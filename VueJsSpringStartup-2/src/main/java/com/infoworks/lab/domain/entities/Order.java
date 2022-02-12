package com.infoworks.lab.domain.entities;

import com.infoworks.lab.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TBL_ORDER")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "TOTAL_PRICE", columnDefinition = "Decimal(10,2) default '1000.00'")
    private Double totalPrice;

    @Column(name = "ORDER_STATUS")
    private Status orderStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ORDER_ID")
    List<OrderDetail> orderDetails;
}
