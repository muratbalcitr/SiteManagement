# Firebase Functions Kurulum Rehberi

Bu rehber, projeye Firebase Functions'ı eklemek ve deploy etmek için gerekli adımları içerir.

## Gereksinimler

- Node.js 20 veya üzeri (Node.js 18 artık desteklenmiyor)
- npm veya yarn
- Firebase CLI

## 1. Node.js Kurulumu

### macOS (Homebrew ile)
```bash
brew install node@20
```

### Windows
[Node.js resmi sitesinden](https://nodejs.org/) LTS versiyonunu indirip kurun.

### Linux (Ubuntu/Debian)
```bash
curl -fsSL https://deb.nodesource.com/setup_20.x | sudo -E bash -
sudo apt-get install -y nodejs
```

Kurulumu kontrol edin:
```bash
node --version
npm --version
```

## 2. Firebase CLI Kurulumu

### Global Kurulum (Önerilen)
```bash
npm install -g firebase-tools
```

### Kurulumu Kontrol Edin
```bash
firebase --version
```

### Firebase'e Giriş Yapın
```bash
firebase login
```

Bu komut tarayıcınızı açacak ve Google hesabınızla giriş yapmanızı isteyecek.

## 3. Proje Yapılandırması

### Firebase Projesini Bağlayın

1. Firebase Console'da projenizi oluşturun (henüz oluşturmadıysanız)
2. Proje ID'nizi not edin
3. `.firebaserc` dosyasındaki `your-project-id` değerini gerçek proje ID'nizle değiştirin:

```json
{
  "projects": {
    "default": "gerçek-proje-id-niz"
  }
}
```

## 4. Functions Bağımlılıklarını Yükleyin

```bash
cd functions
npm install
cd ..
```

## 5. Local Development (Opsiyonel)

Firebase Functions'ı local olarak test etmek için:

```bash
cd functions
npm run serve
```

Bu komut Firebase Emulator Suite'i başlatır ve functions'ları local'de çalıştırır.

## 6. Functions'ları Deploy Etme

### Tüm Functions'ları Deploy Etme
```bash
firebase deploy --only functions
```

### Belirli Bir Function Deploy Etme
```bash
firebase deploy --only functions:createFee
```

### İlk Deploy
İlk deploy işlemi biraz zaman alabilir (5-10 dakika). Firebase Functions runtime'ı oluşturulur.

## 7. Functions Loglarını Görüntüleme

```bash
firebase functions:log
```

Veya belirli bir function için:
```bash
firebase functions:log --only createFee
```

## 8. Android Uygulamasında Functions Kullanımı

Functions'ları Android uygulamasında kullanmak için:

### Örnek: createFee Function'ını Çağırma

```kotlin
import com.google.firebase.functions.FirebaseFunctions

val functions = FirebaseFunctions.getInstance()

val data = hashMapOf(
    "apartmentId" to apartmentId,
    "unitId" to unitId,
    "month" to month,
    "year" to year,
    "amount" to amount,
    "dueDate" to dueDate
)

functions.getHttpsCallable("createFee")
    .call(data)
    .addOnSuccessListener { result ->
        // Başarılı
        val response = result.data as? Map<*, *>
        // Response'u işle
    }
    .addOnFailureListener { exception ->
        // Hata
        // Hata mesajını göster
    }
```

## 9. Mevcut Functions

### createFee
Yeni bir aidat oluşturur.

**Parametreler:**
- `apartmentId`: String
- `unitId`: String
- `month`: Number (1-12)
- `year`: Number
- `amount`: Number
- `dueDate`: Number (timestamp)

### createFeesForAllUnits
Bir apartmandaki tüm daireler için aidat oluşturur.

**Parametreler:**
- `apartmentId`: String
- `month`: Number (1-12)
- `year`: Number
- `baseAmount`: Number
- `dueDate`: Number (timestamp)

### recordPayment
Ödeme kaydı oluşturur.

**Parametreler:**
- `unitId`: String
- `amount`: Number
- `paymentMethod`: String
- `description`: String (opsiyonel)
- `feeId`: String (opsiyonel)
- `extraPaymentId`: String (opsiyonel)
- `waterBillId`: String (opsiyonel)

### recordWaterMeterReading
Su sayaç okuması kaydeder ve fatura oluşturur.

**Parametreler:**
- `unitId`: String
- `currentReading`: Number

### sendPaymentReminders (Scheduled)
Günlük olarak ödeme hatırlatmaları gönderir. Otomatik çalışır.

## 10. Functions'ları Güncelleme

Functions kodunu değiştirdikten sonra:

```bash
firebase deploy --only functions
```

## 11. Functions'ları Silme

Bir function'ı silmek için:

1. `functions/index.js` dosyasından function kodunu silin
2. Deploy edin:
```bash
firebase deploy --only functions
```

## 12. Troubleshooting

### "Functions directory does not exist" Hatası
`firebase.json` dosyasının `functions` klasörünü doğru işaret ettiğinden emin olun.

### "Permission denied" Hatası
Firebase'e giriş yaptığınızdan ve proje sahibi olduğunuzdan emin olun:
```bash
firebase login
```

### "Node version mismatch" Hatası
`functions/package.json` dosyasındaki `engines.node` değerini kontrol edin. Node.js versiyonunuzla uyumlu olmalı.

### Local Emulator Çalışmıyor
Firebase Emulator Suite'i kurun:
```bash
firebase init emulators
```

## 13. Production Best Practices

1. **Error Handling**: Tüm functions'larda proper error handling yapın
2. **Input Validation**: Tüm input'ları validate edin
3. **Security**: Authentication kontrolü yapın
4. **Logging**: Önemli işlemleri loglayın
5. **Testing**: Functions'ları test edin
6. **Monitoring**: Firebase Console'da functions loglarını takip edin

## 14. Maliyet Yönetimi

Firebase Functions ücretsiz kotası:
- 2 milyon invocation/ay
- 400,000 GB-saniye/ay
- 200,000 CPU-saniye/ay

Kullanımınızı Firebase Console'dan takip edebilirsiniz.

## Notlar

- Functions'lar cold start süresi nedeniyle ilk çağrıda biraz yavaş olabilir
- Production'da functions'ları optimize edin
- Gereksiz dependencies eklemeyin (bundle size artar)
- Environment variables kullanmak için Firebase Functions Config kullanın

