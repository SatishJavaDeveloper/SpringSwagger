package com.satish;

import java.util.Collections;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Predicates;
import com.satish.filter.JwtFilter;
import com.satish.service.LoginService;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com/satish")
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2).select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
			.build();
    }
    
    //
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
    @Bean
	   public LoginService login()
	   {
		   return new LoginService();
		   
	   }
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
       // restTemplate.setInterceptors(Collections.singletonList(new XUserAgentInterceptor()));
        System.out.println("set Interceptors>>>>>>>>>>>>>");
        return restTemplate;
    }
}
