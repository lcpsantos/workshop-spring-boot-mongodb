package com.luizpacheco.worshopmongo.dto;

import java.util.Date;

public record CommentDTO(String text, Date date, AuthorDTO author) {

}