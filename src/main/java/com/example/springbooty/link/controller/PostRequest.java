package com.example.springbooty.link.controller;

public class PostRequest {
    private String link;

    public PostRequest(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
