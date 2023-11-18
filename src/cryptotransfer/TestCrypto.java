package cryptotransfer;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class TestCrypto {

    public static void main(String[] args) {
        try {
            // Sample data to encrypt and sign
            String originalData = "Hello, this is a test!";
            byte[] originalDataBytes = originalData.getBytes();

            // AES Encryption Test
            SecretKey aesKey = AESEncryption.generateAESKey();
            byte[] encryptedData = AESEncryption.encryptAES(originalDataBytes, aesKey);
            byte[] decryptedData = AESEncryption.decryptAES(encryptedData, aesKey);

            // Check if AES encryption and decryption work
            System.out.println("Original Data: " + originalData);
            System.out.println("Decrypted Data: " + new String(decryptedData));

            // RSA Key Generation
            KeyPair keyPair = RSAEncryption.generateRSAKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // RSA Encryption Test
            byte[] encryptedAESKey = RSAEncryption.encryptRSA(aesKey.getEncoded(), publicKey);
            byte[] decryptedAESKey = RSAEncryption.decryptRSA(encryptedAESKey, privateKey);

            // Check if RSA encryption and decryption work
            SecretKey originalAESKey = new SecretKeySpec(decryptedAESKey, 0, decryptedAESKey.length, "AES");
            System.out.println("AES Key Encryption and Decryption successful: " +
                    Arrays.equals(aesKey.getEncoded(), originalAESKey.getEncoded()));

            // Digital Signature Test
            byte[] signature = DigitalSignature.createSignature(originalDataBytes, privateKey);
            boolean isSignatureVerified = DigitalSignature.verifySignature(originalDataBytes, signature, publicKey);

            // Check if digital signature works
            System.out.println("Digital Signature Verification: " + isSignatureVerified);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}