-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2023 at 08:17 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `viesnica`
--

-- --------------------------------------------------------

--
-- Table structure for table `istabas`
--

CREATE TABLE `istabas` (
  `idistabas` int(11) NOT NULL,
  `istabas_nr` int(11) NOT NULL,
  `stavs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `istabas`
--

INSERT INTO `istabas` (`idistabas`, `istabas_nr`, `stavs`) VALUES
(1, 101, 1),
(2, 102, 1),
(3, 103, 1),
(4, 104, 1),
(5, 105, 1),
(6, 106, 1),
(7, 201, 2),
(8, 202, 2),
(9, 203, 2),
(10, 204, 2),
(11, 205, 2),
(12, 206, 2),
(13, 207, 2),
(14, 208, 2),
(15, 301, 3),
(16, 302, 3),
(17, 303, 3),
(18, 304, 3),
(19, 305, 3),
(20, 306, 3);

-- --------------------------------------------------------

--
-- Table structure for table `kursi`
--

CREATE TABLE `kursi` (
  `idkursi` int(11) NOT NULL,
  `kurss` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kursi`
--

INSERT INTO `kursi` (`idkursi`, `kurss`) VALUES
(1, 'PT2020'),
(2, 'PT2021'),
(3, 'PP2020'),
(4, 'PP2021'),
(5, 'TP2020'),
(6, 'TP2021'),
(7, 'TT2020');

-- --------------------------------------------------------

--
-- Table structure for table `registracija_studenti`
--

CREATE TABLE `registracija_studenti` (
  `idregistracijaS` int(11) NOT NULL,
  `in_datumsS` date NOT NULL,
  `out_datumsS` date NOT NULL,
  `istabasID` int(11) NOT NULL,
  `studentsID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registracija_studenti`
--

INSERT INTO `registracija_studenti` (`idregistracijaS`, `in_datumsS`, `out_datumsS`, `istabasID`, `studentsID`) VALUES
(1, '2022-09-13', '2022-09-16', 4, 6),
(2, '2023-06-11', '2023-06-13', 10, 2),
(3, '2022-06-25', '2022-06-29', 5, 5),
(4, '2023-03-12', '2023-06-24', 13, 14),
(5, '2023-01-09', '2023-01-13', 7, 18),
(6, '2022-12-18', '2023-06-30', 9, 11);

-- --------------------------------------------------------

--
-- Table structure for table `registracija_viesi`
--

CREATE TABLE `registracija_viesi` (
  `idregistracijaV` int(11) NOT NULL,
  `in_datumsV` date NOT NULL,
  `out_datumsV` date NOT NULL,
  `istabasID` int(11) NOT NULL,
  `viesisID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registracija_viesi`
--

INSERT INTO `registracija_viesi` (`idregistracijaV`, `in_datumsV`, `out_datumsV`, `istabasID`, `viesisID`) VALUES
(1, '2022-08-01', '2022-08-04', 7, 3),
(2, '2023-03-14', '2023-06-17', 13, 6),
(3, '2023-02-01', '2023-02-02', 17, 4),
(4, '2023-09-13', '2023-09-16', 1, 2),
(5, '2023-07-06', '2023-07-08', 13, 1),
(6, '2023-04-09', '2023-04-10', 6, 5);

-- --------------------------------------------------------

--
-- Table structure for table `studenti`
--

CREATE TABLE `studenti` (
  `idstudenti` int(11) NOT NULL,
  `vards` varchar(30) NOT NULL,
  `uzvards` varchar(30) NOT NULL,
  `personas_kods` varchar(12) NOT NULL,
  `adrese` varchar(40) NOT NULL,
  `tel_nr` int(8) NOT NULL,
  `kurssid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studenti`
--

INSERT INTO `studenti` (`idstudenti`, `vards`, `uzvards`, `personas_kods`, `adrese`, `tel_nr`, `kurssid`) VALUES
(1, 'Pāvils', 'Kuzmins', '986541-65113', 'Brīvības iela 25, Rīga', 20564858, 5),
(2, 'Daina', 'Plētniece', '986541-98455', 'Pils iela 3, Sigulda', 20156465, 1),
(3, 'Juris', 'Kalniņš', '235645-02354', 'Raiņa iela 10, Liepāja', 26513200, 2),
(4, 'Līga', 'Ozoliņa', '986541-98455', 'Pils iela 3, Sigulda', 20166489, 4),
(5, 'Ina', 'Elsberga', '3206515-9851', 'Lāčplēša iela 8, Ventspils', 26543127, 5),
(6, 'Zane', 'Pētersone', '464560-65103', 'Pasta iela 7, Ogre', 20566522, 3),
(7, 'Māris', 'Ziemelis', '235645-02354', 'Krišjāņa Barona iela 15, Jelgava', 20156358, 3),
(8, 'Artūrs', 'Lapiņš', '894565-78964', 'Dzirnavu iela 2, Tukums', 26513200, 4),
(9, 'Elīna', 'Ozoliņa', '464560-65103', 'Pils iela 3, Sigulda', 20566522, 2),
(10, 'Sandija', 'Berente', '986541-98651', 'Lāčplēša iela 8, Ventspils', 29865103, 6),
(11, 'Gusts', 'Beinerts', '231652-6320', 'Krišjāņa Barona iela 15, Jelgava', 20165410, 3),
(12, 'Sandija', 'Berente', '986541-98651', 'Lāčplēša iela 8, Ventspils', 29865103, 6),
(13, 'Gusts', 'Beinerts', '231652-63201', 'Rūpniecības iela 4, Cēsis\r\n', 29854648, 2);

-- --------------------------------------------------------

--
-- Table structure for table `viesi`
--

CREATE TABLE `viesi` (
  `idviesi` int(11) NOT NULL,
  `vards` varchar(30) NOT NULL,
  `uzvards` varchar(30) NOT NULL,
  `tel_nr` int(8) NOT NULL,
  `Apmaksas_veids` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `viesi`
--

INSERT INTO `viesi` (`idviesi`, `vards`, `uzvards`, `tel_nr`, `Apmaksas_veids`) VALUES
(1, 'Arnis', 'Līvāns', 20141055, 'intrnetbanka'),
(2, 'Ija', 'Kivliņa', 29865413, 'internetbanka'),
(3, 'Saiva', 'Buņķe', 28965417, 'internetbanka'),
(4, 'Mareks', 'Podkalns', 26320653, 'skaidrā nauda'),
(5, 'Fēlikss', 'Biķeris', 28965120, 'skaidrā nauda'),
(6, 'Saiva', 'Druska', 29865867, 'internetbanka');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `istabas`
--
ALTER TABLE `istabas`
  ADD PRIMARY KEY (`idistabas`);

--
-- Indexes for table `kursi`
--
ALTER TABLE `kursi`
  ADD PRIMARY KEY (`idkursi`);

--
-- Indexes for table `registracija_studenti`
--
ALTER TABLE `registracija_studenti`
  ADD PRIMARY KEY (`idregistracijaS`);

--
-- Indexes for table `registracija_viesi`
--
ALTER TABLE `registracija_viesi`
  ADD PRIMARY KEY (`idregistracijaV`),
  ADD KEY `viesiId` (`viesisID`);

--
-- Indexes for table `studenti`
--
ALTER TABLE `studenti`
  ADD PRIMARY KEY (`idstudenti`),
  ADD KEY `kursiID` (`kurssid`);

--
-- Indexes for table `viesi`
--
ALTER TABLE `viesi`
  ADD PRIMARY KEY (`idviesi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `istabas`
--
ALTER TABLE `istabas`
  MODIFY `idistabas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `kursi`
--
ALTER TABLE `kursi`
  MODIFY `idkursi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `registracija_studenti`
--
ALTER TABLE `registracija_studenti`
  MODIFY `idregistracijaS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `registracija_viesi`
--
ALTER TABLE `registracija_viesi`
  MODIFY `idregistracijaV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `studenti`
--
ALTER TABLE `studenti`
  MODIFY `idstudenti` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `viesi`
--
ALTER TABLE `viesi`
  MODIFY `idviesi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `registracija_viesi`
--
ALTER TABLE `registracija_viesi`
  ADD CONSTRAINT `viesiId` FOREIGN KEY (`viesisID`) REFERENCES `viesi` (`idviesi`);

--
-- Constraints for table `studenti`
--
ALTER TABLE `studenti`
  ADD CONSTRAINT `kursiID` FOREIGN KEY (`kurssid`) REFERENCES `kursi` (`idkursi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
