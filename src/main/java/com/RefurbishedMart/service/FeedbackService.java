package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.model.Feedback;
import com.RefurbishedMart.model.Support;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface FeedbackService {

	List<Feedback> getSupports();

	RefurbishedMartResponse saveFeedback(Feedback feedback);

}
