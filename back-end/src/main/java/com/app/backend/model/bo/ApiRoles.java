package com.app.backend.model.bo;

import java.util.Map;

public class ApiRoles {
    private Map<String, String> ApiRoleMaps;

    public ApiRoles() {
        this.ApiRoleMaps.put("/api/account/getAccountList", "ROLE1");
        this.ApiRoleMaps.put("/api/account/register", "ROLE1");
        this.ApiRoleMaps.put("/api/account/*", "ROLE1");
    }
}
