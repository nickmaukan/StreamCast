package com.streamcast.app.ui.videos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/streamcast/app/ui/videos/VideoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/streamcast/app/ui/videos/VideoAdapter$VideoViewHolder;", "videos", "", "Lcom/streamcast/app/detection/DetectedVideo;", "onVideoClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VideoViewHolder", "app_debug"})
public final class VideoAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.streamcast.app.ui.videos.VideoAdapter.VideoViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.streamcast.app.detection.DetectedVideo> videos = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.streamcast.app.detection.DetectedVideo, kotlin.Unit> onVideoClick = null;
    
    public VideoAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.streamcast.app.detection.DetectedVideo> videos, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.streamcast.app.detection.DetectedVideo, kotlin.Unit> onVideoClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.streamcast.app.ui.videos.VideoAdapter.VideoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.streamcast.app.ui.videos.VideoAdapter.VideoViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/streamcast/app/ui/videos/VideoAdapter$VideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/streamcast/app/ui/videos/VideoAdapter;Landroid/view/View;)V", "badgeLive", "Landroid/widget/TextView;", "badgeQuality", "badgeType", "cardView", "Landroidx/cardview/widget/CardView;", "iconType", "Landroid/widget/ImageView;", "textDuration", "titleText", "bind", "", "video", "Lcom/streamcast/app/detection/DetectedVideo;", "formatDuration", "", "seconds", "", "getQualityColor", "", "quality", "app_debug"})
    public final class VideoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final androidx.cardview.widget.CardView cardView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView titleText = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView badgeQuality = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView badgeType = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView badgeLive = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView textDuration = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView iconType = null;
        
        public VideoViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.streamcast.app.detection.DetectedVideo video) {
        }
        
        private final int getQualityColor(java.lang.String quality) {
            return 0;
        }
        
        private final java.lang.String formatDuration(long seconds) {
            return null;
        }
    }
}