package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Size;
import com.yoatzin.app.repository.SizeRepository;
import com.yoatzin.app.service.SizeService;
import com.yoatzin.app.util.SizeUpdater;

@Service
public class SizeServiceImpl implements SizeService {
    
    //@Autowired
    SizeRepository sizeRepository;
    
    public SizeServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }
    
    @Override
    public Size createSizes(Size size) {
    	size.setId_size(null);
        Size newSizes = sizeRepository.save(size);
        return newSizes;
    }
    
    private Size saveSizes(Size size) {
    	return sizeRepository.save(size);
    }


	@Override
	public Size getSizesById(Long id) {
		Optional<Size> optionalSizes = sizeRepository.findById(id);
        if (optionalSizes.isEmpty()) {
            throw new IllegalStateException("Size does not exist with id " + id);
        }
        return optionalSizes.get();
	}

	@Override
	public Size getSizesBySize(String size) {
		Optional<Size> optionalSizes = sizeRepository.findBySize(size);
        if (optionalSizes.isEmpty()) {
            throw new IllegalStateException("Size does not exist with size " + size);
        }
        return optionalSizes.get();
	}

	@Override
	public Size updateSizes(Size newSizesData, Long id) {
		Size existingSizes = getSizesById(id);         
		return SizeUpdater.updateSizes(existingSizes, newSizesData);
	}

	@Override
	public void deleteSizes(Long id) {
		Size existingSizes = getSizesById(id); 
		saveSizes(existingSizes);
	}
}
