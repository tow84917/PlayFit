package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.AvatarHat;

@Repository
public interface AvatarHatRepository extends JpaRepository<AvatarHat, Integer> {
	
	/**
	 * 依名稱、體型找
	 * @param color
	 * @param typeId
	 * @return AvatarHat
	 */
	@Query(value = "SELECT * FROM avatar_hat ah WHERE ah.name = "
			+ ":name AND ah.type = :type", nativeQuery=true)
	public AvatarHat findByNameAndType(
			@Param("name")String name, @Param("type")Integer typeId);
}








