package com.solvd.carina.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.api.azure.authors.*;
import com.solvd.carina.demo.api.bo.AzureAuthor;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AzureAuthorAPITest extends AbstractTest {
    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testCreateAzureAuthor() throws Exception {
        int id = 1;
        int bookId = 10;
        String firstName = "Franz";
        String lastName = "Kafka";
        PostAzureAuthorMethod postAzureAuthorMethod = new PostAzureAuthorMethod(id, bookId, firstName, lastName);
        postAzureAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureAuthorMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        AzureAuthor actualAuthor = mapper.readValue(rs, AzureAuthor.class);

        Assert.assertNotNull(actualAuthor, "Response object cannot be null");
        Assert.assertEquals(actualAuthor.getId(), id, "Id is not as expected");
        Assert.assertEquals(actualAuthor.getBookId(), bookId, "Book id is not as expected");
        Assert.assertEquals(actualAuthor.getFirstName(), firstName, "First name is not as expected");
        Assert.assertEquals(actualAuthor.getLastName(), lastName, "Last name is not as expected");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureAuthor() {
        GetAzureAuthorMethod getAzureAuthorMethod = new GetAzureAuthorMethod();
        getAzureAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureAuthorMethod.callAPI().asString();

        getAzureAuthorMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAzureAuthorMethod.validateResponseAgainstSchema("api/azure_authors/_get/rsArray.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureAuthorById() {
        int authorId = 1;
        GetAzureAuthorByIdMethod getAzureAuthorByIdMethod = new GetAzureAuthorByIdMethod(authorId);
        getAzureAuthorByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureAuthorByIdMethod.callAPI().asString();

        getAzureAuthorByIdMethod.validateResponseAgainstSchema("api/azure_authors/_get/rs.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureAuthorByIdBook() {
        int idBook = 1;
        GetAzureAuthorByIdBookMethod getAzureAuthorByIdBookMethod = new GetAzureAuthorByIdBookMethod(idBook);
        getAzureAuthorByIdBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureAuthorByIdBookMethod.callAPI().asString();

        getAzureAuthorByIdBookMethod.validateResponseAgainstSchema("api/azure_authors/_get/rsArray.schema");
    }


    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testDeleteAzureAuthorById() {
        int authorId = 1;
        DeleteAzureAuthorByIdMethod deleteAzureAuthorByIdMethod = new DeleteAzureAuthorByIdMethod(authorId);
        deleteAzureAuthorByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureAuthorByIdMethod.callAPI();
        deleteAzureAuthorByIdMethod.validateResponse();
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testPutAzureAuthorById() throws IOException {
        int id = 1;
        String firstName = "Franz";
        String lastName = "Kafka";
        int bookId = 10;
        AzureAuthor azureAuthor = new AzureAuthor(id, bookId, firstName, lastName);

        PutAzureAuthorByIdMethod putAzureAuthorByIdMethod = new PutAzureAuthorByIdMethod(id, azureAuthor);
        putAzureAuthorByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = putAzureAuthorByIdMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        AzureAuthor actualAuthor = mapper.readValue(rs, AzureAuthor.class);

        Assert.assertNotNull(actualAuthor, "Response object cannot be null");
        Assert.assertEquals(actualAuthor.getId(), id, "Id is not as expected");
        Assert.assertEquals(actualAuthor.getBookId(), bookId, "Book id is not as expected");
        Assert.assertEquals(actualAuthor.getFirstName(), firstName, "First name is not as expected");
        Assert.assertEquals(actualAuthor.getLastName(), lastName, "Last name is not as expected");
    }
}
