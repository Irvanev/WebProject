package com.example.webwork.repositories;

import com.example.webwork.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, String> {
    List<Users> findAllByFirstName(String firstName);
    List<Users> findAllByLastName(String lastName);
    @Query("SELECT u FROM Users u JOIN u.role r WHERE r.roleEnum = :role")
    List<Users> findUsersByRole(@Param("role") int role);
}
