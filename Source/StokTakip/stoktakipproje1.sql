-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 22 Mar 2020, 12:56:16
-- Sunucu sürümü: 8.0.19
-- PHP Sürümü: 7.2.24-0ubuntu0.18.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `stoktakipproje1`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `depo`
--

CREATE TABLE `depo` (
  `depoId` int NOT NULL,
  `depoAdi` varchar(45) NOT NULL,
  `personelId` int NOT NULL,
  `depoTur` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `depo`
--

INSERT INTO `depo` (`depoId`, `depoAdi`, `personelId`, `depoTur`) VALUES
(1, 'deneme', 1, 2),
(2, 'deneme2', 1, 2),
(4, 'deneme3', 2, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `depodansiparis`
--

CREATE TABLE `depodansiparis` (
  `depodansiparisId` int NOT NULL,
  `siparisAdi` varchar(45) NOT NULL,
  `siparisAciklama` varchar(45) NOT NULL,
  `siparisAdet` int NOT NULL,
  `siparisHammadde` int NOT NULL,
  `siparisPersonel` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `depotur`
--

CREATE TABLE `depotur` (
  `depoturId` int NOT NULL,
  `depoturAdi` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `depotur`
--

INSERT INTO `depotur` (`depoturId`, `depoturAdi`) VALUES
(1, 'Urun'),
(2, 'Hammadde');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `firma_satis`
--

CREATE TABLE `firma_satis` (
  `FirmaId` int NOT NULL,
  `hammaddeId` int NOT NULL,
  `birimFiyat` double NOT NULL,
  `satisId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `firma_satis`
--

INSERT INTO `firma_satis` (`FirmaId`, `hammaddeId`, `birimFiyat`, `satisId`) VALUES
(1, 1, 1, 4),
(1, 2, 123, 6);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `gunluk`
--

CREATE TABLE `gunluk` (
  `gunlukId` int NOT NULL,
  `gunlukTarih` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `gunluk`
--

INSERT INTO `gunluk` (`gunlukId`, `gunlukTarih`) VALUES
(1, '2020-03-20'),
(2, '2020-03-20'),
(3, '2020-03-20'),
(4, '2020-03-20'),
(5, '2020-03-20'),
(6, '2020-03-20'),
(7, '2020-03-20');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `gunlukhammadde`
--

CREATE TABLE `gunlukhammadde` (
  `gunlukId` int NOT NULL,
  `islemturId` int NOT NULL,
  `hammaddeId` int NOT NULL,
  `adet` int NOT NULL,
  `personelId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `gunlukhammadde`
--

INSERT INTO `gunlukhammadde` (`gunlukId`, `islemturId`, `hammaddeId`, `adet`, `personelId`) VALUES
(1, 1, 1, 12, 1),
(1, 1, 2, 12, 1),
(1, 1, 3, 14, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `gunlukurun`
--

CREATE TABLE `gunlukurun` (
  `gunlukId` int NOT NULL,
  `islemturId` int NOT NULL,
  `urunId` int NOT NULL,
  `adet` int NOT NULL,
  `personelId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `gunlukurun`
--

INSERT INTO `gunlukurun` (`gunlukId`, `islemturId`, `urunId`, `adet`, `personelId`) VALUES
(1, 1, 1, 3, 1),
(1, 2, 1, 3, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hammadde`
--

CREATE TABLE `hammadde` (
  `hammaddeId` int NOT NULL,
  `hammaddeAdi` varchar(45) NOT NULL,
  `hammaddeTur` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `hammadde`
--

INSERT INTO `hammadde` (`hammaddeId`, `hammaddeAdi`, `hammaddeTur`) VALUES
(1, 'A4', 1),
(2, 'Kirmizi', 2),
(3, 'UFO', 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hammaddetur`
--

CREATE TABLE `hammaddetur` (
  `hammaddeturId` int NOT NULL,
  `hammaddeturAdi` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `hammaddetur`
--

INSERT INTO `hammaddetur` (`hammaddeturId`, `hammaddeturAdi`) VALUES
(1, 'Kagit'),
(2, 'Boya'),
(3, 'Yapistirici');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hammadde_depo_icerik`
--

CREATE TABLE `hammadde_depo_icerik` (
  `depoId` int NOT NULL,
  `hammaddeId` int NOT NULL,
  `adet` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `hammadde_depo_icerik`
--

INSERT INTO `hammadde_depo_icerik` (`depoId`, `hammaddeId`, `adet`) VALUES
(2, 2, 135),
(1, 1, 83),
(2, 3, 14);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `islemtur`
--

CREATE TABLE `islemtur` (
  `islemturId` int NOT NULL,
  `islemturAdi` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `islemtur`
--

INSERT INTO `islemtur` (`islemturId`, `islemturAdi`) VALUES
(1, 'Giris'),
(2, 'Cikis');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personel`
--

CREATE TABLE `personel` (
  `PersonelId` int NOT NULL,
  `personelTC` varchar(45) NOT NULL,
  `PersonelIsim` varchar(45) NOT NULL,
  `PersonelSoyIsim` varchar(45) NOT NULL,
  `PersonelCinsiyet` varchar(45) NOT NULL,
  `PersonelEmail` varchar(45) NOT NULL,
  `PersonelDogumTarihi` datetime NOT NULL,
  `PersonelTelefonNo` varchar(45) NOT NULL,
  `PersonelAdres` varchar(45) NOT NULL,
  `PersonelYetki` int NOT NULL,
  `PersonelUsername` varchar(45) NOT NULL,
  `PersonelPassword` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `personel`
--

INSERT INTO `personel` (`PersonelId`, `personelTC`, `PersonelIsim`, `PersonelSoyIsim`, `PersonelCinsiyet`, `PersonelEmail`, `PersonelDogumTarihi`, `PersonelTelefonNo`, `PersonelAdres`, `PersonelYetki`, `PersonelUsername`, `PersonelPassword`) VALUES
(1, '123456789', 'Mert', 'Kilic', 'Erkek', 'mwert09@gmail.com', '1999-06-03 00:00:00', '05427413834', 'Beylikduzu', 1, 'mwert', '123456789'),
(2, '123456788', 'Mertiki', 'Kiliciki', 'Kadin', 'mwert009@gmail.com', '1999-09-30 00:00:00', '05427413835', 'Besiktas', 2, 'mwert2', '123456789'),
(3, '123456777', 'Corona', 'Korona', 'Erkek', 'mwertcorona@gmail.com', '1999-06-02 00:00:00', '05427413834', 'corona kor ona', 2, 'corona', '123456789'),
(7, 'qweads', 'ayhan', 'hatipo', 'Kadin', 'qweasd', '2020-03-04 00:00:00', 'qweasd', '12123', 2, 'qweasd', 'qweasd'),
(9, '123123', 'slm', 'nr', 'Erkek', 'naber@gmail.com', '2020-03-04 00:00:00', '123123', '123q', 3, 'qwe', 'qwe');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `rapor`
--

CREATE TABLE `rapor` (
  `raporId` int NOT NULL,
  `raporAdi` varchar(45) NOT NULL,
  `raporAciklama` varchar(45) NOT NULL,
  `personelId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `rapor`
--

INSERT INTO `rapor` (`raporId`, `raporAdi`, `raporAciklama`, `personelId`) VALUES
(3, 'no', 'way', 1),
(4, 'ad', 'qweasdsad', 7);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `siparis`
--

CREATE TABLE `siparis` (
  `siparisId` int NOT NULL,
  `siparisAdi` varchar(45) NOT NULL,
  `siparisAciklama` varchar(90) NOT NULL,
  `siparisAdet` int NOT NULL,
  `siparisDurum` int NOT NULL,
  `siparisHammadde` varchar(45) NOT NULL,
  `siparisPersonel` int NOT NULL,
  `siparisFirmaSatis` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `siparis`
--

INSERT INTO `siparis` (`siparisId`, `siparisAdi`, `siparisAciklama`, `siparisAdet`, `siparisDurum`, `siparisHammadde`, `siparisPersonel`, `siparisFirmaSatis`) VALUES
(1, 'ilk', 'ilk siparis', 10, 2, '1', 3, 4),
(2, 'asd', '2', 45, 1, '1', 7, 6);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `siparisdurum`
--

CREATE TABLE `siparisdurum` (
  `durumId` int NOT NULL,
  `durumAdi` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `siparisdurum`
--

INSERT INTO `siparisdurum` (`durumId`, `durumAdi`) VALUES
(1, 'Onay Bekliyor'),
(2, 'Onaylandi');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tedarikcifirma`
--

CREATE TABLE `tedarikcifirma` (
  `FirmaId` int NOT NULL,
  `FirmaAdi` varchar(45) NOT NULL,
  `FirmaTelefon` varchar(45) NOT NULL,
  `FirmaAdres` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `tedarikcifirma`
--

INSERT INTO `tedarikcifirma` (`FirmaId`, `FirmaAdi`, `FirmaTelefon`, `FirmaAdres`) VALUES
(1, 'BoyaSatan', '05875254876', 'Esenyurt'),
(3, 'asd', 'qweqweqw', 'qweewq');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urun`
--

CREATE TABLE `urun` (
  `urunId` int NOT NULL,
  `UrunAdi` varchar(45) NOT NULL,
  `UrunAciklamasi` varchar(90) NOT NULL,
  `Fiyat` double NOT NULL,
  `Kagit` int NOT NULL,
  `Boya` int NOT NULL,
  `Yapistirici` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `urun`
--

INSERT INTO `urun` (`urunId`, `UrunAdi`, `UrunAciklamasi`, `Fiyat`, `Kagit`, `Boya`, `Yapistirici`) VALUES
(1, 'Java Programlama', 'Java Programlama kitabi kapakli', 40, 1, 2, 3),
(7, 'deneme', 'online mysql deneme', 1, 1, 2, 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urun_depo_icerik`
--

CREATE TABLE `urun_depo_icerik` (
  `depoid` int NOT NULL,
  `urunid` int NOT NULL,
  `adet` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `urun_depo_icerik`
--

INSERT INTO `urun_depo_icerik` (`depoid`, `urunid`, `adet`) VALUES
(4, 1, 27);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yetki`
--

CREATE TABLE `yetki` (
  `idyetki` int NOT NULL,
  `yetkiadi` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `yetki`
--

INSERT INTO `yetki` (`idyetki`, `yetkiadi`) VALUES
(1, 'Yonetici'),
(2, 'Depocu'),
(3, 'Matbaaci');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `depo`
--
ALTER TABLE `depo`
  ADD PRIMARY KEY (`depoId`),
  ADD KEY `personelId` (`personelId`),
  ADD KEY `depoTur` (`depoTur`);

--
-- Tablo için indeksler `depodansiparis`
--
ALTER TABLE `depodansiparis`
  ADD PRIMARY KEY (`depodansiparisId`),
  ADD KEY `siparisHammadde` (`siparisHammadde`),
  ADD KEY `siparisPersonel` (`siparisPersonel`);

--
-- Tablo için indeksler `depotur`
--
ALTER TABLE `depotur`
  ADD PRIMARY KEY (`depoturId`);

--
-- Tablo için indeksler `firma_satis`
--
ALTER TABLE `firma_satis`
  ADD PRIMARY KEY (`satisId`),
  ADD KEY `hammaddeId` (`hammaddeId`);

--
-- Tablo için indeksler `gunluk`
--
ALTER TABLE `gunluk`
  ADD PRIMARY KEY (`gunlukId`);

--
-- Tablo için indeksler `gunlukhammadde`
--
ALTER TABLE `gunlukhammadde`
  ADD KEY `gunlukId` (`gunlukId`),
  ADD KEY `islemturId` (`islemturId`),
  ADD KEY `hammaddeId` (`hammaddeId`),
  ADD KEY `personelId` (`personelId`);

--
-- Tablo için indeksler `gunlukurun`
--
ALTER TABLE `gunlukurun`
  ADD KEY `gunlukId` (`gunlukId`),
  ADD KEY `islemturId` (`islemturId`),
  ADD KEY `urunId` (`urunId`),
  ADD KEY `personelId` (`personelId`);

--
-- Tablo için indeksler `hammadde`
--
ALTER TABLE `hammadde`
  ADD PRIMARY KEY (`hammaddeId`),
  ADD KEY `hammaddeId` (`hammaddeId`),
  ADD KEY `hammaddeTur` (`hammaddeTur`);

--
-- Tablo için indeksler `hammaddetur`
--
ALTER TABLE `hammaddetur`
  ADD PRIMARY KEY (`hammaddeturId`);

--
-- Tablo için indeksler `hammadde_depo_icerik`
--
ALTER TABLE `hammadde_depo_icerik`
  ADD KEY `depoId` (`depoId`),
  ADD KEY `hammaddeId` (`hammaddeId`);

--
-- Tablo için indeksler `islemtur`
--
ALTER TABLE `islemtur`
  ADD PRIMARY KEY (`islemturId`);

--
-- Tablo için indeksler `personel`
--
ALTER TABLE `personel`
  ADD PRIMARY KEY (`PersonelId`),
  ADD KEY `fk_personel_yetki` (`PersonelYetki`);

--
-- Tablo için indeksler `rapor`
--
ALTER TABLE `rapor`
  ADD PRIMARY KEY (`raporId`),
  ADD KEY `personelId` (`personelId`);

--
-- Tablo için indeksler `siparis`
--
ALTER TABLE `siparis`
  ADD PRIMARY KEY (`siparisId`),
  ADD KEY `siparisDurum` (`siparisDurum`),
  ADD KEY `siparisFirmaSatis` (`siparisFirmaSatis`);

--
-- Tablo için indeksler `siparisdurum`
--
ALTER TABLE `siparisdurum`
  ADD PRIMARY KEY (`durumId`);

--
-- Tablo için indeksler `tedarikcifirma`
--
ALTER TABLE `tedarikcifirma`
  ADD PRIMARY KEY (`FirmaId`);

--
-- Tablo için indeksler `urun`
--
ALTER TABLE `urun`
  ADD PRIMARY KEY (`urunId`),
  ADD KEY `urunId` (`urunId`);

--
-- Tablo için indeksler `urun_depo_icerik`
--
ALTER TABLE `urun_depo_icerik`
  ADD KEY `depoid` (`depoid`);

--
-- Tablo için indeksler `yetki`
--
ALTER TABLE `yetki`
  ADD PRIMARY KEY (`idyetki`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `depo`
--
ALTER TABLE `depo`
  MODIFY `depoId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `depodansiparis`
--
ALTER TABLE `depodansiparis`
  MODIFY `depodansiparisId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `depotur`
--
ALTER TABLE `depotur`
  MODIFY `depoturId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `firma_satis`
--
ALTER TABLE `firma_satis`
  MODIFY `satisId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `gunluk`
--
ALTER TABLE `gunluk`
  MODIFY `gunlukId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `hammadde`
--
ALTER TABLE `hammadde`
  MODIFY `hammaddeId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `hammaddetur`
--
ALTER TABLE `hammaddetur`
  MODIFY `hammaddeturId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `islemtur`
--
ALTER TABLE `islemtur`
  MODIFY `islemturId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `rapor`
--
ALTER TABLE `rapor`
  MODIFY `raporId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `siparis`
--
ALTER TABLE `siparis`
  MODIFY `siparisId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `tedarikcifirma`
--
ALTER TABLE `tedarikcifirma`
  MODIFY `FirmaId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `urun`
--
ALTER TABLE `urun`
  MODIFY `urunId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `yetki`
--
ALTER TABLE `yetki`
  MODIFY `idyetki` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `depo`
--
ALTER TABLE `depo`
  ADD CONSTRAINT `depopersonelId_fk` FOREIGN KEY (`personelId`) REFERENCES `personel` (`PersonelId`) ON DELETE CASCADE ON UPDATE RESTRICT,
  ADD CONSTRAINT `depoTur_fk` FOREIGN KEY (`depoTur`) REFERENCES `depotur` (`depoturId`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Tablo kısıtlamaları `depodansiparis`
--
ALTER TABLE `depodansiparis`
  ADD CONSTRAINT `siparishammadde_fk` FOREIGN KEY (`siparisHammadde`) REFERENCES `hammadde` (`hammaddeId`) ON DELETE CASCADE ON UPDATE RESTRICT,
  ADD CONSTRAINT `siparisPersonel_fk` FOREIGN KEY (`siparisPersonel`) REFERENCES `personel` (`PersonelId`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Tablo kısıtlamaları `firma_satis`
--
ALTER TABLE `firma_satis`
  ADD CONSTRAINT `firmasatishammadde_fk` FOREIGN KEY (`hammaddeId`) REFERENCES `hammadde` (`hammaddeId`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Tablo kısıtlamaları `gunlukhammadde`
--
ALTER TABLE `gunlukhammadde`
  ADD CONSTRAINT `gunlukhammaddepersonelId` FOREIGN KEY (`personelId`) REFERENCES `personel` (`PersonelId`) ON DELETE CASCADE ON UPDATE RESTRICT,
  ADD CONSTRAINT `hammaddegunlukid_fk` FOREIGN KEY (`gunlukId`) REFERENCES `gunluk` (`gunlukId`) ON DELETE CASCADE ON UPDATE RESTRICT,
  ADD CONSTRAINT `islemturgunluk_fk` FOREIGN KEY (`islemturId`) REFERENCES `islemtur` (`islemturId`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Tablo kısıtlamaları `gunlukurun`
--
ALTER TABLE `gunlukurun`
  ADD CONSTRAINT `gunlukid_fk` FOREIGN KEY (`gunlukId`) REFERENCES `gunluk` (`gunlukId`) ON DELETE CASCADE ON UPDATE RESTRICT,
  ADD CONSTRAINT `islemtur_fk` FOREIGN KEY (`islemturId`) REFERENCES `islemtur` (`islemturId`) ON DELETE CASCADE ON UPDATE RESTRICT,
  ADD CONSTRAINT `personelId_fk` FOREIGN KEY (`personelId`) REFERENCES `personel` (`PersonelId`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Tablo kısıtlamaları `hammadde`
--
ALTER TABLE `hammadde`
  ADD CONSTRAINT `hammaddetur_fk` FOREIGN KEY (`hammaddeTur`) REFERENCES `hammaddetur` (`hammaddeturId`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Tablo kısıtlamaları `hammadde_depo_icerik`
--
ALTER TABLE `hammadde_depo_icerik`
  ADD CONSTRAINT `depoId_fk` FOREIGN KEY (`depoId`) REFERENCES `depo` (`depoId`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Tablo kısıtlamaları `personel`
--
ALTER TABLE `personel`
  ADD CONSTRAINT `fk_personel_yetki` FOREIGN KEY (`PersonelYetki`) REFERENCES `yetki` (`idyetki`);

--
-- Tablo kısıtlamaları `rapor`
--
ALTER TABLE `rapor`
  ADD CONSTRAINT `raporpersonelid_fk` FOREIGN KEY (`personelId`) REFERENCES `personel` (`PersonelId`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Tablo kısıtlamaları `siparis`
--
ALTER TABLE `siparis`
  ADD CONSTRAINT `siparisfirmasatis_fk` FOREIGN KEY (`siparisFirmaSatis`) REFERENCES `firma_satis` (`satisId`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Tablo kısıtlamaları `urun_depo_icerik`
--
ALTER TABLE `urun_depo_icerik`
  ADD CONSTRAINT `urundepoid_fk` FOREIGN KEY (`depoid`) REFERENCES `depo` (`depoId`) ON DELETE CASCADE ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
