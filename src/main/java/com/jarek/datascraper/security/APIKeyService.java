package com.jarek.datascraper.security;

public interface APIKeyService {

    String generateKey();

    String generateDigest(String key);


}
