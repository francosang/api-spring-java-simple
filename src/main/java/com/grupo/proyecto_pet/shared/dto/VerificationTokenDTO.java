package com.grupo.proyecto_pet.shared.dto;

import java.util.Date;

/**
 * @author Franco on 07/29/2017.
 */
public class VerificationTokenDTO {

    private long id;
    private String token;
    private Date expirationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
