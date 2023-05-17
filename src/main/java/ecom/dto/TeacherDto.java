package ecom.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TeacherDto {

    private Long id;
    @NotNull
    private String username;


    @NotNull
    private String name;


    @NotNull
    private String password;

    @NotNull
    private String department;

    @NotNull
    private Long salary;

    public TeacherDto(){

    }

    public TeacherDto(Long id,String username, String name, String password, String department, Long salary) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.department = department;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
