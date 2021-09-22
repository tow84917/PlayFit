package com.java016.playfit.service;

import java.util.List;

import com.java016.playfit.model.FitActivityVideo;

import javassist.NotFoundException;

public interface VideoService {
	List<FitActivityVideo> getAllFitActivityVideo();
	FitActivityVideo getFitActivityVideoById(Integer id) throws NotFoundException;
}
