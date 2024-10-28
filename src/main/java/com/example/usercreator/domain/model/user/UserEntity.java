package com.example.usercreator.domain.model.user;

import com.example.usercreator.domain.model.BaseEntity;
import com.example.usercreator.domain.model.phone.PhoneEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/26/2024
 */
@Entity
@Table(name = "USER_ENTITY")
public class UserEntity extends BaseEntity implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 87654321987654321L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, unique = true)
    private UUID userId;

    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "token")
    private UUID token;

    @OneToMany(mappedBy = "phoneUserId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneEntity> phones;

    public UserEntity(String email) {
        this.email = email;
    }

    public UserEntity() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public List<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }
}
