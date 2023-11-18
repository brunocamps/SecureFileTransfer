# Secure File Transfer Project

## Overview
This Java-based project implements a secure file transfer system using encryption, decryption, and digital signatures. The primary components include AES for symmetric encryption of files, RSA for asymmetric encryption of AES keys and digital signature generation, and SHA-256 for hashing in digital signatures.

## Features
- **AES Encryption & Decryption:** Securely encrypts and decrypts files using AES (Advanced Encryption Standard).
- **RSA Key Encryption & Decryption:** Encrypts the AES key using RSA to ensure secure key exchange.
- **Digital Signature:** Ensures the integrity and authenticity of files through SHA-256 hashing and RSA-based signatures.

## How to Use

### Prerequisites
- Java Development Kit (JDK) 8 or higher.

### Setup
1. Clone or download the project to your local machine.
2. Compile the Java files in the `com.yourname.cryptotransfer` package.

### Running the Test Program
1. Execute the `TestCrypto` class.
2. The program will perform AES encryption and decryption of a sample message, RSA encryption and decryption of the AES key, and create and verify a digital signature.

### File Descriptions
- `AESEncryption.java`: Handles AES key generation, encryption, and decryption.
- `RSAEncryption.java`: Manages RSA key pair generation, and encrypts/decrypts data using RSA.
- `DigitalSignature.java`: Creates and verifies digital signatures using RSA and SHA-256.
- `TestCrypto.java`: Demonstrates and tests the functionality of the above components.

## Contributing
Feel free to fork this project and contribute by submitting a pull request.

## License
[MIT License](https://opensource.org/licenses/MIT) or specify another license you prefer.
