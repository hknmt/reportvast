package com.viettelmor.reportvast.Service;

import com.viettelmor.reportvast.BusinessObject.ServiceConfig;
import com.viettelmor.reportvast.DataAccessObject.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceConfigImpl implements ServiceConfigService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<ServiceConfig> getAll() {
        return serviceRepository.findAll();
    }
}
