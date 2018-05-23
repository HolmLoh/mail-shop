package org.mail.servlet.receivingAddress;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mail.common.ResponseBody;
import org.mail.service.receivingAddress.ReceivingAddressService;
import org.mail.util.StringUtil;

/**
 * 收货地址servlet
 * 
 * @author Louis Lo
 *
 */
@WebServlet("/person/ReceivingAddressServlet")
public class ReceivingAddressServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/** 国家 */
		String raCountry = req.getParameter("country");
		/** 省 */
		String raProvince = req.getParameter("province");
		/** 市 */
		String raCity = req.getParameter("city");
		/** 详细地址 */
		String raDetail = req.getParameter("user-intro");
		/** 用户名 */
		String raPeson = req.getParameter("user-name");
		ResponseBody responseBody = new ResponseBody();
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		boolean exists = false;
		//判断是否为空，然后执行checkReceivingAddress方法检查数据
		if (StringUtil.isNotEmpty(raCountry) || StringUtil.isNotEmpty(raProvince) || StringUtil.isNotEmpty(raCity)
				|| StringUtil.isNotEmpty(raDetail)) {
			exists = receivingAddressService.checkReceivingAddress(raCountry, raProvince, raCity, raDetail, raPeson);
		}
		//判断地址是否已经存在
		if (exists) {
			responseBody.setStatus(-1);
			responseBody.setMessage("已经创建该地址！");
			resp.getWriter().write(responseBody.toJson());
			return;
		}
	}

	// 添加地址
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/** 国家 */
		String raCountry = req.getParameter("country");
		/** 省 */
		String raProvince = req.getParameter("province");
		/** 市 */
		String raCity = req.getParameter("city");
		/** 详细地址 */
		String raDetail = req.getParameter("user-intro");
		/** 收货人姓名 */
		String raPerson = req.getParameter("user-name");
		/** 收货人手机 */
		String raPhone = req.getParameter("user-phone");
		// 创建收货地址类
		// 验证添加信息
		ResponseBody responseBody = new ResponseBody();
		
		//判断如果为空，return
		if (StringUtil.isEmpty(raCountry) || StringUtil.isEmpty(raProvince) || StringUtil.isEmpty(raCity)
				|| StringUtil.isEmpty(raDetail) || StringUtil.isEmpty(raPerson) || StringUtil.isEmpty(raPhone)) {
			responseBody.setStatus(-1);
			responseBody.setMessage("添加参数不能为空.");
			resp.getWriter().write(responseBody.toJson());
			return;
		}
		
		// 验证账号唯一性
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		boolean exists = false;
		//判断账号如果不是为空，则调用checkReceivingAddress方法检查是否地址已经存在
		if (StringUtil.isNotEmpty(raCountry) || StringUtil.isNotEmpty(raProvince) || StringUtil.isNotEmpty(raCity)
				|| StringUtil.isNotEmpty(raDetail)) {
			exists = receivingAddressService.checkReceivingAddress(raCountry, raProvince, raCity, raDetail, raPerson);
		}
		//判断如果存在，return
		if (exists) {
			responseBody.setStatus(-1);
			responseBody.setMessage("已经创建该地址！");
			resp.getWriter().write(responseBody.toJson());
			return;
		}

		// 调用业务类进行添加地址
		int modify = 0;
		modify = receivingAddressService.addReceivingAddress(raPerson, raPhone, raCountry, raProvince, raCity,
				raDetail);
		//返回添加信息
		if (modify > 0) {
			responseBody.setMessage("添加成功！");
		} else {
			responseBody.setMessage("添加失败！");
		}
		resp.getWriter().write(responseBody.toJson());
	};

}
