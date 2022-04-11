package com.example.Java.preproject311.repository;

import com.example.Java.preproject311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
