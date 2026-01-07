# Firebase predeploy Seçenekleri

`firebase.json` dosyasındaki `predeploy` kısmı, Functions deploy edilmeden önce çalıştırılacak komutları belirler.

## Mevcut Ayar (Önerilen)

```json
{
  "functions": {
    "predeploy": [
      "npm --prefix \"$RESOURCE_DIR\" run lint"
    ],
    "source": "functions"
  }
}
```

Bu ayar deploy öncesi lint kontrolü yapar. Lint hataları varsa deploy durur.

## Alternatif Seçenekler

### 1. Lint'i Opsiyonel Yap (Hata Olsa Bile Devam Et)

```json
{
  "functions": {
    "predeploy": [
      "npm --prefix \"$RESOURCE_DIR\" run lint || true"
    ],
    "source": "functions"
  }
}
```

**Avantaj:** Lint hataları olsa bile deploy devam eder.
**Dezavantaj:** Kod kalitesi kontrolü atlanır.

### 2. Lint'i Kaldır (Hızlı Deploy)

```json
{
  "functions": {
    "predeploy": [],
    "source": "functions"
  }
}
```

veya

```json
{
  "functions": {
    "source": "functions"
  }
}
```

**Avantaj:** Daha hızlı deploy.
**Dezavantaj:** Kod kalitesi kontrolü yapılmaz.

### 3. Lint + Build Kontrolü

```json
{
  "functions": {
    "predeploy": [
      "npm --prefix \"$RESOURCE_DIR\" run lint",
      "npm --prefix \"$RESOURCE_DIR\" install"
    ],
    "source": "functions"
  }
}
```

**Avantaj:** Hem lint hem de bağımlılık kontrolü yapılır.

### 4. Sadece Kritik Hataları Kontrol Et

`functions/.eslintrc.js` dosyasında bazı kuralları uyarıya çevirebilirsiniz:

```javascript
rules: {
  "valid-jsdoc": "warn", // error yerine warn
  "comma-dangle": "warn",
  // ...
}
```

Sonra predeploy'da sadece error'ları kontrol edin:

```json
{
  "functions": {
    "predeploy": [
      "npm --prefix \"$RESOURCE_DIR\" run lint -- --max-warnings 0"
    ],
    "source": "functions"
  }
}
```

## Önerilen Yaklaşım

**Geliştirme aşamasında:**
```json
{
  "functions": {
    "predeploy": [
      "npm --prefix \"$RESOURCE_DIR\" run lint || true"
    ],
    "source": "functions"
  }
}
```

**Production'da:**
```json
{
  "functions": {
    "predeploy": [
      "npm --prefix \"$RESOURCE_DIR\" run lint"
    ],
    "source": "functions"
  }
}
```

## Lint Hatalarını Düzeltme

Tüm lint hatalarını otomatik düzeltmek için:

```bash
cd functions
npm run lint -- --fix
```

Manuel düzeltme için lint çıktısındaki hataları takip edin.

## Notlar

- `$RESOURCE_DIR` Firebase tarafından otomatik olarak `functions` klasörüne çevrilir
- Predeploy komutları sırayla çalıştırılır
- Bir komut başarısız olursa deploy durur (opsiyonel yapmadıysanız)
- Predeploy komutları root dizinden çalıştırılır


