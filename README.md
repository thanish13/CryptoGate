# CryptoGate
 CryptoGate is a robust and scalable Spring Boot-based cryptography-as-a-service platform designed to provide secure encryption, decryption, and key management APIs for enterprise applications and developers, emphasizing high security standards, and seamless integration to facilitate secure data handling in modern digital environments.

# 🔐 CryptoGate

**Modular Cryptography-as-a-Service Gateway built with Spring Boot**

CryptoGate is a secure, scalable gateway for cryptographic operations, designed for financial microservices and developer platforms. It offers plug-and-play modules for encryption, decryption, key management, and digital signatures—exposed via clean, RESTful APIs.

---

## 🚀 Features

- 🔒 AES/RSA encryption & decryption endpoints
- 🔑 Key generation, rotation, and storage (pluggable backend)
- 🧾 Digital signature creation & verification
- 🧩 Modular architecture for easy extension (e.g., HMAC, JWT, ECC)
- 📊 Audit logging and request tracing
- 🛡️ OAuth2/JWT-based authentication
- 🧵 Asynchronous processing for heavy crypto workloads

---

## 🧰 Tech Stack

| Layer           | Technology            |
|----------------|------------------------|
| Framework       | Spring Boot 3.x        |
| Security        | Spring Security, JWT   |
| Messaging       | Kafka (optional)       |
| Persistence     | PostgreSQL / MongoDB   |
| Containerization| Docker, Docker Compose |
| Build Tool      | Maven                  |

---

## 📦 Modules

- `cryptogate-core`: Core crypto logic (AES, RSA, etc.)
- `cryptogate-api`: REST controllers and DTOs
- `cryptogate-auth`: OAuth2/JWT integration
- `cryptogate-storage`: Key storage abstraction
- `cryptogate-gateway`: Spring Cloud Gateway (optional)

---

## 📄 API Overview

| Endpoint            | Method | Description                        |
|---------------------|--------|------------------------------------|
| `/encrypt/aes`      | POST   | Encrypt data using AES             |
| `/decrypt/aes`      | POST   | Decrypt AES-encrypted data         |
| `/key/generate/rsa` | GET    | Generate RSA key pair              |
| `/sign/rsa`         | POST   | Sign payload with RSA private key  |
| `/verify/rsa`       | POST   | Verify RSA signature               |

---

## 🧪 Running Locally

```bash
git clone https://github.com/your-org/cryptogate.git
cd cryptogate
./mvnw clean install
docker-compose up