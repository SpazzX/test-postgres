package com.ngu.postgresing.domain.feature;

import com.ngu.postgresing.domain.AbstractDomain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "appfeature")
public class AppFeature extends AbstractDomain
{
    @Id
    @GeneratedValue(generator = "appfeature_appfeatureid_seq", strategy = GenerationType.SEQUENCE)
    @Column(name="appfeatureid", unique = true, nullable = false)
    private Long id;

    @NotBlank
    @Column(name="appfeaturename")
    private String appfeaturename;

    @Column(name="appfeaturenote")
    private String appfeaturenote;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "appfeatureid", referencedColumnName = "appfeatureid", insertable = false, updatable = false)
    private List<AppFeatureSetting> appFeatureSettings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppfeaturename() {
        return appfeaturename;
    }

    public void setAppfeaturename(String appfeaturename) {
        this.appfeaturename = appfeaturename;
    }

    public String getAppfeaturenote() {
        return appfeaturenote;
    }

    public void setAppfeaturenote(String appfeaturenote) {
        this.appfeaturenote = appfeaturenote;
    }

    public List<AppFeatureSetting> getAppFeatureSettings() {
        return appFeatureSettings;
    }

    public void setAppFeatureSettings(List<AppFeatureSetting> appFeatureSettings) {
        this.appFeatureSettings = appFeatureSettings;
    }
}
