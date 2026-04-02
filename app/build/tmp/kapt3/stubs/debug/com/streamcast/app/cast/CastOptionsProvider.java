package com.streamcast.app.cast;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/streamcast/app/cast/CastOptionsProvider;", "Lcom/google/android/gms/cast/framework/OptionsProvider;", "()V", "getAdditionalSessionProviders", "", "Lcom/google/android/gms/cast/framework/SessionProvider;", "context", "Landroid/content/Context;", "getCastOptions", "Lcom/google/android/gms/cast/framework/CastOptions;", "app_debug"})
public final class CastOptionsProvider implements com.google.android.gms.cast.framework.OptionsProvider {
    
    public CastOptionsProvider() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.google.android.gms.cast.framework.CastOptions getCastOptions(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.util.List<com.google.android.gms.cast.framework.SessionProvider> getAdditionalSessionProviders(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}