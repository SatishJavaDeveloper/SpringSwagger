package com.satish;

import java.util.Date;




import com.fasterxml.jackson.annotation.JsonFormat;



public class Person {
	public String firstName;
	public String lastName;
	
	@JsonFormat(pattern="yyyy-dd-MM")
	public Date dob;
	public Person() {	
	}
	public Person(String firstName, String lastName,
				Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	public String toString() {
	    return "[" + firstName + " " + lastName +
		       " " + dob.getTime() +"]";
	}
}