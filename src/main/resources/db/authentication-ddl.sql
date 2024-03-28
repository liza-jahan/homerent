--
-- Table structure for table `permission_role`
--

DROP TABLE IF EXISTS `permission_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission_role`
(
    `role_id`       bigint NOT NULL,
    `permission_id` bigint NOT NULL,
    PRIMARY KEY (`role_id`, `permission_id`),
    KEY `FK6mg4g9rc8u87l0yavf8kjut05` (`permission_id`),
    CONSTRAINT `FK3vhflqw0lwbwn49xqoivrtugt` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
    CONSTRAINT `FK6mg4g9rc8u87l0yavf8kjut05` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_role`
--

LOCK TABLES `permission_role` WRITE;
/*!40000 ALTER TABLE `permission_role`
    DISABLE KEYS */;
INSERT INTO `permission_role`
VALUES (1, 1);
/*!40000 ALTER TABLE `permission_role`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions`
(
    `id`                    bigint       NOT NULL AUTO_INCREMENT,
    `description`           varchar(255) DEFAULT NULL,
    `name`                  varchar(255) NOT NULL,
    `requires_verification` bit(1)       NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions`
    DISABLE KEYS */;
INSERT INTO `permissions`
VALUES (1, 'Permission to fetch all users', 'users:read', _binary ''),
       (2, 'Permission to fetch all users', 'users:read', _binary '');
/*!40000 ALTER TABLE `permissions`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles`
(
    `id`          bigint NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        text   NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `roles_chk_1` CHECK ((`name` between 0 and 1))
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles`
    DISABLE KEYS */;
INSERT INTO `roles`
VALUES (1, 'Role for users that carry out administrative functions on the application', 'ROLE_ADMIN'),
       (2, 'Role for users that carry out customer functions on the application', 'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `roles`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokens`
(
    `id`         bigint                                NOT NULL AUTO_INCREMENT,
    `revoked`    bit(1)                                NOT NULL,
    `token`      varchar(512)                          NOT NULL,
    `token_type` enum ('ACCESS_TOKEN','REFRESH_TOKEN') NOT NULL,
    `user_id`    varchar(36) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK2dylsfo39lgjyqml2tbe0b0ss` (`user_id`),
    CONSTRAINT `FK2dylsfo39lgjyqml2tbe0b0ss` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokens`
--

LOCK TABLES `tokens` WRITE;
/*!40000 ALTER TABLE `tokens`
    DISABLE KEYS */;
INSERT INTO `tokens`
VALUES (2, _binary '',
        'eyJhbGciOiJIUzI1NiJ9.eyJmaXJzdE5hbWUiOiJSZWphdWwiLCJsYXN0TmFtZSI6IkthcmltIiwicGhvbmVOdW1iZXIiOiIwMTUxNjEzNDI1OCIsInZlcmlmaWVkIjpmYWxzZSwiYXV0aG9yaXRpZXMiOiJST0xFX0NVU1RPTUVSIiwidXNlcm5hbWUiOiJ1c2VyQGdtYWlsLmNvbSIsImlhdCI6MTcxMTUxMTUyMSwiaXNzIjoic2VsZiIsInN1YiI6InVzZXJAZ21haWwuY29tIiwiZXhwIjoxNzExNTEzMzIxfQ.TJQj-MNK6cMjb6qp-TspPzv8xfgBDe5c8vhIEfJuhX4',
        'ACCESS_TOKEN', '8a7bfeab-9eac-4102-b9a6-22a0fa2bcfa3'),
       (3, _binary '',
        'eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InVzZXJAZ21haWwuY29tIiwiaWF0IjoxNzExNTExNTI0LCJpc3MiOiJzZWxmIiwic3ViIjoidXNlckBnbWFpbC5jb20iLCJleHAiOjE3MTE1OTc5MjR9.U3RSPAPIyU6tZIA5QWB65Wh5WN-m1ehBFK-QFSY2Nd4',
        'REFRESH_TOKEN', '8a7bfeab-9eac-4102-b9a6-22a0fa2bcfa3'),
       (4, _binary '',
        'eyJhbGciOiJIUzI1NiJ9.eyJmaXJzdE5hbWUiOiJSZWphdWwiLCJsYXN0TmFtZSI6IkthcmltIiwicGhvbmVOdW1iZXIiOiIwMTUxNjEzNDI1OCIsInZlcmlmaWVkIjpmYWxzZSwiYXV0aG9yaXRpZXMiOiJST0xFX0NVU1RPTUVSIiwidXNlcm5hbWUiOiJ1c2VyQGdtYWlsLmNvbSIsImlhdCI6MTcxMTUxMjAzNSwiaXNzIjoic2VsZiIsInN1YiI6InVzZXJAZ21haWwuY29tIiwiZXhwIjoxNzExNTEzODM1fQ.CRgomE1S7NRXSHgvx5k7UgciMdj4K8bW9jd5d7auWVI',
        'ACCESS_TOKEN', '8a7bfeab-9eac-4102-b9a6-22a0fa2bcfa3'),
       (5, _binary '',
        'eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InVzZXJAZ21haWwuY29tIiwiaWF0IjoxNzExNTEyMDM1LCJpc3MiOiJzZWxmIiwic3ViIjoidXNlckBnbWFpbC5jb20iLCJleHAiOjE3MTE1OTg0MzV9.t5oV1RKhub-s3Z4w5BfGF-AAZBLh_GrJjYnVY_CR05s',
        'REFRESH_TOKEN', '8a7bfeab-9eac-4102-b9a6-22a0fa2bcfa3'),
       (6, _binary '\0',
        'eyJhbGciOiJIUzI1NiJ9.eyJmaXJzdE5hbWUiOiJSZWphdWwiLCJsYXN0TmFtZSI6IkthcmltIiwicGhvbmVOdW1iZXIiOiIwMTUxNjEzNDI1OCIsInZlcmlmaWVkIjpmYWxzZSwiYXV0aG9yaXRpZXMiOiJST0xFX0NVU1RPTUVSIiwidXNlcm5hbWUiOiJ1c2VyQGdtYWlsLmNvbSIsImlhdCI6MTcxMTUxMzM4NSwiaXNzIjoic2VsZiIsInN1YiI6InVzZXJAZ21haWwuY29tIiwiZXhwIjoxNzExNTE1MTg1fQ.kaYx7UvD3FqL-Yz31zPMQNKvpMEU9bpa168HScWqp7k',
        'ACCESS_TOKEN', '8a7bfeab-9eac-4102-b9a6-22a0fa2bcfa3'),
       (7, _binary '\0',
        'eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InVzZXJAZ21haWwuY29tIiwiaWF0IjoxNzExNTEzMzg1LCJpc3MiOiJzZWxmIiwic3ViIjoidXNlckBnbWFpbC5jb20iLCJleHAiOjE3MTE1OTk3ODV9._RajNfkWdlF3SkQiv_j5lMjaZL6Gb1FiwWmmG_u94Fs',
        'REFRESH_TOKEN', '8a7bfeab-9eac-4102-b9a6-22a0fa2bcfa3');
/*!40000 ALTER TABLE `tokens`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role`
(
    `user_id` varchar(36) NOT NULL,
    `role_id` bigint      NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`),
    CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role`
    DISABLE KEYS */;
INSERT INTO `user_role`
VALUES ('8a7bfeab-9eac-4102-b9a6-22a0fa2bcfa3', 2);
/*!40000 ALTER TABLE `user_role`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users`
(
    `id`                      varchar(36)  NOT NULL,
    `created_time`            datetime(6)  DEFAULT NULL,
    `last_update_time`        datetime(6)  DEFAULT NULL,
    `last_updated_by`         datetime(6)  DEFAULT NULL,
    `account_non_expired`     bit(1)       NOT NULL,
    `account_non_locked`      bit(1)       NOT NULL,
    `credentials_non_expired` bit(1)       NOT NULL,
    `enabled`                 bit(1)       NOT NULL,
    `first_name`              varchar(255) NOT NULL,
    `last_name`               varchar(255) NOT NULL,
    `password`                varchar(255) NOT NULL,
    `phone_number`            varchar(255) DEFAULT NULL,
    `username`                varchar(255) NOT NULL,
    `verified`                bit(1)       NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users`
    DISABLE KEYS */;
INSERT INTO `users`
VALUES ('8a7bfeab-9eac-4102-b9a6-22a0fa2bcfa3', NULL, NULL, NULL, _binary '', _binary '', _binary '', _binary '',
        'Rejaul', 'Karim', '$2a$10$c8o2GV5GwRuzO5uupPfhNeJxIJxbP3ITRr53KivJOp.wjiG7bE8ky', '01516134258',
        'user@gmail.com', _binary '\0');
/*!40000 ALTER TABLE `users`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

