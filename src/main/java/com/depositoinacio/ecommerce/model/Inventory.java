package com.depositoinacio.ecommerce.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "inventories")
public class Inventory{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_variant_id", nullable = false, unique = true)
    private ProductVariant productVariant;
    @Column(nullable = false)
    private Integer quantity;
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;
    /*
    CREATE TABLE inventories(
    id BIGSERIAL PRIMARY KEY,
    product_variant_id BIGINT NOT NULL UNIQUE,
    quantity INT NOT NULL DEFAULT 0 CHECK ( quantity >= 0),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_inventory_variant FOREIGN KEY(product_variant_id) REFERENCES product_variants(id)
);*/

    public Inventory() {
    }

    public Inventory(Long id, ProductVariant productVariant, Integer quantity, OffsetDateTime updatedAt) {
        this.id = id;
        this.productVariant = productVariant;
        this.quantity = quantity;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductVariant getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(ProductVariant productVariant) {
        this.productVariant = productVariant;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) && Objects.equals(productVariant, inventory.productVariant) && Objects.equals(quantity, inventory.quantity) && Objects.equals(updatedAt, inventory.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productVariant, quantity, updatedAt);
    }
}
