package com.kaushik.helpiez.webservice.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.kaushik.helpiez.client.model.LoginClientModel;
import com.kaushik.helpiez.database.NgoCategoryPojo;
import com.kaushik.helpiez.database.NgoEventPojo;
import com.kaushik.helpiez.database.NgoRegistrationPojo;
import com.kaushik.helpiez.database.UserRegistrationPojo;
import com.kaushik.helpiez.webservice.RestURIConstants;
import com.kaushik.helpiez.webservice.model.EmailVarificationModel;
import com.kaushik.helpiez.webservice.model.LoginStatus;
import com.kaushik.helpiez.webservice.model.NewEventModel;
import com.kaushik.helpiez.webservice.model.NgoDetailModel;
import com.kaushik.helpiez.webservice.model.NgoEmailModel;
import com.kaushik.helpiez.webservice.model.NgoRegistrationModel;
import com.kaushik.helpiez.webservice.model.Status;
import com.kaushik.helpiez.webservice.model.UserRegistrationModel;
import com.kaushik.helpiez.webservice.service.WebServiceServices;


@Controller
public class WebServiceController implements ServletContextAware{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceController.class);
	private Integer IMAGE_MAX_SIZE = 50000000;
	private ServletContext servletContext;
	
	@Autowired
	private WebServiceServices webServices;
	
	@RequestMapping(value = RestURIConstants.LOGIN, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LoginStatus loginUser(@RequestBody LoginClientModel model) {
		
		LOGGER.info("Login Process start ");
        
		
		String result = webServices.loginUser(model);
		System.out.println(result);
		LoginStatus status = new LoginStatus();
		if(result == "notemail" ||result.equals("notemail"))
		{
			status.setStatusCode(0);
			status.setStatusMessage("Your email id is wrong");
		}
		else if(result == "notactive" ||result.equals("notactive"))
 		{
			status.setStatusCode(0);
			status.setStatusMessage("Your account not active please first activate your account");
		}
		else if(result == "notpass" ||result.equals("notpass"))
		{
			status.setStatusCode(0);
			status.setStatusMessage("Your password is wrong");
		}
		else
		{
			int index = result.indexOf("-");
			String loginId = result.substring(0,index);
			String roleName = result.substring(index+1);
			System.out.println("LoginId"+loginId);
			System.out.println("Rolename"+roleName);
			
			status.setStatusCode(1);
			status.setLoginId(Integer.parseInt(loginId));
			status.setStatusMessage("LoginSuccsss");
			status.setRoleName(roleName);
			
		}
		return status;
	}
	
	@RequestMapping(value = RestURIConstants.CREATE_USER, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status createUser(@RequestBody UserRegistrationModel model) {
        LOGGER.info("Registration start NGO");
        
        Status status = new Status();
        
        try
        	{
        		System.out.println("-------------------------------------------------------");
    			String result = webServices.registerUser(model);
	        	if(result.equals("1") || result == "1")
	        	{
	        		status.setStatusCode(1);
	        		status.setStatusMessage("Email Id Already Registered");
	        	}
	        	else if(result.equals("2") || result == "2")
	        	{
	        		status.setStatusCode(2);
	        		status.setStatusMessage("Registration Successfully");
	        	}
	        	else
	        	{
	        		status.setStatusCode(0);
	        		status.setStatusMessage("Null Data");
	        	}
        	}
        	catch(Exception ex)
        	{
        		LOGGER.error("Exception :",ex);
        	}
        return status;
    }
	
	@RequestMapping(value = RestURIConstants.CREATE_EVENT, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody Status createEvent(@RequestBody NewEventModel model) {
	        LOGGER.info("Registration start Event");
	        
	        Status status = new Status();
	        try
	        	{
	        		System.out.println("-------------------------------------------------------");
	        		
	        		String imagename = "Event"+model.getEventTitle().substring(0, 3)+"-"+model.getEventDate();
	        		String name = imagename+".jpg";
     			
	        	/*	String valid = validateImage(model.getEventLogo());
	        		if(valid.equals("no") || valid =="no")
	        		{
	        			
	        			MultipartFile file = model.getEventLogo();
	        			try {
	                        byte[] bytes = file.getBytes();
	         
	                        // Creating the directory to store file
	                        String rootPath = servletContext.getRealPath("/");
	                        File dir = new File(rootPath + File.separator + "eventimage");
	                        if (!dir.exists())
	                            dir.mkdirs();
	                        System.out.println("=*************************************************=");
	                		
	                        File serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
	                        BufferedOutputStream stream = new BufferedOutputStream(
	                                new FileOutputStream(serverFile));
	                        stream.write(bytes);
	                        stream.close();
	         
	                        LOGGER.info("Server File Location="
	                                + serverFile.getAbsolutePath());
	         
	                       
	                    } catch (Exception e) {
	                    	LOGGER.error("Error :",e);
	                    }
	        			*/
	        			String path = "http://localhost:8080/helpiez/eventimage/"+name;
	        			String result = webServices.registerEvent(model,path);
			        	if(result.equals("1") || result == "1")
			        	{
			        		status.setStatusCode(1);
			        		status.setStatusMessage("Event Register Successfully");
			        	}
			        	else
			        	{
			        		status.setStatusCode(0);
			        		status.setStatusMessage("Event Not Register Successfully");
			        	}
	        	/*	}
	        		else
	        		{
	        			status.setStatusCode(3);
	   	        		status.setStatusMessage("not valid");
	        		}*/
		        	
	        	}
	        	catch(Exception ex)
	        	{
	        		LOGGER.error("Exception :",ex);
	        	}
	       
	        return status;
	    }

	
	 @RequestMapping(value = RestURIConstants.CREATE_NGO, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody Status createNgo(@RequestBody NgoRegistrationModel model) {
	        LOGGER.info("Registration start NGO");
	        
	        Status status = new Status();
	        
	        if(model.getNgoName().equals("") ||model.getNgoName()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Ngo Name");
	        }
	        else if(model.getNgoCause().equals("") || model.getNgoCause()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Ngo Cause");
	        }
	        else if(model.getNgoEmailId().equals("") || model.getNgoEmailId()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Ngo Email Id");
	        }
	        else if(model.getNgoContactNumber().equals("") || model.getNgoContactNumber()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Ngo Contact Number");
	        }
	        else if(model.getNgoAlternativeContactNumber().equals("") || model.getNgoAlternativeContactNumber()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Ngo Alternative Contact Number");
	        }
	        else if(model.getNgoHeadOfficeAddress1().equals("") || model.getNgoHeadOfficeAddress1()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Ngo Address Line1");
	        }
	        else if(model.getNgoHeadOfficeAddress2().equals("") || model.getNgoHeadOfficeAddress2()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Ngo Address Line2");
	        }
	        else if(model.getNgoHeadOfficeAddressCity().equals("") || model.getNgoHeadOfficeAddressCity()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Ngo Address City");
	        }
	        else if(model.getNgoHeadOfficeAddressState().equals("") || model.getNgoHeadOfficeAddressState()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Address State");
	        }
	        else if(model.getNgoHeadOfficeAddressCountry().equals("") || model.getNgoHeadOfficeAddressCountry()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Address Country");
	        }
	        else if(model.getNgoHeadOfficeAddressPincode().equals("") || model.getNgoHeadOfficeAddressPincode()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Address Pincode");
	        }
	        /*else if(model.getNgoImageLogo().equals("") || model.getNgoImageLogo()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Select Image Logo");
	        }*/
	        else if(model.getNgoLocationLongitude().equals("") || model.getNgoLocationLongitude()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Location Longitude");
	        }
	        else if(model.getNgoLocationLatitude().equals("") || model.getNgoLocationLatitude()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Location Latitude");
	        }
	        else if(model.getNgoCategory().equals("") || model.getNgoCategory()==null)
	        {
	        	 status.setStatusCode(0);
	        	 status.setStatusMessage("Enter Ngo Category");
	        }
	        else
	        {
	        	try
	        	{
	        		System.out.println("-------------------------------------------------------");
	        		String name = model.getNgoName()+".jpg";
        			/*
	        		String valid = validateImage(model.getNgoImageLogo());
	        		if(valid.equals("no") || valid =="no")
	        		{
	        			
	        			MultipartFile file = model.getNgoImageLogo();
	        			try {
	                        byte[] bytes = file.getBytes();
	         
	                        // Creating the directory to store file
	                        String rootPath = servletContext.getRealPath("/");
	                        File dir = new File(rootPath + File.separator + "imageslogo");
	                        if (!dir.exists())
	                            dir.mkdirs();
	                        System.out.println("=*************************************************=");
	                		
	                        File serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
	                        BufferedOutputStream stream = new BufferedOutputStream(
	                                new FileOutputStream(serverFile));
	                        stream.write(bytes);
	                        stream.close();
	         
	                        LOGGER.info("Server File Location="
	                                + serverFile.getAbsolutePath());
	         
	                       
	                    } catch (Exception e) {
	                    	LOGGER.error("Error :",e);
	                    }
	        			*/
	        			String path = "http://localhost:8080/helpiez/imageslogo/"+name;
	        			String result = webServices.registerNgo(model,path);
			        	if(result.equals("1") || result == "1")
			        	{
			        		status.setStatusCode(1);
			        		status.setStatusMessage("Email Id Already Registered");
			        	}
			        	else if(result.equals("2") || result == "2")
			        	{
			        		status.setStatusCode(2);
			        		status.setStatusMessage("Registration Successfully");
			        	}
			        	else
			        	{
			        		status.setStatusCode(0);
			        		status.setStatusMessage("Null Data");
			        	}
	        	/*	}
	        		else
	        		{
	        			status.setStatusCode(3);
	   	        		status.setStatusMessage("not valid");
	        		}*/
		        	
	        	}
	        	catch(Exception ex)
	        	{
	        		LOGGER.error("Exception :",ex);
	        	}
	       
	        }
	        return status;
	    }

	 @RequestMapping(value = RestURIConstants.ALL_CATEGORY, method = RequestMethod.GET)
	 public @ResponseBody List<NgoCategoryPojo> getAllNgoCategory() {
		 	List<NgoCategoryPojo> list = null;
		 	LOGGER.info("Get All NGO-Category Start");
			list = webServices.getNgoCategoryList();
			return list;
	}
	 
	 @RequestMapping(value = RestURIConstants.NGO_INFO, method = RequestMethod.GET)
	 public @ResponseBody List<NgoRegistrationPojo> getNgoInfo(@PathVariable("loginId") String loginId) {
		 	List<NgoRegistrationPojo> list = null;
		 	LOGGER.info("Get NGO-Information Start");
		 	if(loginId != null || loginId != "")
		 	{
		 		list = webServices.getNgoInfo(loginId);
		 		return list;
		 	}
		 	else
		 	{
		 		return null;
		 	}
	}
	 
	 @RequestMapping(value = RestURIConstants.USER_INFO, method = RequestMethod.GET)
	 public @ResponseBody List<UserRegistrationPojo> getUserInfo(@PathVariable("loginId") String loginId) {
		 	List<UserRegistrationPojo> list = null;
		 	LOGGER.info("Get USer-Information Start");
		 	if(loginId != null || loginId != "")
		 	{
		 		list = webServices.getUserInfo(loginId);
		 		return list;
		 	}
		 	else
		 	{
		 		return null;
		 	}
	}
	 
	 @RequestMapping(value = RestURIConstants.ALL_NGO, method = RequestMethod.GET)
	 public @ResponseBody List<NgoRegistrationPojo> getAllNgosDetails() {
		 	List<NgoRegistrationPojo> list = null;
		 	LOGGER.info("Get All NGO-Category Start");
			list = webServices.getNgoList();
			return list;
	}
	
	 @RequestMapping(value = RestURIConstants.ALL_NEAR_NGO, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody  List<NgoRegistrationPojo> getNearestNgoDetail(@RequestBody NgoDetailModel model) {
	        LOGGER.info("Get All Nearest Ngo List start NGO");
	        List<NgoRegistrationPojo> list = null;
		 	list = webServices.getNearNgoList(model);
		 	return list;
	 }
	 
	 @RequestMapping(value = RestURIConstants.ALL_NEAR_EVENT, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody List<NgoEventPojo> getNearestEventDetail(@RequestBody NgoDetailModel model) {
	        LOGGER.info("Get Nearest Event List start NGO");
	        List<NgoEventPojo> map = null;
			map = webServices.getNearEventList(model);
			return map;
	 }
	 
	 @RequestMapping(value = RestURIConstants.EVENT_LIST, method = RequestMethod.GET)
	 public @ResponseBody List<NgoEventPojo> ngoEventList(@PathVariable("ngoId") int ngoId) {
	        LOGGER.info("Get Ngo Event List Start");
	        List<NgoEventPojo> list = null;
	        list = webServices.getNgoEventList(ngoId);
			return list;
	 }
	 
	@RequestMapping(value = RestURIConstants.CHECK_EMAIL, method = RequestMethod.POST)
	public @ResponseBody Status checkEmail(@RequestBody NgoEmailModel model) {
	        LOGGER.info("Check Email Start");
	        String emailId = model.getEmailId();
	        Status status = new Status();
	        System.out.println(emailId);
	        String result = webServices.checkNgoEmail(emailId);
	        if(result=="Yes")
	        {
	        	status.setStatusCode(1);
	        	status.setStatusMessage("Email id already registered");
	        }
	        else if(result=="No")
	        {
	        	status.setStatusCode(0);
	        	status.setStatusMessage("Email id not registered");
	        }
	        return status;
	 }
	 
	@RequestMapping(value = RestURIConstants.EMAIL_VARIFICATION, method = RequestMethod.POST)
	public @ResponseBody Status ngoEmailVarification(@RequestBody EmailVarificationModel model) {
	        LOGGER.info("Ngo Email Id Varification");
	        String emailId = model.getEmailId();
	        Status status = new Status();
	        boolean result = webServices.ngoEmailVarifiaction(model);
	        if(result == false)
	        {
	        	status.setStatusCode(0);
	        	status.setStatusMessage("Your Token is Expired");
	        }
	        else
	        {
	        	status.setStatusCode(1);
	        	status.setStatusMessage("Your varification Successfully");
	        }
	        return status;
	 }
	 
	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	private String validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			return "Only JPG images are accepted";
		}
		else if (!image.getContentType().equals("image/png")) {
			return "Only PNG images are accepted";
		}
		else if (!image.getContentType().equals("image/gif")) {
			return "Only GIF images are accepted";
		}
		else
		{
			return "no";
		}
	}
}
