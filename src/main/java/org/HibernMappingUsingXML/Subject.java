package org.HibernMappingUsingXML;

public class Subject
{
    private int subId;
    private String subName;
    private String department;
    private String instructor;

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Subject() {
    }

    public Subject(int subId, String subName, String department, String instructor) {
        this.subId = subId;
        this.subName = subName;
        this.department = department;
        this.instructor = instructor;
    }
}
