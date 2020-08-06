package com.solvd.carina.demo.api.azure.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PutAzureBookByIdMethod extends AbstractApiMethodV2 {
    public PutAzureBookByIdMethod(int id, String title, String description, int pageCount, String excerpt, String publishDate) {
        super("api/azure_books/_put/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", "" + id);
        addProperty("id", id);
        addProperty("title", title);
        addProperty("description", description);
        addProperty("pageCount", pageCount);
        addProperty("excerpt", excerpt);
        addProperty("publishDate", publishDate);
    }
}
