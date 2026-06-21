package com.depositoinacio.ecommerce.respositories;

import com.depositoinacio.ecommerce.model.VariantAttributeValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantAttributeValuesRepository extends JpaRepository<VariantAttributeValues,Long> {
}
