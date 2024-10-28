package com.example.usercreator.application.service.dto.user;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public class PhoneDto implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1678901234567L;

    private String number;

    private String countryCode;

    private String cityCode;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
