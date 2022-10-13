import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-assignments-add',
  templateUrl: './assignments-add.component.html',
  styleUrls: ['./assignments-add.component.css']
})
export class AssignmentsAddComponent implements OnInit {

  data:any;
  enableSave:boolean=false;
  courses:any=[]
  instructors:any=[]
  terms:any=[]
  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllCourses()
    this.getAllTerms() 
    this.getAllInstructors()
    this.enableSave=false 
    this.data =  sessionStorage.getItem('assignment');
    this.data = JSON.parse(this.data);

   if(this.data){
    this.enableSave=true
    this.bindAssigment(this.data);
   }
  }

  getAllTerms(){
    
    let self = this;

    this._sisApp.getAllTerms().subscribe(
      resp => {
        self.terms = resp;
      });
  }

  getAllCourses(){
    
    let self = this;

    this._sisApp.getAllCourses().subscribe(
      resp => {
        self.courses = resp;
      });
  }

  bindAssigment(data:any) {
    this.assignmentForm.patchValue({
      "id": data['id'],
      "courseName": data['courseId'],
      "instructorName": data['instructorId'],
      "termName":  data['termId'],
      "courseId": data['courseId'],
      "instructorId": data['instructorId'],
      "termId": data['termId']
    });
  }

  assignmentForm: FormGroup = new FormGroup({
    'courseId': new FormControl(""),
    'instructorId': new FormControl("",),
    'termId': new FormControl("",),
    'courseName': new FormControl(""),
    'instructorName': new FormControl("",),
    'termName': new FormControl("",),
    'id': new FormControl("",) 
  })

  backtoList(){
    this._Router.navigate(['/assignment'])
  }

  getAllInstructors(){
    
    let self = this;

    this._sisApp.getAllInstructors().subscribe(
      resp => {
        self.instructors = resp;
      });
  }
  

  addAssignment(){
    let self = this;
  
    if (this.assignmentForm.valid) {
      let data = { 
        "courseId": this.assignmentForm.value.courseName,
        "instructorId": this.assignmentForm.value.instructorName,
        "termId": this.assignmentForm.value.termName,
        "id": this.assignmentForm.value.id
      }
      if(!this.data){
      self._sisApp.createAssignment(data).subscribe(
        resp => {
          alert('Assigment Created Successfully');
          if (resp == "Success") {
            self._Router.navigate(['/assignment']);
          } else
            alert('Failed to Create');
        }
      );  
      }else{
        self._sisApp.updateAssignment(data).subscribe(
          resp => {
            alert('Assignment Updated Successfully');
            if (resp == "Success") {
              self._Router.navigate(['/assignment']);
            } else
              alert('Failed to Update');
          }
        );  
      }
    }
  }

  ngOnDestroy(){
    sessionStorage.removeItem('assignment');
  }
}
