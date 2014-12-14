-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Tempo de geração: 14/12/2014 às 22:50
-- Versão do servidor: 5.6.16
-- Versão do PHP: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `sgtabd`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `func`
--

CREATE TABLE IF NOT EXISTS `func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  `data_nasc` varchar(250) NOT NULL,
  `sexo` varchar(250) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `identidade` varchar(20) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `numero` varchar(11) NOT NULL,
  `complemento` varchar(10) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `estado` varchar(250) NOT NULL,
  `bairro` varchar(25) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `login` varchar(25) NOT NULL,
  `senha` varchar(25) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Fazendo dump de dados para tabela `func`
--

UPDATE `func` SET `id` = 1,`nome` = 'Teste 1',`data_nasc` = '11/11/1987',`sexo` = 'Masculino',`cpf` = '111.111.111-11',`identidade` = '11111',`endereco` = 'Rua Teste',`numero` = '111',`complemento` = '',`cidade` = 'Teste',`estado` = 'Teste',`bairro` = 'Teste',`telefone` = '(81)7888-7878',`celular` = '(78)7878-7878',`email` = 'teste@teste.com',`login` = '',`senha` = '',`cargo` = 'Professor' WHERE `func`.`id` = 1;
UPDATE `func` SET `id` = 2,`nome` = 'Teste 2',`data_nasc` = '21/21/1999',`sexo` = 'Feminino',`cpf` = '   .   .   -  ',`identidade` = '14545',`endereco` = 'Teste',`numero` = '111',`complemento` = '',`cidade` = 'Teste',`estado` = 'Teste',`bairro` = 'Teste',`telefone` = '(  )    -    ',`celular` = '(  )    -    ',`email` = 'teste@teste.com',`login` = 'teste',`senha` = '123',`cargo` = 'Professor' WHERE `func`.`id` = 2;
UPDATE `func` SET `id` = 3,`nome` = 'ad',`data_nasc` = '12/12/2012',`sexo` = 'Masculino',`cpf` = '111.111.111-12',`identidade` = '111',`endereco` = '1111',`numero` = '1111',`complemento` = '1111',`cidade` = '1111',`estado` = '111',`bairro` = '111',`telefone` = '(11)1111-1111',`celular` = '(77)7777-7777',`email` = 'teste@teste.com',`login` = 'teste',`senha` = '123',`cargo` = 'Atendente' WHERE `func`.`id` = 3;
UPDATE `func` SET `id` = 4,`nome` = 'teste',`data_nasc` = '  /  /    ',`sexo` = 'Masculino',`cpf` = '222.222.222-22',`identidade` = '2222',`endereco` = '2222',`numero` = '222',`complemento` = '222',`cidade` = '222',`estado` = '2222',`bairro` = '222',`telefone` = '(22)2222-2222',`celular` = '(22)2222-2222',`email` = '222@222.com',`login` = 'teste',`senha` = '123',`cargo` = 'Professor' WHERE `func`.`id` = 4;
UPDATE `func` SET `id` = 5,`nome` = 'Teste Final',`data_nasc` = '12/11/1121',`sexo` = 'Feminino',`cpf` = '111.111.111-33',`identidade` = '1111',`endereco` = 'teste final',`numero` = '333',`complemento` = '',`cidade` = 'final teste',`estado` = 'Final',`bairro` = 'Teste',`telefone` = '(21)5887-8787',`celular` = '(31)7878-7878',`email` = 'teste@teste.com',`login` = 'teste1',`senha` = '321',`cargo` = 'Atendente' WHERE `func`.`id` = 5;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
