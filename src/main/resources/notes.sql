CREATE TABLE `notes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `note` varchar(100) NOT NULL,
  `createTime` int DEFAULT NULL,
  `updateTime` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
