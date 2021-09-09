package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.AvatarClothes;

@Repository
public interface AvatarClothesRepository extends JpaRepository<AvatarClothes, Integer> {
	
	/**
	 * 依名稱、體型找
	 * @param color
	 * @param typeId
	 * @return AvatarClothes
	 */
	@Query(value = "SELECT * FROM avatar_clothes ac WHERE ac.name = "
			+ ":name AND ac.type = :type", nativeQuery=true)
	public AvatarClothes findByNameAndType(
			@Param("name")String name, @Param("type")Integer typeId);
}





