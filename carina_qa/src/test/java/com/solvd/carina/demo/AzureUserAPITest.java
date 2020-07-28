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
import com.solvd.carina.demo.api.azure.users.DeleteAzureUserByIdMethod;
import com.solvd.carina.demo.api.azure.users.GetAzureUserByIdMethod;
import com.solvd.carina.demo.api.azure.users.GetAzureUserMethod;
import com.solvd.carina.demo.api.azure.users.PostAzureUserMethod;
import com.solvd.carina.demo.api.bo.AzureUser;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTestV2 extends AbstractTest { // AbstractTest - класс из Карины, содержит базовые методы для тестов

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testCreateAzureUser() throws Exception {
        String username = "k-kudryavtseva";
        String password = "root";
        PostAzureUserMethod postAzureUserMethod = new PostAzureUserMethod(username, password); // объявление метода --> формирование запроса
        postAzureUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200); // CREATED_201 - статус-код, который ожидаем в response
        String rs = postAzureUserMethod.callAPI().asString(); // вызов метода
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
        getAzureUserMethod.validateResponseAgainstSchema("api/azure_users/_get/rs.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureUserById() {
        GetAzureUserByIdMethod getAzureUserByIdMethod = new GetAzureUserByIdMethod(10);
        getAzureUserByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureUserByIdMethod.callAPI().asString();

        getAzureUserByIdMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAzureUserByIdMethod.validateResponseAgainstSchema("api/azure_users/_get/rs.schema");
    }


    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testDeleteAzureUserById() {
        int userId = 1;
        DeleteAzureUserByIdMethod deleteAzureUserByIdMethod = new DeleteAzureUserByIdMethod(userId);
        deleteAzureUserByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureUserByIdMethod.callAPI();
        deleteAzureUserByIdMethod.validateResponse();
    }

//    @MethodOwner(owner = "k-kudryavtseva")
//    @Test
//    public void testPutAzureUserById() {
//        super();
//    }

}
