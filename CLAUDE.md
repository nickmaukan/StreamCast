# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

StreamCast is an Android browser app with Chromecast support that detects and casts video content (MP4, HLS, DASH, WebM) from web pages to Cast-enabled devices.

## Build Commands

```bash
# Debug APK
./gradlew assembleDebug

# Release APK (requires signing config)
./gradlew assembleRelease

# Clean build
./gradlew clean

# Single test class
./gradlew test --tests "com.streamcast.app.detection.VideoDetectorTest"
```

**SDK Setup**: Ensure `local.properties` contains `sdk.dir=/path/to/android/sdk`

## Architecture

### Layers
- **UI Layer**: Activities, Fragments, ViewModels (`ui/` package)
- **Business Logic**: ViewModels + LiveData for state management
- **Data Layer**: Room database for history (`data/` package)
- **Cast Layer**: Chromecast integration (`cast/` package)
- **Detection**: Video URL detection from WebView (`detection/` package)

### Key Components

| Component | Responsibility |
|-----------|----------------|
| `MainActivity` | Single-activity container, bottom nav, FABs |
| `BrowserFragment` | WebView with JS injection for video detection |
| `VideoDetector` | Analyzes URLs and page JS for video content |
| `CastManager` | Singleton managing Cast state and device discovery |
| `CastControlSheet` | Bottom sheet for playback controls |
| `HistoryFragment` | Browsing history from Room DB |

### State Flow
1. `BrowserFragment` loads URLs in WebView
2. `VideoDetector` analyzes page JS and network requests for videos
3. Detected videos expose via `MainViewModel.detectedVideos`
4. FAB toggles `DetectedVideosSheet` or initiates Cast via `MainActivity.onVideoSelected()`
5. `CastManager` handles device discovery (MediaRouter) and playback state

### Data Model
- `DetectedVideo`: URL, title, format (HLS/DASH/MP4/WebM), resolution, contentType
- `HistoryEntry`: Room entity storing visited URLs and timestamps

### Dependencies
- AndroidX + Material 3 for UI
- Google Cast SDK (`play-services-cast-framework`)
- Room for persistence
- Glide for thumbnails
- Gson for JSON parsing from JS results
