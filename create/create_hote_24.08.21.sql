-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Hotel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Hotel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Hotel` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci ;
-- -----------------------------------------------------
-- Schema my_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema my_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `my_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema hotel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `Hotel` ;

-- -----------------------------------------------------
-- Table `Hotel`.`guest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`guest` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT(3) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`room` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `capacity` INT NOT NULL,
  `room_status` ENUM('OPEN', 'CLOSED', 'REPAIR') NOT NULL DEFAULT 'OPEN',
  `price` DOUBLE NOT NULL,
  `stars` ENUM('ONE', 'TWO', 'THREE', 'FOUR', 'FIVE') NOT NULL DEFAULT 'ONE',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`order` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `id_guest` BIGINT(4) NULL,
  `id_room` BIGINT(4) NULL,
  `check_in` DATE NULL,
  `check_out` DATE NULL,
  `status` ENUM('CHECKIN', 'CHECKOUT') NULL DEFAULT 'CHECKIN',
  PRIMARY KEY (`id`),
  INDEX `fk_order_guest_idx` (`id_guest` ASC) VISIBLE,
  INDEX `fk_order_room1_idx` (`id_room` ASC) VISIBLE,
  CONSTRAINT `guest_id`
    FOREIGN KEY (`id_guest`)
    REFERENCES `Hotel`.`guest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `room_id`
    FOREIGN KEY (`id_room`)
    REFERENCES `Hotel`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`maintenance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`maintenance` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`ord_maint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`ord_maint` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_order` BIGINT(4) NOT NULL,
  `id_maintenance` BIGINT(4) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ord_maint_order1_idx` (`id_order` ASC) VISIBLE,
  INDEX `fk_ord_maint_maintenance1_idx` (`id_maintenance` ASC) VISIBLE,
  CONSTRAINT `order_id`
    FOREIGN KEY (`id_order`)
    REFERENCES `Hotel`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `maintenance_id`
    FOREIGN KEY (`id_maintenance`)
    REFERENCES `Hotel`.`maintenance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `my_db` ;

-- -----------------------------------------------------
-- Table `my_db`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`departments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NULL DEFAULT NULL,
  `max_salary` INT NULL DEFAULT NULL,
  `min_salary` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_db`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_db`.`employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NULL DEFAULT NULL,
  `surname` VARCHAR(25) NULL DEFAULT NULL,
  `salary` INT NULL DEFAULT NULL,
  `department_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `department_id` (`department_id` ASC) VISIBLE,
  CONSTRAINT `employees_ibfk_1`
    FOREIGN KEY (`department_id`)
    REFERENCES `my_db`.`departments` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `hotel` ;

-- -----------------------------------------------------
-- Table `hotel`.`guest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel`.`guest` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `age` INT NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotel`.`maintenance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel`.`maintenance` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotel`.`ord_maint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel`.`ord_maint` (
  `id_order` BIGINT NOT NULL,
  `id_maintenance` BIGINT NOT NULL,
  UNIQUE INDEX `UK_b7cckd65cucwu97bt2pexxt0a` (`id_maintenance` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotel`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel`.`room` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `capacity` INT NULL DEFAULT NULL,
  `number` INT NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `stars` VARCHAR(255) NULL DEFAULT NULL,
  `room_status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
