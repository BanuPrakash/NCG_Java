package com.adobe.prj.orderapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="items")
public class LineItem {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int itemId;

        @ManyToOne
        @JoinColumn(name="product_fk")
        private Product product;

        private int qty;

        private double amount;
}
