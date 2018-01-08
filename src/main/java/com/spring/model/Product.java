package com.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Product  implements Serializable
{
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue
private int pid;
private String pname;
private String description;
private double price;
private int stock;
private String imgName;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="cid")
private Category category;

 @ManyToOne(fetch=FetchType.EAGER)
 @JoinColumn(name="sid")
 private Supplier supplier;
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}

public String getImgName() {
	return imgName;
}
public void setImgName(String imgName) {
	this.imgName = imgName;
}
 
}
