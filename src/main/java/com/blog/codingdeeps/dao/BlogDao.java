package com.blog.codingdeeps.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blog.codingdeeps.bean.Assignment;
import com.blog.codingdeeps.bean.Instructor;
import com.blog.codingdeeps.bean.Registration;
import com.blog.codingdeeps.bean.SaveBlog;
import com.blog.codingdeeps.bean.course;
import com.blog.codingdeeps.bean.department;
import com.blog.codingdeeps.bean.terms;

public interface BlogDao {

	public String saveBlog(SaveBlog blog);

	public List<SaveBlog> getAllBlogs();

	public List<SaveBlog> getBlogById(String id);

	String updateBlog(SaveBlog blog);

	String deleteBlogById(String id);

	String saveInstructor(Instructor blog);

	List<Instructor> getAllInstructors();

	String updateInstructor(Instructor blog);

	String deleteInstructorById(String id);

	String deleteDepartmentById(String id);

	List<department> getAllDepartments();

	String saveDepartment(department blog);

	String updateDepartment(department blog);

	String deleteCourseById(String id);

	String updateCourse(course blog);

	List<course> getAllCourses();

	String saveCourse(course blog);

	String deleteTermById(String id);

	String updateTerm(terms blog);

	List<terms> getAllTerms();

	String saveTerm(terms blog);

	String deleteAssignmentById(String id);

	String updateAssignment(Assignment blog);

	List<Assignment> getAllAssignments();

	String saveAssignment(Assignment blog);

	String deleteRegistrationById(String id);

	String updateRegistration(Registration blog);

	List<Registration> getAllRegistrations();

	String saveRegistration(Registration blog);

}
