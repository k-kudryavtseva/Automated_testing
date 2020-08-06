package com.solvd.carina.demo.api.azure.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAzureAuthorByIdBookMethod extends AbstractApiMethodV2 {
    public GetAzureAuthorByIdBookMethod(int idBook) {
        super(null, null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("idBook", "" + idBook);
    }
}
