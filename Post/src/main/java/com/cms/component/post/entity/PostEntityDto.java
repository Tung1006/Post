package com.cms.component.post.entity;


import com.cms.component.relate.Relate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Getter
@Setter
public class PostEntityDto {
    PostEntity post = new PostEntity();

    List<Relate>  relates;
}
