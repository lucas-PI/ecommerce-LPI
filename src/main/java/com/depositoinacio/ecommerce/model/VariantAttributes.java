package com.depositoinacio.ecommerce.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "variant_attributes")
public class VariantAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @OneToMany(mappedBy = "variantAttributes")
    private Set<VariantAttributeValues> variantAttributeValues = new HashSet<>();

    public VariantAttributes() {
    }

    public VariantAttributes(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<VariantAttributeValues> getVariantAttributeValues() {
        return variantAttributeValues;
    }

    public void setVariantAttributeValues(Set<VariantAttributeValues> variantAttributeValues) {
        this.variantAttributeValues = variantAttributeValues;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VariantAttributes that = (VariantAttributes) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
