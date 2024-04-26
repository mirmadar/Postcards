package com.example.demo.Controllers;

import com.example.demo.Models.Services;
import com.example.demo.Services.ServicesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@Controller
public class ServicesController {
    private final ServicesService servicesService;
    private final ImageUploadController imageUploadController;

    @GetMapping("/")
    public String redirectToPublic() {
        return "redirect:/public";
    }

    @GetMapping("/public")
    public String getServicesOnIndexPage(Model model) {
        model.addAttribute("services", servicesService.getAllServices());
        return "index";
    }

    @GetMapping("/public/services")
    public String getServicesOnServicesPage(Model model) {
        model.addAttribute("services", servicesService.getAllServices());
        return "services";
    }

    @GetMapping("/admin/control_panel")
    public String showServices(Model model) {
        model.addAttribute("services", servicesService.getAllServices());
        return "control_panel";
    }

    @PostMapping("/admin/control_panel")
    public String createService(@RequestParam("name") String name,
                                @RequestParam("price") String price,
                                @RequestParam("image") MultipartFile image) {
        if (image.isEmpty()) {
            return "redirect:/error";
        }

        String fileName = imageUploadController.uploadImage(image);
        if (fileName == null) {
            return "redirect:/error";
        }

        Services service = new Services();
        service.setName(name);
        service.setPrice(price);
        service.setImage(fileName);
        servicesService.createService(service);

        return "redirect:/admin/control_panel";
    }

    @PostMapping("/admin/control_panel/update")
    public String updateService(@RequestParam("id") Long id,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "price", required = false) String price,
                                @RequestParam(value = "image", required = false) MultipartFile image) {
        Services service = servicesService.getServiceById(id);
        if (service == null) {
            return "redirect:/error";
        }

        if (name != null && !name.isEmpty()) {
            service.setName(name);
        }
        if (price != null && !price.isEmpty()) {
            service.setPrice(price);
        }
        if (image != null && !image.isEmpty()) {
            String fileName = imageUploadController.uploadImage(image);
            if (fileName != null) {
                service.setImage(fileName);
            }
        }
        servicesService.updateService(service);

        return "redirect:/admin/control_panel";
    }

    @PostMapping("/admin/control_panel/delete")
    public String deleteService(@RequestParam("id") Long id) {
        if (servicesService.getServiceById(id) == null) {
            return "redirect:/error";
        }
        servicesService.deleteServiceById(id);

        return "redirect:/admin/control_panel";
    }
}