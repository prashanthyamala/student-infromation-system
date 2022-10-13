import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SisappService {

  constructor(private _Http: HttpClient) { }

  getAllStudents(): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/get/blogs', {});

  }

  createStudent(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/blog/save', data);

  }

  deleteStudent(id: any): Observable<any> {

    return this._Http.post(`http://192.168.1.3:8081/codingdeeps/delete/blogs/id?id=${id}`, {});

  }

  updateStudent(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/blog/update', data);

  }

  getAllInstructors(): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/get/instructors', {});

  }

  deleteInstructor(id: any): Observable<any> {

    return this._Http.post(`http://192.168.1.3:8081/codingdeeps/delete/instructor/id?id=${id}`, {});

  }

  createInstructor(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/instructor/save', data);

  }

  updateInstructor(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/instructor/update', data);

  }

  createDepartment(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/department/save', data);

  }

  updateDepartment(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/department/update', data);

  }

  getAllDepartments(): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/get/departments', {});

  }

  deleteDepartment(id: any): Observable<any> {

    return this._Http.post(`http://192.168.1.3:8081/codingdeeps/delete/department/id?id=${id}`, {});

  }

  
  getAllCourses(): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/get/courses', {});

  }

  deleteCourse(id: any): Observable<any> {

    return this._Http.post(`http://192.168.1.3:8081/codingdeeps/delete/course/id?id=${id}`, {});

  }

  createCourse(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/course/save', data);

  }

  updateCourse(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/course/update', data);

  }

  getAllTerms(): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/get/terms', {});

  }

  deleteTerm(id: any): Observable<any> {

    return this._Http.post(`http://192.168.1.3:8081/codingdeeps/delete/term/id?id=${id}`, {});

  }

  createTerm(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/terms/save', data);

  }

  updateTerm(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/terms/update', data);

  }

  createAssignment(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/assignment/save', data);

  }

  updateAssignment(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/assignment/update', data);

  }

  createRegistration(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/registration/save', data);

  }

  updateRegistration(data: any): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/registration/update', data);

  }

  getAllRegistrations(): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/get/registrations', {});

  }

  deleteRegistration(id: any): Observable<any> {

    return this._Http.post(`http://192.168.1.3:8081/codingdeeps/delete/registration/id?id=${id}`, {});

  }

  getAllAssignments(): Observable<any> {

    return this._Http.post('http://192.168.1.3:8081/codingdeeps/get/assignments', {});

  }

  deleteAssignment(id: any): Observable<any> {

    return this._Http.post(`http://192.168.1.3:8081/codingdeeps/delete/assignment/id?id=${id}`, {});

  }
}
