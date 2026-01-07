# KAPT'den KSP'ye Geçiş

## Yapılan Değişiklikler

KAPT (Kotlin Annotation Processing Tool) yerine KSP (Kotlin Symbol Processing) kullanılmaya başlandı.

### Neden KSP?

1. **Java 22 Uyumluluğu**: KAPT Java 22 ile uyumsuz, KSP uyumlu
2. **Daha Hızlı**: KSP KAPT'den 2x daha hızlı
3. **Modern**: Kotlin-native çözüm
4. **Daha Az Bellek**: Daha verimli bellek kullanımı

### Değişiklikler

#### 1. build.gradle (Project Level)

```gradle
plugins {
    // ...
    id 'com.google.devtools.ksp' version '1.9.20-1.0.14' apply false
}
```

#### 2. app/build.gradle

**Önceki (KAPT):**
```gradle
plugins {
    id 'kotlin-kapt'
}

dependencies {
    kapt 'androidx.room:room-compiler:2.6.1'
    kapt 'com.google.dagger:hilt-android-compiler:2.48'
}
```

**Yeni (KSP):**
```gradle
plugins {
    id 'com.google.devtools.ksp'
}

dependencies {
    ksp 'androidx.room:room-compiler:2.6.1'
    ksp 'com.google.dagger:hilt-android-compiler:2.48'
}
```

#### 3. gradle.properties

KAPT ayarları kaldırıldı (artık gerekli değil).

## Sonraki Adımlar

1. **Gradle Sync**: Android Studio'da Gradle sync yapın
2. **Clean Build**: Build > Clean Project
3. **Rebuild**: Build > Rebuild Project

## Notlar

- KSP, KAPT ile aynı annotation processor'ları destekler
- Room ve Hilt KSP ile tam uyumludur
- Kod değişikliği gerekmez, sadece build yapılandırması değişti

## Sorun Giderme

### Build hatası alırsanız:

1. File > Invalidate Caches / Restart
2. Gradle sync yapın
3. Clean build yapın

### KSP versiyonu uyumsuzsa:

`build.gradle` dosyasında KSP versiyonunu güncelleyin:
```gradle
id 'com.google.devtools.ksp' version '1.9.20-1.0.14'
```

Kotlin versiyonunuzla uyumlu KSP versiyonunu seçin:
- Kotlin 1.9.20 → KSP 1.9.20-1.0.14
- Kotlin 1.9.22 → KSP 1.9.22-1.0.16

Versiyon uyumluluğu için: https://github.com/google/ksp/releases



