package com.project.model;

public class vehicleItem {
       private  String ItemName;
       private  String qun;
       private String name;
       
    public vehicleItem() {}   
       
	public vehicleItem(String itemName) {
		
		super();
		ItemName = itemName;
		
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getQun() {
		return qun;
	}
	public void setQun(String qun) {
		this.qun = qun;
	}
}
