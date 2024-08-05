package com.yoatzin.app.service;

import com.yoatzin.app.dto.SizesDto;
import com.yoatzin.app.model.Sizes;

public interface SizesDtoService{

	SizesDto createSizes(Sizes sizes);
	SizesDto getSizesById(Long id);
	SizesDto getSizesBySize(String size);
	SizesDto updateSizes(Sizes sizes,Long id);
	void deleteSizes(Long id);
}