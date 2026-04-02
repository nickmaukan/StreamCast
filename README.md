# 📺 StreamCast - Android Kotlin

Navegador Android con detección de videos y Chromecast integrado.

## Características

- 🌐 **WebView** - Navegador con JavaScript habilitado
- 🎬 **Detección automática** - Detecta videos MP4, HLS, DASH, WebM
- 📺 **Chromecast** - Envía videos a tu TV
- 🎮 **Controles** - Play, pause, seek, volume
- 🌙 **Tema oscuro** - Interfaz moderna y elegante

## Requisitos

- Android 6.0+ (API 23)
- Google Cast SDK

## Build

```bash
# Configurar SDK
echo "sdk.dir=/path/to/android/sdk" > local.properties

# Build debug
./gradlew assembleDebug

# Build release
./gradlew assembleRelease
```

## Estructura

```
app/src/main/java/com/streamcast/app/
├── cast/          # CastManager, CastOptionsProvider
├── detection/     # VideoDetector
├── ui/
│   ├── browser/   # BrowserFragment
│   ├── cast/      # CastControlSheet
│   └── history/   # HistoryFragment
└── detection/     # DetectedVideo
```

## APK

El APK debug está en: `app/build/outputs/apk/debug/app-debug.apk`

## Licencia

MIT
