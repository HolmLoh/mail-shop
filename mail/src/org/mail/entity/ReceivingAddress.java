/***********************************************************************
 * Module:  ReceivingAddress.java
 * Author:  VIC
 * Purpose: Defines the Class ReceivingAddress
 ***********************************************************************/
package org.mail.entity;

/** 收货地址 */
public class ReceivingAddress {
	
	public static final String DISABLED  = "DISABLED";
	public static final String ENABLED  = "ENABLED";
	
   /** ID */
	private double raId;
   /** 国家 */
   private java.lang.String raCountry;
   /** 省 */
   private java.lang.String raProvince;
   /** 市 */
   private java.lang.String raCity;
   /** 详细地址 */
   private java.lang.String raDetail;
   /** 收货人姓名 */
   private java.lang.String raPerson;
   /** 收货人手机 */
   private double raPhone;
   /** 状态 */
   private java.lang.String state;
   /** 用户ID */
   private double userId;
   /** 创建时间 */
   private Object createTime;
   /** 更新时间 */
   private Object updateTime;
public double getRaId() {
	return raId;
}
public void setRaId(double raId) {
	this.raId = raId;
}
public java.lang.String getRaCountry() {
	return raCountry;
}
public void setRaCountry(java.lang.String raCountry) {
	this.raCountry = raCountry;
}
public java.lang.String getRaProvince() {
	return raProvince;
}
public void setRaProvince(java.lang.String raProvince) {
	this.raProvince = raProvince;
}
public java.lang.String getRaCity() {
	return raCity;
}
public void setRaCity(java.lang.String raCity) {
	this.raCity = raCity;
}
public java.lang.String getRaDetail() {
	return raDetail;
}
public void setRaDetail(java.lang.String raDetail) {
	this.raDetail = raDetail;
}
public java.lang.String getRaPerson() {
	return raPerson;
}
public void setRaPerson(java.lang.String raPerson) {
	this.raPerson = raPerson;
}
public double getRaPhone() {
	return raPhone;
}
public void setRaPhone(double raPhone) {
	this.raPhone = raPhone;
}
public java.lang.String getState() {
	return state;
}
public void setState(java.lang.String state) {
	this.state = state;
}
public double getUserId() {
	return userId;
}
public void setUserId(double userId) {
	this.userId = userId;
}
public Object getCreateTime() {
	return createTime;
}
public void setCreateTime(java.sql.Timestamp createTime) {
	this.createTime = createTime;
}
public Object getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(java.sql.Timestamp updateTime) {
	this.updateTime = updateTime;
}
public static String getDisabled() {
	return DISABLED;
}
public static String getEnabled() {
	return ENABLED;
}
@Override
public String toString() {
	return "ReceivingAddress [raId=" + raId + ", raCountry=" + raCountry + ", raProvince=" + raProvince + ", raCity="
			+ raCity + ", raDetail=" + raDetail + ", raPerson=" + raPerson + ", raPhone=" + raPhone + ", state=" + state
			+ ", userId=" + userId + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
}

}