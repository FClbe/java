package data.selectCourse;

import data.course.Course;

public class SelectedCourse {
    private Course course;
    /*1 代表 SELECT 2代表 FINISHED*/
    private int status;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
