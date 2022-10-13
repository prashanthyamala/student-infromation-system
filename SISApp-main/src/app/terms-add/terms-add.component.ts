import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-terms-add',
  templateUrl: './terms-add.component.html',
  styleUrls: ['./terms-add.component.css']
})
export class TermsAddComponent implements OnInit {

  data:any;
  enableSave:boolean=false;
  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.enableSave=false 
    this.data =  sessionStorage.getItem('term');
    this.data = JSON.parse(this.data);

   if(this.data){
    this.enableSave=true
    this.bindTerm(this.data);
   }
  }

  bindTerm(data:any) {
    this.termForm.patchValue({
      "id": data['id'],
      "termName": data['termName'],
      "termStartDate": data['termStartDate'],
      "termEndDate":data['termEndDate'],
      "termYear": data['termYear'],
      "termSeason": data['termSeason'],
    });
  }

  termForm: FormGroup = new FormGroup({
    'id': new FormControl(""),
    'termName': new FormControl("",),
    'termStartDate': new FormControl("",),
    'termEndDate': new FormControl("",),
    'termYear': new FormControl("",),
    'termSeason': new FormControl("",),
  })

  backtoList(){
    this._Router.navigate(['/term'])
  }

  addTerm(){
    let self = this;
  
    if (this.termForm.valid) {
      let data = { 
        "id": this.termForm.value.id,
        "termName": this.termForm.value.termName,
        "termStartDate": this.termForm.value.termStartDate,
        "termEndDate": this.termForm.value.termEndDate,
        "termYear": this.termForm.value.termYear,
        "termSeason": this.termForm.value.termSeason,
      }
      if(!this.data){
      self._sisApp.createTerm(data).subscribe(
        resp => {
          alert('Terms Created Successfully');
          if (resp == "Success") {
            self._Router.navigate(['/terms']);
          } else
            alert('Failed to Create');
        }
      );  
      }else{
        self._sisApp.updateTerm(data).subscribe(
          resp => {
            alert('Term Updated Successfully');
            if (resp == "Success") {
              self._Router.navigate(['/terms']);
            } else
              alert('Failed to Update');
          }
        );  
      }
    }
  }

  ngOnDestroy(){
    sessionStorage.removeItem('term');
  }
}

