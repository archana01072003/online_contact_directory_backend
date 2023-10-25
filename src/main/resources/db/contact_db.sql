-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 25, 2023 at 09:39 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `contact_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE `contacts` (
  `contact_id` int(11) NOT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`contact_id`, `contact_name`, `contact_number`, `user_id`) VALUES
(2, 'archana', '1234567899', 1),
(3, 'archana', '1234567899', 1),
(4, 'ram', '1234567899', 1),
(5, 'shyam', '1234567899', 1),
(6, 'kamla', '2345678989', 2),
(52, 'archana', '1234567899', 2),
(53, 'shivani', 'singh', 2),
(54, 'riya', '2345678956', 3),
(55, 'shivam', '1234567888', 4),
(56, 'shivani', '1234567888', 4),
(102, 'kavita', '1234567345', 1),
(152, 'kamla', '2938433939', 7),
(153, 'Archana', '928374923874', 7),
(154, 'Rajan', '92387', 7);

-- --------------------------------------------------------

--
-- Table structure for table `contacts_seq`
--

CREATE TABLE `contacts_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contacts_seq`
--

INSERT INTO `contacts_seq` (`next_val`) VALUES
(251);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `mobile_no`, `name`, `password`) VALUES
(1, 'ram123@gmail.com', '1234567899', 'ram', 'ram@123'),
(2, 'archana01072003@gmail.com', '08839337844', 'Archana Yadav', 'Archana@123'),
(3, 'pawan123@gmail.com', '1234567899', 'pawan', 'pawan@123'),
(4, 'rajan123@gmail.com', '1234567899', 'rajan yadav', 'rajan@123'),
(5, 'reena123@gmail.com', '1234567899', 'reena', 'reena@123'),
(6, 'reena123@gmail.com', '1234567888', 'reena', 'reena@123'),
(7, 'risha123@gmail.com', '234567889', 'risha', 'risha@123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`contact_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
