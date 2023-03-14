package com.cms.component.site;

import com.cms.component.relate.Relate;
import com.cms.component.relationShip.RelationShip;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Site")
public class SiteEntity implements Serializable{

    @GeneratedValue(generator = "SiteSeqGen")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SiteSeqGen", sequenceName = "Site_seq")
    @Column(name = "siteId")
    private long siteId;


    @Column(length = 26, name = "CODE")
    private String code;

    @Column(length = 127, name = "NAME")
    private String name;

    @Column(length = 255, name = "LANGUAGE")
    private String language;

    @Column(length = 255, name = "DESCRIPTION")
    private String description;

    @Column(length = 20, name = "PARNETID")
    private Long parnetId;


    @JsonIgnore
    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
    private Collection<RelationShip> relationShips = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
    private Collection<Relate> relate = new ArrayList<>();

    public SiteEntity() {
    }

    public SiteEntity Clone(){
        SiteEntity clo = new SiteEntity();
        clo.setSiteId(this.siteId);
        clo.setCode(this.code);
        clo.setName(this.name);
        clo.setDescription(this.description);
        clo.setLanguage(this.language);
        clo.setParnetId(this.parnetId);
        return clo;
    }

}
