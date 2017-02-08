-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bulk-smart
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bulk-smart
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bulk-smart` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema inventory
-- -----------------------------------------------------
USE `bulk-smart` ;

-- -----------------------------------------------------
-- Table `bulk-smart`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bulk-smart`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(225) NOT NULL,
  `email` VARCHAR(45) NULL,
  `phone_number` INT(30) NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bulk-smart`.`sms-settings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bulk-smart`.`sms-settings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `twilio_api_sid` VARCHAR(45) NOT NULL,
  `twilio_api_key` VARCHAR(45) NOT NULL,
  `users_id` INT NOT NULL,
  `twilio_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_sms-settings_users_idx` (`users_id` ASC),
  UNIQUE INDEX `twilio_api_key_UNIQUE` (`twilio_api_key` ASC),
  UNIQUE INDEX `twilio_api_sid_UNIQUE` (`twilio_api_sid` ASC),
  CONSTRAINT `fk_sms-settings_users`
  FOREIGN KEY (`users_id`)
  REFERENCES `bulk-smart`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bulk-smart`.`receivers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bulk-smart`.`receivers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `phone_number` VARCHAR(30) NULL,
  `country_code` VARCHAR(10) NULL,
  PRIMARY KEY (`id`, `first_name`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bulk-smart`.`groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bulk-smart`.`groups` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bulk-smart`.`messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bulk-smart`.`messages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(140) NOT NULL,
  `send_time` DATETIME NOT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_messages_users1_idx` (`users_id` ASC))
  -- CONSTRAINT `fk_messages_users1`
  --  FOREIGN KEY (`users_id`)
  -- REFERENCES `bulk-smart`.`users` (`id`)
  --  ON DELETE CASCADE
  --  ON UPDATE CASCADE)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bulk-smart`.`receivers_messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bulk-smart`.`receivers_messages` (
  `receivers_id` INT NOT NULL,
  `messages_id` INT NOT NULL,
  PRIMARY KEY (`receivers_id`, `messages_id`),
  INDEX `fk_receivers_has_messages_messages1_idx` (`messages_id` ASC),
  INDEX `fk_receivers_has_messages_receivers1_idx` (`receivers_id` ASC),
  CONSTRAINT `fk_receivers_has_messages_receivers1`
  FOREIGN KEY (`receivers_id`)
  REFERENCES `bulk-smart`.`receivers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bulk-smart`.`receivers_groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bulk-smart`.`receivers_groups` (
  `receivers_id` INT NOT NULL,
  `groups_id` INT NOT NULL,
  PRIMARY KEY (`receivers_id`, `groups_id`),
  INDEX `fk_receivers_has_groups_groups1_idx` (`groups_id` ASC),
  INDEX `fk_receivers_has_groups_receivers1_idx` (`receivers_id` ASC),
  CONSTRAINT `fk_receivers_has_groups_receivers1`
  FOREIGN KEY (`receivers_id`)
  REFERENCES `bulk-smart`.`receivers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_receivers_has_groups_groups1`
  FOREIGN KEY (`groups_id`)
  REFERENCES `bulk-smart`.`groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bulk-smart`.`group_messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bulk-smart`.`group_messages` (
  `messages_id` INT NOT NULL,
  `groups_id` INT NOT NULL,
  PRIMARY KEY (`messages_id`, `groups_id`),
  INDEX `fk_messages_has_groups_groups1_idx` (`groups_id` ASC),
  INDEX `fk_messages_has_groups_messages1_idx` (`messages_id` ASC),
  CONSTRAINT `fk_messages_has_groups_groups1`
  FOREIGN KEY (`groups_id`)
  REFERENCES `bulk-smart`.`groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
