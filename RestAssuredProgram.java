package com.print;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Response resp = RestAssured.get(
				"https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22");

		String data = resp.asString();

		System.err.println(data);

		int statusCode = resp.getStatusCode();

		System.out.println(statusCode);

		Map<String, Integer> main = resp.jsonPath().getMap("main");
		System.out.println(main.get("humidity"));

		List<Map<String, String>> companies = resp.jsonPath().getList("weather");
		System.out.println(companies.get(0).get("description"));
	}

}
