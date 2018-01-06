package io.renren.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品分类表
 *
 * @author kun
 * @email 707069921@qq.com
 * @date 2018-01-05 17:29:26
 */
public class PProductCategory implements Serializable {
    private static final long serialVersionUID = 1L;

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
    //是否启用：1启用，0禁用
    private Integer status;
    //备注
    private String remark;
    //
    private Integer createUser;
    //
    private Date createDate;
    //
    private Integer updateUser;
    //
    private Date updateDate;

    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置：层级 1：一级 2：级
     */
    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    /**
     * 获取：层级 1：一级 2：级
     */
    public Integer getLeaf() {
        return leaf;
    }

    /**
     * 设置：父id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置：是否启用：1启用，0禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：是否启用：1启用，0禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }


    /**
     * 设置：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取：
     */
    public Date getCreateDate() {
        return createDate;
    }


    /**
     * 设置：
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取：
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
}
