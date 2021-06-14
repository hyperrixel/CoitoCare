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
-- Tábla szerkezet ehhez a táblához `tblCoitoCareUser`
--

CREATE TABLE `tblCoitoCareUser` (
  `IX_User_ID` int(10) UNSIGNED NOT NULL,
  `PK_User_UserID` int(10) UNSIGNED NOT NULL,
  `FK_User_Genders_GenderID` smallint(5) UNSIGNED DEFAULT NULL,
  `FK_User_Orientations_OrientationID` smallint(5) UNSIGNED DEFAULT NULL,
  `Nick` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `Photo` blob DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=ascii;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `tblCoitoCareUser`
--
ALTER TABLE `tblCoitoCareUser`
  ADD PRIMARY KEY (`PK_User_UserID`),
  ADD KEY `IX_User_ID` (`IX_User_ID`),
  ADD KEY `FK_User_Genders_GenderID` (`FK_User_Genders_GenderID`),
  ADD KEY `FK_User_Orientations_OrientationID` (`FK_User_Orientations_OrientationID`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `tblCoitoCareUser`
--
ALTER TABLE `tblCoitoCareUser`
  MODIFY `IX_User_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
