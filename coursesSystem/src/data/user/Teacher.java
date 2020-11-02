package data.user;

import data.course.Course;
import data.selectCourse.SelectedCourse;

import java.util.List;

public class Teacher {
    private String accountId;
    private String name;
    private List<String> courseNames;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourseNames() {
        return courseNames;
    }

    public void setCourseNames(List<String> courseNames) {
        this.courseNames = courseNames;
    }
}
