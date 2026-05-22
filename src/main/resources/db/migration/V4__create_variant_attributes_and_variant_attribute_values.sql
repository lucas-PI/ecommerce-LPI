CREATE TABLE variant_attributes(
    id BiGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE UNIQUE INDEX uq_variant_attribute_name ON variant_attributes(LOWER(name));

CREATE TABLE variant_attribute_values(
    id BIGSERIAL PRIMARY KEY,
product_variant_id BIGINT NOT NULL,
variant_attribute_id BIGINT NOT NULL,
value VARCHAR(100) NOT NULL,
UNIQUE(product_variant_id, variant_attribute_id),

CONSTRAINT fk_product_variant FOREIGN KEY(product_variant_id) REFERENCES product_variants(id),
CONSTRAINT fk_variant_attributes FOREIGN KEY(variant_attribute_id) REFERENCES variant_attributes(id)
);

