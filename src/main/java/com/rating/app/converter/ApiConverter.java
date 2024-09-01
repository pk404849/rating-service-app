package com.rating.app.converter;

import java.util.ArrayList;
import java.util.List;

import com.rating.app.entity.Rating;
import com.rating.app.model.RatingModel;

public class ApiConverter {

	public static Rating getRatingJpaObject(RatingModel ratingModel) {

		Rating rating = null;
		if (ratingModel != null) {
			rating = new Rating();
			rating.setRatingId(ratingModel.getRatingId());
			rating.setUserId(ratingModel.getUserId());
			rating.setHotelId(ratingModel.getHotelId());
			rating.setFeedback(ratingModel.getFeedback());
			rating.setNumberOfRatings(ratingModel.getNumberOfRatings());
		}
		return rating;
	}

	public static List<RatingModel> getRatingModelListObject(List<Rating> ratingsList) {

		List<RatingModel> ratingModelList = null;
		if (ratingsList != null && !ratingsList.isEmpty()) {
			ratingModelList = new ArrayList<>();
			for (Rating rating : ratingsList) {
				ratingModelList.add(getRatingModelObject(rating));
			}
		}
		return ratingModelList;
	}

	public static RatingModel getRatingModelObject(Rating rating) {
		RatingModel ratingModel = null;
		if (rating != null) {
			ratingModel = new RatingModel();
			ratingModel.setRatingId(rating.getRatingId());
			ratingModel.setUserId(rating.getUserId());
			ratingModel.setHotelId(rating.getHotelId());
			ratingModel.setFeedback(rating.getFeedback());
			ratingModel.setNumberOfRatings(rating.getNumberOfRatings());
		}
		return ratingModel;
	}

}
