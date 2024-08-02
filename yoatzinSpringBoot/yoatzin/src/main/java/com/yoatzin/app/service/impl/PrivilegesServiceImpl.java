package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Privileges;
import com.yoatzin.app.repository.PrivilegesRepository;
import com.yoatzin.app.service.PrivilegesService;

@Service
public class PrivilegesServiceImpl implements PrivilegesService {
    
    //@Autowired
    PrivilegesRepository privilegesRepository;
    
    public PrivilegesServiceImpl(PrivilegesRepository privilegesRepository) {
        this.privilegesRepository = privilegesRepository;
    }
    
    @Override
    public Privileges createPrivileges(Privileges privileges) {
        Privileges newPrivileges = privilegesRepository.save(privileges);
        return newPrivileges;
    }
}
