package com.balancetech.sitemanagement.ui.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u00062\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/WaterMeterAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "Lcom/balancetech/sitemanagement/ui/adapter/WaterMeterAdapter$WaterMeterViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "onReadingClick", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "WaterMeterDiffCallback", "WaterMeterViewHolder", "app_debug"})
public final class WaterMeterAdapter extends androidx.recyclerview.widget.ListAdapter<com.balancetech.sitemanagement.data.entity.WaterMeter, com.balancetech.sitemanagement.ui.adapter.WaterMeterAdapter.WaterMeterViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.balancetech.sitemanagement.data.entity.WaterMeter, kotlin.Unit> onItemClick = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.balancetech.sitemanagement.data.entity.WaterMeter, kotlin.Unit> onReadingClick = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource = null;
    
    public WaterMeterAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.balancetech.sitemanagement.data.entity.WaterMeter, kotlin.Unit> onItemClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.balancetech.sitemanagement.data.entity.WaterMeter, kotlin.Unit> onReadingClick, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource) {
        super(null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.balancetech.sitemanagement.ui.adapter.WaterMeterAdapter.WaterMeterViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.ui.adapter.WaterMeterAdapter.WaterMeterViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/WaterMeterAdapter$WaterMeterDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class WaterMeterDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.balancetech.sitemanagement.data.entity.WaterMeter> {
        
        public WaterMeterDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.WaterMeter oldItem, @org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.WaterMeter newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.WaterMeter oldItem, @org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.WaterMeter newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/WaterMeterAdapter$WaterMeterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/balancetech/sitemanagement/databinding/ItemWaterMeterBinding;", "(Lcom/balancetech/sitemanagement/ui/adapter/WaterMeterAdapter;Lcom/balancetech/sitemanagement/databinding/ItemWaterMeterBinding;)V", "bind", "", "waterMeter", "Lcom/balancetech/sitemanagement/data/entity/WaterMeter;", "app_debug"})
    public final class WaterMeterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.balancetech.sitemanagement.databinding.ItemWaterMeterBinding binding = null;
        
        public WaterMeterViewHolder(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.databinding.ItemWaterMeterBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.WaterMeter waterMeter) {
        }
    }
}