import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-registrations',
  templateUrl: './registrations.component.html',
  styleUrls: ['./registrations.component.css']
})
export class RegistrationsComponent implements OnInit {

  registrationList:any= []

  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllRegistrations()
  }
 
  getAllRegistrations(){
    
    let self = this;

    this._sisApp.getAllRegistrations().subscribe(
      resp => {
        self.registrationList = resp;
      });
  }
    
  createRegistration(){
    this._Router.navigate(['/registration-add'])
  }

  editRegistration(li:any){
    let sessionData = {
      "id": li['id'],
      "courseName": li['courseName'],
      "studentName": li['studentName'],
      "termName": li['termName'],
      "courseId": li['courseId'],
      "studentId": li['studentId'],
      "termId": li['termId']
    } 
    sessionStorage.setItem('registration', JSON.stringify(sessionData));
    this._Router.navigate(['/registration-add'])
  }

  deleteRegistration(li:any){
    let self = this;
         
      self._sisApp.deleteRegistration(li.id).subscribe(
        resp => {
          if (resp == "Success") {
            alert('Registration Deleted Successfully');
            window.location.reload()
          } else
            alert('Failed to Delete');
        }
      );      
  }
}
