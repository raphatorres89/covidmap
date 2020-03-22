package com.raphaowl.covidmap.api.v1;

import com.raphaowl.covidmap.api.v1.response.ProgressResponse;
import com.raphaowl.covidmap.enumerator.CountryEnum;
import com.raphaowl.covidmap.exception.AreaNotFoundException;
import com.raphaowl.covidmap.exception.ProgressNotFoundException;
import com.raphaowl.covidmap.service.ProgressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("progress")
public class ProgressApi {

    @Autowired
    private ProgressService progressService;

    @GetMapping("/{country}")
    public List<ProgressResponse> getByCountry(@PathVariable CountryEnum country) throws ProgressNotFoundException, AreaNotFoundException {
        Optional<List<ProgressResponse>> progressList = progressService.getByCountry(country);

        if (!progressList.isPresent()) {
            log.error("No progress found for country: {}", country.getName());
            throw new ProgressNotFoundException();
        }

        return progressList.get();
    }
}
