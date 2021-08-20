package com.java016.playfit.dao;

import com.java016.playfit.model.FitActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FitActivityRepository extends JpaRepository<FitActivity, Integer> {
    public List<FitActivity> findAllByBodyPart(String bodyPart);
}
