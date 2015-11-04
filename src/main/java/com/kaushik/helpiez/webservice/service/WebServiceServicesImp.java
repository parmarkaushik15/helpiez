package com.kaushik.helpiez.webservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaushik.helpiez.client.model.LoginClientModel;
import com.kaushik.helpiez.database.NgoCategoryPojo;
import com.kaushik.helpiez.database.NgoEventPojo;
import com.kaushik.helpiez.database.NgoRegistrationPojo;
import com.kaushik.helpiez.database.UserRegistrationPojo;
import com.kaushik.helpiez.webservice.dao.WebServiceDao;
import com.kaushik.helpiez.webservice.model.EmailVarificationModel;
import com.kaushik.helpiez.webservice.model.NewEventModel;
import com.kaushik.helpiez.webservice.model.NgoDetailModel;
import com.kaushik.helpiez.webservice.model.NgoRegistrationModel;
import com.kaushik.helpiez.webservice.model.UserRegistrationModel;

@Service
@Transactional
public class WebServiceServicesImp implements WebServiceServices{

	@Autowired
	private WebServiceDao webServiceDao;
	
	@Override
	public String registerNgo(NgoRegistrationModel model,String path) {
		return webServiceDao.registerNgo(model,path);
	}

	@Override
	public List<NgoCategoryPojo> getNgoCategoryList() {
		return webServiceDao.getNgoCategoryList();
	}

	@Override
	public List<NgoRegistrationPojo> getNgoList() {
		return webServiceDao.getNgoList();
	}

	@Override
	public List<NgoRegistrationPojo> getNearNgoList(NgoDetailModel model) {
		return webServiceDao.getNearNgoList(model);
	}

	@Override
	public List<NgoEventPojo> getNearEventList(NgoDetailModel model) {
		return webServiceDao.getNearEventList(model);
	}

	@Override
	public List<NgoEventPojo> getNgoEventList(int ngoId) {
		return webServiceDao.getNgoEventList(ngoId);
	}

	@Override
	public String checkNgoEmail(String emailId) {
		return webServiceDao.checkNgoEmail(emailId);
	}

	@Override
	public boolean ngoEmailVarifiaction(EmailVarificationModel model) {
		return webServiceDao.ngoEmailVarifiaction(model);
	}

	@Override
	public String loginUser(LoginClientModel model) {
		return webServiceDao.loginUser(model);
	}

	@Override
	public List<NgoRegistrationPojo> getNgoInfo(String loginId) {
		return webServiceDao.getNgoInfo(loginId);
	}

	@Override
	public String registerUser(UserRegistrationModel model) {
		return webServiceDao.registerUser(model);
	}

	@Override
	public List<UserRegistrationPojo> getUserInfo(String loginId) {
		return null;
	}

	@Override
	public String registerEvent(NewEventModel model, String path) {
		return webServiceDao.registerEvent(model, path);
	}

}
