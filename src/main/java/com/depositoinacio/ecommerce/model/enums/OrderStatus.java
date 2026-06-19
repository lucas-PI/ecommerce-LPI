package com.depositoinacio.ecommerce.model.enums;

public enum OrderStatus {

    PENDING("Aguardando pagamento"),
    PAID("Pago"),
    PROCESSING("Em processamento"),
    SHIPPED("Enviado"),
    DELIVERED("Entregue"),
    CANCELLED("Cancelado");

    private final String description;

    private OrderStatus(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
