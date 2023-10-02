package com.masai.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

    Optional<Admin> findByEmail(String email);

	
}
