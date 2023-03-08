package com.cms.component.acc;

import com.cms.component.category.CategoryEntity;
import com.cms.component.organization.Organization;
import com.cms.component.site.Site;

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
    CategoryEntity category;

    @ManyToOne
    @MapsId("siteId")
    @JoinColumn(name = "siteId",insertable = false,updatable = false)
    Site site;

}
