package com.cms.conponent.entity.dto;

import com.cms.conponent.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public interface PostDto {

    long getId() ;


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
