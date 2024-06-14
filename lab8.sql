CREATE DATABASE  IF NOT EXISTS `lab8` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lab8`;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab8` DEFAULT CHARACTER SET utf8 ;
USE `lab8` ;

-- -----------------------------------------------------
-- Table `lab8`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab8`.`user` (
  `iduser` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `username` VARCHAR(256) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab8`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab8`.`movie` (
  `idmovie` INT NOT NULL,
  `titulo` VARCHAR(255) NOT NULL,
  `overview` VARCHAR(255) NOT NULL,
  `popularidad` INT(100) NOT NULL,
  `fecha_lanzamiento` DATE NOT NULL,
  `iduser` INT NOT NULL,
  PRIMARY KEY (`idmovie`),
  INDEX `fk_movie_user_idx` (`iduser` ASC) VISIBLE,
  CONSTRAINT `fk_movie_user`
    FOREIGN KEY (`iduser`)
    REFERENCES `lab8`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
