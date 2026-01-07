# Sonraki Adımlar - Firebase Functions Entegrasyonu

## ✅ Tamamlanan Adımlar

1. ✅ Functions bağımlılıkları yüklendi (`npm install`)
2. ✅ Firebase login durumu kontrol edildi
3. ✅ `FirebaseFunctionsService` oluşturuldu
4. ✅ Repository'ler Functions kullanacak şekilde güncellendi:
   - `FeeRepository`
   - `PaymentRepository`
   - `WaterMeterRepository`
5. ✅ Dependency Injection modülleri güncellendi

## 🔧 Yapmanız Gerekenler

### 1. Firebase Projesi Oluşturun

1. [Firebase Console](https://console.firebase.google.com/)'a gidin
2. "Add project" ile yeni proje oluşturun
3. Proje ID'nizi not edin

### 2. Firebase Projesini Bağlayın

`.firebaserc` dosyasını düzenleyin:

```json
{
  "projects": {
    "default": "GERÇEK-PROJE-ID-NİZ"
  }
}
```

### 3. Firebase'e Giriş Yapın (Gerekirse)

```bash
firebase login
```

### 4. google-services.json Dosyasını Ekleyin

1. Firebase Console'da projenizi açın
2. ⚙️ Settings > Project settings
3. "Your apps" bölümünde Android ikonuna tıklayın
4. Package name: `com.balancetech.sitemanagement`
5. `google-services.json` dosyasını indirin
6. İndirilen dosyayı `app/` klasörüne kopyalayın

### 5. Firestore Database'i Oluşturun

1. Firebase Console'da "Firestore Database" sekmesine gidin
2. "Create database" butonuna tıklayın
3. "Start in test mode" seçin (geliştirme için)
4. Location seçin ve "Enable" butonuna tıklayın

### 6. Firestore Security Rules'ı Güncelleyin

`firestore.rules` dosyası zaten oluşturuldu. Deploy etmek için:

```bash
firebase deploy --only firestore:rules
```

### 7. Functions'ları Deploy Edin

```bash
firebase deploy --only functions
```

**Not:** İlk deploy 5-10 dakika sürebilir.

### 8. Firebase Authentication'ı Etkinleştirin

1. Firebase Console'da "Authentication" sekmesine gidin
2. "Get started" butonuna tıklayın
3. "Sign-in method" sekmesinde "Email/Password" provider'ını etkinleştirin

## 📱 Android Uygulamasında Test

Uygulama şu şekilde çalışır:

1. **Offline-First**: Tüm veriler önce local Room database'e yazılır
2. **Background Sync**: Veriler arka planda Firebase Functions'a gönderilir
3. **Fallback**: Functions başarısız olursa direkt Firestore'a yazılır

### Test Senaryoları

1. **Aidat Oluşturma**:
   - `CreateFeeDialogFragment` ile yeni aidat oluşturun
   - Local database'de görünmeli
   - Firebase Console'da Firestore'da da görünmeli

2. **Ödeme Kaydı**:
   - Bir aidat için ödeme yapın
   - Payment hem local hem Firebase'de kaydedilmeli
   - Fee durumu otomatik güncellenmeli

3. **Su Sayaç Okuması**:
   - Su sayaç okuması girin
   - Water bill otomatik oluşturulmalı
   - Firebase'de görünmeli

## 🔍 Kontrol Listesi

- [ ] Firebase projesi oluşturuldu
- [ ] `.firebaserc` dosyası güncellendi
- [ ] `google-services.json` dosyası `app/` klasörüne eklendi
- [ ] Firestore Database oluşturuldu
- [ ] Firestore Rules deploy edildi
- [ ] Functions deploy edildi
- [ ] Firebase Authentication etkinleştirildi
- [ ] Uygulama test edildi

## 🐛 Sorun Giderme

### Functions Deploy Edilemiyor

```bash
# Functions klasöründe bağımlılıkları kontrol edin
cd functions
npm install
cd ..

# Tekrar deploy edin
firebase deploy --only functions
```

### Authentication Hatası

Functions'lar authentication gerektirir. Firebase Authentication'ı etkinleştirdiğinizden emin olun.

### google-services.json Bulunamıyor

Dosyanın `app/` klasöründe olduğundan ve `build.gradle` dosyasında Google Services plugin'inin eklendiğinden emin olun.

## 📚 Daha Fazla Bilgi

- `FIREBASE_SETUP.md` - Firebase genel kurulum rehberi
- `FIREBASE_FUNCTIONS_SETUP.md` - Functions detaylı kurulum rehberi
- `functions/README.md` - Functions klasörü için README

## 🎉 Hazırsınız!

Tüm kodlar hazır. Sadece Firebase projesini oluşturup deploy etmeniz gerekiyor!


