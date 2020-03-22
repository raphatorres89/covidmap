package com.raphaowl.covidmap.service;

import com.raphaowl.covidmap.api.v1.response.AreaResponse;
import com.raphaowl.covidmap.api.v1.response.ProgressResponse;
import com.raphaowl.covidmap.client.ProgressClient;
import com.raphaowl.covidmap.enumerator.CountryEnum;
import com.raphaowl.covidmap.exception.AreaNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProgressService {

    @Autowired
    private ProgressClient progressClient;

    @Autowired
    private AreaService areaService;

    public Optional<List<ProgressResponse>> getByCountry(CountryEnum country) throws AreaNotFoundException {
        log.info("Getting progress data by country: {}", country.getName());

        Optional<AreaResponse> areaResponse = areaService.getByCountry(country);

        if (!areaResponse.isPresent()) {
            throw new AreaNotFoundException();
        }

        return progressClient.getAll().entrySet().stream()
                .filter(name -> name.getKey().equals(areaResponse.get().getId()))
                .map(stringListEntry -> stringListEntry.getValue())
                .findFirst();
    }
}
