package com.rating.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rating.app.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	@Query("SELECT r from Rating r where r.userId =:userId")
	List<Rating> findRatingByUserId(@Param("userId") Integer userId);

	 @Query("SELECT r from Rating r where r.hotelId =:hotelId")
	List<Rating> findRatingByHotelId(@Param("hotelId") Integer hotelId);

//	List<Rating> findByUserId(Integer userId);

//	List<Rating> findByHotelId(Integer hotelId);
}
