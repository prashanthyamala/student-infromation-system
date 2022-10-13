import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SisappService } from './sisapp.service';
import { StudentsComponent } from './students/students.component';
import { StudentAddComponent } from './student-add/student-add.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { InstructorComponent } from './instructor/instructor.component';
import { DepartmentsComponent } from './departments/departments.component';
import { CoursesComponent } from './courses/courses.component';
import { InstructorAddComponent } from './instructor-add/instructor-add.component';
import { DepartmentAddComponent } from './department-add/department-add.component';
import { CourseAddComponent } from './course-add/course-add.component';
import { AssignmentsComponent } from './assignments/assignments.component';
import { AssignmentsAddComponent } from './assignments-add/assignments-add.component';
import { RegistrationsComponent } from './registrations/registrations.component';
import { RegistrationsAddComponent } from './registrations-add/registrations-add.component';
import { TermsComponent } from './terms/terms.component';
import { TermsAddComponent } from './terms-add/terms-add.component';

const routes: Routes =[

  {
    path: 'home', component: HomeComponent, 
  },
  {
    path: 'student', component: StudentsComponent, 
  },
  {
    path: 'student-add', component: StudentAddComponent, 
  },
  {
    path: 'about', component: AboutComponent, 
  },
  {
    path: 'contact', component: ContactComponent, 
  },
  {
    path: 'instructors', component: InstructorComponent, 
  },
  {
    path: 'departments', component: DepartmentsComponent, 
  },
  {
    path: 'courses', component: CoursesComponent, 
  },
  {
    path: 'instructor-add', component: InstructorAddComponent, 
  },
  {
    path: 'department-add', component: DepartmentAddComponent, 
  },
  {
    path: 'course-add', component: CourseAddComponent, 
  },
  {
    path: 'terms', component: TermsComponent, 
  },
  {
    path: 'term-add', component: TermsAddComponent, 
  },
  {
    path: 'assignment', component: AssignmentsComponent, 
  },
  {
    path: 'assignment-add', component: AssignmentsAddComponent, 
  },
  {
    path: 'registration', component: RegistrationsComponent, 
  },
  {
    path: 'registration-add', component: RegistrationsAddComponent, 
  },
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StudentsComponent,
    StudentAddComponent,
    AboutComponent,
    ContactComponent,
    InstructorComponent,
    DepartmentsComponent,
    CoursesComponent,
    InstructorAddComponent,
    DepartmentAddComponent,
    CourseAddComponent,
    AssignmentsComponent,
    AssignmentsAddComponent,
    RegistrationsComponent,
    RegistrationsAddComponent,
    TermsComponent,
    TermsAddComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
  ],
  providers: [SisappService,HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
