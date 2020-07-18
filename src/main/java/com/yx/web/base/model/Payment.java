package com.yx.web.base.model;

import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.yx.common.base.BaseEntity;


/**
 * 
 *	结算信息
 */
@SuppressWarnings({ "unused"})
@Table(name="shop_Payment")
public class Payment extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		private String paymentCode;
  		private String paymentName;
  		private String paymentConfig;
  		private String paymentState;
  		private Integer isDel;
  		private Long createTime;
  		private Long updateTime;
  		private String paymentLogo;
  		
		public Payment() {
			super();
		}
		
		public Payment(String paymentCode, String paymentName, String paymentConfig, String paymentState, Integer isDel,
				Long createTime, Long updateTime, String paymentLogo) {
			super();
			this.paymentCode = paymentCode;
			this.paymentName = paymentName;
			this.paymentConfig = paymentConfig;
			this.paymentState = paymentState;
			this.isDel = isDel;
			this.createTime = createTime;
			this.updateTime = updateTime;
			this.paymentLogo = paymentLogo;
		}

		public String getPaymentCode() {
			return paymentCode;
		}
		public void setPaymentCode(String paymentCode) {
			this.paymentCode = paymentCode;
		}
		public String getPaymentName() {
			return paymentName;
		}
		public void setPaymentName(String paymentName) {
			this.paymentName = paymentName;
		}
		public String getPaymentConfig() {
			return paymentConfig;
		}
		public void setPaymentConfig(String paymentConfig) {
			this.paymentConfig = paymentConfig;
		}
		public String getPaymentState() {
			return paymentState;
		}
		public void setPaymentState(String paymentState) {
			this.paymentState = paymentState;
		}
		public Integer getIsDel() {
			return isDel;
		}
		public void setIsDel(Integer isDel) {
			this.isDel = isDel;
		}
		public Long getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Long createTime) {
			this.createTime = createTime;
		}
		public Long getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Long updateTime) {
			this.updateTime = updateTime;
		}
		public String getPaymentLogo() {
			return paymentLogo;
		}
		public void setPaymentLogo(String paymentLogo) {
			this.paymentLogo = paymentLogo;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
  		
  		

}
