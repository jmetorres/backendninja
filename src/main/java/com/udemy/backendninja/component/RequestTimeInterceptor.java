 package com.udemy.backendninja.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.udemy.backendninja.repository.LogRepository;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	//Primero
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	//Segundo
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Long startTime = (Long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString();
		String username="";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(null != auth && auth.isAuthenticated()){
			username = auth.getName();
		}
		/*com.udemy.backendninja.entity.Log log = 
				new com.udemy.backendninja.entity.Log(new Date(), auth.getDetails().toString(), username, url);*/
		logRepository.save(new com.udemy.backendninja.entity.Log(new Date(), auth.getDetails().toString(), username, url));
 		LOG.info("URL to: " + url + "' in " + (System.currentTimeMillis() - startTime) +" ms'");
	}	
	
}
