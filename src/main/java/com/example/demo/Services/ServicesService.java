package com.example.demo.Services;

import com.example.demo.Models.Services;
import com.example.demo.Repositories.ServicesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicesService {

    private final ServicesRepository servicesRepository;

    public List<Services> getAllServices() {
        return (List<Services>) servicesRepository.findAll();
    }

    public void createService(Services service) {
        servicesRepository.save(service);
    }

    public Services getServiceById(Long id) {
        return servicesRepository.findById(id).orElse(null);
    }

    public Services updateService(Services service) {
        if (servicesRepository.existsById(service.getId())) {
            return servicesRepository.save(service);
        } else {
            return null;
        }
    }

    public void deleteServiceById(Long id) {
        servicesRepository.deleteById(id);
    }
}
