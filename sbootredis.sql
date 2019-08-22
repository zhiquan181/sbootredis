-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2019-08-22 11:36:21
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sbootredis`
--
CREATE DATABASE IF NOT EXISTS `sbootredis` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sbootredis`;

-- --------------------------------------------------------

--
-- 表的结构 `user_info`
--
-- 创建时间： 2019-08-21 11:27:36
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `id` varchar(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `user_info`
--

INSERT INTO `user_info` (`id`, `username`, `password`, `age`) VALUES
('ID201908211835baa3', 'vegeta', NULL, '21'),
('ID201908211835c813', 'xxm', NULL, '89'),
('ID2019082118368663', 'chenzi', 'abc', '20'),
('ID2019082216313dff', 'K9999', '123456', '18');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
