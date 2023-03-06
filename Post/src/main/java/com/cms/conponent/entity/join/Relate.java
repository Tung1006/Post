package com.cms.conponent.entity.join;

import com.cms.conponent.entity.*;
import com.cms.conponent.entity.join.ForeignKey.RelateId;
import com.cms.conponent.entity.join.ForeignKey.RelationShipId;

import javax.persistence.*;

@Entity
public class Relate {

    @EmbeddedId
    RelateId id;

    @ManyToOne
    @MapsId("catId")
    @JoinColumn(name = "userId",insertable = false,updatable = false)
    Category category;

    @ManyToOne
    @MapsId("siteId")
    @JoinColumn(name = "siteId",insertable = false,updatable = false)
    Site site;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "postId",insertable = false,updatable = false)
    Post post;

}
