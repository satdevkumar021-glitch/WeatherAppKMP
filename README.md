# Weather App - Kotlin Multiplatform

A cross-platform weather application built with **Kotlin Multiplatform** and **Compose Multiplatform**. This project targets Android, iOS, Web (Wasm & JS), and Desktop (JVM).

## 🚀 Features (Planned)
- **Real-time Weather:** Get current weather conditions based on your location.
- **Detailed Forecasts:** View hourly and daily forecasts.
- **Location Search:** Search for weather in cities around the world.
- **Multi-platform UI:** A consistent and beautiful UI across all platforms using Compose Multiplatform.
- **Dark Mode Support:** Automatic switching based on system settings.

## 🛠️ Tech Stack
- **UI:** [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/)
- **Shared Logic:** Kotlin Multiplatform (KMP)
- **Dependency Injection:** (Planned: Koin)
- **Networking:** (Planned: Ktor)
- **Serialization:** (Planned: Kotlinx Serialization)
- **Local Database:** (Planned: SQLDelight or Room)
- **Images:** (Planned: Coil3)

## 📂 Project Structure
* [/androidApp](./androidApp) - Android specific application code.
* [/iosApp](./iosApp) - iOS specific application code (SwiftUI entry point).
* [/desktopApp](./desktopApp) - Desktop (JVM) specific application code.
* [/webApp](./webApp) - Web (Wasm/JS) specific application code.
* [/shared](./shared) - Shared Kotlin code (UI & Logic) used across all platforms.
  - `commonMain`: Shared UI and business logic.
  - `androidMain`, `iosMain`, `jvmMain`, `jsMain`, `wasmJsMain`: Platform-specific implementations.

## 💻 Getting Started

### Prerequisites
- Android Studio (latest stable version)
- Xcode (for iOS development)
- JDK 17 or higher

### Running the apps
Use the run configurations in your IDE or the following Gradle tasks:

- **Android:** `./gradlew :androidApp:assembleDebug`
- **Desktop:**
  - Standard: `./gradlew :desktopApp:run`
  - Hot Reload: `./gradlew :desktopApp:hotRun --auto`
- **Web:**
  - Wasm: `./gradlew :webApp:wasmJsBrowserDevelopmentRun`
  - JS: `./gradlew :webApp:jsBrowserDevelopmentRun`
- **iOS:** Open `/iosApp` in Xcode and run.

### Running Tests
- **Android:** `./gradlew :shared:testAndroidHostTest`
- **Desktop:** `./gradlew :shared:jvmTest`
- **Web:** `./gradlew :shared:wasmJsTest` / `./gradlew :shared:jsTest`
- **iOS:** `./gradlew :shared:iosSimulatorArm64Test`

---
Feedback and contributions are welcome!
