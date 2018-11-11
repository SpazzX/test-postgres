package com.ngu.postgresing.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdDate", "lastModifiedDate", "activeFlag"},
        allowGetters = true
)
public abstract class AbstractDomain implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodifieddate", nullable = false)
    @LastModifiedDate
    private Date lastModifiedDate;

    @NotNull
    @Column(name = "activeflag", nullable = false)
    private boolean activeFlag = true;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
