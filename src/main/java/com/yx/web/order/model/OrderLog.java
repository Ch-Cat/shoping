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
 *	订单管理
 */
@SuppressWarnings({ "unused"})
@Table(name="shop_order_log")
public class OrderLog extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private Long orderId;
public Long getOrderId() {return this.getLong("orderId");}
public void setOrderId(Long orderId) {this.set("orderId",orderId);}
private String orderState;
public String getOrderState() {return this.getString("orderState");}
public void setOrderState(String orderState) {this.set("orderState",orderState);}
private String changeState;
public String getChangeState() {return this.getString("changeState");}
public void setChangeState(String changeState) {this.set("changeState",changeState);}
private String stateInfo;
public String getStateInfo() {return this.getString("stateInfo");}
public void setStateInfo(String stateInfo) {this.set("stateInfo",stateInfo);}
private Long createTime;
public Long getCreateTime() {return this.getLong("createTime");}
public void setCreateTime(Long createTime) {this.set("createTime",createTime);}
private String operator;
public String getOperator() {return this.getString("operator");}
public void setOperator(String operator) {this.set("operator",operator);}


}
