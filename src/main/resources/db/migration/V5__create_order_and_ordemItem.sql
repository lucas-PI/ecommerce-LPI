CREATE TABLE orders(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(30) NOT NULL DEFAULT 'PENDING' CHECK ( status IN ('PENDING','PAID','PROCESSING','SHIPPED','DELIVERED','CANCELLED')),

    CONSTRAINT fk_orders_user FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE INDEX idx_orders_user ON orders(user_id);

CREATE TABLE order_items(
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_variant_id BIGINT NOT NULL,
    quantity INT NOT NULL CHECK ( quantity >= 1),
    sub_total NUMERIC(10,2) NOT NULL,
    unit_price NUMERIC(10,2) NOT NULL,

    CONSTRAINT fk_order_items_order FOREIGN KEY(order_id) REFERENCES orders(id),
    CONSTRAINT fk_order_items_product_variant FOREIGN KEY(product_variant_id) REFERENCES product_variants(id)
);

CREATE UNIQUE INDEX uq_order_items_order_variant ON order_items(order_id,product_variant_id);
CREATE INDEX idx_order_items_order ON order_items(order_id);
CREATE INDEX idx_order_items_product_variant ON order_items(product_variant_id);