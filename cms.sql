-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2020 at 06:23 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cms`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `appointment_id` int(10) NOT NULL,
  `date` date NOT NULL,
  `doctor_id` int(10) DEFAULT NULL,
  `patient_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`appointment_id`, `date`, `doctor_id`, `patient_id`) VALUES
(1, '2020-10-01', 101, 4),
(2, '2020-10-02', 101, 1),
(3, '2020-10-01', 102, 3);

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `department_id` int(10) NOT NULL,
  `Name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`department_id`, `Name`) VALUES
(1, 'Ophthalmologists'),
(2, 'Dentist'),
(3, 'Phycologist');

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `doctor_id` int(10) NOT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `Address` varchar(40) DEFAULT NULL,
  `Gender` varchar(40) DEFAULT NULL,
  `Phone_no` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`doctor_id`, `Name`, `service_id`, `department_id`, `Address`, `Gender`, `Phone_no`) VALUES
(101, 'Ram Shrestha', 1, 2, 'Dallu,Kathmandu', 'Male', 981367409),
(102, 'Geeta Dangol', 2, 1, 'Paknajol,Kathmandu', 'Female', 980864660),
(103, 'Ramesh Bajracharya', 2, 1, 'Swoyambhu, Kathmandu', 'Male', 981374980),
(104, 'Sita Maharjan', 1, 2, 'Balaju, Kathmandu', 'Female', 983201232);

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `patient_id` int(10) NOT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `Address` varchar(40) DEFAULT NULL,
  `Phone_no` bigint(20) DEFAULT NULL,
  `Gender` varchar(40) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`patient_id`, `Name`, `Address`, `Phone_no`, `Gender`, `Email`) VALUES
(1, 'Ajay Maharjan', 'Dallu,Kathmandu', 981367403, 'Male', 'ajaymaharjan441@gmail.com'),
(2, 'Amar Maharjan', 'Swoyambhu,Kathmandu', 980864660, 'Male', 'amarmaharjan67@gmail.com'),
(3, 'Krishna Khanal', 'Balaju,Kathmandu', 981231234, 'Male', 'hazardkhanal22@gmail.com'),
(4, 'Jack', 'sitapaila', 987, 'male', 'jack@gamil.com'),
(5, 'amar', 'dallu', 987654321, 'male', 'amarmaharjann@gmail.com'),
(7, 'Akaa', 'Teku,Kathmandu', 9876554, '', 'hdsfk'),
(8, 'kkjadsf', 'sadhkfh', 9890987656, 'jkfljsd', 'sadhfkd'),
(9, 'ama', 'aksjd', 87928734, 'jkashd', 'shadkjhs'),
(10, 'krishna khanal', 'kathmandu', 9098987876, 'male', 'kielsjkldfjsad'),
(11, 'jlksdjf', 'skdjfj', 7977676, 'ksdjfl', 'ksjdhfjs'),
(12, 'jasdlkjf', 'sdjfljs', 6373, 'jsdklj', 'skdfs'),
(13, 'jsldjf', 'sdjfj', 72348, 'skhdfk', 'skdhf');

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `report_id` int(10) NOT NULL,
  `Recommendation` varchar(40) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`report_id`, `Recommendation`, `patient_id`, `doctor_id`, `service_id`) VALUES
(100, 'Just need a bed rest', 1, 101, 1),
(101, 'take vitamins', 2, 102, 1);

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `schedule_id` int(10) NOT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `shift` varchar(40) DEFAULT NULL,
  `seat_available` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedules`
--

INSERT INTO `schedules` (`schedule_id`, `doctor_id`, `department_id`, `shift`, `seat_available`) VALUES
(1, 101, 2, 'Morning', 10),
(2, 102, 1, 'Noon', 12),
(3, 104, 2, 'Evening', 15),
(5, 103, 1, 'Evening', 10);

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `service_id` int(10) NOT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `Charges` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`service_id`, `Name`, `Charges`) VALUES
(1, 'Checkup', 500),
(2, 'Lab Facility', 200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`appointment_id`),
  ADD UNIQUE KEY `doctor_id` (`doctor_id`,`patient_id`),
  ADD KEY `patient_id` (`patient_id`);

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`department_id`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`doctor_id`),
  ADD UNIQUE KEY `Phone_no` (`Phone_no`),
  ADD KEY `department_id` (`department_id`),
  ADD KEY `service_id` (`service_id`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`patient_id`),
  ADD UNIQUE KEY `Phone_no` (`Phone_no`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`report_id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `service_id` (`service_id`);

--
-- Indexes for table `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`service_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `appointment_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `department_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `doctor_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `patient_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `report_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT for table `schedules`
--
ALTER TABLE `schedules`
  MODIFY `schedule_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `service_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`doctor_id`),
  ADD CONSTRAINT `appointments_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`);

--
-- Constraints for table `doctors`
--
ALTER TABLE `doctors`
  ADD CONSTRAINT `doctors_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`),
  ADD CONSTRAINT `doctors_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`);

--
-- Constraints for table `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`),
  ADD CONSTRAINT `reports_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`doctor_id`),
  ADD CONSTRAINT `reports_ibfk_3` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`);

--
-- Constraints for table `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `schedules_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`doctor_id`),
  ADD CONSTRAINT `schedules_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
