package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	System.out.println("My program started .........");
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//    	JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    	
    	
//    	insert query
//    	String query = "insert into student(id,name,city) values(?,?,?)";
    	
//    	fire the query
//    	int result = jdbcTemplate.update(query,456,"Samar","Kanpur");
//    	System.out.println("No. of records inserted..." + result);
//    	System.out.println("Done");
   
    	StudentDao studentdao = context.getBean("studentdao", StudentDao.class);
    	
//    	Student student = new Student();
//    	student.setId(37832);
//    	student.setName("Kdqdqdh");
//    	student.setCity("Akocewede2dds3e2dxevt");
//    	
//    	int result = studentdao.insert(student);
//    	System.out.println("Student added "+result);
//    	
    	
    	
//    	updatation
//    	Student student = new Student();
//    	student.setId(378);
//    	student.setName("Manish");
//    	student.setCity("Panvel");
//    	
//    	int result = studentDao.update(student);
//    	System.out.println("Student updated "+result);
//    	
    	
    
    	
//    	int result = studentdao.delete(378);
//    	System.out.println("Deleted  "+ result);
//    	studentdao.delete(456);
    	
//    	
//    	Student student = studentdao.getStudent(978);
//    	System.out.println(student);
    	
    	
    	
    	List<Student> students = studentdao.getAllStudent();
    	for(Student s:students) {
    		System.out.println(s);
    	}
    	
    }
}
