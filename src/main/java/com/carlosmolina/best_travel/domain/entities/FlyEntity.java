package com.carlosmolina.best_travel.domain.entities;

import com.carlosmolina.best_travel.util.AeroLine;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "fly")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class FlyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double originLat;
    private Double originLng;
    private Double destinyLat;
    private Double destinyLng;
    private BigDecimal price;
    @Column(length = 20)
    private String origin_name;
    @Column(length = 20)
    private String destinyName;
    @Enumerated(EnumType.STRING)
    private AeroLine aeroLine;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy="fly"
    )
    private Set<TicketEntity> tickets;
}
