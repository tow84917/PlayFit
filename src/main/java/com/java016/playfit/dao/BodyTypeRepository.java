package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.BodyType;

@Repository
public interface BodyTypeRepository extends JpaRepository<BodyType, Integer> {
	
	
	/**
	 * findByName
	 * @param name
	 * @return BodyType
	 */
	public BodyType findByName(String name) ;
}





