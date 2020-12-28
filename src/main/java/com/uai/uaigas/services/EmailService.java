package com.uai.uaigas.services;

import org.springframework.mail.SimpleMailMessage;

import com.uai.uaigas.entities.Usuario;

public interface EmailService {
    
    void sendNewPasswordEmail(Usuario usuario, String newPassword);
    
    void sendEmail(SimpleMailMessage mail);

}
