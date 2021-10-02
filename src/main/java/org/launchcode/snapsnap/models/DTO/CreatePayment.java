package org.launchcode.snapsnap.models.DTO;

import com.google.gson.annotations.SerializedName;

public class CreatePayment {

    @SerializedName("items")
    Object[] items;

    public Object[] getItems() { return items; }
}

