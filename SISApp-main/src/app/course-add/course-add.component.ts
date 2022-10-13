import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-course-add',
  templateUrl: './course-add.component.html',
  styleUrls: ['./course-add.component.css']
})
export class CourseAddComponent implements OnInit {

  
  data:any;
  enableSave:boolean=false;
  departments:any=[]
  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllDepartments()
    this.enableSave=false 
    this.data =  sessionStorage.getItem('course');
    this.data = JSON.parse(this.data);

   if(this.data){
    this.enableSave=true
    this.bindCourse(this.data);
   }
  }

  bindCourse(data:any) {
    this.courseForm.patchValue({
      "id": data['id'],
      "courseName": data['courseName'],
      "departmentName": data['deptName'],
     
    });
  }

  courseForm: FormGroup = new FormGroup({
    'id': new FormControl(""),
    'courseName': new FormControl("",),
    'departmentName': new FormControl("",)
    
  })

  backtoList(){
    this._Router.navigate(['/courses'])
  }

  getAllDepartments(){
    
    let self = this;

    this._sisApp.getAllDepartments().subscribe(
      resp => {
        self.departments = resp;
      });
  }
  

  addCourse(){
    let self = this;
  
    if (this.courseForm.valid) {
      let data = { 
        "id": this.courseForm.value.id,
        "courseName": this.courseForm.value.courseName,
        "deptName": this.courseForm.value.departmentName
      }
      if(!this.data){
      self._sisApp.createCourse(data).subscribe(
        resp => {
          alert('Course Created Successfully');
          if (resp == "Success") {
            self._Router.navigate(['/courses']);
          } else
            alert('Failed to Create');
        }
      );  
      }else{
        self._sisApp.updateCourse(data).subscribe(
          resp => {
            alert('Course Updated Successfully');
            if (resp == "Success") {
              self._Router.navigate(['/courses']);
            } else
              alert('Failed to Update');
          }
        );  
      }
    }
  }

  ngOnDestroy(){
    sessionStorage.removeItem('course');
  }
}



