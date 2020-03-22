package com.raphaowl.covidmap.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaResponse {

    private String id;
    private String displayName;
    private Integer totalConfirmed;
    private Integer totalDeaths;
    private Integer totalRecovered;
    private LocalDateTime lastUpdated;
    private List<AreaResponse> areas;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
