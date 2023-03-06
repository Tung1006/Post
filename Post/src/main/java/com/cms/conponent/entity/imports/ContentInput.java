package com.cms.conponent.entity.imports;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ContentInput {

    private Long id;
    private long postId;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private LocalDateTime created;
    private String conter;
    private Long priority;
    private Boolean status = false ;

}
