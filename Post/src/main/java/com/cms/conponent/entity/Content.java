package com.cms.conponent.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Content")
public class Content implements Serializable{


    @GeneratedValue(generator = "ContentSeqGen")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "ContentSeqGen", sequenceName = "Content_seq")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    @JsonIgnore
    private Post post;

    @Column(name = "CREATED")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private LocalDateTime created;

    @Column(length = 255, name = "CONTER")
    @Lob
    private String conter;

    @Column(length = 11, name = "PRIORITY")
    private Long priority;

    @Column(name = "STATUS")
    private Boolean status = false ;

}
