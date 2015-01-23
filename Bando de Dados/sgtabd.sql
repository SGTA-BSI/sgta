-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23-Jan-2015 às 20:29
-- Versão do servidor: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sgtabd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `data_nasc` varchar(11) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `identidade` varchar(20) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `numero` varchar(25) NOT NULL,
  `complemento` varchar(10) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `bairro` varchar(25) NOT NULL,
  `telefone` varchar(25) NOT NULL,
  `celular` varchar(25) NOT NULL,
  `email` varchar(30) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`id`, `nome`, `data_nasc`, `sexo`, `cpf`, `identidade`, `endereco`, `numero`, `complemento`, `cidade`, `estado`, `bairro`, `telefone`, `celular`, `email`, `login`, `senha`) VALUES
(1, 'adm', '11/11/1970', 'Masculino', '777.777.777-77', '78787', 'Teste', '123', '', 'Teste', 'Teste', 'Teste', '(87)3434-4343', '(87)8787-7878', 'teste@teste.com', 'adm', '1234');

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
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
  `professor` varchar(25) NOT NULL,
  `observacao` varchar(250) NOT NULL,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`,`identidade`,`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`id`, `nome`, `data_nasc`, `sexo`, `cpf`, `identidade`, `endereco`, `numero`, `complemento`, `cidade`, `estado`, `bairro`, `telefone`, `celular`, `email`, `professor`, `observacao`, `status`) VALUES
(3, 'Edvan Joaquim Soares Junior', '12/12/12', 'Sexo', '123456789-78', '12354', 'Rua Bsi', '123', '', 'Recife', 'Pernambuco', 'Dois Irmãos', '1234-7898', '9874-7895', 'teste@hotmail.com', '', 'Teste', 'Ativo'),
(4, 'teste', '12/12/1212', 'Masculino', '111.111.111-11', '111111', '1111', '111', '111', '111', '111', '1111', '(11)1111-1111', '(11)1111-1111', '1111@1111.com', '', '', 'Ativo'),
(5, 'teste1', '12/12/1212', 'Masculino', '111.111.111-12', '1111112', '1111', '111', '111', '111', '111', '1111', '(11)1111-1111', '(11)1111-1111', '1111@1111.com', '', '', 'Desativo'),
(6, 'teste', '11/11/1111', 'Masculino', '121.111.111-11', '11111', '11111', '111', '1111', '1111', '1111', '1111', '(22)2222-2222', '(22)2222-2222', '22@hotmail.com', '', '', 'Ativo'),
(7, 'teste', '22/22/2222', 'Masculino', '111.111.111-22', '1111', '111', '111', '111', '111', '111', '111', '(11)1111-1111', '(11)1111-1111', '1111@111.com', '', '', 'Ativo'),
(8, 'novo teste', '22/22/1987', 'Masculino', '222.222.222-22', '1212121', 'Rua Teste', '123', '', 'Teste', 'Teste', 'Teste', '(87)3214-5698', '(78)9874-5632', 'teste@teste.com.br', '', 'Ultimo Teste bem sucedido', 'Desativo'),
(9, '1111', '11/11/1111', 'Masculino', '888.888.888-88', '88888', '88888', '8888', '88888', '8888', '8888', '888', '(88)8888-8888', '(  )    -    ', '888888888@8888.com', '', '', 'Ativo'),
(10, 'aluno1', '13/12/1985', 'Feminino', '555.555.555-55', '555555', 'Rua Aluno1', '555', '', '01', '01', '01', '(55)5555-5555', '(55)5555-5555', 'aluno01@sgta.com', 'professor', '', 'Ativo'),
(11, 'Aluno2', '14/12/1987', 'Masculino', '555.555.555-57', '78787', 'Rua Aluno 02', '02', '', '02', '02', '02', '(02)2222-2222', '(02)2222-2222', 'aluno2@sgta.com', 'professor', '', 'Desativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `exercicios`
--

CREATE TABLE IF NOT EXISTS `exercicios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  `musculo` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `exercicios`
--

INSERT INTO `exercicios` (`id`, `nome`, `musculo`) VALUES
(1, 'Supino', 'Peitoral'),
(2, 'Rosca Direta', 'Bíceps'),
(3, 'Barra fixa', 'Costas');

-- --------------------------------------------------------

--
-- Estrutura da tabela `func`
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
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `func`
--

INSERT INTO `func` (`id`, `nome`, `data_nasc`, `sexo`, `cpf`, `identidade`, `endereco`, `numero`, `complemento`, `cidade`, `estado`, `bairro`, `telefone`, `celular`, `email`, `login`, `senha`, `cargo`, `status`) VALUES
(1, 'Teste 1', '11/11/1987', 'Masculino', '111.111.111-11', '11111', 'Rua Teste', '111', '', 'Teste', 'Teste', 'Teste', '(81)7888-7878', '(78)7878-7878', 'teste@teste.com', '', '', 'Professor', 'Desativo'),
(2, 'Teste 2', '21/21/1999', 'Masculino', '333.333.333-33', '14545', 'Teste', '111', '', 'Teste', 'Teste', 'Teste', '(88)8888-8888', '(88)8888-8888', 'teste@teste.com', 'professor', '1234', 'Professor', 'Ativo'),
(3, 'ad', '12/12/2012', 'Masculino', '111.111.111-12', '111', '1111', '1111', '1111', '1111', '111', '111', '(11)1111-1111', '(77)7777-7777', 'teste@teste.com', 'teste', '123', 'Atendente', ''),
(4, 'teste', '  /  /    ', 'Masculino', '222.222.222-22', '2222', '2222', '222', '222', '222', '2222', '222', '(22)2222-2222', '(22)2222-2222', '222@222.com', 'teste', '123', 'Professor', ''),
(5, 'Teste Final', '12/11/1121', 'Feminino', '111.111.111-33', '1111', 'teste final', '333', '', 'final teste', 'Final', 'Teste', '(21)5887-8787', '(31)7878-7878', 'teste@teste.com', 'teste1', '321', 'Atendente', ''),
(6, 'Teste1201', '10/10/1010', 'Feminino', '121.212.121-22', '1212', 'Rua', '12', '', 'Recife', 'PE', 'BSI', '(12)1212-1212', '(12)2121-2121', 'teste1201@teste.com', 'teste1201', '1234', 'Atendente', 'Ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `medidas`
--

CREATE TABLE IF NOT EXISTS `medidas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` int(11) NOT NULL,
  `altura` double NOT NULL,
  `peso` double NOT NULL,
  `bracos` double NOT NULL,
  `peito` double NOT NULL,
  `coxas` double NOT NULL,
  `costas` double NOT NULL,
  `panturrilhas` double NOT NULL,
  `trapezio` double NOT NULL,
  `antebracos` double NOT NULL,
  `cintura` double NOT NULL,
  `data` text NOT NULL,
  `relatorio` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Extraindo dados da tabela `medidas`
--

INSERT INTO `medidas` (`id`, `id_aluno`, `altura`, `peso`, `bracos`, `peito`, `coxas`, `costas`, `panturrilhas`, `trapezio`, `antebracos`, `cintura`, `data`, `relatorio`) VALUES
(10, 4, 1.81, 12, 12, 12, 21, 21, 21, 21, 21, 21, '22/01/2015 04:26', ''),
(11, 4, 1.87, 12, 12, 12, 12, 12, 2, 21, 21, 21, '22/01/2015 16:27', ''),
(12, 4, 1.81, 81, 81, 81, 81, 81, 81, 81, 81, 81, '22/01/2015 17:13', 'Teste\nTeste\nTeste'),
(13, 4, 1.33, 33, 33, 33, 33, 33, 33, 33, 33, 33, '23/01/2015 02:13', '33'),
(14, 5, 1.74, 74, 12, 12, 12, 12, 12, 12, 12, 12, '23/01/2015 14:20', 'Medidas iniciais. Aluno iniciando na Academia');

-- --------------------------------------------------------

--
-- Estrutura da tabela `relac_exerc_treino_aluno`
--

CREATE TABLE IF NOT EXISTS `relac_exerc_treino_aluno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` int(11) NOT NULL,
  `id_treino` int(11) NOT NULL,
  `id_exercicio` int(11) NOT NULL,
  `repeticao` int(11) NOT NULL,
  `serie` int(11) NOT NULL,
  `carga` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `treino`
--

CREATE TABLE IF NOT EXISTS `treino` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `data_inicio` text NOT NULL,
  `data_fim` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
