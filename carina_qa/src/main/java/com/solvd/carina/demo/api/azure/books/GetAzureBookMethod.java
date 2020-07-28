package com.solvd.carina.demo.api.azure.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetAzureBookMethod extends AbstractApiMethodV2 {
    public GetAzureBookMethod() {
        super(null, "api/azure_books/_get/rs.json");
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
    }
}
