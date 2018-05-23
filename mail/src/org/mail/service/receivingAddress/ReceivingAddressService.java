package org.mail.service.receivingAddress;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Assert;
import org.mail.entity.ReceivingAddress;
import org.mail.entity.Users;
import org.mail.jdbc.JdbcTemplate;
import org.mail.service.user.UsersService;
import org.mail.util.MD5Util;

/**
 * 收货地址业务类(DAO)
 * 
 * @author Louis Lo
 *
 */

public class ReceivingAddressService extends JdbcTemplate<ReceivingAddress> {

	// 检查数据
	/*
	 * public List<ReceivingAddress> testReceivingAddressQuery(){
	 * ReceivingAddressService receivingAddressService = new
	 * ReceivingAddressService(); List<ReceivingAddress> receivingAddress =
	 * receivingAddressService.quary("select * from receiving_address");
	 * System.out.println(receivingAddress); return receivingAddress; }
	 */
	
	// 检查收货地址
	public boolean checkReceivingAddress(String raCountry, String raProvince, String raCity, String raDetail,
			String rapreson) {
		return exists(
				"select * from Receiving_Address where racountry = ? and raprovince = ? and racity = ? and radetail = ? and RAPERSON = ? ",
				raCountry, raProvince, raCity, raDetail ,rapreson);
	}

	// 添加数据
	public int addReceivingAddress(String raPerson, String raPhone, String raCountry, String raProvince, String raCity,
			String raDetail) {
		Object[] parms = {raCountry, raProvince, raCity, raDetail, raPerson, raPhone, ReceivingAddress.ENABLED, 1,
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()) };
		return execute("insert into receiving_address values( ADDRESS_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)", parms);
	}
}
