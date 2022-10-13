package com.blog.codingdeeps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.codingdeeps.bean.Assignment;
import com.blog.codingdeeps.bean.Instructor;
import com.blog.codingdeeps.bean.Registration;
import com.blog.codingdeeps.bean.SaveBlog;
import com.blog.codingdeeps.bean.course;
import com.blog.codingdeeps.bean.department;
import com.blog.codingdeeps.bean.terms;
import com.blog.codingdeeps.services.BlogServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BlogController {

	@Autowired
	private BlogServices service;

	@Autowired
	ObjectMapper mapper;

	/**
	 * @param invoice
	 * @return
	 * @throws JsonProcessingException
	 */
	@CrossOrigin
	@RequestMapping(value = "blog/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveBlog(@RequestBody SaveBlog blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.saveBlog(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "blog/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateBlog(@RequestBody SaveBlog blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.updateBlog(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "get/blogs", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getBlogs()
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.getAllBlogs()),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@CrossOrigin
	@RequestMapping(value = "get/blogs/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getBlogById(@RequestParam String id)
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.getBlogById(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "delete/blogs/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> deleteBlogbyId(@RequestParam String id)
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.deleteBlogById(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "instructor/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveInstructor(@RequestBody Instructor blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.saveInstructor(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "instructor/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateInstructor(@RequestBody Instructor blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.updateInstructor(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "get/instructors", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getInstructors()
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.getAllInstructors()),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@CrossOrigin
	@RequestMapping(value = "delete/instructor/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> deleteInstructorbyId(@RequestParam String id)
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.deleteInstructorById(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "department/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveDepartment(@RequestBody department blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.saveDepartment(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "department/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateDepartment(@RequestBody department blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.updateDepartment(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "get/departments", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getDepartments()
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.getAllDepartments()),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@CrossOrigin
	@RequestMapping(value = "delete/department/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> deleteDepartmentbyId(@RequestParam String id)
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.deleteDepartmentById(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "course/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveCourse(@RequestBody course blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.saveCourse(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "course/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateCourse(@RequestBody course blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.updateCourse(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "get/courses", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getCourses()
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.getAllCourses()),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@CrossOrigin
	@RequestMapping(value = "delete/course/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> deleteCoursebyId(@RequestParam String id)
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.deleteCourseById(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "terms/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveTerm(@RequestBody terms blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.saveTerm(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "terms/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateTerm(@RequestBody terms blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.updateTerm(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "get/terms", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getTerms()
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.getAllTerms()),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@CrossOrigin
	@RequestMapping(value = "delete/term/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> deleteTermbyId(@RequestParam String id)
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.deleteTermById(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "assignment/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveAssignment(@RequestBody Assignment blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.saveAssignment(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "assignment/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateAssignment(@RequestBody Assignment blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.updateAssignment(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "get/assignments", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getAssignments()
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.getAllAssignments()),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@CrossOrigin
	@RequestMapping(value = "delete/assignment/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> deleteAssignmentbyId(@RequestParam String id)
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.deleteAssignmentById(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "registration/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveRegistration(@RequestBody Registration blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.saveRegistration(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "registration/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateRegistration(@RequestBody Registration blog) throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.updateRegistrations(blog)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "get/registrations", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getRegistrations()
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.getAllRegistrations()),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@CrossOrigin
	@RequestMapping(value = "delete/registration/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> deleteRegistrationbyId(@RequestParam String id)
			throws JsonProcessingException {
		try {
			return new ResponseEntity<String>(mapper.writeValueAsString(service.deleteRegistrationById(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
