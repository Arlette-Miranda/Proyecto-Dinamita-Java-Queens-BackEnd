package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Sizes;
import com.yoatzin.app.repository.SizesRepository;
import com.yoatzin.app.service.SizesService;
import com.yoatzin.app.util.SizesUpdater;

@Service
public class SizesServiceImpl implements SizesService {
    
    //@Autowired
    SizesRepository sizesRepository;
    
    public SizesServiceImpl(SizesRepository sizesRepository) {
        this.sizesRepository = sizesRepository;
    }
    
    @Override
    public Sizes createSizes(Sizes sizes) {
    	sizes.setId_size(null);
        Sizes newSizes = sizesRepository.save(sizes);
        return newSizes;
    }
    
    private Sizes saveSizes(Sizes sizes) {
    	return sizesRepository.save(sizes);
    }


	@Override
	public Sizes getSizesById(Long id) {
		Optional<Sizes> optionalSizes = sizesRepository.findById(id);
        if (optionalSizes.isEmpty()) {
            throw new IllegalStateException("Sizes does not exist with id " + id);
        }
        return optionalSizes.get();
	}

	@Override
	public Sizes getSizesBySize(String size) {
		Optional<Sizes> optionalSizes = sizesRepository.findBySize(size);
        if (optionalSizes.isEmpty()) {
            throw new IllegalStateException("Sizes does not exist with size " + size);
        }
        return optionalSizes.get();
	}

	@Override
	public Sizes updateSizes(Sizes newSizesData, Long id) {
		Sizes existingSizes = getSizesById(id);         
		return SizesUpdater.updateSizes(existingSizes, newSizesData);
	}

	@Override
	public void deleteSizes(Long id) {
		Sizes existingSizes = getSizesById(id); 
		saveSizes(existingSizes);
	}
}
