# Firestore Database Seed Rehberi

Firestore, NoSQL bir veritabanıdır ve **collections (tablolar) otomatik olarak oluşturulur** - ilk veri yazıldığında. Ancak initial data (başlangıç verileri) için seed script'i kullanabilirsiniz.

## Firestore Nasıl Çalışır?

### Otomatik Collection Oluşturma

Firestore'da collections **otomatik olarak oluşturulur**:

1. **İlk veri yazıldığında**: Bir collection'a ilk document yazıldığında, collection otomatik oluşur
2. **Schema yok**: Firestore'da schema (tablo yapısı) yoktur, her document farklı field'lara sahip olabilir
3. **Index'ler**: Query'ler için gerekli index'ler otomatik oluşturulur (bazı durumlarda manuel eklemeniz gerekebilir)

### Örnek

```javascript
// Bu kod çalıştığında "users" collection'ı otomatik oluşur
await db.collection("users").doc("user-001").set({
  name: "John",
  email: "john@example.com"
});
```

## Seed Script Kullanımı

### 1. Seed Script'i Çalıştırma

#### Yerel Olarak (Node.js ile)

```bash
cd functions
node seed.js
```

#### Firebase Functions Olarak

```bash
# Functions'ı deploy edin
firebase deploy --only functions:seedDatabase

# Sonra çağırın (Android uygulamasından veya Firebase Console'dan)
```

#### Android Uygulamasından

```kotlin
val functions = FirebaseFunctions.getInstance()
functions.getHttpsCallable("seedDatabase")
    .call(hashMapOf())
    .addOnSuccessListener { result ->
        // Başarılı
    }
    .addOnFailureListener { exception ->
        // Hata
    }
```

### 2. Seed Script Ne Yapar?

Seed script şunları oluşturur:

- ✅ **1 Apartment** (Küçükyalı Site)
- ✅ **2 Blocks** (A Blok, B Blok)
- ✅ **10 Units** (Daireler)
- ✅ **6 Users** (1 Admin, 5 Resident)
- ✅ **10 Water Meters** (Her daire için)

### 3. Seed Script'i Özelleştirme

`functions/seed.js` dosyasını düzenleyerek:

- Daha fazla/apartman ekleyebilirsiniz
- Farklı unit sayıları kullanabilirsiniz
- Farklı user rolleri ekleyebilirsiniz
- Initial fees, payments, vb. ekleyebilirsiniz

### 4. Production'da Kullanım

⚠️ **DİKKAT**: Seed script production'da dikkatli kullanılmalıdır:

1. **Sadece Admin kullanıcılar** seed yapabilir (kodda kontrol var)
2. **Mevcut verileri silmez** - sadece yeni veri ekler
3. **Duplicate kontrolü** ekleyebilirsiniz

## Manuel Collection Oluşturma

Firestore'da collections'ı manuel oluşturmanıza gerek yok. Ancak şunları yapabilirsiniz:

### 1. Firestore Console'dan

1. Firebase Console > Firestore Database
2. "Start collection" butonuna tıklayın
3. Collection ID girin (örn: "users")
4. İlk document'i ekleyin

### 2. Android Uygulamasından

```kotlin
// İlk veri yazıldığında collection otomatik oluşur
firestore.collection("users")
    .document("user-001")
    .set(userData)
```

### 3. Firebase Functions'dan

```javascript
// Collection otomatik oluşur
await db.collection("fees").doc("fee-001").set(feeData);
```

## Collection Yapısı

Projenizdeki entity'lere göre şu collections oluşturulacak:

| Collection | Açıklama | Otomatik Oluşur? |
|------------|----------|------------------|
| `apartments` | Apartmanlar | ✅ İlk veri yazıldığında |
| `blocks` | Bloklar | ✅ İlk veri yazıldığında |
| `units` | Daireler | ✅ İlk veri yazıldığında |
| `users` | Kullanıcılar | ✅ İlk veri yazıldığında |
| `fees` | Aidatlar | ✅ İlk veri yazıldığında |
| `payments` | Ödemeler | ✅ İlk veri yazıldığında |
| `water_meters` | Su sayaçları | ✅ İlk veri yazıldığında |
| `water_bills` | Su faturaları | ✅ İlk veri yazıldığında |
| `notifications` | Bildirimler | ✅ İlk veri yazıldığında |
| `extra_payments` | Ek ödemeler | ✅ İlk veri yazıldığında |

## Index'ler

Bazı query'ler için **composite index**'lere ihtiyaç duyabilirsiniz:

### Otomatik Index Oluşturma

Firestore, basit query'ler için index'leri otomatik oluşturur. Ancak şu durumlarda manuel index gerekir:

- Birden fazla field'da filtreleme
- Farklı field'larda sıralama ve filtreleme

### Index Oluşturma

1. Firebase Console > Firestore Database > Indexes
2. "Create Index" butonuna tıklayın
3. Collection ve field'ları seçin

Veya `firestore.indexes.json` dosyasını düzenleyin:

```json
{
  "indexes": [
    {
      "collectionGroup": "fees",
      "queryScope": "COLLECTION",
      "fields": [
        {"fieldPath": "apartmentId", "order": "ASCENDING"},
        {"fieldPath": "month", "order": "ASCENDING"},
        {"fieldPath": "year", "order": "DESCENDING"}
      ]
    }
  ]
}
```

Sonra deploy edin:
```bash
firebase deploy --only firestore:indexes
```

## Önerilen Yaklaşım

1. **Development**: Seed script kullanarak initial data oluşturun
2. **Production**: Seed script'i sadece ilk kurulumda kullanın
3. **Schema Validation**: Firebase Functions'da input validation yapın
4. **Index Management**: Gerekli index'leri `firestore.indexes.json`'da tanımlayın

## Sorun Giderme

### Collection Görünmüyor

- Firestore Console'da "Data" sekmesine bakın
- Collection ID'nin doğru yazıldığından emin olun
- İlk veri yazıldığından emin olun

### Index Hatası

- Firebase Console'da index önerilerini kontrol edin
- `firestore.indexes.json` dosyasını güncelleyin
- Index'leri deploy edin

### Seed Script Çalışmıyor

- Node.js versiyonunu kontrol edin (20+)
- Firebase Admin SDK'nın initialize edildiğinden emin olun
- Authentication kontrolünü geçtiğinizden emin olun



