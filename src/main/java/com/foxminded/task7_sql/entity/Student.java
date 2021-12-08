package com.foxminded.task7_sql.entity;

import java.util.Objects;

public class Student {

    private int studentId;
    private int groupId;
    private String firstName;
    private String lastName;
    
    

    public Student() { 
   
    }
    
    public Student(int group_id, String first_name, String last_name) {
        this.groupId = group_id;
        this.firstName = first_name;
        this.lastName = last_name;
    }

    public Student(int student_id, int group_id, String first_name, String last_name) {
        this.studentId = student_id;
        this.groupId = group_id;
        this.firstName = first_name;
        this.lastName = last_name;
    }

    public int getStudent_id() {
        return studentId;
    }

    public void setStudent_id(int student_id) {
        this.studentId = student_id;
    }

    public int getGroup_id() {
        return groupId;
    }

    public void setGroup_id(int group_id) {
        this.groupId = group_id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, groupId, lastName, studentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return Objects.equals(firstName, other.firstName) && groupId == other.groupId
                && Objects.equals(lastName, other.lastName) && studentId == other.studentId;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", groupId=" + groupId + ", firstName=" + firstName + ", lastName="
                + lastName + "]";
    }
    
    

}
