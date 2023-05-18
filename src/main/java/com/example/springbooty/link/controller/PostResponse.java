package com.example.springbooty.link.controller;

public class PostResponse {
    private String shortLink;

    public PostResponse(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }
}
