package com.charts.demo.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Request {
	
	@Id
    public String id;

    public String Name;
    public String Quantity;

    public Request() {}

    public Request(String Name, String Quantity) {
        this.Name = Name;
        this.Quantity = Quantity;
    }
    
	public String getId() {
		return id;
	}
	
		public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

}
