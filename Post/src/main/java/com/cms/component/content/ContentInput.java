package com.cms.component.content;


import com.cms.component.post.PostEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Getter
@Setter
public class ContentInput {
    private Long id;

    private Long postId;
    private LocalDateTime created;


    private String content;
    private Long priority;
    private Boolean status = false ;
}
