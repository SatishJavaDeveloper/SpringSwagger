/**
 * 
 */
package com.satish.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.satish.vo.Asset;

/**
 * @author Satish Reddy
 *
 */
public class LoginService {
	
	
	@Autowired
	RestTemplate resttemplate;

	public boolean verifyUser(String username, String password) {
		// final String url = "http://localhost:8080/SpringRestExample/rest/emps";
		 final HttpHeaders headers = new HttpHeaders();
		 headers.add("Authorization","Basic eG430-123NCUD90432KDLAJF98243JKILSD0-43FJKDSF0943T590TIIOEJ093");
		  final HttpEntity<?> entity = new HttpEntity<>(headers);
     // List<LinkedHashMap> emps=  resttemplate.getForObject(url,List.class);
     //   System.out.println(emps.size());
	//	for(LinkedHashMap map : emps){
	//		System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
	//	}
		if (username.equals("satish") && password.equals("satish")) {
			System.out.println("rest>>>>>>>>>> user verification>>>>>>>>>>>> valid user>>>>>>>>>>>>>>>>success");
			return true;
			
		} else
			return false;
	}

}
