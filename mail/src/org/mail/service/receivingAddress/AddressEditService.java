package org.mail.service.receivingAddress;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mail.common.ResponseBody;
import org.mail.entity.ReceivingAddress;
import org.mail.jdbc.JdbcTemplate;
import org.mail.util.JsonUtil;

public class AddressEditService extends JdbcTemplate<ReceivingAddress>{
	
	public List<Map<String, Object>> SelectAddress(String userid) {
		return findAllAttribute("select * from Receiving_address where RAID = ?",userid);
		
	}

}
