# 🛡️ IronWallet – Web3 Wallet Android App

IronWallet is a modern Web3 wallet app built with Kotlin, Jetpack Compose, and Hilt. It allows users to securely generate, store, and interact with Ethereum-compatible wallets on Android.

## 🚀 Features

- 🔐 Generate and store Ethereum wallet keys (using [web3j](https://github.com/web3j/web3j))
- 📲 Modern UI with Jetpack Compose
- 💉 Dependency Injection via Hilt
- 🧠 Secure storage using AndroidX Security and Tink
- 👆 Biometric authentication support
- ⚡ Asynchronous operations with Kotlin Coroutines

## 🏗️ Built With

| Tech           | Usage                         |
|----------------|-------------------------------|
| Kotlin 2.0+    | Main language                 |
| Jetpack Compose| UI toolkit                    |
| Hilt           | Dependency Injection          |
| web3j          | Web3/Ethereum interaction     |
| Tink           | Encryption library            |
| AndroidX Security | Secure shared prefs + keys |
| Biometric API  | Fingerprint/face unlock       |

## 🔧 Project Setup

### Requirements

- Android Studio Hedgehog or later
- Kotlin 2.0.21+
- JDK 11
- Gradle 8+

### How to Run

1. Clone the repo:

   ```bash
   git clone https://github.com/yourusername/ironwallet.git
   cd ironwallet
