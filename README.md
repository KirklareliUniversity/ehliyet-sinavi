# 🚗 Ehliyet Sınav Sistemi

Modern ve kapsamlı bir online ehliyet sınavı yönetim sistemi. Spring Boot, Spring Security, Thymeleaf ve MySQL teknolojileri ile geliştirilmiştir.

## ✨ Özellikler

### 👤 Kullanıcı Özellikleri
- ✅ Kullanıcı kayıt ve giriş sistemi
- ✅ 50 soruluk ehliyet sınavı
- ✅ **Görselli sorular** desteği
- ✅ **Videolu sorular** desteği
- ✅ Sınav süresi takibi
- ✅ Canlı ilerleme çubuğu
- ✅ Soru haritası (hangi sorular cevaplanmış gösterimi)
- ✅ Detaylı sınav sonuçları
- ✅ Geçmiş sınav kayıtları
- ✅ Profil yönetimi

### 👨‍💼 Admin Özellikleri
- ✅ Kullanıcı yönetimi (CRUD)
- ✅ Soru yönetimi (CRUD)
- ✅ **Görselli soru ekleme**
- ✅ **Videolu soru ekleme**
- ✅ Soru kategorileri (Trafik Kuralları, İşaretler, İlk Yardım, vb.)
- ✅ Sınav sonuçları izleme
- ✅ İstatistikler ve raporlar
- ✅ Dashboard paneli

## 🛠 Teknolojiler

- **Backend:** Spring Boot 3.2.0
- **Güvenlik:** Spring Security
- **Template Engine:** Thymeleaf
- **Database:** MySQL / H2 (Development)
- **ORM:** Spring Data JPA / Hibernate
- **Build Tool:** Maven
- **Java Version:** 17

## 📋 Gereksinimler

- Java 17 veya üstü
- Maven 3.6+
- MySQL 8.0+ (veya H2 development için)
- IDE (IntelliJ IDEA, Eclipse, VS Code önerilir)

## 🚀 Kurulum

### 1. Projeyi İndirin
```bash
git clone <repo-url>
cd ehliyet-sinavi-java
```

### 2. Database Ayarları

#### MySQL Kullanımı (Production)
`src/main/resources/application.properties` dosyasında MySQL ayarlarını yapılandırın:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ehliyet_sinav?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=yourpassword
```

#### H2 Kullanımı (Development)
H2 için ilgili satırların yorumunu kaldırın:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
```

### 3. Projeyi Derleyin ve Çalıştırın
```bash
mvn clean install
mvn spring-boot:run
```

### 4. Uygulamaya Erişin
```
http://localhost:8080
```

## 👥 Varsayılan Kullanıcılar

### Admin Hesabı
- **Kullanıcı Adı:** admin
- **Şifre:** admin123

### Test Kullanıcısı
- **Kullanıcı Adı:** user
- **Şifre:** user123

## 📂 Proje Yapısı

```
src/
├── main/
│   ├── java/com/ehliyet/sinav/
│   │   ├── config/           # Konfigürasyon dosyaları
│   │   │   ├── SecurityConfig.java
│   │   │   └── DataInitializer.java
│   │   ├── controller/       # Controller sınıfları
│   │   │   ├── MainController.java
│   │   │   ├── AdminController.java
│   │   │   ├── UserController.java
│   │   │   └── ExamController.java
│   │   ├── entity/           # Entity sınıfları
│   │   │   ├── User.java
│   │   │   ├── Question.java
│   │   │   └── ExamResult.java
│   │   ├── repository/       # Repository arayüzleri
│   │   │   ├── UserRepository.java
│   │   │   ├── QuestionRepository.java
│   │   │   └── ExamResultRepository.java
│   │   ├── service/          # Service sınıfları
│   │   │   ├── UserService.java
│   │   │   ├── QuestionService.java
│   │   │   └── ExamService.java
│   │   └── EhliyetSinavApplication.java
│   └── resources/
│       ├── templates/        # Thymeleaf HTML şablonları
│       │   ├── login.html
│       │   ├── register.html
│       │   ├── admin/        # Admin sayfaları
│       │   ├── user/         # Kullanıcı sayfaları
│       │   └── exam/         # Sınav sayfaları
│       ├── static/
│       │   ├── css/
│       │   ├── js/
│       │   ├── images/
│       │   └── videos/
│       └── application.properties
```

## 📸 Görselli ve Videolu Soru Ekleme

### Admin Panelinden Soru Ekleme
1. Admin hesabı ile giriş yapın
2. "Sorular" menüsüne gidin
3. "Yeni Soru Ekle" butonuna tıklayın
4. Soru bilgilerini doldurun
5. **Görsel veya Video eklemek için:**
   - "Medya Dosyası" alanından dosya seçin
   - Desteklenen formatlar:
     - **Görsel:** JPG, PNG, GIF, WEBP
     - **Video:** MP4, WEBM, OGG
6. Kaydet butonuna tıklayın

### Dosya Upload Limitleri
- Maksimum dosya boyutu: 50MB
- Dosyalar `uploads/` klasörüne kaydedilir

## 🎯 Sınav Kuralları

- **Toplam Soru:** 50
- **Her Soru:** 2 puan
- **Geçme Notu:** 70 puan (35 doğru)
- **Toplam Puan:** 100
- Cevap değiştirme yapılabilir
- Soru haritasından dilediğiniz soruya geçebilirsiniz
- Süre sınırı yoktur (opsiyonel olarak eklenebilir)

## 🔐 Güvenlik

- Spring Security ile güvenli authentication
- BCrypt ile şifreleme
- CSRF koruması
- Role-based authorization (ADMIN, USER)
- Session yönetimi

## 📊 Sınav Kategorileri

1. **Trafik Kuralları** - Temel trafik kuralları
2. **Trafik İşaretleri** - Yol işaretleri ve anlamları
3. **İlk Yardım** - Kaza sonrası ilk yardım bilgileri
4. **Motor ve Araç Tekniği** - Araç bakımı ve teknik bilgiler
5. **Çevresel Konular** - Çevre ve güvenlik

## 🎨 Özelleştirme

### Sınav Soru Sayısını Değiştirme
`ExamController.java` dosyasında:
```java
List<Question> questions = examService.generateExamQuestions(50); // 50'yi değiştirin
```

### Geçme Notunu Değiştirme
`ExamResult.java` dosyasında:
```java
this.passed = score >= 70; // 70'i değiştirin
```

### Tema Renkleri
CSS dosyalarında gradient ve renk kodlarını değiştirebilirsiniz.

## 📝 Geliştirme Notları

- Proje Spring Boot best practices'e uygun olarak geliştirilmiştir
- Lombok kullanılarak boilerplate kod azaltılmıştır
- Repository pattern kullanılmıştır
- Service layer ile business logic ayrılmıştır
- Thymeleaf ile server-side rendering yapılmıştır

## 🐛 Hata Ayıklama

### Port 8080 Kullanımda
`application.properties` dosyasında portu değiştirin:
```properties
server.port=8081
```

### Database Bağlantı Hatası
- MySQL servisinin çalıştığından emin olun
- Database kullanıcı adı ve şifresini kontrol edin
- Database'in oluşturulduğunu kontrol edin

### Upload Klasörü Hatası
Proje root dizininde `uploads/` klasörü otomatik oluşturulacaktır.

## 📞 Destek

Sorularınız için issue açabilirsiniz.

## 📄 Lisans

Bu proje eğitim amaçlı geliştirilmiştir.

---

**Geliştirici:** Claude AI  
**Versiyon:** 1.0.0  
**Tarih:** 2025
