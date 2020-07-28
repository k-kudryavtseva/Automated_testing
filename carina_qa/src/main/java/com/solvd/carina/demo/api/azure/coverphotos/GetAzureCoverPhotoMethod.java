package com.solvd.carina.demo.api.azure.coverphotos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetAzureCoverPhotoMethod extends AbstractApiMethodV2 {
    public GetAzureCoverPhotoMethod() {
        super(null, "api/azure_coverphotos/_get/rs.json");
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
    }
}
