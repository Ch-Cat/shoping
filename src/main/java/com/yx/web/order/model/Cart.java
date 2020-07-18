package com.yx.web.order.model;

import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.yx.common.base.BaseEntity;


/**
 *	购物车
 */
@SuppressWarnings({ "unused"})
@Table(name="shop_cart")
public class Cart extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		private Long memberId;
  		private Long storeId;
  		private String storeName;
  		private Long goodsId;
  		private String goodsName;
  		private Long specId;
  		private String specInfo;
  		private BigDecimal goodsStorePrice;
  		private Long goodsNum;
  		private String goodsImages;
  		private Long firstGcId;
		public Long getMemberId() {
			return this.getLong("memberId");
		}
		public void setMemberId(Long memberId) {
			this.set("memberId",memberId);
		}
		public Long getStoreId() {
			return this.getLong("storeId");
		}
		public void setStoreId(Long storeId) {
			this.set("storeId",storeId);
			}
		
		public String getStoreName() {
			return this.getString("storeName");
			}
		public void setStoreName(String storeName) {
			this.set("storeName",storeName);
			}
		
		public Long getGoodsId() {
			return this.getLong("goodsId");
			}
		public void setGoodsId(Long goodsId) {
			this.set("goodsId",goodsId);
			}
		
		public String getGoodsName() {
			return this.getString("goodsName");
			}
		public void setGoodsName(String goodsName) {
			this.set("goodsName",goodsName);
			}
		
		public Long getSpecId() {
			return this.getLong("specId");
			}
		public void setSpecId(Long specId) {
			this.set("specId",specId);
			}
		
		public String getSpecInfo() {
			return this.getString("specInfo");
			}
		public void setSpecInfo(String specInfo) {
			this.set("specInfo",specInfo);
			}
		
		public BigDecimal getGoodsStorePrice() {
			return this.getBigDecimal("goodsStorePrice");
			}
		public void setGoodsStorePrice(BigDecimal goodsStorePrice) {
			this.set("goodsStorePrice",goodsStorePrice);
			}
		
		public Long getGoodsNum() {
			return this.getLong("goodsNum");
			}
		public void setGoodsNum(Long goodsNum) {
			this.set("goodsNum",goodsNum);
			}
		
		public String getGoodsImages() {
			return this.getString("goodsImages");
			}
		public void setGoodsImages(String goodsImages) {
			this.set("goodsImages",goodsImages);
			}
		
		public Long getFirstGcId() {
			return this.getLong("firstGcId");
			}
		public void setFirstGcId(Long firstGcId) {
			this.set("firstGcId",firstGcId);
			}
}
