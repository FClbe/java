package data.course;

import data.user.Student;
import data.user.Teacher;

import java.util.List;

public class Course {
    private String courseId;
    private String name;
    private int learningTime;
    private int learningScore;
    private String place;
    private int selectedNum;
    private int maxSelectedNum;
    private Teacher teacher;
    private List<String> studentList;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSelectedNum() {
        return selectedNum;
    }

    public void setSelectedNum(int selectedNum) {
        this.selectedNum = selectedNum;
    }

    public int getMaxSelectedNum() {
        return maxSelectedNum;
    }

    public void setMaxSelectedNum(int maxSelectedNum) {
        this.maxSelectedNum = maxSelectedNum;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<String> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<String> studentList) {
        this.studentList = studentList;
    }

    public int getLearningTime() {
        return learningTime;
    }

    public void setLearningTime(int learningTime) {
        this.learningTime = learningTime;
    }

    public int getLearningScore() {
        return learningScore;
    }

    public void setLearningScore(int learningScore) {
        this.learningScore = learningScore;
    }
}
