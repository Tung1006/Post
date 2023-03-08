package com.cms.component.relate;

import com.cms.component.category.CategoryEntity;
import com.cms.component.post.PostEntity;
import com.cms.component.site.Site;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Relate {

    @EmbeddedId
    RelateId id;

    @ManyToOne
    @MapsId("catId")
    @JoinColumn(name = "catId",insertable = false,updatable = false)
    CategoryEntity category;

    @ManyToOne
    @MapsId("siteId")
    @JoinColumn(name = "siteId",insertable = false,updatable = false)
    Site site;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "postId",insertable = false,updatable = false)
    PostEntity post;

}
