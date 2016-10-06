package com.preetam.Listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListener implements HttpSessionListener{
	private static Logger logger=Logger.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		logger.info("NEW SESSION ADDED WITH SESSION ID: "+event.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.info("SESSION WITH ID "+event.getSession().getId()+" DESTROYED!");
	}
}
