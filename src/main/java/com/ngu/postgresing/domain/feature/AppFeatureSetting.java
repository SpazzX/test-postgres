package com.ngu.postgresing.domain.feature;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ngu.postgresing.domain.AbstractDomain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "appfeaturesetting")
public class AppFeatureSetting extends AbstractDomain
{
    @Id
    @GeneratedValue(generator = "appfeaturesetting_appfeaturesettingid_seq", strategy = GenerationType.SEQUENCE)
    @Column(name="appfeaturesettingid", unique = true, nullable = false)
    private Long id;

    @NotBlank
    @Column(name="appfeaturekey")
    private String appfeaturekey;

    @NotBlank
    @Column(name="appfeaturevalue")
    private String appfeaturevalue;

    @JoinColumn(name = "appfeatureid", referencedColumnName = "appfeatureid", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private AppFeature appfeature;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppfeaturekey() {
        return appfeaturekey;
    }

    public void setAppfeaturekey(String appfeaturekey) {
        this.appfeaturekey = appfeaturekey;
    }

    public String getAppfeaturevalue() {
        return appfeaturevalue;
    }

    public void setAppfeaturevalue(String appfeaturevalue) {
        this.appfeaturevalue = appfeaturevalue;
    }

    public AppFeature getAppfeature() {
        return appfeature;
    }

    public void setAppfeature(AppFeature appfeature) {
        this.appfeature = appfeature;
    }
}
