-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: playfit
-- ------------------------------------------------------
-- Server version	8.0.21
-- 帳密
-- playfit1234@gmail.com 1234
-- test@gmail.com    123456  月曆紀錄測試用帳號

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Avatar`
--

DROP TABLE IF EXISTS `Avatar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Avatar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` mediumblob,
  `image_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `file_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mime_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Avatar`
--

LOCK TABLES `Avatar` WRITE;
/*!40000 ALTER TABLE `Avatar` DISABLE KEYS */;
INSERT INTO `Avatar` VALUES (1,'dolor','Sint quibusdam distinctio omnis. Quia nobis suscipit sit vel. Co',NULL,'./images/Avatar/Avatar_01.png','quis','application/vnd.dna'),(2,'fugiat','Quas vel perspiciatis porro alias soluta voluptas. Voluptate sae',NULL,'./images/Avatar/Avatar_02.png','et','application/vnd.ms-powerpoint.presentation.macroenabled.12'),(3,'nisi','Impedit quod recusandae sit exercitationem est quam laudantium o',NULL,'./images/Avatar/Avatar_03.png','perspiciatis','image/g3fax'),(4,'adipisci','Maiores praesentium maiores aut odio laboriosam. Perferendis qui',NULL,'./images/Avatar/Avatar_04.png','enim','image/vnd.dxf'),(5,'praesentium','Vero ut eum id error voluptatem. Et non libero laudantium sequi ',NULL,'./images/Avatar/Avatar_05.png','laborum','application/vnd.immervision-ivp'),(6,'et','Excepturi natus atque labore earum ex veniam. Ut quis nulla et n',NULL,'tmp//18182e0b2031fcc3e29512471899fcc6.jpg','soluta','text/troff'),(7,'et','Nulla natus eum sit ut et expedita enim. Voluptas cum aliquam do',NULL,'tmp//c193e9625508bfc60efead9deca055c1.jpg','inventore','application/vnd.oasis.opendocument.image'),(8,'aperiam','Provident qui eos numquam reiciendis dignissimos nostrum. Cupidi',NULL,'tmp//ff0b2262d7910a8150dcbf55b2decd0e.jpg','quo','application/vnd.kde.kchart'),(9,'numquam','Sequi velit ipsam nam quibusdam vitae occaecati sint. Consequatu',NULL,'tmp//88b482e04781d50e7c97a09496fa1c61.jpg','ut','application/x-mie'),(10,'iusto','Qui repudiandae quis ducimus aut nesciunt delectus. Reiciendis u',NULL,'tmp//d75bb206cce5d20ba33d350f7c740e43.jpg','rem','application/mp4'),(11,'iste','Aut enim aut fugiat numquam pariatur. Atque quis reiciendis fugi',NULL,'tmp//14174949f77cd9e396ecb58f4020c95e.jpg','nam','video/h261'),(12,'quis','Et dolorem voluptas omnis. Laborum eos incidunt laborum sit dolo',NULL,'tmp//295c55d7a7adc9bf54e3369cf7c76262.jpg','eius','application/vnd.ahead.space'),(13,'cumque','Est dignissimos sunt voluptas recusandae tempore modi ea. Facili',NULL,'tmp//3c607e8944db3426f7b64e3429c53670.jpg','dicta','text/x-nfo'),(14,'aut','Eum est molestias quo et. Ut cum iure architecto ex culpa. Offic',NULL,'tmp//5d0cc1030da6c298fa45b837c9b6cb54.jpg','nobis','application/lost+xml'),(15,'laboriosam','Autem accusamus recusandae doloribus reprehenderit autem. Conseq',NULL,'tmp//bdbf1f050fd3051df0c16b7428efb8ed.jpg','quis','application/vnd.oasis.opendocument.text-master'),(16,'quas','Adipisci provident qui amet nisi. Iusto omnis ipsam id dolorem s',NULL,'tmp//fc033ae76efea7ec4cdcac0a63775b3e.jpg','vel','application/vnd.dece.ttml+xml'),(17,'pariatur','Beatae similique vero molestias et. Fugit velit voluptatem labor',NULL,'tmp//87484b3aa84f1d6fe68cc911bd4de4cb.jpg','nemo','application/x-cpio'),(18,'est','Dignissimos ut sit ut. Sint dolor excepturi dolorum voluptates. ',NULL,'tmp//33d96130da5b004a0f05d8aa6ea82746.jpg','dolore','application/x-ms-shortcut'),(19,'eligendi','Eum sit sit totam est fugit vel. Suscipit itaque quod et ab moll',NULL,'tmp//78226689ecd6a3432186fdbc1404396a.jpg','praesentium','application/zip'),(20,'consequatur','Nam sint qui eum. Quidem dolor ut velit quo qui. Eum hic dolorem',NULL,'tmp//5e406c3a884ca06c80182d47ca77fd48.jpg','debitis','application/vnd.ms-powerpoint.slideshow.macroenabled.12');
/*!40000 ALTER TABLE `Avatar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Daily_Record`
--

DROP TABLE IF EXISTS `Daily_Record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Daily_Record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `kcal_burned` int DEFAULT NULL,
  `kcal_intake` int DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `status` int DEFAULT NULL,
  `created_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `Daily_Record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Daily_Record`
--

LOCK TABLES `Daily_Record` WRITE;
/*!40000 ALTER TABLE `Daily_Record` DISABLE KEYS */;
INSERT INTO `Daily_Record` VALUES 
(1,1,443,1437,'Harum consequatur qui consectetur.','Voluptatibus iure et quo. Voluptas et cum sed exercitationem eum ea autem.Illo architecto asperiores qui enim ut. Itaque quia et id maxime. Minima possimus quas eum vel sed rerum.',2,'2021-08-30'),
(2,1,317,554,'Illo illum omnis molestias optio dolor.','Nisi perferendis autem fuga sapiente. Dolor iste corporis numquam omnis quis eum incidunt. Quibusdam dolorem eaque laudantium minima eos inventore veritatis.',1,'2021-08-31'),
(3,1,289,347,'Quo molestiae qui consequatur.','Sapiente expedita odit sunt et. Nam ex deleniti quo sequi exercitationem. Illo aut quos et qui.',2,'2021-09-02'),
(4,1,341,1652,'Cumque temporibus et et quo sunt omnis.','Illum ut officia et voluptatem nesciunt voluptas omnis. Sapiente dolor alias sed et. Expedita facilis sint similique veritatis voluptatum temporibus molestias. Adipisci cupiditate et id aut est.',1,'2021-09-03'),
(5,1,360,255,'Odit fuga cupiditate voluptas magni assumenda quasi id.','Rerum ea ut molestiae doloremque. Autem sunt fuga culpa illum. Asperiores minus eaque officiis maiores.',3,'2021-09-06'),
(6,1,492,1419,'Cum neque incidunt molestiae repudiandae accusantium.','Itaque esse adipisci numquam soluta necessitatibus delectus enim. Sunt ut optio iste veritatis. Blanditiis id dicta et est. Culpa possimus odit dolorem quis commodi praesentium saepe.',1,'2021-09-07'),
(7,1,494,941,'Quod facere commodi dolor eaque.','Ad occaecati maiores non. Et quas cupiditate ut iste ad. Laboriosam labore itaque ratione voluptatem accusamus enim inventore.',2,'2021-09-08'),
(8,1,411,1412,'Est nihil autem ad vitae ad repudiandae eos.','Et recusandae dolore aspernatur libero. Saepe placeat soluta totam repellat et inventore saepe. Sed voluptatem vel accusantium illo ut.',3,'2021-09-09'),
(9,1,189,1070,'Quo unde et esse esse sit.','Minus similique tenetur necessitatibus totam animi optio. Eos labore fuga aliquam corporis consequatur aut libero. Ut error quod harum qui odio ut voluptas. Molestiae itaque qui delectus mollitia.',1,'2021-09-10'),
(10,1,237,1696,'Rerum et aliquam excepturi ratione perspiciatis.','Quam tenetur et exercitationem facere porro quia voluptates et. Qui expedita voluptatibus hic aut sed. Itaque excepturi ea aut sint. Sunt voluptatibus sit debitis distinctio.',2,'2021-09-12'),
(11,1,76,928,'Debitis saepe impedit molestiae voluptatum harum.','Vero autem perspiciatis rem labore quidem incidunt perferendis. Quidem et eaque nihil soluta et adipisci. Qui tenetur fugit sapiente vel. Eos at quae quam atque deleniti quod laboriosam.',3,'2021-09-13'),
(12,1,182,1914,'Temporibus quae officiis assumenda reprehenderit repellat voluptatum.','Voluptas nam ab natus aperiam. Tempora illo velit et rerum aut esse libero quos. Velit exercitationem et quam numquam quis tenetur et nam.',2,'2021-09-14'),
(13,1,308,988,'Ipsam omnis ut repellendus.','Harum recusandae atque rerum et iste occaecati. Dignissimos iure ut asperiores ad in soluta provident. Voluptatem libero commodi sint eveniet.',3,'2021-09-16'),
(14,1,75,508,'Vero sed magnam eos reiciendis eligendi non beatae.','Itaque ea aliquam beatae molestiae quis. Rerum ullam sed asperiores corporis dolor. Consequatur dolorem cupiditate voluptas sequi voluptas molestiae. Est quis sed qui dignissimos quia.',1,'2021-09-17'),
(15,1,164,478,'Dignissimos nihil ab beatae accusamus.','Dolorum necessitatibus quod ex expedita odio. Vero beatae quod facere dolor consequatur. Velit tenetur dolores natus ut accusamus praesentium.',2,'2021-09-19'),
(16,1,470,505,'Facilis rem consequatur quia possimus iste quos vel.','Cupiditate vel iste suscipit saepe qui. Doloribus soluta nesciunt cupiditate nisi dolores omnis. Esse quia et odio velit ea enim provident.',1,'2021-09-20'),
(17,1,347,428,'Autem placeat qui unde aut assumenda in quia velit.','Tempora architecto perspiciatis aut architecto voluptas illo. Provident alias dolores nostrum consequuntur tenetur id similique.',1,'2021-09-21'),
(18,1,64,273,'Aliquam pariatur quas eum rerum vel quia.','Ea voluptatibus consectetur iusto aut magni. Non aut fugiat aut sint et recusandae. Voluptatem qui eum sed ut minus non sed.',2,'2021-09-22'),
(19,1,98,1889,'Aut quis voluptas repellat at eveniet sunt.','Tempore impedit eos vitae non. Aut eum nemo deleniti. Doloremque qui natus exercitationem aspernatur quod aperiam perspiciatis dolorem.',3,'2021-09-23'),
(20,1,22,1501,'Nisi maxime fugiat ut voluptatum.','Nostrum quia provident quo doloribus est deleniti dolorum. Ea qui et commodi impedit corrupti adipisci. Similique tempora et rerum et consequatur. Quo non voluptas perferendis nisi quia totam neque.',1,'2021-09-24'),
(21,10,459,283,'Dignissimos itaque amet accusantium voluptatem ipsum fugiat voluptatibus.','Iste asperiores sit voluptate id. Et sunt tempora voluptatem excepturi exercitationem sit occaecati.',2,'1978-11-04'),
(22,6,130,602,'Aspernatur consequatur asperiores animi.','Sequi et itaque vel nihil voluptatem. Vitae temporibus quas impedit dolor odit dolorem hic. Aut velit pariatur quis facilis vero quas ut.',2,'2014-10-01'),
(23,35,8,1608,'Velit odit et aut tempore quia perspiciatis placeat.','Labore commodi unde eligendi odio officia veniam. Cumque nam voluptatem ut voluptatem labore exercitationem aperiam. Non placeat accusantium ut ipsa ex soluta.',2,'1990-01-06'),
(24,28,139,461,'Sint excepturi consequatur et neque exercitationem illo.','Repellendus voluptate est est. Ullam distinctio expedita nihil. Consequuntur inventore quis exercitationem sit impedit. Esse non non non dolores exercitationem assumenda.',3,'1992-07-23'),
(25,38,316,859,'Aliquid repellat incidunt et ullam atque hic.','Libero nemo ab architecto id quia. Officiis consectetur cupiditate consectetur placeat molestias officia et. Numquam et velit laboriosam sequi temporibus. Labore rem officiis totam et occaecati.',1,'1972-10-25'),
(26,13,304,1498,'Repudiandae incidunt et et culpa nesciunt facilis.','Dolorum earum voluptatibus cumque. A repellat corporis similique possimus quia fuga reprehenderit est. Fugit quidem animi porro veniam. Fuga consequatur eligendi sunt numquam.',1,'1990-09-01'),
(27,2,477,577,'Assumenda debitis sed exercitationem nihil.','Dolorem minus fugiat fugiat tenetur cupiditate consequatur minima. Totam officiis autem et.',3,'2021-09-01'),
(28,39,330,719,'Cum voluptate non delectus quia soluta.','Autem est necessitatibus saepe. Rerum sapiente placeat labore dolor aliquid vero.Nihil voluptas commodi tempora quia earum. Qui consequuntur unde consectetur et quasi non.',3,'1986-04-05'),
(29,28,455,1736,'Eius illo laborum at.','Quibusdam at et illo fuga accusamus repellendus. In ducimus ipsam inventore nisi asperiores aliquid omnis. Et et occaecati eaque rerum animi consectetur.',1,'1973-07-13'),
(30,7,272,575,'Quis alias culpa autem omnis voluptatem et.','Iure tempore deserunt tempore vel. Neque ipsam illo distinctio. Delectus repudiandae qui sit animi. Quia esse qui veniam in rerum molestias sunt.',2,'1991-02-16'),
(31,20,181,581,'Magnam aliquam repellat quia rerum perspiciatis.','Veniam temporibus quas error aliquid. Ullam vero eos qui ab molestiae cumque sit totam. Et tempore explicabo facere impedit illum enim asperiores voluptatem.',3,'1995-07-30'),
(32,7,327,724,'Totam error dolorem saepe corrupti non.','Dolor eos ad autem fuga quibusdam. Quia maiores voluptatum facere cumque voluptates neque. Provident vero et ut expedita molestias.',2,'2021-09-10'),
(33,27,86,1966,'Iste magni voluptas est sunt soluta exercitationem.','Est minima impedit voluptatum pariatur unde. Et consequuntur maxime sit nulla est ut. Dolores doloremque hic qui expedita. Minima dolore maxime ut rerum sunt.',2,'1970-11-28'),
(34,6,79,1335,'Quis nihil sunt magni doloribus deleniti nobis iure dicta.','Aut impedit exercitationem aut corrupti. Et quidem eos nihil fuga vitae assumenda vitae. Earum nesciunt libero consequatur alias aut.',3,'2002-04-27'),
(35,38,215,1426,'Libero sit nemo numquam.','Exercitationem delectus est consequatur provident suscipit. Molestias non pariatur minus eos. Quidem sint et quisquam qui accusantium rem qui.',3,'1990-03-15'),
(36,7,375,1885,'Aut nesciunt molestias aut.','Pariatur ut reiciendis repudiandae nemo. Voluptatem repudiandae ipsam velit amet asperiores unde. Cum suscipit veritatis pariatur. Eveniet voluptatum quaerat nisi delectus dolore blanditiis cum esse.',3,'1990-07-11'),
(37,19,396,49,'Et fugit eum sit voluptatem.','Atque id officia sapiente amet ipsam aut nemo. Optio maxime qui magnam eum soluta. Aut nihil porro nisi neque quae ipsa repudiandae. Non consectetur beatae sit soluta vel.',3,'2017-07-12'),
(38,40,399,1340,'Dolores natus sit qui omnis sit vel.','Commodi et sed dolores velit facere consequatur. Ea rerum nulla voluptatem provident ad. Alias error eveniet consequatur possimus.',1,'2007-01-12'),
(39,8,102,256,'Illo tenetur facilis omnis est in.','Laudantium odit veritatis autem ad debitis ea. Ratione doloribus cum officia commodi labore facilis eum doloribus. Et ut illum sit. Ut omnis illo dolores sed error dolorem quia.',3,'2021-09-12'),
(40,6,79,861,'Autem vitae praesentium laborum et et reiciendis veniam.','Itaque eos tenetur quis a et deleniti. Perspiciatis dolorem accusamus similique ut laboriosam placeat. In tempora nam ratione doloremque velit.',1,'2000-10-27'),
(41,6,259,1487,'Occaecati voluptatem dolor ducimus delectus porro non temporibus.','Maiores quisquam excepturi magnam quasi. Laboriosam similique soluta eveniet. Ducimus saepe eum illo consequatur ut maiores error et. Consequatur unde ullam praesentium et.',2,'1993-12-10'),
(42,24,363,1961,'Et dolorum nostrum ut.','Earum sunt aut mollitia possimus sequi. Molestiae quibusdam voluptatum sed optio. Libero inventore inventore dicta voluptas. Numquam ratione at enim veritatis repellat.',3,'2016-08-02'),
(43,29,256,658,'Voluptatum et facilis fugiat placeat.','Non et rem provident in porro laboriosam aperiam. Sed est consectetur quisquam molestiae. Totam dolorem rem fugit rem soluta reprehenderit. Odio dolore eum aliquid ut voluptas ut id et.',3,'1997-06-22'),
(44,40,163,1881,'Quo voluptatem accusantium suscipit quo eum.','Accusamus sequi perspiciatis assumenda minima. Commodi amet pariatur fugiat suscipit. Cupiditate amet qui distinctio nemo aspernatur.',1,'1972-03-22'),
(45,25,441,1543,'Expedita enim ipsum est quis repellat architecto alias.','Natus deserunt autem veritatis. Voluptatibus provident atque quo distinctio.',3,'1998-03-14'),
(46,6,323,1851,'Vel est quo et.','Odit dolor illo omnis sint. Maxime sunt rerum consequatur officia sapiente. Qui voluptatem sed architecto. Et sed laudantium laborum qui natus explicabo sunt.',1,'2015-03-20'),
(47,17,440,1346,'Eum corporis aut dicta.','Minus debitis blanditiis harum eos asperiores dolorem. Id eum pariatur animi dolor cupiditate. Consectetur dolor ut ipsum voluptas doloremque ea laborum.',1,'2014-08-20'),
(48,20,468,1566,'Et fugit sed occaecati sunt consequatur incidunt eum enim.','Dolor numquam dolor est omnis at nesciunt nobis. Suscipit quae sit et qui. Consequatur corrupti dolorum vero qui non perferendis tempora.',3,'1980-07-31'),
(49,27,417,1544,'A nobis perspiciatis quas rerum a autem.','Itaque dicta culpa vel quo deleniti earum consequatur dolores. Molestiae incidunt consectetur enim itaque molestiae sunt veritatis. Voluptas nemo deleniti veritatis adipisci.',3,'2007-05-18'),
(50,22,291,585,'Rerum omnis qui natus.','Eum ut cum accusantium. Tenetur repudiandae architecto rerum quae ut quidem ut quibusdam. Et nulla ipsa ab voluptatibus.',2,'2010-05-26'),
(51,12,377,1133,'Ratione eius ab magni et.','Suscipit quod qui dicta. Aut provident similique ducimus et eos blanditiis. Id excepturi odit eius et veniam. Nihil aliquam eos incidunt error fugit.',2,'1977-06-04'),
(52,36,329,1716,'Deleniti labore sint quia.','Excepturi quia eos dolorem magni asperiores. Sunt recusandae ea ut fuga fuga. Voluptas ut inventore sint qui consequuntur non. Non veritatis ipsa natus.',2,'2012-12-03'),
(53,27,198,1796,'Aliquam asperiores officia praesentium.','Est quibusdam cumque quia. Consequatur nesciunt iste dicta quasi sunt ad. Sed sunt accusantium inventore dicta.',3,'1987-10-24'),
(54,6,163,1166,'Et consequatur quae eius amet.','Quos tempore similique ea eaque. Ipsa non cumque aspernatur alias earum quasi. Id tempore animi natus hic. Doloremque laborum nemo quod.',1,'2006-08-09'),
(55,24,474,276,'Et expedita nesciunt architecto consequuntur deserunt quibusdam quia.','Eaque voluptatibus labore consequuntur aperiam nihil reiciendis dicta. Eius autem aut voluptatem reiciendis neque. Eos atque eveniet nihil quasi sequi. Quos in voluptatem nihil suscipit eaque.',2,'2013-02-13'),
(56,24,493,347,'Corporis hic minima et fugit.','Odit ad eos rerum autem laborum voluptas. Quibusdam provident soluta sed pariatur neque dolores omnis. Nihil quo ex eligendi alias est. Nulla qui molestiae vel molestiae. Ut minima a repudiandae id.',2,'1984-09-28'),
(57,19,210,444,'Similique doloremque nesciunt ducimus harum.','Quo sit et doloribus. Dicta quam excepturi velit qui consequatur. Magnam soluta facilis qui et dolorum praesentium consequatur. Aliquam esse aut sit ipsum vero.',2,'1985-02-09'),
(58,26,498,708,'Porro fugiat et autem rem.','Temporibus sit nam quis id id magnam et. Illo dolorum doloribus sapiente.',2,'1989-06-05'),
(59,22,151,158,'Sunt earum culpa similique soluta et sint velit fugit.','Omnis et magnam sed nam. Reprehenderit consequatur numquam aut blanditiis molestiae minima sit. Voluptates rerum ea pariatur quam voluptatem aut quo. Explicabo architecto voluptatem odit enim.',3,'1981-02-13'),
(60,7,322,219,'Quibusdam et praesentium laboriosam consectetur.','Laudantium autem eos earum nihil fugiat eaque ut. Non aut omnis et rerum. Ipsam et sed deleniti maxime commodi doloremque sint. Libero praesentium commodi ullam.',3,'1979-12-26'),
(61,32,409,738,'Nobis necessitatibus ad totam ut eum quo voluptatum.','Praesentium aut accusantium modi nesciunt dolorem. Dignissimos voluptatem officiis est quas consectetur. Ea nesciunt suscipit labore corrupti blanditiis.',3,'2013-09-05'),
(62,41,378,1132,'Nam dolores aspernatur sint molestias sed.','Sed architecto accusantium excepturi quia quam repudiandae molestiae. Ex molestias placeat asperiores laboriosam modi ipsa ut. Mollitia voluptatem ut eos molestias.',1,'2021-08-13'),
(63,10,204,2,'Tenetur sed dolor aspernatur doloribus atque.','Natus vitae ea excepturi autem est. Id nostrum rem sint odio. Nostrum praesentium aut eligendi. Alias fugit dolorem quod incidunt dolore.',1,'2001-06-09'),
(64,19,397,235,'Dignissimos id non voluptatibus est.','Perspiciatis rerum quas quia rerum. Eum aspernatur consequatur velit eos hic vel earum. Aspernatur incidunt expedita ea animi quod optio.',2,'2008-06-05'),
(65,8,321,1620,'Id aut velit eos vero eaque assumenda minus.','Deleniti ea et doloribus aut non. Suscipit non id voluptas velit quia. Sunt enim atque quia beatae architecto. Facere dolorum est unde rerum quo.',3,'2008-06-10'),
(66,8,395,277,'Quia exercitationem unde officiis et quis assumenda.','Voluptatem qui quisquam aut nemo dolorem id earum. Et in illum sed sed sunt. Est saepe fuga eligendi illum minima molestiae.',1,'1993-08-12'),
(67,26,247,1044,'Rerum et dolorem quia ut fuga veniam.','Dolor quaerat recusandae harum aut voluptatem. Quisquam quo vero dolores et porro consequatur. Dolor et sequi labore omnis odit. Enim qui unde illo nisi fugit et. Nobis saepe consequatur odio cum.',2,'1997-08-26'),
(68,26,456,1476,'Consequuntur cupiditate et modi optio ut sit.','Quo dolores minima est possimus quo maxime. Dolores aliquid nostrum rerum soluta.',3,'2005-06-28'),
(69,8,136,569,'Animi ipsum ea explicabo dolore magni distinctio aut.','Molestiae debitis ut voluptatem omnis. Animi perspiciatis quia soluta nemo recusandae.',3,'2017-10-31'),
(70,29,483,344,'Nam laboriosam quis vitae consequatur velit.','Id asperiores aut ea est. Rerum perspiciatis autem nihil accusamus. Consequatur esse cupiditate facere voluptatem quis inventore incidunt. Eum enim rem et.',3,'2003-04-06'),
(71,32,435,1956,'Dolorum natus sint est ea fugit dolorem aut.','Eos non dicta quo enim et provident. Ut veniam ab laborum nihil. Odit ut doloremque pariatur amet quasi natus ipsa.',2,'1998-09-06'),
(72,41,210,878,'Aliquid eveniet velit expedita dolorem aut explicabo aut pariatur.','Qui accusantium tenetur architecto neque perspiciatis assumenda ut. Saepe sunt quasi maxime ab. Quam praesentium deleniti reiciendis repellat.',1,'2021-04-18'),
(73,13,414,1263,'Et sed et cupiditate possimus.','Facere ipsa dolorum animi odit laboriosam dolorem voluptatem ut. Aut voluptatem accusamus reiciendis. Ratione ducimus aut voluptatem magnam non quo. Et deserunt voluptate culpa.',1,'1992-07-28'),
(74,20,473,666,'Quibusdam ut voluptatem molestiae aut.','Minima iure corporis vel tempore quo eos ex. Vitae ad natus impedit possimus blanditiis cupiditate veritatis.',2,'2010-03-04'),
(75,13,494,718,'Beatae voluptates repudiandae voluptatem ratione reprehenderit animi rem illum.','Nesciunt et reprehenderit ut. Voluptatibus qui perspiciatis id ex et dolor consequatur aliquid. Possimus non eius autem quis suscipit est.',2,'1998-09-06'),
(76,37,84,1258,'Et quo qui cumque rerum.','Enim et veritatis cumque rerum quia adipisci dolorem. Repudiandae voluptas eaque corrupti sint iste suscipit consectetur. Vero fugiat et et aliquid eos.',1,'1982-03-11'),
(77,26,407,1196,'Et laudantium vel qui vel in placeat ut.','Amet voluptas iste dicta dolores. Sed quis unde dolore. Et quam laboriosam quia odio ipsa.',2,'2005-07-04'),
(78,29,304,1200,'Aut est impedit asperiores voluptatum excepturi perferendis tempore consectetur.','Iusto aut quibusdam sit et laborum. Nostrum voluptatem maiores sint dolorem voluptatum. Occaecati sint numquam ea commodi blanditiis ducimus sunt.',1,'1990-02-06'),
(79,41,290,639,'Ipsam ratione consectetur voluptatem sunt ut similique quia.','Doloremque vero odio quas saepe. Explicabo eius et ducimus voluptas. Reiciendis quasi dolores dolor quia. Ratione optio placeat est neque totam.',1,'2021-08-12'),
(80,12,88,121,'Quis at voluptas provident assumenda qui.','Inventore ut ut voluptatibus mollitia officiis quia. Nihil aliquid vel sit eius. Est quia corporis porro facilis.',1,'1993-09-14'),
(81,41,208,1863,'Non est illum laborum.','Molestiae rem aspernatur omnis rem est. Dicta omnis magnam non consequatur cupiditate ut.',1,'2021-08-02'),
(82,28,98,1073,'Odit ut enim quidem accusantium rerum accusantium.','Iusto aliquid exercitationem omnis atque totam similique dolorem. Doloremque nesciunt sequi ipsa quia. Deleniti quos rem asperiores deleniti minus sed.',1,'1992-02-04'),
(83,8,270,1619,'Exercitationem incidunt illo dolore ipsam.','Error eos est qui ducimus et. Odio maiores cum harum id sint sint eos placeat. Est est labore unde expedita inventore magnam adipisci. Labore sed cum in magni et ut quis.',2,'1991-06-12'),
(84,37,20,1851,'Facilis eos magnam quae dolor incidunt atque maiores deleniti.','Iure saepe ut libero. Non doloremque voluptatem culpa magni eveniet ut magnam. Vel enim et sint dicta ipsam veritatis.',2,'1982-11-30'),
(85,34,342,1229,'Dolor iure ut velit earum unde.','Sapiente qui eaque ut possimus occaecati. Delectus dolorem et deserunt quisquam praesentium sit ut dolorem. Aut et qui facere quos laborum.',1,'1973-09-19'),
(86,31,47,451,'Unde dolor quo repellat vel.','Asperiores sit eligendi et molestiae. Voluptas corrupti consequatur quia voluptatum. Labore soluta enim modi voluptas.',1,'1972-08-12'),
(87,20,170,1707,'Corporis dolorem minima tempore est maxime qui.','Velit quas esse nisi est. Quia ut vel consectetur enim laborum nam.',3,'2006-07-31'),
(88,13,0,766,'Eaque nostrum enim repellat commodi.','Ut voluptatem est itaque rerum. Inventore accusamus sapiente dolorem qui quo assumenda qui. Voluptatem iusto odit qui sapiente ipsa mollitia. Esse odit sint qui reiciendis et id.',1,'2009-01-25'),
(89,16,20,1816,'Quae dolor molestiae quae libero temporibus.','Alias corrupti qui ratione corrupti corporis ad modi ea. Perspiciatis quia molestiae ipsam incidunt sunt enim ab ut. Labore nulla voluptas inventore occaecati et in quae quaerat.',3,'2007-11-22'),
(90,8,221,513,'Laborum est id tempore quia inventore sunt praesentium in.','Ipsa odit id earum reiciendis quibusdam rerum. Non explicabo numquam minus voluptatem adipisci. Est dolorem quas eum dolor ipsa. Ab eveniet est perspiciatis dolores.',3,'2021-09-01'),
(91,19,453,845,'Amet porro error aperiam nihil quae aut.','Distinctio iste blanditiis omnis ut ratione. Nobis animi non repudiandae. Id voluptas architecto deleniti quidem. Architecto quae placeat aut fugiat.',1,'2002-02-24'),
(92,8,428,1683,'Deserunt consequatur quod sunt voluptatem vero quis.','Quisquam eveniet et hic qui. Qui repudiandae porro saepe alias autem repellendus perspiciatis. Ex placeat hic impedit modi adipisci.',3,'1987-07-01'),
(93,8,177,1120,'Quisquam quos voluptatum similique qui mollitia qui porro.','Sed ducimus in consequatur quibusdam expedita similique. Quam qui molestiae voluptatem quis excepturi aut. Eum et doloribus necessitatibus consequatur.',2,'2021-09-13'),
(94,29,26,1777,'Culpa autem dignissimos dolorem ducimus.','Assumenda laudantium et consectetur optio. Consequatur placeat voluptatem ipsa dolorem optio ducimus. Cupiditate incidunt labore qui suscipit.',1,'1983-01-08'),
(95,26,140,1398,'Et voluptate sunt delectus debitis eos culpa.','Nulla eum rem ut fugit autem libero. Maxime sit alias voluptates sunt architecto dolorum. Animi voluptate aut qui dolor ut hic modi.',2,'1984-08-30'),
(96,11,397,1062,'Itaque enim tempore quasi nihil culpa.','Labore recusandae ut molestiae est rerum reprehenderit ipsam. Eos voluptates sunt ut ipsa repudiandae eos. Quo dolore eveniet eaque. Voluptate ut qui voluptas quod. Corrupti id et et rem ullam quo.',1,'1971-01-17'),
(97,36,143,1625,'Laboriosam quis ipsam sit ratione soluta et quam.','Ea eos reiciendis iusto quisquam tempore cumque dolorem. Sed praesentium vero eligendi magni numquam ea natus. In ad mollitia quam eius.',2,'1975-05-22'),
(98,12,28,495,'Ad labore qui asperiores expedita voluptas voluptatem.','Sed culpa et est doloremque et commodi. Rerum sit tempore magnam ut et fuga veniam. Accusantium dolore fugit ut nobis laudantium eos.',2,'2014-12-13'),
(99,36,377,1336,'Autem iusto doloremque esse et labore similique.','Temporibus voluptatem tenetur odio ea quidem. Officia dolor sed aperiam quas eum.',2,'1999-08-21'),
(100,7,345,230,'Sed molestiae perferendis et aut sed.','Et sed distinctio reiciendis. Id beatae aliquid quis.Fugiat sit voluptatem odit. Sequi quis officiis voluptas nesciunt dolores. Non id impedit ratione sed.',1,'2021-09-14'),
(101,40,491,1599,'Fuga ullam officiis qui illum consequatur quas.','Odio quo porro impedit ab. Non vero amet ut commodi molestiae. Aliquam dolores beatae et. Ducimus et quas recusandae non sunt harum.',1,'1988-03-23'),
(102,28,56,673,'Architecto qui minus sit qui.','Nobis et aut ullam debitis ut aut. Dignissimos omnis consequatur odit dicta non. Sunt sed voluptas est animi vero dicta est. Error nemo quibusdam explicabo architecto. Odit fugiat enim itaque.',1,'1994-03-25'),
(103,17,192,1729,'Omnis inventore qui ut et.','Cum aut fugiat voluptatibus officiis. Explicabo ut expedita debitis accusamus aut error. Voluptatem quaerat perferendis est. Nisi ut nostrum similique. Est impedit illo voluptate dicta.',3,'1995-09-11'),
(104,13,274,55,'Magnam autem laboriosam natus consequatur laboriosam et.','Totam est voluptas consequatur at eius. Minima explicabo neque labore non. Eos nesciunt eaque vero sed. Mollitia maxime inventore sit dolore. Sed eos harum quaerat molestiae id eum ipsum animi.',2,'2015-12-11'),
(105,7,472,95,'Temporibus quo enim odio et blanditiis enim veniam.','Non beatae est dignissimos. Eum qui vero accusantium dolorem itaque consectetur. Reprehenderit ad sunt labore enim minima.',1,'2013-06-03'),
(106,29,433,550,'Aliquid itaque ea similique ullam.','In necessitatibus eligendi et impedit in architecto dolor rerum. Esse ex vel et odit. Ut quae non fugiat ut earum. Dolore optio aperiam repudiandae quis ea.',1,'1978-10-19'),
(107,9,153,467,'Possimus beatae itaque dolor ipsum ab maiores qui.','Aperiam enim et aut soluta facilis. Sed facilis atque architecto.Consequatur iusto esse atque. Est rerum aut est sed.',2,'1982-06-01'),
(108,32,248,345,'Debitis et necessitatibus autem voluptas consequatur minus.','In et enim perspiciatis quidem error velit. Porro qui ea voluptas mollitia. Ipsam distinctio ipsum ipsam dolore animi possimus enim. Voluptates explicabo consequatur ut nesciunt.',1,'1986-03-27'),
(109,18,6,578,'Earum nemo tenetur sed illo.','Ea magni voluptatem officiis vel. Molestiae exercitationem dolorem quo assumenda tempora. Est iure tenetur nulla amet eos debitis fuga. Veritatis minus culpa non veritatis et.',2,'2017-11-04'),
(110,26,0,858,'Nulla sed repellat rerum alias qui.','Et magni quidem voluptas quia non aut. Aut nemo aut fugit eligendi eaque repellendus earum. Dolorum praesentium fugit incidunt est at dolor illo.',3,'1995-10-31'),
(111,7,439,1926,'Veniam animi assumenda eos fugiat.','Nostrum fuga cum aut mollitia. Ut velit quam nobis doloremque velit. Ut ut adipisci et officiis nihil. Voluptas sit neque ex nesciunt assumenda.',2,'2021-09-16'),
(112,27,142,126,'Laborum esse vitae quisquam.','Illum ut reiciendis expedita et adipisci eos. Non fuga ex cumque fuga. Est praesentium sit culpa deserunt ea sit reiciendis illum.',2,'2010-05-30'),
(113,14,370,920,'Autem qui labore praesentium culpa molestias assumenda.','Dolorum facilis dolores est quod sit. Voluptates et aspernatur magnam asperiores. Eum libero voluptatem et quis tempore eos.',2,'1995-01-09'),
(114,11,471,406,'Perspiciatis qui tenetur voluptas labore ipsam aliquam.','Odit alias laudantium sed nam. Eaque tempora vel quia nihil. Error optio aliquam consequuntur ea voluptatem quos. Facere aut voluptate laudantium commodi.',3,'1990-01-20'),
(115,23,72,1570,'Culpa odio eligendi numquam.','Eaque tempora dolor praesentium vero. Dolorem itaque alias qui hic. Magnam quisquam nam quis quaerat cumque ipsum consequatur. Non quia illo est nesciunt.',1,'2013-01-11'),
(116,7,366,910,'Ut voluptatem eius aut quod ut vero ut.','Vero veniam et magni ut. Doloremque saepe fuga odit autem omnis. Dolorem inventore voluptatem voluptatibus aspernatur neque. Assumenda est quia sint et.',1,'1995-09-11'),
(117,5,277,1441,'Vero et dolor qui nobis et.','Quis consequatur magni atque et aut a numquam. Aperiam excepturi nobis eligendi ea ratione aut. Rem et vitae sed quod quam id est.',3,'2021-09-03'),
(118,6,370,1638,'Nesciunt nihil dolor eaque.','Autem qui et occaecati adipisci. Ut eum quae quos aperiam nobis qui consequuntur. Aut ut adipisci vitae totam. Reiciendis et impedit quod quis deleniti.',2,'2021-09-08'),
(119,20,387,72,'Et perspiciatis et animi occaecati facilis.','Ullam architecto voluptatem voluptatum. Ullam illo repudiandae quibusdam. Ipsam tempora ullam deserunt nisi. Maiores nihil corporis eum doloremque.',3,'2020-02-25'),
(120,17,85,1806,'Sit nostrum et autem labore rerum in.','Quam ab est saepe odit porro. Sint quod ipsum dolor consequuntur. Adipisci aliquam officiis qui ut doloribus dolores et.',1,'1971-03-31'),
(121,5,104,1959,'Facere et odit sed atque.','Nemo ipsam et et quo dolor et sit. Ullam totam officiis repellat est.',2,'1975-06-01'),
(122,38,62,997,'Velit distinctio fuga dignissimos.','Vel ut temporibus officia magnam laborum soluta excepturi. Dicta animi placeat amet esse.',2,'2005-02-26'),
(123,41,69,1395,'Et quaerat pariatur voluptatibus et ad aspernatur.','Labore repellendus eum itaque qui natus sunt. Molestiae odio eaque nemo reiciendis eveniet suscipit ea. Et consequuntur ab qui soluta. Placeat voluptatem ipsam quia ab soluta nemo est quae.',2,'2021-08-24'),
(124,8,456,555,'Quia suscipit in officiis accusantium.','Facere autem rerum ducimus voluptas incidunt dolores id. Saepe molestias velit tempore. Tempore et tempora ea.',2,'2015-08-24'),
(125,27,158,1537,'Deleniti necessitatibus modi voluptas illum ipsum aut.','Sit sit ullam fuga error. Quis eligendi eum itaque voluptas rerum. Libero sapiente molestias nihil officiis dignissimos temporibus. Doloribus est alias cupiditate omnis.',2,'1985-07-04'),
(126,10,79,1151,'Soluta reprehenderit cum consequatur.','Ducimus doloribus aut est. Ipsum suscipit amet nisi. Dolore ut sunt tenetur exercitationem molestias dolores.',3,'1974-10-05'),
(127,18,456,1621,'Tenetur aut sapiente laborum nisi placeat culpa.','Minus magnam enim minus. Consequatur consequuntur laboriosam quas vel qui dignissimos. Aliquid quia id eos similique excepturi. Vero quia eaque quisquam dolor cum ea. Saepe et corrupti esse quia.',2,'1980-07-05'),
(128,22,374,430,'Recusandae et error minima distinctio accusantium consequuntur ut qui.','Eum maiores nemo enim est qui alias. Dolorem non tempore maxime impedit aut. Quibusdam voluptas cumque quia nihil et officiis nihil.',3,'2007-01-05'),
(129,21,213,119,'Dolorum eos iusto nobis architecto expedita exercitationem hic.','Laudantium exercitationem consequatur nisi possimus dolor. Laboriosam eligendi porro ut dicta. Aut minus veniam veniam vero iste iure.',1,'1995-02-09'),
(130,41,51,1881,'Cumque fugit aspernatur repudiandae minus inventore commodi ad.','Pariatur dolore et soluta repellat. Impedit molestiae dolores dolores dolor ipsum.',1,'2021-08-17'),
(131,26,446,292,'Modi molestiae dolor rerum saepe iusto natus quaerat.','Est recusandae sint optio a est eius rerum. Impedit ullam ex est blanditiis error. Aut ut est culpa. Explicabo incidunt eligendi sunt quis eum dolore quidem.',1,'2014-07-17'),
(132,21,125,758,'Quas voluptatem corporis voluptas perferendis molestiae.','Debitis dolor repellat sunt id repellendus eaque totam. Qui hic non blanditiis soluta qui molestias sint.',3,'1999-09-07'),
(133,2,37,668,'Est qui sunt et dolore.','Ut ratione ea itaque nam. Et ut qui nihil aliquam eos. Reiciendis et iure doloremque tempore cupiditate. Ea aut voluptas voluptate blanditiis doloribus aut non.',2,'2021-08-31'),
(134,4,296,598,'Quibusdam non et saepe incidunt.','Occaecati rem architecto excepturi quam. Deserunt doloribus eveniet dolores laudantium velit qui aspernatur. Sit ipsum quis et nihil ut.',3,'2021-09-04'),
(135,33,117,1483,'Ab dolorem dolor tenetur alias distinctio.','Minima aspernatur est sit. Optio sit unde non nesciunt modi vero exercitationem deleniti. Tempora facere dolores ex aut molestias quia tempore. Quia qui in praesentium aliquid.',2,'1978-07-23'),
(136,8,380,1666,'Id veniam qui hic aut.','Consequatur sunt blanditiis ipsum id blanditiis. Accusantium qui quia laudantium officia voluptatibus cumque non. Quaerat ut enim officiis aut alias aut. Aspernatur sunt rerum ut officiis.',1,'2004-09-04'),
(137,31,313,1544,'Eligendi impedit officiis sapiente et molestiae quidem reiciendis.','Voluptatem enim excepturi dolorum corporis non non. Eaque quia autem consequatur rerum cupiditate non. Quas minima minima eos provident et ex quis.',3,'2004-07-08'),
(138,2,16,995,'Eos architecto qui nihil cum laboriosam quidem.','Quod distinctio praesentium dignissimos saepe amet tempora sequi. Nostrum possimus nihil aliquid autem quae aspernatur id maxime. Est placeat eos et et.',2,'2021-09-06'),
(139,40,8,508,'Ut quod aspernatur reiciendis debitis.','Odit eos quod facere cumque. Aspernatur at voluptas qui sit ex voluptatem ut. Eligendi aut sequi reiciendis doloremque et quibusdam atque. Aut quia qui harum rerum.',1,'1988-10-02'),
(140,8,157,76,'Doloremque earum nostrum ipsam dignissimos dolor.','Ullam consequatur nostrum pariatur in ipsam. Fugiat deleniti corporis et voluptas sunt soluta perspiciatis. Ducimus in repellat cumque non quam accusamus est.',1,'2005-01-23'),
(141,27,342,1275,'Qui dolorem numquam cum sit possimus.','Libero aut est ex ut reiciendis et. Porro aliquam consequatur porro nesciunt soluta aperiam blanditiis. Iure dolores qui quae.',2,'1990-04-12'),
(142,2,69,217,'Ut voluptas eveniet tempora adipisci delectus.','Illo quasi sapiente qui quidem. Fugiat autem dolore exercitationem quis dolores minus est quia. Voluptatem libero pariatur itaque eos et. Mollitia aut accusantium non sint.',2,'2021-09-09'),
(143,34,193,1902,'Mollitia et odio optio illo voluptatem minus et.','Excepturi sit illo deleniti commodi facere. Earum qui sit et aut et vel corrupti. Occaecati excepturi ad quaerat dolorem tempora consequatur quia.',2,'2015-01-08'),
(144,40,497,1832,'Rem cupiditate atque recusandae provident debitis.','Rem est ab pariatur quo ut quia est beatae. Et incidunt et cum qui blanditiis aut. Vero asperiores dicta ut quia esse reprehenderit maiores. Beatae eum asperiores nam magnam rem error beatae.',2,'2012-08-08'),
(145,13,393,265,'Corporis sed unde qui illo saepe quia consequuntur.','A quia mollitia consequatur quia neque qui. Asperiores error totam vel magnam voluptas et beatae. Et enim debitis neque velit qui non voluptates rerum.',3,'1984-06-24'),
(146,17,123,1355,'Quibusdam exercitationem vitae dolores labore.','Voluptatibus vel nihil ut labore consequuntur numquam voluptates culpa. Eaque inventore facere repellendus eum sed et quia maxime. Sunt inventore in aut consectetur dolore.',2,'2001-04-19'),
(147,7,66,1040,'Occaecati beatae voluptatem sapiente.','Id ea occaecati porro perspiciatis provident. Et aliquid ad sequi amet distinctio quos. Aliquam in laboriosam itaque quas quis sunt. Dolores ut ut vitae et explicabo quod perspiciatis.',1,'2008-03-17'),
(148,14,156,1917,'Amet illum voluptates quod quo unde.','Aut repellat pariatur molestiae expedita veritatis nemo atque. Asperiores neque id esse dignissimos. Dicta doloribus eligendi delectus rem. Sed nihil impedit voluptas ea nostrum error consectetur at.',2,'2006-07-08'),
(149,20,122,1654,'Rerum ea excepturi alias dolores libero vero veritatis.','Esse accusamus nihil voluptatum qui. Inventore et corporis consequatur. Voluptas vel eos ab ea. Atque tempora alias deserunt nam qui aut.',3,'2016-02-24'),
(150,26,296,1250,'Similique voluptas eum laborum labore et explicabo beatae.','Est dolorem numquam eum non. Fugiat eaque odit enim perferendis. Iure facere libero aut officiis.',1,'1998-05-04'),
(151,31,281,1161,'Delectus aspernatur vel eos placeat qui qui.','Et rerum voluptate eos. Doloribus veritatis ullam et similique ducimus itaque ut minima.',1,'1978-06-18'),
(152,25,98,1763,'Voluptatibus rerum ducimus ipsa.','Ipsam distinctio recusandae mollitia ut amet tempore. Magnam quas iste tempora suscipit hic labore laboriosam. Veritatis exercitationem error eaque rerum ipsam atque.',3,'2003-03-28'),
(153,24,158,481,'Tempora ea nihil at nobis et cumque voluptatem ut.','Vel inventore autem omnis ipsum. Molestias magnam eos quas dolores. Laudantium ut hic amet necessitatibus.',2,'1979-07-10'),
(154,14,160,1988,'Sit enim ut temporibus.','Nesciunt numquam quasi dolorum repudiandae. Fuga quaerat sequi maiores. Omnis vel nisi voluptatem vel soluta quam.',2,'1989-08-13'),
(155,33,458,956,'Rerum veniam nulla qui sunt quos nemo.','Rerum et voluptates enim temporibus quam. Voluptatem molestiae voluptatem fugiat dolorum natus. Unde nesciunt molestiae consequuntur facilis.',2,'1999-08-02'),
(156,10,208,1985,'Dolores aut beatae eius ut aut architecto expedita et.','Ut rerum nisi omnis voluptatem nobis est voluptatem inventore. Sit voluptatem est ut accusamus deserunt culpa quo. Aut magnam cupiditate at aperiam.',3,'2011-03-02'),
(157,24,92,1197,'Saepe itaque est soluta qui laborum delectus blanditiis ut.','Voluptatem aperiam nemo vel dolores. Dolor officiis voluptatibus voluptatum laudantium sit asperiores consequatur. Perferendis iusto cupiditate labore impedit fugit.',3,'1979-10-21'),
(158,10,283,1087,'Aspernatur sunt ut necessitatibus officia molestias molestiae non.','Et unde enim repudiandae libero itaque et sed. Voluptas voluptatem tempora commodi sit repellendus. Commodi et et quo aut voluptates commodi consequatur est.',2,'2004-06-04'),
(159,32,115,947,'Debitis quo soluta commodi dignissimos.','Eius nam dolor repellat. Dolores suscipit impedit est est enim. Hic provident possimus quia quos voluptates occaecati ut. Fugiat animi nemo repudiandae.',1,'2003-12-04'),
(160,4,13,355,'Incidunt quod ab aut dignissimos debitis occaecati odio dolores.','Veniam voluptas enim quasi sunt quia autem saepe assumenda. Et ut nemo occaecati nobis illo. Sequi earum consequuntur laboriosam pariatur quae iure mollitia minima.',1,'2021-09-17'),
(161,24,49,485,'Est est sed ea nisi maiores.','Nihil laboriosam perferendis nihil doloremque omnis. Sit error doloremque illo tenetur quas eum aliquam. Est qui consequuntur occaecati et molestiae vel sit.',3,'1980-07-20'),
(162,17,455,549,'Iure dolorum voluptatem dolores qui deserunt eum optio.','Quae velit et voluptate qui ut. Quia enim earum soluta quod voluptatibus iste sed neque. Quam velit in dolor sed consequatur laborum.',1,'1979-03-25'),
(163,24,373,1315,'Molestiae modi suscipit ea molestiae sint labore vero.','Quia atque eligendi temporibus officia cum est. Nihil voluptates dolorem sint reprehenderit voluptates vitae provident. Libero consequatur velit sed adipisci ipsum dolor.',2,'1984-11-22'),
(164,25,458,1336,'Ipsum et error tempore temporibus nisi sunt.','Possimus est quia hic qui aut placeat. Excepturi quia nam aut exercitationem voluptas. Ea et nobis ea impedit. Velit id earum soluta repudiandae debitis nostrum deleniti expedita.',3,'1998-10-28'),
(165,18,194,1308,'Natus ea non velit culpa aperiam.','Praesentium doloribus et corrupti illo mollitia aperiam quisquam. Consectetur blanditiis ducimus a est. Modi et minima non aut.',1,'1985-03-27'),
(166,17,340,1333,'Suscipit atque et deserunt in sit quaerat.','Officiis ipsam et et enim neque inventore. Aspernatur dicta eos nesciunt occaecati. Possimus ut vel vel itaque fuga. Possimus aut est sed inventore.',2,'2014-04-13'),
(167,32,283,1671,'Quaerat odit repudiandae dicta at.','Impedit neque voluptatem aut aut numquam quasi. Reprehenderit voluptatem quis molestias sit nemo. Tenetur aut dolore id ipsa praesentium.',3,'1986-11-15'),
(168,8,205,544,'Aperiam sit blanditiis veniam tenetur dolores magnam omnis et.','Corporis optio architecto autem a. Voluptas in accusamus voluptas iusto. Maiores ut aliquam suscipit aut aliquam rerum sint. Corporis est non aut consequatur impedit eos repellendus quos.',3,'1987-08-04'),
(169,18,183,866,'Minima voluptatem qui eveniet nesciunt nihil autem ut.','Sit unde velit neque tempore eveniet dolores aliquid voluptates. Quaerat inventore rem aut et ut est ullam. Et aut iste mollitia maxime. Molestiae consectetur vel corrupti sed.',1,'1993-01-02'),
(170,31,220,61,'Illo ut dolores repellendus doloribus aperiam.','Eaque deserunt aut veniam quo. Aut aut aliquid dolor nemo. Odit sed placeat maiores sequi neque voluptatem sint.Ipsa quia quis sunt sunt labore. Voluptatum sequi facere sed quia quisquam debitis.',1,'2012-05-14'),
(171,15,242,1356,'Eos voluptatem est non voluptatem vitae possimus aut.','Architecto aliquid aspernatur voluptatem eveniet. Repudiandae fugiat sint in ea blanditiis. Quam dolore sint numquam sit aut et earum.',3,'1997-07-28'),
(172,5,118,784,'Saepe aut necessitatibus consequatur natus rem nihil vero.','Eius eos ab vel quod minima similique. Voluptatem quam aut qui culpa. Voluptate assumenda et tempore et soluta aut et.',1,'1979-11-04'),
(173,34,459,1372,'Est ut quidem dolorum nobis placeat et.','Repellendus iure sit eum id. Aut veniam ducimus aut magni sint. Perspiciatis voluptatum id laudantium magni occaecati tempore.',1,'1973-03-30'),
(174,9,45,559,'Dolorum enim ipsam quibusdam totam tempore.','Ut et perferendis voluptatem. Iusto dolor ipsam voluptatum ratione qui nobis et. Est repellendus vitae corporis. Voluptatem rem molestias ut iusto distinctio et est.',1,'2013-11-17'),
(175,5,494,192,'Velit aut velit velit cum beatae.','Laboriosam aut ut sunt laborum. Ipsa eligendi nihil molestias perspiciatis quaerat. Necessitatibus impedit deleniti error. Quam dolorem et harum amet rerum rerum. Optio quo est et maxime.',1,'2013-07-13'),
(176,6,229,88,'Laboriosam labore ut asperiores eveniet suscipit odio.','Ut eligendi ducimus ipsum cum aut architecto. Id sit perferendis ut ipsum minus. Cupiditate blanditiis aut in. Omnis molestiae fuga numquam rerum reprehenderit debitis.',1,'1990-04-06'),
(177,26,95,1288,'Qui est doloremque dolores et a vel est voluptates.','Quod laboriosam recusandae velit consequatur pariatur voluptate consequatur aliquam. Qui suscipit consequatur debitis et earum. Modi omnis officia ratione eos molestiae sed.',1,'2006-07-18'),
(178,11,128,1025,'Est fugit fugiat eos ullam illum id.','Rem aspernatur facilis aperiam velit eligendi ipsam. Sed hic numquam veniam exercitationem. Harum consequuntur dolorem commodi. Aliquid velit eos blanditiis modi.',1,'2008-10-24'),
(179,20,356,1376,'Repellat dolores natus accusamus cupiditate et voluptatum.','Aperiam rem ratione odio ex. Nulla quo laudantium sequi aut dolor. Optio quis qui est ea nisi. Libero cum soluta ad beatae.',1,'1971-12-09'),
(180,6,397,1410,'Ut sapiente numquam repellendus et sed.','Et quia voluptatem ut cupiditate ullam aliquid. Voluptate itaque necessitatibus quis voluptatem corrupti. Adipisci unde qui aperiam adipisci consectetur. Officia saepe voluptatem inventore.',2,'2001-08-25'),
(181,37,426,594,'Consequatur tenetur beatae eos.','Debitis omnis iusto delectus expedita iure accusantium enim ut. Id magni voluptatum earum. Illum impedit magnam exercitationem aut. Sint hic voluptatem expedita quia voluptatem.',1,'2004-12-09'),
(182,11,424,1483,'Sint perferendis ex voluptas distinctio facere consequatur earum.','Voluptas repellat quia ducimus et totam iure. Id animi non maxime aut molestias exercitationem ad accusamus. Fuga est commodi voluptatem eos accusamus repudiandae. Velit quis tempora aut qui beatae.',2,'2007-12-12'),
(183,30,403,1194,'Modi nesciunt amet totam deleniti quae veniam voluptatum.','Natus soluta dolor deleniti qui. Reprehenderit sunt ut aut rerum rem. Officia animi necessitatibus velit et minus alias.',3,'1979-04-27'),
(184,20,0,475,'Velit temporibus facilis et ut et hic quaerat.','Fugit numquam consequatur numquam laborum consectetur harum. Totam recusandae exercitationem optio eos. Et atque ut iure porro est. Consequatur qui vel aliquam aut quaerat.',2,'1993-01-17'),
(185,25,404,1105,'Molestiae vel odit possimus omnis est ipsum.','Itaque veniam voluptates quis. Ducimus sed accusantium ut assumenda voluptatibus. Id sint maxime qui itaque.Saepe quisquam voluptas magni. Omnis id sed facilis voluptates cum numquam.',1,'1986-02-12'),
(186,22,347,1018,'Nostrum hic animi dicta.','Autem quia vero quisquam sed temporibus neque nemo. Qui odit exercitationem enim dolor beatae dolorem ipsa.',2,'1991-06-04'),
(187,29,458,1329,'Nihil earum vitae aut cum neque.','Qui voluptatibus delectus dolores praesentium non fuga consequatur. Facere qui sunt aut nam. Quidem nisi consequatur et voluptatibus mollitia autem quaerat.',1,'1990-08-06'),
(188,8,149,1479,'Pariatur iste fuga in inventore.','Esse reprehenderit reprehenderit ut veniam deserunt nisi. Vel quibusdam et et eum. Sit enim id nobis.',3,'2013-12-30'),
(189,32,195,1406,'Voluptatem nihil esse nesciunt quasi consequatur voluptatem laborum.','Accusantium non id temporibus necessitatibus magni et inventore. Fuga voluptate alias illo nobis voluptas quidem sed. Adipisci laborum soluta soluta alias. Soluta iste est sunt.',1,'2009-10-15'),
(190,21,340,568,'Rerum nobis sequi quasi in distinctio in consequatur.','Aliquam doloribus saepe debitis et. Ut voluptatem neque maxime porro. At aut saepe quia consequatur. Quo magni est consectetur minus eaque.',1,'1982-03-21'),
(191,11,90,1853,'Mollitia itaque dolorem ipsam quia nemo ut.','Quisquam et omnis explicabo quae. Et nemo rerum fuga consectetur est. Quia et qui vel consequatur.Veniam atque corrupti labore nisi facere. Ea fugiat eum sunt sapiente aspernatur eum rerum.',2,'1977-12-29'),
(192,16,230,872,'Molestias placeat soluta sit nostrum.','Illum ea omnis quidem odit ad aut expedita. Exercitationem nulla et et aut distinctio nostrum natus. Harum quasi aut officia vel quas qui.',1,'2018-03-19'),
(193,37,81,1848,'Ea quaerat eligendi sint.','Enim quo culpa harum at. Fuga beatae debitis vel illo dolor vero. Repellat velit atque et dicta veniam quos.',3,'2013-02-13'),
(194,35,108,1706,'Tempore dolores architecto voluptas est expedita nihil in.','Vel repellendus recusandae qui impedit. Doloribus architecto quis alias. Non id atque fugiat rerum. Repellat et culpa natus magni rerum et blanditiis possimus.',2,'1998-10-03'),
(195,40,226,235,'Ut dicta necessitatibus ab porro cum beatae.','Quod temporibus dolores ut rerum est saepe. Eos recusandae voluptas reprehenderit neque. Et voluptatibus expedita consequatur est et aut beatae.',2,'2011-02-21'),
(196,15,480,356,'Voluptatem sed natus ipsam ut quis praesentium.','Neque voluptas est corporis est. Vel possimus quo omnis quia doloribus natus sequi. Quia accusamus corporis assumenda deleniti quia voluptas reprehenderit. Eum quae expedita molestias neque.',1,'1991-05-18'),
(197,12,390,750,'Perspiciatis est unde velit autem magnam tempora.','Eos assumenda ut perspiciatis eaque sequi nostrum. Et voluptas expedita accusamus ut dolor. At at veniam sunt ut animi. Ut est at ipsum odit.',1,'2015-09-24'),
(198,32,394,95,'Sint possimus minima magnam rerum rerum eaque.','Qui nisi autem totam. Laborum maxime quo quam quidem aut voluptatum dolorem veritatis. Qui eveniet temporibus et inventore id.',2,'2018-11-08'),
(199,23,67,1353,'Dolore suscipit fugit consectetur.','Neque quaerat nihil incidunt possimus. Accusantium incidunt architecto quo. Ut natus et eum quo assumenda corporis.',3,'2008-11-23'),
(200,30,174,1678,'Dolore culpa neque eveniet.','Corporis et possimus quis cumque quia eos rerum. Accusamus quia rem cupiditate dolor placeat dolores. Et ut voluptas sunt magni animi iste.',1,'1983-01-17');
/*!40000 ALTER TABLE `Daily_Record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fit_achieve`
--

DROP TABLE IF EXISTS `Fit_achieve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Fit_achieve` (
  `id` int NOT NULL AUTO_INCREMENT,
  `daily_record_id` int DEFAULT NULL,
  `fit_activity_id` int NOT NULL,
  `number_groups` int NOT NULL,
  `total_kcal` int DEFAULT NULL,
  `execution_date` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `daily_record_id` (`daily_record_id`),
  KEY `fit_activity_id` (`fit_activity_id`),
  CONSTRAINT `Fit_achieve_ibfk_1` FOREIGN KEY (`daily_record_id`) REFERENCES `Daily_Record` (`id`),
  CONSTRAINT `Fit_achieve_ibfk_2` FOREIGN KEY (`fit_activity_id`) REFERENCES `Fit_activity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fit_achieve`
--

LOCK TABLES `Fit_achieve` WRITE;
/*!40000 ALTER TABLE `Fit_achieve` DISABLE KEYS */;
INSERT INTO `Fit_achieve` VALUES (2,25,9,6,129,'1973-08-12','2000-09-24','2005-09-19 15:56:58','直接執行'),(4,44,1,2,50,'2020-11-29','2013-01-27','2007-07-26 02:18:44','按計畫執行'),(5,32,12,10,78,'2019-06-09','2014-05-18','2008-07-24 11:40:01','未執行'),(6,53,12,1,99,'1979-03-30','1997-02-25','2007-12-16 01:40:54','未執行'),(8,30,1,12,160,'1981-04-03','1983-01-13','1989-07-18 03:29:54','未執行'),(9,59,8,16,143,'1984-03-05','1982-02-28','1982-06-04 15:42:40','按計畫執行'),(10,50,5,4,184,'1996-10-29','1988-04-03','1975-06-18 19:24:03','直接執行'),(11,71,15,6,195,'1980-08-22','1997-07-18','1998-10-11 18:46:56','按計畫執行'),(12,89,8,19,155,'1976-12-07','1980-12-04','1983-12-26 03:22:10','按計畫執行'),(13,14,8,14,140,'1973-03-25','2003-05-29','2015-08-30 06:41:54','直接執行'),(14,85,3,12,52,'2015-06-10','1975-03-01','1970-08-13 07:08:19','未執行'),(15,47,4,19,73,'1980-05-08','1978-01-08','1970-02-06 18:17:22','未執行'),(16,150,15,13,48,'1998-12-15','2020-11-28','1994-04-07 05:13:39','直接執行'),(18,24,5,6,165,'2005-10-08','1984-08-16','1990-11-15 06:11:38','直接執行'),(19,169,7,20,94,'1985-03-27','1996-01-15','1991-06-29 05:55:40','未執行'),(20,52,1,20,94,'1975-01-09','1974-09-01','1993-08-27 01:54:07','未執行'),(21,184,11,1,197,'1973-04-08','1996-04-25','1976-04-15 12:09:39','直接執行'),(22,118,10,2,25,'1994-01-10','2002-05-31','2012-04-13 22:34:52','直接執行'),(23,87,15,6,115,'1985-05-29','1992-02-24','2004-01-01 01:27:07','直接執行'),(24,106,15,1,6,'2002-09-20','2010-10-19','1971-08-26 09:23:12','按計畫執行'),(25,19,16,16,41,'2007-03-25','2005-06-09','1996-10-28 19:12:00','未執行'),(26,187,9,20,120,'2010-08-07','2002-05-30','1975-07-20 04:57:15','未執行'),(27,104,8,12,120,'2012-04-26','1995-08-09','2016-02-05 13:33:54','按計畫執行'),(28,160,12,7,87,'1979-06-06','1970-02-09','1980-01-16 22:17:39','按計畫執行'),(29,153,5,1,33,'1995-01-25','2012-02-18','2011-08-15 18:39:55','未執行'),(31,80,10,7,150,'1998-06-04','1992-10-08','2010-01-20 10:06:01','按計畫執行'),(32,141,8,10,6,'1986-07-11','2018-10-12','2021-04-19 22:49:21','直接執行'),(34,125,4,2,85,'1991-01-21','2018-11-21','2010-02-26 13:30:57','直接執行'),(36,37,2,4,32,'1984-12-04','1977-01-21','2007-11-18 03:27:09','直接執行'),(37,80,16,18,76,'1983-12-03','2000-03-20','1980-03-30 12:02:09','按計畫執行'),(39,101,2,1,134,'1995-10-24','1982-12-07','1994-05-16 13:36:58','直接執行'),(40,111,12,10,124,'1994-09-27','2021-02-26','1976-02-28 03:10:20','未執行'),(41,173,10,17,72,'2004-08-17','1974-09-06','1998-01-27 02:31:26','直接執行'),(42,9,8,18,85,'1999-02-27','1981-12-29','1979-01-09 11:07:38','直接執行'),(44,194,13,1,55,'2009-12-18','1981-08-10','2004-06-27 09:50:05','直接執行'),(45,12,14,1,177,'2015-09-30','2003-06-04','1998-02-28 01:04:11','直接執行'),(46,125,10,9,127,'2009-03-22','1970-06-24','1981-09-14 15:15:00','直接執行'),(47,31,7,15,30,'1976-03-21','1989-03-23','2010-07-14 22:07:23','直接執行'),(48,171,10,17,124,'1975-12-08','2005-01-22','2008-05-19 06:08:21','按計畫執行'),(49,29,10,2,170,'1989-05-05','2011-06-15','2019-12-03 15:11:05','未執行'),(50,135,6,1,148,'1971-02-27','2014-03-05','1970-10-23 16:51:51','未執行'),(52,75,16,20,147,'2007-03-17','1989-10-09','2021-06-13 11:03:02','按計畫執行'),(54,116,3,9,50,'1989-08-18','2001-06-28','1993-12-01 05:37:00','按計畫執行'),(55,4,3,1,102,'1991-04-25','1998-03-29','1987-09-28 22:39:13','直接執行'),(57,124,16,8,0,'2006-03-01','1975-08-24','2010-07-11 11:24:45','未執行'),(58,53,10,9,197,'2020-04-16','1993-06-13','1999-09-11 10:16:57','按計畫執行'),(59,120,5,5,19,'1998-05-27','2020-08-20','2013-07-02 01:13:22','直接執行'),(60,22,14,11,13,'1996-01-17','2015-08-22','2009-07-17 02:40:52','未執行'),(61,183,15,5,112,'1985-06-29','1993-08-13','1975-09-22 23:37:45','未執行'),(62,24,2,8,40,'1995-07-24','1995-02-15','1984-07-09 06:30:23','直接執行'),(64,112,4,8,58,'1996-06-12','1976-10-29','1985-04-23 23:51:47','未執行'),(65,90,5,9,24,'1976-05-25','2010-12-06','1994-12-27 20:06:24','直接執行'),(68,111,15,8,34,'2010-05-22','2008-03-03','1988-01-01 01:37:47','未執行'),(69,160,3,16,186,'1988-08-23','1985-07-23','1988-11-28 15:36:49','按計畫執行'),(71,53,11,18,4,'2011-01-20','2001-10-09','2003-02-28 23:59:46','直接執行'),(75,38,10,2,33,'1995-07-19','1975-04-27','2016-02-22 05:16:40','直接執行'),(76,113,3,18,55,'1997-04-03','2008-03-22','2020-06-27 15:06:58','未執行'),(77,40,14,2,152,'1976-02-14','2017-06-21','1987-07-07 21:47:10','按計畫執行'),(78,34,5,8,105,'1996-04-26','2016-11-09','1976-03-30 04:31:44','直接執行'),(79,130,15,12,167,'2020-06-28','2001-01-06','2012-06-29 13:17:59','按計畫執行'),(80,89,2,19,2,'2013-09-20','2005-09-19','1981-07-11 06:28:03','直接執行'),(82,179,1,11,128,'1989-03-07','1995-02-14','1998-11-19 06:39:28','按計畫執行'),(83,160,9,4,140,'2013-07-05','1992-04-18','2014-05-07 23:50:25','按計畫執行'),(84,148,12,14,82,'1977-04-03','1998-10-13','2003-04-30 19:10:42','直接執行'),(85,115,12,5,0,'2020-09-27','2015-02-24','1976-02-12 05:15:33','未執行'),(87,23,3,12,41,'1994-01-05','1984-06-16','1974-10-16 01:23:33','按計畫執行'),(88,144,9,9,55,'1971-06-08','2018-04-10','1987-06-17 22:44:01','直接執行'),(89,13,2,20,121,'2006-05-02','1981-10-01','1977-11-26 18:21:05','直接執行'),(90,64,6,2,159,'1975-08-29','2011-10-26','2001-08-24 18:26:21','按計畫執行'),(92,71,15,5,145,'2015-10-22','1998-06-25','2016-02-01 00:12:19','直接執行'),(93,111,11,6,72,'1986-02-19','1984-03-20','1996-04-09 11:36:06','直接執行'),(94,199,5,9,136,'1985-08-09','1983-10-13','2003-08-26 17:13:11','直接執行'),(95,49,9,18,43,'1992-10-13','1978-12-13','1988-12-22 10:18:35','未執行'),(96,59,4,5,39,'1999-03-13','2008-01-18','1970-10-09 16:25:19','未執行'),(97,74,4,14,68,'1995-11-28','2019-07-28','2012-04-04 03:43:13','未執行'),(98,48,4,6,12,'2012-01-15','2006-04-29','2007-12-30 23:02:26','未執行'),(100,151,4,5,155,'1993-08-30','1976-07-30','1976-01-11 13:20:44','未執行'),(101,109,4,16,78,'2012-10-13','2014-09-05','1982-06-24 19:47:27','按計畫執行'),(102,8,14,8,55,'1987-11-23','1996-05-20','1987-08-26 01:47:41','按計畫執行'),(103,55,16,7,109,'1973-01-18','1974-03-11','1982-10-19 17:45:12','直接執行'),(104,14,7,4,133,'2001-09-05','1987-05-16','2008-04-01 04:17:59','直接執行'),(105,167,8,9,139,'2013-08-12','1970-07-16','2010-01-08 00:38:18','直接執行'),(106,118,8,14,196,'1987-10-08','2019-12-07','1975-01-24 21:36:46','直接執行'),(109,92,3,14,174,'2013-11-12','2017-05-28','1986-08-13 15:43:56','直接執行'),(110,4,15,11,67,'1979-09-30','2017-06-01','1971-12-22 10:16:15','直接執行'),(111,111,7,9,14,'2004-07-22','1987-01-13','2000-03-08 10:24:36','按計畫執行'),(113,99,3,3,141,'1985-08-03','1986-05-27','2009-01-08 20:31:15','按計畫執行'),(114,17,3,16,56,'1992-07-06','1978-07-01','1970-09-01 15:37:19','未執行'),(116,64,14,13,79,'2014-12-16','2012-04-24','1985-06-10 14:19:33','按計畫執行'),(117,1,8,16,113,'1981-02-09','1991-05-30','1988-04-10 02:52:06','直接執行'),(118,61,6,7,86,'1984-03-17','2018-07-16','2005-10-10 09:59:17','按計畫執行'),(119,21,8,5,159,'1995-05-07','1975-10-04','2003-12-24 18:54:50','未執行'),(121,151,4,13,11,'1985-06-16','1991-11-12','1980-10-13 01:36:38','直接執行'),(122,64,1,14,14,'1987-02-27','1982-07-01','1995-11-13 14:35:16','直接執行'),(123,27,9,8,103,'1973-04-14','1988-07-14','2009-08-15 17:24:32','直接執行'),(124,166,12,12,30,'1992-04-16','1994-10-17','2007-03-04 03:01:10','未執行'),(126,58,3,19,27,'1986-04-25','1985-06-10','1988-06-06 21:28:32','直接執行'),(127,31,4,11,78,'2016-05-11','1980-01-29','2020-09-16 08:22:47','直接執行'),(128,9,13,9,70,'1971-04-18','2016-04-24','1999-04-23 20:33:39','直接執行'),(129,65,3,17,100,'2015-09-25','2011-06-21','1977-07-07 13:39:18','按計畫執行'),(130,152,9,13,10,'1992-09-25','1997-06-03','1986-01-05 04:46:02','未執行'),(131,192,2,5,158,'1982-01-08','1970-11-04','1983-09-15 04:39:18','直接執行'),(133,86,8,10,16,'1988-05-12','2015-10-11','1976-11-05 00:38:56','按計畫執行'),(134,47,11,7,6,'2010-03-19','1976-05-31','1978-03-28 17:01:33','直接執行'),(136,95,11,20,167,'1994-01-18','1973-12-19','1975-02-14 08:20:27','未執行'),(137,2,16,4,90,'2020-10-15','2020-02-04','2008-01-22 12:54:10','未執行'),(138,106,4,17,188,'2019-05-01','1984-06-09','1983-04-30 10:24:25','直接執行'),(139,48,8,13,70,'1974-02-25','2013-01-22','2016-09-20 09:21:52','直接執行'),(141,40,1,6,90,'1997-01-28','2012-04-01','2014-11-25 14:08:29','未執行'),(142,185,8,14,64,'2003-09-11','1994-06-19','1983-11-04 20:16:08','直接執行'),(144,199,12,12,170,'2000-03-30','2011-08-24','1975-01-24 14:59:37','未執行'),(145,18,16,9,59,'1997-07-01','2019-08-28','1991-05-15 02:36:05','直接執行'),(146,199,1,7,8,'1996-02-12','1980-03-13','1974-06-26 20:49:28','未執行'),(147,166,2,16,152,'1970-03-24','1985-03-11','1992-10-28 00:32:56','直接執行'),(148,2,6,8,18,'1996-07-11','2008-04-18','1994-07-01 06:12:13','直接執行'),(149,95,5,7,1,'2016-10-04','2014-06-04','1998-06-10 14:52:44','按計畫執行'),(150,158,5,4,171,'1995-07-09','1979-12-10','2000-06-08 08:33:22','未執行'),(151,17,6,3,195,'1973-08-12','1979-05-14','1976-06-25 03:09:07','直接執行'),(152,149,3,12,180,'2008-01-01','2000-12-10','1985-03-14 11:53:22','未執行'),(153,10,6,18,148,'2017-09-17','1980-01-27','1975-05-09 07:48:41','按計畫執行'),(154,57,6,12,87,'2009-07-09','1988-04-08','2007-08-02 21:23:32','直接執行'),(155,125,1,15,129,'2006-12-10','1974-09-30','1982-03-24 15:21:20','直接執行'),(157,16,1,9,195,'1991-05-21','2012-02-09','1971-12-11 04:11:17','未執行'),(158,35,7,12,49,'1978-08-27','1972-05-24','2019-07-21 13:44:13','未執行'),(159,195,4,16,82,'2003-11-04','1991-03-11','2010-12-26 22:36:44','直接執行'),(160,173,2,1,72,'1979-01-27','1975-10-20','1995-06-13 10:10:18','按計畫執行'),(162,22,15,19,124,'1993-07-14','1979-05-22','2021-03-31 13:46:59','按計畫執行'),(163,187,3,6,171,'1998-02-12','2013-01-31','2005-06-16 16:49:55','按計畫執行'),(164,1,9,12,26,'2005-12-21','1977-12-13','2002-08-04 22:35:42','按計畫執行'),(165,72,16,2,23,'2007-02-21','1993-02-18','2020-01-31 18:10:21','未執行'),(166,128,9,12,33,'1993-12-25','1982-05-24','2021-03-18 02:30:03','直接執行'),(167,11,8,17,175,'2003-10-25','1996-05-25','1983-03-05 02:58:05','未執行'),(168,111,3,5,105,'2018-05-04','2011-08-05','1974-03-06 14:47:12','未執行'),(170,78,6,6,168,'1996-11-16','1979-08-16','1970-07-13 00:55:39','直接執行'),(171,174,10,20,92,'1970-07-02','1982-06-27','1980-10-01 22:00:46','直接執行'),(173,97,6,17,119,'2014-07-26','1981-09-20','2009-11-27 09:51:45','按計畫執行'),(174,51,10,6,85,'1999-04-23','1998-03-17','2004-12-13 09:02:56','未執行'),(175,87,3,2,91,'1971-04-07','1987-02-14','1979-05-07 14:52:33','未執行'),(176,103,7,12,88,'1990-11-01','2001-11-17','2005-09-26 05:50:53','未執行'),(177,194,13,13,62,'1984-06-05','2015-05-01','1991-04-27 00:49:28','按計畫執行'),(179,148,2,17,196,'1978-10-13','1995-01-05','1979-06-26 03:27:47','直接執行'),(180,62,2,18,84,'1985-11-13','2018-03-23','2020-08-12 01:03:44','按計畫執行'),(183,65,2,3,130,'2017-02-05','1999-09-12','2020-06-06 16:12:47','按計畫執行'),(185,183,9,15,189,'2006-05-26','2013-10-12','2018-07-01 05:16:01','未執行'),(186,49,16,19,64,'1989-11-27','1998-03-12','2009-05-04 01:45:58','直接執行'),(187,182,7,7,90,'2002-04-05','1994-02-15','1998-06-27 08:18:05','未執行'),(188,145,8,8,175,'1998-04-09','2003-01-06','1997-01-17 01:38:22','未執行'),(190,169,1,17,85,'1999-06-13','1981-04-09','1990-07-29 03:35:43','按計畫執行'),(191,18,8,18,175,'1972-07-25','1981-06-22','1987-08-31 18:21:48','未執行'),(192,77,2,2,141,'2006-06-14','2011-08-04','1983-03-05 16:00:42','未執行'),(193,196,10,6,98,'1980-06-30','1989-03-08','2019-11-18 20:06:15','按計畫執行'),(194,192,15,18,185,'1989-11-27','1975-04-16','2005-08-19 16:06:26','按計畫執行'),(195,115,6,12,135,'2011-01-27','1971-04-02','2009-06-05 01:20:28','按計畫執行'),(196,162,10,9,166,'2012-06-01','2009-09-29','1976-02-08 13:51:23','未執行'),(197,43,7,8,37,'1971-10-15','1972-12-07','2005-10-11 02:12:49','未執行'),(198,82,11,4,171,'1983-09-23','2020-03-16','1977-11-27 11:03:37','直接執行'),(199,84,10,8,74,'1989-12-23','2007-04-04','1980-04-03 04:38:19','按計畫執行'),(200,102,7,9,30,'1996-12-25','2004-02-24','1986-10-21 23:18:56','按計畫執行'),(201,178,16,14,147,'1973-12-20','2000-12-04','1980-11-17 10:40:32','直接執行'),(202,23,16,11,72,'2017-04-14','1977-05-15','1979-05-27 00:29:36','按計畫執行'),(204,36,14,19,188,'1995-10-05','2000-02-02','1991-09-04 17:32:11','直接執行'),(205,162,1,6,118,'2012-04-23','2014-05-16','1988-07-22 14:38:28','按計畫執行'),(207,76,3,3,37,'1982-11-26','1989-07-30','1971-11-14 02:22:51','未執行'),(208,190,8,4,128,'2003-03-15','1991-01-22','2015-08-15 23:10:50','直接執行'),(210,14,4,14,157,'1983-08-02','1989-08-28','1997-09-15 10:24:29','未執行'),(212,125,8,16,49,'2002-02-18','2000-10-11','1980-10-09 21:53:23','未執行'),(213,43,1,10,40,'1980-10-13','1991-01-28','1989-12-31 11:00:41','直接執行'),(214,185,13,15,8,'2013-02-08','1979-03-26','2013-07-16 12:12:04','按計畫執行'),(215,97,9,16,115,'2004-04-17','1979-12-12','1991-08-08 07:06:31','未執行'),(216,192,8,14,154,'1988-11-12','1992-01-20','2001-06-19 08:29:23','按計畫執行'),(217,37,2,19,27,'2001-06-19','1994-07-24','1973-10-24 18:53:13','未執行'),(218,33,6,4,52,'1986-05-04','2003-10-23','1976-10-18 14:00:46','按計畫執行'),(219,181,7,16,139,'2018-11-28','2006-11-04','1984-11-01 15:06:53','未執行'),(220,193,15,11,178,'1999-03-10','1980-04-19','2006-06-09 13:14:15','按計畫執行'),(221,73,14,14,79,'2002-03-29','2015-08-15','2019-12-23 06:15:33','按計畫執行'),(222,121,15,16,68,'2008-05-25','2016-02-12','1975-05-31 07:51:00','按計畫執行'),(223,161,11,15,11,'2020-12-22','2007-10-04','1998-03-10 04:51:11','按計畫執行'),(224,18,8,18,40,'1989-01-27','1988-09-01','2011-02-03 03:36:11','未執行'),(225,92,4,5,29,'1997-12-27','1992-02-23','1995-01-16 07:43:29','按計畫執行'),(226,109,13,11,107,'2006-05-06','1983-08-30','1984-01-05 17:14:37','按計畫執行'),(227,7,4,20,163,'1993-02-02','2000-11-17','2012-08-03 16:33:33','按計畫執行'),(228,3,5,12,35,'2010-02-12','1985-09-09','2019-10-02 07:47:16','按計畫執行'),(230,175,14,18,17,'1973-07-17','2015-10-31','1990-11-03 05:43:15','按計畫執行'),(232,11,11,6,89,'1974-03-22','1990-04-11','2004-08-17 22:52:06','按計畫執行'),(233,181,5,6,33,'1987-04-03','1996-11-12','2012-03-20 18:01:15','直接執行'),(235,112,16,18,61,'2003-09-14','2003-07-25','1980-07-31 22:09:05','按計畫執行'),(237,94,3,7,96,'1971-12-24','1997-09-24','1999-07-29 02:01:51','未執行'),(238,131,6,20,26,'1986-11-20','1971-10-05','2019-07-24 06:34:56','未執行'),(239,134,15,12,46,'1999-12-22','2012-10-25','1973-09-10 14:11:16','直接執行'),(240,131,3,11,101,'2003-10-29','2002-12-27','2015-08-29 03:30:08','按計畫執行'),(241,180,4,9,169,'1974-03-31','2000-09-19','1993-11-29 20:33:55','按計畫執行'),(243,73,16,18,34,'1997-09-12','2014-03-12','1998-08-17 23:01:01','未執行'),(244,35,12,3,35,'1987-10-18','2013-01-10','1978-05-21 14:05:47','直接執行'),(245,140,1,5,51,'1971-05-26','1996-06-26','2016-02-04 04:02:49','未執行'),(246,48,2,19,118,'1972-03-25','1977-05-11','2020-02-12 18:45:56','按計畫執行'),(247,176,6,1,84,'2008-01-17','1986-04-28','1994-05-07 07:31:18','按計畫執行'),(248,120,16,10,78,'1995-08-03','1992-01-29','2006-03-07 13:13:31','未執行'),(249,101,9,11,166,'2006-10-15','2003-05-08','2009-12-14 04:16:46','直接執行'),(250,118,2,8,61,'2020-07-04','1998-09-27','1984-01-07 08:30:16','未執行'),(251,37,3,12,38,'1971-08-23','2010-10-22','1994-01-12 18:24:14','未執行'),(252,196,14,7,74,'1999-05-17','1986-07-23','1991-06-18 10:53:59','未執行'),(253,45,13,10,119,'1992-07-03','2014-07-17','1989-03-13 07:15:25','未執行'),(255,76,12,19,3,'2012-10-02','1985-08-27','1981-11-29 08:13:08','按計畫執行'),(256,4,6,2,142,'2004-01-23','1994-02-02','2018-03-09 02:17:03','按計畫執行'),(257,154,16,16,123,'2008-11-24','1998-04-10','1975-10-12 02:50:51','未執行'),(258,42,3,16,2,'2018-09-10','1972-11-24','1999-01-01 04:29:51','未執行'),(259,107,8,12,118,'1983-05-16','1983-11-28','2020-10-22 15:47:08','按計畫執行'),(260,138,5,8,62,'1978-01-09','2021-01-09','2005-05-25 19:44:28','直接執行'),(262,57,7,7,71,'1982-10-28','2007-08-11','2020-12-09 12:42:26','直接執行'),(264,18,15,18,61,'1972-10-12','1990-03-02','1995-10-16 21:39:26','未執行'),(265,58,14,2,57,'2003-05-29','1995-06-01','1978-08-24 07:59:56','直接執行'),(266,157,10,6,36,'2013-04-07','1987-11-01','1973-07-14 05:58:23','未執行'),(267,156,16,1,65,'1981-11-20','2012-12-15','2002-06-09 06:49:23','直接執行'),(268,26,1,6,196,'2018-12-03','1982-07-20','2009-11-15 02:39:21','未執行'),(269,79,1,16,150,'2009-11-29','2012-01-12','1975-11-11 08:34:31','直接執行'),(270,180,16,18,135,'2018-07-10','1986-09-15','2002-02-08 03:52:07','未執行'),(272,9,8,2,142,'1999-12-19','2017-10-16','2005-03-28 13:06:51','未執行'),(273,136,5,18,99,'2004-12-24','1979-09-30','1977-03-06 19:21:08','直接執行'),(274,104,5,5,10,'2006-08-13','2021-02-23','2016-05-15 22:21:44','未執行'),(275,126,5,17,83,'2000-06-04','2007-11-18','1972-05-27 06:18:22','直接執行'),(276,88,2,4,69,'2006-08-26','2003-03-15','1984-09-15 08:38:46','未執行'),(277,27,15,7,117,'2011-10-21','2010-11-18','2002-11-28 18:54:41','未執行'),(278,72,7,5,160,'1985-11-07','1971-03-08','2007-08-16 05:42:29','按計畫執行'),(279,121,9,11,40,'1994-09-11','1996-08-07','1979-05-18 06:23:02','直接執行'),(283,123,10,12,60,'1987-10-12','2010-10-31','1991-11-27 14:29:24','未執行'),(284,181,1,15,65,'1971-04-05','2006-11-18','2015-01-17 14:49:45','未執行'),(285,107,16,17,42,'2011-03-26','1996-12-05','1988-09-26 06:21:45','未執行'),(286,155,4,1,72,'1982-08-06','2006-02-27','1994-04-05 17:47:08','按計畫執行'),(288,108,8,3,104,'1988-04-02','2001-09-21','1972-10-17 01:23:46','未執行'),(289,13,2,18,22,'2021-08-02','1979-08-17','2003-03-24 00:28:56','直接執行'),(290,120,14,10,167,'2002-10-20','2003-04-22','2014-03-29 12:07:13','直接執行'),(291,52,1,8,171,'1987-05-23','1994-01-04','1998-09-05 06:20:34','未執行'),(292,150,8,2,13,'2000-02-07','2001-10-14','2002-10-23 14:21:43','直接執行'),(293,151,3,11,33,'2001-05-27','2010-10-18','1995-10-07 12:38:34','未執行'),(294,148,8,8,53,'1980-04-03','2000-02-28','1976-10-25 09:53:53','未執行'),(296,49,14,2,106,'1998-01-26','2007-11-06','1974-12-18 11:09:12','按計畫執行'),(297,132,13,5,178,'1997-01-10','2020-04-15','2016-09-22 13:15:48','按計畫執行'),(298,115,6,10,172,'2016-04-28','2002-07-14','2010-05-31 02:56:03','直接執行'),(299,20,10,19,132,'2004-07-23','2015-01-12','1984-05-26 20:20:40','直接執行'),(300,55,13,14,42,'2006-03-02','1985-11-28','2012-11-03 07:57:31','按計畫執行'),(301,54,1,8,179,'1971-04-20','2005-08-18','1977-08-09 08:22:22','直接執行'),(303,172,7,20,119,'2013-06-16','1992-04-05','1984-05-09 01:55:11','直接執行'),(306,123,13,14,156,'1985-12-12','1972-03-27','2003-08-22 06:35:21','直接執行'),(307,198,8,20,197,'2002-02-07','2003-05-19','2018-12-31 11:36:39','按計畫執行'),(308,3,15,16,163,'2016-11-14','1993-08-28','1988-06-05 18:30:59','直接執行'),(309,94,16,19,82,'1989-10-26','1988-10-28','1999-03-31 21:56:51','未執行'),(310,20,1,18,138,'1998-07-26','1990-01-01','1998-06-30 12:27:53','直接執行'),(311,112,7,11,178,'2011-06-11','2018-06-11','1973-09-21 15:31:14','未執行'),(312,139,5,18,94,'1989-12-06','2016-09-30','1986-10-07 23:23:46','未執行'),(313,191,6,8,37,'1994-01-31','2011-09-03','2011-12-22 02:48:18','未執行'),(314,98,1,14,36,'2017-05-09','1971-03-13','2003-01-23 00:54:47','未執行'),(315,147,16,17,123,'1984-02-16','1977-09-07','2004-09-17 19:54:06','直接執行'),(316,136,1,20,110,'1993-11-25','2008-05-10','1973-05-02 15:02:47','未執行'),(317,161,10,19,162,'1985-06-12','1987-07-15','2004-10-25 13:48:09','直接執行'),(318,195,14,19,29,'1994-11-17','1975-03-21','2018-03-05 13:04:24','未執行'),(319,155,7,20,59,'2002-01-29','2015-09-10','2006-12-02 06:56:03','未執行'),(320,117,3,4,80,'2011-10-31','2011-03-29','1986-05-24 13:44:07','按計畫執行'),(321,58,4,11,63,'2004-01-18','1973-12-13','1985-04-10 03:58:08','未執行'),(322,154,6,18,80,'1992-05-03','2002-11-01','2004-07-15 03:22:57','按計畫執行'),(323,111,16,13,94,'2009-11-16','1977-12-15','1991-05-17 17:16:15','未執行'),(324,5,1,15,195,'1970-03-23','1996-04-10','2010-01-18 17:58:39','按計畫執行'),(325,108,3,10,44,'1980-01-03','1988-08-14','1976-04-01 03:48:47','直接執行'),(326,9,2,16,20,'2006-03-23','2004-04-26','1981-09-30 12:46:31','按計畫執行'),(327,94,15,9,105,'1993-12-29','2020-06-30','1978-02-10 22:38:41','直接執行'),(328,63,9,14,147,'2012-12-06','2015-04-19','1991-03-21 21:16:40','按計畫執行'),(329,200,16,1,88,'2019-04-01','1993-07-25','2016-12-28 12:39:41','直接執行'),(330,93,15,12,185,'1981-06-05','1999-03-07','2006-12-22 21:53:31','按計畫執行'),(331,112,3,6,196,'1972-05-11','1994-08-12','2003-05-23 11:15:36','按計畫執行'),(332,147,8,20,1,'2002-10-28','1970-01-22','1973-03-31 11:18:58','按計畫執行'),(333,120,15,14,40,'2004-07-12','1987-02-25','1994-02-23 00:00:46','未執行'),(334,4,8,7,148,'1972-11-30','2020-11-27','1979-11-27 16:49:52','未執行'),(335,8,12,16,191,'2007-01-21','1976-01-11','1997-05-18 12:03:23','直接執行'),(336,104,7,13,180,'1982-08-22','1989-12-05','2002-11-17 17:50:21','直接執行'),(337,159,6,11,125,'1996-09-20','1985-05-18','1999-08-27 04:21:55','未執行'),(338,122,7,12,38,'1986-09-07','1975-02-10','2014-02-09 00:40:36','未執行'),(339,14,13,4,182,'1975-01-25','2021-07-17','1993-06-20 06:52:35','未執行'),(340,74,13,3,176,'1991-08-19','2008-02-16','2018-03-17 00:25:19','按計畫執行'),(341,152,9,7,124,'2009-08-08','1980-05-06','1982-12-27 03:12:16','直接執行'),(342,140,5,3,57,'1982-06-22','1981-03-22','2008-07-21 06:43:01','未執行'),(343,30,1,8,139,'2018-11-16','2010-10-16','1996-11-19 20:22:49','按計畫執行'),(344,128,3,15,109,'2005-08-05','2018-05-30','1995-06-08 09:56:48','按計畫執行'),(345,162,3,2,151,'1993-08-16','1977-11-07','1993-09-10 18:36:35','按計畫執行'),(346,176,8,20,162,'1972-01-15','2007-01-04','2008-07-23 07:43:15','直接執行'),(347,49,13,12,115,'1977-01-11','1991-04-05','2004-11-25 04:47:03','直接執行'),(349,63,15,17,155,'1999-01-09','1981-02-23','1990-10-09 19:38:32','按計畫執行'),(350,44,8,17,29,'1986-06-04','1986-02-18','2014-02-24 12:33:28','按計畫執行'),(351,67,15,10,111,'1994-07-12','2000-06-14','2009-06-29 18:22:17','未執行'),(352,137,3,13,107,'2019-01-08','1978-04-08','1998-05-26 08:19:45','未執行'),(353,3,6,17,16,'1999-07-18','1970-05-22','2015-11-20 02:49:21','未執行'),(354,95,2,13,148,'2021-08-02','1991-09-15','1978-09-03 03:30:03','按計畫執行'),(356,136,14,1,190,'2006-02-25','1996-02-17','1999-11-15 03:42:15','按計畫執行'),(357,51,8,18,156,'1999-06-11','1983-09-18','1990-04-27 06:24:36','直接執行'),(358,180,8,19,175,'1970-04-25','1982-07-28','1994-06-09 14:57:15','直接執行'),(359,77,11,13,144,'2016-05-21','1994-04-29','1984-07-29 05:26:36','直接執行'),(360,109,4,10,160,'1978-04-22','1985-08-19','2021-04-18 05:34:58','未執行'),(361,128,9,10,111,'1992-08-27','1991-05-19','1981-05-09 01:42:58','未執行'),(363,5,6,3,25,'1995-05-29','1989-04-18','2005-04-06 06:21:09','未執行'),(364,145,7,6,98,'2009-06-04','1970-05-05','1980-02-02 17:54:35','未執行'),(366,138,7,3,3,'1995-09-13','1980-06-20','1990-02-26 03:32:53','直接執行'),(367,134,8,20,23,'1984-05-31','1995-07-22','1983-11-27 16:01:34','按計畫執行'),(368,93,14,17,88,'2013-12-29','2004-06-01','1997-07-22 07:45:13','未執行'),(370,152,12,18,133,'2014-05-26','2007-05-18','2015-03-30 18:51:38','直接執行'),(371,156,9,19,171,'1997-11-25','2007-12-25','1980-10-26 07:58:46','按計畫執行'),(372,53,1,11,154,'1997-02-06','1991-04-24','2017-08-08 19:53:28','直接執行'),(373,163,4,1,6,'2000-09-08','1985-04-05','1973-01-14 03:10:42','按計畫執行'),(374,87,4,3,182,'1994-08-28','2016-02-07','1978-11-20 10:35:52','直接執行'),(376,76,7,16,73,'2009-08-15','2006-10-08','1970-05-11 00:16:49','按計畫執行'),(378,43,9,10,9,'1998-01-07','1980-09-20','2012-12-24 20:25:36','未執行'),(380,151,4,8,42,'1995-11-10','1980-09-29','1983-06-13 16:08:19','按計畫執行'),(381,174,9,11,117,'2001-06-21','2008-11-12','1995-06-11 22:56:46','直接執行'),(382,107,11,7,111,'2011-03-25','1998-03-03','1980-10-18 01:49:21','直接執行'),(384,43,10,3,8,'1995-03-13','1993-10-16','1993-04-12 13:08:39','直接執行'),(386,13,15,4,62,'2008-05-01','1977-08-29','2015-11-15 20:24:05','未執行'),(387,82,7,11,194,'1980-05-09','2012-06-16','1999-04-24 21:10:52','直接執行'),(388,150,5,16,85,'2006-01-20','1980-09-11','2014-12-17 18:43:14','直接執行'),(389,98,4,8,74,'1992-10-21','1992-07-16','2018-09-05 18:11:56','按計畫執行'),(390,83,4,7,98,'1979-10-31','2005-10-18','2001-05-09 23:20:15','未執行'),(391,32,16,10,50,'1985-11-02','1985-06-24','1995-09-03 04:30:44','按計畫執行'),(392,104,11,16,25,'1977-12-28','1992-01-06','1989-05-05 04:22:22','按計畫執行'),(393,144,15,16,132,'1990-05-27','2004-05-04','2002-04-02 06:08:05','未執行'),(395,133,15,17,57,'1985-01-16','2001-07-14','1977-11-14 07:15:33','按計畫執行'),(396,22,11,18,163,'1995-07-18','1991-02-12','1992-12-09 02:01:08','未執行'),(397,33,13,17,43,'1999-03-13','2007-11-02','1976-08-29 23:58:47','直接執行'),(399,129,6,2,107,'1987-07-06','2000-06-09','2010-09-12 06:29:59','按計畫執行'),(400,91,12,4,18,'1971-11-01','1983-01-10','2012-09-19 06:53:10','未執行'),(401,50,11,12,143,'2009-07-10','1988-06-22','2003-08-01 16:26:10','按計畫執行'),(402,59,14,15,108,'1973-03-03','2007-07-10','2009-03-19 14:50:03','未執行'),(403,168,1,13,161,'2013-03-17','1970-09-30','1987-11-07 09:39:19','未執行'),(404,175,7,3,103,'2007-06-21','1979-10-21','2012-04-01 17:22:40','直接執行'),(405,44,6,13,96,'1977-05-25','2015-04-15','1991-01-07 05:54:59','直接執行'),(406,102,8,4,53,'1984-03-22','1986-05-14','1980-10-08 01:01:32','未執行'),(407,16,1,7,114,'1970-03-17','1977-11-03','2015-01-12 16:58:09','直接執行'),(408,185,16,4,134,'2006-06-17','2016-12-15','2005-01-28 23:38:17','按計畫執行'),(410,141,9,2,138,'1974-01-20','2002-06-06','1989-09-04 06:34:23','按計畫執行'),(412,190,16,14,54,'1984-05-13','1980-05-20','2002-09-13 23:43:16','按計畫執行'),(413,91,1,11,145,'1995-10-27','1996-02-11','2012-04-19 02:05:21','按計畫執行'),(414,151,2,12,54,'1974-07-18','1990-02-01','1992-11-12 21:21:11','按計畫執行'),(415,59,5,12,136,'1981-08-06','1995-02-06','1971-03-31 06:11:34','按計畫執行'),(416,134,11,16,164,'1981-10-23','1970-09-07','1978-01-17 10:15:52','直接執行'),(418,40,12,2,179,'1997-04-30','2002-12-22','1991-11-27 04:33:17','按計畫執行'),(419,200,2,5,66,'2003-01-08','2013-05-21','1976-05-19 16:14:18','直接執行'),(420,178,5,17,149,'2004-08-03','1994-11-09','1996-01-21 05:04:54','未執行'),(421,72,8,7,130,'1971-12-24','2011-05-22','1986-07-27 08:45:14','按計畫執行'),(422,119,9,1,46,'2008-02-21','2010-09-19','2008-10-25 08:54:21','按計畫執行'),(423,84,11,4,175,'1989-03-05','1991-02-17','1970-05-15 04:28:11','直接執行'),(424,45,4,2,122,'1990-01-29','2010-11-26','1999-03-17 11:23:20','直接執行'),(426,119,1,15,111,'2001-10-12','2021-06-21','2008-03-01 19:01:54','未執行'),(427,148,11,8,105,'1999-03-21','2002-12-10','2005-09-29 01:13:56','直接執行'),(428,158,4,4,119,'1984-11-21','1976-12-29','1990-12-01 02:06:17','按計畫執行'),(429,112,11,3,183,'2012-01-08','2012-09-26','1994-07-24 14:57:26','未執行'),(432,79,10,7,183,'1994-01-21','1999-09-30','2003-06-12 10:29:24','直接執行'),(433,184,12,12,59,'2004-03-10','1983-10-24','2001-07-14 23:00:48','未執行'),(436,28,1,13,54,'1993-04-05','2004-04-16','1990-08-06 04:20:51','直接執行'),(437,61,15,17,75,'2003-11-08','1994-02-13','1981-08-17 05:21:45','未執行'),(438,90,15,6,175,'2005-03-03','1971-11-15','2003-10-12 21:16:58','直接執行'),(439,50,14,13,56,'1983-12-08','1973-04-13','1972-04-15 08:37:43','按計畫執行'),(440,180,14,5,181,'2003-03-16','2013-11-05','2017-07-04 08:22:13','未執行'),(441,120,10,4,39,'1991-12-09','2012-07-25','2014-12-21 03:45:43','未執行'),(442,135,7,3,139,'1990-08-25','1976-08-25','1979-07-01 04:39:54','按計畫執行'),(443,8,10,8,96,'2001-12-10','1985-11-28','1982-08-08 09:23:13','未執行'),(444,107,12,2,21,'2008-06-08','2011-02-08','2008-05-01 20:16:16','未執行'),(446,90,15,2,127,'1978-07-10','1983-12-21','2020-03-22 20:10:16','直接執行'),(448,41,14,14,8,'1972-01-23','1972-12-01','2015-12-12 18:36:56','直接執行'),(449,86,5,17,168,'1971-06-26','1981-10-24','2001-10-02 06:10:59','直接執行'),(450,124,2,5,15,'1986-09-19','1981-06-28','2018-02-06 14:37:30','直接執行'),(451,28,16,4,47,'1979-11-29','2012-05-29','1972-11-05 17:43:21','按計畫執行'),(452,21,9,3,128,'1982-05-18','2021-03-31','1982-10-14 01:07:17','未執行'),(453,98,12,17,88,'1992-06-11','1991-09-07','1989-09-30 13:51:18','直接執行'),(454,33,15,7,160,'1978-02-16','1981-03-04','2012-07-16 00:17:47','直接執行'),(455,45,2,15,111,'1991-07-09','2014-02-24','1998-01-28 20:06:43','直接執行'),(457,111,2,15,156,'2007-10-05','2008-03-28','2020-01-01 06:32:36','未執行'),(458,32,12,7,169,'2008-03-01','2020-08-24','2014-11-16 18:18:19','直接執行'),(459,104,14,9,119,'2019-06-06','2008-06-26','1995-02-26 07:27:09','直接執行'),(460,37,11,1,46,'2009-06-19','1977-05-18','2011-01-16 17:16:21','直接執行'),(461,103,13,2,129,'2019-08-07','1974-02-16','1994-09-17 17:27:11','直接執行'),(462,51,6,3,158,'2015-03-30','1995-10-27','1995-05-14 12:30:26','未執行'),(463,94,10,10,122,'1977-12-11','2020-12-26','2011-09-12 19:11:13','按計畫執行'),(465,137,13,9,178,'2005-11-11','1990-11-03','2000-07-02 11:41:40','按計畫執行'),(467,73,2,17,88,'1974-03-26','1982-08-16','2012-10-20 16:02:36','直接執行'),(469,129,9,20,148,'2001-09-30','2003-12-31','1978-08-16 22:11:56','按計畫執行'),(472,137,1,4,45,'2007-08-30','2008-01-07','1986-03-19 11:47:46','按計畫執行'),(474,124,12,6,137,'1974-08-16','1974-12-12','1985-08-18 10:44:01','未執行'),(476,15,1,10,200,'2001-01-16','2002-09-19','1997-11-29 17:21:54','按計畫執行'),(477,87,7,20,150,'1976-06-02','2009-06-23','1984-12-15 13:46:22','按計畫執行'),(479,157,7,14,9,'1986-10-11','2021-03-17','2014-09-15 16:28:15','未執行'),(480,160,10,6,184,'1982-06-09','1997-12-31','2017-01-06 03:51:40','直接執行'),(481,185,16,3,94,'1983-04-17','1998-06-27','1971-12-23 07:19:09','未執行'),(482,58,6,9,91,'1986-02-03','2013-10-10','1988-11-06 12:30:45','直接執行'),(483,175,11,1,153,'2021-08-02','1990-12-29','1996-07-23 13:40:21','未執行'),(484,27,11,10,112,'2004-03-29','1983-05-17','1983-01-29 08:07:23','直接執行'),(485,194,15,4,80,'2009-12-27','2009-11-20','1996-07-30 21:28:08','按計畫執行'),(486,76,9,10,51,'1994-04-12','1974-08-01','1999-07-14 22:00:30','直接執行'),(487,138,2,13,119,'1971-12-13','1992-06-03','1998-04-01 23:46:16','未執行'),(488,97,15,6,174,'2003-05-03','2009-12-28','1998-11-02 14:55:26','直接執行'),(489,180,2,4,88,'1983-03-10','2004-11-26','1982-06-04 13:39:57','未執行'),(490,56,9,4,35,'1988-02-01','1992-06-14','2012-04-10 23:24:56','直接執行'),(491,181,7,5,194,'1991-06-30','1989-01-23','2005-01-01 18:26:19','未執行'),(492,94,7,8,119,'1979-02-08','2012-07-28','1985-05-30 07:58:35','未執行'),(493,135,16,4,126,'1995-02-10','1982-10-25','2005-08-09 12:14:27','直接執行'),(494,7,10,1,85,'1992-04-08','1973-02-25','2007-01-25 17:29:20','按計畫執行'),(495,23,1,5,112,'2013-02-15','2019-08-19','2006-09-28 19:31:21','直接執行'),(496,7,1,15,33,'1980-04-27','2010-07-11','2012-06-02 17:48:31','未執行'),(497,162,5,13,111,'1993-07-31','2008-03-24','1989-11-10 23:17:46','直接執行'),(498,65,14,15,54,'1977-05-22','2004-04-04','2003-06-15 18:08:27','直接執行'),(499,151,10,2,12,'2020-10-21','1996-03-29','1993-06-14 11:57:05','按計畫執行'),(500,38,15,15,10,'1995-07-12','1979-01-02','1992-03-15 16:56:33','直接執行');
/*!40000 ALTER TABLE `Fit_achieve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fit_activity`
--

DROP TABLE IF EXISTS `Fit_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Fit_activity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `body_part` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `kcal_burn` float NOT NULL,
  `image` mediumblob,
  `image_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `video_id` int NOT NULL,
  `time` time NOT NULL,
  `role` TINYINT DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `Fit_activity_ibfk_1` FOREIGN KEY (`video_id`) REFERENCES `Fit_activity_video` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fit_activity`
--

LOCK TABLES `Fit_activity` WRITE;
/*!40000 ALTER TABLE `Fit_activity` DISABLE KEYS */;
INSERT INTO `Fit_activity` VALUES 
(1,'10 min LISTT','Upper',NULL,90,NULL,'./images/Fit_activity/10_min_LISTT.png',1,'00:10:00',NULL),
(2,'12 min LISTT','Upper',NULL,190,NULL,'./images/Fit_activity/12_min_LISTT.png',2,'00:12:00',NULL),
(3,'16 min LISTT','Upper',NULL,210,NULL,'./images/Fit_activity/16_min_LISTT.png',3,'00:16:00',NULL),
(4,'20 min ST','Upper',NULL,160,NULL,'./images/Fit_activity/20_min_ST.png',4,'00:20:00',NULL),
(5,'10 min PT','Core',NULL,80,NULL,'./images/Fit_activity/10_min_PT.png',5,'00:10:00',NULL),
(6,'10 min BLIT','Core',NULL,70,NULL,'./images/Fit_activity/10_min_BLIT.png',6,'00:10:00',NULL),
(7,'12 min LISTT','Core',NULL,120,NULL,'./images/Fit_activity/12_min_LISTT.png',7,'00:12:00',NULL),
(8,'18 min CLIPT','Core',NULL,170,NULL,'./images/Fit_activity/18_min_CLIPT.png',8,'00:18:00',NULL),
(9,'10 min STE','Lower',NULL,110,NULL,'./images/Fit_activity/10_min_STE.png',9,'00:10:00',NULL),
(10,'14 min LIPT','Lower',NULL,100,NULL,'./images/Fit_activity/14_min_LIPT.png',10,'00:14:00',NULL),
(11,'16 min PSTT','Lower',NULL,231,NULL,'./images/Fit_activity/16_min_PSTT.png',11,'00:16:00',NULL),
(12,'20 min LIPT','Lower',NULL,150,NULL,'./images/Fit_activity/20_min_LIPT.png',12,'00:20:00',NULL),
(13,'10 min CHT','HIIT',NULL,110,NULL,'./images/Fit_activity/10_min_CHT.png',13,'00:10:00',NULL),
(14,'16 min CHT','HIIT',NULL,190,NULL,'./images/Fit_activity/16_min_CHT.png',14,'00:16:00',NULL),
(15,'16 min CH','HIIT',NULL,200,NULL,'./images/Fit_activity/16_min_CH.png',15,'00:16:00',NULL),
(16,'20 min CHT','HIIT',NULL,260,NULL,'./images/Fit_activity/20_min_CHT.png',16,'00:20:00',NULL);
/*!40000 ALTER TABLE `Fit_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fit_activity_video`
--

DROP TABLE IF EXISTS `Fit_activity_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Fit_activity_video` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `video` longblob,
  `video_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `file_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mime_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `time` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fit_activity_video`
--

LOCK TABLES `Fit_activity_video` WRITE;
/*!40000 ALTER TABLE `Fit_activity_video` DISABLE KEYS */;
INSERT INTO `Fit_activity_video` VALUES (1,'voluptatum',NULL,'http://lorempixel.com/10/20/cats/','quo','text/prs.lines.tag','23:24:33'),(2,'blanditiis',NULL,'http://lorempixel.com/10/20/cats/','reiciendis','audio/x-pn-realaudio','12:12:01'),(3,'et',NULL,'http://lorempixel.com/10/20/cats/','sunt','video/jpeg','15:51:43'),(4,'nobis',NULL,'http://lorempixel.com/10/20/cats/','velit','application/vnd.sun.xml.impress','20:51:34'),(5,'atque',NULL,'http://lorempixel.com/10/20/cats/','repudiandae','message/rfc822','18:24:13'),(6,'quisquam',NULL,'http://lorempixel.com/10/20/cats/','ab','application/vnd.semd','23:19:15'),(7,'molestiae',NULL,'http://lorempixel.com/10/20/cats/','corrupti','video/3gpp','01:34:23'),(8,'delectus',NULL,'http://lorempixel.com/10/20/cats/','adipisci','application/vnd.dece.zip','18:18:17'),(9,'ea',NULL,'http://lorempixel.com/10/20/cats/','quis','application/vnd.las.las+xml','05:39:18'),(10,'quasi',NULL,'http://lorempixel.com/10/20/cats/','quia','application/vnd.ezpix-package','00:47:10'),(11,'tempore',NULL,'http://lorempixel.com/10/20/cats/','et','application/x-subrip','22:05:21'),(12,'iusto',NULL,'http://lorempixel.com/10/20/cats/','sint','application/x-tex','16:46:52'),(13,'officiis',NULL,'http://lorempixel.com/10/20/cats/','inventore','image/cgm','00:44:58'),(14,'vero',NULL,'http://lorempixel.com/10/20/cats/','voluptas','video/x-flv','14:45:20'),(15,'magnam',NULL,'http://lorempixel.com/10/20/cats/','adipisci','image/x-tga','19:04:12'),(16,'sunt',NULL,'http://lorempixel.com/10/20/cats/','eligendi','image/jpeg','06:49:17');
/*!40000 ALTER TABLE `Fit_activity_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Food`
--

DROP TABLE IF EXISTS `Food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `kcal` float NOT NULL,
  `serving` varchar(64),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Food`
--

LOCK TABLES `Food` WRITE;
/*!40000 ALTER TABLE `Food` DISABLE KEYS */;
INSERT INTO food VALUES (1,'Beer','Alcohol',152,'1 can/bottle (354 ml)');
INSERT INTO food VALUES (2,'Beef','Beef',287,'6 oz. (168 g)');
INSERT INTO food VALUES (3,'Beef Fillet','Beef',318,'6 oz. (168 g)');
INSERT INTO food VALUES (4,'Roast Beef','Beef',638,'1 slice (341 g)');
INSERT INTO food VALUES (5,'Porterhouse Steak','Beef',790,'1 steak (320 g)');
INSERT INTO food VALUES (6,'Rib Eye Steak','Beef',610,'1 steak (281 g)');
INSERT INTO food VALUES (7,'Strip Steak','Beef',40,'3 slices (34 g)');
INSERT INTO food VALUES (8,'Stew Beef','Beef',867,'1 lb. (454 g)');
INSERT INTO food VALUES (9,'Birthday Cake','Cakes & Pies',395,'1 piece (85 g)');
INSERT INTO food VALUES (10,'Blueberry Pie','Cakes & Pies',290,'1 piece (125 g)');
INSERT INTO food VALUES (11,'Caramel Cake','Cakes & Pies',304,'1 slice (64 g)');
INSERT INTO food VALUES (12,'Cheesecake','Cakes & Pies',257,'1 piece (80 g)');
INSERT INTO food VALUES (13,'Chocolate Cake','Cakes & Pies',537,'1 piece (138 g)');
INSERT INTO food VALUES (14,'Chocolate Cream Pie','Cakes & Pies',301,'1 piece (99 g)');
INSERT INTO food VALUES (15,'Chocolate Mousse Cake','Cakes & Pies',247,'1 piece (95 g)');
INSERT INTO food VALUES (16,'Coffee Cake','Cakes & Pies',298,'1 piece (90 g)');
INSERT INTO food VALUES (17,'Cream Puff','Cakes & Pies',434,'1 cream puff (130 g)');
INSERT INTO food VALUES (18,'Cupcake','Cakes & Pies',131,'1 cupcake (43 g)');
INSERT INTO food VALUES (19,'Donut','Cakes & Pies',242,'1 donut (60 g)');
INSERT INTO food VALUES (20,'Fruit Cake','Cakes & Pies',139,'1 piece (43 g)');
INSERT INTO food VALUES (21,'Ice Cream Cake','Cakes & Pies',240,'1 piece (120 g)');
INSERT INTO food VALUES (22,'Chocolate','Candy & Sweets',37,'1 piece (7 g)');
INSERT INTO food VALUES (23,'Chocolate Bar','Candy & Sweets',240,'1 bar (45 g)');
INSERT INTO food VALUES (24,'Chocolate Chips','Candy & Sweets',69,'1 tbsp (14 g)');
INSERT INTO food VALUES (25,'Cookies','Candy & Sweets',78,'1 cookie (16 g)');
INSERT INTO food VALUES (26,'Cotton Candy','Candy & Sweets',90,'1/2 bag (14 g)');
INSERT INTO food VALUES (27,'Kit Kat','Candy & Sweets',234,'1 bar (45 g)');
INSERT INTO food VALUES (28,'Lollipop','Candy & Sweets',47,'1 lollipop (12 g)');
INSERT INTO food VALUES (29,'M&Ms','Candy & Sweets',67,'20 pieces (14 g)');
INSERT INTO food VALUES (30,'Marshmallows','Candy & Sweets',124,'5 pieces (39 g)');
INSERT INTO food VALUES (31,'Chicken Caesar Salad','Meals',392,'1 salad (309 g)');
INSERT INTO food VALUES (32,'Fried Rice','Meals',662,'1 serving (356 g)');
INSERT INTO food VALUES (33,'Ham and Cheese Sandwich','Meals',352,'1 sandwich (146 g)');
INSERT INTO food VALUES (34,'Macaroni and Cheese','Meals',699,'1 serving (189 g)');
INSERT INTO food VALUES (35,'Peking Duck','Meals',401,'1/2 duck (178 g)');
INSERT INTO food VALUES (36,'Pizza','Meals',272,'1 slice (102 g)');
INSERT INTO food VALUES (37,'Ramen','Meals',380,'1 package, dry (85 g)');
INSERT INTO food VALUES (38,'Spaghetti Bolognese','Meals',374,'1 serving (283 g)');
INSERT INTO food VALUES (39,'Dumplings','Meals',50,'1 dumpling (40 g)');
INSERT INTO food VALUES (40,'Pork Chop','Meals',194,'1 chop  (158 g)');
INSERT INTO food VALUES (41,'Pork Bacon','Meals',106,'1 slice (26 g)');
INSERT INTO food VALUES (42,'Pork Roast','Meals',510,'1 chop  (263 g)');
INSERT INTO food VALUES (43,'Pork Sausage','Meals',163,'1 sausage (48 g)');
INSERT INTO food VALUES (44,'Burger King Double Whopper','Fast Food',894,'1 burger (374 g)');
INSERT INTO food VALUES (45,'Cheeseburger','Fast Food',410,'1 burger (156 g)');
INSERT INTO food VALUES (46,'Chicken Nuggets','Fast Food',59,'1 piece (20 g)');
INSERT INTO food VALUES (47,'Chicken Wings','Fast Food',94,'1 piece (29 g)');
INSERT INTO food VALUES (48,'Double Cheeseburger','Fast Food',414,'1 burger (155 g)');
INSERT INTO food VALUES (49,'Egg Roll','Fast Food',200,'1 roll (80 g)');
INSERT INTO food VALUES (50,'French Fries','Fast Food',222,'1 serving (71 g)');
INSERT INTO food VALUES (51,'Hamburger','Fast Food',279,'1 sandwich (110 g)');
INSERT INTO food VALUES (52,'Hot Dog','Fast Food',312,'1 hot dog (116 g)');
INSERT INTO food VALUES (53,'McDonalds Big Mac','Fast Food',561,'1 burger (219 g)');
INSERT INTO food VALUES (54,'Calamari','Fish & Seafood',21,'1 piece (12 g)');
INSERT INTO food VALUES (55,'Caviar','Fish & Seafood',42,'1 tbsp (16 g)');
INSERT INTO food VALUES (56,'Clam','Fish & Seafood',126,'3 oz. (85 g)');
INSERT INTO food VALUES (57,'Flounder','Fish & Seafood',109,'1 fillet (127 g)');
INSERT INTO food VALUES (58,'Grouper','Fish & Seafood',238,'1 fillet (202 g)');
INSERT INTO food VALUES (59,'Lobster','Fish & Seafood',134,'1 lobster (150 g)');
INSERT INTO food VALUES (60,'Monkfish','Fish & Seafood',82,'3 oz. (85 g)');
INSERT INTO food VALUES (61,'Octopus','Fish & Seafood',139,'3 oz. (85 g)');
INSERT INTO food VALUES (62,'Sushi','Fish & Seafood',39,'1 piece (26 g)');
INSERT INTO food VALUES (63,'Apple','Fruits ',95,'1 apple (182 g)');
INSERT INTO food VALUES (64,'Banana','Fruits ',111,'1 banana (125 g)');
INSERT INTO food VALUES (65,'Blueberries','Fruits ',84,'1 cup (148 g)');
INSERT INTO food VALUES (66,'Cherries','Fruits ',4,'1 cherry (8 g)');
INSERT INTO food VALUES (67,'Grapes','Fruits ',104,'1 cup (151 g)');
INSERT INTO food VALUES (68,'Lemon','Fruits ',17,'1 lemon (58 g)');
INSERT INTO food VALUES (69,'Lychees','Fruits ',7,'1 lychee (10 g)');
INSERT INTO food VALUES (70,'Mango','Fruits ',202,'1 mango (336 g)');
INSERT INTO food VALUES (71,'Orange','Fruits ',62,'1 orange (131 g)');
INSERT INTO food VALUES (72,'Papaya','Fruits ',215,'1 fruit (500 g)');
INSERT INTO food VALUES (73,'Peach','Fruits ',59,'1 peach (150 g)');
INSERT INTO food VALUES (74,'Pear','Fruits ',101,'1 pear (178 g)');
INSERT INTO food VALUES (75,'Pineapple','Fruits ',453,'1 pineapple (905 g)');
INSERT INTO food VALUES (76,'Watermelon','Fruits ',86,'1 wedge (286 g)');
INSERT INTO food VALUES (77,'Chocolate Milk','Non-alcoholic drink',237,'1 cup (266 ml)');
INSERT INTO food VALUES (78,'Coca Cola','Non-alcoholic drink',139,'1 can (330 ml)');
INSERT INTO food VALUES (79,'Coffee','Non-alcoholic drink',2,'1 cup (237 ml)');
INSERT INTO food VALUES (80,'Coke Zero','Non-alcoholic drink',3,'1 can (330 ml)');
INSERT INTO food VALUES (81,'Hot Chocolate','Non-alcoholic drink',237,'1 cup (266 ml)');
INSERT INTO food VALUES (82,'Lemonade','Non-alcoholic drink',149,'12 fl. oz. (355 ml)');
INSERT INTO food VALUES (83,'Milk','Non-alcoholic drink',149,'1 cup (244 ml)');
INSERT INTO food VALUES (84,'Tea','Non-alcoholic drink',2,'1 cup (237 ml)');
INSERT INTO food VALUES (85,'Broccoli','Vegetables',207,'1 bunch (608 g)');
INSERT INTO food VALUES (86,'Cabbage','Vegetables',227,'1 head (908 g)');
INSERT INTO food VALUES (87,'Capsicum','Vegetables',12,'1 pepper (45 g)');
INSERT INTO food VALUES (88,'Carrot','Vegetables',25,'1 carrot (61 g)');
INSERT INTO food VALUES (89,'Celery','Vegetables',6,'1 stalk (40 g)');
INSERT INTO food VALUES (90,'Chinese Cabbage','Vegetables',134,'1 head (840 g)');
INSERT INTO food VALUES (91,'Corn','Vegetables',562,'1 cup (154 g)');
INSERT INTO food VALUES (92,'Cucumber','Vegetables',66,'1 cucumber (410 g)');
INSERT INTO food VALUES (93,'Eggplant','Vegetables',115,'1 eggplant (458 g)');
INSERT INTO food VALUES (94,'Green Beans','Vegetables',34,'1 cup (110 g)');
INSERT INTO food VALUES (95,'Green Onion','Vegetables',5,'1 green onion (15 g)');
INSERT INTO food VALUES (96,'Lettuce','Vegetables',90,'1 head (600 g)');
INSERT INTO food VALUES (97,'Mushrooms','Vegetables',1,'1 mushroom (5.4 g)');
INSERT INTO food VALUES (98,'Onion','Vegetables',34,'1 onion (85 g)');
INSERT INTO food VALUES (99,'Peas','Vegetables',79,'1 cup (98 g)');
INSERT INTO food VALUES (100,'Pepper','Vegetables',20,'1 pepper (75 g)');
INSERT INTO food VALUES (101,'Potato','Vegetables',164,'1 potato (213 g)');
INSERT INTO food VALUES (102,'Pumpkin','Vegetables',51,'1 pumpkin (196 g)');
INSERT INTO food VALUES (103,'Tomato','Vegetables',20,'1 tomato (111 g)');
/*!40000 ALTER TABLE `Food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Health_record`
--

DROP TABLE IF EXISTS `Health_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Health_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `age` int DEFAULT NULL,
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `BMI` float DEFAULT NULL,
  `BMR` float DEFAULT NULL,
  `BFP` float DEFAULT NULL,
  `TDEE` float DEFAULT NULL,
  `FFMI` float DEFAULT NULL,
  `calorie_deficit` float DEFAULT NULL,
  `exercise_frequency` varchar(64) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `health_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Health_record`
--

LOCK TABLES `Health_record` WRITE;
/*!40000 ALTER TABLE `Health_record` DISABLE KEYS */;
INSERT INTO `Health_record` VALUES 
(1,1,26,164.8,66.3,24.41,1621.51,19.07,2594.42,19.76,6542,'ModerateExercise','2021-07-20'),
(2,1,26,164.8,65.8,24.23,1614.66,23.2,2583.44,18.61,7235,'ModerateExercise','2021-07-16'),
(3,2,28,177.5,88.2,27.99,1699.62,25.3,3059.32,20.91,5347,'HeavyExercise','2021-07-25'),
(4,1,27,165.5,67,24.46,1627.8,19.36,2604.48,19.73,-6825,'ModerateExercise','2021-08-28'),
(5,1,27,165.5,66,24.1,1614.1,18.93,2582.56,19.53,-3912.6,'ModerateExercise','2021-08-29'),
(6,4,26,164.8,66.3,24.41,1621.51,19.07,2594.42,19.76,6542,'ModerateExercise','2021-07-20'),
(7,5,26,164.8,65.8,24.23,1614.66,23.2,2583.44,18.61,7235,'ModerateExercise','2021-07-16'),
(8,6,28,177.5,88.2,27.99,1699.62,25.3,3059.32,20.91,5347,'HeavyExercise','2021-07-25'),
(9,7,27,165.5,67,24.46,1627.8,19.36,2604.48,19.73,-6825,'ModerateExercise','2021-08-28'),
(10,8,27,165.5,66,24.1,1614.1,18.93,2582.56,19.53,-3912.6,'ModerateExercise','2021-08-29');
/*!40000 ALTER TABLE `Health_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Meal`
--

DROP TABLE IF EXISTS `Meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Meal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `food_id` int NOT NULL,
  `daily_record_id` int NOT NULL,
  `time_period_id` int NOT NULL,
  `quantity` int NOT NULL,
  `total_kcal` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `food_id` (`food_id`),
  KEY `daily_record_id` (`daily_record_id`),
  KEY `time_period_id` (`time_period_id`),
  CONSTRAINT `Meal_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `Food` (`id`),
  CONSTRAINT `Meal_ibfk_2` FOREIGN KEY (`daily_record_id`) REFERENCES `Daily_Record` (`id`),
  CONSTRAINT `Meal_ibfk_3` FOREIGN KEY (`time_period_id`) REFERENCES `Time_period` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=401 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Meal`
--

LOCK TABLES `Meal` WRITE;
/*!40000 ALTER TABLE `Meal` DISABLE KEYS */;
INSERT INTO `Meal` VALUES (1,5,12,3,2,664),(2,10,182,3,5,959),(3,19,75,2,7,761),(4,6,48,2,5,615),(5,23,91,3,8,158),(6,14,9,3,4,179),(7,4,75,3,3,15),(8,11,131,2,7,142),(9,15,100,2,2,232),(10,23,140,3,5,986),(11,21,174,3,7,145),(12,15,47,3,3,89),(13,7,192,1,3,316),(14,23,32,2,1,439),(15,7,11,3,2,500),(16,24,119,3,2,440),(17,17,151,1,4,42),(18,12,37,3,6,231),(19,3,151,2,8,464),(20,12,130,1,10,183),(21,7,94,3,6,834),(22,3,9,1,6,47),(23,22,64,1,9,335),(24,25,43,1,8,465),(25,9,92,2,8,52),(26,5,77,3,4,221),(27,1,9,3,3,85),(28,7,103,3,2,507),(29,4,125,2,7,662),(30,13,21,1,10,576),(31,15,74,3,8,842),(32,13,98,3,8,547),(33,18,71,1,4,475),(34,21,70,1,9,59),(35,3,141,3,9,313),(36,12,174,1,2,659),(37,10,178,1,3,662),(38,2,26,3,7,951),(39,24,51,1,9,146),(40,14,152,2,8,734),(41,21,66,3,1,570),(42,15,168,1,7,82),(43,9,105,2,2,585),(44,12,68,3,3,399),(45,19,89,3,9,588),(46,13,178,2,4,69),(47,17,54,2,4,632),(48,22,67,2,8,972),(49,15,54,3,4,71),(50,23,165,2,8,487),(51,9,131,3,4,159),(52,4,44,3,10,83),(53,11,113,1,5,456),(54,2,2,2,6,470),(55,2,153,1,2,677),(56,19,56,3,1,932),(57,8,190,1,9,743),(58,19,162,2,9,693),(59,8,75,3,9,995),(60,4,54,2,4,657),(61,18,120,1,9,416),(62,16,145,2,2,450),(63,10,29,1,5,11),(64,17,40,1,8,518),(65,7,48,3,5,990),(66,8,195,1,3,393),(67,6,52,1,1,798),(68,11,199,3,1,205),(69,25,59,1,8,411),(70,20,85,2,4,535),(71,11,28,1,8,452),(72,17,152,3,10,636),(73,5,26,3,10,560),(74,6,154,1,8,908),(75,8,4,2,6,550),(76,4,63,2,2,532),(77,7,111,2,4,934),(78,8,198,2,1,787),(79,5,193,3,2,291),(80,11,148,2,5,458),(81,23,28,2,6,677),(82,1,163,1,1,289),(83,22,198,2,9,214),(84,21,45,1,2,698),(85,25,106,1,9,744),(86,10,133,2,4,2),(87,19,182,1,4,18),(88,10,43,1,2,263),(89,1,77,3,7,433),(90,24,158,3,1,378),(91,7,141,3,4,745),(92,19,144,2,6,6),(93,25,113,2,8,553),(94,9,75,3,6,262),(95,13,70,2,5,993),(96,16,146,1,7,924),(97,3,96,3,3,900),(98,3,173,1,9,825),(99,3,175,2,4,783),(100,2,160,2,7,581),(101,20,14,1,2,846),(102,16,165,3,3,39),(103,7,163,1,9,43),(104,23,34,3,1,340),(105,20,132,1,1,214),(106,5,59,3,1,101),(107,6,79,1,3,342),(108,5,101,1,6,520),(109,10,124,3,8,298),(110,24,139,3,9,332),(111,7,95,3,2,116),(112,9,18,3,1,335),(113,3,71,2,5,268),(114,11,53,2,10,378),(115,3,8,1,3,424),(116,5,42,2,4,337),(117,24,88,3,6,19),(118,6,127,2,4,801),(119,9,2,1,5,84),(120,8,189,3,7,284),(121,3,44,1,5,504),(122,24,110,2,2,534),(123,16,128,3,4,255),(124,4,12,3,10,890),(125,20,35,1,1,712),(126,3,69,1,3,357),(127,18,59,2,1,941),(128,18,100,1,5,972),(129,6,164,1,10,479),(130,8,26,1,10,423),(131,4,45,2,9,206),(132,11,36,1,3,891),(133,20,162,2,2,847),(134,13,186,3,3,576),(135,12,142,3,2,275),(136,13,161,1,9,894),(137,18,102,2,5,294),(138,10,42,1,3,219),(139,17,82,3,2,990),(140,25,146,3,7,789),(141,6,171,1,3,318),(142,18,52,2,7,931),(143,18,5,1,1,293),(144,10,102,1,9,582),(145,2,196,3,8,815),(146,24,93,2,8,417),(147,5,36,1,3,566),(148,18,111,1,3,605),(149,18,47,3,6,350),(150,14,44,2,8,551),(151,13,91,1,7,393),(152,17,30,2,3,978),(153,1,173,2,6,534),(154,5,46,1,10,56),(155,7,59,1,7,463),(156,2,49,2,10,93),(157,17,84,3,7,680),(158,20,22,1,8,325),(159,3,163,2,5,607),(160,21,70,3,4,299),(161,7,167,1,9,614),(162,14,101,1,2,451),(163,3,105,1,10,161),(164,18,140,2,7,517),(165,20,194,3,7,32),(166,21,6,3,1,297),(167,9,138,2,3,894),(168,2,91,2,6,914),(169,8,107,1,9,780),(170,21,68,2,8,839),(171,13,118,2,10,775),(172,17,28,3,6,16),(173,25,49,2,5,585),(174,4,185,1,3,105),(175,14,139,1,10,898),(176,6,105,1,7,654),(177,4,177,3,7,745),(178,13,189,1,5,486),(179,24,51,3,1,232),(180,6,11,1,3,163),(181,21,112,3,7,940),(182,7,45,3,6,537),(183,6,38,1,10,284),(184,18,65,1,2,885),(185,22,170,3,1,312),(186,25,12,1,5,960),(187,4,41,1,3,895),(188,1,139,1,3,208),(189,8,128,2,7,78),(190,4,170,2,10,62),(191,9,135,3,1,464),(192,3,190,1,5,617),(193,25,34,2,1,898),(194,4,172,3,2,961),(195,5,144,2,4,353),(196,24,142,2,6,880),(197,6,173,3,3,140),(198,10,174,2,8,892),(199,13,35,1,8,189),(200,21,64,3,1,49),(201,7,129,2,2,80),(202,6,146,2,5,76),(203,10,143,3,1,6),(204,20,168,2,4,650),(205,12,5,2,1,401),(206,25,194,1,4,439),(207,15,38,3,6,530),(208,10,114,3,5,395),(209,23,10,3,7,832),(210,1,177,1,8,220),(211,25,26,3,1,38),(212,17,67,2,3,324),(213,7,146,2,3,192),(214,1,98,1,9,58),(215,17,190,1,2,150),(216,25,189,1,7,206),(217,1,107,2,1,770),(218,24,186,3,9,393),(219,18,163,3,7,266),(220,17,166,3,9,935),(221,24,164,3,2,573),(222,21,94,1,10,419),(223,12,144,1,3,575),(224,21,147,2,3,746),(225,25,76,2,5,244),(226,5,73,2,8,87),(227,10,79,3,5,588),(228,19,67,3,4,546),(229,17,11,3,6,66),(230,16,144,2,2,253),(231,13,131,2,5,75),(232,12,98,3,5,468),(233,20,193,2,9,73),(234,21,155,1,9,173),(235,10,154,2,2,408),(236,22,193,3,6,280),(237,7,66,2,6,318),(238,6,11,3,8,771),(239,3,141,3,9,812),(240,21,66,2,2,965),(241,9,163,1,6,129),(242,17,58,2,7,68),(243,12,16,2,8,615),(244,25,184,2,1,451),(245,7,58,1,1,107),(246,23,29,1,8,870),(247,23,84,2,6,663),(248,7,130,2,3,59),(249,1,153,1,10,578),(250,20,115,2,7,602),(251,7,180,1,4,313),(252,11,113,2,3,196),(253,2,8,3,3,956),(254,16,8,2,2,547),(255,1,60,3,9,973),(256,4,38,1,5,450),(257,6,16,2,6,564),(258,17,72,1,4,841),(259,4,73,3,1,439),(260,8,28,2,1,220),(261,21,81,1,9,302),(262,4,164,3,3,827),(263,19,172,3,1,271),(264,11,100,3,9,936),(265,1,100,1,9,159),(266,23,128,2,3,504),(267,24,174,2,3,462),(268,10,104,3,9,622),(269,12,130,1,5,166),(270,9,190,2,8,587),(271,20,152,3,10,463),(272,3,178,2,5,681),(273,25,125,2,6,681),(274,23,9,3,5,56),(275,22,12,2,3,438),(276,4,194,1,5,203),(277,15,181,3,1,802),(278,4,57,2,4,744),(279,1,153,1,9,75),(280,7,20,1,6,548),(281,17,172,3,9,695),(282,11,190,3,9,498),(283,2,186,2,4,673),(284,13,167,2,6,942),(285,12,143,2,1,24),(286,24,170,2,5,616),(287,1,88,1,4,627),(288,25,113,2,10,691),(289,12,115,2,10,267),(290,15,167,2,6,888),(291,17,97,1,4,888),(292,13,184,1,7,202),(293,6,193,1,5,295),(294,15,94,1,9,701),(295,24,188,3,5,872),(296,10,174,2,9,169),(297,20,179,1,7,418),(298,3,177,2,2,623),(299,18,71,1,9,764),(300,2,190,3,2,532),(301,13,124,2,9,786),(302,21,25,2,5,549),(303,2,70,2,7,246),(304,7,184,3,10,774),(305,7,174,3,1,874),(306,25,52,2,10,908),(307,14,11,2,5,455),(308,15,32,2,6,626),(309,4,172,3,1,584),(310,8,183,3,1,826),(311,7,84,1,8,484),(312,18,47,2,2,460),(313,3,60,3,9,364),(314,11,109,3,9,137),(315,7,160,2,10,737),(316,25,157,3,7,336),(317,15,67,3,5,960),(318,3,180,1,3,155),(319,13,8,3,1,504),(320,6,64,3,9,803),(321,23,116,1,9,775),(322,6,60,2,9,254),(323,16,79,3,10,455),(324,11,166,1,5,972),(325,3,14,1,4,2),(326,17,12,3,10,683),(327,13,130,1,5,720),(328,9,150,1,2,516),(329,10,46,1,3,104),(330,7,89,2,1,676),(331,2,69,1,2,310),(332,8,110,1,3,22),(333,19,36,3,10,815),(334,13,119,2,9,974),(335,20,140,2,2,270),(336,22,73,3,8,925),(337,19,169,1,8,41),(338,24,39,1,6,23),(339,2,115,1,4,885),(340,5,169,3,2,617),(341,16,183,1,7,604),(342,17,42,2,6,95),(343,1,190,3,10,772),(344,19,88,2,10,860),(345,7,43,1,3,937),(346,23,16,2,3,577),(347,15,163,1,1,838),(348,23,151,2,5,964),(349,24,159,1,1,801),(350,7,195,3,7,73),(351,25,123,3,5,574),(352,2,57,1,6,774),(353,18,57,3,8,790),(354,13,1,2,4,619),(355,23,55,2,2,339),(356,1,33,3,2,904),(357,12,145,2,9,762),(358,20,122,1,6,519),(359,7,113,1,10,328),(360,9,164,1,6,125),(361,6,162,2,6,323),(362,2,177,3,7,391),(363,3,118,1,4,430),(364,2,21,1,6,970),(365,13,4,2,9,23),(366,3,7,2,6,837),(367,21,100,2,7,311),(368,9,54,3,9,727),(369,16,106,2,5,861),(370,18,171,2,4,576),(371,19,19,1,9,645),(372,10,31,1,1,965),(373,9,50,2,7,39),(374,14,65,3,10,951),(375,20,163,3,4,803),(376,7,186,3,9,149),(377,24,150,1,10,528),(378,9,19,2,10,910),(379,9,143,1,1,259),(380,23,80,3,8,44),(381,7,26,1,2,289),(382,11,103,1,8,296),(383,13,168,2,10,355),(384,4,77,3,5,636),(385,23,32,2,9,638),(386,17,87,2,8,643),(387,12,74,1,8,454),(388,20,139,2,4,472),(389,9,4,1,3,233),(390,12,180,2,5,696),(391,10,31,2,3,450),(392,11,119,1,1,384),(393,16,19,3,9,668),(394,2,49,1,6,668),(395,21,30,2,10,610),(396,11,165,3,7,375),(397,23,61,1,8,436),(398,5,18,3,3,86),(399,13,88,3,2,514),(400,15,177,3,6,834);
/*!40000 ALTER TABLE `Meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monthly_record`
--

DROP TABLE IF EXISTS `monthly_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monthly_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `monthly` date NOT NULL,
  `finish` int NOT NULL,
  `monthly_kcal` int NOT NULL,
  `monthly_time` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `monthly_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monthly_record`
--

LOCK TABLES `monthly_record` WRITE;
/*!40000 ALTER TABLE `monthly_record` DISABLE KEYS */;
INSERT INTO `monthly_record` VALUES 
(1,41,'2021-08-01',3,2000,400),
(2,41,'2021-09-01',5,900,100),
(3,41,'2021-07-01',1,100,20),
(4,1,'2021-07-01',1,100,21),
(5,1,'2021-08-01',14,1800,27),
(6,1,'2021-09-01',12,1600,66),
(7,2,'2021-09-01',10,100,21),
(8,4,'2021-09-01',2,1200,20),
(9,5,'2021-09-01',5,1800,20),
(10,6,'2021-09-01',7,1800,20),
(11,7,'2021-09-01',8,1800,20),
(12,8,'2021-09-01',10,1800,20);
/*!40000 ALTER TABLE `monthly_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Personal_Goal`
--

DROP TABLE IF EXISTS `Personal_Goal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Personal_Goal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `start_weight` float DEFAULT NULL,
  `goal_weight` float DEFAULT NULL,
  `total_lost` int DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `personal_goal_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Personal_Goal`
--

LOCK TABLES `Personal_Goal` WRITE;
/*!40000 ALTER TABLE `Personal_Goal` DISABLE KEYS */;
INSERT INTO `Personal_Goal` VALUES 
(1,1,80,70,4256,'2021-06-01'),
(2,1,70,60,17852,'2021-07-20'),
(3,2,60,50,4567,'2021-07-25'),
(4,1,68,52.5,0,'2021-08-30'),
(5,4,80,70,4256,'2021-06-01'),
(6,5,80,70,4256,'2021-06-01'),
(7,6,80,70,4256,'2021-06-01'),
(8,7,70,60,17852,'2021-07-20'),
(9,8,60,50,4567,'2021-07-25'),
(10,1,68,52.5,0,'2021-08-30');
/*!40000 ALTER TABLE `Personal_Goal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Time_period`
--

DROP TABLE IF EXISTS `Time_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Time_period` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Time_period`
--

LOCK TABLES `Time_period` WRITE;
/*!40000 ALTER TABLE `Time_period` DISABLE KEYS */;
INSERT INTO `Time_period` VALUES (1,'Breakfast'),(2,'Lunch'),(3,'Dinner');
/*!40000 ALTER TABLE `Time_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gender` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birthday` date NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `avatar_id` int DEFAULT NULL,
  `certification_status` int NOT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dateline` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `avatar_id` (`avatar_id`),
  CONSTRAINT `Users_ibfk_1` FOREIGN KEY (`avatar_id`) REFERENCES `Avatar` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES 
(1,'Funk','$2a$10$p/lWTfRvR/vKvuPqWgKon.DN461b4UFBxahuaKNG9fPBn3dsucyl6','龐克頭','Male','playfit1234@gmail.com','832-038-1019','台中市北區中正路808號','1998-08-09','1994-09-26 00:24:29',1,0,NULL,NULL),
(2,'mickey','$2a$10$p/lWTfRvR/vKvuPqWgKon.DN461b4UFBxahuaKNG9fPBn3dsucyl6','米其林','Male','mickey.rau@example.org','077-057-2468','台北市中山北路64號','1998-08-09','1998-09-24 00:24:29',1,0,NULL,NULL),
(3,'kitty','$2a$10$p/lWTfRvR/vKvuPqWgKon.DN461b4UFBxahuaKNG9fPBn3dsucyl6','你好KK','Female','kitty.rau@example.org','256-067-1357','新竹市竹科路777號','1998-08-09','0000-00-00 00:00:00',1,0,NULL,NULL),
(4,'Effie Waelchi','f04830307d50203c785c452e261f6690be35debd','quam','Male','claudie.mckenzie@example.net','033.877.6376','78868 Stamm Trail Suite 778\nWest Maiyachester, IA 16042','1998-08-09','1974-10-24 13:45:44',5,1,NULL,NULL),
(5,'Miss Carmela Erdman','a4460fb64e8666f937f69d51d568208a40e9305f','aspernatur','Female','delores.kautzer@example.org','07025232554','8063 Parker Squares Apt. 114\nNew Kaneton, LA 66489-1349','1975-08-17','1991-02-18 20:38:52',11,2,NULL,NULL),
(6,'Kylie Schmeler','0c8807b9a59b501ccb3612bf123e1d2d5691359f','voluptatem','Female','mdietrich@example.org','887-927-3660','2809 Goldner Fall Suite 903\nSouth Miles, HI 91668-9002','2011-09-15','2003-06-18 17:39:52',18,2,NULL,NULL),
(7,'Simone Robel','9b5c156fbf746db915effe445f825b540c074ce4','est','Male','consuelo.spinka@example.net','203.043.3886x91','7365 Johnston Ville\nEast Loren, MI 57113','2019-08-25','2008-01-13 02:29:18',8,3,NULL,NULL),
(8,'Miss Kiana Ryan','7adf6d1e294b169b96a662d5d04d967c345444bf','fugit','Male','chase90@example.org','1-455-623-0013x','0572 Gabe Well Apt. 298\nLake Taniaville, NC 39499','1973-02-13','2012-01-24 05:09:36',3,2,NULL,NULL),
(9,'Prof. Amara Cummings','2b2164b6c51484f42087e4c9a5ae047a3aa2bebd','qui','Male','wisoky.cathryn@example.net','204-066-9565x34','3612 Mercedes Freeway Apt. 049\nFosterland, HI 77577','1998-01-14','2021-01-16 02:49:01',6,3,NULL,NULL),
(10,'Orville Heidenreich','4063c1313438f471c1d3276bff09f23514e175f6','recusandae','Female','otis.kub@example.com','726.333.5670x22','254 Abernathy Walks Apt. 469\nSouth Makaylaville, MD 40617','1997-06-12','1990-01-09 02:44:19',10,1,NULL,NULL),
(11,'Sonny Hintz','a1241ef1daca045ae763fb19eaf8930ba1dd2cd6','alias','Male','pascale96@example.net','(734)181-9854x2','02692 Jaycee Circles\nAprilburgh, MA 88031','2003-11-26','1997-11-02 03:08:48',13,1,NULL,NULL),
(12,'Mrs. Lavada Herzog','8ce8294b5c60a0d19092011fda66ed3552d79f88','quia','Male','mariela17@example.com','1-863-636-6308x','29810 Lubowitz Plain\nDemetrisstad, PA 65645','2004-11-18','1999-10-04 00:35:30',3,3,NULL,NULL),
(13,'Dr. Zola Lind Sr.','5966416e6cf7d971637a0949ec6270a371398bd5','doloremque','Male','ellie55@example.net','1-232-565-3187x','8867 Sarai Stravenue\nEast Albert, MD 78563','1989-06-21','1991-12-13 18:11:15',10,1,NULL,NULL),
(14,'Gia Douglas','e55b97bef7ca241e6ab052b4733b37dab4706e7f','quas','Female','zwaters@example.com','903.147.9823x72','057 Darrell Knoll\nLloydborough, GA 56170-1164','2021-06-12','2006-02-02 12:07:16',16,1,NULL,NULL),
(15,'Miss Verna Marquardt','d276d2a8b15a208023c25203f46a15bcd1e4619c','sapiente','Female','precious07@example.org','871.899.6214x49','3334 Deshawn Flat\nNew Annamariemouth, WA 11646-1838','1992-06-25','2018-12-04 04:59:44',17,3,NULL,NULL),
(16,'Lucas Schimmel','8919f8026fee590577a0777541ca9f34e81ac37e','officia','Male','bergnaum.hannah@example.com','399.533.7515x12','978 Jewell Point\nNew Justineshire, DC 80105','2002-02-09','2008-05-23 18:15:07',11,3,NULL,NULL),
(17,'Deondre Little','3952ff1cca8a8eaca80e8073de62f8dcbe470d65','consectetur','Female','dickens.monique@example.net','09644154407','952 Edd Drive Apt. 398\nMarleefurt, IL 39332-3778','2013-05-15','1970-11-30 17:53:51',16,1,NULL,NULL),
(18,'Mrs. Lela Hara III','c04bf682e6016b5c48af31d351fca1586d13f450','quibusdam','Male','armstrong.giovanny@example.org','06260764980','9419 Miller Drive\nWest Cecilstad, VA 99894-6985','1996-03-27','1985-02-22 22:46:36',17,3,NULL,NULL),
(19,'Dr. Elyssa Bernier','eb8410a4e77d372bc7414c78e1a39d2969a72fb3','harum','Female','lora.klocko@example.com','531-288-2793x90','4204 Marion Garden\nWest Ashleeside, DC 67758','1992-03-26','2020-10-03 04:15:09',9,2,NULL,NULL),
(20,'Warren Klein','c2f1a47535d2e6b8d21eee899a7c68880df7d74e','dolores','Female','hollis.haley@example.net','+71(7)340085732','255 Mayer Squares\nNorth Ignacio, AL 76449','1996-11-15','1996-06-21 09:11:05',13,2,NULL,NULL),
(21,'Prof. Mohamed Huels IV','27be74838caf068b9d24f279b5a81f93cf4652b2','ut','Male','kemmer.burnice@example.net','572.252.0443','835 Connie Street Suite 024\nProsaccoborough, MN 42405-9014','1991-12-07','2000-05-10 10:32:38',8,2,NULL,NULL),
(22,'Jaydon Prohaska','1bbc23fe5392cb72af1ee37b9351ed4e06375db5','et','Male','javon.hettinger@example.org','(012)516-6853','51851 Homenick Rest Suite 349\nNormamouth, CA 93778-3886','1982-11-08','2002-05-11 13:44:48',12,1,NULL,NULL),
(23,'Toni Effertz Sr.','20fdf6c6bef7ed728fba06f6b3b0c1384ae70ab4','tenetur','Female','labadie.eduardo@example.com','(613)296-5419x1','034 Maeve Turnpike\nNew Marcellustown, SC 20876-6652','2015-08-06','2001-01-06 09:37:58',9,3,NULL,NULL),
(24,'Dr. Larue Larkin','32b63a06e108df9fdb3c8beb38dfb6297d0ae9d8','odio','Male','miller87@example.com','789-212-7857x21','5994 Ceasar Row Apt. 577\nLake Ellis, NE 84292-9325','1974-03-23','2016-11-15 19:02:47',20,2,NULL,NULL),
(25,'Gavin Collins','392059f79df2b6716b789bbb10105b75a00efae2','quo','Female','lavada.leuschke@example.com','(452)842-6797','99112 Haley Corners\nWest Marilou, RI 03661','2008-11-24','1999-07-21 22:09:49',13,2,NULL,NULL),
(26,'Noemie Cremin','a7046903d5d8c7c122c5c283eaf40640e211b813','molestiae','Female','veum.tyra@example.com','1-425-825-4998x','657 Jacobs Crest Suite 551\nLake Piper, OR 21203','2004-01-24','1988-05-15 10:45:33',18,1,NULL,NULL),
(27,'Chad Kessler','555e8a0f613e45ba89514736df00be4a3ce3a6d8','voluptas','Male','corine.crooks@example.org','07740464753','4059 Pacocha Island Suite 484\nDietrichborough, VA 37372','2013-08-29','1972-05-25 05:19:48',3,3,NULL,NULL),
(28,'Dr. Eunice Collier','110f73f864b83dcc634a289e7c0ebb30a70d2c05','magnam','Male','cboehm@example.net','133-736-8858','221 Crooks Inlet\nWest Tamia, WV 42869-6780','1986-02-02','1980-10-03 19:30:28',12,2,NULL,NULL),
(29,'Caden Luettgen','25d6977da195215937d2b3ebdb5ae10a87a53a5e','eligendi','Female','shanie94@example.com','466-826-3614x53','957 Rosalinda Islands\nCristville, GA 32027-9925','2017-12-16','1983-07-15 07:06:03',15,1,NULL,NULL),
(30,'Madisyn Lakin Jr.','3f5221cbc229924170ae7756b5c1cd9332beac75','est','Male','howell.gwendolyn@example.org','(385)301-2928x4','8835 Terry Squares\nBaumbachport, WI 65237-7948','2008-03-05','2007-07-06 01:05:46',11,2,NULL,NULL),
(31,'Marion Hahn','58220bfff0304fe6d3cf532eec0249355e5a71d3','voluptatem','Male','bpfeffer@example.org','252-021-5210','90632 Littel Hill\nWest Cornelius, MN 06082-2857','2000-02-16','1987-08-30 02:14:20',10,2,NULL,NULL),
(32,'Rosie Satterfield IV','c4296c1d3a57d2637e4bafbc354b4d5d6f3ac63f','optio','Female','tevin07@example.org','+68(9)892177164','630 Heloise Overpass\nRunolfssonstad, NY 54532-8904','1975-01-08','2015-09-23 10:10:48',7,3,NULL,NULL),
(33,'Mariana Littel','9e451ee17e02dacc9643d033581d050d8a7510bd','quas','Male','eugenia64@example.net','(802)807-8081','658 Jean Street\nEast Godfrey, TX 43443','1975-07-04','1995-02-14 02:07:17',2,2,NULL,NULL),
(34,'Rosemary Abernathy','6c52e26fd1d182d4860b81874ce891ed7ba65675','et','Female','agottlieb@example.net','032.104.4580x80','1480 Borer Stream Suite 968\nSouth Aurore, NM 25770','2011-10-09','2002-01-24 10:02:13',16,2,NULL,NULL),
(35,'Prof. Justyn Brekke II','1492ffbaa3c588907e9a297ebd7beea640e0ad08','corporis','Female','gkunde@example.com','805-086-8629','066 Quinn Extension Suite 252\nSidview, IN 72507-9229','1988-07-27','1970-03-01 20:12:12',11,3,NULL,NULL),
(36,'Litzy Hintz','cdcb7c70b541ab5359e800c3e6ab169bffbadd6b','laudantium','Female','isabelle78@example.org','1-821-900-8034x','6554 Schultz Crescent Suite 940\nWildermanbury, RI 58652-0429','2005-12-16','2005-01-18 02:13:51',12,2,NULL,NULL),
(37,'Ms. Laila Feeney','d11bd76c78c116fb078933093b56423c907254a0','molestias','Male','oda75@example.com','479-489-3249x60','9164 Bonita Views Apt. 984\nMetaville, VA 05462-3544','1985-12-20','1991-01-30 15:24:41',14,2,NULL,NULL),
(38,'Sonya Bradtke','8926b676d4d6a7826d0d0b98974cef8562b0a7de','quibusdam','Male','smorar@example.com','+79(5)713902001','863 Cremin Squares\nShayleemouth, NM 87392-5130','2004-07-05','1970-12-31 23:19:51',19,1,NULL,NULL),
(39,'Miss Antonette Glover IV','bb7d3f0bb54d23c2f9c9d6fc93df72bb6ace1dc0','consequuntur','Female','dnitzsche@example.org','940.181.4668x24','815 Fernando Forges Suite 928\nSouth Enolaburgh, MS 10004','1996-05-27','2006-10-14 16:30:14',14,3,NULL,NULL),
(40,'Ilene Beatty','1467c20d8101f7aae4f3c8537d22c69291a0c303','libero','Male','antonette.hand@example.org','1-169-043-8437x','06640 Shields Estate Apt. 860\nTremblaymouth, MT 83209','1999-06-01','2010-02-03 16:07:40',19,3,NULL,NULL);
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'playfit'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-14 15:54:27
