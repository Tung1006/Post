package com.cms.component.relationShip;

import com.cms.component.category.CategoryEntity;
import com.cms.component.organization.OrganizationEntity;
import com.cms.component.site.SiteEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class RelationShip {

    @EmbeddedId
    private RelationShipId id = new RelationShipId();


    @Column(name = "userId",insertable = false,updatable = false)
    private Long userId;

    @ManyToOne
    @MapsId("orgId")
    @JoinColumn(name = "org_Id",insertable = false,updatable = false)
    private OrganizationEntity organization;

    @ManyToOne
    @MapsId("catId")
    @JoinColumn(name = "cat_Id",insertable = false,updatable = false)
    private CategoryEntity category;

    @ManyToOne
    @MapsId("siteId")
    @JoinColumn(name = "site_Id",insertable = false,updatable = false)
    private SiteEntity site;

}
