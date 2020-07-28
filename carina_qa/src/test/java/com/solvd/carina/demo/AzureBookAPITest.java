package com.solvd.carina.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.api.azure.books.DeleteAzureBookByIdMethod;
import com.solvd.carina.demo.api.azure.books.GetAzureBookByIdMethod;
import com.solvd.carina.demo.api.azure.books.GetAzureBookMethod;
import com.solvd.carina.demo.api.azure.books.PostAzureBookMethod;
import com.solvd.carina.demo.api.bo.AzureBook;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AzureBookAPITest extends AbstractTest {

    @MethodOwner(owner = "k-kudryavtseva")
    @Test

    public void testCreateBookAPITest() throws Exception {
        int id = 0;
        String title = "NewTitle";
        String description = "NewDescription";
        int pageCount = 300;
        String excerpt = "excerpt";
        String publishDate = "2020-07-28T16:25:51.8305106"; //LocalDateTime.now().toString();

        PostAzureBookMethod postAzureBookMethod = new PostAzureBookMethod(id, title, description, pageCount, excerpt, publishDate);
        postAzureBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = postAzureBookMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        AzureBook actualBook = mapper.readValue(rs, AzureBook.class);

        Assert.assertNotNull(actualBook, "Response object cannot be null");
        Assert.assertEquals(actualBook.getId(), id, "Id is not as expected");
        Assert.assertEquals(actualBook.getTitle(), title, "Title is not as expected");
        Assert.assertEquals(actualBook.getDescription(), description, "Description is not as expected");
        Assert.assertEquals(actualBook.getPageCount(), pageCount, "PageCount is not as expected");
        Assert.assertEquals(actualBook.getExcerpt(), excerpt, "Excerpt is not as expected");
        Assert.assertEquals(actualBook.getPublishDate(), publishDate, "PublishDate is not as expected");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureBook() {
        GetAzureBookMethod getAzureBookMethod = new GetAzureBookMethod();
        getAzureBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureBookMethod.callAPI().asString();

        getAzureBookMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAzureBookMethod.validateResponseAgainstSchema("api/azure_books/_get/rsArray.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testGetAzureBookById() {
        int bookId = 1;
        GetAzureBookByIdMethod getAzureBookByIdMethod = new GetAzureBookByIdMethod(bookId);
        getAzureBookByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAzureBookByIdMethod.callAPI().asString();

        getAzureBookByIdMethod.validateResponseAgainstSchema("api/azure_books/_get/rs.schema");
    }

    @MethodOwner(owner = "k-kudryavtseva")
    @Test
    public void testDeleteAzureBookById() {
        int id = 1;
        DeleteAzureBookByIdMethod deleteAzureBookByIdMethod = new DeleteAzureBookByIdMethod(id);
        deleteAzureBookByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAzureBookByIdMethod.callAPI();
        deleteAzureBookByIdMethod.validateResponse();
    }
}