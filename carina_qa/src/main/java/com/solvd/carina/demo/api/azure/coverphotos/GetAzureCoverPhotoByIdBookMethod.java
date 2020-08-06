package com.solvd.carina.demo.api.azure.coverphotos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAzureCoverPhotoByIdBookMethod extends AbstractApiMethodV2 {
    public GetAzureCoverPhotoByIdBookMethod(int idBook) {
        super(null, null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        replaceUrlPlaceholder("idBook", "" + idBook);
    }
}
