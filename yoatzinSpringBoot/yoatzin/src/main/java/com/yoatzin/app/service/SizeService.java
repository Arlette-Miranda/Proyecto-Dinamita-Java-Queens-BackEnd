package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Size;

@Service
public interface SizeService {
	
	Size createSizes(Size size);
	Size getSizesById(Long id);
	Size getSizesBySize(String size);
	Size updateSizes(Size size,Long id);
	void deleteSizes(Long id);

}
