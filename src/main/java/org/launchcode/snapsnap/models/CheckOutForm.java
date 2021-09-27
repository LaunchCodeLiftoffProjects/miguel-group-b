package org.launchcode.snapsnap.models;

import javax.validation.constraints.NotNull;

public class CheckOutForm {

    @NotNull
    private Double amount;

    @NotNull
    private String email;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
