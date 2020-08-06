package com.solvd.carina.demo.api.azure.activities;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAzureActivityMethod extends AbstractApiMethodV2 {
    public GetAzureActivityMethod() {
        super(null, "api/azure_activities/_get/rs.json", new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
    }
}
