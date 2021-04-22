##Retrieve data for many to many relationship from Student_Course table

```text

SELECT * FROM STUDENT_COURSE, STUDENT, COURSE
Where STUDENT_COURSE.STUDENT_ID=STUDENT.ID and
STUDENT_COURSE.COURSE_ID=COURSE.ID

```