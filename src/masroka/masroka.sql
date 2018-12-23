-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 23, 2018 at 09:08 AM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `masroka`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `Country` varchar(255) NOT NULL,
  `Governate` varchar(255) NOT NULL,
  `Street` varchar(255) NOT NULL,
  `Bulding` int(11) NOT NULL,
  `Floor` int(11) NOT NULL,
  `apartment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `Type` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `ID` varchar(255) NOT NULL,
  `Address` varchar(798) NOT NULL,
  `OwnerID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `ID` varchar(255) NOT NULL,
  `Owner` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Photo` varchar(255) NOT NULL,
  `Description` varchar(1080) NOT NULL,
  `Question` varchar(1080) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`ID`, `Owner`, `Name`, `Address`, `Photo`, `Description`, `Question`) VALUES
('1', 'abdallah@gmail.com', 'car', 'egy-cairo', 'C:Users\newDesktopحاسبات1جدول.jpg', 'my car', 'this car?'),
('222', 'abdo', 'Stolen_car', 'embaba', 'car.jbg', 'ford', 'what is s color?');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Email` varchar(255) NOT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Address` varchar(255) NOT NULL,
  `Phone` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Email`, `UserName`, `Password`, `Address`, `Phone`) VALUES
('abdallah@gmail.com', 'abdallah', '1234567s', 'egy-cairo', '1097949015'),
('alyaloly@gmail.com', 'Ali Maged', '123456789', 'Cairoooooo', '01116192622'),
('lolo.mego.aly@gmail.com', 'warraa', '987654321', 'Gizaaaaaaa', '01116193633');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Email`),
  ADD KEY `Email` (`Email`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
