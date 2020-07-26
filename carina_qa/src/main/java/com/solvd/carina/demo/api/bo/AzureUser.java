package com.solvd.carina.demo.api.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AzureUser {
    private String id;
    private String username;
    private String password;

    @JsonCreator
    public AzureUser(
            @JsonProperty("ID") String id,
            @JsonProperty("UserName") String username,
            @JsonProperty("Password") String password
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
