package com.rating.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.app.entity.Rating;
import com.rating.app.exception.RatingException;
import com.rating.app.repository.RatingRepository;
import com.rating.app.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating saveRating(Rating rating) throws RatingException {
		if(rating.getFeedback() == null || rating.getFeedback().isBlank()) {
			throw new RatingException("Feedback can be not null or empty");
		}
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> findAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> findRatingByUserId(Integer userId) {
		return ratingRepository.findRatingByUserId(userId);
	}

	@Override
	public List<Rating> findRatingByHotelId(Integer hotelId) {
		return ratingRepository.findRatingByHotelId(hotelId);
	}

}
