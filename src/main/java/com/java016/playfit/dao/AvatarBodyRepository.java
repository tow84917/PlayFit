package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.AvatarBody;

@Repository
public interface AvatarBodyRepository extends JpaRepository<AvatarBody, Integer> {
	
	/**
	 * 依顏色、體型找
	 * @param color
	 * @param typeId
	 * @return AvatarBody
	 */
	@Query(value = "SELECT * FROM avatar_body ab WHERE ab.color = "
			+ ":color AND ab.type = :type", nativeQuery=true)
	public AvatarBody findByColorAndType(
			@Param("color")String color, @Param("type")Integer typeId);

}









