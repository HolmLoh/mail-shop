package org.mail.servlet.receivingAddress;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mail.common.ResponseBody;
import org.mail.entity.ReceivingAddress;
import org.mail.jdbc.JdbcTemplate;
import org.mail.service.receivingAddress.AddressEditService;
import org.mail.service.receivingAddress.AddressShowService;
import org.mail.util.JsonUtil;

/**
 * 根据RAID查询数据库
 * @author Administrator
 *
 */
@WebServlet("/AddressEditServlet")
public class AddressEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseBody responseBody = new ResponseBody();
		AddressEditService addressEditService = new AddressEditService();
		//用户id
		String userid =  request.getParameter("RAID");;
		List<Map<String,Object>> listResult = null;
		if(userid==null || userid.isEmpty()){
			responseBody.setStatus(-1);
			responseBody.setMessage("添加参数不能为空.");
			response.getWriter().write(responseBody.toJson());
			return;
		}
		
		 listResult = addressEditService.SelectAddress(userid);
		
		if (listResult.isEmpty()) {
			responseBody.setStatus(-1);
			responseBody.setMessage("查询不到数据！");
			response.getWriter().write(responseBody.toJson());
			return;
		}
		String JsonData = JsonUtil.toJson(listResult);
		responseBody.setData(JsonData);
        response.getWriter().write(responseBody.toJson());
	}



}
