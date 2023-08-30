-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Aug 30, 2023 at 10:48 AM
-- Server version: 5.7.34
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gym_java_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `sports`
--

CREATE TABLE `sports` (
  `id` int(11) NOT NULL,
  `cost` int(11) NOT NULL,
  `coach` text NOT NULL,
  `name` text NOT NULL,
  `time` text NOT NULL,
  `number_of_places` int(11) NOT NULL,
  `rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sports`
--

INSERT INTO `sports` (`id`, `cost`, `coach`, `name`, `time`, `number_of_places`, `rating`) VALUES
(1, 50, 'John Smith', 'Weightlifting', 'Monday 6:00 PM', 14, 0),
(3, 25, 'Michael Brown', 'Cardio Kickboxing', 'Wednesday 5:45 PM', 12, 0),
(4, 40, 'Emily Davis', 'Pilates', 'Thursday 8:15 AM', 17, 0),
(5, 28, 'test', 'test', 'test', 78, 6),
(6, 20, 'Jessica Martinez', 'Zumba', 'Saturday 10:00 AM', 25, 0),
(7, 45, 'Ryan Johnson', 'Spin Cycling', 'Sunday 9:30 AM', 14, 0),
(8, 30, 'Michelle Lee', 'Functional Training', 'Monday 7:00 AM', 16, 5),
(9, 25, 'Chris Miller', 'Hatha Yoga', 'Tuesday 6:15 PM', 22, 0),
(10, 40, 'Amanda White', 'HIIT', 'Wednesday 6:30 AM', 6, 0),
(11, 50, 'John Smith', 'Weightlifting', 'Monday 6:00 PM', 13, 0),
(12, 30, 'Sarah Johnson', 'Yoga', 'Tuesday 7:30 AM', 20, 0),
(13, 25, 'Michael Brown', 'Cardio Kickboxing', 'Wednesday 5:45 PM', 12, 0),
(14, 40, 'Emily Davis', 'Pilates', 'Thursday 8:15 AM', 18, 6),
(16, 20, 'Jessica Martinez', 'Zumba', 'Saturday 10:00 AM', 25, 0),
(17, 45, 'Ryan Johnson', 'Spin Cycling', 'Sunday 9:30 AM', 13, 0),
(19, 25, 'Chris Miller', 'Hatha Yoga', 'Tuesday 6:15 PM', 21, 0),
(20, 40, 'Amanda White', 'HIIT', 'Wednesday 6:30 AM', 10, 0),
(21, 30, 'Test Coach', 'NewSport', 'New Time', 10, 4),
(22, 40, 'Test Coach', 'NewSport', 'New Time', 9, 3),
(23, 40, 'Test Coach2', 'NewSport2', 'New Time2', 6, 3),
(24, 40, 'Test Coach3', 'NewSport3', 'New Time3', 9, 3),
(25, 40, 'Test Coach4', 'NewSport4', 'New Time4', 10, 3),
(26, 40, 'Test Coach5', 'NewSport5', 'New Time5', 9, 3),
(27, 40, 'Test Coach5', 'NewSport5', 'New Time5', 10, 3),
(28, 40, 'Test Coach6', 'NewSport6', 'New Time6', 10, 3);

-- --------------------------------------------------------

--
-- Table structure for table `subscribtion`
--

CREATE TABLE `subscribtion` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `sport_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `subscribtion`
--

INSERT INTO `subscribtion` (`id`, `user_id`, `sport_id`) VALUES
(9, 12, 2),
(10, 13, 2),
(11, 16, 2),
(12, 20, 2),
(13, 17, 2),
(14, 5, 2),
(15, 5, 2),
(16, 5, 2),
(17, 5, 2),
(18, 4, 2),
(19, 2, 2),
(20, 1, 2),
(21, 3, 2),
(22, 2, 2),
(23, 10, 2),
(24, 14, 2),
(25, 2, 18),
(26, 2, 18),
(27, 11, 2),
(28, 11, 2),
(29, 10, 2),
(30, 17, 2),
(31, 4, 2),
(32, 23, 2),
(33, 22, 2),
(34, 23, 2),
(35, 10, 2),
(36, 26, 2),
(37, 24, 2),
(38, 1, 3),
(39, 23, 3),
(40, 23, 3),
(41, 19, 3),
(42, 10, 3),
(43, 10, 3);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `is_admin` tinyint(1) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `is_admin`, `email`, `password`) VALUES
(1, 'Admin', 1, 'admin@gym.com', 'admin'),
(3, 'User2', 0, 'user2@gmail.com', '12345'),
(4, 'User2', 0, 'user2@gmail.com', '12345'),
(5, 'User3', 0, 'user2@gmail.com', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sports`
--
ALTER TABLE `sports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subscribtion`
--
ALTER TABLE `subscribtion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sport_id` (`sport_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sports`
--
ALTER TABLE `sports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `subscribtion`
--
ALTER TABLE `subscribtion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
