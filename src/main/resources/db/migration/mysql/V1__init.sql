CREATE TABLE `usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR (100) NOT NULL,
	`email` VARCHAR (150) NOT NULL,
	`senha` VARCHAR (30) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;

CREATE TABLE `pet`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`especie` VARCHAR (45) NOT NULL,
	`nome` VARCHAR (100) NOT NULL,
	`dt_Nascimento` DATE NOT NULL,
	`raca` VARCHAR (45),
	`sexo` VARCHAR (45) NOT NULL,
	`peso` FLOAT,
	`usuario_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_pet_usuario_idx` (`usuario_id` ASC),
	CONSTRAINT `fk_pet_usuario`
		FOREIGN KEY (`usuario_id`)
		REFERENCES `usuario` (`id`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION)
ENGINE = InnoDB;