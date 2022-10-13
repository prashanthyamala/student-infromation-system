import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-assignments',
  templateUrl: './assignments.component.html',
  styleUrls: ['./assignments.component.css']
})
export class AssignmentsComponent implements OnInit {

  assignmentList:any= []

  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllAssignments()
  }
 
  getAllAssignments(){
    
    let self = this;

    this._sisApp.getAllAssignments().subscribe(
      resp => {
        self.assignmentList = resp;
      });
  }
    
  createAssignment(){
    this._Router.navigate(['/assignment-add'])
  }

  editAssignment(li:any){
    let sessionData = {
      "id": li['id'],
      "courseName": li['courseName'],
      "instructorName": li['instructorName'],
      "termName": li['termName'],
      "courseId": li['courseId'],
      "instructorId": li['instructorId'],
      "termId": li['termId']
    } 
    sessionStorage.setItem('assignment', JSON.stringify(sessionData));
    this._Router.navigate(['/assignment-add'])
  }

  deleteAssignment(li:any){
    let self = this;
         
      self._sisApp.deleteAssignment(li.id).subscribe(
        resp => {
          if (resp == "Success") {
            alert('Assignment Deleted Successfully');
            window.location.reload()
          } else
            alert('Failed to Delete');
        }
      );      
  }
}
