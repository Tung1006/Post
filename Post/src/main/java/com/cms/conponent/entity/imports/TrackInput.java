package com.cms.conponent.entity.imports;

import com.cms.conponent.entity.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
public class TrackInput {
    private long id;
    private String type;
    private String time;
    private String description;
    private String userId;
    private Long postId;

    public TrackInput() {
    }



}
