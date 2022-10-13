import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-instructor',
  templateUrl: './instructor.component.html',
  styleUrls: ['./instructor.component.css']
})
export class InstructorComponent implements OnInit {

  instructorsList:any= []

  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllInstructors()
  }
 
  getAllInstructors(){
    
    let self = this;

    this._sisApp.getAllInstructors().subscribe(
      resp => {
        self.instructorsList = resp;
      });
  }
    
  createInstructor(){
    this._Router.navigate(['/instructor-add'])
  }

  editInstructor(li:any){
    let sessionData = {
      "instructorHireDate": li['instructorDate'],
      "id": li['id'],
      "instructorNumber": li['instructorNumber'],
      "instructorFirstName": li['instructorFirstName'],
      "instructorLastName": li['instructorLastName']
    } 
    sessionStorage.setItem('instructor', JSON.stringify(sessionData));
    this._Router.navigate(['/instructor-add'])
  }

  deleteInstructor(li:any){
    let self = this;
         
      self._sisApp.deleteInstructor(li.id).subscribe(
        resp => {
          if (resp == "Success") {
            alert('Instructor Deleted Successfully');
            window.location.reload()
          } else
            alert('Failed to Delete');
        }
      );      
  }
}
