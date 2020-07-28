package com.solvd.carina.demo.api.azure.coverphotos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PostAzureCoverPhotoMethod extends AbstractApiMethodV2 {
    public PostAzureCoverPhotoMethod(int id, int idBook, String url) {
        super("api/azure_coverphotos/_post/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("id", id);
        addProperty("idBook", idBook);
        addProperty("url", url);
    }
}
