# Excel Import/Export Format Açıklaması

## Daire Listesi Formatı

### Sütunlar (Sıralı)

1. **Blok** - Blok adı (A, B, C, vb.)
2. **Daire Numarası** - Daire numarası (1, 2, 3, vb.)
3. **Kat** - Kat numarası (1, 2, 3, vb.)
4. **Alan (m²)** - Daire alanı metrekare cinsinden (100.0, 120.5, vb.)
5. **Arsa Payı** - Arsa payı oranı (0.0278, 0.0333, vb.) - Opsiyonel, boş bırakılırsa otomatik hesaplanır
6. **Sahip Tipi** - OWNER (Sahibi) veya TENANT (Kiracı) - Opsiyonel, varsayılan: OWNER
7. **Sahip Adı** - Sahip/Kiracı adı - Opsiyonel
8. **Sahip Telefonu** - Sahip/Kiracı telefonu - Opsiyonel

### Örnek CSV Dosyası

```csv
Blok,Daire Numarası,Kat,Alan (m²),Arsa Payı,Sahip Tipi,Sahip Adı,Sahip Telefonu
A,1,1,100.0,0.0278,OWNER,Ahmet Yılmaz,5551234567
A,2,1,100.0,0.0278,TENANT,Mehmet Demir,5559876543
A,3,1,100.0,0.0278,OWNER,Ayşe Kaya,5551112233
B,1,1,120.0,0.0333,OWNER,Fatma Öz,5554445566
B,2,1,120.0,0.0333,TENANT,Ali Veli,5557778899
B,3,1,120.0,0.0333,OWNER,Zeynep Şahin,5550001122
```

### Minimum Gereksinimler

- **Zorunlu Sütunlar**: Blok, Daire Numarası, Kat, Alan (m²)
- **Opsiyonel Sütunlar**: Arsa Payı, Sahip Tipi, Sahip Adı, Sahip Telefonu

### Örnekler

#### Basit Format (Minimum)
```csv
Blok,Daire Numarası,Kat,Alan (m²)
A,1,1,100.0
A,2,1,100.0
B,1,1,120.0
```

#### Tam Format
```csv
Blok,Daire Numarası,Kat,Alan (m²),Arsa Payı,Sahip Tipi,Sahip Adı,Sahip Telefonu
A,1,1,100.0,0.0278,OWNER,Ahmet Yılmaz,5551234567
A,2,1,100.0,0.0278,TENANT,Mehmet Demir,5559876543
```

### Önemli Notlar

1. **Header Satırı**: İlk satır mutlaka başlık satırı olmalı
2. **UTF-8 Encoding**: Dosya UTF-8 formatında kaydedilmeli (BOM ile)
3. **Virgül Ayırıcı**: Sütunlar virgül (,) ile ayrılmalı
4. **Tırnak İşareti**: Alanlar virgül içeriyorsa tırnak içine alınmalı: `"Yılmaz, Ahmet"`
5. **Ondalık Sayılar**: Nokta (.) ile ayrılmalı: `100.5` (virgül değil)
6. **Sahip Tipi**: Sadece `OWNER` veya `TENANT` olabilir (büyük/küçük harf duyarsız)

### Excel'de Oluşturma

1. Excel'de yeni bir dosya açın
2. İlk satıra başlıkları yazın
3. Her satıra bir daire bilgisi girin
4. Dosyayı **CSV (UTF-8)** formatında kaydedin
5. Uygulamada "Excel'den Aktar" butonuna tıklayın ve dosyayı seçin

### Export Edilen Format

Uygulamadan export edilen dosya aynı formatta olacaktır, böylece:
- Export edilen dosyayı düzenleyip tekrar import edebilirsiniz
- Excel'de açıp düzenleyebilirsiniz
- Başka sistemlere aktarabilirsiniz



