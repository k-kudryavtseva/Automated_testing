package com.solvd.carina.demo.api.azure.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class DeleteAzureAuthorByIdMethod extends AbstractApiMethodV2 {
    public DeleteAzureAuthorByIdMethod(int id) {
        super("api/azure_authors/_delete/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", "" + id);
    }
}
