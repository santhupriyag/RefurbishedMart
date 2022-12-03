package com.RefurbishedMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.model.Feedback;
import com.RefurbishedMart.model.Support;
import com.RefurbishedMart.repository.FeedBackRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.FeedbackService;

@Component
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	FeedBackRepository feedBackRepository;

	@Override
	public List<Feedback> getSupports() {
		// TODO Auto-generated method stub
		return feedBackRepository.findAll();
	}

	@Override
	public RefurbishedMartResponse saveFeedback(Feedback feedback) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		feedBackRepository.save(feedback);
		response.setMessage(RefurbishedMartMessage.RM_FEEDBACK_SAVED);
		return response;
	}

}
