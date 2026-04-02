package com.streamcast.app.ui.videos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u001a\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/streamcast/app/ui/videos/DetectedVideosSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/streamcast/app/databinding/SheetDetectedVideosBinding;", "adapter", "Lcom/streamcast/app/ui/videos/VideoAdapter;", "binding", "getBinding", "()Lcom/streamcast/app/databinding/SheetDetectedVideosBinding;", "onVideoSelected", "Lkotlin/Function1;", "Lcom/streamcast/app/detection/DetectedVideo;", "", "getOnVideoSelected", "()Lkotlin/jvm/functions/Function1;", "setOnVideoSelected", "(Lkotlin/jvm/functions/Function1;)V", "videos", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "Companion", "app_debug"})
public final class DetectedVideosSheet extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    @org.jetbrains.annotations.Nullable()
    private com.streamcast.app.databinding.SheetDetectedVideosBinding _binding;
    private com.streamcast.app.ui.videos.VideoAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.streamcast.app.detection.DetectedVideo> videos;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super com.streamcast.app.detection.DetectedVideo, kotlin.Unit> onVideoSelected;
    @org.jetbrains.annotations.NotNull()
    public static final com.streamcast.app.ui.videos.DetectedVideosSheet.Companion Companion = null;
    
    public DetectedVideosSheet() {
        super();
    }
    
    private final com.streamcast.app.databinding.SheetDetectedVideosBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<com.streamcast.app.detection.DetectedVideo, kotlin.Unit> getOnVideoSelected() {
        return null;
    }
    
    public final void setOnVideoSelected(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.streamcast.app.detection.DetectedVideo, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2 = {"Lcom/streamcast/app/ui/videos/DetectedVideosSheet$Companion;", "", "()V", "newInstance", "Lcom/streamcast/app/ui/videos/DetectedVideosSheet;", "videos", "", "Lcom/streamcast/app/detection/DetectedVideo;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.streamcast.app.ui.videos.DetectedVideosSheet newInstance(@org.jetbrains.annotations.NotNull()
        java.util.List<com.streamcast.app.detection.DetectedVideo> videos) {
            return null;
        }
    }
}