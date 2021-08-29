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
CREATE SCHEMA IF NOT EXISTS `Hotel` DEFAULT CHARACTER SET utf8 ;
USE `Hotel` ;

-- -----------------------------------------------------
-- Table `Hotel`.`guests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`guests` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT(3) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`rooms` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `capacity` INT NOT NULL,
  `room_status` ENUM('OPEN', 'CLOSED', 'REPAIR') NOT NULL DEFAULT 'OPEN',
  `price` DOUBLE NOT NULL,
  `stars` ENUM('ONE', 'TWO', 'THREE', 'FOUR', 'FIVE') NOT NULL DEFAULT 'ONE',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`orders` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `id_guest` BIGINT(4) NULL,
  `id_room` BIGINT(4) NULL,
  `check_in` DATE NULL,
  `check_out` DATE NULL,
  `status` ENUM('CHECKIN', 'CHECKOUT') NOT NULL DEFAULT 'CHECKIN',
  PRIMARY KEY (`id`),
  INDEX `fk_order_guest_idx` (`id_guest` ASC) VISIBLE,
  INDEX `fk_order_room1_idx` (`id_room` ASC) VISIBLE,
  CONSTRAINT `guest_id`
    FOREIGN KEY (`id_guest`)
    REFERENCES `Hotel`.`guests` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `room_id`
    FOREIGN KEY (`id_room`)
    REFERENCES `Hotel`.`rooms` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`maintenances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`maintenances` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`ord_maint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`ord_maint` (
  `id_order` BIGINT(4) NOT NULL,
  `id_maintenance` BIGINT(4) NOT NULL,
  INDEX `fk_ord_maint_order1_idx` (`id_order` ASC) VISIBLE,
  INDEX `fk_ord_maint_maintenance1_idx` (`id_maintenance` ASC) VISIBLE,
  CONSTRAINT `order_id`
    FOREIGN KEY (`id_order`)
    REFERENCES `Hotel`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `maintenance_id`
    FOREIGN KEY (`id_maintenance`)
    REFERENCES `Hotel`.`maintenances` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
