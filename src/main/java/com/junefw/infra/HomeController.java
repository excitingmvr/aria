package com.junefw.infra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;


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
	
	@RequestMapping(value = "/test/zoomList")
	public String zoomList() {
		
		return "test/zoomList";
	}
	
	
	@RequestMapping(value = "/test/publicCorona1List")
	public String publicCorona1List(Model model) throws Exception {
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=dNLcjyriV9IBD5djvIMsq16GYwW%2F8N%2FCtnCNvRj66yaLV9jXKhipDNCJFDcDzorgqnVsJsz5gmYoibNbAG0sdw%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		//나중에 사용할 map을 선언해줍니다.
//		Map<String, Object> map = new HashMap<String, Object>();
		 
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
//		conn.setRequestProperty("Content-type", "application/json");
		
		System.out.println("Response code: " + httpURLConnection.getResponseCode());
		
		BufferedReader bufferedReader;
		 
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
			stringBuilder.append(line);
		}
		bufferedReader.close();
		httpURLConnection.disconnect();
		url =null;
		//StringBuilder로 위에 파라미터 더 한값을 toString으로 불러옵니다.
		//그리고 println으로 확인을 하면 xml형식이 나오게됩니다.
		System.out.println(stringBuilder.toString());

//		String json = "{\"name\":\"intruder\", \"phone\":\"01054221111\"}";


		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = objectMapper.readValue(stringBuilder.toString(), Map.class);

//		for (String key : map.keySet()) {
//			String value = map.get(key);
//		    System.out.println("[key]:" + key + ", [value]:" + value);
//		}   
		
		
		System.out.println("map.get(\"resultCode\"): " + map.get("resultCode"));
//		System.out.println("map.get(\"header\"): " + map.get("header"));
		
		
////		JSONObject jsonObject = new JSONObject();
//		for( Map.Entry<String, String> entry : map.entrySet()  ){
//		    String key = entry.getKey();
//		    System.out.println(key);
////		    Object value = entry.getValue();
////		    jsonObject.put(key, value);
//		}
//		
//		HashMap header = new HashMap();
//		header = (HashMap) map.get("header");
//		
//		System.out.println("header.get(resultCode): " + header.get("resultCode"));
		
		
		
		
//		Home home = objectMapper.readValue(stringBuilder.toString(), Home.class);
//		System.out.println("home: " + home);
//		
//		System.out.println("home.getResultCode(): " + home.getResultCode());
//		System.out.println("home.getResultMsg(): " + home.getResultMsg());
//		System.out.println("home.getPageNo(): " + home.getPageNo());
//		System.out.println("home.getTotalCount(): " + home.getTotalCount());
		
		
		
//		model.addAttribute("list", home.items);
		
		return "test/publicCorona1List";
	}
	
}
