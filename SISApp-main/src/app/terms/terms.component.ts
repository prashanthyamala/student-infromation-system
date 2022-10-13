import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SisappService } from '../sisapp.service';

@Component({
  selector: 'app-terms',
  templateUrl: './terms.component.html',
  styleUrls: ['./terms.component.css']
})
export class TermsComponent implements OnInit {

  termsList:any= []

  constructor(
    private _Router: Router,
    private _sisApp: SisappService
  ) { }

  ngOnInit(): void {
    this.getAllTerms()
  }
 
  getAllTerms(){
    
    let self = this;

    this._sisApp.getAllTerms().subscribe(
      resp => {
        self.termsList = resp;
      });
  }
    
  createTerm(){
    this._Router.navigate(['/term-add'])
  }

  editTerm(li:any){
    let sessionData = {
      
      "termStartDate": li['termStartDate'],
      "id": li['id'],
      "termName": li['termName'],
      "termEndDate": li['termEndDate'],
      "termYear": li['termYear'],
      "termSeason": li['termSeason']
    } 
    sessionStorage.setItem('term', JSON.stringify(sessionData));
    this._Router.navigate(['/term-add'])
  }

  deleteTerm(li:any){
    let self = this;
         
      self._sisApp.deleteTerm(li.id).subscribe(
        resp => {
          if (resp == "Success") {
            alert('Terms Deleted Successfully');
            window.location.reload()
          } else
            alert('Failed to Delete');
        }
      );      
  }
}
