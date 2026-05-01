package br.com.ebac.user.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_user")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "data_register", nullable = false)
    private LocalDate data_register;

    public Users() {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_register() {
        return data_register;
    }

    public void setData_register(LocalDate data_register) {
        this.data_register = data_register;
    }
}
