package com.adnan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adnan.entity.Customer;
import com.adnan.entity.Survey;

@Repository
public class SurveyDAOImpl implements SurveyDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Survey> getSurveys() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Survey> theQuery = 
				currentSession.createQuery("from Survey order by name",
											Survey.class);
		
		// execute query and get result list
		List<Survey> surveys = theQuery.getResultList();
				
		// return the results		
		return surveys;
	}

	@Override
	public void saveSurvey(Survey theSurvey) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theSurvey);
		
	}

	@Override
	public Survey getSurvey(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Survey theSurvey = currentSession.get(Survey.class, theId);
		
		return theSurvey;
	}

	@Override
	public void deleteSurvey(int theId){

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Survey where id=:surveyId");
		theQuery.setParameter("surveyId", theId);
		
		theQuery.executeUpdate();		
	}

}











