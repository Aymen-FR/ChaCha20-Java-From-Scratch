# ChaCha20 Stream Cipher Implementation in Java

A pure, low-level implementation of the ChaCha20 stream cipher algorithm (RFC 8439, formerly RFC 7539) written in Java from scratch, without external cryptographic libraries.

## Architecture and Design

The project is structured into modular components based on Object-Oriented Programming (OOP) principles and low-level bit manipulation:

- **BitwiseUtils**: Handles low-level bitwise operations, byte manipulation, shift rotations, and endianness conversions (converting between UTF-8 byte arrays and 32-bit unsigned integer arrays).
- **ChaCha20Matrix**: Manages the 4x4 state matrix, constant setup, counter incrementation, quarter-round state transformations, and round iterations (20 rounds).
- **ChaCha20Engine**: Implements the main cipher stream loop, keystream block generation, XOR operations, and multi-block sequence handling for messages exceeding 64 bytes.
- **Main**: Provides an interactive command-line interface using `Scanner` to test real-time text encryption and decryption.

## Technical Specifications

- **Key Size**: 256 bits (32 bytes).
- **Nonce Size**: 96 bits (3 words).
- **Counter**: 32-bit integer for block sequence handling.
- **Block Size**: 64 bytes (512 bits) per keystream block.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/Aymen-FR/ChaCha20-Java-From-Scratch.git
cd ChaCha20-Java-From-Scratch
```

2. Compile the Java files:

```bash
javac Main.java
```

3. Execute the program:

```bash
java Main
```

## Note

This project came after self-studying Object-Oriented Programming concepts independently, as a way to consolidate my understanding through a real implementation. I chose ChaCha20 specifically because it is still actively used as of the date this repository was published.

I relied on AI and YouTube to understand how the algorithm works internally. AI assistance was used specifically to explain the bitwise operations and to write the hex-conversion helper function. Everything else in this project was written by me.
