package com.java016.playfit.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.FitActivityRepository;
import com.java016.playfit.dao.FitActivityVideoRepository;
import com.java016.playfit.model.FitActivityVideo;
import com.java016.playfit.service.VideoService;

import javassist.NotFoundException;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	FitActivityVideoRepository fitActivityVideoRepo;
	@Override
	public List<FitActivityVideo> getAllFitActivityVideo() {
		
		return fitActivityVideoRepo.findAll();
	}
	@Override
	public FitActivityVideo getFitActivityVideoById(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		Optional<FitActivityVideo> entityOptional = fitActivityVideoRepo.findById(id);
		if(entityOptional.isPresent()) {
			return entityOptional.get();
		}else {
			throw new NotFoundException("video id not founded");
		}
	}

}
