package org.launchcode.javawebdevtechjobsauthentication.security;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    VENDOR_WRITE("vendor:write"),
    VENDOR_READ("vendor:read"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
