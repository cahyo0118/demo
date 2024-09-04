package com.example.demo.keypairvalidator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;

@RestController
@RequestMapping(path = "/api/key-pair")
@Slf4j
public class KeyPairController {

    PrivateKey privateKey;
    PublicKey publicKey;

    @PostMapping("/validate")
    private ResponseEntity<?> validate() {

        try {

//            publicKey = convertStringToPublicKey("-----BEGIN PUBLIC KEY-----\n" +
//                    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtMTJ1VGAyt1ixRDnnsEL\n" +
//                    "CXyN1WZd2RlavEulSLJTDjVAeJFC+iZqZsqtXP9qQhd9HP82B5w6ks3B0UuVJEMI\n" +
//                    "beZE61iunpi0rHITFt0Fv9x7nBRZRZ7hsHhLFR9EH4O+ZJY5qcDKvf/cUBrOW2Hl\n" +
//                    "GsohUN6HH9v25v0EmslWAneTqe6k23m4l+lKnTv3vaGKJ/gwUpqMVZZ4ZAaim3+y\n" +
//                    "+GmZrHBlTrbnSRTFSfrwK7LUwgCcae2SYXD91hhSHT774/xTkxGVN6jvYB30TBke\n" +
//                    "xtGgeA89eBM/eS9QdbXdbbg/K9jaApfwrGSZ5l0+HXleWMRdxAGvnVKhniuc1Pdu\n" +
//                    "BQIDAQAB\n" +
//                    "-----END PUBLIC KEY-----\n");
//            privateKey = convertStringToPrivateKey("-----BEGIN RSA PRIVATE KEY-----\n" +
//                    "MIIEpAIBAAKCAQEAtMTJ1VGAyt1ixRDnnsELCXyN1WZd2RlavEulSLJTDjVAeJFC\n" +
//                    "+iZqZsqtXP9qQhd9HP82B5w6ks3B0UuVJEMIbeZE61iunpi0rHITFt0Fv9x7nBRZ\n" +
//                    "RZ7hsHhLFR9EH4O+ZJY5qcDKvf/cUBrOW2HlGsohUN6HH9v25v0EmslWAneTqe6k\n" +
//                    "23m4l+lKnTv3vaGKJ/gwUpqMVZZ4ZAaim3+y+GmZrHBlTrbnSRTFSfrwK7LUwgCc\n" +
//                    "ae2SYXD91hhSHT774/xTkxGVN6jvYB30TBkextGgeA89eBM/eS9QdbXdbbg/K9ja\n" +
//                    "ApfwrGSZ5l0+HXleWMRdxAGvnVKhniuc1PduBQIDAQABAoIBAQCv6VEAZfAPeqFD\n" +
//                    "ZNABjZpQAQWFRbjOK/5Afty5gc+RZAD5U2L6S6f/n/xVI7kj1/fI4BKUFVRqyBB0\n" +
//                    "vDjGsPTi/dLTs9k6PSCVL+2jsjKGIumnWaYGOjcmo+ltBKAmiu4ctJQovZSOkQ60\n" +
//                    "ZWGrS/jHuSvyppqYRlZfMpnoh0VL36t684Q863r9kGGisjW79VZ0J6Oz0Sle+4rJ\n" +
//                    "G3C2asgWx90NEE9FGnb8ElQ2LSAKJ5x1KPJ6BkPGFHNbBrSUFcv82Dm95O+gLbbR\n" +
//                    "DQthppAvIg8CEZ09fZ4vAN8FziAp+y4Y3Bpc4gJeshdF1k4bfWF5F82x4ZVU79u/\n" +
//                    "MW1x56ABAoGBAPTwjK1eezA/lyy7cP1lRQ3xvNAwxZ01E4rYbu5nEU+xHNx4O5W0\n" +
//                    "Tfe61f4Lj8Llmt2ONI1nZWUHXvPJNeKA/rR6CMN3c3gX5RT+lthF21AxCXUQfK2Q\n" +
//                    "WkHrBVm5SGYVcxqIVPq6PHmW5dUwCqL0LX1zXzUhsfJ83AAlxyBBhjtBAoGBALzu\n" +
//                    "b7bP6NtqYvJjtEXRDzaN15pWinHS6H4ISsmVjqJ4LM3RgN4pFAvaP/9XluOUKQXb\n" +
//                    "yZZiQYnqF/lrD9gwcLRDqBKGG44CvwITq/0jMvIUGmJ+LVi9Wtqx4G8x5/ut9vL6\n" +
//                    "DJgFcxpXLeKsYKfOb7pmQc7PFDzX/zvvSLDXb5XFAoGAJqf8G7RojrHKgwXGDEe6\n" +
//                    "QTwgh17bITdqMSR9RWTAx6n1GxpilPrSv0EeWqyqcKDZ8xNpWdOyneIu6xybQ3cG\n" +
//                    "O6dy0J5+e7qRreGMHu/Pb/V9P5ttgdrhU7vqqUFjmrDR7KMNflB8ENhux1mApD0T\n" +
//                    "HNRjdzgtJE7uTZuotH+C1sECgYEAiahVP2c3a/+U/rVE2YXcxswMpsidcRfSDFpw\n" +
//                    "W3acCab0RjZ65eQaVhR8gsjICSOfzEP7GpaW2Cz3sOSgE84foEiXgn+yPgOkNpgs\n" +
//                    "vXFTIm0hWFhFJB47v5LRS1OaipeTkjA80ttNpYiVx03/0uSoJbFyC4R4Y2ih8IKF\n" +
//                    "fUxLYl0CgYBSVUEjDDIow2Qjfe/jAsTS42vk4S/o3+vLW64js9gPbHXJvzRSy3Sd\n" +
//                    "R7nKR70lRGcWHAQoWEJKVda0EZ/lK1NVmlH3qXgB7Ozk1gbSs0j0AtEA9DpXll5k\n" +
//                    "RU2w2LDXjwFpDZ0MAzYHG3xv3IFNyjq5vNuyZ8O9RgucOjo3gFe20g==\n" +
//                    "-----END RSA PRIVATE KEY-----\n");

//            publicKey = convertStringToPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApY+mwpD3CTXjxJ1kL9614L4GzsLPaP7l9Rcf2BWZT8vAjqUnDe8bdkJPlXE5rqRmWdC4pdyUB0+B02InP8yTKxpqmC324TP1Ni5/MLD5zR9BC1HeAtIgGLfB/+TLoWF0iOqDqYKpz3jtzpnjUZoIm1L1U1foK8OYmBsoTPX5EIdOC1Smo9qYWQfNd8Dhcf7i/Aa0EWdxJdMWEL6nHJSybsjyvucSR+SnxP6TuanV7mhjZU099Y0fmyueUN5gDnsqyP5gNYXoT1suBsiav+eWX+mRqo1MXHdXyhW+w9p+vNGBzEYJX/Sn4grJOpQoRyFW1a4TsdJ3scoFszYtPHEvIQIDAQAB");
//            privateKey = convertStringToPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQClj6bCkPcJNePEnWQv3rXgvgbOws9o/uX1Fx/YFZlPy8COpScN7xt2Qk+VcTmupGZZ0Lil3JQHT4HTYic/zJMrGmqYLfbhM/U2Ln8wsPnNH0ELUd4C0iAYt8H/5MuhYXSI6oOpgqnPeO3OmeNRmgibUvVTV+grw5iYGyhM9fkQh04LVKaj2phZB813wOFx/uL8BrQRZ3El0xYQvqcclLJuyPK+5xJH5KfE/pO5qdXuaGNlTT31jR+bK55Q3mAOeyrI/mA1hehPWy4GyJq/55Zf6ZGqjUxcd1fKFb7D2n680YHMRglf9KfiCsk6lChHIVbVrhOx0nexygWzNi08cS8hAgMBAAECggEALhiT/qIsFeVqOEj2JxnkG+HstU6qPvqRfi7lD93bpMr/Hvg+qnODeua1j89JlyVw1dr2Pj/u+yYY6IjwkqPb6eld+mb50PQNdvt1MFJmCsWD76nonXJxu1AWdK/4PkOLFb/tzplxvDFYTOit0P+JG+36Hi1gmCbKardM/jiSExaWOsq2qcbQ8jUV2JB+4xaUmVSZo7GOcgiAMTsLc0ZsofbyvThnmy/vHfryteyn6+4Vb0KLEYlDgIC52oh1nw8zXs6mbRpdkzgsaOtgfoZwJuHYGEA7yg0CjokCJxM0CYqq4OtIt5X8SE99RYJ/q+Hx3oADccYs+9YFoUeD61kmDQKBgQDax0LZ9n/va8FOM1eVLvo3LUJ3bEM+G2fks1YYGe58UtZW3dHp6dYlVCE0L0+YBdrDaVbJfxngCIFy3cKOY1TFeg6aQ6+w+sXKNr49KANRHI/1Yly6wb9Vx5lX2M75naL90FrEs1gF7VYMXimePu+7toBcO+eJ7R09AJ73eGbPMwKBgQDBuo0ZprmzcuTSU/co8NqO75CxMyIe++YTakxkNxurWZYH8pqN9lPXDiMFX5If0gysPcpXR6DfVRlkaBdJBqd6HUHUZhNneN4uYuDcJIMpVuhSKWdpCl622+V1+IldaEQ93pEMX/jEfiwYI2VKHxFMjJkPBeG+IyMIp6GlNKRYWwKBgDtjJ7R/A098kqalrTqj2+wqbwZ37vDnA5bDT7WPJHu/CMvfvuGeRjEv2yuNRC/iNvYgnBxqUh3McUc7B1sbf6Fzdo9NnF2QVSyFG7MCL5RPCozzvHQ9r7CbU/bStaxwrBP2AQ2wGU7SlC8bSHTaZL0x1zoyULHSGcO7bWuD1XSdAoGAbt2UnCZmxYQt4RP+MObNHNmKY24Qy8x6WYgOmZdT9VZ6Xqf+vNlIF51We1+7Hwy1BekCn7o1HTn1IxnSoY72TxLpNmUIG8H23HLnnfQjP4glwcdCD8HIfDsRcNa/vb3Kt+Fj/sH5enF+SH4RHD71Rmp7uTYzfv1asjxEbGfY2VsCgYEAg5QqWySja48Ubtw4CBjEfwxIj05sRr3Kkz3dXwC7iL5IoNAiqFAMMUxCHVH8j5s2GCwsfjisvsQCIQyvOTc+dx8aKtmrXkKrve4TlU1jFK9yMDCCFmig/t1FKwlRW7jMHUW8/HwtpltWQ45Ay1+u1w1eVtX7LguNrRmYKi6jK9U=");

            publicKey = convertStringToPublicKey("-----BEGIN PUBLIC KEY-----\n" +
                    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk7rqGaWeTCUPhGUtvStZ\n" +
                    "yFc5kMaJQdo6DZQxoSONoFmLTCBvuNCKvVrarff2/44CwMhG2w3R2EULhNK5ZFP4\n" +
                    "F7Y08u3Ax2K7XAwHvWjbEHengDBeNBlCP5nsf5TRNnUzFLaM9a1veYrmbMCRFjql\n" +
                    "s0PlKibCjzmPgjaZdRLsnfjBLxfq1rIWIphCTaltjqrv0xsFrbu9sPkZYRf5XWLq\n" +
                    "Pj/Hxm3k0MJNIXRmqoX46zLXcC8e6PVSIAnNwdp9KZvGMjqi6F/mQ5tEaHc4UFrc\n" +
                    "k4Tk1Hv7CS4y92NgHDqNwQuB29/njlLNiWYKjmoBCYSUVf2LMrcxzpmqRtfKR65g\n" +
                    "oQIDAQAB\n" +
                    "-----END PUBLIC KEY-----\n");

            privateKey = convertStringToPrivateKey("-----BEGIN PRIVATE KEY-----\n" +
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCTuuoZpZ5MJQ+E\n" +
                    "ZS29K1nIVzmQxolB2joNlDGhI42gWYtMIG+40Iq9Wtqt9/b/jgLAyEbbDdHYRQuE\n" +
                    "0rlkU/gXtjTy7cDHYrtcDAe9aNsQd6eAMF40GUI/mex/lNE2dTMUtoz1rW95iuZs\n" +
                    "wJEWOqWzQ+UqJsKPOY+CNpl1Euyd+MEvF+rWshYimEJNqW2Oqu/TGwWtu72w+Rlh\n" +
                    "F/ldYuo+P8fGbeTQwk0hdGaqhfjrMtdwLx7o9VIgCc3B2n0pm8YyOqLoX+ZDm0Ro\n" +
                    "dzhQWtyThOTUe/sJLjL3Y2AcOo3BC4Hb3+eOUs2JZgqOagEJhJRV/YsytzHOmapG\n" +
                    "18pHrmChAgMBAAECggEAC2MgAmQVb0citWYwgAwPD/XxQQCcueUUDnyQKsdDy8q7\n" +
                    "MF4GXpeXP4CjqenwMcNaNk6kb47W0GCEwnM/yRpT3aK03XjddZZdsiWslGQNvBeN\n" +
                    "DhYsXMBfA+oIec5t0KXODy2scI+IL9/jYm9MKmDQ6aA1J5T0mvepNon2NY5aNima\n" +
                    "1O/S2qTSnu90YZHmOtmCzRzV6SQeqvUar2eYPRm9YT8iV+vG6sWS0+F51uJZ5a2o\n" +
                    "gZQ3F1KcN3UalNzsCYvZdzs2eEZxWaXEu9pRynkxUCA1hDBB4B2uFuJ4BI02Undi\n" +
                    "bO6biQpi6uvyY8WtonTxGmoovFug7GW7G/8vn9EwhQKBgQDOOe7hZ/pKdtZcfYBm\n" +
                    "zcEApUjbefkXLurCyl3WT4JFe7H6gyw6Wi4NeUwB1t3+K4iltVnb6NJPcHLsiiuH\n" +
                    "c+pJePIK/R3DK3ZK8AFzLcPpWL7xDnNIk/l0gTV6kKCsAhMssaUCKVQ5GQY8SQYD\n" +
                    "+ene9rzYeXxtGkXNeL8XfuCq7wKBgQC3YrB4tgCNrBdoDNKQ16np+nhuyQ0jL1Am\n" +
                    "sNP//BdZhe+TxqvKU+RAzKVxhz5UlFeZb3UpjPbts9R3aDBgFuVyXWPODOUdQw+w\n" +
                    "IJWlilvWqm/9UHnwR+yFEUEf9QwC55OgmyKh2Aih/Nseiiv8yKl6Q/EYSVn81ejk\n" +
                    "koUY7kvtbwKBgCBENDoUWLb57QQ/pq1vF/mP4txkMzMLZjPgEdqMSiew+OHnUC45\n" +
                    "GeeFyPyor8cq7JBw1YRw4ycGwxR7ceAZpNimEcjiXZvB2xpSfweUa4jBF+8Dgcoj\n" +
                    "TO6LoOBybJE9Kd7eVKEH8mOUpMMd8dEBczQtitKb/3namH1TnSKB+YkFAoGBAK3y\n" +
                    "epnFaXj4h6s2nnStXIqH/rx3EHMTad+JU044/Jz6Imn1xPXB5XxhoXyyYDkyDHWJ\n" +
                    "94RWJdMLBLnOpjQ/A50bYJQOPzUmazcRcWD4gGx6doe9UizMzFjcKP37Hk2TA8EP\n" +
                    "5iXGGUot4lpxjY/Vdox27bWvvh/Jd4N4R6+COZsZAoGACJ9Np4DMyOwKgzQKzVmd\n" +
                    "VqTnGeMig+q+rltKN98xC8EOqXTQJuOBvJlFf/mIN2XqdX61uSDlFTz1jOzoOUGJ\n" +
                    "bBKtjHp3caH2f0ELUOVeohlCA3LaN4tr6th/+MbDC11NudgKtKd696ETPZwEhqkF\n" +
                    "ls3UNxVPfCKJchy8ScNAFH4=\n" +
                    "-----END PRIVATE KEY-----\n");

//            rsaKeyPairGenerator();

            String originalData = "TEST MY PATIENCE";
            String encrypted = encrypt(originalData);
            log.info("ENCRYPTED ====> {}", encrypted);

            String decrypted = decrypt(encrypted);
            log.info("DECRYPTED ====> {}", decrypted);

            // Validate the decrypted data
            if (originalData.equals(decrypted)) {
                System.out.println("Validation Successful: The original and decrypted data match.");
            } else {
                System.out.println("Validation Failed: The original and decrypted data do not match.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(new HashMap<>(), HttpStatusCode.valueOf(200));
    }

    // Method to encrypt data using the public key
    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
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
