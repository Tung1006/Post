package com.cms.component.acc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@AllArgsConstructor
@Table(name = "Users")
public class User implements Serializable {

    @Column(name = "ID")
    @GeneratedValue(generator = "UsersSeqGen")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "UsersSeqGen", sequenceName = "Users_seq")
    private long id;

    @Column(length = 129, name = "userid")
    private String userId;

    @Column(length = 129, name = "username")
    private String userName;

    @Column(length = 76, name = "password")
    private String password;

    @Column(name = "active_")
    private Boolean active;

    @Column(length = 76, name = "cadrescode")
    private String cadresCode;

    @Column(name = "orgid")
    private Long orgId;

    @Column(length = 501, name = "provinceids")
    private String provinceIds;

    @Column(length = 501, name = "districtids")
    private String districtIds;

    @Column(length = 129, name = "fullname")
    private String fullName;

    @Column(length = 129, name = "position")
    private String position;

    @Column(length = 129, name = "email")
    private String email;

    @Column(length = 129, name = "phone")
    private String phone;

    @Column(length = 513, name = "address")
    private String address;

    @Column(length = 513, name = "roles")
    private String roles;

    @Column(name = "status")
    private Long status;

    @Column(name = "mailnotify")
    private Boolean mailNotify;

    @Column(name = "smsnotify")
    private Boolean smsNotify;

    @Column(name = "createdate")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private Date createDate;

    @Column(name = "updatedate")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok")
    private Date updateDate;

    @Column(length = 257, name = "document")
    private String document;

    @Column(length = 4001, name = "reason")
    private String reason;

    @Column(name = "createby")
    private String createBy;

    @Column(name = "updatedby")
    private String updatedBy;

//    @OneToOne
//    @JoinColumn(name="userid")
//    private Post post;

//    @OneToOne
////    @JoinColumn(name="USERID")
//    private Post post;

//    @OneToMany(mappedBy = "student")
//    Set<CourseRating> ratings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Column(insertable = false, updatable = false)
    Set<RelationShip> relationShips;

    public User() {
    }

    public User clone() {
        User clo = new User();
        clo.setId(this.id);
        clo.setUserId(this.userId);
        clo.setUserName(this.userName);
        clo.setPassword(this.password);
        clo.setActive(this.active);
        clo.setCadresCode(this.cadresCode);
        clo.setOrgId(this.orgId);
        clo.setProvinceIds(this.provinceIds);
        clo.setDistrictIds(this.districtIds);
        clo.setFullName(this.fullName);
        clo.setPosition(this.position);
        clo.setEmail(this.email);
        clo.setPhone(this.phone);
        clo.setAddress(this.address);
        clo.setRoles(this.roles);
        clo.setStatus(this.status);
        clo.setMailNotify(this.mailNotify);
        clo.setSmsNotify(this.smsNotify);
        clo.setCreateDate(this.createDate);
        clo.setUpdateDate(this.updateDate);
        clo.setDocument(this.document);
        clo.setReason(this.reason);
        clo.setCreateBy(this.createBy);
        clo.setUpdatedBy(this.updatedBy);

        return clo;
    }
}
