package com.example.usercreator.domain.model.phone;

import com.example.usercreator.domain.model.BaseEntity;
import com.example.usercreator.domain.model.user.UserEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/26/2024
 */
@Table
@Entity(name = "PHONE")
public class PhoneEntity extends BaseEntity implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 12345678901234567L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long phoneId;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "country_code", nullable = false, length = 20)
    private String countryCode;

    @Column(name = "city_code", nullable = false, length = 5)
    private String cityCode;

    @Column(name = "phone_type", nullable = false, length = 5)
    private String phoneType = "CEL";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity phoneUserId;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public UserEntity getPhoneUserId() {
        return phoneUserId;
    }

    public void setPhoneUserId(UserEntity phoneUserId) {
        this.phoneUserId = phoneUserId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
