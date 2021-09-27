package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class UserPayment extends AbstractEntity{

//    @NotNull(message = "Must not be null")
//    @Size(min=13, max=13, message = "Invalid, must be 13-digit")
    private Double creditCardNo;
//
//    @NotNull(message = "Must not be null")
//    @Size(min = 3, max = 3, message = "Invalid, must be 3-digit")
    private Integer cvcNo;

//    @NotNull(message = "Must not be null")
    private String expirationDate;

    public UserPayment() {
    }

    public UserPayment(Double acreditCardNo, Integer acvcNo,  String anexpirationDate) {
        super();
        this.creditCardNo = acreditCardNo;
        this.cvcNo = acvcNo;
        this.expirationDate = anexpirationDate;
    }

    // Getters and setters.

    public Double getCreditCardNo() {
        return creditCardNo;
    }

    public Integer getCvcNo() {
        return cvcNo;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setCreditCardNo(Double creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public void setCvcNo(Integer cvcNo) {
        this.cvcNo = cvcNo;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}

