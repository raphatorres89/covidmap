package com.raphaowl.covidmap.service;

import com.raphaowl.covidmap.client.AreaClient;
import com.raphaowl.covidmap.api.v1.response.AreaResponse;
import com.raphaowl.covidmap.enumerator.CountryEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class AreaService {

    @Autowired
    private AreaClient areaClient;

    public AreaResponse getAll() {
        log.info("Getting all Areas");
        return areaClient.getAll();
    }

    public Optional<AreaResponse> getByCountry(CountryEnum country) {
        return Objects.requireNonNull(areaClient.getAll())
                .getAreas().stream()
                .filter(areaResponse -> areaResponse.getDisplayName().equals(country.getName()))
                .findFirst();
    }

}
