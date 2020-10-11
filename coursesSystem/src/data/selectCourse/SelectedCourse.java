package data.selectCourse;

import data.course.Course;
import data.enums.CourseStatus;

public class SelectedCourse {
    private Course course;
    private CourseStatus status;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }
}
