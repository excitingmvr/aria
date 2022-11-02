package com.junefw.infra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.junefw.infra.modules.member.Member;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/test/map")
	public String map() {
		
		return "test/map";
	}
	
	
	@RequestMapping(value = "/test/memberList")
	public String memberList(Model model) throws Exception {
		
		String apiUrl = "http://localhost/rest/member";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		// json Array String -> java List
		ObjectMapper objectMapper = new ObjectMapper();
		List<Member> memberList = objectMapper.readValue(stringBuilder.toString(), new TypeReference<List<Member>>() {});

		model.addAttribute("list", memberList);
		
		return "test/memberList";
	}
	
	
	@RequestMapping(value = "/test/memberView")
	public String memberView(Model model) throws Exception {

//		api 호출해서 데이터를 받아온다.
		
		String apiUrl = "http://localhost/rest/member/22";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}
		
		bufferedReader.close();
		httpURLConnection.disconnect();
		
		System.out.println("final line:" + stringBuilder.append(line));
		
		ObjectMapper objectMapper = new ObjectMapper();
		Member member = objectMapper.readValue(stringBuilder.toString(), Member.class);
		
		model.addAttribute("item", member);
		
		return "test/memberView";
	}
	
	

	@RequestMapping(value = "/test/publicCorona1List")
	public String publicCorona1List(Model model) throws Exception {
		
		System.out.println("asdfasdfasdf");
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=dNLcjyriV9IBD5djvIMsq16GYwW%2F8N%2FCtnCNvRj66yaLV9jXKhipDNCJFDcDzorgqnVsJsz5gmYoibNbAG0sdw%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		System.out.println("stringBuilder.toString(): " + stringBuilder.toString());
		
//		json object + array string -> java map
		
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(stringBuilder.toString(), Map.class);
        
        System.out.println("######## Map");
		for (String key : map.keySet()) {
			String value = String.valueOf(map.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
		Map<String, Object> header = new HashMap<String, Object>();
		header = (Map<String, Object>) map.get("header");
		
		System.out.println("######## Header");
		for (String key : header.keySet()) {
			String value = String.valueOf(header.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
//		String aaa = (String) header.get("resultCode");
		
//		System.out.println("header.get(\"resultCode\"): " + header.get("resultCode"));
//		System.out.println("header.get(\"resultMsg\"): " + header.get("resultMsg"));
		
		Map<String, Object> body = new HashMap<String, Object>();
		body = (Map<String, Object>) map.get("body");
		
		List<Home> items = new ArrayList<Home>();
		items = (List<Home>) body.get("items");
		
		
		System.out.println("items.size(): " + items.size());
		
//		for(Home item : items) {
//			System.out.println(item.getMM());
//		}
		
		model.addAllAttributes(header);
		model.addAllAttributes(body);
		
		return "test/publicCorona1List";
	}
	
	
	@RequestMapping(value = "/test/publicCorona1JsonNodeList")
	public String publicCorona1JsonNodeList(Model model) throws Exception {
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=dNLcjyriV9IBD5djvIMsq16GYwW%2F8N%2FCtnCNvRj66yaLV9jXKhipDNCJFDcDzorgqnVsJsz5gmYoibNbAG0sdw%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
		
		model.addAttribute("node", node);
		
//		model.addAttribute(node);
		
		return "test/publicCorona1JsonNodeList";
	}
	
	
	@RequestMapping(value = "/test/rtcView")
	public String rtcView(Model model) throws Exception {

		return "test/rtcView";
	}

	
	@RequestMapping(value = "/test/peerconnection/pc1")
	public String pc1(Model model) throws Exception {

		return "webrtc/content/peerconnection/pc1/index";
	}
	
	
	@RequestMapping(value = "/test/zoomList")
	public String zoomList(Model model) throws Exception {
		
		String apiUrl = "https://api.zoom.us/v2/users/excitingmvr@gmail.com/meetings";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6ImpZZUF6bURXU0pDN0Q0RHhEZ1Z4Y1EiLCJleHAiOjE2NTM0NDUwNTAsImlhdCI6MTY1MzQzOTY1M30.M-ClBp_0hADXERd5VrXOqtANh85L8OfRML0bxiQZDmc");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		System.out.println("stringBuilder.toString(): " + stringBuilder.toString());
		
		
		return "test/zoomList";
	}
	
	
}
