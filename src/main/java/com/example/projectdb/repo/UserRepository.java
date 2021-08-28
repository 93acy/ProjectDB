package com.example.projectdb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projectdb.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsernameAndPassword(String name, String password);
	
	User findByUsername(String username);

	@Query("SELECT u.id FROM User u WHERE u.username =: username")
	Long findIdByUsername(@Param("username") String username);
}

