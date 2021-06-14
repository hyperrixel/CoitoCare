-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Gép: localhost:3306
-- Létrehozás ideje: 2021. Jún 14. 21:04
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
-- Tábla szerkezet ehhez a táblához `tblCoitoCareUsers`
--

CREATE TABLE `tblCoitoCareUsers` (
  `IX_Users_ID` int(10) UNSIGNED NOT NULL,
  `FK_Users_User_UserID` bigint(20) UNSIGNED NOT NULL,
  `UQ_Users_PlatformID` char(20) NOT NULL,
  `UQ_Users_DeviceID` char(20) NOT NULL,
  `Created` int(10) UNSIGNED NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=ascii;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `tblCoitoCareUsers`
--
ALTER TABLE `tblCoitoCareUsers`
  ADD PRIMARY KEY (`IX_Users_ID`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `tblCoitoCareUsers`
--
ALTER TABLE `tblCoitoCareUsers`
  MODIFY `IX_Users_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
