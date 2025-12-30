# KAPT Java 17+ Uyumluluk Sorunu Çözümü

## Sorun

Java 22 kullanıldığında KAPT (Kotlin Annotation Processing Tool) şu hatayı veriyor:

```
IllegalAccessError: superclass access check failed: class org.jetbrains.kotlin.kapt3.base.javac.KaptJavaCompiler 
cannot access class com.sun.tools.javac.main.JavaCompiler
```

## Çözüm

### 1. Java Versiyonunu 17'ye Düşürün

Android Studio'da:
1. File > Project Structure > SDK Location
2. JDK location'ı Java 17'ye ayarlayın
3. Veya Android Studio > Preferences > Build, Execution, Deployment > Build Tools > Gradle
4. Gradle JDK'yı Java 17 olarak seçin

### 2. Gradle.properties Ayarları

`gradle.properties` dosyasına şu ayarlar eklendi:

```properties
# KAPT configuration for Java 17+ compatibility
kapt.use.worker.api=true
kapt.incremental.apt=true
kapt.include.compile.classpath=false
```

### 3. Build.gradle Ayarları

`app/build.gradle` dosyasında Java 17 kullanılacak şekilde ayarlandı:

```gradle
compileOptions {
    sourceCompatibility JavaVersion.VERSION_17
    targetCompatibility JavaVersion.VERSION_17
}

kotlinOptions {
    jvmTarget = '17'
}
```

## Alternatif Çözüm: KSP'ye Geçiş

KAPT yerine KSP (Kotlin Symbol Processing) kullanabilirsiniz. KSP daha hızlı ve modern bir alternatiftir.

### KSP'ye Geçiş Adımları

1. `app/build.gradle` dosyasında:

```gradle
plugins {
    // kapt yerine ksp ekleyin
    id 'com.google.devtools.ksp' version '1.9.20-1.0.14'
    // id 'kotlin-kapt' // Bu satırı kaldırın
}

dependencies {
    // Room için
    ksp 'androidx.room:room-compiler:2.6.1'
    // kapt 'androidx.room:room-compiler:2.6.1' // Bu satırı kaldırın
    
    // Hilt için
    ksp 'com.google.dagger:hilt-android-compiler:2.48'
    // kapt 'com.google.dagger:hilt-android-compiler:2.48' // Bu satırı kaldırın
}
```

## Kontrol

1. Android Studio'yu yeniden başlatın
2. File > Invalidate Caches / Restart
3. Gradle sync yapın
4. Clean build yapın: Build > Clean Project
5. Rebuild yapın: Build > Rebuild Project

## Notlar

- Java 17 Android geliştirme için önerilen versiyondur
- Java 22 henüz tam desteklenmiyor
- KAPT Java 17 ile çalışır, ancak KSP daha iyi performans sağlar

