package com.runnablepatterns.javaobserverpattern;

import java.util.Observable;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to store survey information.
 * This class is the subject that will notify all observers once data is updated
 * This time we are extending Observable interface
 */
public class SurveyData extends Observable {

	/**
	 * The name of the survey
	 */
	private String surveyName;
	
	/**
	 * Total answers provided to this survey
	 */
	private int totalAnswers;
	
	/**
	 * Current score after computing the answers
	 */
	private double currentScore;
	
	/**
	 * Overloaded constructor.
	 * @param _surveyName The survey name to use
	 */
	public SurveyData(String _surveyName) {
		this.surveyName = _surveyName;
	}
	
	/**
	 * This method just receives the calculated values for this survey.
	 * @param _totalAnswers Number of total answers to set
	 * @param _score Current survey score to set
	 */
	public void surveyUpdate(int _totalAnswers, double _score) {
		// check if the values changed
		if(this.totalAnswers != _totalAnswers || this.currentScore != _score) {
			// set the state to true
			setChanged();
		}
		this.totalAnswers = _totalAnswers;
		this.currentScore = _score;
		
		// notify all observers
		notifyObservers();
	}
	
	/**
	 * Get current survey name
	 * @return The survey name
	 */
	public String getSurveyName() {
		return surveyName;
	}

	/**
	 * Get the total survey answers
	 * @return The survey answers count
	 */
	public int getTotalAnswers() {
		return totalAnswers;
	}

	/**
	 * Get the current survey score
	 * @return The survey score
	 */
	public double getCurrentScore() {
		return currentScore;
	}

}
