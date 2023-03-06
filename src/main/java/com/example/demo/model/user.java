package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import static java.time.temporal.ChronoUnit.YEARS;

@Entity(name = "User")
@Table(name = "users")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class user {

    @JsonProperty(value = "user_id")
    @javax.persistence.Id
    @SequenceGenerator(
            name = "user_id",
            sequenceName = "user_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id"
    )
    @Column(name = "user_id")
    private long Id;
    
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "login", nullable = false)
    private String login;

    @JsonIgnore
    @Column(name = "user_password", nullable = false)
    private String password;
    
    @JsonProperty(value = "sub_date")
    @Column(name = "sub_date", nullable = false)
    private LocalDate subscriptionDate;
    
    public user (String username, String login, String password, LocalDate sub_date) {
    	this.username = username;
    	this.login = login;
    	this.password = password;
    	this.subscriptionDate = sub_date;
    }
    
    public int getyearsofsub() {
    	return (int) YEARS.between(subscriptionDate, LocalDate.now());
    }
    
    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<comment> comments = new ArrayList<>();
    
    public boolean isNull() {
        return this.username == null;
    }
    
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", login='" + login + '\'' +
                ", subscriptionDeadline=" + subscriptionDate +
                '}';
    }
}
    