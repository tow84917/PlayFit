package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java016.playfit.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	/**
	 * findByEmail
	 * @param email
	 * @return User
	 */
	public User findByEmail(String email);
	
	/**
	 * updateUserName
	 * @param id
	 * @param fullName
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	@Modifying
	@Query(value = "update users u set u.full_name = :fullName where u.id = :id"
	, nativeQuery=true)
	public void updateUserName(
			@Param(value = "id") Integer id, 
			@Param(value="fullName") String fullName) ;
	
	/**
	 * updateUserPassword
	 * @param id
	 * @param password
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	@Modifying
	@Query(value = "update users u set u.password = :password where u.id = :id"
	, nativeQuery=true)
	public void updateUserPassword(
			@Param(value = "id") Integer id, 
			@Param(value="password") String password) ;
	
	/**
	 * updateUserCertificationStatus
	 * @param id
	 * @param certificationStatus
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	@Modifying
	@Query(value = "update users u set u.certification_status = :certificationStatus "
			+ "where u.id = :id"
	, nativeQuery=true)
	public void updateUserCertificationStatus(
			@Param(value = "id") Integer id, 
			@Param(value="certificationStatus") Integer certificationStatus) ;
}









