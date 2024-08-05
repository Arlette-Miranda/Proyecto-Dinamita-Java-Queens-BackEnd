package com.yoatzin.app.util;

import java.util.ArrayList;
import java.util.List;

import com.yoatzin.app.model.Sizes;

public class SizesGenerator{
	
	private SizesGenerator() {}
	
	public static List<Sizes> generateRandomSizes (int quantity){
		List<Sizes> sizes = new ArrayList<>();
		
		for (int i = 0; i < quantity; i++) {
			sizes.add(generateRandomSizes());
        }

        return sizes;
	}

	private static Sizes generateRandomSizes() {
		return null;
	}
}