CREATE TABLE `usuario` (
	`idusuario` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR (150) NOT NULL,
	`email` VARCHAR (100) NOT NULL,
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

CREATE TABLE `veterinario` (
	`idveterinario` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR (150) NOT NULL,
	`especialidade` VARCHAR (150) NOT NULL,
	`telefone` VARCHAR (30) NOT NULL,
	`endereco` VARCHAR (200) NOT NULL,
	PRIMARY KEY(`idveterinario`),
	UNIQUE INDEX `nome_UNIQUE` (`nome` ASC))
ENGINE = InnoDB;

CREATE TABLE `pet_veterinario` (
	`pet_idpet` INT NOT NULL,
	`veterinario_idveterinario` INT NOT NULL,
	PRIMARY KEY (`pet_idpet`, `veterinario_idveterinario`),
	INDEX `fk_pet_veterinario_veterinario_idx` (`veterinario_idveterinario` ASC),
	INDEX `fk_pet_veterinario_pet_idx` (`pet_idpet` ASC),
	CONSTRAINT `fk_pet_veterinario_pet`
		FOREIGN KEY (`pet_idpet`)
		REFERENCES `pet` (`idpet`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT `fk_pet_veterinario_veterinario`
		FOREIGN KEY (`veterinario_idveterinario`)
		REFERENCES `veterinario` (`idveterinario`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE `fichasaude` (
	`idficha` INT NOT NULL AUTO_INCREMENT,
	`nome_Saude` VARCHAR (100),
	`data_Saude` DATE,
	`hora_Saude` TIME,
	`tipo_Saude` VARCHAR (1),
	`pet_idpet` INT NOT NULL,
	`veterinario_idveterinario` INT NOT NULL,
	PRIMARY KEY (`idficha`),
	INDEX `fk_fichasaude_pet_idx` (`pet_idpet` ASC),
	INDEX `fk_fichasaude_veterinario_idx` (`veterinario_idveterinario` ASC),
	CONSTRAINT `fk_fichasaude_pet`
		FOREIGN KEY (`pet_idpet`)
		REFERENCES `pet` (`idpet`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT `fk_fichasaude_veterinario`
		FOREIGN KEY (`veterinario_idveterinario`)
		REFERENCES `veterinario` (`idveterinario`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE `medicamento` (
	`idmedicamento` INT NOT NULL AUTO_INCREMENT,
	`nome_Med` VARCHAR (50) NOT NULL,
	`finalidade_Med` VARCHAR (150), 
	`dose_Med` VARCHAR (50) NOT NULL,
	`hora_Med` TIME NOT NULL,
	`intervalo` INT NOT NULL,
	`data_Inicial` DATE NOT NULL,
	`data_Final` DATE NOT NULL,
	`fichasaude_idficha` INT NOT NULL,
	PRIMARY KEY (`idmedicamento`),
	INDEX `fk_medicamento_fichasaude_idx` (`fichasaude_idficha` ASC),
	CONSTRAINT `fk_medicamento_fichasaude`
		FOREIGN KEY (`fichasaude_idficha`)
		REFERENCES `fichasaude` (`idficha`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION)
ENGINE = InnoDB; 
