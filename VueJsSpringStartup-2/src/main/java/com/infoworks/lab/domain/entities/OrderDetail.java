package com.infoworks.lab.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TBL_ORDER_DETAIL")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_DETAIL_ID")
    private Long orderDetailId;

    @OneToOne
    @JoinColumn(name = "PIZZA_ID", nullable = false)
    private Pizza pizza;

    @OneToOne
    @JoinColumn(name = "TOPPINGS_ID", nullable = false)
    private Toppings toppings;
}
