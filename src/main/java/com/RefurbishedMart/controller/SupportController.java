package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.exception.RefurbishedMartInvalidDataException;
import com.RefurbishedMart.model.Support;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.SupportService;

@RestController
@RequestMapping("/supportcontroller")
@CrossOrigin
public class SupportController {
	
	@Autowired
	SupportService supportService;
	

	@PostMapping("/saveSupport")
	public RefurbishedMartResponse saveSupport(@RequestBody Support user) throws RefurbishedMartInvalidDataException {

		return supportService.saveSupport(user);
	}
	
    @GetMapping("/getSupports")
	public List<Support> getSupports()  {

		return supportService.getSupports();
	}
}
