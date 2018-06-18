package com.admin.product.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product implements Serializable{
		
	private static final long serialVersionUID=748392348L;
		
		@NotNull
		@Size(min=1,max=50)
		private String name;
		
		private String description;
		
		@Min(value = 0)
		private float price;
		
		private int id;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		
		public String getDescription() {
			return description;
		}
		
		public void setDescription(String description) {
			this.description=description;
		}
		
		public float getPrice() {
			return price;
		}
		
		public void setPrice(float price) {
			this.price=price;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id=id;
		}
}
