package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Sizes;

@Service
public interface SizesService {
	
	Sizes createSizes(Sizes sizes);
	Sizes getSizesById(Long id);
	Sizes getSizesBySize(String size);
	Sizes updateSizes(Sizes sizes,Long id);
	void deleteSizes(Long id);

}