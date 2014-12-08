-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08-Dez-2014 às 18:45
-- Versão do servidor: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sgtadb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
`id` int(11) NOT NULL,
  `nome` text NOT NULL,
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
  `senha` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE IF NOT EXISTS `aluno` (
`id` int(11) NOT NULL,
  `nome` text NOT NULL,
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
  `obsservacao` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `login` (`login`);

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `cpf` (`cpf`,`identidade`,`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
