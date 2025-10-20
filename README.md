![JellyCast banner](images/jellycast_banner.png)

# JellyCast

<div align="center">

![GitHub](https://img.shields.io/github/license/Jordigb44/JellyCast?style=for-the-badge)
![Platform](https://img.shields.io/badge/platform-Android-green?style=for-the-badge)
![Kotlin](https://img.shields.io/badge/Kotlin-2.2.20-purple?style=for-the-badge&logo=kotlin)
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)

**A feature-rich Jellyfin client for Android with DLNA casting support**

[Features](#features) • [Screenshots](#screenshots) • [Technology](#technology-stack) • [Credits](#credits)

</div>

---

> [!NOTE]
> JellyCast is based on [Findroid 0.15.3](https://github.com/jarnedemeulemeester/findroid) with significant additional features and improvements.

## 🎯 What's New in JellyCast

JellyCast extends the original JellyCast with powerful new capabilities:

### 🎭 **DLNA Casting**
Stream your media to any DLNA-enabled device on your network:
- 📡 Automatic device discovery
- 🎮 Full playback control (play, pause, stop, seek, volume)
- 📺 Support for smart TVs, speakers, and media renderers
- 🎬 Works with both movies and TV series

### 📥 **Enhanced Downloads**
Beautiful download management with real-time feedback:
- ⭕ Circular progress indicators with percentage display
- 🌫️ Elegant blur effects on downloading items
- 📊 Live progress updates
- 📺 Automatic series grouping in Downloads section

### 🎨 **UI Improvements**
- ✨ Refined status bar handling
- 🎯 Better visual hierarchy
- 🔄 Improved state synchronization
- ⚙️ Settings toggles for DLNA and Chromecast

## 🔧 Development & Quality

### Code Quality
- ✅ **Ktlint Integration**: Automated code formatting and style checking
- 🎯 **Zero Violations**: All 289+ style violations resolved
- 📏 **Consistent Formatting**: 140-character line limit, proper indentation
- 🔧 **Compose Support**: Custom ktlint rules for Jetpack Compose functions

### Build System
- 🚀 **Java 21**: Modern JVM with enhanced performance
- 📦 **Gradle 9.x**: Latest build tool with improved caching
- 🔄 **Toolchains**: Consistent Java version across all modules
- 🏗️ **Multi-Module**: Organized architecture with clear separation

### Development Setup
- 💻 **IDE Ready**: Configured for Android Studio/VS Code
- 🔍 **Linting**: Integrated code quality checks
- 🧪 **Testing**: Unit test support with proper tooling
- 📱 **Device Testing**: Support for phones and Android TV

## Screenshots

### Main Interface
| Home | Library | Movie Details |
|------|---------|---------------|
| ![Home](images/jellycast_home.png) | ![Library](images/jellycast_library.png) | ![Movie](images/jellycast_movie.png) |

### New Features
| DLNA Casting | Downloads Progress | Settings |
|--------------|-------------------|----------|
| ![DLNA](images/jellycast_dlna.png) | ![Downloads](images/jellycast_downloads.png) | ![Settings](images/jellycast_settings.png) |

## ✨ Features

### 🆕 JellyCast Exclusive Features

#### DLNA Casting
- 🔍 **Device Discovery**: Automatic detection of DLNA devices on your network
- 🎮 **Full Control**: Play, pause, stop, seek, and volume control
- 📱 **Mini Player**: Persistent playback controls
- 🎬 **Universal Support**: Works with movies and TV series

#### Download Experience
- ⭕ **Visual Progress**: Circular indicators with real-time percentage
- 🌫️ **Blur Effects**: Beautiful visual feedback during downloads (Android 12+)
- 📺 **Smart Grouping**: Episodes automatically organized by series
- 🗑️ **Instant Updates**: Download list refreshes immediately after deletions

#### Settings & Control
- ⚙️ **DLNA Toggle**: Enable/disable DLNA functionality
- 📡 **Chromecast Toggle**: Control Chromecast availability
- 🎯 **User-Friendly**: Easy access to all casting options

### 🎥 Core Features (from JellyCast)

#### Media Support
- 🎬 **Content Types**: Movies, TV series, seasons, episodes
- 📥 **Offline Playback**: Download and watch without internet
- 🎯 **Direct Play**: No transcoding required for compatible formats

#### ExoPlayer Integration
- 🎞️ **Video Codecs**: H.263, H.264, H.265, VP8, VP9, AV1
  - Support depends on device capabilities
- 🔊 **Audio Codecs**: Vorbis, Opus, FLAC, ALAC, PCM, MP3, AAC, AC-3, E-AC-3, DTS, DTS-HD, TrueHD
  - Enhanced by ExoPlayer FFmpeg extension
- 📝 **Subtitles**: SRT, VTT, SSA/ASS, PGSSUB
  - SSA/ASS with [limited styling](https://github.com/google/ExoPlayer/issues/8435)

#### MPV Alternative
- 📦 **Containers**: MKV, MOV, MP4, AVI
- 🎞️ **Video**: H.264, H.265, H.266, VP8, VP9, AV1
- 🔊 **Audio**: Opus, FLAC, MP3, AAC, AC-3, E-AC-3, TrueHD, DTS, DTS-HD
- 📝 **Subtitles**: SRT, VTT, SSA/ASS, DVDSUB
- 💻 **Software Decoding**: Optional fallback for hardware issues

#### Advanced Features
- 📺 **Picture-in-Picture**: Watch while using other apps
- 📑 **Media Chapters**: Timeline markers and gesture navigation
- 🎯 **Trickplay**: Thumbnail previews (Jellyfin 10.9+)
- ⏭️ **Media Segments**: Auto-skip intros/credits (Jellyfin 10.10+)

## � Quick Start

### Prerequisites

- **Java 21** (Eclipse Temurin recommended)
- **Android Studio** (latest stable) or VS Code with Android extensions
- **Git** for version control

### Build Instructions

```bash
# Clone the repository
git clone https://github.com/Jordigb44/findroid.git
cd findroid

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Run tests
./gradlew test

# Check code quality
./gradlew ktlintCheck

# Auto-format code
./gradlew ktlintFormat
```

### Development Setup

1. Open project in Android Studio
2. Ensure JDK 21 is configured as project SDK
3. Sync project with Gradle files
4. Run on device or emulator

## �🛠️ Technology Stack

### Core Technologies

- **Java**: 21 (Eclipse Temurin)
- **Kotlin**: 2.2.20
- **Android Gradle Plugin**: 8.13.0
- **Gradle**: 9.x (wrapper)
- **Ktlint**: 12.3.0 (code quality)

### DLNA Implementation

- **Server**: Jetty 9.4.54.v20240208
- **UPnP Stack**: jUPnP 3.0.2
- **Discovery**: AndroidUpnpServiceConfiguration

### UI Framework

- **Compose**: Jetpack Compose 1.9.3 with Material 3
- **Design**: Material Design 3 components
- **Effects**: RenderEffect API for blur (Android 12+)

### Architecture

- **Pattern**: MVVM (Model-View-ViewModel)
- **Async**: Kotlin Coroutines & Flow
- **DI**: Hilt 2.57.2 for dependency injection
- **Persistence**: Room 2.8.2 database for downloads

### Media & Playback

- **ExoPlayer**: Media3 1.8.0
- **FFmpeg**: Custom extension for enhanced codec support
- **MPV**: Alternative player with software decoding

## 🚀 Planned Features
- 🔗 **Syncplay**: WebSocket-based synchronized playback
- 📡 **Enhanced Chromecast**: Improved casting experience

## 🙏 Credits

This project is based on [**Findroid**](https://github.com/jarnedemeulemeester/findroid) version **0.15.3** by [Jarne De Meulemeester](https://github.com/jarnedemeulemeester).

Special thanks to:

- The original Findroid project and all its contributors
- The Jellyfin community
- All open-source libraries used in this project

## 📄 License
This project is licensed under [GPLv3](LICENSE).

The logo is a combination of the Jellyfin logo and the Android robot.

The Android robot is reproduced or modified from work created and shared by Google and used according to terms described in the Creative Commons 3.0 Attribution License.

Android is a trademark of Google LLC.

Google Play and the Google Play logo are trademarks of Google LLC.
