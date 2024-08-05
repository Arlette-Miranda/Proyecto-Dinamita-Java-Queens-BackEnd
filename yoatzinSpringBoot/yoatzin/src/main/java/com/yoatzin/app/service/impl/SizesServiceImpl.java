package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Sizes;
import com.yoatzin.app.repository.SizesRepository;
import com.yoatzin.app.service.SizesService;

@Service
public class SizesServiceImpl implements SizesService {
    
    //@Autowired
    SizesRepository sizesRepository;
    
    public SizesServiceImpl(SizesRepository sizesRepository) {
        this.sizesRepository = sizesRepository;
    }
    
    @Override
    public Sizes createSizes(Sizes sizes) {
        Sizes newSizes = sizesRepository.save(sizes);
        return newSizes;
    }
}
