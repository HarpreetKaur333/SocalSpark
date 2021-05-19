
create database IF NOT EXISTS Social_Spark_db;
use Social_Spark_db;

CREATE TABLE user ( 
	UserId int NOT NULL AUTO_INCREMENT,
	FirstName varchar(100) NOT NULL,
    LastName varchar(100)  NOT NULL,
    Email varchar(500)  NOT NULL,
    Password varchar(100)  NOT NULL,
	PRIMARY KEY (`UserId`)
);
CREATE TABLE `social_spark_db`.`post` (
  `PostId` INT NOT NULL AUTO_INCREMENT,
  `UserId` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `content` VARCHAR(45) NULL,
  PRIMARY KEY (`PostId`));
CREATE TABLE `social_spark_db`.`friends` (
  `FrndId` INT NOT NULL AUTO_INCREMENT,
  `UserId` INT NOT NULL,
  `Status` INT NOT NULL,
  PRIMARY KEY (`FrndId`));
  
  CREATE TABLE `social_spark_db`.`savedposts` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `PostId` VARCHAR(45) NOT NULL,
  `UserId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`));
  
  CREATE TABLE `social_spark_db`.`likes` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `UserId` VARCHAR(45) NOT NULL,
  `PostId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`));
  
  CREATE TABLE `social_spark_db`.`notifications` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` INT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`));
  
  ALTER TABLE `social_spark_db`.`notifications` 
ADD COLUMN `ToUserId` VARCHAR(45) NOT NULL AFTER `FromUserId`,
CHANGE COLUMN `UserId` `FromUserId` VARCHAR(45) NOT NULL ;

   CREATE TABLE `social_spark_db`.`messages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `FromUserId` INT NOT NULL,
   `ToUserId` INT NOT NULL,
  `message` VARCHAR(500)  NOT NULL,
  PRIMARY KEY (`id`));