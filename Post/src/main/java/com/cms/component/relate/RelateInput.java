package com.cms.component.relate;


import com.cms.component.category.CategoryEntity;
import com.cms.component.post.PostEntity;
import com.cms.component.site.Site;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Getter
@Setter
public class RelateInput {
    private Long catId;
    private Long siteId;
    private Long postId;
}
