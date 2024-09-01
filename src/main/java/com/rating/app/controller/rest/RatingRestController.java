package com.rating.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.app.converter.ApiConverter;
import com.rating.app.entity.Rating;
import com.rating.app.exception.RatingException;
import com.rating.app.model.RatingModel;
import com.rating.app.service.RatingService;

@RestController
@RequestMapping(value = "/rating")
public class RatingRestController {

	@Autowired
	private RatingService ratingService;

	@PostMapping(value = "/save-rating")
	public ResponseEntity<?> saveRating(@RequestBody RatingModel ratingModel) throws RatingException {
		Rating rating = ApiConverter.getRatingJpaObject(ratingModel);
		Rating saveRating = ratingService.saveRating(rating);
		return ResponseEntity.ok(saveRating);
	}

	@GetMapping(value = "/find-all-ratings")
	public ResponseEntity<?> findAllRatings() {
		List<Rating> ratingsList = ratingService.findAllRatings();
		List<RatingModel> ratingModelList = ApiConverter.getRatingModelListObject(ratingsList);
		return ResponseEntity.ok(ratingModelList);
	}

	@GetMapping(value = "/find-rating-by-user-id/{userId}")
	public ResponseEntity<?> findRatingByUserId(@PathVariable(name = "userId") Integer userId) {
		List<Rating> ratingsList = ratingService.findRatingByUserId(userId);
		List<RatingModel> ratingModelList = ApiConverter.getRatingModelListObject(ratingsList);
		return ResponseEntity.ok(ratingModelList);
	}

	@GetMapping(value = "/find-rating-by-hotel-id/{hotelId}")
	public ResponseEntity<?> findRatingByHotelId(@PathVariable(name = "hotelId") Integer hotelId) {
		List<Rating> ratingsList = ratingService.findRatingByHotelId(hotelId);
		List<RatingModel> ratingModelList = ApiConverter.getRatingModelListObject(ratingsList);
		return ResponseEntity.ok(ratingModelList);
	}
}
