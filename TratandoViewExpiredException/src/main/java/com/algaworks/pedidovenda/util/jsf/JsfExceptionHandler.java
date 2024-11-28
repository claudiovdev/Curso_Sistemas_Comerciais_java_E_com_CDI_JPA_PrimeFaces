package com.algaworks.pedidovenda.util.jsf;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class JsfExceptionHandler extends ExceptionHandlerWrapper{

	private ExceptionHandler wrapped;
	
	
	
	public JsfExceptionHandler(ExceptionHandler ex) {
		this.wrapped = ex;	}
	@Override
	public ExceptionHandler getWrapped() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();
		while(events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			Throwable execption = context.getException();
			try {
				if(execption instanceof ViewExpiredException) {
					redirect("/");
				}
			}finally {
				events.remove();
			}
			
		}
	}
	
	private void redirect(String page) {
		try {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		String contextPath = externalContext.getRequestContextPath();
		
		externalContext.redirect(contextPath + page);
		facesContext.responseComplete();
		}catch (IOException e) {
			throw new FacesException(e);
		}
	}
}
