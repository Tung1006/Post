package com.cms.conponent.entity.join;

import com.cms.conponent.entity.Category;
import com.cms.conponent.entity.Organization;
import com.cms.conponent.entity.Site;
import com.cms.conponent.entity.User;
import com.cms.conponent.entity.join.ForeignKey.RelationShipId;

import javax.persistence.*;

@Entity
public class RelationShip {

    @EmbeddedId
    RelationShipId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "userId",insertable = false,updatable = false)
    User user;

    @ManyToOne
    @MapsId("orgId")
    @JoinColumn(name = "orgId",insertable = false,updatable = false)
    Organization organization;

    @ManyToOne
    @MapsId("catId")
    @JoinColumn(name = "catId",insertable = false,updatable = false)
    Category category;

    @ManyToOne
    @MapsId("siteId")
    @JoinColumn(name = "siteId",insertable = false,updatable = false)
    Site site;

}
