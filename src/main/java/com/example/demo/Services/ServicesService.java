package com.example.demo.Services;

import com.example.demo.Models.Services;
import com.example.demo.Repositories.ServicesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicesService {

    private final ServicesRepository servicesRepository;

    @Transactional(readOnly = true)
    public List<Services> getAllServices() {
        return (List<Services>) servicesRepository.findAll();
    }
    @Transactional
    public void createService(Services service) {
        servicesRepository.save(service);
    }

    @Transactional
    public Services getServiceById(Long id) {
        return servicesRepository.findById(id).orElse(null);
    }

    @Transactional
    public Services updateService(Services service) {
        if (servicesRepository.existsById(service.getId())) {
            return servicesRepository.save(service);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteServiceById(Long id) {
        servicesRepository.deleteById(id);
    }
}
