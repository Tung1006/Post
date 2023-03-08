package com.cms.component.acc;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RelationShipId implements Serializable {
    @Column(name = "Id",insertable = false,updatable = false)
    private Long userId;

    @Column(name = "Id",insertable = false,updatable = false)
    private Long orgId;

    @Column(name = "Id",insertable = false,updatable = false)
    private Long catId;

    @Column(name = "Id",insertable = false,updatable = false)
    private Long siteId;
}
