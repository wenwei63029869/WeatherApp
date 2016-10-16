package com.wei.com.wei.web;


import com.wei.com.wei.responseObj.Location;
import com.wei.com.wei.responseObj.WeatherResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * Created by weiwen on 10/15/16.
 */

@Controller
public class WeatherController {
    // Perform a get request for homepage
    @RequestMapping(value="", method= RequestMethod.GET)
    public  String weather (ModelMap model) {
        Location location = new Location();

        model.put("location", location);
        return "weather";
    }

    // Perform a post request to make API call to get weather
    @RequestMapping(value="", method=RequestMethod.POST)
    public String weatherPost (@ModelAttribute Location location, ModelMap model) throws URISyntaxException, UnsupportedEncodingException {

        String apiKey="9d70ec4175aaa312ffc8b5b659dd91f8";

        RestTemplate template = new RestTemplate();

        // Construct a URI object
        // Encode city name to prevent spaces
        URI uri = new URI("http://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(location.getCity(), "UTF-8") + "," + location.getCountryCode() + "&units=imperial&appid=" + apiKey);

        // Create a request with Get method and the generated uri
        RequestEntity<String> request = new RequestEntity<String>(HttpMethod.GET, uri);

        // Create a response with WeatherResponse type to only store the info we need from the API response
        ResponseEntity<WeatherResponse> weatherResponse = template.exchange(uri, HttpMethod.GET, request, WeatherResponse.class);

        // Empty the form fields
        location = new Location();
        model.put("location", location);

        // Get body of the response entity
        model.put("weatherResponse", weatherResponse.getBody());

        return "weather";
    }
}
