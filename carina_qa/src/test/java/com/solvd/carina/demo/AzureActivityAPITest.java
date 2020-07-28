/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.solvd.carina.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.api.azure.activities.*;
import com.solvd.carina.demo.api.bo.AzureActivity;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class AzureActivityAPITest extends AbstractTest {

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testCreateAzureActivity() throws Exception {
        int id = 0;
        String title = "sport";
        String dueDate = "2020-07-28T00:00:00"; //LocalDate.now().toString();
        boolean completed = true;
        PostAzureActivityMethod postAzureActivityMethod = new PostAzureActivityMethod(id, title, dueDate, completed);
        postAzureActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureActivityMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        AzureActivity actualActivity = mapper.readValue(rs, AzureActivity.class);

        Assert.assertNotNull(actualActivity, "Response object cannot be null");
        Assert.assertEquals(actualActivity.getId(), id, "Id is not as expected");
        Assert.assertEquals(actualActivity.getTitle(), title, "Title is not as expected");
        Assert.assertEquals(actualActivity.getDueDate(), dueDate, "DueDate is not as expected");
        Assert.assertEquals(actualActivity.isCompleted(), false, "Completed is not as expected");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureActivity() {
        GetAzureActivityMethod getAzureActivityMethod = new GetAzureActivityMethod();
        getAzureActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureActivityMethod.callAPI().asString();

        getAzureActivityMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAzureActivityMethod.validateResponseAgainstSchema("api/azure_activities/_get/rsArray.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureActivityById() {
        int userId = 1;
        GetAzureActivityByIdMethod getAzureActivityByIdMethod = new GetAzureActivityByIdMethod(userId);
        getAzureActivityByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureActivityByIdMethod.callAPI().asString();

        getAzureActivityByIdMethod.validateResponseAgainstSchema("api/azure_activities/_get/rs.schema");
    }


    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testDeleteAzureActivityById() {
        int id = 1;
        DeleteAzureActivityByIdMethod deleteAzureActivityByIdMethod = new DeleteAzureActivityByIdMethod(id);
        deleteAzureActivityByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureActivityByIdMethod.callAPI();
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testPutAzureActivityById() throws IOException {
        int id = 11;
        String title = "art";
        String dueDate = "2020-12-31T00:00:00";
        boolean completed = true;
        PutAzureActivityByIdMethod putAzureActivityByIdMethod = new PutAzureActivityByIdMethod(id, title, dueDate, completed);
        putAzureActivityByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = putAzureActivityByIdMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        AzureActivity actualActivity = mapper.readValue(rs, AzureActivity.class);

        Assert.assertNotNull(actualActivity, "Response object cannot be null");
        Assert.assertEquals(actualActivity.getId(), id, "Id is not as expected");
        Assert.assertEquals(actualActivity.getTitle(), title, "Title is not as expected");
        Assert.assertEquals(actualActivity.getDueDate(), dueDate, "DueDate is not as expected");
    }
}
