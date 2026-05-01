package br.com.ebac.categoriameme.categoriameme.entity;

import java.time.LocalDate;

public class User {

    private Long id;
    private String name;
    private String email;
    private LocalDate data_register;
    public User() {

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
