package com.balancetech.sitemanagement.ui.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0010\u0011B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/PaymentAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "Lcom/balancetech/sitemanagement/ui/adapter/PaymentAdapter$PaymentViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PaymentDiffCallback", "PaymentViewHolder", "app_debug"})
public final class PaymentAdapter extends androidx.recyclerview.widget.ListAdapter<com.balancetech.sitemanagement.data.entity.Payment, com.balancetech.sitemanagement.ui.adapter.PaymentAdapter.PaymentViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.balancetech.sitemanagement.data.entity.Payment, kotlin.Unit> onItemClick = null;
    
    public PaymentAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.balancetech.sitemanagement.data.entity.Payment, kotlin.Unit> onItemClick) {
        super(null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.balancetech.sitemanagement.ui.adapter.PaymentAdapter.PaymentViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.ui.adapter.PaymentAdapter.PaymentViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/PaymentAdapter$PaymentDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class PaymentDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.balancetech.sitemanagement.data.entity.Payment> {
        
        public PaymentDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Payment oldItem, @org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Payment newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Payment oldItem, @org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Payment newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/PaymentAdapter$PaymentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/balancetech/sitemanagement/databinding/ItemPaymentBinding;", "(Lcom/balancetech/sitemanagement/ui/adapter/PaymentAdapter;Lcom/balancetech/sitemanagement/databinding/ItemPaymentBinding;)V", "bind", "", "payment", "Lcom/balancetech/sitemanagement/data/entity/Payment;", "app_debug"})
    public final class PaymentViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.balancetech.sitemanagement.databinding.ItemPaymentBinding binding = null;
        
        public PaymentViewHolder(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.databinding.ItemPaymentBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Payment payment) {
        }
    }
}