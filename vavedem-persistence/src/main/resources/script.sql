-- # DROP tables

DROP TABLE if exists `localitate`;

DROP TABLE if exists `primarie`;

DROP TABLE if exists `adresa`;

-- # CREATE tables

CREATE TABLE `adresa` (
  `id` int(11) NOT NULL auto_increment,
  `judet` varchar(45) NOT NULL,
  `localitate` varchar(45) NOT NULL,
  `strada` varchar(100) NOT NULL,
  `numar` int(11) DEFAULT NULL,
  `cod_postal` varchar(45) DEFAULT NULL,
  unique key `adresa_unique` (`judet`, `localitate`, `strada`, `cod_postal`),
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `primarie` (
  `id` int(11) NOT NULL auto_increment,
  `nume` varchar(100) NOT NULL,
  `cod_fiscal` int(9) not NULL,
  `telefon` varchar(45) DEFAULT NULL,
  `cod_siruta` int(6) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `id_adresa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  unique key `nume_unique` (`nume`),
  unique key `siruta_unique` (`cod_siruta`),

  CONSTRAINT `fk_primarie_1` FOREIGN KEY (`id_adresa`) REFERENCES `adresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `localitate` (
  `id` int(11) NOT NULL auto_increment,
  `nume` varchar(45) NOT NULL,
  `id_judet` int(11) NOT NULL,
  `tip` INT(3) NOT NULL,
  `id_uat` int(11) NOT NULL,
  `populatie` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_localitate_primarie_1_idx` (`id_uat`),
  CONSTRAINT `fk_localitate_1` FOREIGN KEY (`id_uat`) REFERENCES `primarie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- # INSERT data


DELETE FROM `adresa`
WHERE id >= 1;

INSERT INTO `adresa` (`judet`,`localitate`,`strada`,`numar`,`cod_postal`) VALUES ("IF","if","strada1",22,123);


DELETE FROM `primarie`
WHERE id >= 1;

INSERT INTO `primarie` (`id`,`nume`,`cod_fiscal`,`telefon`,`cod_siruta`,`email`, `id_adresa`)
VALUES (1,'sector 1',1231231,'021234352',123123,'s1@gmail.com',1);
INSERT INTO `primarie` (`id`,`nume`,`cod_fiscal`,`telefon`,`cod_siruta`,`email`, `id_adresa`)
VALUES (2,'sector 2',1231232,'021234352',123122,'s1@gmail.com',1);
INSERT INTO `primarie` (`id`,`nume`,`cod_fiscal`,`telefon`,`cod_siruta`,`email`, `id_adresa`)
VALUES (3,'sector 3',12312313,'021234352',123121,'s1@gmail.com',1);
INSERT INTO `primarie` (`id`,`nume`,`cod_fiscal`,`telefon`,`cod_siruta`,`email`, `id_adresa`)
VALUES (4,'sector 4',1231234, '021234352',123120,'s1@gmail.com',1);
INSERT INTO `primarie` (`id`,`nume`,`cod_fiscal`,`telefon`,`cod_siruta`,`email`, `id_adresa`)
VALUES (5,'sector 5',12312315,'021234352',123124,'s1@gmail.com',1);
INSERT INTO `primarie` (`id`,`nume`,`cod_fiscal`,`telefon`,`cod_siruta`,`email`, `id_adresa`)
VALUES (6,'sector 6',12312316,'021234352',123125,'s1@gmail.com',1);
INSERT INTO `primarie` (`id`,`nume`,`cod_fiscal`,`telefon`,`cod_siruta`,`email`, `id_adresa`)
VALUES (7,'cluj',12312317,'021234352',123126,'s1@gmail.com',1);
INSERT INTO `primarie` (`id`,`nume`,`cod_fiscal`,`telefon`,`cod_siruta`,`email`, `id_adresa`)
VALUES (8,'iasi',12312318,'021234352',123127,'s1@gmail.com',1);
INSERT INTO `primarie` (`id`,`nume`,`cod_fiscal`,`telefon`,`cod_siruta`,`email`, `id_adresa`)
VALUES (9,'brasov',123123123,'021234352',123128,'s1@gmail.com',1);


DELETE FROM `localitate`
WHERE id >= 1;

INSERT INTO `localitate`
(`nume`, `id_judet`,`tip`,`id_uat`) VALUES ("BUCURESTI",1,0,1);


--
-- Table structure for table `account_county`
--

CREATE TABLE IF NOT EXISTS `account_county` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(2) NOT NULL,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `account_county_52094d6e` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=43 ;

--
-- Dumping data for table `account_county`
--

INSERT INTO `account_county` (`id`, `code`, `name`) VALUES
(1, 'DJ', 'Dolj'),
(2, 'BC', 'Bacău'),
(3, 'HR', 'Harghita'),
(4, 'BN', 'Bistrița-Năsăud'),
(5, 'DB', 'Dâmbovița'),
(6, 'SV', 'Suceava'),
(7, 'BT', 'Botoșani'),
(8, 'BV', 'Brașov'),
(9, 'B', 'București'),
(10, 'BR', 'Brăila'),
(11, 'HD', 'Hunedoara'),
(12, 'TR', 'Teleorman'),
(13, 'CV', 'Covasna'),
(14, 'TL', 'Tulcea'),
(15, 'TM', 'Timiș'),
(16, 'BZ', 'Buzău'),
(17, 'PH', 'Prahova'),
(18, 'IF', 'Ilfov'),
(19, 'NT', 'Neamț'),
(20, 'CJ', 'Cluj'),
(21, 'AB', 'Alba'),
(22, 'GR', 'Giurgiu'),
(23, 'AG', 'Argeș'),
(24, 'CL', 'Călărași'),
(25, 'BH', 'Bihor'),
(26, 'IS', 'Iași'),
(27, 'VL', 'Vâlcea'),
(28, 'VN', 'Vrancea'),
(29, 'AR', 'Arad'),
(30, 'IL', 'Ialomița'),
(31, 'CS', 'Caraș-Severin'),
(32, 'GL', 'Galați'),
(33, 'GJ', 'Gorj'),
(34, 'CT', 'Constanța'),
(35, 'SM', 'Satu Mare'),
(36, 'MM', 'Maramureș'),
(37, 'MH', 'Mehedinți'),
(38, 'SJ', 'Sălaj'),
(39, 'VS', 'Vaslui'),
(40, 'MS', 'Mureș'),
(41, 'SB', 'Sibiu'),
(42, 'OT', 'Olt');




