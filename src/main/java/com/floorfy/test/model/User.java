package com.floorfy.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class User {

    private final UUID id;
    @NotBlank
    private final String email;
    @NotBlank
    private final String name;
    @NotBlank
    private final String phone;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("email") String email,
                @JsonProperty("name") String name,
                @JsonProperty("phone") String phone) {

        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
