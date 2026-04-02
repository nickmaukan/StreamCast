# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in ${sdk.dir}/tools/proguard/proguard-android.txt

# Keep Cast classes
-keep class com.google.android.gms.cast.** { *; }
-keep class androidx.media.cast.** { *; }
-keep class androidx.mediarouter.** { *; }

# Keep Room entities
-keep class com.streamcast.app.data.** { *; }

# Keep WebView
-keep class androidx.webkit.** { *; }
