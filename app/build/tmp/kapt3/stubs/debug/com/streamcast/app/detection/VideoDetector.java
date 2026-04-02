package com.streamcast.app.detection;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u001e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/streamcast/app/detection/VideoDetector;", "", "()V", "VIDEO_EXTENSIONS", "", "", "VIDEO_URL_PATTERNS", "_detectedVideos", "Landroidx/lifecycle/MutableLiveData;", "Lcom/streamcast/app/detection/DetectedVideo;", "detectedVideos", "Landroidx/lifecycle/LiveData;", "getDetectedVideos", "()Landroidx/lifecycle/LiveData;", "scanPageJS", "getScanPageJS", "()Ljava/lang/String;", "videoSet", "", "analyzeUrl", "", "url", "pageTitle", "pageUrl", "clearDetected", "detectFormat", "extractTitle", "guessContentType", "guessResolution", "processJsScanResult", "json", "JsVideoResult", "app_debug"})
public final class VideoDetector {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.streamcast.app.detection.DetectedVideo>> _detectedVideos = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.streamcast.app.detection.DetectedVideo>> detectedVideos = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> videoSet = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> VIDEO_EXTENSIONS = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> VIDEO_URL_PATTERNS = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scanPageJS = null;
    
    public VideoDetector() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.streamcast.app.detection.DetectedVideo>> getDetectedVideos() {
        return null;
    }
    
    public final void analyzeUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String pageTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String pageUrl) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScanPageJS() {
        return null;
    }
    
    public final void processJsScanResult(@org.jetbrains.annotations.NotNull()
    java.lang.String json, @org.jetbrains.annotations.NotNull()
    java.lang.String pageTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String pageUrl) {
    }
    
    private final java.lang.String detectFormat(java.lang.String url) {
        return null;
    }
    
    private final java.lang.String guessResolution(java.lang.String url) {
        return null;
    }
    
    private final java.lang.String guessContentType(java.lang.String url) {
        return null;
    }
    
    private final java.lang.String extractTitle(java.lang.String url, java.lang.String pageTitle) {
        return null;
    }
    
    public final void clearDetected() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/streamcast/app/detection/VideoDetector$JsVideoResult;", "", "url", "", "title", "duration", "", "width", "height", "poster", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getPoster", "()Ljava/lang/String;", "getTitle", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/streamcast/app/detection/VideoDetector$JsVideoResult;", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class JsVideoResult {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String url = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String title = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer duration = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer width = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer height = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String poster = null;
        
        public JsVideoResult(@org.jetbrains.annotations.Nullable()
        java.lang.String url, @org.jetbrains.annotations.Nullable()
        java.lang.String title, @org.jetbrains.annotations.Nullable()
        java.lang.Integer duration, @org.jetbrains.annotations.Nullable()
        java.lang.Integer width, @org.jetbrains.annotations.Nullable()
        java.lang.Integer height, @org.jetbrains.annotations.Nullable()
        java.lang.String poster) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getDuration() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getWidth() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getHeight() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getPoster() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component4() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component5() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.streamcast.app.detection.VideoDetector.JsVideoResult copy(@org.jetbrains.annotations.Nullable()
        java.lang.String url, @org.jetbrains.annotations.Nullable()
        java.lang.String title, @org.jetbrains.annotations.Nullable()
        java.lang.Integer duration, @org.jetbrains.annotations.Nullable()
        java.lang.Integer width, @org.jetbrains.annotations.Nullable()
        java.lang.Integer height, @org.jetbrains.annotations.Nullable()
        java.lang.String poster) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}