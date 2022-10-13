package com.blog.codingdeeps.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.blog.codingdeeps.bean.Assignment;
import com.blog.codingdeeps.bean.Instructor;
import com.blog.codingdeeps.bean.Registration;
import com.blog.codingdeeps.bean.SaveBlog;
import com.blog.codingdeeps.bean.course;
import com.blog.codingdeeps.bean.department;
import com.blog.codingdeeps.bean.terms;
import com.blog.codingdeeps.dao.BlogDao;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String saveBlog(SaveBlog blog) {

		String response = null;
		int status = 0;
		String BLOG = "Insert into csds.student(Student_Id, Student_First_Name, Student_Last_Name, Student_Number, Student_Address,Student_Enrollment_Date) "
				+ "values (?,?,?,?,?,?)";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, blog.getId());
			cs.setString(2, blog.getStudentFirstName());
			cs.setString(3, blog.getStudentLastName());
			cs.setDouble(4, blog.getNumber());
			cs.setString(5, blog.getAddress());
			cs.setString(6, blog.getEnrollmentDate());
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public List<SaveBlog> getAllBlogs() {
		// TODO Auto-generated method stub
		String query = "select * from csds.student";

		List<SaveBlog> list = null;
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			list = new ArrayList<SaveBlog>();

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					SaveBlog report = new SaveBlog();
					report.setId(rs.getString("Student_Id"));
					report.setStudentFirstName(rs.getString("Student_First_Name"));
					report.setStudentLastName(rs.getString("Student_Last_Name"));
					report.setNumber(rs.getDouble("Student_Number"));
					report.setAddress(rs.getString("Student_Address"));
					report.setEnrollmentDate(rs.getString("Student_Enrollment_Date"));
					list.add(report);

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public String updateBlog(SaveBlog blog) {
		
		String response = null;
		int status = 0;
		String BLOG = "Update student SET Student_First_Name=?, Student_Last_Name=?, Student_Number=?, Student_Address=?, Student_Enrollment_Date=? where Student_Id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, blog.getStudentFirstName());
			cs.setString(2, blog.getStudentLastName());
			cs.setDouble(3, blog.getNumber());
			cs.setString(4, blog.getAddress());
			cs.setString(5, blog.getEnrollmentDate());
			cs.setString(6, blog.getId());
			status = cs.executeUpdate();
			
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public List<SaveBlog> getBlogById(String id) {

		String query = "select * from student where Student_Id=?";

		List<SaveBlog> list = null;
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			list = new ArrayList<SaveBlog>();

			ps.setString(1, id);
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					SaveBlog report = new SaveBlog();
					report.setId(rs.getString("Student_Id"));
					report.setStudentFirstName(rs.getString("Student_First_Name"));
					report.setStudentLastName(rs.getString("Student_Last_Name"));
					report.setNumber(rs.getDouble("Student_Number"));
					report.setAddress(rs.getString("Student_Address"));
					report.setEnrollmentDate(rs.getString("Student_Enrollment_Date"));
					list.add(report);

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public String deleteBlogById(String id) {

		String response = null;
		int status = 0;
		String BLOG = "delete from student where Student_Id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, id);
			
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}
	
	@Override
	public String saveInstructor(Instructor blog) {

		String response = null;
		int status = 0;
		String BLOG = "Insert into instructor(id,instructorFirstName, instructorLastName, instructorPhone, instructorHireDate) "
				+ "values (?,?,?,?,?)";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(1, blog.getId());
			cs.setString(2, blog.getInstructorFirstName());       
			cs.setString(3, blog.getInstructorLastName());
			cs.setDouble(4, blog.getInstructorNumber());
			cs.setString(5, blog.getInstructorDate());
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public List<Instructor> getAllInstructors() {
		// TODO Auto-generated method stub
		String query = "select * from instructor";

		List<Instructor> list = null;
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			list = new ArrayList<Instructor>();

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					Instructor report = new Instructor();
					report.setId(rs.getInt("id"));
					report.setInstructorFirstName(rs.getString("instructorFirstName"));
					report.setInstructorLastName(rs.getString("instructorLastName"));
					report.setInstructorNumber(rs.getDouble("instructorPhone"));
					report.setInstructorDate(rs.getString("instructorHireDate"));
					list.add(report);

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public String updateInstructor(Instructor blog) {
		
		String response = null;
		int status = 0;
		String BLOG = "Update instructor SET instructorFirstName=?, instructorLastName=?, instructorPhone=?, instructorHireDate=? where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, blog.getInstructorFirstName());       
			cs.setString(2, blog.getInstructorLastName());
			cs.setDouble(3, blog.getInstructorNumber());
			cs.setString(4, blog.getInstructorDate());
			cs.setInt(5, blog.getId());
			status = cs.executeUpdate();
			

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public String deleteInstructorById(String id) {

		String response = null;
		int status = 0;
		String BLOG = "delete from instructor where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, id);
			
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}
	
	@Override
	public String saveDepartment(department blog) {

		String response = null;
		int status = 0;
		String BLOG = "Insert into department(deptId,deptName) "
				+ "values (?,?)";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(1, blog.getId());
			cs.setString(2, blog.getDeptName());  
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public List<department> getAllDepartments() {
		// TODO Auto-generated method stub
		String query = "select * from department";

		List<department> list = null;
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			list = new ArrayList<department>();

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					department report = new department();
					report.setId(rs.getInt("deptId"));
					report.setDeptName(rs.getString("deptName"));
					list.add(report);

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	
	@Override
	public String updateDepartment(department blog) {
		
		String response = null;
		int status = 0;
		String BLOG = "Update department SET deptName=? where deptId=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(2, blog.getId());
			cs.setString(1, blog.getDeptName()); 
			status = cs.executeUpdate();
			

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public String deleteDepartmentById(String id) {

		String response = null;
		int status = 0;
		String BLOG = "delete from department where deptId=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, id);
			
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}
	
	@Override
	public String saveCourse(course blog) {

		String response = null;
		int status = 0;
		String BLOG = "Insert into course(id,courseName,deptName) "
				+ "values (?,?,?)";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(1, blog.getId());
			cs.setString(2, blog.getCourseName());
			cs.setString(3, blog.getDeptName()); 
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public List<course> getAllCourses() {
		// TODO Auto-generated method stub
		String query = "select * from course";

		List<course> list = null;
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			list = new ArrayList<course>();

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					course report = new course();
					report.setId(rs.getInt("id"));
					report.setCourseName(rs.getString("courseName"));
					report.setDeptName(rs.getString("deptName"));
					list.add(report);

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	
	@Override
	public String updateCourse(course blog) {
		
		String response = null;
		int status = 0;
		String BLOG = "Update course SET courseName=?, deptName=? where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(3, blog.getId());
			cs.setString(1, blog.getCourseName());
			cs.setString(2, blog.getDeptName()); 
			status = cs.executeUpdate();
			

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public String deleteCourseById(String id) {

		String response = null;
		int status = 0;
		String BLOG = "delete from course where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, id);
			
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}
	
	@Override
	public String saveTerm(terms blog) {

		String response = null;
		int status = 0;
		String BLOG = "Insert into terms(id,termName,termStartDate,termEndDate,termYear, termSeason) "
				+ "values (?,?,?,?,?,?)";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(1, blog.getId());
			cs.setString(2, blog.getTermName());
			cs.setString(3, blog.getTermStartDate());
			cs.setString(4, blog.getTermEndDate()); 
			cs.setInt(5, blog.getTermYear());
			cs.setString(6, blog.getTermSeason()); 
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public List<terms> getAllTerms() {
		// TODO Auto-generated method stub
		String query = "select * from terms";

		List<terms> list = null;
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			list = new ArrayList<terms>();

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					terms report = new terms();
					report.setId(rs.getInt("id"));
					report.setTermName(rs.getString("termName"));
					report.setTermStartDate(rs.getString("termStartDate"));
					report.setTermEndDate(rs.getString("termEndDate"));
					report.setTermYear(rs.getInt("termYear"));
					report.setTermSeason(rs.getString("termSeason"));
					list.add(report);

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public String updateTerm(terms blog) {
		
		String response = null;
		int status = 0;
		String BLOG = "Update terms SET termName=?, termStartDate=?, termEndDate=?, termYear=?, termSeason=? where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(6, blog.getId());
			cs.setString(1, blog.getTermName());
			cs.setString(2, blog.getTermStartDate());
			cs.setString(3, blog.getTermEndDate()); 
			cs.setInt(4, blog.getTermYear()); 
			cs.setString(5, blog.getTermSeason()); 
			status = cs.executeUpdate();
			

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public String deleteTermById(String id) {

		String response = null;
		int status = 0;
		String BLOG = "delete from terms where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, id);
			
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}
	
	@Override
	public String saveAssignment(Assignment blog) {

		String response = null;
		int status = 0;
		String BLOG = "Insert into assignment(course_id,instructor_id,term_id) "
				+ "values (?,?,?)";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(1, blog.getCourseId());
			cs.setInt(2, blog.getInstructorId());
			cs.setInt(3, blog.getTermId());
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public List<Assignment> getAllAssignments() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM assignment a\r\n"
				+ "JOIN course c ON c.id=a.course_id\r\n"
				+ "JOIN instructor i ON i.id=a.instructor_id\r\n"
				+ "JOIN terms t ON t.id=a.term_id;";

		List<Assignment> list = null;
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			list = new ArrayList<Assignment>();

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					Assignment report = new Assignment();
					report.setId(rs.getInt("id"));
					report.setCourseName(rs.getString("courseName"));
					report.setInstructorName(rs.getString("instructorFirstName"));
					report.setTermName(rs.getString("termName"));
					report.setCourseId(rs.getInt("course_id"));
					report.setInstructorId(rs.getInt("instructor_id"));
					report.setTermId(rs.getInt("term_id"));
					list.add(report);

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public String updateAssignment(Assignment blog) {
		
		String response = null;
		int status = 0;
		String BLOG = "Update assignment SET course_id=?, instructor_id=?, term_id=? where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(4, blog.getId());
			cs.setInt(1, blog.getCourseId());
			cs.setInt(2, blog.getInstructorId());
			cs.setInt(3, blog.getTermId());
			status = cs.executeUpdate();
			

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public String deleteAssignmentById(String id) {

		String response = null;
		int status = 0;
		String BLOG = "delete from assignment where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, id);
			
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}
	
	@Override
	public String saveRegistration(Registration blog) {

		String response = null;
		int status = 0;
		String BLOG = "Insert into registration(course_id,term_id,student_id) "
				+ "values (?,?,?)";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(1, blog.getCourseId());
			cs.setInt(3, blog.getStudentId());
			cs.setInt(2, blog.getTermId());
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public List<Registration> getAllRegistrations() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM registration r\r\n"
				+ "JOIN course c ON c.id=r.course_id\r\n"
				+ "JOIN terms t ON t.id=r.term_id\r\n"
				+ "JOIN student s ON s.Student_Id=r.student_id;";

		List<Registration> list = null;
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			list = new ArrayList<Registration>();

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					Registration report = new Registration();
					report.setId(rs.getInt("id"));
					report.setCourseName(rs.getString("courseName"));
					report.setStudentName(rs.getString("Student_First_Name"));
					report.setTermName(rs.getString("termName"));
					report.setCourseId(rs.getInt("course_id"));
					report.setStudentId(rs.getInt("Student_Id"));
					report.setTermId(rs.getInt("term_id"));
					list.add(report);

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public String updateRegistration(Registration blog) {
		
		String response = null;
		int status = 0;
		String BLOG = "Update registration SET course_id=?, term_id=?, student_id=? where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(4, blog.getId());
			cs.setInt(1, blog.getCourseId());
			cs.setInt(3, blog.getStudentId());
			cs.setInt(2, blog.getTermId());
			status = cs.executeUpdate();
			

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	@Override
	public String deleteRegistrationById(String id) {

		String response = null;
		int status = 0;
		String BLOG = "delete from registration where id=?";
		try (Connection conn = jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, id);
			
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

}
