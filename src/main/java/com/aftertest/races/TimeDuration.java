package com.aftertest.races;

import com.aftertest.exceptions.BadBadValueException;

public class TimeDuration {

    private int nbSeconds;

    public TimeDuration(int nbSeconds) {
    	if (nbSeconds<0)
			try {
				throw new BadBadValueException();
			} catch (BadBadValueException e) {
				e.printStackTrace();
			}
        this.nbSeconds = nbSeconds;
    }

    public String toString() {
        int nbHours = nbSeconds/3600;
        int nbMinutes = (nbSeconds-nbHours*3600)/60;
        int leftSeconds = nbSeconds-nbHours*3600-nbMinutes*60;
        String hours = nbHours==0?"":nbHours+"h ";
        String minutes =nbMinutes==0?nbHours==0?"":"0m ":nbMinutes+"m ";
        String seconds = leftSeconds==0?"0s":leftSeconds+"s";
        return hours+""+minutes+""+seconds;
    }

    public void setNbSeconds(int nbSeconds) {
        this.nbSeconds = nbSeconds;
    }

    public int getNbSeconds() {
        return nbSeconds;
    }

    void printResults() {

    }
}
