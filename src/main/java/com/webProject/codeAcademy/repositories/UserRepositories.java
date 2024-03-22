package com.webProject.codeAcademy.repositories;

import com.webProject.codeAcademy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User,Long> {
}
