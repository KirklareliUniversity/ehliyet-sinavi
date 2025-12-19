-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 17 Ara 2025, 10:33:45
-- Sunucu sürümü: 10.4.32-MariaDB
-- PHP Sürümü: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `ehliyet_sinav`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `exam_answers`
--

CREATE TABLE `exam_answers` (
  `exam_result_id` bigint(20) NOT NULL,
  `correct_answer` varchar(255) DEFAULT NULL,
  `is_correct` bit(1) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  `user_answer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `exam_answers`
--

INSERT INTO `exam_answers` (`exam_result_id`, `correct_answer`, `is_correct`, `question_id`, `user_answer`) VALUES
(1, 'B', b'0', 29, 'A'),
(1, 'B', b'0', 27, 'D'),
(1, 'B', b'0', 32, 'C'),
(1, 'B', b'0', 36, 'A'),
(1, 'B', b'0', 44, 'D'),
(1, 'B', b'0', 8, 'A'),
(1, 'B', b'1', 48, 'B'),
(1, 'B', b'0', 28, 'D'),
(1, 'B', b'0', 46, 'D'),
(1, 'C', b'0', 3, 'D'),
(1, 'B', b'0', 20, 'D'),
(1, 'B', b'0', 10, 'D'),
(1, 'B', b'0', 14, 'D'),
(1, 'B', b'0', 38, 'D'),
(1, 'B', b'0', 13, 'D'),
(1, 'B', b'0', 16, 'D'),
(1, 'B', b'0', 30, 'D'),
(1, 'B', b'0', 34, 'D'),
(1, 'C', b'0', 5, 'D'),
(1, 'B', b'0', 12, 'D'),
(1, 'B', b'0', 22, 'D'),
(1, 'B', b'0', 6, 'D'),
(1, 'B', b'0', 7, 'D'),
(1, 'B', b'0', 1, 'D'),
(1, 'B', b'0', 18, 'D'),
(1, 'B', b'0', 11, 'D'),
(1, 'B', b'0', 50, 'D'),
(1, 'B', b'0', 15, 'D'),
(1, 'B', b'0', 33, 'D'),
(1, 'B', b'0', 45, 'D'),
(1, 'B', b'0', 17, 'D'),
(1, 'B', b'0', 40, 'D'),
(1, 'C', b'0', 2, 'D'),
(1, 'B', b'0', 19, 'D'),
(1, 'B', b'0', 49, 'D'),
(1, 'B', b'0', 41, 'D'),
(1, 'B', b'0', 31, 'D'),
(1, 'B', b'0', 4, 'D'),
(1, 'B', b'0', 21, 'D'),
(1, 'B', b'0', 35, 'D'),
(1, 'B', b'0', 23, 'C'),
(1, 'B', b'0', 42, 'D'),
(1, 'B', b'0', 24, 'C'),
(1, 'B', b'0', 37, 'D'),
(1, 'B', b'0', 9, 'D'),
(1, 'B', b'0', 25, 'D'),
(1, 'B', b'0', 43, 'D'),
(1, 'B', b'0', 39, 'D'),
(1, 'B', b'0', 47, 'D'),
(1, 'B', b'0', 26, 'D'),
(2, 'A', b'1', 46, 'A'),
(2, 'D', b'0', 29, 'A'),
(2, 'C', b'1', 48, 'C'),
(2, 'A', b'1', 49, 'A'),
(2, 'C', b'1', 45, 'C'),
(2, 'A', b'0', 42, 'B'),
(2, 'D', b'0', 35, 'A'),
(2, 'D', b'1', 44, 'D'),
(2, 'D', b'1', 15, 'D'),
(2, 'B', b'1', 7, 'B'),
(2, 'B', b'0', 37, 'A'),
(2, 'C', b'1', 6, 'C'),
(2, 'A', b'1', 21, 'A'),
(2, 'D', b'1', 50, 'D'),
(2, 'A', b'1', 31, 'A'),
(2, 'B', b'1', 43, 'B'),
(2, 'B', b'1', 34, 'B'),
(2, 'A', b'1', 9, 'A'),
(2, 'B', b'0', 3, 'D'),
(2, 'B', b'1', 11, 'B'),
(2, 'B', b'1', 8, 'B'),
(2, 'D', b'1', 40, 'D'),
(2, 'D', b'0', 19, 'B'),
(2, 'B', b'1', 13, 'B'),
(2, 'C', b'0', 38, 'B'),
(2, 'B', b'1', 27, 'B'),
(2, 'C', b'1', 41, 'C'),
(2, 'A', b'0', 17, 'B'),
(2, 'A', b'1', 28, 'A'),
(2, 'B', b'1', 14, 'B'),
(2, 'B', b'1', 20, 'B'),
(2, 'A', b'1', 39, 'A'),
(2, 'C', b'1', 18, 'C'),
(2, 'C', b'1', 26, 'C'),
(2, 'C', b'0', 16, 'A'),
(2, 'D', b'0', 10, 'B'),
(2, 'A', b'0', 5, 'B'),
(2, 'B', b'1', 2, 'B'),
(2, 'D', b'0', 4, 'A'),
(2, 'C', b'1', 1, 'C'),
(2, 'B', b'1', 33, 'B'),
(2, 'B', b'1', 47, 'B'),
(2, 'A', b'0', 25, 'D'),
(2, 'C', b'1', 30, 'C'),
(2, 'C', b'1', 12, 'C'),
(2, 'D', b'0', 24, 'C'),
(2, 'B', b'1', 32, 'B'),
(2, 'A', b'1', 36, 'A'),
(2, 'B', b'1', 23, 'B'),
(2, 'C', b'1', 22, 'C'),
(3, 'D', b'1', 19, 'D'),
(3, 'D', b'1', 44, 'D'),
(3, 'C', b'1', 38, 'C'),
(3, 'A', b'1', 39, 'A'),
(3, 'C', b'1', 6, 'C'),
(3, 'B', b'1', 7, 'B'),
(3, 'B', b'1', 37, 'B'),
(3, 'A', b'1', 36, 'A'),
(3, 'B', b'1', 2, 'B'),
(3, 'B', b'0', 3, 'D'),
(3, 'D', b'0', 40, 'A'),
(3, 'B', b'0', 8, 'A'),
(3, 'C', b'1', 22, 'C'),
(3, 'D', b'1', 24, 'D'),
(3, 'A', b'1', 21, 'A'),
(3, 'D', b'0', 4, 'C'),
(3, 'B', b'1', 43, 'B'),
(3, 'A', b'0', 17, 'B'),
(3, 'B', b'1', 20, 'B'),
(3, 'D', b'0', 10, 'C'),
(3, 'B', b'1', 23, 'B'),
(3, 'A', b'0', 49, 'B'),
(3, 'C', b'1', 48, 'C'),
(3, 'A', b'1', 46, 'A'),
(3, 'C', b'1', 41, 'C'),
(3, 'C', b'0', 16, 'A'),
(3, 'B', b'0', 32, 'A'),
(3, 'C', b'1', 1, 'C'),
(3, 'C', b'1', 45, 'C'),
(3, 'B', b'1', 47, 'B'),
(3, 'A', b'1', 31, 'A'),
(3, 'A', b'1', 9, 'A'),
(3, 'D', b'1', 15, 'D'),
(3, 'D', b'1', 50, 'D'),
(3, 'B', b'1', 33, 'B'),
(3, 'A', b'0', 42, 'B'),
(3, 'B', b'1', 27, 'B'),
(3, 'A', b'0', 5, 'D'),
(3, 'D', b'0', 29, 'A'),
(3, 'C', b'0', 30, 'B'),
(3, 'D', b'0', 35, 'B'),
(3, 'C', b'1', 26, 'C'),
(3, 'A', b'0', 25, 'B'),
(3, 'B', b'1', 14, 'B'),
(3, 'C', b'1', 18, 'C'),
(3, 'B', b'1', 34, 'B'),
(3, 'B', b'1', 13, 'B'),
(3, 'A', b'0', 28, 'C'),
(3, 'C', b'1', 12, 'C'),
(3, 'B', b'1', 11, 'B');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `exam_results`
--

CREATE TABLE `exam_results` (
  `id` bigint(20) NOT NULL,
  `correct_answers` int(11) NOT NULL,
  `duration_in_seconds` int(11) NOT NULL,
  `exam_date` datetime(6) DEFAULT NULL,
  `passed` bit(1) NOT NULL,
  `score` int(11) NOT NULL,
  `total_questions` int(11) NOT NULL,
  `wrong_answers` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `exam_results`
--

INSERT INTO `exam_results` (`id`, `correct_answers`, `duration_in_seconds`, `exam_date`, `passed`, `score`, `total_questions`, `wrong_answers`, `user_id`) VALUES
(1, 1, 79, '2025-12-16 21:47:57.000000', b'0', 2, 50, 49, 2),
(2, 36, 402, '2025-12-16 22:28:40.000000', b'1', 72, 50, 14, 2),
(3, 34, 356, '2025-12-16 22:40:15.000000', b'0', 68, 50, 16, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `questions`
--

CREATE TABLE `questions` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `category` enum('TRAFIK_KURALLARI','TRAFIK_ISARETLERI','ILK_YARDIM','MOTOR_VE_ARAC_TEKNIK','CEVRESEL_KONULAR') NOT NULL,
  `correct_answer` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `difficulty` int(11) NOT NULL,
  `explanation` varchar(1000) DEFAULT NULL,
  `media_path` varchar(500) DEFAULT NULL,
  `media_type` varchar(100) DEFAULT NULL,
  `optiona` varchar(500) NOT NULL,
  `optionb` varchar(500) NOT NULL,
  `optionc` varchar(500) NOT NULL,
  `optiond` varchar(500) NOT NULL,
  `question_text` varchar(1000) NOT NULL,
  `type` enum('TEXT','IMAGE','VIDEO') NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `questions`
--

INSERT INTO `questions` (`id`, `active`, `category`, `correct_answer`, `created_at`, `difficulty`, `explanation`, `media_path`, `media_type`, `optiona`, `optionb`, `optionc`, `optiond`, `question_text`, `type`, `updated_at`) VALUES
(1, b'1', 'TRAFIK_KURALLARI', 'C', '2025-12-16 22:21:18.000000', 2, 'Alkollü araç kullanma sınırı 0.50 promildir. Bu sınırın üzerinde araç kullanmak yasaktır.', NULL, NULL, '0.20 promil', '0.30 promil', '0.50 promil', '0.80 promil', 'Türkiye\'de sürücüler için izin verilen maksimum alkol sınırı kaç promildir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(2, b'1', 'TRAFIK_KURALLARI', 'B', '2025-12-16 22:21:18.000000', 1, 'Şehir içinde azami hız sınırı 50 km/s\'dir.', NULL, NULL, '30 km/s', '50 km/s', '70 km/s', '90 km/s', 'Şehir içinde binek otomobiller için azami hız sınırı kaç km/s\'dir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(3, b'1', 'TRAFIK_KURALLARI', 'B', '2025-12-16 22:21:18.000000', 1, 'Şehirlerarası yollarda azami hız sınırı 90 km/s\'dir.', NULL, NULL, '70 km/s', '90 km/s', '110 km/s', '120 km/s', 'Şehirlerarası yollarda binek otomobiller için azami hız sınırı kaç km/s\'dir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(4, b'1', 'TRAFIK_KURALLARI', 'D', '2025-12-16 22:21:18.000000', 2, 'Otoyollarda azami hız sınırı 120 km/s\'dir.', NULL, NULL, '90 km/s', '100 km/s', '110 km/s', '120 km/s', 'Otoyollarda binek otomobiller için azami hız sınırı kaç km/s\'dir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(5, b'1', 'TRAFIK_KURALLARI', 'A', '2025-12-16 22:21:18.000000', 2, 'Takip mesafesi, öndeki aracın geçtiği noktayı en az 2 saniye sonra geçecek şekilde ayarlanmalıdır.', NULL, NULL, '2 saniye kuralı', '5 saniye kuralı', '10 metre kuralı', '20 metre kuralı', 'Güvenli takip mesafesi için hangi kural uygulanmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(6, b'1', 'TRAFIK_KURALLARI', 'C', '2025-12-16 22:21:18.000000', 1, 'Yaya geçitlerinde yayalara her zaman yol verilmelidir.', NULL, NULL, 'Korna çalarak uyarmalıdır', 'Hızını artırarak geçmelidir', 'Durarak yayaların geçmesini beklemelidir', 'Işıklı uyarı vererek geçmelidir', 'Yaya geçidine yaklaşan sürücü ne yapmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(7, b'1', 'TRAFIK_KURALLARI', 'B', '2025-12-16 22:21:18.000000', 2, 'Dönel kavşaklarda içerideki araçların geçiş önceliği vardır.', NULL, NULL, 'Dışarıdan gelen araç', 'İçerideki araç', 'Büyük araç', 'İlk gelen araç', 'Dönel kavşaklarda (göbek) geçiş önceliği kimdedir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(8, b'1', 'TRAFIK_KURALLARI', 'B', '2025-12-16 22:21:18.000000', 1, 'Kavşaklarda işaret veya ışık yoksa sağdan gelen aracın geçiş önceliği vardır.', NULL, NULL, 'Soldan gelen araçta', 'Sağdan gelen araçta', 'İlk gelen araçta', 'Büyük araçta', 'İşaretsiz kavşaklarda öncelik hakkı kimdedir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(9, b'1', 'TRAFIK_KURALLARI', 'A', '2025-12-16 22:21:18.000000', 1, 'Emniyet kemeri takmak hem sürücü hem de tüm yolcular için zorunludur.', NULL, NULL, 'Tüm yolcular ve sürücü', 'Sadece sürücü', 'Sadece ön koltukta oturanlar', 'Sadece arka koltukta oturanlar', 'Emniyet kemeri takma zorunluluğu kimler için geçerlidir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(10, b'1', 'TRAFIK_KURALLARI', 'D', '2025-12-16 22:21:18.000000', 2, 'Çocuk koltuğu 150 cm altındaki veya 36 kg altındaki çocuklar için zorunludur.', NULL, NULL, '100 cm ve 20 kg', '120 cm ve 25 kg', '135 cm ve 30 kg', '150 cm ve 36 kg', 'Araçlarda çocuk güvenlik koltuğu kullanımı hangi boy ve kilo sınırına kadar zorunludur?', 'TEXT', '2025-12-16 22:21:18.000000'),
(11, b'1', 'TRAFIK_KURALLARI', 'B', '2025-12-16 22:21:18.000000', 2, 'Sollama yaparken sol şeride geçilmeli, sollama tamamlandıktan sonra sağ şeride dönülmelidir.', NULL, NULL, 'Sağ taraftan', 'Sol taraftan', 'Her iki taraftan', 'Duruma göre değişir', 'Trafikte sollama hangi taraftan yapılmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(12, b'1', 'TRAFIK_KURALLARI', 'C', '2025-12-16 22:21:18.000000', 2, 'Yokuş aşağı giden araç, yokuş yukarı çıkan araca yol vermelidir.', NULL, NULL, 'Yokuş yukarı çıkan araç', 'Büyük araç', 'Yokuş aşağı inen araç', 'İlk gelen araç', 'Dar yolda karşılaşan iki araçtan hangisi yol vermelidir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(13, b'1', 'TRAFIK_KURALLARI', 'B', '2025-12-16 22:21:18.000000', 1, 'Kırmızı ışıkta araç durmalı ve yeşil ışığı beklemelidir.', NULL, NULL, 'Hızla geçmelidir', 'Durmalı ve yeşil ışığı beklemelidir', 'Yavaşça geçebilir', 'Korna çalarak geçmelidir', 'Kırmızı ışıkta araç ne yapmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(14, b'1', 'TRAFIK_KURALLARI', 'B', '2025-12-16 22:21:18.000000', 2, 'Tünel içinde sollama yapmak tehlikeli ve yasaktır.', NULL, NULL, 'Serbesttir', 'Yasaktır', 'Sadece kısa tünellerde serbesttir', 'Gündüz serbesttir', 'Tünel içinde sollama yapmak hangi durumda serbesttir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(15, b'1', 'TRAFIK_KURALLARI', 'D', '2025-12-16 22:21:18.000000', 1, 'Kırmızı ışıkta sağa dönüş ancak yeşil ok işareti varsa yapılabilir.', NULL, NULL, 'Her zaman serbesttir', 'Hiçbir zaman yapılamaz', 'Yaya yoksa yapılabilir', 'Sadece yeşil ok işareti varsa yapılabilir', 'Kırmızı ışıkta sağa dönüş ne zaman yapılabilir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(16, b'1', 'TRAFIK_KURALLARI', 'C', '2025-12-16 22:21:18.000000', 2, 'Işıklı kavşakta yeşil ışık yanınca, kavşağı temizlemek için bekleyen araçlara yol verilmelidir.', NULL, NULL, 'Hemen hareket etmeli', 'Korna çalmalı', 'Kavşağı temizleyen araçları beklemeli', 'Hızla kavşağa girmeli', 'Işıklı kavşakta yeşil ışık yandığında sürücü ne yapmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(17, b'1', 'TRAFIK_KURALLARI', 'A', '2025-12-16 22:21:18.000000', 2, 'Demiryolu geçitlerinde mutlaka durulmalı ve tren kontrolü yapılmalıdır.', NULL, NULL, 'Durup kontrol etmeli', 'Yavaşlayarak geçmeli', 'Hızlıca geçmeli', 'Korna çalarak geçmeli', 'Hemzemin geçide yaklaşan sürücü ne yapmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(18, b'1', 'TRAFIK_KURALLARI', 'C', '2025-12-16 22:21:18.000000', 1, 'Okul servisleri durduğunda, tüm araçlar durarak çocukların geçişini beklemelidir.', NULL, NULL, 'Hızını azaltmadan devam etmeli', 'Korna çalmalı', 'Durmalı ve öğrencilerin geçmesini beklemeli', 'Hızla sollayarak geçmeli', 'Okul servis araçları durduğunda ne yapılmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(19, b'1', 'TRAFIK_KURALLARI', 'D', '2025-12-16 22:21:18.000000', 2, 'Yağmurlu havada fren mesafesi kuru yola göre 2 kat artar.', NULL, NULL, 'Değişmez', '1.5 kat', '1.2 kat', '2 kat', 'Yağmurlu havada fren mesafesi kuru havaya göre ne kadar artar?', 'TEXT', '2025-12-16 22:21:18.000000'),
(20, b'1', 'TRAFIK_KURALLARI', 'B', '2025-12-16 22:21:18.000000', 1, 'Araç kullanırken cep telefonu ile konuşmak yasaktır.', NULL, NULL, 'Serbesttir', 'Yasaktır', 'Sadece şehir dışında yasaktır', 'Sadece otoyolda yasaktır', 'Araç kullanırken elle cep telefonu kullanmak hangi durumda serbesttir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(21, b'1', 'TRAFIK_ISARETLERI', 'A', '2025-12-16 22:21:18.000000', 1, 'Sekizgen kırmızı işaret DUR işaretidir ve mutlaka durulması gerektiğini belirtir.', NULL, NULL, 'Dur işareti', 'Yol ver işareti', 'Tehlike işareti', 'Park yasağı işareti', 'Sekizgen şeklindeki kırmızı trafik işareti neyi ifade eder?', 'TEXT', '2025-12-16 22:21:18.000000'),
(22, b'1', 'TRAFIK_ISARETLERI', 'C', '2025-12-16 22:21:18.000000', 2, 'Mavi zemin üzerinde beyaz ok, zorunlu yön işaretidir.', NULL, NULL, 'Yasak yön', 'Tehlike', 'Zorunlu yön', 'Tavsiye edilen yön', 'Mavi zemin üzerinde beyaz ok işareti neyi belirtir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(23, b'1', 'TRAFIK_ISARETLERI', 'B', '2025-12-16 22:21:18.000000', 1, 'Üçgen şeklinde kırmızı kenarlı işaretler tehlike uyarı işaretleridir.', NULL, NULL, 'Yasaklama', 'Tehlike uyarısı', 'Bilgi', 'Yön', 'Üçgen şeklindeki kırmızı kenarlı işaretler neyi ifade eder?', 'TEXT', '2025-12-16 22:21:18.000000'),
(24, b'1', 'TRAFIK_ISARETLERI', 'D', '2025-12-16 22:21:18.000000', 2, 'Yuvarlak mavi işaretler zorunluluk işaretleridir.', NULL, NULL, 'Yasaklama işareti', 'Tehlike işareti', 'Bilgi işareti', 'Zorunluluk işareti', 'Yuvarlak mavi zemin üzerindeki beyaz semboller hangi tür işarettir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(25, b'1', 'TRAFIK_ISARETLERI', 'A', '2025-12-16 22:21:18.000000', 2, 'Kırmızı daire içinde çarpı işareti duraklamanın yasak olduğunu gösterir.', NULL, NULL, 'Duraklamak yasaktır', 'Park etmek yasaktır', 'Sollama yasaktır', 'Giriş yasaktır', 'Kırmızı daire içindeki kırmızı çarpı (X) işareti ne anlama gelir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(26, b'1', 'TRAFIK_ISARETLERI', 'C', '2025-12-16 22:21:18.000000', 1, 'Kesik beyaz çizgi şerit değiştirmeye izin verildiğini gösterir.', NULL, NULL, 'Geçiş yasaktır', 'Sollama yasaktır', 'Şerit değiştirilebilir', 'Park edilebilir', 'Yol üzerindeki kesik beyaz çizgi ne anlama gelir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(27, b'1', 'TRAFIK_ISARETLERI', 'B', '2025-12-16 22:21:18.000000', 2, 'Sarı sürekli çizgi sollama ve geçişin yasak olduğunu gösterir.', NULL, NULL, 'Şerit değiştirilebilir', 'Sollama yasaktır', 'Park edilebilir', 'Hız sınırı var', 'Yol üzerindeki sarı sürekli çizgi ne anlama gelir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(28, b'1', 'TRAFIK_ISARETLERI', 'A', '2025-12-16 22:21:18.000000', 2, 'Kırmızı daire içinde 50 yazısı, azami hız sınırının 50 km/s olduğunu gösterir.', NULL, NULL, 'Azami hız sınırı', 'Asgari hız sınırı', 'Tavsiye edilen hız', 'Mesafe', 'Kırmızı daire içindeki rakam neyi ifade eder?', 'TEXT', '2025-12-16 22:21:18.000000'),
(29, b'1', 'TRAFIK_ISARETLERI', 'D', '2025-12-16 22:21:18.000000', 1, 'Yeşil zemin üzerinde beyaz H harfi hastane işaretidir.', NULL, NULL, 'Heliport', 'Havaalanı', 'Otel', 'Hastane', 'Yeşil zemin üzerinde beyaz H harfi neyi ifade eder?', 'TEXT', '2025-12-16 22:21:18.000000'),
(30, b'1', 'TRAFIK_ISARETLERI', 'C', '2025-12-16 22:21:18.000000', 2, 'Ters üçgen işareti yol ver işaretidir.', NULL, NULL, 'Dur', 'Ana yol', 'Yol ver', 'Tehlike', 'Ters üçgen şeklindeki trafik işareti ne anlama gelir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(31, b'1', 'ILK_YARDIM', 'A', '2025-12-16 22:21:18.000000', 1, '112 Türkiye\'nin genel acil yardım numarasıdır.', NULL, NULL, '112', '155', '110', '156', 'Türkiye\'de acil yardım numarası kaçtır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(32, b'1', 'ILK_YARDIM', 'B', '2025-12-16 22:21:18.000000', 2, 'İlk yardımda ABC kuralı: Airway (Hava yolu), Breathing (Solunum), Circulation (Dolaşım) anlamına gelir.', NULL, NULL, 'Ambulans-Bandaj-Cenaze', 'Hava yolu-Solunum-Dolaşım', 'Alarm-Bekleme-Cevap', 'Anestezi-Bağlama-Cerrahi', 'İlk yardımda ABC kuralı ne anlama gelir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(33, b'1', 'ILK_YARDIM', 'B', '2025-12-16 22:21:18.000000', 2, 'Bilinç kontrolü için omuzlara hafifçe dokunulup seslenilir.', NULL, NULL, 'Soğuk su dökmek', 'Omuzlara hafifçe dokunup seslenmek', 'Şiddetli sarsmak', 'Tokat atmak', 'Yaralının bilinci nasıl kontrol edilir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(34, b'1', 'ILK_YARDIM', 'B', '2025-12-16 22:21:18.000000', 2, 'Kanamalarda baskı uygulayarak kanamayı durdurmaya çalışılmalıdır.', NULL, NULL, 'Buz uygulamak', 'Baskı ile kanamayı durdurmaya çalışmak', 'Yaralıyı koşturmak', 'Hiçbir şey yapmamak', 'Kan kaybı durumunda ilk yapılması gereken nedir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(35, b'1', 'ILK_YARDIM', 'D', '2025-12-16 22:21:18.000000', 2, 'Yanıklarda en az 10-20 dakika soğuk su tutulmalıdır.', NULL, NULL, '1-2 dakika', '3-5 dakika', '5-10 dakika', '10-20 dakika', 'Yanık durumunda yaralı bölge soğuk su altında en az ne kadar tutulmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(36, b'1', 'ILK_YARDIM', 'A', '2025-12-16 22:21:18.000000', 1, 'Bilinci kapalı ancak nefes alan yaralı koma pozisyonuna (yan yatış) alınmalıdır.', NULL, NULL, 'Koma pozisyonu (yan yatış)', 'Sırt üstü yatırılmalı', 'Oturtulmalı', 'Ayakta tutulmalı', 'Bilinci kapalı ancak nefes alan yaralı hangi pozisyona alınmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(37, b'1', 'ILK_YARDIM', 'B', '2025-12-16 22:21:18.000000', 2, 'Yetişkinlerde kalp masajı dakikada 100-120 baskı hızında yapılmalıdır.', NULL, NULL, '60-80', '100-120', '140-160', '180-200', 'Yetişkinlerde kalp masajı dakikada kaç baskı hızında yapılmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(38, b'1', 'ILK_YARDIM', 'C', '2025-12-16 22:21:18.000000', 2, 'Şok pozisyonunda bacaklar 30-45 cm yükseltilir.', NULL, NULL, 'Baş yükseltilir', 'Vücut düz tutulur', 'Bacaklar yükseltilir', 'Yan yatırılır', 'Şok durumundaki yaralıya hangi pozisyon verilmelidir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(39, b'1', 'ILK_YARDIM', 'A', '2025-12-16 22:21:18.000000', 1, 'Batan cisim çıkarılmamalı, yerinde sabitlenmelidir.', NULL, NULL, 'Çıkarılmamalı, yerinde sabitlenmeli', 'Hemen çıkarılmalı', 'Daha derine itilmeli', 'Yana doğru eğilmeli', 'Vücuda batan cisim durumunda ne yapılmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(40, b'1', 'ILK_YARDIM', 'D', '2025-12-16 22:21:18.000000', 2, 'Burun kanamasında baş öne eğik tutulmalı ve burun kanatları bastırılmalıdır.', NULL, NULL, 'Baş geriye atılmalı', 'Burun tıkanmalı ve baş geriye atılmalı', 'Sırt üstü yatırılmalı', 'Baş öne eğik, burun kanatları bastırılmalı', 'Burun kanamasında doğru müdahale hangisidir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(41, b'1', 'MOTOR_VE_ARAC_TEKNIK', 'C', '2025-12-16 22:21:18.000000', 2, 'Motor yağı seviyesi düzenli olarak kontrol edilmeli ve eksikse tamamlanmalıdır.', NULL, NULL, 'Her gün', 'Her hafta', 'Uzun yola çıkmadan önce ve düzenli aralıklarla', 'Yılda bir kez', 'Motor yağı seviyesi ne zaman kontrol edilmelidir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(42, b'1', 'MOTOR_VE_ARAC_TEKNIK', 'A', '2025-12-16 22:21:18.000000', 2, 'Lastik diş derinliği yasal olarak minimum 1.6 mm olmalıdır.', NULL, NULL, '1.6 mm', '2.0 mm', '3.0 mm', '4.0 mm', 'Lastiklerin yasal asgari diş derinliği kaç mm olmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(43, b'1', 'MOTOR_VE_ARAC_TEKNIK', 'B', '2025-12-16 22:21:18.000000', 2, 'ABS (Anti-lock Braking System) frenleme sırasında tekerleklerin kilitlenmesini önler.', NULL, NULL, 'Hızlanmayı artırır', 'Frenleme sırasında tekerleklerin kilitlenmesini önler', 'Yakıt tasarrufu sağlar', 'Motor gücünü artırır', 'ABS sisteminin görevi nedir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(44, b'1', 'MOTOR_VE_ARAC_TEKNIK', 'D', '2025-12-16 22:21:18.000000', 2, 'Aküde kırmızı terminal (+) pozitif, siyah terminal (-) negatif kutuptur.', NULL, NULL, 'Kırmızı negatif, siyah pozitif', 'Her ikisi de pozitif', 'Her ikisi de negatif', 'Kırmızı pozitif, siyah negatif', 'Araç aküsünde kırmızı ve siyah terminaller neyi ifade eder?', 'TEXT', '2025-12-16 22:21:18.000000'),
(45, b'1', 'MOTOR_VE_ARAC_TEKNIK', 'C', '2025-12-16 22:21:18.000000', 2, 'Soğutma suyu seviyesi motor soğukken kontrol edilmelidir.', NULL, NULL, 'Motor çalışırken', 'Motor sıcakken', 'Motor soğukken', 'Araç hareket halindeyken', 'Soğutma suyu seviyesi ne zaman kontrol edilmelidir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(46, b'1', 'CEVRESEL_KONULAR', 'A', '2025-12-16 22:21:18.000000', 1, 'Ekonomik sürüş yakıt tüketimini azaltır ve çevreye daha az zarar verir.', NULL, NULL, 'Yakıt tüketimi azalır, çevre kirliliği azalır', 'Yakıt tüketimi artar', 'Araç daha hızlı gider', 'Motor ömrü kısalır', 'Ekonomik sürüşün faydası nedir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(47, b'1', 'CEVRESEL_KONULAR', 'B', '2025-12-16 22:21:18.000000', 2, 'Ani hızlanma ve ani frenleme hem yakıt tüketimini hem de çevre kirliliğini artırır.', NULL, NULL, 'Yakıt tasarrufu sağlar', 'Yakıt tüketimini ve emisyonu artırır', 'Motor performansını artırır', 'Lastik ömrünü uzatır', 'Ani hızlanma ve ani frenlemenin çevreye etkisi nedir?', 'TEXT', '2025-12-16 22:21:18.000000'),
(48, b'1', 'CEVRESEL_KONULAR', 'C', '2025-12-16 22:21:18.000000', 2, 'Egzoz emisyon testi araçların çevre standartlarına uygunluğunu kontrol eder.', NULL, NULL, 'Motor gücünü ölçer', 'Fren performansını ölçer', 'Araçtan çıkan zararlı gazları ölçer', 'Lastik durumunu kontrol eder', 'Egzoz emisyon testi neyi kontrol eder?', 'TEXT', '2025-12-16 22:21:18.000000'),
(49, b'1', 'CEVRESEL_KONULAR', 'A', '2025-12-16 22:21:18.000000', 2, 'Rölantide bekleme yerine motoru kapatmak yakıt tasarrufu sağlar.', NULL, NULL, 'Motoru kapatmak', 'Rölantide beklemek', 'Gaza basmak', 'Vites değiştirmek', 'Uzun süre beklerken yakıt tasarrufu için ne yapılmalıdır?', 'TEXT', '2025-12-16 22:21:18.000000'),
(50, b'1', 'CEVRESEL_KONULAR', 'D', '2025-12-16 22:21:18.000000', 1, 'Gürültü kirliliği hem çevreye hem de insan sağlığına zararlıdır.', NULL, NULL, 'Hava kirliliği', 'Su kirliliği', 'Toprak kirliliği', 'Gürültü kirliliği', 'Gereksiz korna çalmak hangi tür kirliliğe yol açar?', 'TEXT', '2025-12-16 22:21:18.000000');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `tc_no` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`id`, `created_at`, `email`, `enabled`, `first_name`, `last_name`, `password`, `phone_number`, `tc_no`, `updated_at`, `username`) VALUES
(1, '2025-12-16 21:43:59.000000', 'admin@ehliyet.com', b'1', 'Admin', 'User', '$2a$10$U6qt38Ki19.Aj6iSDo5Dyuef63nejlttUKeLpQiBkde1DidV2WbfO', '5551234567', '12345678901', '2025-12-16 21:43:59.000000', 'admin'),
(2, '2025-12-16 21:43:59.000000', 'user@ehliyet.com', b'1', 'Test', 'Kullanıcı', '$2a$10$JhyNwUVPzrrzXI6Xengqy.UhFnFjtaNMfD//nDjSWugR2pOkFylj.', '5559876543', '98765432109', '2025-12-16 21:43:59.000000', 'user');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `exam_answers`
--
ALTER TABLE `exam_answers`
  ADD KEY `FKral4toyh8ehui74wn0h1b310n` (`exam_result_id`);

--
-- Tablo için indeksler `exam_results`
--
ALTER TABLE `exam_results`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt2jcn29o332cpiv7s7h3o877e` (`user_id`);

--
-- Tablo için indeksler `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Tablo için indeksler `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `exam_results`
--
ALTER TABLE `exam_results`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `questions`
--
ALTER TABLE `questions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `exam_answers`
--
ALTER TABLE `exam_answers`
  ADD CONSTRAINT `FKral4toyh8ehui74wn0h1b310n` FOREIGN KEY (`exam_result_id`) REFERENCES `exam_results` (`id`);

--
-- Tablo kısıtlamaları `exam_results`
--
ALTER TABLE `exam_results`
  ADD CONSTRAINT `FKt2jcn29o332cpiv7s7h3o877e` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Tablo kısıtlamaları `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
