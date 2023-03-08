package com.cms.component.track;
import com.cms.component.post.PostEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Track")
public class Track implements Serializable{

    @GeneratedValue(generator = "TrackSeqGen")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "TrackSeqGen", sequenceName = "Track_seq")
    @Column(name = "ID")
    private long id;

    @Column(length = 26, name = "TYPE")
    private String type;

    @Column(length = 127, name = "Time")
    private String time;

    @Column(length = 255, name = "DESCRIPTION")
    private String description;

    @Column(length = 255, name = "USERID")
    private String userId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id", insertable = false, updatable = false)
//    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    @JsonIgnore
    private PostEntity post;

//    @Column(length = 20, name = "POSTID")
//    private Long postId;

    public Track() {
    }

    public Track Clone(){
        Track clo = new Track();
        clo.setId(this.id);
        clo.setType(this.type);
        clo.setTime(this.time);
        clo.setDescription(this.description);
        clo.setUserId(this.userId);
//        clo.setPostId(this.postId);
        return clo;
    }

}
