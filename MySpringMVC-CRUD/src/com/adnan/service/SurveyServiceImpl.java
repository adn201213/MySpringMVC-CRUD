package com.adnan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adnan.dao.SurveyDAO;
import com.adnan.entity.Customer;
import com.adnan.entity.Survey;

@Service
public class SurveyServiceImpl implements SurveyService {

	// need to inject customer dao
	@Autowired
	private SurveyDAO surveyDAO;
	
	@Override
	@Transactional
	public List<Survey> getSurveys() {
		return surveyDAO.getSurveys();
	}

	@Override
	@Transactional
	public void saveSurvey(Survey theSurvey) {

		surveyDAO.saveSurvey(theSurvey);
	}

	@Override
	@Transactional
	public Survey getSurvey(int theId) {
		
		return surveyDAO.getSurvey(theId);
	}

	@Override
	@Transactional
	public void deleteSurvey(int theId) {
		
		surveyDAO.deleteSurvey(theId);
	}
}





