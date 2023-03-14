package com.cms.component.content;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
@Getter
@Setter
public class ContentInput {
    private Long contentId;

    private Long postId;
    private LocalDateTime created;


    private String content;
    private Long priority;
    private Boolean status = false ;
}
