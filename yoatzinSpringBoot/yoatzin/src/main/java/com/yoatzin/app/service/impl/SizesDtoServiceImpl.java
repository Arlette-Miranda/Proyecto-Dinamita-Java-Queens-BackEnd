package com.yoatzin.app.service.impl;

import com.yoatzin.app.dto.SizesDto;
import com.yoatzin.app.model.Sizes;
import com.yoatzin.app.service.SizesDtoService;
import com.yoatzin.app.service.SizesService;

public class SizesDtoServiceImpl implements SizesDtoService{
	
	SizesService sizesService;
	
	public SizesDtoServiceImpl(SizesService sizesService) {
		this.sizesService = sizesService;
	}
	@Override
	public SizesDto createSizes(Sizes sizes) {
		Sizes newSizes = sizesService.createSizes(sizes);
		SizesDto newSizesDto = new SizesDto();
		newSizesDto.setSerialnumber(newSizes.getId_size());
		newSizesDto.setSize(newSizes.getSize());
		
		return newSizesDto;
	}
	@Override
	public SizesDto getSizesById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SizesDto getSizesBySize(String size) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SizesDto updateSizes(Sizes sizes, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteSizes(Long id) {
		// TODO Auto-generated method stub
		
	}
}