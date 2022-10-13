import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-department-add',
  templateUrl: './department-add.component.html',
  styleUrls: ['./department-add.component.css']
})
export class DepartmentAddComponent implements OnInit {

  data:any;
  enableSave:boolean=false;
  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.enableSave=false 
    this.data =  sessionStorage.getItem('department');
    this.data = JSON.parse(this.data);

   if(this.data){
    this.enableSave=true
    this.bindDepartment(this.data);
   }
  }

  bindDepartment(data:any) {
    this.departmentForm.patchValue({
      "id": data['id'],
      "departmentName": data['departmentName'],
     
    });
  }

  departmentForm: FormGroup = new FormGroup({
    'id': new FormControl(""),
    'departmentName': new FormControl("",)
    
  })

  backtoList(){
    this._Router.navigate(['/departments'])
  }

  addDepartment(){
    let self = this;
  
    if (this.departmentForm.valid) {
      let data = { 
        "id": this.departmentForm.value.id,
        "deptName": this.departmentForm.value.departmentName
      }
      if(!this.data){
      self._sisApp.createDepartment(data).subscribe(
        resp => {
          alert('Department Created Successfully');
          if (resp == "Success") {
            self._Router.navigate(['/departments']);
          } else
            alert('Failed to Create');
        }
      );  
      }else{
        self._sisApp.updateDepartment(data).subscribe(
          resp => {
            alert('Department Updated Successfully');
            if (resp == "Success") {
              self._Router.navigate(['/departments']);
            } else
              alert('Failed to Update');
          }
        );  
      }
    }
  }

  ngOnDestroy(){
    sessionStorage.removeItem('department');
  }
}


