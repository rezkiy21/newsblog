package com.example.newsblog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String fname;
    @NotBlank
    private String lname;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String age;
    private String token;

}
