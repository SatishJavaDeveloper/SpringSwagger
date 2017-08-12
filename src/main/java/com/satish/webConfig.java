/**

 * 
 */
package com.satish;
import java.util.Collections;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.satish.filter.JwtFilter;
import com.satish.service.LoginService;

/**
 * @author Satish Reddy
 *
 */
public class webConfig extends WebMvcConfigurerAdapter  {
	 @Bean
	    public JwtFilter jwtFilter() {
	        return new JwtFilter();
	    }
	    @SuppressWarnings("deprecation")
	   	@Bean
	   	    public FilterRegistrationBean jwtFilterBean() {
	   	        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	   	     registrationBean.setFilter(new JwtFilter());
	   	     System.out.println("filter config>>>>>>>>>>>>>:");
	   	  registrationBean.addUrlPatterns("/*");
	   			return registrationBean;
	   	 }
		/* (non-Javadoc)
		 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
		 */
	  
	    
		
}
