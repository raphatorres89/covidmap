package com.raphaowl.covidmap.api.v1.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgressResponse {

    private Integer confirmed;
    private Integer fatal;
    private Integer recovered;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

}
