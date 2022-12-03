package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.model.Support;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface SupportService {

	RefurbishedMartResponse saveSupport(Support user);

	List<Support> getSupports();

}
