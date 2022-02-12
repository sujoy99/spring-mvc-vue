package com.infoworks.lab.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TBL_PIZZA")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PIZZA_ID")
    private Long pizzaId;

    @Column(name = "PIZZA_NAME")
    private String pizzaName;

    @Column(name = "PIZZA_PRICE", columnDefinition = "Decimal(10,2) default '1000.00'")
    private Double pizzaPrice;

}
