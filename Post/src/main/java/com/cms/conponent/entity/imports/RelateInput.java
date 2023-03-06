package com.cms.conponent.entity.imports;

import com.cms.conponent.entity.Category;
import com.cms.conponent.entity.Post;
import com.cms.conponent.entity.Site;
import com.cms.conponent.entity.join.ForeignKey.RelateId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
public class RelateInput {

    RelateId id;
    private Long catId;

    private Long siteId;

    private Long postId;

}
