-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 05, 2021 at 09:32 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projekanime`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `auth` enum('Y') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`, `auth`) VALUES
('putra', '12319', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `username` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `no_telp` int(15) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`username`, `email`, `nama`, `no_telp`, `password`) VALUES
('a', 'kj', 'jnjnjs', 9897, '12342'),
('ana', 'ujan@gmail.com', 'ksaisai', 12345678, '12345'),
('noah', 'noahsan123@gmail.com', 'Noah Stevie', 896123456, 'lukasmordez'),
('prism', 'raikaji@gmail.com', 'anji', 123456789, '12345'),
('prisma717', 'prismaputra91@gmail.com', 'Prisma Putra', 89698765, 'prisma'),
('renkan', 'raikani@gmail.com', 'Habsah G', 12345678, '55555');

-- --------------------------------------------------------

--
-- Table structure for table `detail`
--

CREATE TABLE `detail` (
  `id_anime` int(3) NOT NULL,
  `judul` varchar(30) NOT NULL,
  `publisher` varchar(30) NOT NULL,
  `tahun` varchar(5) DEFAULT NULL,
  `rilis` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `genre` varchar(15) DEFAULT NULL,
  `download` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail`
--

INSERT INTO `detail` (`id_anime`, `judul`, `publisher`, `tahun`, `rilis`, `status`, `genre`, `download`) VALUES
(1, 'The Journey of Elaine@', 'Funimation', '2020', 'Oct 2020', 'Finished', 'Horror', 1),
(2, 'Naruto Shippuden', 'Pierrot', '2007', 'Feb 2007', 'Finished', 'Adventure', 2),
(3, 'Danshi Koukousei no Nichijou', 'Sunrise', '2012', 'Jan 2012', 'Finished', 'Adventure', 0),
(4, 'Love Live Nijigasaki!', 'Sunrise', '2020', 'Oct 2020', 'Finished', 'Comedy', 2),
(5, 'Corpse Party', 'Asread', '2013', 'Jul 2013', 'Finished', 'Adventure', 14),
(6, 'Gintama', 'Sunrise', '2006', 'Apr 2006', 'Finished', 'Comedy', 1),
(7, 'Shingeki no Kyojin', 'Mappa', '2021', 'Dec 2020', 'On-Going', 'Action', 1),
(8, 'Conan', 'Naraku', '2000', 'Jan 2000', 'On-Going', 'Adventure', 1),
(10, 'Inuyasha', 'Jump', '2000', 'Jun 2000', 'Finished', 'Adventure', 2),
(11, 'Arena of Valor', 'Garena', '2016', 'Oct 2016', 'On-Going', 'Action', 2),
(20, 'Sayonara Sensei-KUN!!!', 'Rumhan.com', '2021', 'May 2021', 'On-Going', 'Comedy', 0),
(21, 'Gundam 97X-RR', 'SupaRoboto', '2021', 'June 2021', 'On-Going', 'Action', 0),
(28, 'Gun-Gale Offline', 'Kirino', '2017', 'Mar 2017', 'On-Going', 'Horror', 0);

-- --------------------------------------------------------

--
-- Table structure for table `library`
--

CREATE TABLE `library` (
  `username` varchar(30) DEFAULT NULL,
  `judul` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `library`
--

INSERT INTO `library` (`username`, `judul`) VALUES
('ana', 'The Journey of Elaine'),
('ana', 'Love Live Nijigasaki!'),
('ana', 'Corpse Party'),
('ana', 'Inuyasha'),
('ana', 'Conan'),
('prism', 'Naruto Shippuden'),
('prism', 'Corpse Party');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `detail`
--
ALTER TABLE `detail`
  ADD PRIMARY KEY (`id_anime`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail`
--
ALTER TABLE `detail`
  MODIFY `id_anime` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
