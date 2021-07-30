package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java016.playfit.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update users u set u.full_name = :fullName where u.id = :id", nativeQuery=true)
	void updateUserName(@Param(value = "id") int id,@Param(value="fullName") String fullName);
}
