# Küçükyalı Site Yönetimi Uygulaması

Android uygulaması - Site yönetimi için geliştirilmiş mobil uygulama.

## Proje Bilgileri

- **Paket Adı**: `com.balancetech.sitemanagement`
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Dil**: Kotlin
- **Build Tool**: Gradle
- **Mimari**: MVVM (Model-View-ViewModel)
- **Dependency Injection**: Hilt
- **Veritabanı**: Room Database
- **Navigation**: Navigation Component

## Özellikler

### ✅ Tamamlanan Özellikler

#### 1. Kullanıcı Yönetimi
- Kullanıcı rolleri (Yönetici, Daire Sakini, Denetçi)
- Giriş/Kayıt sistemi
- Rol bazlı yetkilendirme

#### 2. Veri Modelleri
- Apartman/Bina yönetimi
- Daire/Bağımsız bölüm tanımları
- Blok yönetimi
- Aidat yönetimi
- Ek ödeme yönetimi
- Su sayaç takibi
- Ödeme takibi
- Bildirim sistemi

#### 3. Veritabanı Yapısı
- Room Database entegrasyonu
- Tüm entity'ler için DAO'lar
- Repository pattern implementasyonu

#### 4. UI Ekranları
- Login/Register ekranları
- Dashboard (Ana sayfa)
- Aidatlar ekranı (temel yapı)
- Su sayaç ekranı (temel yapı)
- Ödemeler ekranı (temel yapı)
- Ek ödemeler ekranı (temel yapı)

### 🚧 Geliştirilmesi Gereken Özellikler

#### MVP Öncelikli
1. **Aidat Yönetimi**
   - Aidat listesi görüntüleme
   - Yeni aidat oluşturma (yönetici)
   - Toplu aidat oluşturma
   - Aidat ödeme girişi
   - Borç-alacak hesaplama

2. **Su Sayaç Takibi**
   - Sayaç okuma girişi
   - Otomatik fatura hesaplama
   - Su faturası listesi
   - Tüketim grafikleri

3. **Ödeme Takibi**
   - Manuel ödeme girişi
   - Ödeme geçmişi
   - Borç-alacak özeti

4. **Ek Ödeme Yönetimi**
   - Ek ödeme oluşturma
   - Taksitli ödeme desteği
   - Ödeme takibi

5. **Bildirim Sistemi**
   - Push bildirim entegrasyonu
   - Aidat hatırlatmaları
   - Gecikme uyarıları

## Proje Yapısı

```
app/src/main/java/com/balancetech/sitemanagement/
├── data/
│   ├── model/          # Enum'lar ve modeller
│   ├── entity/         # Room entity'leri
│   ├── dao/            # Data Access Objects
│   ├── repository/     # Repository katmanı
│   └── database/       # Database sınıfı
├── di/                 # Dependency Injection modülleri
├── ui/
│   ├── auth/           # Giriş/Kayıt ekranları
│   ├── dashboard/      # Ana sayfa
│   ├── fees/           # Aidat yönetimi
│   ├── watermeter/     # Su sayaç takibi
│   ├── payments/       # Ödeme takibi
│   ├── extrapayments/  # Ek ödemeler
│   └── viewmodel/      # ViewModel'ler
└── SiteManagementApplication.kt
```

## Teknoloji Stack

- **Kotlin**: Programlama dili
- **AndroidX**: Modern Android kütüphaneleri
- **Material Design 3**: UI bileşenleri
- **Room**: Yerel veritabanı
- **Hilt**: Dependency Injection
- **Navigation Component**: Ekran geçişleri
- **Coroutines & Flow**: Asenkron işlemler
- **ViewBinding**: View binding

## Gereksinimler

- Android Studio Hedgehog (2023.1.1) veya üzeri
- JDK 8 veya üzeri
- Android SDK 34

## Kurulum

1. Projeyi Android Studio'da açın
2. Gradle sync işleminin tamamlanmasını bekleyin
3. Uygulamayı çalıştırın

## Geliştirme Notları

### Veritabanı
- Room Database kullanılmaktadır
- Tüm veriler yerel olarak saklanır (offline-first yaklaşım)
- İleride API entegrasyonu için repository katmanı hazırdır

### Güvenlik
- Şifreler şu anda plain text olarak saklanıyor (production'da hash'lenmeli)
- JWT/OAuth entegrasyonu için hazır yapı mevcut

### Genişletilebilirlik
- Repository pattern sayesinde API entegrasyonu kolay
- MVVM mimarisi test edilebilir kod yapısı sağlar
- Hilt ile dependency injection merkezi yönetiliyor

## Firebase Entegrasyonu

Proje Firebase Firestore, Authentication ve Functions kullanmaktadır.

### Firebase Kurulumu

1. `FIREBASE_SETUP.md` dosyasındaki adımları takip edin
2. `google-services.json` dosyasını `app/` klasörüne ekleyin
3. Firebase Console'da Firestore Database'i oluşturun

### Firebase Functions

Firebase Functions kurulumu için:

1. `FIREBASE_FUNCTIONS_SETUP.md` dosyasındaki adımları takip edin
2. Node.js 18+ ve Firebase CLI kurun
3. `functions/` klasöründe `npm install` çalıştırın
4. `.firebaserc` dosyasında proje ID'nizi güncelleyin
5. `firebase deploy --only functions` ile deploy edin

## Sonraki Adımlar

1. ✅ RecyclerView adapter'ları ve liste ekranlarını tamamla
2. ✅ Form ekranları (aidat oluşturma, su sayaç girişi, vb.)
3. ✅ Ödeme girişi dialog/form ekranları
4. ✅ Bildirim sistemi entegrasyonu
5. ✅ Raporlama ekranları
6. ✅ Firebase entegrasyonu
7. ✅ Firebase Functions kurulumu

