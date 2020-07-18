package com.yx.web.goods.model;

import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.yx.common.base.BaseEntity;


/**
 *	商品管理
 */
@SuppressWarnings({ "unused"})
@Table(name="shop_goods_images")
public class GoodsImages extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private Long goodsCommonid;
public Long getGoodsCommonid() {return this.getLong("goodsCommonid");}
public void setGoodsCommonid(Long goodsCommonid) {this.set("goodsCommonid",goodsCommonid);}
private Long storeId;
public Long getStoreId() {return this.getLong("storeId");}
public void setStoreId(Long storeId) {this.set("storeId",storeId);}
private Long colorId;
public Long getColorId() {return this.getLong("colorId");}
public void setColorId(Long colorId) {this.set("colorId",colorId);}
private String goodsImage;
public String getGoodsImage() {return this.getString("goodsImage");}
public void setGoodsImage(String goodsImage) {this.set("goodsImage",goodsImage);}
private Long goodsImageSort;
public Long getGoodsImageSort() {return this.getLong("goodsImageSort");}
public void setGoodsImageSort(Long goodsImageSort) {this.set("goodsImageSort",goodsImageSort);}
private Long isDefault;
public Long getIsDefault() {return this.getLong("isDefault");}
public void setIsDefault(Long isDefault) {this.set("isDefault",isDefault);}


}
