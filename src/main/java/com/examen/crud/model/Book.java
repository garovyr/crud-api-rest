package com.examen.crud.model;

public class Book {

    private Long id;

    private String title;
    private String author;

    private String thumbnail;

    public Long getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public String getAuthor() {

        return author;
    }

    public String getThumbnail() {

        return thumbnail;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setThumbnail(String url) {

        this.thumbnail = url;
    }
}
