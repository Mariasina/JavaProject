package com.petlovers.model;

import javax.persistence.*;

@Entity
@Table(name = "UserData")
public class UserData {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_adress_id") 
    private UserAdress user_adress;

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String value) {
        this.username = value;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public UserAdress getUserAdress() {
        return user_adress;
    }
    public void setUserAdress(UserAdress user_adress) {
        this.user_adress = user_adress;
    }
    
}