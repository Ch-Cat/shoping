package com.yx.web.test.model;

import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.yx.common.base.BaseEntity;


/**
 *	test管理
 */
@SuppressWarnings({ "unused"})
@Table(name="test_user")
public class TestUser extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private String username;
public String getUsername() {return this.getString("username");}
public void setUsername(String username) {this.set("username",username);}
private String password;
public String getPassword() {return this.getString("password");}
public void setPassword(String password) {this.set("password",password);}
private String nickname;
public String getNickname() {return this.getString("nickname");}
public void setNickname(String nickname) {this.set("nickname",nickname);}


}
