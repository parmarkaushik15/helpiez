package com.kaushik.helpiez.webservice.dao;

import java.util.List;
import java.util.Map;

import com.kaushik.helpiez.client.model.LoginClientModel;
import com.kaushik.helpiez.database.NgoCategoryPojo;
import com.kaushik.helpiez.database.NgoEventPojo;
import com.kaushik.helpiez.database.NgoRegistrationPojo;
import com.kaushik.helpiez.database.UserRegistrationPojo;
import com.kaushik.helpiez.webservice.model.EmailVarificationModel;
import com.kaushik.helpiez.webservice.model.NewEventModel;
import com.kaushik.helpiez.webservice.model.NgoDetailModel;
import com.kaushik.helpiez.webservice.model.NgoRegistrationModel;
import com.kaushik.helpiez.webservice.model.UserRegistrationModel;

public interface WebServiceDao {
	public String registerNgo(NgoRegistrationModel model,String path);

	public List<NgoCategoryPojo> getNgoCategoryList();
	public List<NgoRegistrationPojo> getNgoList();
	public List<NgoRegistrationPojo> getNearNgoList(NgoDetailModel model);
	public List<NgoEventPojo> getNearEventList(NgoDetailModel model);
	public List<NgoEventPojo> getNgoEventList(int ngoId);
	public String checkNgoEmail(String emailId);
	public boolean ngoEmailVarifiaction(EmailVarificationModel model);
	public String loginUser(LoginClientModel model);
	public List<NgoRegistrationPojo> getNgoInfo(String loginId);
	public String registerUser(UserRegistrationModel model);
	public List<UserRegistrationPojo> getUserInfo(String loginId);
	public String registerEvent(NewEventModel model, String path);
}
