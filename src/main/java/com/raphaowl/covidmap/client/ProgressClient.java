package com.raphaowl.covidmap.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raphaowl.covidmap.api.v1.response.ProgressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProgressClient {

    @Value("${covid.url.by-date}")
    private String covidUrlByDate;

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, List<ProgressResponse>> getAll() {
        String response = restTemplate.getForObject(covidUrlByDate, String.class);
        Map<String, List<ProgressResponse>> map = new HashMap<>();

        try {
            map = new ObjectMapper().readValue(response, new TypeReference<HashMap<String, List<ProgressResponse>>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return map;
    }

}
