package ecom.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dob")
    @NotNull
    @Past
    private LocalDate dob;
    @Column(name = "department")
    @NotNull
    private String department;

    @Column(name = "semester")
    @NotNull
    private Long semester;

    @Column(name = "completed_credits")
    @NotNull
    private Long completed_credits;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "section",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> courses;

    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
