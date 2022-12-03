package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.model.Feedback;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.FeedbackService;

@RestController
@RequestMapping("/feedbackcontroller")
@CrossOrigin
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	

	@PostMapping("/saveFeedback")
	public RefurbishedMartResponse saveFeedback(@RequestBody Feedback feedback) {

		return feedbackService.saveFeedback(feedback);
	}
	
    @GetMapping("/getFeedbacks")
	public List<Feedback> getFeedbacks()  {

		return feedbackService.getSupports();
	}

}
