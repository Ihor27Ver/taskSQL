package com.foxminded.task7_sql.entity;

public class Course {
    private int CourseId;
    private String CourseName;
    private String CourseDescription;

    public Course() {

    }

    public Course(int CourseId, String CourseName, String CourseDescription) {

        this.CourseId = CourseId; 
        this.CourseName = CourseName;
        this.CourseDescription = CourseDescription;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getCourseDescription() {
        return CourseDescription;
    }

    public void setCourseDescription(String CourseDescription) {
        this.CourseDescription = CourseDescription;
    }

}
