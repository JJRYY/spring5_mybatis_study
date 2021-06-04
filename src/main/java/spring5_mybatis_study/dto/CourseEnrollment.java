package spring5_mybatis_study.dto;

public class CourseEnrollment {
	private Course course;
	private Student student;

	public CourseEnrollment() {
	}

	public CourseEnrollment(Course course, Student student) {
		this.course = course;
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return String.format("CourseEnrollment [course=%s, student=%s]", course, student);
	}

}
