package com.carlosmolina.best_travel.api.models.responses;

import com.carlosmolina.best_travel.util.AeroLine;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlyResponse implements Serializable {
    private Long id;
    private Double originLat;
    private Double originLng;
    private Double destinyLat;
    private Double destinyLng;
    private BigDecimal price;
    private String destinyName;
    private String originName;
    private AeroLine aeroLine;
}
