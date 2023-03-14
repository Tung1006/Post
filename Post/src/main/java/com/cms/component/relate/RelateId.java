package com.cms.component.relate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RelateId implements Serializable {

    private Long catId;


    private Long siteId;


    private Long postId;
}
