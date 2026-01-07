package com.balancetech.sitemanagement.ui.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0018\u0019B\u001f\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\tJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rJ\u001c\u0010\u000e\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\rR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/UnitCheckboxAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "Lcom/balancetech/sitemanagement/ui/adapter/UnitCheckboxAdapter$UnitViewHolder;", "onUnitChecked", "Lkotlin/Function2;", "", "", "", "(Lkotlin/jvm/functions/Function2;)V", "selectedUnitIds", "", "getSelectedUnits", "", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedUnits", "unitIds", "UnitDiffCallback", "UnitViewHolder", "app_debug"})
public final class UnitCheckboxAdapter extends androidx.recyclerview.widget.ListAdapter<com.balancetech.sitemanagement.data.entity.Unit, com.balancetech.sitemanagement.ui.adapter.UnitCheckboxAdapter.UnitViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Boolean, kotlin.Unit> onUnitChecked = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Set<java.lang.String> selectedUnitIds = null;
    
    public UnitCheckboxAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onUnitChecked) {
        super(null);
    }
    
    public final void setSelectedUnits(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> unitIds) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<java.lang.String> getSelectedUnits() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.balancetech.sitemanagement.ui.adapter.UnitCheckboxAdapter.UnitViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.ui.adapter.UnitCheckboxAdapter.UnitViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/UnitCheckboxAdapter$UnitDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class UnitDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.balancetech.sitemanagement.data.entity.Unit> {
        
        public UnitDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Unit oldItem, @org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Unit newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Unit oldItem, @org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Unit newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/balancetech/sitemanagement/ui/adapter/UnitCheckboxAdapter$UnitViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/balancetech/sitemanagement/databinding/ItemUnitCheckboxBinding;", "(Lcom/balancetech/sitemanagement/ui/adapter/UnitCheckboxAdapter;Lcom/balancetech/sitemanagement/databinding/ItemUnitCheckboxBinding;)V", "bind", "", "unit", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "app_debug"})
    public final class UnitViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.balancetech.sitemanagement.databinding.ItemUnitCheckboxBinding binding = null;
        
        public UnitViewHolder(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.databinding.ItemUnitCheckboxBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.data.entity.Unit unit) {
        }
    }
}