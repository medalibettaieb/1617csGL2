package tn.esprit.cs.g2.services;

import javax.ejb.Remote;

@Remote
public interface DisplaySchedulerRemote {
	String requestForScheduler();

}
