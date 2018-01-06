package io.renren.modules.generator.vo;

import java.util.Date;

public class CategoryResponseVO {


    //主键
    private Integer id;
    //名称
    private String name;
    //编码
    private String code;
    //层级 1：一级 2：级
    private Integer leaf;
    //父id
    private Integer parentId;
    private Integer parentName;
    //是否启用：1启用，0禁用
    private Integer status;
    //备注
    private String remark;
    //
    private String createUser;
    //
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentName() {
        return parentName;
    }

    public void setParentName(Integer parentName) {
        this.parentName = parentName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
