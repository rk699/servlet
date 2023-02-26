package com.purusottam.regionf.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.purusottam.regionf.dao.Merchantdao;
import com.purusottam.regionf.model.Merchant;

@WebServlet("/merchant")
public class MerchantServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Merchantdao merchantdao;
	
	public MerchantServlet() {
		// TODO Auto-generated constructor stub
	}
	public void init() {
		merchantdao = new Merchantdao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action1 = request.getServletPath();
		System.out.println(action1);
		System.out.println(action1);
		System.out.println("Entered1");

		try {
			switch (action1) {
			case "/merchant/news":
				System.out.println("Entered2");
				showNewForm1(request, response);
				break;
			case "/merchant/insert":
				insertMerchant(request, response);
				break;
			case "/merchant/delete":
				deleteUser1(request, response);
				break;
//			case "/merchant/edit":
//				showEditForm(request, response);
//				break;
//			case "/merchant/update":
//				updateUser(request, response);
//				break;
			default:
				listMerchant(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void deleteUser1(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		merchantdao.deleteUser1(m_id);
		response.sendRedirect(request.getServletPath()+"merchant");
		System.out.println(request.getServletPath()+"merchant");

	}
	
	private void insertMerchant(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		String m_name = request.getParameter("m_name");
		String m_mail = request.getParameter("m_mail");
		String m_address = request.getParameter("m_address");
		String m_phone = request.getParameter("m_phone");
		String m_pincode = request.getParameter("m_pincode");
		String receipe_style = request.getParameter("receipe_style");
		String receipe_price = request.getParameter("receipe_price");
		Merchant merchantuser=new Merchant(m_id,m_name,m_mail,m_address,m_phone,m_pincode,receipe_price,receipe_style);
		merchantdao.insertMerchant(merchantuser);
		response.sendRedirect("merchant");
	}
	
	private void listMerchant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Merchant> listMerchant = merchantdao.selectAllMerchants();
		request.setAttribute("listMerchant", listMerchant);
		RequestDispatcher dispatcher = request.getRequestDispatcher("merchantlist.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("merchantform.jsp");
		dispatcher.forward(request, response);
	}

}
