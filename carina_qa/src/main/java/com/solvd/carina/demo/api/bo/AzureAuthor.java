package com.solvd.carina.demo.api.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AzureAuthor {
    private int id;
    private int bookId;
    private String firstName;
    private String lastName;

    @JsonCreator
    public AzureAuthor(
            @JsonProperty("ID") int id,
            @JsonProperty("IDBook") int bookId,
            @JsonProperty("FirstName") String firstName,
            @JsonProperty("LastName") String lastName
    ) {
        this.id = id;
        this.bookId = bookId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
