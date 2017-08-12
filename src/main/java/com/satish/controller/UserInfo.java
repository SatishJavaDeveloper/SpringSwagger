package com.satish.controller;

import java.io.IOException;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.ning.billing.recurly.RecurlyClient;
import com.ning.billing.recurly.model.Account;
import com.ning.billing.recurly.model.Address;
import com.ning.billing.recurly.model.Invoice;
import com.ning.billing.recurly.model.Invoices;
import com.ning.billing.recurly.model.Plan;
import com.ning.billing.recurly.model.Plans;
import com.ning.billing.recurly.model.RecurlyUnitCurrency;
import com.satish.service.LoginService;
import com.satish.vo.Accounts;
import com.satish.vo.Users;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiModel(value="UserInfo",description="User Services")
@Api(tags = { "UserInfo" }, description = "Customer related services")
@RestController
public class UserInfo {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	LoginService services;
	
	@ApiModelProperty(example = "1234", required = true)
	private static final String template = "Hello, %s!";
	@ApiModelProperty(example = "1234", required = true)
	private final AtomicLong counter = new AtomicLong();
	//
	
  //
	// @ApiOperation(value = "Customers", nickname = "getGreetings")
	// @RequestMapping(value = "/User/{UserId}/{Password}", method =
	// RequestMethod.PUT, produces = "application/json")
	// @ApiImplicitParams({
	//
	// @ApiImplicitParam(name = "id", value = "User's id", required = true,
	// dataType = "int", paramType = "query", defaultValue = "12345"),
	// @ApiImplicitParam(name = "password", value = "User's password", required
	// = true, dataType = "string", paramType = "query", defaultValue = "Satish
	// Reddy"),
	// @ApiImplicitParam(name = "name", value = "User's name", required = true,
	// dataType = "json", paramType = "query", defaultValue = "Satish Reddy")
	//
	// })
	// @ApiResponses(value = { @ApiResponse(code = 200, message = "Success",
	// response = Greeting.class),
	// @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code =
	// 403, message = "Forbidden"),
	// @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500,
	// message = "Failure") })
	// public Greeting greeting(@RequestParam(value = "name", defaultValue =
	// "World") String name) {
	// return new Greeting(counter.incrementAndGet(), String.format(template,
	// name));
	// }
	//
	// //
	// @ApiModelProperty(example = "satish")
	// @ApiOperation(value = "CustomerDetails", nickname = "getGreeting", notes
	// = "Customer details")
	// @RequestMapping(value = "/User/{Username}", method = RequestMethod.POST,
	// produces = MediaType.TEXT_PLAIN_VALUE)
	// @ApiImplicitParams({
	//
	// @ApiImplicitParam(name = "commands", value = "commands", required = true,
	// dataType = "string", paramType = "body", defaultValue = "") })
	// @ApiResponses(value = { @ApiResponse(code = 200, message = "Success",
	// response = Greeting.class),
	// @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code =
	// 403, message = "Forbidden"),
	// @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500,
	// message = "Failure") })
	// //
	//
	// public void greeting4(@RequestParam(value = "name", defaultValue =
	// "World") String name) {
	//
	// System.out.println(String.format(template, name));
	//
	// // return new Greeting(counter.incrementAndGet(),
	// // String.format(template, name));
	// }
	//
	// //
	//
	// // public Greeting greetings(@RequestParam(value="name",
	// // defaultValue="World") String name) {
	// // return new Greeting(counter.incrementAndGet(),
	// // String.format(template, name));
	// @ApiModelProperty(example = "satish", required = true)
	// @ApiOperation(value = "getGreetings3", nickname = "getGreetings3")
	// @RequestMapping(value = "/User/{UserId}/{Password}", method =
	// RequestMethod.DELETE, produces = "application/json")
	// @ApiImplicitParams({
	// @ApiImplicitParam(name = "id", value = "User's id", required = true,
	// dataType = "int", paramType = "query", defaultValue = "12345"),
	// @ApiImplicitParam(name = "password", value = "User's password", required
	// = true, dataType = "string", paramType = "query", defaultValue = "Satish
	// Reddy"),
	// @ApiImplicitParam(name = "name", value = "User's name", required = true,
	// dataType = "string", paramType = "query", defaultValue = "Satish Reddy")
	// })
	// @ApiResponses(value = {
	//
	// @ApiResponse(code = 200, message = "Success", response = Greeting.class),
	// @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code =
	// 403, message = "Forbidden"),
	// @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500,
	// message = "Failure") })
	//
	// public Greeting greeting3(@RequestParam(value = "name", defaultValue =
	// "World") String name) {
	// return new Greeting(counter.incrementAndGet(), String.format(template,
	// name));
	// }
	/*@ApiOperation(value = "Create Instance")
	@RequestMapping(value = "/Instance/CreateInstance", method = RequestMethod.GET, produces = "application/json")
	public Users createInstance(@RequestBody Users instancePayload, HttpServletResponse response,HttpServletRequest req)
			throws IOException {
		response.setLocale(Locale.JAPANESE);
		System.out.println("authentication:>>>>:"+req.getHeader("api_key"));
		final Instance instance = instancePayload;
		// response.setStatus(201, "Instance Created successfully.");
		// response.setStatus(200);
		//response.sendError(401);
		System.out.println("Instance" + instance.toString());
		FileWriter writer = new FileWriter("D:\\SatishReddy\\Instance.txt");

		Barcode128 code128 = new Barcode128();
		code128.setGenerateChecksum(true);
		code128.setCode("1234554321");
	//	System.out.println("graphics:"+code128.createAwtImage(Color.BLUE, Color.CYAN).getGraphics());
	//	System.out.println("graphics:"+code128.CODE128);
	//	writer.write((code128.createAwtImage(Color.BLUE, Color.CYAN));
		writer.write(instance.toString());
		// document.add(code128.createImageWithBarcode(writer.getDirectContent(),
		// null, null));
		// document.close();

		writer.close();
		return instance;
		
		return instancePayload;
	}*/
	/*@RequestMapping("/hell")
	public String hello()
	{
		return "hello";
		
	}
	*/
	@ApiOperation("UserLogin")
	@RequestMapping(value="Users/Login", method=RequestMethod.POST)
	public Users login(@RequestBody Users user,HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		restTemplate.equals("restTemplate");
		boolean verify=services.verifyUser(user.getUsername(),user.getPassword());
		if(verify)
		{
			res.setStatus(200);
			System.out.println(" headers req>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+req.getHeaderNames()+" resp headers>>>>>>>>>>>>>>>>>>>>>>>>>>>"+res.getHeaderNames());
			return user;
		}
		else
			res.sendError(400);
		System.out.println("response headers>>>>>>>>>>>>>");
		return user;
	}
	//
	
	@ApiOperation("UserLogin")
	@RequestMapping(value="Users/Login", method=RequestMethod.POST)
	public Users queue(@RequestBody Users user,HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		restTemplate.equals("restTemplate");
		
		boolean verify=services.verifyUser(user.getUsername(),user.getPassword());
	
		if(verify)
		{
			res.setStatus(200);
			System.out.println(" headers req>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+req.getHeaderNames()+" resp headers>>>>>>>>>>>>>>>>>>>>>>>>>>>"+res.getHeaderNames());
			return user;
		}
		else
			res.sendError(400);
		System.out.println("response headers>>>>>>>>>>>>>");
		return user;
	}
	//
	@ApiOperation("UserLoginRecurly")
	@RequestMapping(value="Users/Recurly", method=RequestMethod.GET)
	@JsonCreator
	public String logins(HttpServletRequest req,HttpServletResponse res) throws IOException, KeyManagementException, NoSuchAlgorithmException
	{
	final String apiKey = "ea67a580ff3d43c7b810b5b1bc7d0a2c";     
    final String Domain = "satish";

    /*Account account = new Account();*/
    /*user.setAccountCode("7864854309");
    user.setFirstName("Jeet");
    user.setEmail("satish270694@gmail.com");
    Address ad=new Address();
    ad.setCity("Hyderabad");
    user.setAddress(ad);*/
    RecurlyClient recurlyClient =new RecurlyClient(apiKey);

    // opening the recurly server.
    recurlyClient.open();
    
    com.ning.billing.recurly.model.Accounts accounts=recurlyClient.getAccounts();
   /*Invoices invoices= recurlyClient.getAccountInvoices("90868");
   if(invoices.size()>0)
   {
   Invoice inv=invoices.get(0);
   System.out.println(inv.getHref());
  
   return inv;
   }*/
   //  return user;
	return accounts.toArray().toString();
	}
	@ApiOperation("UserLogin")
	@RequestMapping(value="Users/Plans", method=RequestMethod.GET)
	public Users createPlan(@RequestBody Users user,HttpServletRequest req,HttpServletResponse res) throws IOException, KeyManagementException, NoSuchAlgorithmException
	{
		//res.setContentType("application/octet-stream");
		/*final String apiKey = "ea67a580ff3d43c7b810b5b1bc7d0a2c";     
	    final String Domain = "satish";

	    Account account = new Account();
	    user.setAccountCode("7864854309");
	    user.setFirstName("Jeet");
	    user.setEmail("satish270694@gmail.com");
	    Address ad=new Address();
	    ad.setCity("Hyderabad");
	    user.setAddress(ad);
	    Plan plan=new Plan();
	    plan.setName("Enterprise");
	    plan.setPlanCode("5124");
	    RecurlyUnitCurrency curs=new RecurlyUnitCurrency();
	    curs.setUnitAmountUSD(900);
	   plan.setSetupFeeInCents(curs);
	    Plans pl=new Plans();
	    pl.add(plan);
	    
	   // plan.setPlanIntervalUnit(1);
	    
//	    plan.setUnitAmountInCents("898.00");
	    
	   // plan.setPlanIntervalUnit("3 Months");
	    System.out.println("curs.getUnitAmountUSD()"+curs.getUnitAmountUSD());
	    RecurlyClient recurlyClient =new RecurlyClient(apiKey);

	    // opening the recurly server.
	    recurlyClient.open();
	    recurlyClient.createPlan(plan);
*/
		return user;	    
	}
	
}
