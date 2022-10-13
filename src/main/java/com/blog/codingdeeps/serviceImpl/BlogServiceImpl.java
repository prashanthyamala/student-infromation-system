package com.blog.codingdeeps.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.codingdeeps.bean.Assignment;
import com.blog.codingdeeps.bean.Instructor;
import com.blog.codingdeeps.bean.Registration;
import com.blog.codingdeeps.bean.SaveBlog;
import com.blog.codingdeeps.bean.course;
import com.blog.codingdeeps.bean.department;
import com.blog.codingdeeps.bean.terms;
import com.blog.codingdeeps.dao.BlogDao;
import com.blog.codingdeeps.services.BlogServices;

@Service
public class BlogServiceImpl implements BlogServices {

	@Autowired
	private BlogDao dao;

	@Override
	public String saveBlog(SaveBlog blog) {
		// TODO Auto-generated method stub
		try {
			return dao.saveBlog(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String updateBlog(SaveBlog blog) {
		// TODO Auto-generated method stub
		try {
			return dao.updateBlog(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<SaveBlog> getAllBlogs() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllBlogs();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<SaveBlog> getBlogById(String id) {
		// TODO Auto-generated method stub
		try {
			return dao.getBlogById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String deleteBlogById(String id) {
		// TODO Auto-generated method stub
		try {
			return dao.deleteBlogById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String saveInstructor(Instructor blog) {
		// TODO Auto-generated method stub
		try {
			return dao.saveInstructor(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String updateInstructor(Instructor blog) {
		// TODO Auto-generated method stub
		try {
			return dao.updateInstructor(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Instructor> getAllInstructors() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllInstructors();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String deleteInstructorById(String id) {
		// TODO Auto-generated method stub
		try {
			return dao.deleteInstructorById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String saveDepartment(department blog) {
		// TODO Auto-generated method stub
		try {
			return dao.saveDepartment(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String updateDepartment(department blog) {
		// TODO Auto-generated method stub
		try {
			return dao.updateDepartment(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<department> getAllDepartments() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllDepartments();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String deleteDepartmentById(String id) {
		// TODO Auto-generated method stub
		try {
			return dao.deleteDepartmentById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String saveCourse(course blog) {
		// TODO Auto-generated method stub
		try {
			return dao.saveCourse(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String updateCourse(course blog) {
		// TODO Auto-generated method stub
		try {
			return dao.updateCourse(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<course> getAllCourses() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllCourses();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public String deleteCourseById(String id) {
		// TODO Auto-generated method stub
		try {
			return dao.deleteCourseById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String saveTerm(terms blog) {
		// TODO Auto-generated method stub
		try {
			return dao.saveTerm(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String updateTerm(terms blog) {
		// TODO Auto-generated method stub
		try {
			return dao.updateTerm(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public List<terms> getAllTerms() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllTerms();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public String deleteTermById(String id) {
		// TODO Auto-generated method stub
		try {
			return dao.deleteTermById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
    @Override
	public String saveAssignment(Assignment blog) {
		// TODO Auto-generated method stub
		try {
			return dao.saveAssignment(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String updateAssignment(Assignment blog) {
		// TODO Auto-generated method stub
		try {
			return dao.updateAssignment(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public List<Assignment> getAllAssignments() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllAssignments();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public String deleteAssignmentById(String id) {
		// TODO Auto-generated method stub
		try {
			return dao.deleteAssignmentById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String saveRegistration(Registration blog) {
		// TODO Auto-generated method stub
		try {
			return dao.saveRegistration(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String updateRegistrations(Registration blog) {
		// TODO Auto-generated method stub
		try {
			return dao.updateRegistration(blog);

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public List<Registration> getAllRegistrations() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllRegistrations();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public String deleteRegistrationById(String id) {
		// TODO Auto-generated method stub
		try {
			return dao.deleteRegistrationById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
