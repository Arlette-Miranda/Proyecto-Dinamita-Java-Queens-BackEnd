package com.yoatzin.app.util;

import com.yoatzin.app.model.Size;

public class SizeUpdater{
	
	private SizeUpdater() {}
	
	public static Size updateSizes(Size existingSizes, Size newSizesData) {
		if (existingSizes == null || newSizesData == null) {
            throw new IllegalArgumentException("Size data cannot be null");
		}
		
	existingSizes.setSize(newSizesData.getSize());
	
	return existingSizes;
	}
}