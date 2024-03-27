package com.example.homerent.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleName {
    ROLE_CUSTOMER ("ROLE_CUSTOMER"), ROLE_ADMIN ("ROLE_ADMIN");

    private final String value;

    RoleName(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
