package spring5_mybatis_study.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.CourseEnrollment;
import spring5_mybatis_study.dto.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseEnrollmentMapperTest {
	private static final Log log = LogFactory.getLog(CourseEnrollmentMapperTest.class);
	
	@Autowired
	private CourseEnrollmentMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectCourseEnrollmentById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Course course = new Course();
		course.setCourseId(1);
		
		Student student = new Student();
		student.setStudId(1);
		
		CourseEnrollment courseEnrollment = new CourseEnrollment(course, student);
		CourseEnrollment ce = mapper.selectCourseEnrollmentById(courseEnrollment);
		
		Assert.assertNotNull(ce);
		log.debug(ce.toString());
	}

	@Test
	public void test02InsertCourseEnrollment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Course course = new Course();
		course.setCourseId(3);
		
		Student student = new Student();
		student.setStudId(1);
		
		CourseEnrollment ce = new CourseEnrollment(course, student);
		int res = mapper.insertCourseEnrollment(ce);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateCourseEnrollment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, Integer> map = new HashMap<>();
		map.put("param1", 3);
		map.put("param2", 2);
		map.put("param3", 3);
		map.put("param4", 1);
		
		int res = mapper.updateCourseEnrollment(map);
		Assert.assertEquals(1, res);
		
	}

	@Test
	public void test04DeleteCourseEnrollment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Course course = new Course();
		course.setCourseId(3);
		
		Student student = new Student();
		student.setStudId(2);
		
		CourseEnrollment ce = new CourseEnrollment(course, student);
		int res = mapper.deleteCourseEnrollment(ce);
		Assert.assertEquals(1, res);
	}

}
