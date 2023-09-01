package org.mapping.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project
{
    @Id
   private int projId;
    @Column(name="proj_name")
   private String projName;
    @ManyToMany(mappedBy = "projects")


    private List<Employee> employees;

    public Project() {
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
