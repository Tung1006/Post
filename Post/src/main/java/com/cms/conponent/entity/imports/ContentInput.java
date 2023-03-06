package com.cms.conponent.entity.imports;

import com.cms.conponent.entity.Post;
import com.cms.conponent.entity.join.ForeignKey.ContentId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ContentInput {
    private Long postId;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private LocalDateTime created;
    private String conter;
    private Long priority;
    private Boolean status = false ;

}
