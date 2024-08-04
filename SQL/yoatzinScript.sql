-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema yoatzin
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema yoatzin
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `yoatzin` DEFAULT CHARACTER SET utf8 ;
USE `yoatzin` ;

-- -----------------------------------------------------
-- Table `yoatzin`.`privileges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yoatzin`.`privileges` (
  `id_privilege` BIGINT NOT NULL AUTO_INCREMENT,
  `privilege` VARCHAR(20) NOT NULL,
  `description` LONGTEXT NULL,
  PRIMARY KEY (`id_privilege`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yoatzin`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yoatzin`.`users` (
  `id_user` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(10) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `fk_id_privilege` BIGINT NOT NULL,
  PRIMARY KEY (`id_user`, `fk_id_privilege`),
  INDEX `user_has_privilege_idx` (`fk_id_privilege` ASC) VISIBLE,
  CONSTRAINT `user_has_privilege`
    FOREIGN KEY (`fk_id_privilege`)
    REFERENCES `yoatzin`.`privileges` (`id_privilege`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yoatzin`.`cards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yoatzin`.`cards` (
  `id_card` BIGINT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(16) NOT NULL,
  `owner_card` VARCHAR(100) NOT NULL,
  `month` VARCHAR(2) NOT NULL,
  `year` VARCHAR(4) NOT NULL,
  `cvc` VARCHAR(4) NOT NULL,
  `fk_id_user` BIGINT NOT NULL,
  PRIMARY KEY (`id_card`),
  INDEX `cards_has_users_idx` (`fk_id_user` ASC) VISIBLE,
  CONSTRAINT `cards_has_users`
    FOREIGN KEY (`fk_id_user`)
    REFERENCES `yoatzin`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yoatzin`.`addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yoatzin`.`addresses` (
  `id_address` BIGINT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(20) NOT NULL,
  `city` VARCHAR(50) NOT NULL,
  `colony` VARCHAR(50) NOT NULL,
  `street` VARCHAR(50) NOT NULL,
  `zipcode` VARCHAR(5) NOT NULL,
  `reference` VARCHAR(45) NULL,
  `fk_id_user` BIGINT NOT NULL,
  PRIMARY KEY (`id_address`),
  INDEX `addresses_has_user_idx` (`fk_id_user` ASC) VISIBLE,
  CONSTRAINT `addresses_has_user`
    FOREIGN KEY (`fk_id_user`)
    REFERENCES `yoatzin`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yoatzin`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yoatzin`.`orders` (
  `id_order` BIGINT NOT NULL AUTO_INCREMENT,
  `quantity` INT(2) NOT NULL,
  `date` DATETIME NOT NULL,
  `fk_id_user` BIGINT NOT NULL,
  `fk_id_card` BIGINT NOT NULL,
  `fk_id_address` BIGINT NOT NULL,
  PRIMARY KEY (`id_order`, `fk_id_card`, `fk_id_address`),
  INDEX `orders_has_cards_idx` (`fk_id_card` ASC) VISIBLE,
  INDEX `orders_has_users_idx` (`fk_id_user` ASC) VISIBLE,
  INDEX `orders_has_addresses_idx` (`fk_id_address` ASC) VISIBLE,
  CONSTRAINT `orders_has_cards`
    FOREIGN KEY (`fk_id_card`)
    REFERENCES `yoatzin`.`cards` (`id_card`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orders_has_users`
    FOREIGN KEY (`fk_id_user`)
    REFERENCES `yoatzin`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orders_has_addresses`
    FOREIGN KEY (`fk_id_address`)
    REFERENCES `yoatzin`.`addresses` (`id_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yoatzin`.`sizes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yoatzin`.`sizes` (
  `id_size` BIGINT NOT NULL AUTO_INCREMENT,
  `size` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_size`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yoatzin`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yoatzin`.`products` (
  `id_product` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `image` VARCHAR(250) NOT NULL,
  `origin` VARCHAR(70) NULL,
  `stock` INT(5) NOT NULL,
  `description` LONGTEXT NULL,
  `fk_id_size` BIGINT NOT NULL,
  PRIMARY KEY (`id_product`, `fk_id_size`),
  INDEX `products_has_sizes_idx` (`fk_id_size` ASC) VISIBLE,
  CONSTRAINT `products_has_sizes`
    FOREIGN KEY (`fk_id_size`)
    REFERENCES `yoatzin`.`sizes` (`id_size`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yoatzin`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yoatzin`.`comments` (
  `id_comment` BIGINT NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(280) NULL,
  `fk_id_user` BIGINT NOT NULL,
  PRIMARY KEY (`id_comment`),
  INDEX `comments_has_user_idx` (`fk_id_user` ASC) VISIBLE,
  CONSTRAINT `comments_has_user`
    FOREIGN KEY (`fk_id_user`)
    REFERENCES `yoatzin`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yoatzin`.`products_has_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yoatzin`.`products_has_orders` (
  `id_product` BIGINT NOT NULL,
  `id_order` BIGINT NOT NULL,
  `partial_amount` DECIMAL(10,2) NOT NULL,
  `discount` DECIMAL(10,2) NOT NULL,
  `shipment` DECIMAL(10,2) NOT NULL,
  `final_amount` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id_product`, `id_order`),
  INDEX `fk_products_has_orders_orders1_idx` (`id_order` ASC) VISIBLE,
  INDEX `fk_products_has_orders_products1_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `fk_products_has_orders_products1`
    FOREIGN KEY (`id_product`)
    REFERENCES `yoatzin`.`products` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_has_orders_orders1`
    FOREIGN KEY (`id_order`)
    REFERENCES `yoatzin`.`orders` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
