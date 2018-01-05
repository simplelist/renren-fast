package io.renren.modules.generator.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 商品表
 *
 * @author kun
 * @email 707069921@qq.com
 * @date 2018-01-05 14:18:42
 */
public class PProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //名称
    private String name;
    //编码
    private String code;
    //进价
    private BigDecimal purchasePrice;
    //销售价
    private BigDecimal salePrice;
    //差价
    private BigDecimal differencePrice;
    //商品数量
    private Integer productNum;
    //商品库存
    private Integer stock;
    //商品单位
    private String unit;
    //大图片地址
    private String photoMaxUrl;
    //所属分类
    private String categoryCode;
    //所属商户
    private String shopCode;
    //商品描述
    private String describe;
    //是否启用：1启用，0禁用
    private Integer status;
    //内容
    private String content;
    //备注
    private String remark;
    //
    private String createUser;
    //
    private Date createDate;
    //
    private String updateUser;
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
     * 设置：进价
     */
    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取：进价
     */
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * 设置：销售价
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 获取：销售价
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     * 设置：差价
     */
    public void setDifferencePrice(BigDecimal differencePrice) {
        this.differencePrice = differencePrice;
    }

    /**
     * 获取：差价
     */
    public BigDecimal getDifferencePrice() {
        return differencePrice;
    }

    /**
     * 设置：商品数量
     */
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    /**
     * 获取：商品数量
     */
    public Integer getProductNum() {
        return productNum;
    }

    /**
     * 设置：商品库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取：商品库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置：商品单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取：商品单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置：大图片地址
     */
    public void setPhotoMaxUrl(String photoMaxUrl) {
        this.photoMaxUrl = photoMaxUrl;
    }

    /**
     * 获取：大图片地址
     */
    public String getPhotoMaxUrl() {
        return photoMaxUrl;
    }

    /**
     * 设置：所属分类
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * 获取：所属分类
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 设置：所属商户
     */
    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    /**
     * 获取：所属商户
     */
    public String getShopCode() {
        return shopCode;
    }

    /**
     * 设置：商品描述
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 获取：商品描述
     */
    public String getDescribe() {
        return describe;
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
     * 设置：内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
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
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取：
     */
    public String getCreateUser() {
        return createUser;
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
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取：
     */
    public String getUpdateUser() {
        return updateUser;
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
}
