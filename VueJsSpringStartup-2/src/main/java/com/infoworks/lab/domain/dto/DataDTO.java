package com.infoworks.lab.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataDTO {

    private Long pizzaId;
    private Long[] toppingsId;
}
