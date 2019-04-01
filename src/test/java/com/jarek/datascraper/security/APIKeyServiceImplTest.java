package com.jarek.datascraper.security;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class APIKeyServiceImplTest {

    private static APIKeyServiceImpl keyService;


    @BeforeAll
    public static void setUp() {
     keyService = new APIKeyServiceImpl();
    }

    @Test
    public void shouldReturnUUIDAsString() {

        System.out.println(keyService.generateKey());
    }

    @Test
    public void shouldGenerateDigestFromUUID() {

        assertAll(
                ()-> assertEquals("730d723e03aa6793b5dc35b5f31cea0b4e816dc20eb596624b6dd20ec9bbe20a", keyService.generateDigest("1297f571-3554-4c92-89cd-f6ef2609a7fc")),
                ()-> assertEquals("f0e5be2d4109c749c9d01e2747476cfc2c54accfda8d9170dd51cbc595ccd7f6", keyService.generateDigest("54b3244d-ca31-4f5a-91db-0c83ca06262f")),
                ()-> assertEquals("ae817eb5f964a178e51b4ddbb1e2101306039d9662eba83b40f77f13cac024a6", keyService.generateDigest("40bca910-ed8e-4370-bbe6-399a3b8e3b66"))
        );

    }
}
