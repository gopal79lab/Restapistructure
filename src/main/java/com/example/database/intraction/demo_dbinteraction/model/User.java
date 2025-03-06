package com.example.database.intraction.demo_dbinteraction.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(nullable = false)
    @NotNull
    private String name;
    @Column(unique = true,nullable = true)
    private String email;

}
