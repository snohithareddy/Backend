package com.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Supplier implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue
		private int Sid;
		private String SupplierName;
		public int getSid() {
			return Sid;
		}
		public void setSid(int sid) {
			Sid = sid;
		}
		public String getSupplierName() {
			return SupplierName;
		}
		public void setSupplierName(String supplierName) {
			SupplierName = supplierName;
		}
		
		
	}

