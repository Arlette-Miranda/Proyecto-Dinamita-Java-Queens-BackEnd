package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Privileges;

@Service
public interface PrivilegesService {
	public Privileges createPrivileges(Privileges privileges);
}
