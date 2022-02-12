package com.infoworks.lab.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TBL_TOPPINGS")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Toppings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOPPINGS_ID")
    private Long toppingsId;

    @Column(name = "TOPPINGS_NAME")
    private String toppingsName;

    @Column(name = "TOPPINGS_PRICE")
    private Double toppingPrice;
}
