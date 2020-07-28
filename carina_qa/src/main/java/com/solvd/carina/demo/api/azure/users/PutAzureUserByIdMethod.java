package com.solvd.carina.demo.api.azure.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.api.bo.AzureUser;

import java.util.Properties;

public class PutAzureUserByIdMethod extends AbstractApiMethodV2 {
    public PutAzureUserByIdMethod(int id, String username, String password) {
        super("api/azure_users/_put/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", "" + id);
        addProperty("id", id);
        addProperty("username", username);
        addProperty("password", password);
    }
}
