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
import org.mail.service.receivingAddress.AddressShowService;
import org.mail.util.JsonUtil;

/**
 * Servlet implementation class AddressShowServlet
 */
@WebServlet("/AddressShowServlet")
public class AddressShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



    //查询收货地址
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseBody responseBdoy = new ResponseBody();
		AddressShowService addressShowService = new AddressShowService();
		//用户id
		String userid = null;
		//按照ID查询
		String sql = "select * from Receiving_address where userid = ?";
		List<Map<String,Object>> listResult = addressShowService.get(sql,1);
		//把数组返回
		String JsonData = JsonUtil.toJson(listResult);
		responseBdoy.setData(JsonData);
        response.getWriter().write(responseBdoy.toJson());
	}



}
