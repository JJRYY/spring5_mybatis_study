package spring5_mybatis_study.mapper;

import java.util.List;

import spring5_mybatis_study.dto.CourseStat;

public interface CourseStatMapper {
	// procedure
	/*
	 * Map<String, Object> getCourseCountByTutor(Map<String, Object> param);
	 * Map<String, Object> getCourseCountByTutor2(Map<String, Object> param);
	 */
	CourseStat getCourseCountByTutor3(int param);
	List<CourseStat> getCourseCount();
}
