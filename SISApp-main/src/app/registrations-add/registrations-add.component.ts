import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-registrations-add',
  templateUrl: './registrations-add.component.html',
  styleUrls: ['./registrations-add.component.css']
})
export class RegistrationsAddComponent implements OnInit {

  data:any;
  enableSave:boolean=false;
  courses:any=[]
  students:any=[]
  terms:any=[]
  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllCourses()
    this.getAllTerms() 
    this.getAllStudents()
    this.enableSave=false 
    this.data =  sessionStorage.getItem('registration');
    this.data = JSON.parse(this.data);

   if(this.data){
    this.enableSave=true
    this.bindRegistration(this.data);
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

  bindRegistration(data:any) {
    this.registrationForm.patchValue({
      "id": data['id'],
      "courseName": data['courseId'],
      "studentName": data['studentId'],
      "termName":  data['termId'],
      "courseId": data['courseId'],
      "studentId": data['studentId'],
      "termId": data['termId']
    });
  }

  registrationForm: FormGroup = new FormGroup({
    'courseId': new FormControl(""),
    'studentId': new FormControl("",),
    'termId': new FormControl("",),
    'courseName': new FormControl(""),
    'studentName': new FormControl("",),
    'termName': new FormControl("",),
    'id': new FormControl("",) 
  })

  backtoList(){
    this._Router.navigate(['/registration'])
  }

  getAllStudents(){
    
    let self = this;

    this._sisApp.getAllStudents().subscribe(
      resp => {
        self.students = resp;
      });
  }
  

  addRegistration(){
    let self = this;
  
    if (this.registrationForm.valid) {
      let data = { 
        "courseId": this.registrationForm.value.courseName,
        "studentId": this.registrationForm.value.studentName,
        "termId": this.registrationForm.value.termName,
        "id": this.registrationForm.value.id
      }
      if(!this.data){
      self._sisApp.createRegistration(data).subscribe(
        resp => {
          alert('Registration Created Successfully');
          if (resp == "Success") {
            self._Router.navigate(['/registration']);
          } else
            alert('Failed to Create');
        }
      );  
      }else{
        self._sisApp.updateRegistration(data).subscribe(
          resp => {
            alert('Registration Updated Successfully');
            if (resp == "Success") {
              self._Router.navigate(['/registration']);
            } else
              alert('Failed to Update');
          }
        );  
      }
    }
  }

  ngOnDestroy(){
    sessionStorage.removeItem('registration');
  }
}
