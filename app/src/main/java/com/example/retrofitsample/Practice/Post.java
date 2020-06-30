package com.example.retrofitsample.Practice;

import java.io.Serializable;

public class Post implements Serializable {
    private int id;
    private String title;
    private String body;
    private int userId;

    public Post(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return
                "Post{" +
                        "id = '" + id + '\'' +
                        ",title = '" + title + '\'' +
                        ",body = '" + body + '\'' +
                        ",userId = '" + userId + '\'' +
                        "}";
    }
}