package com.sparta.homework01.domain;

public class BlogRequestDto {
    private String title;
    private String username;
    private String contents;
    private int pw;

    public String getTitle() {
        return this.title;
    }

    public String getUsername() {
        return this.username;
    }

    public String getContents() {
        return this.contents;
    }

    public int getPw() {
        return this.pw;
    }

    public BlogRequestDto(final String title, final String username, final String contents, final int pw) {
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.pw = pw;
    }
}
