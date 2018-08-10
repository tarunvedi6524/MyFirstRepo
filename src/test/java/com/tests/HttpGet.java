package com.tests;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class HttpGet {
	
	private final String USER_AGENT = "Mozilla/5.0";
	private final String url = "http://restcountries.eu/rest/v1";

	public static void main(String[] args) {
		
		
		HttpGet http = new HttpGet();
		try {
			System.out.println("--Processing HTTP GET--");
			//Pass country name as argument
			http.get("Australia");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void get(String country) throws Exception{
		
		
		boolean temp = false;
		
		//Creating a URL object
		URL obj = new URL(url);
		
		//Casting that object to HttpURLConnection
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		//Setting type and headers
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		if(responseCode == 200){
			
			//Converting input stream to string using buffered reader and string buffer
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			//System.out.println(response.toString());
			//System.out.println("Response Code : " + responseCode);
			
			JSONParser parser = new JSONParser();
			JSONArray jsonarr = (JSONArray) parser.parse(response.toString());
			for(int i=0;i<jsonarr.size();i++){
				JSONObject jobj = (JSONObject) jsonarr.get(i);
				if(jobj.get("name").toString().equalsIgnoreCase(country)){
					
					temp=true;
					break;
				}														
			}
			
			if(temp==true){
				System.out.println(country+" is available in response");
			}else
				System.out.println(country+" is not available in response");
			
		}
		else
			System.out.println("Error is processing request, Response code:"+responseCode);		
			
	}

}
