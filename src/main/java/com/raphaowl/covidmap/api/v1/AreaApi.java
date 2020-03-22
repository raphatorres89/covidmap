package com.raphaowl.covidmap.api.v1;

import com.raphaowl.covidmap.api.v1.response.AreaResponse;
import com.raphaowl.covidmap.enumerator.CountryEnum;
import com.raphaowl.covidmap.exception.AreaNotFoundException;
import com.raphaowl.covidmap.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("areas")
public class AreaApi {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public AreaResponse getAll() {
        return areaService.getAll();
    }

    @GetMapping("/{country}")
    public AreaResponse getByCountry(@PathVariable CountryEnum country) throws AreaNotFoundException {
        Optional<AreaResponse> areaResponse = areaService.getByCountry(country);

        if (!areaResponse.isPresent()) {
            log.error("Area not found for country: {}", country.getName());
            throw new AreaNotFoundException();
        }

        return areaResponse.get();
    }

}
