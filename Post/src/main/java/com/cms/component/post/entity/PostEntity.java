package com.cms.component.post.entity;


import com.cms.component.content.ContentEntity;
import com.cms.component.track.Track;
import com.cms.component.relate.Relate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Post")
public class PostEntity implements Serializable{


    @GeneratedValue(generator = "PostSeqGen")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "PostSeqGen", sequenceName = "Post_seq")
    @Column(name = "postId")
    private long postId;

    @Column(length = 36, name = "CODE")
    private String code;

    @Column(length = 255, name = "TITLE")
    private String title;

    @Column(length = 512, name = "SPECIAL")
    private String special;

    @Column(length = 1024, name = "SUMMARY")
    private String summary;

    @Column(length = 64, name = "AUTHOR")
    private String author;

    @Column(length = 11, name = "TYPE")
    private Long type;

    @Column(name = "STATUS")
    private Boolean status = false ;

    @Column(length = 11, name = "PRIORITY")
    private Long priority;

    @Column(length = 255, name = "REPRESENT")
    private String represent;

    @Column(name = "CREATED")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private LocalDateTime created;

//    @Column(length = 255, name = "USERID")
//    private String userId;

    @Column(name = "UPDATED")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private LocalDateTime updated;

    @Column(length = 11, name = "COUNTER")
    private String counter;

    @Column(length = 255, name = "TAG")
    private String tag;


//    @OneToOne(mappedBy="post")
//    private User user;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "USERID")
//    private User user;

//    @JsonIgnore
////    @JsonIgnoreProperties(value = {"email","address"})
//    @OneToOne
//    @JoinColumn(name = "userId", insertable = false, updatable = false)
//    private User user;

    @Column(name = "userId")
    private Long userId;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
//    @Column(insertable = false, updatable = false)
//    Set<Relate> relate;
    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Collection<Relate> relate = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    @Column(insertable = false, updatable = false)
    private List<ContentEntity> contents;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    @Column(insertable = false, updatable = false)
    private List<Track> track;





    public PostEntity() {
    }


    public PostEntity clone() {
        PostEntity clo = new PostEntity();
        clo.setPostId(this.postId);
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
