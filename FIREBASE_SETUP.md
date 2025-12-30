# Firebase Kurulum Rehberi

Bu proje Firebase Firestore, Authentication ve Functions kullanmaktadır.

## 1. Firebase Console'da Proje Oluşturma

1. [Firebase Console](https://console.firebase.google.com/)'a gidin
2. "Add project" butonuna tıklayın
3. Proje adını girin ve devam edin
4. Google Analytics'i etkinleştirmek isteyip istemediğinizi seçin
5. Projeyi oluşturun

## 2. Android Uygulamasını Firebase'e Ekleme

1. Firebase Console'da projenizi açın
2. Android ikonuna tıklayın
3. Package name: `com.balancetech.sitemanagement`
4. App nickname (opsiyonel): Site Management
5. Debug signing certificate SHA-1 (opsiyonel - şimdilik atlayabilirsiniz)
6. "Register app" butonuna tıklayın
7. `google-services.json` dosyasını indirin
8. İndirilen `google-services.json` dosyasını `app/` klasörüne kopyalayın

## 3. Firestore Database Kurulumu

1. Firebase Console'da "Firestore Database" sekmesine gidin
2. "Create database" butonuna tıklayın
3. "Start in test mode" seçeneğini seçin (geliştirme için)
4. Cloud Firestore location seçin (en yakın bölgeyi seçin)
5. "Enable" butonuna tıklayın

### Firestore Security Rules (Test Mode - Geliştirme için)

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if request.time < timestamp.date(2025, 12, 31);
    }
  }
}
```

**ÖNEMLİ:** Production için daha güvenli kurallar yazmanız gerekecek!

### Production Security Rules Örneği

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Users collection
    match /users/{userId} {
      allow read: if request.auth != null;
      allow write: if request.auth != null && request.auth.uid == userId;
    }
    
    // Fees collection
    match /fees/{feeId} {
      allow read: if request.auth != null;
      allow write: if request.auth != null;
    }
    
    // Payments collection
    match /payments/{paymentId} {
      allow read: if request.auth != null;
      allow write: if request.auth != null;
    }
    
    // Water meters collection
    match /water_meters/{meterId} {
      allow read: if request.auth != null;
      allow write: if request.auth != null;
    }
    
    // Water bills collection
    match /water_bills/{billId} {
      allow read: if request.auth != null;
      allow write: if request.auth != null;
    }
    
    // Notifications collection
    match /notifications/{notificationId} {
      allow read: if request.auth != null && 
                     resource.data.userId == request.auth.uid;
      allow write: if request.auth != null;
    }
    
    // Units collection
    match /units/{unitId} {
      allow read: if request.auth != null;
      allow write: if request.auth != null;
    }
  }
}
```

## 4. Firebase Authentication Kurulumu

1. Firebase Console'da "Authentication" sekmesine gidin
2. "Get started" butonuna tıklayın
3. "Sign-in method" sekmesine gidin
4. "Email/Password" provider'ını etkinleştirin
5. İsterseniz diğer provider'ları da etkinleştirebilirsiniz (Google, Facebook, vb.)

## 5. Firebase Functions Kurulumu (Opsiyonel)

Firebase Functions kullanmak istiyorsanız:

1. Firebase Console'da "Functions" sekmesine gidin
2. "Get started" butonuna tıklayın
3. Node.js ve Firebase CLI kurulumu yapın
4. Functions klasörü oluşturun ve deploy edin

## 6. Proje Yapısı

Proje şu şekilde çalışır:

- **Offline-First Strategy**: Tüm veriler önce local Room database'e yazılır
- **Background Sync**: Veriler arka planda Firebase'e senkronize edilir
- **Read Operations**: Okuma işlemleri local database'den yapılır (hızlı)
- **Write Operations**: Yazma işlemleri hem local hem remote'a yapılır

## 7. Sync Mekanizması

Uygulama şu durumlarda sync yapar:

- Uygulama açıldığında (opsiyonel)
- Manuel sync butonu ile
- Veri yazıldığında otomatik olarak arka planda

## 8. Test Etme

1. `google-services.json` dosyasını `app/` klasörüne eklediğinizden emin olun
2. Uygulamayı çalıştırın
3. Firebase Console'da Firestore Database'de verilerin oluştuğunu kontrol edin

## 9. Production'a Geçiş

Production'a geçmeden önce:

1. Firestore Security Rules'ı güvenli hale getirin
2. Firebase Authentication kurallarını gözden geçirin
3. Error handling ve retry mekanizmalarını test edin
4. Offline senkronizasyonu test edin

## Notlar

- `google-services.json` dosyası `.gitignore`'a eklenmemiştir (örnek dosya var)
- Production'da bu dosyayı güvenli bir şekilde yönetmeniz gerekir
- Firebase Functions kullanmak istiyorsanız, backend kodlarını ayrı bir klasörde tutmanız önerilir

