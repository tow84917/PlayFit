package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.AvatarBody;

@Repository
public interface AvatarBodyRepository extends JpaRepository<AvatarBody, Integer> {

}
