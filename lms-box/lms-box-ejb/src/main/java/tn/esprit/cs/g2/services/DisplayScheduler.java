package tn.esprit.cs.g2.services;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class DisplayScheduler
 */
@Stateless
public class DisplayScheduler implements DisplaySchedulerRemote, DisplaySchedulerLocal {

    /**
     * Default constructor. 
     */
    public DisplayScheduler() {
    }

	@Override
	public String requestForScheduler() {
		return "10 AM";
	}

}
