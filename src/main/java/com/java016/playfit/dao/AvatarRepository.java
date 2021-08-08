package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.Avatar;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Integer>{

}
