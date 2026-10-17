-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2026 at 01:23 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `person`
--

-- --------------------------------------------------------

--
-- Table structure for table `persontable`
--

CREATE TABLE `persontable` (
  `id` varchar(6) NOT NULL,
  `name` varchar(50) NOT NULL,
  `year` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `category` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `persontable`
--

INSERT INTO `persontable` (`id`, `name`, `year`, `email`, `category`) VALUES
('M001', 'John Stewart', 2026, 'Granny@gmail.com', 'LULUS'),
('M003', 'Hal Jordan', 1983, 'HalJord@gmail.com', 'DIKELUARKAN'),
('M002', 'MOGO', 1900, 'mogoandi@gmail.com', 'LULUS'),
('M004', 'Meursault', 1933, 'absurd@gmail.com', 'LULUS'),
('M005', 'King gondo', 1940, 'kg@gmail.com', 'MENGUNDURKAN DIRI'),
('M006', 'JIA BAOYU', 2026, 'HL@gmail.com', 'MENGUNDURKAN DIRI'),
('M007', 'Heathcliff', 1900, 'LintonsucksSSSSS@gmail.com', 'TIDAK LULUS');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
