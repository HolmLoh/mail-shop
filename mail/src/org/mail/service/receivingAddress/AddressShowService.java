package org.mail.service.receivingAddress;

import java.util.List;
import java.util.Map;

import org.mail.entity.ReceivingAddress;
import org.mail.jdbc.JdbcTemplate;

public class AddressShowService extends JdbcTemplate<ReceivingAddress>{
	//返回一个数组
	public List<Map<String, Object>> get(String sql,Object...args) {
		return findAllAttribute(sql,args);
	}

}
