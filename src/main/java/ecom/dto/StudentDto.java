package ecom.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StudentDto {

    @NotNull
    private String username;


    @NotNull
    private String name;


    @NotNull
    private String password;


    @NotNull
    private LocalDate dob;

    @NotNull
    private String department;

    @NotNull
    private Long semester;

    @NotNull
    private Long completed_credits;

    public StudentDto(){

    }

    public StudentDto(String username, String name, String password, LocalDate dob, String department, Long semester, Long completed_credits) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.dob = dob;
        this.department = department;
        this.semester = semester;
        this.completed_credits = completed_credits;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSemester() {
        return semester;
    }

    public void setSemester(Long semester) {
        this.semester = semester;
    }

    public Long getCompleted_credits() {
        return completed_credits;
    }

    public void setCompleted_credits(Long completed_credits) {
        this.completed_credits = completed_credits;
    }
}
