package com.solvd.carina.demo.api.azure.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.api.bo.AzureUser;

import java.util.Properties;

public class PutAzureUserMethodById extends AbstractApiMethodV2 {
    public PutAzureUserMethodById(AzureUser azureUser) {
        super("api/azure_users/_put/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("id", azureUser.getId());
        addProperty("username", azureUser.getUsername());
        addProperty("password", azureUser.getPassword());
    }
}
