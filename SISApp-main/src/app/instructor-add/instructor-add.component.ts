import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-instructor-add',
  templateUrl: './instructor-add.component.html',
  styleUrls: ['./instructor-add.component.css']
})
export class InstructorAddComponent implements OnInit {

  data:any;
  enableSave:boolean=false;
  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.enableSave=false 
    this.data =  sessionStorage.getItem('instructor');
    this.data = JSON.parse(this.data);

   if(this.data){
    this.enableSave=true
    this.bindInstructor(this.data);
   }
  }

  bindInstructor(data:any) {
    this.instructorForm.patchValue({
      "id": data['id'],
      "instructorFirstName": data['instructorFirstName'],
      "instructorHireDate":data['instructorHireDate'],
      "instructorLastName": data['instructorLastName'],
      "instructorNumber": data['instructorNumber']
    });
  }

  instructorForm: FormGroup = new FormGroup({
    'id': new FormControl(""),
    'instructorFirstName': new FormControl("",),
    'instructorLastName': new FormControl("",),
    'instructorHireDate': new FormControl("",),
    'instructorNumber': new FormControl("",),
    
  })

  backtoList(){
    this._Router.navigate(['/instructors'])
  }

  addInstructor(){
    let self = this;
  
    if (this.instructorForm.valid) {
      let data = { 
        "id": this.instructorForm.value.id,
        "instructorFirstName": this.instructorForm.value.instructorFirstName,
        "instructorLastName": this.instructorForm.value.instructorLastName,
        "instructorDate": this.instructorForm.value.instructorHireDate,
        "instructorNumber": this.instructorForm.value.instructorNumber
      }
      if(!this.data){
      self._sisApp.createInstructor(data).subscribe(
        resp => {
          alert('Instructor Created Successfully');
          if (resp == "Success") {
            self._Router.navigate(['/instructors']);
          } else
            alert('Failed to Create');
        }
      );  
      }else{
        self._sisApp.updateInstructor(data).subscribe(
          resp => {
            alert('Instructor Updated Successfully');
            if (resp == "Success") {
              self._Router.navigate(['/instructors']);
            } else
              alert('Failed to Update');
          }
        );  
      }
    }
  }

  ngOnDestroy(){
    sessionStorage.removeItem('instructor');
  }
}

