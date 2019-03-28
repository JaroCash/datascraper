package com.jarek.datascraper.security;

import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

@Service
public class APIKeyServiceImpl implements APIKeyService {

    @Override
    public String generateKey() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public String generateDigest(String key) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(key.getBytes("UTF-8"));
            byte[] digest = md.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
