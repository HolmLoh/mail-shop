package org.mail.service.receivingAddress;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mail.entity.ReceivingAddress;
import org.mail.entity.Users;
import org.mail.service.user.UsersService;


/**
 * 收货地址测试类
 * @author Louis Lo
 *
 */
public class ReceivingAddressServiceTest {
	/*		RA_ID       NUMBER                        ID       
	RA_COUNTRY  VARCHAR2(32) Y                国家     
	RA_PROVINCE VARCHAR2(32) Y                省       
	RA_CITY     VARCHAR2(32) Y                市       
	RA_DETAIL   VARCHAR2(32) Y                详细地址 
	RA_PERSON   VARCHAR2(52) Y                收货人姓名 
	RA_PHONE    NUMBER       Y                收货人手机 
	STATE       VARCHAR2(32) Y                状态     
	U_ID        NUMBER       Y                用户ID   
	CREATE_TIME TIMESTAMP(6) Y                创建时间 
	UPDATE_TIME TIMESTAMP(6) Y                更新时间 
	*/
	/*
	//添加测试
	@Test
	public void testReceivingAddressExecute(){
		

		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		Object[] parms = {2,"中国","广东","广州",
				"海珠区","赵铁蛋",132555555,"enabled",
				2,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis())};
		
		int modify = receivingAddressService.execute("insert into receiving_address values(?,?,?,?,?,?,?,?,?,?,?)",
				parms);
		
		Assert.assertTrue(modify>0);
	}

	//查询测试
	@Test
	public void testReceivingAddressQuery(){
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		List<ReceivingAddress> receivingAddress = receivingAddressService.quary("select * from receiving_address");
		System.out.println(receivingAddress);
		Assert.assertTrue(receivingAddress.size()>0);
	}
	*/
	
	
	//检查测试
	@Test
	public void testReceivingAddresscheck(){
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		boolean modify = receivingAddressService.exists("select * from Receiving_Address where racountry = ? and raprovince = ? and racity = ? and radetail = ?","中国","广东","广州","海珠区");
		System.out.println(modify);
		Assert.assertTrue(modify);
	}

}
