package com.blog.codingdeeps.services;

import java.util.List;

import com.blog.codingdeeps.bean.Assignment;
import com.blog.codingdeeps.bean.Instructor;
import com.blog.codingdeeps.bean.Registration;
import com.blog.codingdeeps.bean.SaveBlog;
import com.blog.codingdeeps.bean.course;
import com.blog.codingdeeps.bean.department;
import com.blog.codingdeeps.bean.terms;

public interface BlogServices {

	public String saveBlog(SaveBlog blog);
	
	List<SaveBlog> getAllBlogs();

	public List<SaveBlog> getBlogById(String id);

	public String updateBlog(SaveBlog blog);

	String deleteBlogById(String id);

	String deleteInstructorById(String id);

	List<Instructor> getAllInstructors();

	String saveInstructor(Instructor blog);

	String updateInstructor(Instructor blog);

	String deleteDepartmentById(String id);

	List<department> getAllDepartments();

	String updateDepartment(department blog);

	String saveDepartment(department blog);

	String deleteCourseById(String id);

	List<course> getAllCourses();

	String saveCourse(course blog);

	String updateCourse(course blog);

	String deleteTermById(String id);

	List<terms> getAllTerms();

	String updateTerm(terms blog);

	String saveTerm(terms blog);

	String deleteAssignmentById(String id);

	List<Assignment> getAllAssignments();

	String updateAssignment(Assignment blog);

	String saveAssignment(Assignment blog);

	String deleteRegistrationById(String id);

	List<Registration> getAllRegistrations();

	String updateRegistrations(Registration blog);

	String saveRegistration(Registration blog);

}
