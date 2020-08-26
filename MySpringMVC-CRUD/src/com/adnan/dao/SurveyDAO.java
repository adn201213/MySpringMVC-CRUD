package com.adnan.dao;

import java.util.List;

import com.adnan.entity.Customer;
import com.adnan.entity.Survey;

public interface SurveyDAO {

	public List<Survey> getSurveys();

	public void saveSurvey(Survey theSurvey);

	public Survey getSurvey(int theId);

	public void deleteSurvey(int theId);
	
}
