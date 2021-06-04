select * from addresses;
select * from courses;
select course_id, stud_id from course_enrollment;
select * from students;
select * from tutors;
select * from user_pics;
desc user_pics;

delete from tutors where tutor_id = 5;
delete from courses where course_id = 8;

select stud_id, name, email, dob, phone from students where stud_id = 1;

select stud_id, name, email, dob
	, substring(phone, 1, 3) as f
	, substring(phone, 5, 3) as m
	, substring(phone, 9, 4) as l
	from students
	where stud_id = 1;
	
select stud_id, name, email, dob, phone, a.addr_id, street, city, state, zip, country
	from students s join addresses a on s.addr_id = a.addr_id 
	where stud_id = 1;
	

-- 1:N
select t.tutor_id, t.name as tutor_name, email, c.course_id, c.name, description, start_date, end_date
	from tutors t left join courses c on t.tutor_id=c.tutor_id
	where t.tutor_id=5;

select course_id, name, description, start_date, end_date, tutor_id from courses;

select course_id, name, description, start_date, end_date, tutor_id 
	from courses
	where name like '%java%';

select course_id, name, description, start_date, end_date, tutor_id 
	from courses
	where start_date <= '2013-04-01';

select course_id, name, description, start_date, end_date, tutor_id 
	from courses
	where end_date <= '2013-07-13';
	

select * from course_enrollment;

select c.course_id, c.name as cname, c.description, c.start_date, c.end_date, s.stud_id, s.name, s.email 
from course_enrollment ce join courses c on ce.course_id = c.course_id join students s on ce.stud_id = s.stud_id 
where ce.stud_id = 1 and ce.course_id = 1;

insert into course_enrollment(course_id, stud_id) values (3, 1);

update course_enrollment set course_id = 3, stud_id = 2 where course_id = 3 and stud_id = 1;

delete from course_enrollment where course_id = 3 and stud_id = 1;