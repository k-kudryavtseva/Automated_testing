package com.solvd.carina.demo.api.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AzureCoverPhoto {
    private int id;
    private int idBook;
    private String url;

    @JsonCreator
    public AzureCoverPhoto(
        @JsonProperty("ID") int id,
        @JsonProperty("IDBook") int idBook,
        @JsonProperty("Url") String url
    ) {
        this.id = id;
        this.idBook = idBook;
        this.url = url;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
