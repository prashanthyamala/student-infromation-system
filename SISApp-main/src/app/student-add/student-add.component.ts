import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-student-add',
  templateUrl: './student-add.component.html',
  styleUrls: ['./student-add.component.css']
})
export class StudentAddComponent implements OnInit {
  data:any;
  enableSave:boolean=false;
  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.enableSave=false 
    this.data =  sessionStorage.getItem('student');
    this.data = JSON.parse(this.data);

   if(this.data){
    this.enableSave=true
    this.bindStudent(this.data);
   }
  }

  bindStudent(data:any) {
    this.studentForm.patchValue({
      "studentId": data['id'],
      "studentFirstName": data['studentFirstName'],
      "studentAddress":data['address'],
      "studentLastName": data['studentLastName'],
      "studentContactNumber": data['number'],
      "studentEnrollmentDate":data['enrollmentDate']
    });
  }

  studentForm: FormGroup = new FormGroup({
    'studentId': new FormControl(""),
    'studentFirstName': new FormControl("",),
    'studentLastName': new FormControl("",),
    'studentEnrollmentDate': new FormControl("",),
    'studentContactNumber': new FormControl("",),
    'studentAddress': new FormControl("",),
  })

  backtoList(){
    this._Router.navigate(['/student'])
  }

  addStudent(){
    let self = this;
  
    if (this.studentForm.valid) {
      let data = { 
        "id": this.studentForm.value.studentId,
        "studentFirstName": this.studentForm.value.studentFirstName,
        "studentLastName": this.studentForm.value.studentLastName,
        "enrollmentDate": this.studentForm.value.studentEnrollmentDate,
        "number": this.studentForm.value.studentContactNumber,
        "address":  this.studentForm.value.studentAddress
      }
      if(!this.data){
      self._sisApp.createStudent(data).subscribe(
        resp => {
          alert('Student Created Successfully');
          if (resp == "Success") {
            self._Router.navigate(['/student']);
          } else
            alert('Failed to Create');
        }
      );  
      }else{
        self._sisApp.updateStudent(data).subscribe(
          resp => {
            alert('Student Updated Successfully');
            if (resp == "Success") {
              self._Router.navigate(['/student']);
            } else
              alert('Failed to Update');
          }
        );  
      }
    }
  }

  ngOnDestroy(){
    sessionStorage.removeItem('student');
  }
}
