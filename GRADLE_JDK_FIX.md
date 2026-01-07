# Gradle JDK Hatası Çözümü

## Sorun

```
Error while executing process /Applications/Android Studio 2.app/Contents/jbr/Contents/Home/bin/jlink
```

Bu hata Android Studio'nun JDK'sı ile ilgili bir sorundur.

## Çözüm Adımları

### 1. Gradle Cache'i Temizle

Terminal'de şu komutları çalıştırın:

```bash
cd /Users/muratbalci/AndroidStudioProjects/kucukyali-site-yonetimi

# Gradle cache'i temizle
rm -rf ~/.gradle/caches/transforms-3

# Gradle daemon'ı durdur
./gradlew --stop
```

### 2. Android Studio'da JDK Ayarları

1. **File > Settings** (veya **Preferences** on macOS)
2. **Build, Execution, Deployment > Build Tools > Gradle**
3. **Gradle JDK** bölümünde:
   - **Embedded JDK** seçin (Android Studio'nun kendi JDK'sı)
   - Veya **Download JDK** ile Java 17 indirin
   - **JDK location** olarak Java 17'yi seçin

### 3. Android Studio'yu Yeniden Başlat

1. **File > Invalidate Caches / Restart**
2. **Invalidate and Restart** seçin

### 4. Projeyi Temizle

Android Studio'da:
1. **Build > Clean Project**
2. **Build > Rebuild Project**

### 5. Gradle Wrapper'ı Güncelle (Gerekirse)

Eğer hala sorun varsa:

```bash
cd /Users/muratbalci/AndroidStudioProjects/kucukyali-site-yonetimi
./gradlew wrapper --gradle-version=8.2
```

## Alternatif Çözüm: JDK'yı Manuel Ayarla

`gradle.properties` dosyasına ekleyin:

```properties
org.gradle.java.home=/Applications/Android Studio 2.app/Contents/jbr/Contents/Home
```

Veya Java 17 kullanıyorsanız:

```properties
org.gradle.java.home=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home
```

## Notlar

- Android Studio 2 kullanıyorsunuz, bu eski bir versiyon olabilir
- JDK 17 veya 21 kullanmanız önerilir
- Gradle 8.2 Java 17+ gerektirir


