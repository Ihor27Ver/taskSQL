package com.foxminded.task7_sql.entity;

import java.util.Objects;

public class Group {
    private int groupId ;
    private String groupName ;
    
    
    
    public Group() {
       
    }
    public Group(int group_id, String group_name) {
       
        this.groupId = group_id;
        this.groupName = group_name;
    }
    public int getGroup_id() {
        return groupId;
    }
    public void setGroup_id(int group_id) {
        this.groupId = group_id;
    }
    public String getGroup_name() {
        return groupName;
    }
    public void setGroup_name(String group_name) {
        this.groupName = group_name; 
    }
    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Group other = (Group) obj;
        return groupId == other.groupId && Objects.equals(groupName, other.groupName);
    }
    @Override
    public String toString() {
        return "Group [groupId=" + groupId + ", groupName=" + groupName + "]";
    }
   
    
    
}
