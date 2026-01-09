package com.balancetech.sitemanagement.util;

/**
 * MESKİ (Mersin Su ve Kanalizasyon İdaresi) standartlarına göre su faturası hesaplama
 *
 * Hesaplama Bileşenleri:
 * 1. Kademeli Su Tarifesi (tüketim miktarına göre)
 * 2. Atık Su Bedeli (su bedelinin bir yüzdesi)
 * 3. Çevre Temizlik Vergisi (ÇTV) - m³ başına sabit tutar
 * 4. KDV (%20)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/balancetech/sitemanagement/util/MeskiBillCalculator;", "", "()V", "defaultMeskiTariff", "Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$MeskiTariff;", "getDefaultMeskiTariff", "()Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$MeskiTariff;", "calculateWaterBill", "Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$BillCalculationResult;", "consumption", "", "tariff", "formatBillDetails", "", "result", "BillCalculationResult", "MeskiTariff", "TariffTier", "TierBreakdown", "app_debug"})
public final class MeskiBillCalculator {
    
    /**
     * Varsayılan MESKİ Tarifesi
     * Not: Bu değerler örnek değerlerdir, güncel tarifeler MESKİ'den alınmalıdır
     */
    @org.jetbrains.annotations.NotNull
    private static final com.balancetech.sitemanagement.util.MeskiBillCalculator.MeskiTariff defaultMeskiTariff = null;
    @org.jetbrains.annotations.NotNull
    public static final com.balancetech.sitemanagement.util.MeskiBillCalculator INSTANCE = null;
    
    private MeskiBillCalculator() {
        super();
    }
    
    /**
     * Varsayılan MESKİ Tarifesi
     * Not: Bu değerler örnek değerlerdir, güncel tarifeler MESKİ'den alınmalıdır
     */
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.util.MeskiBillCalculator.MeskiTariff getDefaultMeskiTariff() {
        return null;
    }
    
    /**
     * MESKİ standartlarına göre su faturası hesapla
     *
     * @param consumption Tüketim miktarı (m³)
     * @param tariff MESKİ tarifesi (varsayılan kullanılabilir)
     * @return Hesaplama sonucu
     */
    @org.jetbrains.annotations.NotNull
    public final com.balancetech.sitemanagement.util.MeskiBillCalculator.BillCalculationResult calculateWaterBill(double consumption, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.util.MeskiBillCalculator.MeskiTariff tariff) {
        return null;
    }
    
    /**
     * Fatura detayını formatlanmış string olarak döndür
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatBillDetails(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.util.MeskiBillCalculator.BillCalculationResult result) {
        return null;
    }
    
    /**
     * Su Faturası Hesaplama Sonucu
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J_\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\'H\u00d6\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006("}, d2 = {"Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$BillCalculationResult;", "", "consumption", "", "waterAmount", "wastewaterAmount", "environmentalTax", "subtotal", "vat", "totalAmount", "breakdown", "", "Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$TierBreakdown;", "(DDDDDDDLjava/util/List;)V", "getBreakdown", "()Ljava/util/List;", "getConsumption", "()D", "getEnvironmentalTax", "getSubtotal", "getTotalAmount", "getVat", "getWastewaterAmount", "getWaterAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class BillCalculationResult {
        private final double consumption = 0.0;
        private final double waterAmount = 0.0;
        private final double wastewaterAmount = 0.0;
        private final double environmentalTax = 0.0;
        private final double subtotal = 0.0;
        private final double vat = 0.0;
        private final double totalAmount = 0.0;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TierBreakdown> breakdown = null;
        
        public BillCalculationResult(double consumption, double waterAmount, double wastewaterAmount, double environmentalTax, double subtotal, double vat, double totalAmount, @org.jetbrains.annotations.NotNull
        java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TierBreakdown> breakdown) {
            super();
        }
        
        public final double getConsumption() {
            return 0.0;
        }
        
        public final double getWaterAmount() {
            return 0.0;
        }
        
        public final double getWastewaterAmount() {
            return 0.0;
        }
        
        public final double getEnvironmentalTax() {
            return 0.0;
        }
        
        public final double getSubtotal() {
            return 0.0;
        }
        
        public final double getVat() {
            return 0.0;
        }
        
        public final double getTotalAmount() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TierBreakdown> getBreakdown() {
            return null;
        }
        
        public final double component1() {
            return 0.0;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        public final double component3() {
            return 0.0;
        }
        
        public final double component4() {
            return 0.0;
        }
        
        public final double component5() {
            return 0.0;
        }
        
        public final double component6() {
            return 0.0;
        }
        
        public final double component7() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TierBreakdown> component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.util.MeskiBillCalculator.BillCalculationResult copy(double consumption, double waterAmount, double wastewaterAmount, double environmentalTax, double subtotal, double vat, double totalAmount, @org.jetbrains.annotations.NotNull
        java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TierBreakdown> breakdown) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    /**
     * MESKİ Tarife Yapılandırması
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J7\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$MeskiTariff;", "", "tiers", "", "Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$TariffTier;", "wastewaterRate", "", "environmentalTaxPerCubicMeter", "vatRate", "(Ljava/util/List;DDD)V", "getEnvironmentalTaxPerCubicMeter", "()D", "getTiers", "()Ljava/util/List;", "getVatRate", "getWastewaterRate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class MeskiTariff {
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier> tiers = null;
        private final double wastewaterRate = 0.0;
        private final double environmentalTaxPerCubicMeter = 0.0;
        private final double vatRate = 0.0;
        
        public MeskiTariff(@org.jetbrains.annotations.NotNull
        java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier> tiers, double wastewaterRate, double environmentalTaxPerCubicMeter, double vatRate) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier> getTiers() {
            return null;
        }
        
        public final double getWastewaterRate() {
            return 0.0;
        }
        
        public final double getEnvironmentalTaxPerCubicMeter() {
            return 0.0;
        }
        
        public final double getVatRate() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier> component1() {
            return null;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        public final double component3() {
            return 0.0;
        }
        
        public final double component4() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.util.MeskiBillCalculator.MeskiTariff copy(@org.jetbrains.annotations.NotNull
        java.util.List<com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier> tiers, double wastewaterRate, double environmentalTaxPerCubicMeter, double vatRate) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    /**
     * MESKİ Tarife Kademeleri (2024 - örnek değerler, güncellenebilir)
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$TariffTier;", "", "minConsumption", "", "maxConsumption", "pricePerCubicMeter", "(DDD)V", "getMaxConsumption", "()D", "getMinConsumption", "getPricePerCubicMeter", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class TariffTier {
        private final double minConsumption = 0.0;
        private final double maxConsumption = 0.0;
        private final double pricePerCubicMeter = 0.0;
        
        public TariffTier(double minConsumption, double maxConsumption, double pricePerCubicMeter) {
            super();
        }
        
        public final double getMinConsumption() {
            return 0.0;
        }
        
        public final double getMaxConsumption() {
            return 0.0;
        }
        
        public final double getPricePerCubicMeter() {
            return 0.0;
        }
        
        public final double component1() {
            return 0.0;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        public final double component3() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier copy(double minConsumption, double maxConsumption, double pricePerCubicMeter) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    /**
     * Kademe bazında detay
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$TierBreakdown;", "", "tier", "Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$TariffTier;", "consumptionInTier", "", "amount", "(Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$TariffTier;DD)V", "getAmount", "()D", "getConsumptionInTier", "getTier", "()Lcom/balancetech/sitemanagement/util/MeskiBillCalculator$TariffTier;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class TierBreakdown {
        @org.jetbrains.annotations.NotNull
        private final com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier tier = null;
        private final double consumptionInTier = 0.0;
        private final double amount = 0.0;
        
        public TierBreakdown(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier tier, double consumptionInTier, double amount) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier getTier() {
            return null;
        }
        
        public final double getConsumptionInTier() {
            return 0.0;
        }
        
        public final double getAmount() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier component1() {
            return null;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        public final double component3() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.balancetech.sitemanagement.util.MeskiBillCalculator.TierBreakdown copy(@org.jetbrains.annotations.NotNull
        com.balancetech.sitemanagement.util.MeskiBillCalculator.TariffTier tier, double consumptionInTier, double amount) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}