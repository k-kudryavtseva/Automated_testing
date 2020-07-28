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
import com.solvd.carina.demo.api.azure.users.*;
import com.solvd.carina.demo.api.bo.AzureUser;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class AzureUserAPITest extends AbstractTest {

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testCreateAzureUser() throws Exception {
        String username = "k-kudryavtseva";
        String password = "root";
        PostAzureUserMethod postAzureUserMethod = new PostAzureUserMethod(username, password);
        postAzureUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureUserMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        AzureUser actualUser = mapper.readValue(rs, AzureUser.class);

        Assert.assertNotNull(actualUser, "Response object cannot be null");
        Assert.assertEquals(actualUser.getUsername(), username, "Username is not as expected");
        Assert.assertEquals(actualUser.getPassword(), password, "Password is not as expected");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureUsers() {
        GetAzureUserMethod getAzureUserMethod = new GetAzureUserMethod();
        getAzureUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureUserMethod.callAPI().asString(); // вызов метода

        getAzureUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAzureUserMethod.validateResponseAgainstSchema("api/azure_users/_get/rsArray.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureUserById() {
        int userId = 1;
        GetAzureUserByIdMethod getAzureUserByIdMethod = new GetAzureUserByIdMethod(userId);
        getAzureUserByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureUserByIdMethod.callAPI().asString();

        getAzureUserByIdMethod.validateResponseAgainstSchema("api/azure_users/_get/rs.schema");
    }


    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testDeleteAzureUserById() {
        int id = 1;
        DeleteAzureUserByIdMethod deleteAzureUserByIdMethod = new DeleteAzureUserByIdMethod(id);
        deleteAzureUserByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureUserByIdMethod.callAPI();
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testPutAzureUserById() throws IOException {
        int id = 11;
        String username = "k-kudryavtseva";
        String password = "root";
        PutAzureUserByIdMethod putAzureUserByIdMethod = new PutAzureUserByIdMethod(id, username, password);
        putAzureUserByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = putAzureUserByIdMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        AzureUser actualUser = mapper.readValue(rs, AzureUser.class);

        Assert.assertNotNull(actualUser, "Response object cannot be null");
        Assert.assertEquals(actualUser.getUsername(), id, "Id is not as expected");
        Assert.assertEquals(actualUser.getUsername(), username, "Username is not as expected");
        Assert.assertEquals(actualUser.getPassword(), password, "Password is not as expected");
    }
}
