package com.yoatzin.app.util;

import com.yoatzin.app.model.Sizes;

public class SizesUpdater{
	
	private SizesUpdater() {}
	
	public static Sizes updateSizes(Sizes existingSizes, Sizes newSizesData) {
		if (existingSizes == null || newSizesData == null) {
            throw new IllegalArgumentException("Sizes data cannot be null");
		}
		
	existingSizes.setSize(newSizesData.getSize());
	
	return existingSizes;
	}
}