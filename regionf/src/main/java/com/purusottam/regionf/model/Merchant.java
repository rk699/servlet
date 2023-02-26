package com.purusottam.regionf.model;

public class Merchant {
	protected int m_id;
	protected String m_name;
	protected String m_mail;
	protected String m_address;
	protected String m_phone;
	protected String m_pincode;
	protected String receipe_style;
	protected String receipe_price;
	
	

	public Merchant() {
		
	}



	public Merchant(int m_id, String m_name, String m_mail, String m_address, String m_phone, String m_pincode,
			String receipe_style, String receipe_price) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_mail = m_mail;
		this.m_address = m_address;
		this.m_phone = m_phone;
		this.m_pincode = m_pincode;
		this.receipe_style = receipe_style;
		this.receipe_price = receipe_price;
	}



	public int getM_id() {
		return m_id;
	}



	public void setM_id(int m_id) {
		this.m_id = m_id;
	}



	public String getM_name() {
		return m_name;
	}



	public void setM_name(String m_name) {
		this.m_name = m_name;
	}



	public String getM_mail() {
		return m_mail;
	}



	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}



	public String getM_address() {
		return m_address;
	}



	public void setM_address(String m_address) {
		this.m_address = m_address;
	}



	public String getM_phone() {
		return m_phone;
	}



	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}



	public String getM_pincode() {
		return m_pincode;
	}



	public void setM_pincode(String m_pincode) {
		this.m_pincode = m_pincode;
	}



	public String getReceipe_style() {
		return receipe_style;
	}



	public void setReceipe_style(String receipe_style) {
		this.receipe_style = receipe_style;
	}



	public String getReceipe_price() {
		return receipe_price;
	}



	public void setReceipe_price(String receipe_price) {
		this.receipe_price = receipe_price;
	}



	



	}
