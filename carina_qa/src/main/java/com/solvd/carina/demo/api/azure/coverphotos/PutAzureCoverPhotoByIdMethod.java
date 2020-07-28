package com.solvd.carina.demo.api.azure.coverphotos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PutAzureCoverPhotoByIdMethod extends AbstractApiMethodV2 {
    public PutAzureCoverPhotoByIdMethod(int id, int idBook, String url) {
        super("api/azure_coverphotos/_put/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("id", "" + id);
        addProperty("id", id);
        addProperty("idBook", idBook);
        addProperty("url", url);

    }
}
