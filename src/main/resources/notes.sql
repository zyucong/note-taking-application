CREATE TABLE `notes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text_note` varchar(100) NOT NULL,
  `create_time` bigint DEFAULT NULL,
  `update_time` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
