package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.User;

public interface AvatarRepository extends JpaRepository<Avatar, Integer> {

	
//	Avatar findById(int id);
}
