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
-- Tábla szerkezet ehhez a táblához `tblCoitoCareMatchEvent`
--

CREATE TABLE `tblCoitoCareMatchEvent` (
  `IX_MatchEvent_MatchID` int(10) UNSIGNED NOT NULL,
  `UQ_MatchEvent_EventID` bigint(20) UNSIGNED NOT NULL,
  `FK_MatchEvent_Users_DeviceID` char(20) NOT NULL,
  `Protection` tinyint(3) UNSIGNED DEFAULT 0,
  `Created` int(10) UNSIGNED NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=ascii;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `tblCoitoCareMatchEvent`
--
ALTER TABLE `tblCoitoCareMatchEvent`
  ADD PRIMARY KEY (`IX_MatchEvent_MatchID`),
  ADD UNIQUE KEY `UQ_MatchEvent_EventID` (`UQ_MatchEvent_EventID`),
  ADD KEY `FK_MatchEvent_Users_DeviceID` (`FK_MatchEvent_Users_DeviceID`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `tblCoitoCareMatchEvent`
--
ALTER TABLE `tblCoitoCareMatchEvent`
  MODIFY `IX_MatchEvent_MatchID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
