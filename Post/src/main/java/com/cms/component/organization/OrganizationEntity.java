package com.cms.component.organization;


import com.cms.component.relationShip.RelationShip;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Organization")
public class OrganizationEntity implements Serializable{


    @GeneratedValue(generator = "OrganizationSeqGen")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "OrganizationSeqGen", sequenceName = "Organization_seq")
    @Column(name = "organizationId")
    private long organizationId;

    @Column(length = 26, name = "CODE")
    private String code;

    @Column(length = 127, name = "NAME")
    private String name;

    @Column(length = 11, name = "PRIORITY")
    private Long priority;

    @Column(length = 255, name = "DESCRIPTION")
    private String description;

    @Column(length = 20, name = "PARNETID")
    private Long parnetId;

//    @OneToMany(mappedBy = "organization")
////    Set<RelationShip> relationShips;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
//    @Column(insertable = false, updatable = false)
//    Set<RelationShip> relationShips;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private Collection<RelationShip> relationShips = new ArrayList<>();

    public OrganizationEntity() {
    }


    public OrganizationEntity clone() {
        OrganizationEntity clo = new OrganizationEntity();
        clo.setOrganizationId(this.organizationId);
        clo.setCode(this.code);
        clo.setName(this.name);
        clo.setDescription(this.description);
        clo.setPriority(this.priority);
        clo.setParnetId(this.parnetId);
        return  clo;
    }
}
