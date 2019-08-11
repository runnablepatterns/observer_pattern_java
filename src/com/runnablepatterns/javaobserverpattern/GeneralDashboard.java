package com.runnablepatterns.javaobserverpattern;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to display General Dahsboard details
 * This class is one of the observers of Survey Data
 * This time we are implementing Observer interface
 */
public class GeneralDashboard implements Observer {

	/**
	 * Reference to Subject to be able to register or unsubscribe from the list
	 */
	private Observable subject;
	
	/**
	 * Overloaded constructor to define which subject will be use
	 * @param _subject The subject to use for notifications
	 */
	public GeneralDashboard(Observable _subject) {
		this.subject = _subject;
		// add this class as one observer
		this.subject.addObserver(this);
	}
	
	@Override
	public void update(Observable _subject, Object arg) {
		if(_subject instanceof SurveyData) {
			// set the subject
			this.subject = _subject;
			
			// display updated details
			displayDetails();
		}
	}
	
	/**
	 * This method just displays the information using a format
	 */
	public void displayDetails() {
		// check if is the required instance
		if(this.subject instanceof SurveyData) {
			// convert it to required subject
			SurveyData survey = (SurveyData)this.subject;
			
			// display the information
			System.out.println("Displaying details for General Dashboard");
			System.out.println(String.format("Survey: %s | Answers: %s | Score: %s", survey.getSurveyName(),
					survey.getTotalAnswers(), survey.getCurrentScore()));
			System.out.println(String.format("Last update: %s", LocalDateTime.now()));
			System.out.println();
		}
	}

}
