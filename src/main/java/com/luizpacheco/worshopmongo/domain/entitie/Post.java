package com.luizpacheco.worshopmongo.domain.entitie;

import java.io.Serializable;

public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String body;
    private User author;

    public Post() {
    }

    public Post(String id, String title, String body, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }


}
