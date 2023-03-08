package com.cms.component.organization;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrganizationInput {
    private long id;
    private String code;
    private String name;
    private Long priority;
    private String description;
    private Long parnetId;

    public OrganizationInput() {
    }


}
