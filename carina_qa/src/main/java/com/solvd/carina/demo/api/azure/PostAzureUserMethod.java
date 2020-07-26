package com.solvd.carina.demo.api.azure;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PostAzureUserMethod extends AbstractApiMethodV2 {
    public PostAzureUserMethod(String username, String password) {
        super("api/azure_users/_post/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("username", username);
        addProperty("password", password);
    }
}
