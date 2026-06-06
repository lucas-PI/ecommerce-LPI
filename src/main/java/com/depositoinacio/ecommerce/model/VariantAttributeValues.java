package com.depositoinacio.ecommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "variant_attribute_values")
public class VariantAttributeValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_variant_id", nullable = false)
    private ProductVariant productVariant;
    // Minha enitdade não é apenas um valor da linha, mas ela toda.
    @ManyToOne
    @JoinColumn(name = "variant_attribute_id", nullable = false)
    private VariantAttributes variantAttributes;

    @Column(nullable = false, length = 100)
    private String value;
/*
* CREATE TABLE variant_attribute_values(
    id BIGSERIAL PRIMARY KEY,
product_variant_id BIGINT NOT NULL,
variant_attribute_id BIGINT NOT NULL,
value VARCHAR(100) NOT NULL,*/

    public VariantAttributeValues() {
    }

    public VariantAttributeValues(Long id, ProductVariant productVariant,
                                  VariantAttributes variantAttributes, String value) {
        this.id = id;
        this.productVariant = productVariant;
        this.variantAttributes = variantAttributes;
        this.value = value;
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

    public VariantAttributes getVariantAttributes() {
        return variantAttributes;
    }

    public void setVariantAttributes(VariantAttributes variantAttributes) {
        this.variantAttributes = variantAttributes;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VariantAttributeValues that = (VariantAttributeValues) o;
        return Objects.equals(id, that.id) && Objects.equals(productVariant, that.productVariant) && Objects.equals(variantAttributes, that.variantAttributes) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productVariant, variantAttributes, value);
    }
}
