package com.solvd.carina.demo.api.azure.activities;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAzureActivityByIdMethod extends AbstractApiMethodV2 {
    public GetAzureActivityByIdMethod(int id) {
        super(null, null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", "" + id);
    }
}
