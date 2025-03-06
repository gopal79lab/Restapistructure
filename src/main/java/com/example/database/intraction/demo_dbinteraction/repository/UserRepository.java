package com.example.database.intraction.demo_dbinteraction.repository;

import com.example.database.intraction.demo_dbinteraction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
