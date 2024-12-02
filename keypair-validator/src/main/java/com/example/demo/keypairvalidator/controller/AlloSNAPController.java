package com.example.demo.keypairvalidator.controller;

import com.example.demo.keypairvalidator.service.AlloSNAPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Formatter;
import java.util.HashMap;

@RestController
@RequestMapping(path = "/api/allo")
@Slf4j
public class AlloSNAPController {

    PrivateKey privateKey;
    PublicKey publicKey;

    @Autowired
    private AlloSNAPService snapService;

    @PostMapping("/req-b2b")
    private ResponseEntity<?> validate() {

        try {
            String clientId = "SNAP01DNA01";

            publicKey = convertStringToPublicKey("-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAroe8J9lXnrW9Og8MrGR0kIFCy7Yv6f56vZtUXhM6zpn26oBRASsCSWaHraZ0TwrHQO3dEqGoOQDSKMZdHK/MLsFejTYw0av2yh0IIM1ltJR8G9mdFtzgzTzsJNIwKhQdcGmnyHNi487JYDNVz3tnsf54FpmOn5DcR5r1XACRsQRDGbkZvdNjiuYVPoX1e/vwccxOIJWiHi2zubODsWc+YowDajMk7qpgeUOOo/ldGdvgrN3Bu+BfSfa1LLMvptIboSoi3aq0kUqe2c8WXrFDRPfQv4wAbK+8veFJlENWhLsG3jmBrZOIn1zPDTwjrYZUB+cVvwWpVs2zFFQlvnfXZwIDAQAB\n-----END PUBLIC KEY-----");
            privateKey = convertStringToPrivateKey("-----BEGIN PRIVATE KEY-----\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCuh7wn2Veetb06DwysZHSQgULLti/p/nq9m1ReEzrOmfbqgFEBKwJJZoetpnRPCsdA7d0Soag5ANIoxl0cr8wuwV6NNjDRq/bKHQggzWW0lHwb2Z0W3ODNPOwk0jAqFB1waafIc2LjzslgM1XPe2ex/ngWmY6fkNxHmvVcAJGxBEMZuRm902OK5hU+hfV7+/BxzE4glaIeLbO5s4OxZz5ijANqMyTuqmB5Q46j+V0Z2+Cs3cG74F9J9rUssy+m0huhKiLdqrSRSp7ZzxZesUNE99C/jABsr7y94UmUQ1aEuwbeOYGtk4ifXM8NPCOthlQH5xW/BalWzbMUVCW+d9dnAgMBAAECggEAEOGaJnSUUAqeIfaAsFALIksObevSWJy/vIVAtNTBVGh6BJaivy0szHK5XueByn9tZG9decbfIZxdt4nwSa0LX95eSeRa9nzeoxAJ0Dptwvi1xG/ZDPQSXmetI6ac+AT4D/54NyBKCWTf/4kXnLj//6xwaycxL2fwlpB7eQmpDekFqqtVW4D+WPCeiAg0uH6cCrDn0eYKuAmUa+YWYz3e74x3+L25Euqd/fBnpuVtTAmMCyz7qpprRepcu7LC1EFh41k6XGVYTwv5i83WAVcHJ+ddzFelqEHP/qGxy4fTa9x3tecWfKxY9RTBAR7+pgQqMtrGqDj0RdsbRNe34MToIQKBgQDgDtdO1dwJXNsdX9izqKtk8mYrnPMEzfJyRUfJ8gVekZVgkVIhz3T8g8EmJSaNXDcEDlWMHAIGRo4qxSrsF97nXqnitK2ZZY8GNbrH0IBTL6rXFmiXwJbWxPn/E0Uin/FStlZr/Wuhe+ezExJ9GLOLM0VX0Kc3fRLH4+L17gYpEQKBgQDHaVeifMU9lwuDvKSVmIqObwE7j43pmOmJ2HldNmLgcgrjagjhLDmYHSbAPVs5VB/e+QiZeQPKHjLDGjcwqFf1boQO/IlqTzg9lPW+QMWddVr14FOWjasfOFxZhJpAgaW88dw0G4vKKktOtKkIt1wqUaofDpJHaeOUztUR6OK49wKBgQCRH+vDq2+/PL7MEvXYwIprczpMS3d5CDBeZZNvMWza6S85AkeRkL80g96KZ4vGChG0ddhhTQ7eo7qX52e6zmdZs44UQnUjI431Nr4JiHpl5z0f3erXSC4rZCCNYBzqpXB445OslNOvIANekR7rmiFJK2dhzstQfJm6kVfDdW3WEQKBgQCCkRAHXUjMZfztGfRt2v5F+prFA964qB2p2yrEBJtDOIi2lLQRs6JWXigEUWhMpi9kEI036Au6KIG2S5D9dAx7sAwZv/K9v/ckI0ewdbquuauAOIyilEoKXB3jozZYrEr35yj2mV6zVXQPqazP/zcCoowQX7sZtVSFF9RdMK5aywKBgHXsJWjYGnUzXzQU3XrPrE4Jlk1ogAV764EolrIO0AnP2Bxm0OVtntXm45NPeCAVp0VEUUNnldLGeUnzSzcJu31vAoWszQqFiUtR1UqHnb3KUk0t5e4U0lQvNTzHWrtEu3huQvIsdmrDIRtXhpFCVQLFU+sjWMy+zRDWga4Lewev\n-----END PRIVATE KEY-----");

            HashMap<String, Object> body = new HashMap<>();
            body.put("grant_type", "client_credentials");

            // Step 1: Get the current date and time with time zone
            ZonedDateTime now = ZonedDateTime.now();

            // Step 2: Define the desired date-time format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

            // Step 3: Format the date-time to the desired format
            String currentTimestamp = now.format(formatter);

            String originalData = clientId + "|" + currentTimestamp;
            String encrypted = encryptByPrivateKey(originalData, "-----BEGIN PRIVATE KEY-----\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCuh7wn2Veetb06DwysZHSQgULLti/p/nq9m1ReEzrOmfbqgFEBKwJJZoetpnRPCsdA7d0Soag5ANIoxl0cr8wuwV6NNjDRq/bKHQggzWW0lHwb2Z0W3ODNPOwk0jAqFB1waafIc2LjzslgM1XPe2ex/ngWmY6fkNxHmvVcAJGxBEMZuRm902OK5hU+hfV7+/BxzE4glaIeLbO5s4OxZz5ijANqMyTuqmB5Q46j+V0Z2+Cs3cG74F9J9rUssy+m0huhKiLdqrSRSp7ZzxZesUNE99C/jABsr7y94UmUQ1aEuwbeOYGtk4ifXM8NPCOthlQH5xW/BalWzbMUVCW+d9dnAgMBAAECggEAEOGaJnSUUAqeIfaAsFALIksObevSWJy/vIVAtNTBVGh6BJaivy0szHK5XueByn9tZG9decbfIZxdt4nwSa0LX95eSeRa9nzeoxAJ0Dptwvi1xG/ZDPQSXmetI6ac+AT4D/54NyBKCWTf/4kXnLj//6xwaycxL2fwlpB7eQmpDekFqqtVW4D+WPCeiAg0uH6cCrDn0eYKuAmUa+YWYz3e74x3+L25Euqd/fBnpuVtTAmMCyz7qpprRepcu7LC1EFh41k6XGVYTwv5i83WAVcHJ+ddzFelqEHP/qGxy4fTa9x3tecWfKxY9RTBAR7+pgQqMtrGqDj0RdsbRNe34MToIQKBgQDgDtdO1dwJXNsdX9izqKtk8mYrnPMEzfJyRUfJ8gVekZVgkVIhz3T8g8EmJSaNXDcEDlWMHAIGRo4qxSrsF97nXqnitK2ZZY8GNbrH0IBTL6rXFmiXwJbWxPn/E0Uin/FStlZr/Wuhe+ezExJ9GLOLM0VX0Kc3fRLH4+L17gYpEQKBgQDHaVeifMU9lwuDvKSVmIqObwE7j43pmOmJ2HldNmLgcgrjagjhLDmYHSbAPVs5VB/e+QiZeQPKHjLDGjcwqFf1boQO/IlqTzg9lPW+QMWddVr14FOWjasfOFxZhJpAgaW88dw0G4vKKktOtKkIt1wqUaofDpJHaeOUztUR6OK49wKBgQCRH+vDq2+/PL7MEvXYwIprczpMS3d5CDBeZZNvMWza6S85AkeRkL80g96KZ4vGChG0ddhhTQ7eo7qX52e6zmdZs44UQnUjI431Nr4JiHpl5z0f3erXSC4rZCCNYBzqpXB445OslNOvIANekR7rmiFJK2dhzstQfJm6kVfDdW3WEQKBgQCCkRAHXUjMZfztGfRt2v5F+prFA964qB2p2yrEBJtDOIi2lLQRs6JWXigEUWhMpi9kEI036Au6KIG2S5D9dAx7sAwZv/K9v/ckI0ewdbquuauAOIyilEoKXB3jozZYrEr35yj2mV6zVXQPqazP/zcCoowQX7sZtVSFF9RdMK5aywKBgHXsJWjYGnUzXzQU3XrPrE4Jlk1ogAV764EolrIO0AnP2Bxm0OVtntXm45NPeCAVp0VEUUNnldLGeUnzSzcJu31vAoWszQqFiUtR1UqHnb3KUk0t5e4U0lQvNTzHWrtEu3huQvIsdmrDIRtXhpFCVQLFU+sjWMy+zRDWga4Lewev\n-----END PRIVATE KEY-----");

            log.info("originalData => {}", originalData);

            return new ResponseEntity<>(
                    snapService.reqB2B(body, currentTimestamp, encrypted),
                    HttpStatusCode.valueOf(200)
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Method to encrypt data using the public key
    public String encrypt(String data) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());

        byte[] digitalSignature = signature.sign();

        // Convert the signature to Hex format
        return bytesToHex(digitalSignature);
    }

    public static String encryptByPrivateKey(String data, String privateKeyPEM) throws Exception {
        String privateKeyPEMFormatted = privateKeyPEM
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", ""); // Remove header, footer, and whitespace

        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPEMFormatted);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        byte[] encryptedBytes = cipher.doFinal(data.getBytes());

        return bytesToHex(encryptedBytes);
    }

    // Utility method to convert byte array to Hexadecimal string
    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) hexString.append('0'); // Pad with leading zero if needed
            hexString.append(hex);
        }

        return hexString.toString();
    }

    // Method to decrypt data using the private key
    public String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

    public static PublicKey convertStringToPublicKey(String publicKeyString) throws Exception {
        // Remove the "BEGIN" and "END" markers
        String publicKeyPEM = publicKeyString
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s+", ""); // Removes any whitespace or newline characters

        // Decode the Base64 string into a byte array
        byte[] decoded = Base64.getDecoder().decode(publicKeyPEM);

        // Create a PublicKey object from the byte array
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA"); // or "EC" for elliptic curve keys, etc.
        return keyFactory.generatePublic(keySpec);
    }

    public static PrivateKey convertStringToPrivateKey(String privateKeyString) throws Exception {
        // Remove the "BEGIN" and "END" markers
        String privateKeyPEM = privateKeyString
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", ""); // Removes any whitespace or newline characters

        // Decode the Base64 string into a byte array
        byte[] decoded = Base64.getDecoder().decode(privateKeyPEM);

        // Create a PrivateKey object from the byte array
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA"); // or "EC" for elliptic curve keys, etc.
        return keyFactory.generatePrivate(keySpec);
    }


    // Convert PublicKey to String
    public String getPublicKeyAsString() {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    // Convert PrivateKey to String
    public String getPrivateKeyAsString() {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public void rsaKeyPairGenerator() throws NoSuchAlgorithmException {
        // Generate the key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Extract the public and private keys
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();

        log.info("PUBLIC KEY ==> {}", getPublicKeyAsString());
        log.info("PRIVATE KEY ==> {}", getPrivateKeyAsString());
    }
}
