package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Driver {

	public static void main(String[] args) {

		// create object mapper
		ObjectMapper mapper = new ObjectMapper();

		// read the json file and map/convert to java pojo
		// data/sample-lite.json
		Student student = null;
		try {
			student = mapper.readValue(new File("data/sample-full.json"), Student.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// print first name and last name
		System.out.println(student.getFirstName() + " " + student.getLastName());
		System.out.println(student.getAddress());
		StringBuilder languages = new StringBuilder();
		for (String s : student.getLanguages())
			languages.append(s + " ");
		System.out.println(languages.toString().trim());

		// write Student object to new output json file
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT); // pretty print the data in json format
			mapper.writeValue(new File("data/sample-output.json"), student);
			System.out.println("\ndata/sample-output.json file created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
