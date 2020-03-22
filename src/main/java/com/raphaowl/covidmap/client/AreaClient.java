package com.raphaowl.covidmap.client;

import com.raphaowl.covidmap.api.v1.response.AreaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AreaClient {

    @Value("${covid.url.database}")
    private String covidUrlDatabase;

    @Autowired
    private RestTemplate restTemplate;

    public AreaResponse getAll() {
        return restTemplate.getForObject(covidUrlDatabase, AreaResponse.class);
    }

}
