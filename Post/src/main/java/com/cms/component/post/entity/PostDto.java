package com.cms.component.post.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public interface PostDto {

    long getPostId() ;


    String getCode() ;


    String getTitle() ;


    String getSpecial() ;


    String getSummary() ;


    String getAuthor() ;


    Long getType() ;


    Boolean getStatus() ;


    Long getPriority() ;


    String getRepresent() ;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    LocalDateTime getCreated() ;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    LocalDateTime getUpdated() ;


    String getCounter() ;


    String getTag() ;


    Long getUserId() ;

    String getFullName();
}
