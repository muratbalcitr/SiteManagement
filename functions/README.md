# Firebase Functions

Bu klasör Firebase Cloud Functions kodlarını içerir.

## Kurulum

```bash
npm install
```

## Local Development

Functions'ları local'de test etmek için:

```bash
npm run serve
```

## Deploy

Functions'ları Firebase'e deploy etmek için:

```bash
npm run deploy
```

Veya root dizinden:

```bash
firebase deploy --only functions
```

## Functions Listesi

- **createFee**: Yeni aidat oluşturur
- **createFeesForAllUnits**: Tüm daireler için aidat oluşturur
- **recordPayment**: Ödeme kaydı oluşturur
- **recordWaterMeterReading**: Su sayaç okuması kaydeder
- **sendPaymentReminders**: Günlük ödeme hatırlatmaları gönderir (scheduled)

## Detaylı Bilgi

Detaylı kurulum ve kullanım bilgileri için `FIREBASE_FUNCTIONS_SETUP.md` dosyasına bakın.

