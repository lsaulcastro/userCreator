package com.example.usercreator.application.service.dto.user;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public class UserDto implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 23231678901234567L;

    private String name;

    private String email;

    private String password;

    private List<PhoneDto> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDto> phones) {
        this.phones = phones;
    }
}
