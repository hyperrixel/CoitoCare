-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Gép: localhost:3306
-- Létrehozás ideje: 2021. Jún 14. 21:03
-- Kiszolgáló verziója: 10.3.27-MariaDB-log
-- PHP verzió: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `fisheeu1_testdb`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `tblCoitoCareUserDiseases`
--

CREATE TABLE `tblCoitoCareUserDiseases` (
  `IX_UserDiseases_ID` int(10) UNSIGNED NOT NULL,
  `FK_UserDiseases_User_UserID` int(10) UNSIGNED NOT NULL,
  `FK_UserDiseases_Diseases_DiseaseID` smallint(5) UNSIGNED NOT NULL,
  `Uploaded` int(10) UNSIGNED NOT NULL,
  `CreatedByUser` int(10) UNSIGNED NOT NULL,
  `Start` int(10) UNSIGNED NOT NULL,
  `End` int(10) UNSIGNED DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=ascii;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `tblCoitoCareUserDiseases`
--
ALTER TABLE `tblCoitoCareUserDiseases`
  ADD PRIMARY KEY (`IX_UserDiseases_ID`),
  ADD KEY `FK_UserDiseases_User_UserID` (`FK_UserDiseases_User_UserID`),
  ADD KEY `FK_UserDiseases_Diseases_DiseaseID` (`FK_UserDiseases_Diseases_DiseaseID`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `tblCoitoCareUserDiseases`
--
ALTER TABLE `tblCoitoCareUserDiseases`
  MODIFY `IX_UserDiseases_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
