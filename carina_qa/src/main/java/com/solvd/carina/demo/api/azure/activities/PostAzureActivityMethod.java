package com.solvd.carina.demo.api.azure.activities;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PostAzureActivityMethod extends AbstractApiMethodV2 {
    public PostAzureActivityMethod(int id, String title, String dueDate, boolean completed) {
        super("api/azure_activities/_post/rq.json", null, new Properties());
        replaceUrlPlaceholder("api_azure_url", Configuration.getEnvArg("api_azure_url"));
        addProperty("id", id);
        addProperty("title", title);
        addProperty("dueDate", dueDate);
        addProperty("completed", completed);
    }
}
