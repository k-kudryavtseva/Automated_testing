package com.solvd.carina.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.api.azure.coverphotos.*;
import com.solvd.carina.demo.api.azure.users.PutAzureUserByIdMethod;
import com.solvd.carina.demo.api.bo.AzureCoverPhoto;
import com.solvd.carina.demo.api.bo.AzureUser;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AzureCoverPhotoAPITest extends AbstractTest {

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testCreateAzureCoverPhoto() throws Exception {
        int id = 0;
        int idBook = 100;
        String url = "http://newUrl";
        PostAzureCoverPhotoMethod postAzureCoverPhotoMethod = new PostAzureCoverPhotoMethod(id, idBook, url);
        postAzureCoverPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureCoverPhotoMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        AzureCoverPhoto actualCoverPhoto = mapper.readValue(rs, AzureCoverPhoto.class);

        Assert.assertNotNull(actualCoverPhoto, "Response object cannot be null");
        Assert.assertEquals(actualCoverPhoto.getId(), id, "Id is not as expected");
        Assert.assertEquals(actualCoverPhoto.getIdBook(), idBook, "IdBook is not as expected");
        Assert.assertEquals(actualCoverPhoto.getUrl(), url, "URL is not as expected");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureCoverPhoto() {
        GetAzureCoverPhotoMethod getAzureCoverPhotoMethod = new GetAzureCoverPhotoMethod();
        getAzureCoverPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureCoverPhotoMethod.callAPI().asString();

        getAzureCoverPhotoMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAzureCoverPhotoMethod.validateResponseAgainstSchema("api/azure_coverphotos/_get/rsArray.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureCoverPhotoById() {
        int id = 1;
        GetAzureCoverPhotoByIdMethod getAzureCoverPhotoByIdMethod = new GetAzureCoverPhotoByIdMethod(id);
        getAzureCoverPhotoByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureCoverPhotoByIdMethod.callAPI().asString();

        getAzureCoverPhotoByIdMethod.validateResponseAgainstSchema("api/azure_coverphotos/_get/rs.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureCoverPhotoByIdBook() {
        int idBook = 10;
        GetAzureCoverPhotoByIdBookMethod getAzureCoverPhotoByIdBookMethod = new GetAzureCoverPhotoByIdBookMethod(idBook);
        getAzureCoverPhotoByIdBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureCoverPhotoByIdBookMethod.callAPI().asString();

        getAzureCoverPhotoByIdBookMethod.validateResponseAgainstSchema("api/azure_coverphotos/_get/rsArray.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testDeleteAzureCoverPhotoById() {
        int id = 1;
        DeleteAzureCoverPhotoByIdMethod deleteAzureCoverPhotoByIdMethod = new DeleteAzureCoverPhotoByIdMethod(id);
        deleteAzureCoverPhotoByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureCoverPhotoByIdMethod.callAPI();
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testPutAzureCoverPhotoById() throws IOException {
        int id = 11;
        int idBook = 100;
        String url = "url";
        PutAzureCoverPhotoByIdMethod putAzureCoverPhotoByIdMethod = new PutAzureCoverPhotoByIdMethod(id, idBook, url);
        putAzureCoverPhotoByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = putAzureCoverPhotoByIdMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        AzureCoverPhoto actualCoverPhoto = mapper.readValue(rs, AzureCoverPhoto.class);

        Assert.assertNotNull(actualCoverPhoto, "Response object cannot be null");
        Assert.assertEquals(actualCoverPhoto.getId(), id, "Id is not as expected");
        Assert.assertEquals(actualCoverPhoto.getIdBook(), idBook, "IdBook is not as expected");
        Assert.assertEquals(actualCoverPhoto.getUrl(), url, "Url is not as expected");
    }
}
