package com.solvd.carina.demo.api.bo;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class AzureUsers {
    public AzureUser[] azureUsers;
    @JsonCreator
    public AzureUsers(@JsonProperty("azureUsers") AzureUser[] azureUsers)
    {
        this.azureUsers = azureUsers;
    }

    public AzureUser[] getAzureUsers() {
        return azureUsers;
    }
}
