package com.yoatzin.app.dto;

public class SizesDto{
	private Long serialnumber;
	private String size;
	
	public SizesDto() {}

	public Long getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(Long serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}