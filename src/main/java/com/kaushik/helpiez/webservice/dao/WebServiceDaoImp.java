package com.kaushik.helpiez.webservice.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.stream.util.EventReaderDelegate;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.kaushik.helpiez.client.model.LoginClientModel;
import com.kaushik.helpiez.database.LoginPojo;
import com.kaushik.helpiez.database.NgoCategoryPojo;
import com.kaushik.helpiez.database.NgoEventPojo;
import com.kaushik.helpiez.database.NgoRegistrationPojo;
import com.kaushik.helpiez.database.RolePojo;
import com.kaushik.helpiez.database.UserRegistrationPojo;
import com.kaushik.helpiez.database.UserSubscriptionPojo;
import com.kaushik.helpiez.webservice.MailUtility;
import com.kaushik.helpiez.webservice.PasswordUtility;
import com.kaushik.helpiez.webservice.model.EmailVarificationModel;
import com.kaushik.helpiez.webservice.model.NewEventModel;
import com.kaushik.helpiez.webservice.model.NgoDetailModel;
import com.kaushik.helpiez.webservice.model.NgoRegistrationModel;
import com.kaushik.helpiez.webservice.model.UserRegistrationModel;

@Repository
public class WebServiceDaoImp implements WebServiceDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public String registerNgo(NgoRegistrationModel model,String path) {
		try
		{
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			List<NgoCategoryPojo> list = null;
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NgoCategoryPojo.class);
			criteria.add(Restrictions.eq("categoryName", model.getNgoCategory()));
			list = criteria.list();
			if(list != null || list.size()>0)
			{
				NgoCategoryPojo ngoCategoryPojo = list.get(0);
				List<LoginPojo> ngoRegistrationPojos = null;
				Criteria criteria2 = sessionFactory.getCurrentSession().createCriteria(LoginPojo.class);
				criteria2.add(Restrictions.eq("loginEmail",model.getNgoEmailId()));
				ngoRegistrationPojos = criteria2.list();
				if(ngoRegistrationPojos.size()==0 || ngoRegistrationPojos==null)
				{
					String password = PasswordUtility.generatePassword();
					String token = PasswordUtility.tokenGeneration();
					MailUtility mailUtility = new MailUtility();
					String title = "Auto Confirmation";
					String body = "username :"+model.getNgoEmailId()+"\n password :"+password;
					System.out.println(model.getNgoEmailId());
					System.out.println(password);
					boolean result = true;
					
					MimeMessage mimeMessage = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
					String htmlMsg = "<table cellspacing='0' cellpadding='0' style='padding:30px 10px;width:100%;font-family:arial;background:rgb(238,238,238)><tbody><tr>"
							+ "<td><table align='center' cellspacing='0' style='max-width:650px;min-width:320px'><tbody><tr>"
							+ "<td style='text-align:left;padding-bottom:14px'> <img src='https://lh3.googleusercontent.com/-viuzRqS_BwY/VRGDGIFGhJI/AAAAAAAAANw/-WsK-872VAQ/w1044-h267-no/Helpiez.png' align='left' alt='Helpiez' style='width:125px'></td></tr><tr>"
							+ "<td align='center' style='border:1px solid rgb(228,228,228);padding:50px 30px;background:rgb(255,255,255)'><div><div><div></div></div></div>"
							+ "<table align='center'><tbody><tr><td style='border-bottom-width:1px;border-bottom-style:solid;border-bottom-color:rgb(223,223,208);color:rgb(102,102,102);text-align:center;padding-bottom:30px'><table align='center' style='margin:auto'>"
							+ "<tbody><tr><td style='color:rgb(102,102,102);font-size:20px;font-weight:bold;text-align:center;font-family:arial'>"
							+ "Hi "+model.getNgoName()+", Welcome to Helpiez!<br><br>"
							+ "Your Username :"+model.getNgoEmailId()+"<br>"
							+ "Your Password : <h3><b><i>"+password+"</i></b><h3>"
							+ "</td></tr></tbody></table>"
							+ "<table align='center' style='margin:auto'><tbody><tr><td style='color:rgb(102,102,102);font-size:16px;padding-bottom:30px;text-align:center;font-family:arial'>"
							+ "Are you ready to get started?"
							+ "</td></tr></tbody></table>"
						    + "<table align='center' style='margin:auto'><tbody><tr><td style='border:1px solid rgb(187,51,51);border-radius:3px;text-align:center;background-color:rgb(187,51,51)'>"
							+ "<a href='http://localhost:8080/helpiez/accountvarificationcontroller?useremail="+model.getNgoEmailId()+"&amp;tokenId="+token+"' style='padding:16px 20px;display:block;text-decoration:none;color:rgb(255,255,255);font-size:16px;text-align:center;font-family:arial;font-weight:bold' target='_blank'>ACTIVATE YOUR ACCOUNT</a>"		
							+ "</td></tr></tbody></table></td></tr><tr>"
							+ "<td style='color:rgb(170,170,170);padding:15px;font-size:11px;line-height:15px;text-align:left'><div style='color:rgb(170,170,170);padding-bottom:15px;font-family:arial'>"
							+ "If clicking the link above does not work, copy and paste the following URL in a new browser window: <a href='http://localhost:8080/helpiez/accountvarificationcontroller?useremail="+model.getNgoEmailId()+"&amp;tokenId="+token+"' style='color:rgb(187,51,51)' target='_blank'>http://localhost:8080/helpiez/accountvarificationcontroller?useremail="+model.getNgoEmailId()+"&amp;tokenId="+token+"</a></div>"
							+ "<div style='color:rgb(170,170,170);font-family:arial'>"
							+ "It is also a good idea to add <a style='color:rgb(170,170,170)'>admin@helpiez.org</a> to your address book to ensure that you receive our messages (no spam, we promise!)."
							+ "</div></td></tr></tbody></table>	</td></tr><tr>"
                            + "<td align='center' style='border-right-width:1px;border-bottom-width:1px;border-left-width:1px;border-style:none solid solid;border-right-color:rgb(228,228,228);border-bottom-color:rgb(228,228,228);border-left-color:rgb(228,228,228);padding:24px 10px;background:rgb(99,99,99)'>"
                            + "<table align='center' style='width:100%;max-width:650px'><tbody><tr>"
                            +  "<td style='font-size:20px;line-height:27px;text-align:center;max-width:650px;padding-bottom:20px'>"
                            +  "<a href='http://www.helpiez.org/blog' style='text-decoration:none;color:white' target='_blank'>"
                            +  "Read articles that matter on our <span style='color:rgb(255,75,87)'>Blog.</span></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
                            +  "<tr><td><table align='center' style='max-width:650px'><tbody><tr>"
							+  "<td style='color:rgb(180,180,180);font-size:11px;padding-top:10px;line-height:15px;font-family:arial'>"
							+  "<a href='http://www.Helpiez.org' target='_blank'>www.Helpiez.org</a></td></tr></tbody></table></td></tr></tbody></table>";
					
					mimeMessage.setContent(htmlMsg, "text/html");
					helper.setTo(model.getNgoEmailId());
					helper.setSubject("This is the test message for testing gmail smtp server using spring mail");
					helper.setFrom("kaushikparmar123456@gmail.com");
					mailSender.send(mimeMessage);
					
					//boolean result = mailUtility.mailSend(model.getNgoEmailId(), title, body);
					if(result == true)
					{
						 String key = PasswordUtility.generateKey();
						 String digestPassword = PasswordUtility.digestPassword(password, key);
						 
						 Criteria criteria3 = sessionFactory.getCurrentSession().createCriteria(RolePojo.class);
						 criteria3.add(Restrictions.eq("roleName", "NGO"));
						 List<RolePojo> rolePojos = criteria3.list();
						 if(rolePojos.size()>0)
						 {
							 RolePojo rolePojo = rolePojos.get(0);
							 LoginPojo loginPojo = new LoginPojo();
							 loginPojo.setLoginEmail(model.getNgoEmailId());
							 loginPojo.setLoginFirstTimeStatus(token);
							 loginPojo.setLoginLastDateTime(null);
							 loginPojo.setLoginPassword(digestPassword);
							 loginPojo.setLoginPasswordSalt(key);
							 loginPojo.setLoginStatus("DEACTIVE");
							 loginPojo.setRolePojo(rolePojo);
							 
							 NgoRegistrationPojo registrationPojo = new NgoRegistrationPojo();
							 registrationPojo.setLoginPojo(loginPojo);
							 registrationPojo.setNgoAlternativeContactNumber(model.getNgoAlternativeContactNumber());
							 registrationPojo.setNgoCategoryPojo(ngoCategoryPojo);
							 registrationPojo.setNgoCause(model.getNgoCause());
							 registrationPojo.setNgoContactNumber(model.getNgoContactNumber());
							 registrationPojo.setNgoEmailId(model.getNgoEmailId());
							 registrationPojo.setNgoHeadOfficeAddress1(model.getNgoHeadOfficeAddress1());
							 registrationPojo.setNgoHeadOfficeAddress2(model.getNgoHeadOfficeAddress2());
							 registrationPojo.setNgoHeadOfficeAddressCity(model.getNgoHeadOfficeAddressCity());
							 registrationPojo.setNgoHeadOfficeAddressCountry(model.getNgoHeadOfficeAddressCountry());
							 registrationPojo.setNgoHeadOfficeAddressPincode(model.getNgoHeadOfficeAddressPincode());
							 registrationPojo.setNgoHeadOfficeAddressState(model.getNgoHeadOfficeAddressState());
							 registrationPojo.setNgoImageLogo(path);
							 registrationPojo.setNgoLocationLatitude(model.getNgoLocationLatitude());
							 registrationPojo.setNgoLocationLongitude(model.getNgoLocationLongitude());
							 registrationPojo.setNgoName(model.getNgoName());
							 registrationPojo.setNgoRegistrationDate(sqlDate);
							 registrationPojo.setNgoStatus("ACTIVE");
							
							 sessionFactory.getCurrentSession().save(loginPojo);
							 sessionFactory.getCurrentSession().save(registrationPojo);
							 return "2";
							 
						 }
					}
				}
				else
				{
					return "1";
				}
			}
			
		}
		catch(Exception ex)
		{		
			return "0";
		}
		return null;
	}

	@Override
	public List<NgoCategoryPojo> getNgoCategoryList() {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NgoCategoryPojo.class);
		criteria.add(Restrictions.eq("categoryStatus","ACTIVE"));
		List<NgoCategoryPojo> list = null;
		list = criteria.list();
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<NgoRegistrationPojo> getNgoList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NgoRegistrationPojo.class);
		criteria.add(Restrictions.eq("ngoStatus","ACTIVE"));
		List<NgoRegistrationPojo> list = null;
		list = criteria.list();
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public List<NgoRegistrationPojo> getNearNgoList(NgoDetailModel model) {
		
		String queryString = "SELECT ngoid, (6371 * acos (cos(radians("
                + model.getUserLatitude()
                + ")) * cos(radians(ngoLocationLatitude)) * cos(radians(ngoLocationLongitude) - radians("
                + model.getUserLongitude()
                + "))  + sin(radians("
                + model.getUserLatitude()
                + ")) * sin(radians(ngoLocationLatitude)))) AS distance FROM NgoDetail HAVING distance < 50"
                 + " ORDER BY distance";
        Query  query = sessionFactory.getCurrentSession().createSQLQuery(queryString);
        List<NgoRegistrationPojo> ngoRegistrationPojos = null;
		List<NgoRegistrationPojo> registrationPojos = new ArrayList<NgoRegistrationPojo>();
		
        List<Object[]> list = null;
        list = query.list();
        List<Integer> idList = new ArrayList<Integer>();
        for (Object[] obj : list) {
            Integer ngoid = (Integer) obj[0];
           
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NgoRegistrationPojo.class);
			criteria.add(Restrictions.eq("ngoId",ngoid));
			criteria.add(Restrictions.eq("ngoStatus","ACTIVE"));
			ngoRegistrationPojos = criteria.list();
			NgoRegistrationPojo registrationPojo = ngoRegistrationPojos.get(0);
			registrationPojos.add(registrationPojo);
        }

		
		return registrationPojos;
	}

	@Override
	public List<NgoEventPojo> getNearEventList(NgoDetailModel model) {
		String queryString = "SELECT ngoEventId, (6371 * acos (cos(radians("
                + model.getUserLatitude()
                + ")) * cos(radians(ngoEventLocationLatitude)) * cos(radians(ngoEventLocationLongitude) - radians("
                + model.getUserLongitude()
                + "))  + sin(radians("
                + model.getUserLatitude()
                + ")) * sin(radians(ngoEventLocationLatitude)))) AS distance FROM NgoEvent HAVING distance < 50"
                 + " ORDER BY distance";
        Query  query = sessionFactory.getCurrentSession().createSQLQuery(queryString);
        List<NgoEventPojo> ngoRegistrationPojos = null;
		List<NgoEventPojo> registrationPojos = new ArrayList<NgoEventPojo>();
		
        List<Object[]> list = null;
        list = query.list();
        List<Integer> idList = new ArrayList<Integer>();
        for (Object[] obj : list) {
            Integer eventId = (Integer) obj[0];
           	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NgoEventPojo.class);
				criteria.add(Restrictions.eq("ngoEventId",eventId));
				criteria.add(Restrictions.eq("ngoEventStatus","ACTIVE"));
				ngoRegistrationPojos = criteria.list();
				NgoEventPojo registrationPojo = ngoRegistrationPojos.get(0);
				registrationPojos.add(registrationPojo);
				
			
		}
		return registrationPojos;
	}

	@Override
	public List<NgoEventPojo> getNgoEventList(int ngoId) {
		
		NgoRegistrationPojo ngoRegistrationPojo = new NgoRegistrationPojo();
		ngoRegistrationPojo.setNgoId(ngoId);
		
		List<NgoEventPojo> ngoEventPojos = null;
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NgoEventPojo.class);
		criteria.add(Restrictions.eq("ngoRegistrationPojo",ngoRegistrationPojo));
		criteria.add(Restrictions.eq("ngoEventStatus","ACTIVE"));
		ngoEventPojos = criteria.list();
		
		return ngoEventPojos;
	}

	@Override
	public String checkNgoEmail(String emailId) {
		System.out.println("---"+emailId);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginPojo.class);
		criteria.add(Restrictions.eq("loginEmail",emailId));
		List<LoginPojo> list = null;
		list = criteria.list();
		if(list.size()==0)
		{
			return "No";
		}
		else
		{
			return "Yes";
		}
	}

	@Override
	public boolean ngoEmailVarifiaction(EmailVarificationModel model) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginPojo.class);
		criteria.add(Restrictions.eq("loginEmail", model.getEmailId()));
		criteria.add(Restrictions.eq("loginFirstTimeStatus", model.getTokenId()));
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		List<LoginPojo> list = null;
		list = criteria.list();
		if(list.size()==0)
		{
			return false;
		}
		else
		{
			Query query = sessionFactory.getCurrentSession().createQuery("update com.kaushik.helpiez.database.LoginPojo set loginStatus = :status, loginLastDateTime= :loginDate where loginEmail= :email");
			query.setParameter("status", "ACTIVE");
			query.setParameter("loginDate", sqlDate);
			query.setParameter("email",model.getEmailId());
			int result1 = 0;
			result1 = query.executeUpdate();
			if(result1 ==  0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}

	@Override
	public String loginUser(LoginClientModel model) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginPojo.class);
		criteria.add(Restrictions.eq("loginEmail", model.getLoginEmailId()));
		List<LoginPojo> list = null;
		list = criteria.list();
		if(list.size()==0 || list==null)
		{
			return "notemail";
		}
		else
		{
			LoginPojo loginPojo = list.get(0);
			if(loginPojo.getLoginStatus().equals("ACTIVE"))
			{
				String digestPass = PasswordUtility.digestPassword(model.getLoginPassword(), loginPojo.getLoginPasswordSalt());
				if(loginPojo.getLoginPassword().equals(digestPass) || loginPojo.getLoginPassword()==digestPass)
				{
					RolePojo rolePojo = loginPojo.getRolePojo();
					return loginPojo.getLoginId().toString()+"-"+rolePojo.getRoleName();
				}
				else
				{
					return "notpass";
				}
			}
			else
			{
				return "notactive";
			}
		}
	}

	@Override
	public List<NgoRegistrationPojo> getNgoInfo(String loginId) {
		LoginPojo loginPojo = new LoginPojo();
		loginPojo.setLoginId(Integer.parseInt(loginId));
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NgoRegistrationPojo.class);
		criteria.add(Restrictions.eq("loginPojo", loginPojo));
		List<NgoRegistrationPojo> list = null;
		list = criteria.list();
		if(list.size()==0 || list == null)
			return null;
		else
			return list;
	}

	@Override
	public String registerUser(UserRegistrationModel model) {
		try
		{
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				List<LoginPojo> ngoRegistrationPojos = null;
				Criteria criteria2 = sessionFactory.getCurrentSession().createCriteria(LoginPojo.class);
				criteria2.add(Restrictions.eq("loginEmail",model.getUserEmail()));
				ngoRegistrationPojos = criteria2.list();
				if(ngoRegistrationPojos.size()==0 || ngoRegistrationPojos==null)
				{
					String password = PasswordUtility.generatePassword();
					String token = PasswordUtility.tokenGeneration();
					MailUtility mailUtility = new MailUtility();
					String title = "Auto Confirmation";
					System.out.println(model.getUserEmail());
					System.out.println(password);
					boolean result = true;
					
					MimeMessage mimeMessage = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
					String htmlMsg = "<table cellspacing='0' cellpadding='0' style='padding:30px 10px;width:100%;font-family:arial;background:rgb(238,238,238)><tbody><tr>"
							+ "<td><table align='center' cellspacing='0' style='max-width:650px;min-width:320px'><tbody><tr>"
							+ "<td style='text-align:left;padding-bottom:14px'> <img src='https://lh3.googleusercontent.com/-viuzRqS_BwY/VRGDGIFGhJI/AAAAAAAAANw/-WsK-872VAQ/w1044-h267-no/Helpiez.png' align='left' alt='Helpiez' style='width:125px'></td></tr><tr>"
							+ "<td align='center' style='border:1px solid rgb(228,228,228);padding:50px 30px;background:rgb(255,255,255)'><div><div><div></div></div></div>"
							+ "<table align='center'><tbody><tr><td style='border-bottom-width:1px;border-bottom-style:solid;border-bottom-color:rgb(223,223,208);color:rgb(102,102,102);text-align:center;padding-bottom:30px'><table align='center' style='margin:auto'>"
							+ "<tbody><tr><td style='color:rgb(102,102,102);font-size:20px;font-weight:bold;text-align:center;font-family:arial'>"
							+ "Hi "+model.getUserFirstname()+", Welcome to Helpiez!<br><br>"
							+ "Your Username :"+model.getUserEmail()+"<br>"
							+ "Your Password : <h3><b><i>"+password+"</i></b><h3>"
							+ "</td></tr></tbody></table>"
							+ "<table align='center' style='margin:auto'><tbody><tr><td style='color:rgb(102,102,102);font-size:16px;padding-bottom:30px;text-align:center;font-family:arial'>"
							+ "Are you ready to get started?"
							+ "</td></tr></tbody></table>"
						    + "<table align='center' style='margin:auto'><tbody><tr><td style='border:1px solid rgb(187,51,51);border-radius:3px;text-align:center;background-color:rgb(187,51,51)'>"
							+ "<a href='http://localhost:8080/helpiez/useraccountvarificationcontroller?useremail="+model.getUserEmail()+"&amp;tokenId="+token+"' style='padding:16px 20px;display:block;text-decoration:none;color:rgb(255,255,255);font-size:16px;text-align:center;font-family:arial;font-weight:bold' target='_blank'>ACTIVATE YOUR ACCOUNT</a>"		
							+ "</td></tr></tbody></table></td></tr><tr>"
							+ "<td style='color:rgb(170,170,170);padding:15px;font-size:11px;line-height:15px;text-align:left'><div style='color:rgb(170,170,170);padding-bottom:15px;font-family:arial'>"
							+ "If clicking the link above does not work, copy and paste the following URL in a new browser window: <a href='http://localhost:8080/helpiez/useraccountvarificationcontroller?useremail="+model.getUserEmail()+"&amp;tokenId="+token+"' style='color:rgb(187,51,51)' target='_blank'>http://localhost:8080/helpiez/useraccountvarificationcontroller?useremail="+model.getUserEmail()+"&amp;tokenId="+token+"</a></div>"
							+ "<div style='color:rgb(170,170,170);font-family:arial'>"
							+ "It is also a good idea to add <a style='color:rgb(170,170,170)'>admin@helpiez.org</a> to your address book to ensure that you receive our messages (no spam, we promise!)."
							+ "</div></td></tr></tbody></table>	</td></tr><tr>"
                            + "<td align='center' style='border-right-width:1px;border-bottom-width:1px;border-left-width:1px;border-style:none solid solid;border-right-color:rgb(228,228,228);border-bottom-color:rgb(228,228,228);border-left-color:rgb(228,228,228);padding:24px 10px;background:rgb(99,99,99)'>"
                            + "<table align='center' style='width:100%;max-width:650px'><tbody><tr>"
                            +  "<td style='font-size:20px;line-height:27px;text-align:center;max-width:650px;padding-bottom:20px'>"
                            +  "<a href='http://www.helpiez.org/blog' style='text-decoration:none;color:white' target='_blank'>"
                            +  "Read articles that matter on our <span style='color:rgb(255,75,87)'>Blog.</span></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
                            +  "<tr><td><table align='center' style='max-width:650px'><tbody><tr>"
							+  "<td style='color:rgb(180,180,180);font-size:11px;padding-top:10px;line-height:15px;font-family:arial'>"
							+  "<a href='http://www.Helpiez.org' target='_blank'>www.Helpiez.org</a></td></tr></tbody></table></td></tr></tbody></table>";
					
					mimeMessage.setContent(htmlMsg, "text/html");
					helper.setTo(model.getUserEmail());
					helper.setSubject("Auto Conformation");
					helper.setFrom("kaushikparmar123456@gmail.com");
					mailSender.send(mimeMessage);
					if(result == true)
					{
						 String key = PasswordUtility.generateKey();
						 String digestPassword = PasswordUtility.digestPassword(password, key);
						 
						 Criteria criteria3 = sessionFactory.getCurrentSession().createCriteria(RolePojo.class);
						 criteria3.add(Restrictions.eq("roleName", "USER"));
						 List<RolePojo> rolePojos = criteria3.list();
						 if(rolePojos.size()>0)
						 {
							 RolePojo rolePojo = rolePojos.get(0);
							 LoginPojo loginPojo = new LoginPojo();
							 loginPojo.setLoginEmail(model.getUserEmail());
							 loginPojo.setLoginFirstTimeStatus(token);
							 loginPojo.setLoginLastDateTime(null);
							 loginPojo.setLoginPassword(digestPassword);
							 loginPojo.setLoginPasswordSalt(key);
							 loginPojo.setLoginStatus("DEACTIVE");
							 loginPojo.setRolePojo(rolePojo);
							 
							Date date1 = new Date(model.getUserDateofBirth());
							java.sql.Date dateofBirth = new java.sql.Date(date1.getTime());
							 
							 UserRegistrationPojo registrationPojo = new UserRegistrationPojo();
							 registrationPojo.setUserContactNumber(model.getUserContactNumber());
							 registrationPojo.setUserCountry(model.getUserCountry());
							 registrationPojo.setUserDateofBirth(dateofBirth);
							 registrationPojo.setUserEmailId(model.getUserEmail());
							 registrationPojo.setUserFirstName(model.getUserFirstname());
							 registrationPojo.setUserLastName(model.getUserLastName());
							 registrationPojo.setUserRegistrationDate(sqlDate);
							 registrationPojo.setUserStatus("ACTIVE");
							 registrationPojo.setLoginPojo(loginPojo);
							
							 sessionFactory.getCurrentSession().save(loginPojo);
							 sessionFactory.getCurrentSession().save(registrationPojo);
							 return "2";
							 
						 }
					}
				}
				else
				{
					return "1";
				}
			
			
		}
		catch(Exception ex)
		{		
			return "0";
		}
		return null;
	}

	@Override
	public List<UserRegistrationPojo> getUserInfo(String loginId) {
		LoginPojo loginPojo = new LoginPojo();
		loginPojo.setLoginId(Integer.parseInt(loginId));
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserRegistrationPojo.class);
		criteria.add(Restrictions.eq("loginPojo", loginPojo));
		List<UserRegistrationPojo> list = null;
		list = criteria.list();
		if(list.size()==0 || list == null)
			return null;
		else
			return list;
	}

	@Override
	public String registerEvent(NewEventModel model, String path) {
		try
		{
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			if(model.getNgoId().equals("") || model.getNgoId()=="")
			{
				return "0";
			}
			else
			{
				NgoRegistrationPojo pojo = new NgoRegistrationPojo();
				pojo.setNgoId(Integer.parseInt(model.getNgoId()));
				
				List<UserSubscriptionPojo> list = null;
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserSubscriptionPojo.class);
				criteria.add(Restrictions.eq("ngoRegistrationPojo", pojo));
				list = criteria.list();
				int size = list.size();
				String[] mailId = new String[size];
				InternetAddress[] mailTo = new InternetAddress[mailId.length];
				int index = 0;
				Iterator<UserSubscriptionPojo> iterator = list.iterator();
				while (iterator.hasNext()) {
					UserSubscriptionPojo userSubscriptionPojo = (UserSubscriptionPojo) iterator.next();
					UserRegistrationPojo userRegistrationPojo = userSubscriptionPojo.getUserRegistrationPojo();
					mailId[index] = userRegistrationPojo.getUserEmailId();
					index++;
				}
				for (int i = 0; i < mailId.length; i++)
				{
					mailTo[i] = new InternetAddress(mailId[i]);
				}
				
				Date date1 = new Date(model.getEventDate());
				java.sql.Date eventDate = new java.sql.Date(date1.getTime());
				
				
				NgoEventPojo ngoEventPojo = new NgoEventPojo();
				ngoEventPojo.setNgoEventDate(eventDate);
				ngoEventPojo.setNgoEventDescription(model.getEventDescription());
				ngoEventPojo.setNgoEventImage(path);
				ngoEventPojo.setNgoEventLocationAddress(model.getEventAddress());
				ngoEventPojo.setNgoEventLocationAddressCity(model.getEventAddressCity());
				ngoEventPojo.setNgoEventLocationAddressCountry(model.getEventAddressCountry());
				ngoEventPojo.setNgoEventLocationAddressPincode(model.getEventAddressPincode());
				ngoEventPojo.setNgoEventLocationAddressState(model.getEventAddressState());
				ngoEventPojo.setNgoEventLocationLatitude(model.getEventAddressLatitude());
				ngoEventPojo.setNgoEventLocationLongitude(model.getEventAddressLongitude());
				ngoEventPojo.setNgoEventOrganizerAlternativeContactNumber(model.getEventAlternativeContact());
				ngoEventPojo.setNgoEventOrganizerContactNumber(model.getEventOrganizerContact());
				ngoEventPojo.setNgoEventOrganizerEmail(model.getEventOrganizerEmail());
				ngoEventPojo.setNgoEventOrganizerName(model.getEventOrganizerName());
				ngoEventPojo.setNgoEventPostDate(sqlDate);
				ngoEventPojo.setNgoEventStatus("ACTIVE");
				ngoEventPojo.setNgoEventTitle(model.getEventTitle());
				ngoEventPojo.setNgoRegistrationPojo(pojo);
				
				sessionFactory.getCurrentSession().save(ngoEventPojo);
				
				MimeMessage mimeMessage = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
				String htmlMsg = "<table cellspacing='0' cellpadding='0' style='padding:30px 10px;width:100%;font-family:arial;background:rgb(238,238,238)><tbody><tr>"
						+ "<td><table align='center' cellspacing='0' style='max-width:650px;min-width:320px'><tbody><tr>"
						+ "<td style='text-align:left;padding-bottom:14px'> <img src='https://lh3.googleusercontent.com/-viuzRqS_BwY/VRGDGIFGhJI/AAAAAAAAANw/-WsK-872VAQ/w1044-h267-no/Helpiez.png' align='left' alt='Helpiez' style='width:125px'></td></tr><tr>"
						+ "<td align='center' style='border:1px solid rgb(228,228,228);padding:50px 30px;background:rgb(255,255,255)'><div><div><div></div></div></div>"
						+ "<table align='center'><tbody><tr><td style='border-bottom-width:1px;border-bottom-style:solid;border-bottom-color:rgb(223,223,208);color:rgb(102,102,102);text-align:center;padding-bottom:30px'><table align='center' style='margin:auto'>"
						+ "<tbody><tr><td style='color:rgb(102,102,102);font-size:20px;font-weight:bold;text-align:center;font-family:arial'>"
						+ "Hi , Welcome to Helpiez!<br><br>"
						+ "</td></tr></tbody></table>"
						+ "<table align='center' style='margin:auto'><tbody><tr><td style='color:rgb(102,102,102);font-size:16px;padding-bottom:30px;text-align:center;font-family:arial'>"
						+ "Are you ready to get started?"
						+ "</td></tr></tbody></table>"
					    + "<table align='center' style='margin:auto'><tbody><tr><td style='border:1px solid rgb(187,51,51);border-radius:3px;text-align:center;background-color:rgb(187,51,51)'>"
						+ "<a href='http://localhost:8080/helpiez/ style='padding:16px 20px;display:block;text-decoration:none;color:rgb(255,255,255);font-size:16px;text-align:center;font-family:arial;font-weight:bold' target='_blank'>PARTICIPATE NOW</a>"		
						+ "</td></tr></tbody></table></td></tr><tr>"
						+ "<td style='color:rgb(170,170,170);padding:15px;font-size:11px;line-height:15px;text-align:left'><div style='color:rgb(170,170,170);padding-bottom:15px;font-family:arial'>"
						+ "If clicking the link above does not work, copy and paste the following URL in a new browser window: <a href='http://localhost:8080/helpiez/ style='color:rgb(187,51,51)' target='_blank'>http://localhost:8080/helpiez/</a></div>"
						+ "<div style='color:rgb(170,170,170);font-family:arial'>"
						+ "It is also a good idea to add <a style='color:rgb(170,170,170)'>admin@helpiez.org</a> to your address book to ensure that you receive our messages (no spam, we promise!)."
						+ "</div></td></tr></tbody></table>	</td></tr><tr>"
                        + "<td align='center' style='border-right-width:1px;border-bottom-width:1px;border-left-width:1px;border-style:none solid solid;border-right-color:rgb(228,228,228);border-bottom-color:rgb(228,228,228);border-left-color:rgb(228,228,228);padding:24px 10px;background:rgb(99,99,99)'>"
                        + "<table align='center' style='width:100%;max-width:650px'><tbody><tr>"
                        +  "<td style='font-size:20px;line-height:27px;text-align:center;max-width:650px;padding-bottom:20px'>"
                        +  "<a href='http://www.helpiez.org/blog' style='text-decoration:none;color:white' target='_blank'>"
                        +  "Read articles that matter on our <span style='color:rgb(255,75,87)'>Blog.</span></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
                        +  "<tr><td><table align='center' style='max-width:650px'><tbody><tr>"
						+  "<td style='color:rgb(180,180,180);font-size:11px;padding-top:10px;line-height:15px;font-family:arial'>"
						+  "<a href='http://www.Helpiez.org' target='_blank'>www.Helpiez.org</a></td></tr></tbody></table></td></tr></tbody></table>";
				
				mimeMessage.setContent(htmlMsg, "text/html");
				helper.setTo(mailTo);
				helper.setSubject("Event Invitation");
				helper.setFrom("kaushikparmar123456@gmail.com");
				mailSender.send(mimeMessage);
				return "1";
			}
		}
		catch(Exception ex)
		{		
			return "0";
		}
	}
}
