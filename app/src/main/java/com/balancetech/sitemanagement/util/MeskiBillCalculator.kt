package com.balancetech.sitemanagement.util

/**
 * MESKİ (Mersin Su ve Kanalizasyon İdaresi) standartlarına göre su faturası hesaplama
 * 
 * Hesaplama Bileşenleri:
 * 1. Kademeli Su Tarifesi (tüketim miktarına göre)
 * 2. Atık Su Bedeli (su bedelinin bir yüzdesi)
 * 3. Çevre Temizlik Vergisi (ÇTV) - m³ başına sabit tutar
 * 4. KDV (%20)
 */
object MeskiBillCalculator {
    
    /**
     * MESKİ Tarife Kademeleri (2024 - örnek değerler, güncellenebilir)
     */
    data class TariffTier(
        val minConsumption: Double, // Minimum tüketim (m³)
        val maxConsumption: Double, // Maksimum tüketim (m³) - null ise sınırsız
        val pricePerCubicMeter: Double // m³ başına fiyat (₺)
    )
    
    /**
     * MESKİ Tarife Yapılandırması
     */
    data class MeskiTariff(
        val tiers: List<TariffTier>, // Kademeli tarifeler
        val wastewaterRate: Double = 0.50, // Atık su bedeli oranı (%50 = 0.50)
        val environmentalTaxPerCubicMeter: Double = 0.50, // ÇTV m³ başına (₺)
        val vatRate: Double = 0.20 // KDV oranı (%20 = 0.20)
    )
    
    /**
     * Varsayılan MESKİ Tarifesi
     * Not: Bu değerler örnek değerlerdir, güncel tarifeler MESKİ'den alınmalıdır
     */
    val defaultMeskiTariff = MeskiTariff(
        tiers = listOf(
            TariffTier(0.0, 15.0, 8.50), // İlk 15 m³: 8.50 ₺/m³
            TariffTier(15.0, 30.0, 10.00), // 15-30 m³: 10.00 ₺/m³
            TariffTier(30.0, 50.0, 12.00), // 30-50 m³: 12.00 ₺/m³
            TariffTier(50.0, Double.MAX_VALUE, 15.00) // 50+ m³: 15.00 ₺/m³
        ),
        wastewaterRate = 0.50, // Atık su bedeli su bedelinin %50'si
        environmentalTaxPerCubicMeter = 0.50, // ÇTV: 0.50 ₺/m³
        vatRate = 0.20 // KDV: %20
    )
    
    /**
     * Su Faturası Hesaplama Sonucu
     */
    data class BillCalculationResult(
        val consumption: Double, // Tüketim (m³)
        val waterAmount: Double, // Su bedeli (₺)
        val wastewaterAmount: Double, // Atık su bedeli (₺)
        val environmentalTax: Double, // Çevre Temizlik Vergisi (₺)
        val subtotal: Double, // Ara toplam (Su + Atık Su + ÇTV)
        val vat: Double, // KDV (₺)
        val totalAmount: Double, // Toplam tutar (₺)
        val breakdown: List<TierBreakdown> // Kademe bazında detay
    )
    
    /**
     * Kademe bazında detay
     */
    data class TierBreakdown(
        val tier: TariffTier,
        val consumptionInTier: Double, // Bu kademedeki tüketim (m³)
        val amount: Double // Bu kademedeki tutar (₺)
    )
    
    /**
     * MESKİ standartlarına göre su faturası hesapla
     * 
     * @param consumption Tüketim miktarı (m³)
     * @param tariff MESKİ tarifesi (varsayılan kullanılabilir)
     * @return Hesaplama sonucu
     */
    fun calculateWaterBill(
        consumption: Double,
        tariff: MeskiTariff = defaultMeskiTariff
    ): BillCalculationResult {
        if (consumption <= 0) {
            return BillCalculationResult(
                consumption = 0.0,
                waterAmount = 0.0,
                wastewaterAmount = 0.0,
                environmentalTax = 0.0,
                subtotal = 0.0,
                vat = 0.0,
                totalAmount = 0.0,
                breakdown = emptyList()
            )
        }
        
        var remainingConsumption = consumption
        val breakdown = mutableListOf<TierBreakdown>()
        var totalWaterAmount = 0.0
        
        // Kademeli tarife hesaplaması
        for (tier in tariff.tiers) {
            if (remainingConsumption <= 0) break
            
            val tierMax = if (tier.maxConsumption == Double.MAX_VALUE) {
                remainingConsumption
            } else {
                tier.maxConsumption
            }
            
            val consumptionInTier = minOf(
                remainingConsumption,
                tierMax - tier.minConsumption
            )
            
            if (consumptionInTier > 0) {
                val tierAmount = consumptionInTier * tier.pricePerCubicMeter
                totalWaterAmount += tierAmount
                
                breakdown.add(
                    TierBreakdown(
                        tier = tier,
                        consumptionInTier = consumptionInTier,
                        amount = tierAmount
                    )
                )
                
                remainingConsumption -= consumptionInTier
            }
        }
        
        // Atık su bedeli (su bedelinin belirli bir yüzdesi)
        val wastewaterAmount = totalWaterAmount * tariff.wastewaterRate
        
        // Çevre Temizlik Vergisi (m³ başına sabit tutar)
        val environmentalTax = consumption * tariff.environmentalTaxPerCubicMeter
        
        // Ara toplam (Su + Atık Su + ÇTV)
        val subtotal = totalWaterAmount + wastewaterAmount + environmentalTax
        
        // KDV (ara toplam üzerinden)
        val vat = subtotal * tariff.vatRate
        
        // Toplam tutar
        val totalAmount = subtotal + vat
        
        return BillCalculationResult(
            consumption = consumption,
            waterAmount = totalWaterAmount,
            wastewaterAmount = wastewaterAmount,
            environmentalTax = environmentalTax,
            subtotal = subtotal,
            vat = vat,
            totalAmount = totalAmount,
            breakdown = breakdown
        )
    }
    
    /**
     * Fatura detayını formatlanmış string olarak döndür
     */
    fun formatBillDetails(result: BillCalculationResult): String {
        return buildString {
            appendLine("Tüketim: ${String.format("%.2f", result.consumption)} m³")
            appendLine("Su Bedeli: ${String.format("%.2f", result.waterAmount)} ₺")
            appendLine("Atık Su Bedeli: ${String.format("%.2f", result.wastewaterAmount)} ₺")
            appendLine("Çevre Temizlik Vergisi: ${String.format("%.2f", result.environmentalTax)} ₺")
            appendLine("Ara Toplam: ${String.format("%.2f", result.subtotal)} ₺")
            appendLine("KDV (%20): ${String.format("%.2f", result.vat)} ₺")
            appendLine("TOPLAM: ${String.format("%.2f", result.totalAmount)} ₺")
        }
    }
}

