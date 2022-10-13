import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css']
})
export class DepartmentsComponent implements OnInit {

  departmentsList:any= []

  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllDepartments()
  }
 
  getAllDepartments(){
    
    let self = this;

    this._sisApp.getAllDepartments().subscribe(
      resp => {
        self.departmentsList = resp;
      });
  }
    
  createDepartment(){
    this._Router.navigate(['/department-add'])
  }

  editDepartment(li:any){
    let sessionData = {
      "id": li['id'],
      "departmentName": li['deptName'],
    } 
    sessionStorage.setItem('department', JSON.stringify(sessionData));
    this._Router.navigate(['/department-add'])
  }

  deleteDepartment(li:any){
    let self = this;
         
      self._sisApp.deleteDepartment(li.id).subscribe(
        resp => {
          if (resp == "Success") {
            alert('Department Deleted Successfully');
            window.location.reload()
          } else
            alert('Failed to Delete');
        }
      );      
  }
}

