package com.cms.conponent.entity.join;

import com.cms.conponent.entity.Post;
import com.cms.conponent.entity.User;
import com.cms.conponent.entity.join.ForeignKey.ContentId;
import com.cms.conponent.entity.join.ForeignKey.RelateId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Content {

    @EmbeddedId
    ContentId id;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "postId",insertable = false,updatable = false)
    Post post;


    @Column(name = "CREATED")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private LocalDateTime created;

    @Column(length = 255, name = "CONTER")
    private String conter;

    @Column(length = 11, name = "PRIORITY")
    private Long priority;

    @Column(name = "STATUS")
    private Boolean status = false ;

}
