CREATE TABLE `udacity`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `udacity`.`reviews` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `product_id` INT(11) NULL DEFAULT NULL,
  INDEX `review_product_fk_idx` (`product_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `review_product_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES `udacity`.`products` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

CREATE TABLE `udacity`.`comments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(200) NULL DEFAULT NULL,
  `timestamp` TIMESTAMP(6) NULL DEFAULT NULL,
  `review_id` INT NULL,
  INDEX `comments_review_fk_idx` (`review_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `comments_review_fk`
    FOREIGN KEY (`review_id`)
    REFERENCES `udacity`.`reviews` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


