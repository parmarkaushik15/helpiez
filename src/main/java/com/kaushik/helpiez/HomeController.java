package com.kaushik.helpiez;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.kaushik.helpiez.client.model.CheckEmailModel;
import com.kaushik.helpiez.client.model.EventClientModel;
import com.kaushik.helpiez.client.model.LoginClientModel;
import com.kaushik.helpiez.client.model.NgoClientCategory;
import com.kaushik.helpiez.client.model.NgoClientModel;
import com.kaushik.helpiez.client.model.NgoClientRegistrationModel;
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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController implements ServletContextAware, ServletConfigAware{
	
	@Autowired
	private HttpSession httpSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public static final String SERVER_URI = "http://localhost:8080/helpiez";
	RestTemplate restTemplate = new RestTemplate();
	
	
	private ServletContext servletContext;
	private ServletConfig servletConfig;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Welcome Index! The client locale is {}.", locale);
		return "index";
	}
	
	
	@RequestMapping(value="accountvarificationcontroller", method=RequestMethod.GET)
	public ModelAndView accountvarificationcontroller(@RequestParam("useremail") String email, @RequestParam("tokenId") String token)
	{
		logger.info("token varification start!");
		
		if(email==null || email.equals("") || token.equals("") || token==null)
		{
			return new ModelAndView("login");
		}
		else
		{
			EmailVarificationModel model = new EmailVarificationModel();
			model.setEmailId(email);
			model.setTokenId(token);
			System.out.println("Email :"+email);
			System.out.println("token :"+token);
			Status status = restTemplate.postForObject(SERVER_URI+RestURIConstants.EMAIL_VARIFICATION,model, Status.class);
			String result = "";
			if(status.getStatusCode()==0)
			{
				return new ModelAndView("redirect:/"); 
			}
			else if(status.getStatusCode()==1)
			{
				return new ModelAndView("redirect:getNgoAllDetailController");
			}
		}
		return null;
	}
	
	@RequestMapping(value="useraccountvarificationcontroller", method=RequestMethod.GET)
	public ModelAndView useraccountvarificationcontroller(@RequestParam("useremail") String email, @RequestParam("tokenId") String token)
	{
		logger.info("token varification start!");
		
		if(email==null || email.equals("") || token.equals("") || token==null)
		{
			return new ModelAndView("login");
		}
		else
		{
			EmailVarificationModel model = new EmailVarificationModel();
			model.setEmailId(email);
			model.setTokenId(token);
			System.out.println("Email :"+email);
			System.out.println("token :"+token);
			Status status = restTemplate.postForObject(SERVER_URI+RestURIConstants.EMAIL_VARIFICATION,model, Status.class);
			String result = "";
			if(status.getStatusCode()==0)
			{
				return new ModelAndView("redirect:/"); 
			}
			else if(status.getStatusCode()==1)
			{
				return new ModelAndView("redirect:getUserAllDetailController");
			}
		}
		return null;
	}
	
	@RequestMapping(value = "homeController", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam("lat") String lat, @RequestParam("longi") String longi) {
		logger.info("Welcome home!");
		List<NgoClientModel> list = new ArrayList<NgoClientModel>();
		List<EventClientModel> list1 = new ArrayList<EventClientModel>();
		try
		{
			if(lat==null || lat.equals("") && longi=="" || longi.equals(""))
			{
				ModelAndView modelAndView = new ModelAndView("home");
				modelAndView.addObject("ngoList", null);
				modelAndView.addObject("eventList", null);
				return modelAndView;
			}
			else
			{
				NgoDetailModel ngoDetailModel = new NgoDetailModel();
				ngoDetailModel.setUserLatitude(lat);
				ngoDetailModel.setUserLongitude(longi);
				
				List<LinkedHashMap> ngoList = restTemplate.postForObject(SERVER_URI+RestURIConstants.ALL_NEAR_NGO, ngoDetailModel, List.class);
				
				for(LinkedHashMap map : ngoList){
			    
					NgoClientModel model = new NgoClientModel();
					model.setNgoId((Integer) map.get("ngoId"));
					model.setNgoName((String) map.get("ngoName"));
					model.setNgoCause((String)map.get("ngoCause"));
					model.setNgoImage((String)map.get("ngoImageLogo"));
					System.out.println(model);
			        list.add(model);
			    }
				
				List<LinkedHashMap> eventList = restTemplate.postForObject(SERVER_URI+RestURIConstants.ALL_NEAR_EVENT, ngoDetailModel, List.class);
				
				for(LinkedHashMap map : eventList){
			    
					EventClientModel model = new EventClientModel();
					System.out.println(map.get("ngoEventTitle"));
					model.setEventName((String) map.get("ngoEventTitle"));
					model.setEventId((Integer)map.get("ngoEventId"));
					model.setEventImage((String)map.get("ngoEventImage"));
			        list1.add(model);
			    }
				ModelAndView modelAndView = new ModelAndView("home");
				modelAndView.addObject("ngoList", list);
				modelAndView.addObject("eventList", list1);
				return modelAndView;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("ngoList", list);
		modelAndView.addObject("eventList", list1);
		return modelAndView;
	}
	private List<NgoClientCategory> categoryList()
	{
		
		List<LinkedHashMap> categoryList = restTemplate.getForObject(SERVER_URI+RestURIConstants.ALL_CATEGORY, List.class);
		List<NgoClientCategory> list = new ArrayList<NgoClientCategory>();
		for(LinkedHashMap map : categoryList){
		    
			NgoClientCategory model = new NgoClientCategory();
			model.setNgoCategoryName((String) map.get("categoryName"));
	        list.add(model);
	    }
		return list;
	}
	@RequestMapping(value = "registerDataController", method = RequestMethod.GET)
	public ModelAndView registerDataController() {
		
		List<NgoClientCategory> list = categoryList();
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("categoryList", list);
		return modelAndView;
	}
	
	@RequestMapping(value = "checkNgoEmailController", method = RequestMethod.POST)
	public @ResponseBody String checkNgoEmailController(@ModelAttribute CheckEmailModel checkEmailModel)
	{	
		RestTemplate restTemplate = new RestTemplate();
		NgoEmailModel model = new NgoEmailModel();
		model.setEmailId(checkEmailModel.getEmailId());
		System.out.println(checkEmailModel.getEmailId());
		Status status = restTemplate.postForObject(SERVER_URI+RestURIConstants.CHECK_EMAIL,model, Status.class);
		String result = "";
		if(status.getStatusCode()==1)
		{
			result = "1";
		}
		else if(status.getStatusCode()==0)
		{
			result = "0";
		}
		return result;
	}
	
	@RequestMapping(value = "userLoginDataController", method=RequestMethod.POST)
	public ModelAndView userLoginDataController(@ModelAttribute LoginClientModel loginClientModel)
	{
		logger.info("User Login start!");
		ModelAndView view = new ModelAndView("login");
		String result = "";
		if(loginClientModel.getLoginEmailId().equals("") || loginClientModel.getLoginEmailId()==null)
		{
			result = "Please Enter Email Id";
			view.addObject("error", result);
			return view;
		}
		else if(loginClientModel.getLoginPassword().equals("") || loginClientModel.getLoginPassword()==null)
		{
			result = "Please Enter Password";
			view.addObject("error", result);
			return view;
		}
		else
		{
			LoginStatus status = restTemplate.postForObject(SERVER_URI+RestURIConstants.LOGIN,loginClientModel, LoginStatus.class);
			if(status.getStatusCode().equals(0) || status.getStatusCode()==0)
			{
				result = status.getStatusMessage();
				view.addObject("error", result);
				return view;
			}
			else if(status.getStatusCode().equals(1) || status.getStatusCode()==1)
			{
				if(status.getRoleName().equals("NGO") || status.getRoleName()=="NGO")
				{
					
					httpSession.setAttribute("ngologinId", status.getLoginId());
					httpSession.setAttribute("loginStatus", "true");
					return new ModelAndView("redirect:getNgoAllDetailController");
				}
				else if(status.getRoleName().equals("USER") || status.getRoleName()=="USER")
				{
					httpSession.setAttribute("userloginId", status.getLoginId());
					httpSession.setAttribute("loginStatus", "true");
					return new ModelAndView("redirect:getUserAllDetailController");
				}
					
			}
		}
		return null;
	}
	
	private boolean loginStatus()
	{
		String status = (String) httpSession.getAttribute("loginStatus");
		if(status!=null || status.equals("true") || status=="true")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	@RequestMapping(value = "eventRegistrationController", method = RequestMethod.GET)
	public ModelAndView eventRegistrationController()
	{
		return new ModelAndView("eventregistration");
	}
	
	@RequestMapping(value = "getUserAllDetailController", method = RequestMethod.GET)
	public ModelAndView getUserAllDetailController()
	{
		try
		{
			boolean result = loginStatus();
			if(result == false)
			{
				ModelAndView view = new ModelAndView("login");
				return view;
			}
			else
			{
				Integer id = (Integer) httpSession.getAttribute("userloginId");
				String status = id.toString();
				List<LinkedHashMap> ngoInfo = restTemplate.getForObject(SERVER_URI+"/rest/userinformation/"+status, List.class);
				UserRegistrationPojo model = new UserRegistrationPojo();
				for(LinkedHashMap map : ngoInfo){
					
					model.setUserContactNumber((String) map.get("userContactNumber"));
					model.setUserCountry((String) map.get("userCountry"));
					model.setUserDateofBirth((java.sql.Date) map.get("userDateofBirth"));
					model.setUserEmailId((String) map.get("userEmailId"));
					model.setUserFirstName((String) map.get("userFirstName"));
					model.setUserId((Integer) map.get("ngoName"));
					model.setUserLastName((String) map.get("userLastName"));
				}
				httpSession.setAttribute("userDetails", model);
				ModelAndView view = new ModelAndView("userdashboard");
				return view;
			}
		}
		catch(Exception ex)
		{
			logger.error(""+ex);
			ModelAndView view = new ModelAndView("login");
			return view;
		}
	}
	
	
	@RequestMapping(value = "getNgoAllDetailController", method = RequestMethod.GET)
	public ModelAndView getNgoAllDetailController()
	{
		try
		{
			boolean result = loginStatus();
			if(result == false)
			{
				ModelAndView view = new ModelAndView("login");
				return view;
			}
			else
			{
				Integer id = (Integer) httpSession.getAttribute("ngologinId");
				String status = id.toString();
				List<LinkedHashMap> ngoInfo = restTemplate.getForObject(SERVER_URI+"/rest/ngoinformation/"+status, List.class);
				NgoRegistrationPojo model = new NgoRegistrationPojo();
				for(LinkedHashMap map : ngoInfo){
					
					model.setNgoId((Integer) map.get("ngoId"));
					model.setNgoName((String) map.get("ngoName"));
				    model.setNgoHeadOfficeAddress1((String) map.get("ngoHeadOfficeAddress1"));
				    model.setNgoHeadOfficeAddress2((String) map.get("ngoHeadOfficeAddress2"));
				    model.setNgoHeadOfficeAddressCity((String) map.get("ngoHeadOfficeAddressCity"));
				    model.setNgoHeadOfficeAddressCountry((String) map.get("ngoHeadOfficeAddressCountry"));
				    model.setNgoHeadOfficeAddressPincode((String) map.get("ngoHeadOfficeAddressPincode"));
				    model.setNgoHeadOfficeAddressState((String) map.get("ngoHeadOfficeAddressState"));
				    model.setNgoAlternativeContactNumber((String) map.get("ngoAlternativeContactNumber"));
				    model.setNgoCause((String) map.get("ngoCause"));
				    model.setNgoContactNumber((String) map.get("ngoContactNumber"));
				    model.setNgoEmailId((String) map.get("ngoEmailId"));
				    model.setNgoImageLogo((String) map.get("ngoImageLogo"));
				    model.setNgoLocationLongitude((String) map.get("ngoLocationLongitude"));
				    model.setNgoLocationLatitude((String) map.get("ngoLocationLatitude"));
				}
				httpSession.setAttribute("ngoDetails", model);
				ModelAndView view = new ModelAndView("ngodashboard");
				return view;
			}
		}
		catch(Exception ex)
		{
			logger.error(""+ex);
			ModelAndView view = new ModelAndView("login");
			return view;
		}
	}
	
	@RequestMapping(value = "ngoRegistrationDataController", method = RequestMethod.POST)
	public ModelAndView ngoRegistrationDataController(@ModelAttribute NgoClientRegistrationModel ngoCModel)
	{	
		logger.info("Registration start!");
		try
		{
			
			NgoRegistrationModel model = new NgoRegistrationModel();
			model.setNgoName(ngoCModel.getNgoName());
			model.setNgoCause(ngoCModel.getNgoCause());
			model.setNgoAlternativeContactNumber(ngoCModel.getNgoAlternativeContact());
			model.setNgoCategory(ngoCModel.getNgoCategory());
			model.setNgoContactNumber(ngoCModel.getNgoContact());
			model.setNgoEmailId(ngoCModel.getNgoEmail());
			model.setNgoHeadOfficeAddress1(ngoCModel.getNgoAddressLine1());
			model.setNgoHeadOfficeAddress2(ngoCModel.getNgoAddressLine2());
			model.setNgoHeadOfficeAddressCity(ngoCModel.getNgoAddressLineCity());
			model.setNgoHeadOfficeAddressCountry(ngoCModel.getNgoAddressLineCountry());
			model.setNgoHeadOfficeAddressPincode(ngoCModel.getNgoAddressLinePincode());
			model.setNgoHeadOfficeAddressState(ngoCModel.getNgoAddressLineState());
			//model.setNgoImageLogo(ngoCModel.getNgoImage());
			model.setNgoLocationLatitude(ngoCModel.getNgoLocationLatitude());
			model.setNgoLocationLongitude(ngoCModel.getNgoLocationLongitude());
			Status status = restTemplate.postForObject(SERVER_URI+RestURIConstants.CREATE_NGO,model, Status.class);
			String result = "";
			List<NgoClientCategory> list = categoryList();
			ModelAndView view = new ModelAndView("register");
			view.addObject("categoryList", list);
			
			if(status.getStatusCode()==1)
			{
				result = status.getStatusMessage();
				view.addObject("error", result);
			}
			else if(status.getStatusCode()==2)
			{
				result = status.getStatusMessage();
				view.addObject("success", result);
			}
			else if(status.getStatusCode()==0)
			{
				result = status.getStatusMessage();
				view.addObject("error", result);
			}
			return view;
		}
		catch(Exception e)
		{
			ModelAndView view = new ModelAndView("error");
			return view;
		}
	}
	
	@RequestMapping(value = "userRegistrationDataController", method = RequestMethod.POST)
	public ModelAndView userRegistrationDataController(@ModelAttribute UserRegistrationModel userCModel)
	{	
		logger.info("User Registration start!");
		try
		{
			Status status = restTemplate.postForObject(SERVER_URI+RestURIConstants.CREATE_USER,userCModel, Status.class);
			String result = "";
			ModelAndView view = new ModelAndView("register");
			if(status.getStatusCode()==1)
			{
				result = status.getStatusMessage();
				view.addObject("error", result);
			}
			else if(status.getStatusCode()==2)
			{
				result = status.getStatusMessage();
				view.addObject("success", result);
			}
			else if(status.getStatusCode()==0)
			{
				result = status.getStatusMessage();
				view.addObject("error", result);
			}
			return view;
		}
		catch(Exception e)
		{
			ModelAndView view = new ModelAndView("error");
			return view;
		}
	}
	
	@RequestMapping(value = "eventDataRegistrationController", method = RequestMethod.POST)
	public ModelAndView eventDataRegistrationController(@ModelAttribute NewEventModel model)
	{
		logger.info("Event Registration start!");
		try
		{
			Status status = restTemplate.postForObject(SERVER_URI+RestURIConstants.CREATE_EVENT,model, Status.class);
			String result = "";
			ModelAndView view = new ModelAndView("register");
			if(status.getStatusCode()==1)
			{
				result = status.getStatusMessage();
				view.addObject("success", result);
			}
			else if(status.getStatusCode()==0)
			{
				result = status.getStatusMessage();
				view.addObject("error", result);
			}
			return view;
		}
		catch(Exception e)
		{
			ModelAndView view = new ModelAndView("error");
			return view;
		}
	}
	
	public ServletContext getServletContext() {
		return servletContext;
	}
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		this.servletConfig = servletConfig;
	}
}
