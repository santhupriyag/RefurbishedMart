package com.RefurbishedMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.model.Support;
import com.RefurbishedMart.repository.SupportRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.SupportService;

@Component
public class SupportServiceImpl implements SupportService{
	
	@Autowired
	SupportRepository supportRepository;

	@Override
	public RefurbishedMartResponse saveSupport(Support user) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		
		supportRepository.save(user);
		response.setMessage(RefurbishedMartMessage.RM_SUPPPORT_SAVED);
		return response;
	}

	@Override
	public List<Support> getSupports() {
		// TODO Auto-generated method stub
		return supportRepository.findAll();
	}

}
