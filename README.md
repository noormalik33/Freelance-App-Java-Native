# Freelance Assist App 📱

![Language](https://img.shields.io/badge/Language-Java-orange.svg)
![Platform](https://img.shields.io/badge/Platform-Android-green.svg)
![IDE](https://img.shields.io/badge/IDE-Android%20Studio-blue.svg)

## 📌 Project Overview
**Freelance Assist** is a native Android application developed as part of the **Mobile Computing Lab 14**. The app serves as a profile management tool for freelancers, allowing users to input their experience level, availability, and project deadlines.

This project demonstrates proficiency in fundamental Android UI components, event handling, and the integration of external third-party libraries.

## ✨ Features
This application implements the following core requirements:

1.  **Activity Lifecycle Management**:
    * Implemented full logging (`onCreate`, `onStart`, `onResume`, etc.) to track the app's state changes in Logcat.
2.  **Gesture Handling**:
    * Custom **Back Press** implementation that triggers an confirmation dialog before exiting the app.
3.  **UI Controls**:
    * **Radio Group & Buttons**: For selecting freelancer experience level (Junior/Mid/Senior).
    * **CheckBox**: To toggle immediate availability status.
4.  **Pickers**:
    * **Date Picker**: Calendar interface to set project deadlines.
    * **Time Picker**: Clock interface to set specific deadline times.
5.  **Dialogs**:
    * **Standard AlertDialog**: Confirms profile details before saving.
    * **SweetAlert (Bonus)**: A custom, animated success dialog using an external library.

## 🏆 Bonus Implementation
For the bonus marks requirement, this project integrates the **SweetAlert2** library to replace standard Android dialogs with beautiful, animated alerts.

* **Library Used:** `cn.pedant.SweetAlert` (via `f0ris` port)
* **Implementation:** Triggered via the "Show Success" button to demonstrate a success state animation.


## 🛠️ Tech Stack
* **Language:** Java
* **Minimum SDK:** API 24 (Android 7.0)
* **Target SDK:** API 34 (Android 14)
* **Build System:** Gradle (Kotlin DSL)
* **Dependencies:**
    * `androidx.appcompat`
    * `com.google.android.material`
    * `com.github.f0ris.sweetalert:library:1.6.2`

## 🚀 How to Run
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/noormalik33/Freelance-App-Java-Native.git]
    ```
2.  **Open in Android Studio:**
    * Select **File > Open** and navigate to the cloned folder.
3.  **Sync Gradle:**
    * Ensure your `settings.gradle.kts` includes the `jitpack.io` repository.
    * Click "Sync Now" to download dependencies.
4.  **Build & Run:**
    * Connect a device or launch an emulator.
    * Click the green **Run** button (Shift+F10).

## Contributing 🤝
Contributions are welcome! Please fork the repository, make changes, and submit a pull request. Report bugs or suggest features via GitHub Issues. 🌟
Contact 📬
For questions, feedback, or collaboration, reach out to:

## License 📝
This project is licensed under the MIT License. See the LICENSE file for details.

## 👩‍💻 Author

**Noor Malik**  
IT Student  
📍 Islamabad, Pakistan  
📧 Email: noormalik56500@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/noormalik56500/)

Social 📱

📧 Email: mailto:coreittech1@gmail.com  
📹 YouTube: https://www.youtube.com/@CoreITTech1  
📸 Instagram: https://www.instagram.com/coreit.tech  
📘 Facebook: https://www.facebook.com/share/1AmgLDUnc9/

💡 If you like this project, don’t forget to star ⭐ it on GitHub!
Happy coding! 🚀 Let’s build amazing UIs together! 💪