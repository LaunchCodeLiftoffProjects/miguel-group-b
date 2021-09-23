package org.launchcode.snapsnap.models;

import javax.persistence.Entity;

@Entity
public class Payment extends AbstractEntity{

    //    @NotNull(message = "Must not be null")
//    @Size(max=13, message = "Invalid, must be 13-digit")
    private String cardNo;
    //
//    @NotNull(message = "Must not be null")
//    @Size(min = 3, max = 3, message = "Invalid, must be 3-digit")
    private Integer cvcNo;

    //    @NotNull(message = "Must not be null")
    private String expirationDate;

    public Payment() {}

    public Payment(String cardNo, Integer cvcNo, String expirationDate) {
        this.cardNo = cardNo;
        this.cvcNo = cvcNo;
        this.expirationDate = expirationDate;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getCvcNo() {
        return cvcNo;
    }

    public void setCvcNo(Integer cvcNo) {
        this.cvcNo = cvcNo;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
