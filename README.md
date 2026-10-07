# ChaCha20 Stream Cipher Implementation in Java

A pure, low-level implementation of the ChaCha20 stream cipher algorithm (RFC 7539) written in Java from scratch, without external cryptographic libraries.

## Architecture and Design

The project is structured into modular components based on Object-Oriented Programming (OOP) principles and low-level bit manipulation:

* **BitwiseUtils**: Handles low-level bitwise operations, byte manipulation, shift rotations, and endianness conversions (converting between UTF-8 byte arrays and 32-bit unsigned integer arrays).
* **ChaCha20Matrix**: Manages the 4x4 state matrix, constant setup, counter incrementation, quarter-round state transformations, and round iterations (20 rounds).
* **ChaCha20Engine**: Implements the main cipher stream loop, keystream block generation, XOR operations, and multi-block sequence handling for messages exceeding 64 bytes.
* **Main**: Provides an interactive command-line interface using `Scanner` to test real-time text encryption and decryption.

## Technical Specifications

* **Key Size**: 256 bits (32 bytes).
* **Nonce Size**: 96 bits (3 words).
* **Counter**: 32-bit integer for block sequence handling.
* **Block Size**: 64 bytes (512 bits) per keystream block.

## How to Run

1. Clone the repository:
```bash
git clone [https://github.com/Aymen-FR/ChaCha20-Java-From-Scratch.git](https://github.com/Aymen-FR/ChaCha20-Java-From-Scratch.git)
cd ChaCha20-Java-From-Scratch
Compile the Java files:
  javac Main.java
Execute the program:
  java Main
