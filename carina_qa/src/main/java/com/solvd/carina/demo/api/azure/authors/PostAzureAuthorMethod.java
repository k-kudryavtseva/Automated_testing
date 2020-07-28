package com.solvd.carina.demo.api.azure.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PostAzureAuthorMethod extends AbstractApiMethodV2 {
    public PostAzureAuthorMethod(int authorId, int bookId, String firstName, String lastName) {
        super("api/azure_authors/_post/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("id", authorId);
        addProperty("bookId", bookId);
        addProperty("firstName", firstName);
        addProperty("lastName", lastName);
    }
}
