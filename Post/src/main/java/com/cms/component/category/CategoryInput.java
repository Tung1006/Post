package com.cms.component.category;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryInput {
    private long id;
    private String code;
    private String name;
    private Boolean status = false ;
    private Long priority;
    private String description;
    private Long menu;
    private Long block;
    private Long topic;
    private Long event;
    private Long parnetId;
    private Long partnerId;


    public CategoryInput() {
    }


}
