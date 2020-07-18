package com.yx.web.user.model;

import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.yx.common.base.BaseEntity;


/**
 *	会员管理管理
 */
@SuppressWarnings({ "unused"})
@Table(name="shop_member_grade")
public class MemberGrade extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private String gradeName;
public String getGradeName() {return this.getString("gradeName");}
public void setGradeName(String gradeName) {this.set("gradeName",gradeName);}
private Integer integration;
public Integer getIntegration() {return this.getInteger("integration");}
public void setIntegration(Integer integration) {this.set("integration",integration);}
private String gradeImg;
public String getGradeImg() {return this.getString("gradeImg");}
public void setGradeImg(String gradeImg) {this.set("gradeImg",gradeImg);}
private Integer preferential;
public Integer getPreferential() {return this.getInteger("preferential");}
public void setPreferential(Integer preferential) {this.set("preferential",preferential);}
private Integer isDefault;
public Integer getIsDefault() {return this.getInteger("isDefault");}
public void setIsDefault(Integer isDefault) {this.set("isDefault",isDefault);}


}
