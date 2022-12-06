package com.RefurbishedMart.valueobject;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.annotations.SetBinder;
import org.json.JSONException;
import org.json.JSONObject;

import com.RefurbishedMart.model.Address;
import com.RefurbishedMart.model.Cart;
import com.RefurbishedMart.model.Category;
import com.RefurbishedMart.model.Contact;
import com.RefurbishedMart.model.Feedback;
import com.RefurbishedMart.model.Order;
import com.RefurbishedMart.model.OrderProducts;
import com.RefurbishedMart.model.Product;
import com.RefurbishedMart.model.Support;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.model.WishList;
import com.RefurbishedMart.status.UserStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtility {
	
	
	
	

 public static String getDummyUser() throws JsonProcessingException
 {
	 User user=new User();
	 user.setFirstname("p");
	 user.setLastname("arun");
	 user.setUsername("arun");
	 user.setPassword("1234567");
	 Contact contact=new Contact();
	 contact.setEmail("pa@gmail.com");
	 contact.setPhno(Long.parseLong("9000730500"));
	 Address address=new Address();
	 address.setAptno("1-22");
	 address.setStreet("ny");
	 address.setPincode(76201);
	 address.setCity("cs");
	 address.setState("NJ");
	 address.setCountry("US");
	 contact.setAddress(address);
	 user.setContact(contact);
	return new ObjectMapper().writeValueAsString(user);
 }
 

 
 public static String getDummyLogin() throws JsonProcessingException
 {
	 User user=new User();

	 user.setPassword("1234567");
	 Contact contact=new Contact();
	 contact.setEmail("pa@gmail.com");
	 user.setContact(contact);
	return new ObjectMapper().writeValueAsString(user);
 }

 
 public static String getDummyLoginNegative() throws JsonProcessingException
 {
	 User user=new User();

	 user.setPassword("123");
	 Contact contact=new Contact();
	 contact.setEmail("pa@gmail.com");
	 user.setContact(contact);
	return new ObjectMapper().writeValueAsString(user);
 }
 
 public static String getDummyLoginNegative1() throws JsonProcessingException
 {
	 User user=new User();

	 user.setPassword("123");
	 Contact contact=new Contact();
	 contact.setEmail("paaa@gmail.com");
	 user.setContact(contact);
	return new ObjectMapper().writeValueAsString(user);
 }
 

 
 public static String EditProfileDUmmy(User data) throws JsonProcessingException
 {
    User user=new User();
	 user.setId(data.getId());
	 user.setUid(data.getUid());
	 user.setFirstname(data.getFirstname());
	 user.setLastname("priya");
	 user.setUsername(data.getUsername());
	 user.setPassword(data.getPassword());
	 user.setStatus(data.getStatus());
	 user.setUsertype(data.getUsertype());
	 Contact contact=new Contact();
	 contact.setId(data.getContact().getId());
	 contact.setEmail(data.getContact().getEmail());
	 contact.setPhno(data.getContact().getPhno());
	 Address address=new Address();
	 address.setId(data.getContact().getAddress().getId());
	 address.setAptno(data.getContact().getAddress().getAptno());
	 address.setStreet(data.getContact().getAddress().getStreet());
	 address.setPincode(data.getContact().getAddress().getPincode());
	 address.setCity(data.getContact().getAddress().getCity());
	 address.setState(data.getContact().getAddress().getState());
	 address.setCountry(data.getContact().getAddress().getCountry());
	 contact.setAddress(address);
	 user.setContact(contact);
	return new ObjectMapper().writeValueAsString(user);
 }
 
 public static String getDummyForgotPassword() throws JsonProcessingException
 {
	 ForgotPasswordVo user=new ForgotPasswordVo();
	 
	 user.setEmail("pa@gmail.com");
	 user.setPassword("1234567");
	 
	return new ObjectMapper().writeValueAsString(user);
 }
 
 public static String getDummyCart() throws JsonProcessingException
 {
	 Cart cart=new Cart();
	  cart.setUserid("1");
	  cart.setName("13 Pro Max");
	  cart.setDescription("mint condition");
	  cart.setImgpath("https://di2ponv0v5otw.cloudfront.net/posts/2022/06/07/629f66b367ffb13e36774441/m_wp_629f66c57272af21acb4f46d.webp");
      cart.setPrice(Double.parseDouble("1099"));
      cart.setQuantity(1);
      cart.setProductid("1");
	return new ObjectMapper().writeValueAsString(cart);
 }
 
 public static String getDummyCategory() throws JsonProcessingException
 {
	 Category category=new Category();
	 category.setCategoryname("Books");
	 return new ObjectMapper().writeValueAsString(category);
	 
 }
 
 public static String getDummyUpdateCategory(Long id) throws JsonProcessingException
 {
	 Category category=new Category();
	 category.setCategoryid(id);
	 category.setCategoryname("Books");
	 return new ObjectMapper().writeValueAsString(category);
	 
 }
 
 public static String getDummyFeedBack() throws JsonProcessingException
 {
      Feedback feedback=new Feedback();
      feedback.setFirstname("priya");
      feedback.setLastname("santu");
      feedback.setEmail("priya@gmail.com");
      feedback.setRating("GOOD");
      feedback.setFeedback("Nice");
	return new ObjectMapper().writeValueAsString(feedback);
 }
 
 public static String getDummySupport() throws JsonProcessingException
 {
      Support support=new Support();
      support.setFirstname("priya");
      support.setLastname("santu");
      support.setEmail("priya@gmail.com");
      support.setIssue("Request Invoice for order");
      support.setDescription("Please send copy");
	return new ObjectMapper().writeValueAsString(support);
 }
 public static String getDummyWishList() throws JsonProcessingException
 {
	 WishList wishList=new WishList();
	 wishList.setUserid("hsa@gmail.com");
	 wishList.setProdname("13 Pro Max");
	 wishList.setDescription("mint condition");
	 wishList.setImgpath("https://di2ponv0v5otw.cloudfront.net/posts/2022/06/07/629f66b367ffb13e36774441/m_wp_629f66c57272af21acb4f46d.webp");
	 wishList.setPrice(Double.parseDouble("1099"));
	 wishList.setBrand("Apple");
	 wishList.setProdid("457867");
	return new ObjectMapper().writeValueAsString(wishList);
 }
 
 public static String getDummyOrder() throws JsonProcessingException
 {
	 List<OrderProducts> op=new ArrayList<OrderProducts>();
	 OrderProducts product=new OrderProducts();
	 product.setProductid("p1");
	 product.setQuantity("1");
	 product.setImgpath("https://di2ponv0v5otw.cloudfront.net/posts/2022/06/07/629f66b367ffb13e36774441/m_wp_629f66c57272af21acb4f46d.webp");
	 product.setDescription("nice");
	 product.setPrice("200");
	 op.add(product);
	 Order order=new Order();
	 order.setUserMail("spriya@gmail.com");
	 order.setTotalprice(1000);
	 order.setStreet("test");
	 order.setCity("nc");
	 order.setState("iln");
	 order.setZipCode("76201");
	 order.setOp(op);
	 order.setStatus("Pending");
	 
	 return new ObjectMapper().writeValueAsString(order); 
 }
 
 public static String getDummyProduct(Long id,String name) throws JsonProcessingException
 {
Product product=new Product();
product.setProdname("PODS GEN 1");
product.setType("AIrpods");
product.setBrand("APPLE");
Category c=new Category();
c.setCategoryid(id);
c.setCategoryname(name);
product.setCategory(c);
product.setImgpath("https://di2ponv0v5otw.cloudfront.net/posts/2022/06/07/629f66b367ffb13e36774441/m_wp_629f66c57272af21acb4f46d.webp");
product.setDescription("nice");
product.setPrice(112.3);
 return new ObjectMapper().writeValueAsString(product);
}
 
 
 
 public static String getDummyProductUpadte(Long id,String name) throws JsonProcessingException
 {
Product product=new Product();
product.setProdname("PODS GEN 1");
product.setType("AIrpodss");
product.setBrand("APPLE");
Category c=new Category();
c.setCategoryid(id);
c.setCategoryname(name);
product.setCategory(c);
product.setImgpath("https://di2ponv0v5otw.cloudfront.net/posts/2022/06/07/629f66b367ffb13e36774441/m_wp_629f66c57272af21acb4f46d.webp");
product.setDescription("nice");
product.setPrice(112.3);
 return new ObjectMapper().writeValueAsString(product);
}
 
 public static String getDummyCategoryProduct() throws JsonProcessingException
 {
	 Category category=new Category();
	 category.setCategoryname("TEST");
	 return new ObjectMapper().writeValueAsString(category);
	 
 }
 //admin
 

 public static String getDummyAdminUser() throws JsonProcessingException
 {
	 User user=new User();
	 user.setFirstname("p");
	 user.setLastname("Reddy");
	 user.setUsername("reddy");
	 user.setPassword("1234567");
	 Contact contact=new Contact();
	 contact.setEmail("reddy@gmail.com");
	 contact.setPhno(Long.parseLong("984898044"));
	 Address address=new Address();
	 address.setAptno("1-22");
	 address.setStreet("ny");
	 address.setPincode(76201);
	 address.setCity("cs");
	 address.setState("NJ");
	 address.setCountry("US");
	 contact.setAddress(address);
	 user.setContact(contact);
	return new ObjectMapper().writeValueAsString(user);
 }
 
 public static String getDummyAdminLogin() throws JsonProcessingException
 {
	 User user=new User();

	 user.setPassword("1234567");
	 Contact contact=new Contact();
	 contact.setEmail("reddy@gmail.com");
	 user.setContact(contact);
	return new ObjectMapper().writeValueAsString(user);
 }
 
 public static String getDummyAdminLoginNegative() throws JsonProcessingException
 {
	 User user=new User();

	 user.setPassword("123");
	 Contact contact=new Contact();
	 contact.setEmail("reddy@gmail.com");
	 user.setContact(contact);
	return new ObjectMapper().writeValueAsString(user);
 }
 
 public static String getDummyAdminLoginNegative1() throws JsonProcessingException
 {
	 User user=new User();

	 user.setPassword("123");
	 Contact contact=new Contact();
	 contact.setEmail("reddfry@gmail.com");
	 user.setContact(contact);
	return new ObjectMapper().writeValueAsString(user);
 }
 
}
