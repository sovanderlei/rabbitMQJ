package com.ms.rabbitMQJ.modal;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity 
@Table(name="tbOrderSel")
public class TbOrderSel  implements Serializable { 
   
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")	
	@Column(name="id")  
	private int id;
	@Column(name="idSalesMan")  
	private int idSalesMan;	 
	@Column(name="idCompany")  
	private int idCompany;   
	@Column(name="idCustomer")  
	private int idCustomer;
	@Column(name="nameCustomer") 
	private String nameCustomer;
	@Column(name="idProduct")  
	private int idProduct; 	
	@Column(name="nameProduct") 
	private String nameProduct;  
	@Column(name="taxCouponNumber") 
	private String taxCouponNumber;  
	@Column(name="email") 
	private String email; 
	@Column(name="barcode") 
	private String barcode;	
	@Column(name="qrcode") 
	private String qrcode;			
	@Column(name="goal") 
	private Double goal;	
	@Column(name="goalAchieved") 
	private Double goalAchieved;		
	@Column(name="goalValue") 
	private Double goalValue; 
	@Column(name="unitQuantity") 
	private Double unitQuantity;	
	@Column(name="soldValue") 
	private Double soldValue;	 
	@Column(name="total") 
	private Double total;	 
	@Column(name="createdDate", nullable=false) 
	private Date createdDate;
	@Column(name="updatedDate", nullable=false)  
	private Date updatedDate;
	@Column(name="status") 
	private String status;	
	@Column(name="active") 
	private String active;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSalesMan() {
		return idSalesMan;
	}
	public void setIdSalesMan(int idSalesMan) {
		this.idSalesMan = idSalesMan;
	}
	public int getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getTaxCouponNumber() {
		return taxCouponNumber;
	}
	public void setTaxCouponNumber(String taxCouponNumber) {
		this.taxCouponNumber = taxCouponNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public Double getGoal() {
		return goal;
	}
	public void setGoal(Double goal) {
		this.goal = goal;
	}
	public Double getGoalAchieved() {
		return goalAchieved;
	}
	public void setGoalAchieved(Double goalAchieved) {
		this.goalAchieved = goalAchieved;
	}
	public Double getGoalValue() {
		return goalValue;
	}
	public void setGoalValue(Double goalValue) {
		this.goalValue = goalValue;
	}
	public Double getUnitQuantity() {
		return unitQuantity;
	}
	public void setUnitQuantity(Double unitQuantity) {
		this.unitQuantity = unitQuantity;
	}
	public Double getSoldValue() {
		return soldValue;
	}
	public void setSoldValue(Double soldValue) {
		this.soldValue = soldValue;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
	
	
	
			
	
}

