package com.cms.component.relate;

import com.cms.component.category.CategoryEntity;
import com.cms.component.post.entity.PostEntity;
import com.cms.component.site.SiteEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Relate {

    @EmbeddedId
    private RelateId id = new RelateId();

    @ManyToOne
    @MapsId("catId")
    @JoinColumn(name = "category_Id")
    private CategoryEntity category;

    @ManyToOne
    @MapsId("siteId")
    @JoinColumn(name = "site_Id")
    private SiteEntity site;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_Id")
    @JsonIgnore
    private PostEntity post;

}
