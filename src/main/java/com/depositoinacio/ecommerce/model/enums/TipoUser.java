package com.depositoinacio.ecommerce.model.enums;

public enum TipoUser {

    ADMIN("Administrador"),
    CUSTOMER("Cliente ou Usuário comum");

    private final String description;

    private TipoUser(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
