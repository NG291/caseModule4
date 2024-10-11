package com.codegym.casestudymodule4.model.ENUM;

public enum ROLE {
    ROLE_ADMIN("admin"),
    ROLE_USER("user"),
    ROLE_MERCHANT("templates/merchant");
    private final String roleName;

    ROLE(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

}
