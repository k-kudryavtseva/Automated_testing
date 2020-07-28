package com.solvd.carina.demo.api.azure.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAzureBookByIdMethod extends AbstractApiMethodV2 {
    public GetAzureBookByIdMethod(int id) {
        super(null, null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", "" + id);
    }
}
