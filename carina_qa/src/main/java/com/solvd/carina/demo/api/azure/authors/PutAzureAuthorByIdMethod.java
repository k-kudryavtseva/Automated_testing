package com.solvd.carina.demo.api.azure.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.api.bo.AzureAuthor;

import java.util.Properties;

public class PutAzureAuthorByIdMethod extends AbstractApiMethodV2 {
    public PutAzureAuthorByIdMethod(int id, AzureAuthor author) {
        super("api/azure_authors/_put/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("id", id);
        addProperty("bookId", author.getBookId());
        addProperty("firstName", author.getFirstName());
        addProperty("lastName", author.getLastName());
    }
}
