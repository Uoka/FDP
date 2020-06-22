package org.ddd.yzf.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "annex")
public class Annex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long uid;

    @Column(name = "uploader_id")
    protected Long uploaderId;

    @Column(name = "upload_time")
    protected Date uploadTime;

    @Column(name = "saved_name")
    protected String savedName;

    @Column(name = "table_name")
    protected String tableName;

    @Column(name = "field_id")
    protected Long fieldId;

    @Column(name = "relative_path")
    protected String relativePath;

    @Column(name = "suffix_name")
    protected String suffixName;

    @Column(name = "former_name")
    protected String formerName;

    @Column(name = "size")
    protected Long size;

    @Column(name = "remark")
    protected String remark;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Long uploaderId) {
        this.uploaderId = uploaderId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getSavedName() {
        return savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
