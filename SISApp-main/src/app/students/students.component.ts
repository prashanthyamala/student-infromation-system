import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  studentsList:any= []

  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllStudents()
  }
 
  getAllStudents(){
    
    let self = this;

    this._sisApp.getAllStudents().subscribe(
      resp => {
        self.studentsList = resp;
      });
  }
    
  createStudent(){
    this._Router.navigate(['/student-add'])
  }

  editStudent(li:any){
    let sessionData = {
      "address": li['address'],
      "enrollmentDate": li['enrollmentDate'],
      "id": li['id'],
      "number": li['number'],
      "studentFirstName": li['studentFirstName'],
      "studentLastName": li['studentLastName']
    } 
    sessionStorage.setItem('student', JSON.stringify(sessionData));
    this._Router.navigate(['/student-add'])
  }

  deleteStudent(li:any){
    let self = this;
         
      self._sisApp.deleteStudent(li.id).subscribe(
        resp => {
          if (resp == "Success") {
            alert('Student Deleted Successfully');
            window.location.reload()
          } else
            alert('Failed to Delete');
        }
      );      
  }
}
