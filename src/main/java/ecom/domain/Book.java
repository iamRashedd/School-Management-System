package ecom.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "available_copy")
    @NotNull
    private Long available_copy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAvailable_copy() {
        return available_copy;
    }

    public void setAvailable_copy(Long available_copy) {
        this.available_copy = available_copy;
    }
}
