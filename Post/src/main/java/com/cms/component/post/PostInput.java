package com.cms.component.post;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
@Getter
@Setter
public class PostInput {
    private long id;
    private String code;
    private String title;
    private String special;
    private String summary;
    private String author;
    private Long type;
    private Boolean status = false ;
    private Long priority;
    private String represent;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private LocalDateTime created;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private LocalDateTime updated;
    private String counter;
    private String tag;
    private Long userId;

    public PostInput() {
    }


    public PostInput clone() {
        PostInput clo = new PostInput();
        clo.setId(this.id);
        clo.setCode(this.code);
        clo.setTitle(this.title);
        clo.setSpecial(this.special);
        clo.setSummary(this.summary);
        clo.setAuthor(this.author);
        clo.setType(this.type);
        clo.setStatus(this.status);
        clo.setPriority(this.priority);
        clo.setRepresent(this.represent);
        clo.setCreated(this.created);
//        clo.setUserId(this.userId);
        clo.setUpdated(this.updated);
        clo.setCounter(this.counter);
        clo.setTag(this.tag);
        return  clo;
    }
}
