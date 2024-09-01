package com.rating.app.service;

import java.util.List;

import com.rating.app.entity.Rating;
import com.rating.app.exception.RatingException;

public interface RatingService {

	public Rating saveRating(Rating rating) throws RatingException;
	
	public List<Rating> findAllRatings();
	
	public List<Rating> findRatingByUserId(Integer userId);
	
	public List<Rating> findRatingByHotelId(Integer hotelId);
	
	
}
