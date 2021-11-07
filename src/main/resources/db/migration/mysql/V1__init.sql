CREATE TABLE `usuario` (
	`idusuario` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR (100) NOT NULL,
	`email` VARCHAR (150) NOT NULL,
	`senha` VARCHAR (30) NOT NULL,
	PRIMARY KEY (`idusuario`),
	UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;

CREATE TABLE `pet`(
	`idpet` INT NOT NULL AUTO_INCREMENT,
	`especie` VARCHAR (45) NOT NULL,
	`nome` VARCHAR (100) NOT NULL,
	`dt_Nascimento` DATE NOT NULL,
	`raca` VARCHAR (45),
	`sexo` VARCHAR (45) NOT NULL,
	`peso` INT,
	`usuario_idusuario` INT NOT NULL,
	PRIMARY KEY (`idpet`),
	INDEX `fk_pet_usuario_idx` (`usuario_idusuario` ASC),
	CONSTRAINT `fk_pet_usuario`
		FOREIGN KEY (`usuario_idusuario`)
		REFERENCES `usuario` (`idusuario`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE `dicainteracao` (
	`iddica` INT NOT NULL AUTO_INCREMENT,
	`dica` LONGTEXT,
	`tipo_Dica` VARCHAR (1),
	`especie_Dica` VARCHAR (1),
	PRIMARY KEY(`iddica`))
ENGINE = InnoDB;

CREATE TABLE `usuario_dicainteracao` (
	`usuario_idusuario` INT NOT NULL,
	`dicainteracao_iddica` INT NOT NULL,
	PRIMARY KEY (`usuario_idusuario`, `dicainteracao_iddica`),
	INDEX `fk_usuario_dicainteracao_dicainteracao_idx` (`dicainteracao_iddica` ASC),
	INDEX `fk_usuario_dicainteracao_usuario_idx` (`usuario_idusuario` ASC),
	CONSTRAINT `fk_usuario_dicainteracao_usuario`
		FOREIGN KEY (`usuario_idusuario`)
		REFERENCES `usuario` (`idusuario`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT `fk_usuario_dicainteracao_dicainteracao`
		FOREIGN KEY (`dicainteracao_iddica`)
		REFERENCES `dicainteracao` (`iddica`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE `cuidadopet` (
	`idcuidadopet` INT NOT NULL AUTO_INCREMENT,
	`data_Cuidado` DATE,
	`tipo_Cuidado` VARCHAR (1),
	`nome_Cuidado` VARCHAR (50),
	`pet_idpet` INT NOT NULL,
	PRIMARY KEY (`idcuidadopet`),
	INDEX `fk_cuidadopet_pet_idx` (`pet_idpet` ASC),
	CONSTRAINT `fk_cuidadopet_pet`
		FOREIGN KEY (`pet_idpet`)
		REFERENCES `pet` (`idpet`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION)
ENGINE = InnoDB;
