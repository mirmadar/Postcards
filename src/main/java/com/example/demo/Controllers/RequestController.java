package com.example.demo.Controllers;

import com.example.demo.DTO.RequestForm;
import com.example.demo.Services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping("/public/submit-request")
    public String submitRequest(@ModelAttribute RequestForm requestForm) {
        requestService.saveRequest(requestForm);
        requestService.sendEmail(requestForm.getName(), requestForm.getPhoneNumber());
        return "gratitude";
    }
}
