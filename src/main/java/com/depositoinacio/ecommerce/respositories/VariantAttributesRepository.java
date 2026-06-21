package com.depositoinacio.ecommerce.respositories;

import com.depositoinacio.ecommerce.model.VariantAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantAttributesRepository extends JpaRepository<VariantAttributes, Long> {
}
