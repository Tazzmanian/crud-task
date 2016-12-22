-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.17-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for person_schema
CREATE DATABASE IF NOT EXISTS `person_schema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `person_schema`;

-- Dumping structure for table person_schema.person
CREATE TABLE IF NOT EXISTS `person` (
  `first_name` char(50) DEFAULT NULL,
  `last_name` char(50) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `email` char(255) DEFAULT NULL,
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8;

-- Dumping data for table person_schema.person: ~8 rows (approximately)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
REPLACE INTO `person` (`first_name`, `last_name`, `birth_date`, `phone`, `email`, `id`) VALUES
	('Alex', 'Angel', '1901-12-12', '0123456789', 'emil__vasilev@abv.bg', 9),
	('Alex', 'Todorov', '1902-12-12', '0123456789', 'banskaliqtabg@gmail.com', 11),
	('Alex', 'Alex', '1903-12-11', '019812345', 'fasdfa@adfa.com', 12),
	('Peter', 'Pan', '1879-10-10', '1023892834', 'peter@pan.bg', 13),
	('Alex', 'Svewt', '1904-12-12', '019812345', 'tazzmanian@abv.bg', 14),
	('Peter', 'Angel', '1906-12-12', '1023892834', 'banskaliqtabg@gmail.com', 172),
	('Alexa', 'Todorova', '1879-11-11', '019812345', 'asdasd@abv.bg', 173),
	('Plam', 'Svet', '1960-10-10', '7894651230', 'plam@svet.com', 174);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
