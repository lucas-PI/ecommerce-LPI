CREATE TABLE inventories(
    id BIGSERIAL PRIMARY KEY,
    product_variant_id BIGINT NOT NULL UNIQUE,
    quantity INT NOT NULL DEFAULT 0 CHECK ( quantity >= 0),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_inventory_variant FOREIGN KEY(product_variant_id) REFERENCES product_variants(id)
);