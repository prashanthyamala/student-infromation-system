import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  coursesList:any= []

  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllCourses()
  }
 
  getAllCourses(){
    
    let self = this;

    this._sisApp.getAllCourses().subscribe(
      resp => {
        self.coursesList = resp;
      });
  }
    
  createCourse(){
    this._Router.navigate(['/course-add'])
  }

  editCourse(li:any){
    let sessionData = {
      "id": li['id'],
      "courseName": li['courseName'],
      "deptName": li['deptName'],
    } 
    sessionStorage.setItem('course', JSON.stringify(sessionData));
    this._Router.navigate(['/course-add'])
  }

  deleteCourse(li:any){
    let self = this;
         
      self._sisApp.deleteCourse(li.id).subscribe(
        resp => {
          if (resp == "Success") {
            alert('Course Deleted Successfully');
            window.location.reload()
          } else
            alert('Failed to Delete');
        }
      );      
  }
}

