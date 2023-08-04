package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;


@Component("studentdao")
public class StudentDaoImpl implements StudentDao
{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	
	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
//		updating data
		String query = "update student set name=?, city=? where id =?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	@Override
	public int delete(int studentid) {
		// TODO Auto-generated method stub
		String query = "delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentid);
		return r;
	}
	
	@Override
	public Student getStudent(int studentid) {
		// TODO Auto-generated method stub
		String query  = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentid);
		
		return student;
	}
	
//	Selecting multiple student	
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String query = "select * from student";
//		RowMapper<Student> rowMapper = new RowMapperImpl();
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}





	

	
	
	
}
