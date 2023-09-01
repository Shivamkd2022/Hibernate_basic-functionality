package org.mapping.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee
{
    @Id
    private int empId;
    @Column(name="emp_name")
    private String name;
    @ManyToMany
//    @JoinTable(name="emp-proj",
//            joinColumns = {@JoinColumn(name="eid")},
//            inverseJoinColumns = {@JoinColumn(name="pid")})
    private List<Project> projects;

    public Employee() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
