package com.cms.conponent.entity.join.ForeignKey;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RelateId implements Serializable {
    @Column(name = "id",insertable = false,updatable = false)
    private Long catId;

    @Column(name = "id",insertable = false,updatable = false)
    private Long siteId;

    @Column(name = "id",insertable = false,updatable = false)
    private Long postId;
}
