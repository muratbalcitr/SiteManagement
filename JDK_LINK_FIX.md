# JDK jlink Hatası Çözümü

## Sorun

```
Error while executing process /Applications/Android Studio 2.app/Contents/jbr/Contents/Home/bin/jlink
```

Bu hata Android SDK'nın `core-for-system-modules.jar` dosyasını işlerken oluşuyor.

## Çözüm Adımları

### 1. Android SDK Platform Dosyalarını Yeniden İndirin

Android Studio'da:
1. **Tools > SDK Manager**
2. **SDK Platforms** sekmesine gidin
3. **Android 14.0 (API 34)** seçin
4. **Show Package Details** işaretleyin
5. **Android SDK Platform 34** seçin
6. **Apply** ve **OK** tıklayın

### 2. Gradle Cache'i Tamamen Temizle

Terminal'de:
```bash
cd /Users/muratbalci/AndroidStudioProjects/kucukyali-site-yonetimi

# Tüm Gradle cache'i temizle
rm -rf ~/.gradle/caches

# Gradle daemon'ı durdur
./gradlew --stop
```

### 3. Android Studio'yu Yeniden Başlat

1. **File > Invalidate Caches / Restart**
2. **Invalidate and Restart** seçin

### 4. Projeyi Temizle ve Rebuild

1. **Build > Clean Project**
2. **Build > Rebuild Project**

### 5. Alternatif: compileSdk'yı Düşürün (Geçici Çözüm)

Eğer hala sorun varsa, `app/build.gradle` dosyasında:

```gradle
compileSdk 33  // 34 yerine 33
```

Ve `targetSdk` da 33 yapın:

```gradle
targetSdk 33
```

### 6. JDK Path'i Kontrol Edin

`gradle.properties` dosyasında JDK path'i eklendi:

```properties
org.gradle.java.home=/Applications/Android Studio 2.app/Contents/jbr/Contents/Home
```

## Notlar

- Kotlin derlemesi başarılı, sadece Java derlemesi başarısız
- Bu genellikle Android SDK platform dosyalarının bozuk olmasından kaynaklanır
- Android SDK'yı yeniden indirmek genellikle sorunu çözer

## Hata Devam Ederse

1. Android Studio'yu güncelleyin
2. Android SDK'yı tamamen yeniden yükleyin
3. Projeyi yeni bir dizinde oluşturup dosyaları kopyalayın

