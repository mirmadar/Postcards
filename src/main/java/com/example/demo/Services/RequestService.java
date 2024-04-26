package com.example.demo.Services;

import com.example.demo.Models.Request;
import com.example.demo.Repositories.RequestRepository;
import com.example.demo.DTO.RequestForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    public void saveRequest(RequestForm requestForm) {
        Request request = new Request();
        request.setName(requestForm.getName());
        request.setPhoneNumber(requestForm.getPhoneNumber());
        requestRepository.save(request);
    }

    public void sendEmail(String name, String phoneNumber) {
        String subject = "Новая заявка";
        String text = "Имя: " + name + "\nНомер телефона: " + phoneNumber;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("polinafreidman20024@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("nightpharmacy@mail.ru");
        javaMailSender.send(message);
    }
}
