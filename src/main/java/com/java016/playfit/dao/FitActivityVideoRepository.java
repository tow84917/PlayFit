package com.java016.playfit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java016.playfit.model.FitActivityVideo;

public interface FitActivityVideoRepository extends JpaRepository<FitActivityVideo, Integer>{
	public List<FitActivityVideo> findAll();
	public Optional<FitActivityVideo> findById(Integer id);
}
