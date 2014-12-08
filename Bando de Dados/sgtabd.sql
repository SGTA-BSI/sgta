-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Tempo de geração: 08/12/2014 às 20:27
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
-- Estrutura para tabela `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_nasc` date NOT NULL,
  `sexo` text NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `identidade` varchar(20) NOT NULL,
  `enedereco` varchar(50) NOT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(10) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `estado` text NOT NULL,
  `bairro` varchar(25) NOT NULL,
  `telefone` int(11) NOT NULL,
  `celular` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `obsservacao` varchar(250) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `aluno`
--

CREATE TABLE IF NOT EXISTS `aluno` (
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
  `observacao` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`,`identidade`,`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Fazendo dump de dados para tabela `aluno`
--

INSERT INTO `aluno` (`id`, `nome`, `data_nasc`, `sexo`, `cpf`, `identidade`, `endereco`, `numero`, `complemento`, `cidade`, `estado`, `bairro`, `telefone`, `celular`, `email`, `observacao`) VALUES
(2, 'Antonio Jorge Ferreira Delgado Filho', '11/06/1993', 'Sexo', '101376344-04', '1000000', 'Rua São Benedito', '215', 'Casa A', 'Recife ', 'Pernambuco', 'Pina', '3216-9874', '9874-8587', 'bsi@bsi.com.br', 'Teste bem sucedido!!!');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
