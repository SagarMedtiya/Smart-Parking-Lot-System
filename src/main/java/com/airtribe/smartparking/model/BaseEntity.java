package com.airtribe.smartparking.model;

import java.util.Date;
import java.util.UUID;

public abstract class BaseEntity {
    protected String id;
    protected Date createdAt;
    protected Date updatedAt;
    protected long version;
    protected boolean isDeleted;

    public BaseEntity() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.version = 0;
        this.isDeleted = false;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public long getVersion() {
        return version;
    }
    public void setVersion(long version) {
        this.version = version;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    public void updateTimestamp(){
        this.updatedAt = new Date();
        this.version++;
    }
}





































