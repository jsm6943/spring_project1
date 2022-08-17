package com.sparta.homework01.domain;

public class BlogResponseDto {
    private String title;
    private String username;
    private String contents;

    public BlogResponseDto(Blog detail) {
        this.title = detail.getTitle();
        this.username = detail.getUsername();
        this.contents = detail.getContents();
    }

    public String getTitle() {
        return this.title;
    }

    public String getUsername() {
        return this.username;
    }

    public String getContents() {
        return this.contents;
    }

    public BlogResponseDto(final String title, final String username, final String contents) {
        this.title = title;
        this.username = username;
        this.contents = contents;
    }
}
