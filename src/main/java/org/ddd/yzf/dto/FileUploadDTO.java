package org.ddd.yzf.dto;

import org.ddd.yzf.entity.Annex;

public class FileUploadDTO {

    private String tableName;

    private Long fieldId;

    private String remark;

    public Annex getAnnex() {
        Annex annex = new Annex();
        annex.setFieldId(fieldId);
        annex.setTableName(tableName);
        annex.setRemark(remark);
        return annex;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
