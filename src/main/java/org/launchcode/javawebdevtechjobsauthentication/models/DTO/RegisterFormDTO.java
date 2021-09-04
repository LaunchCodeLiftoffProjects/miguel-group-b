package org.launchcode.javawebdevtechjobsauthentication.models.DTO;

public class RegisterFormDTO extends LoginFormDTO{


    public static boolean enabled;
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setIsEnabled(boolean isEnabled) {
        RegisterFormDTO.enabled = true;
    }
}
