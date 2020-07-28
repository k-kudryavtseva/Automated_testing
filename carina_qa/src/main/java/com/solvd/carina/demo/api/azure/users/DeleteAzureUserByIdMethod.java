package com.solvd.carina.demo.api.azure.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteAzureUserMethod extends AbstractApiMethodV2 {
    public DeleteAzureUserMethod() {
        super("api/azure_users/_delete/rq.json", "api/azure_users/_delete/rs.json", "api/azure_users/azureUser.properties");
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
    }
}
