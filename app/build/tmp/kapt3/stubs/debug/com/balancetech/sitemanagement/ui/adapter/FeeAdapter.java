package com.balancetech.sitemanagement.ui.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\u00062\n\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/FeeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "Lcom/balancetech/sitemanagement/ui/adapter/FeeAdapter$FeeViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "onPaymentClick", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FeeDiffCallback", "FeeViewHolder", "app_debug"})
public final class FeeAdapter extends androidx.recyclerview.widget.ListAdapter<com.balancetech.sitemanagement.data.entity.Fee, com.balancetech.sitemanagement.ui.adapter.FeeAdapter.FeeViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.balancetech.sitemanagement.data.entity.Fee, kotlin.Unit> onItemClick = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.balancetech.sitemanagement.data.entity.Fee, kotlin.Unit> onPaymentClick = null;
    
    public FeeAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.balancetech.sitemanagement.data.entity.Fee, kotlin.Unit> onItemClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.balancetech.sitemanagement.data.entity.Fee, kotlin.Unit> onPaymentClick) {
        super(null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.balancetech.sitemanagement.ui.adapter.FeeAdapter.FeeViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.ui.adapter.FeeAdapter.FeeViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/FeeAdapter$FeeDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class FeeDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.balancetech.sitemanagement.data.entity.Fee> {
        
        public FeeDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Fee oldItem, @org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Fee newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Fee oldItem, @org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Fee newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/FeeAdapter$FeeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/balancetech/sitemanagement/databinding/ItemFeeBinding;", "(Lcom/balancetech/sitemanagement/ui/adapter/FeeAdapter;Lcom/balancetech/sitemanagement/databinding/ItemFeeBinding;)V", "bind", "", "fee", "Lcom/balancetech/sitemanagement/data/entity/Fee;", "app_debug"})
    public final class FeeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.balancetech.sitemanagement.databinding.ItemFeeBinding binding = null;
        
        public FeeViewHolder(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.databinding.ItemFeeBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Fee fee) {
        }
    }
}