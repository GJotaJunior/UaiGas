-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 19-Dez-2020 às 05:00
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `uaigas_api`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_combustivel`
--


CREATE TABLE `tb_combustivel` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_combustivel`
--

INSERT INTO `tb_combustivel` (`id`, `nome`) VALUES
(1, 'Gasolina'),
(2, 'Etanol'),
(3, 'Diesel');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_combustivel_posto`
--

CREATE TABLE `tb_combustivel_posto` (
  `id` bigint(20) NOT NULL,
  `combustivel_id` bigint(20) DEFAULT NULL,
  `cotacao_id` bigint(20) DEFAULT NULL,
  `posto_id` bigint(20) DEFAULT NULL,
  `tipo_combustivel_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cotacao`
--

CREATE TABLE `tb_cotacao` (
  `id` bigint(20) NOT NULL,
  `data_hora` datetime DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `combustivel_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_cotacao`
--

INSERT INTO `tb_cotacao` (`id`, `data_hora`, `preco`, `combustivel_id`) VALUES
(1, '2020-12-19 01:57:46', 20, 3),
(2, '2020-12-19 01:57:46', 17, 1),
(3, '2020-12-19 01:57:46', 19.35, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_endereco`
--

CREATE TABLE `tb_endereco` (
  `id` bigint(20) NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `posto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_posto`
--

CREATE TABLE `tb_posto` (
  `id` bigint(20) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `endereco` tinyblob DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_posto`
--

INSERT INTO `tb_posto` (`id`, `descricao`, `endereco`, `status`) VALUES
(1, 'Posto Ipiranga', NULL, 0),
(2, 'Posto Shell', NULL, 1),
(3, 'Posto Petrobras', NULL, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_reclamacao`
--

CREATE TABLE `tb_reclamacao` (
  `id` bigint(20) NOT NULL,
  `data_hora` datetime DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `reclamacao_status` int(11) DEFAULT NULL,
  `posto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_reclamacao`
--

INSERT INTO `tb_reclamacao` (`id`, `data_hora`, `descricao`, `reclamacao_status`, `posto_id`) VALUES
(1, '2020-12-19 01:57:46', 'Preços incompativeis', 0, NULL),
(2, '2020-12-19 01:57:46', 'Preços totalmente errados', 0, NULL),
(3, '2020-12-19 01:57:46', 'Mal atendimento', 0, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_tipo_combustivel`
--

CREATE TABLE `tb_tipo_combustivel` (
  `id` bigint(20) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_tipo_combustivel`
--

INSERT INTO `tb_tipo_combustivel` (`id`, `descricao`) VALUES
(1, 'Aditivada'),
(2, 'Comum'),
(3, 'Premium');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `id` bigint(20) NOT NULL,
  `admin` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `foto_url` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_usuario`
--

INSERT INTO `tb_usuario` (`id`, `admin`, `email`, `foto_url`, `nome`, `senha`) VALUES
(1, b'0', 'jose@gmail.com', NULL, 'Jose', '123456'),
(2, b'0', 'maria@gmail.com', NULL, 'Maria', '123456'),
(3, b'0', 'carlos@gmail.com', NULL, 'Carlos', '123456');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_combustivel`
--
ALTER TABLE `tb_combustivel`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_combustivel_posto`
--
ALTER TABLE `tb_combustivel_posto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK24x7xo1dqr1xlc8afvxfgfs42` (`combustivel_id`),
  ADD KEY `FK1jw7por6rulctnxsw6wubpora` (`cotacao_id`),
  ADD KEY `FKju7x62ufuql3srruvnkymu7t8` (`posto_id`),
  ADD KEY `FK8wm5j4ruek42d5tugovcs4kuv` (`tipo_combustivel_id`);

--
-- Índices para tabela `tb_cotacao`
--
ALTER TABLE `tb_cotacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKta0i6pjw07hy06c0nahli8dcm` (`combustivel_id`);

--
-- Índices para tabela `tb_endereco`
--
ALTER TABLE `tb_endereco`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsashdeemeqjuj0pcn741bsgw4` (`posto_id`);

--
-- Índices para tabela `tb_posto`
--
ALTER TABLE `tb_posto`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_reclamacao`
--
ALTER TABLE `tb_reclamacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn8te1sn5wc6nqoip9wtcnakrl` (`posto_id`);

--
-- Índices para tabela `tb_tipo_combustivel`
--
ALTER TABLE `tb_tipo_combustivel`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_combustivel`
--
ALTER TABLE `tb_combustivel`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_combustivel_posto`
--
ALTER TABLE `tb_combustivel_posto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_cotacao`
--
ALTER TABLE `tb_cotacao`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_endereco`
--
ALTER TABLE `tb_endereco`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_posto`
--
ALTER TABLE `tb_posto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_reclamacao`
--
ALTER TABLE `tb_reclamacao`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_tipo_combustivel`
--
ALTER TABLE `tb_tipo_combustivel`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_combustivel_posto`
--
ALTER TABLE `tb_combustivel_posto`
  ADD CONSTRAINT `FK1jw7por6rulctnxsw6wubpora` FOREIGN KEY (`cotacao_id`) REFERENCES `tb_cotacao` (`id`),
  ADD CONSTRAINT `FK24x7xo1dqr1xlc8afvxfgfs42` FOREIGN KEY (`combustivel_id`) REFERENCES `tb_combustivel` (`id`),
  ADD CONSTRAINT `FK8wm5j4ruek42d5tugovcs4kuv` FOREIGN KEY (`tipo_combustivel_id`) REFERENCES `tb_tipo_combustivel` (`id`),
  ADD CONSTRAINT `FKju7x62ufuql3srruvnkymu7t8` FOREIGN KEY (`posto_id`) REFERENCES `tb_posto` (`id`);

--
-- Limitadores para a tabela `tb_cotacao`
--
ALTER TABLE `tb_cotacao`
  ADD CONSTRAINT `FKta0i6pjw07hy06c0nahli8dcm` FOREIGN KEY (`combustivel_id`) REFERENCES `tb_combustivel` (`id`);

--
-- Limitadores para a tabela `tb_endereco`
--
ALTER TABLE `tb_endereco`
  ADD CONSTRAINT `FKsashdeemeqjuj0pcn741bsgw4` FOREIGN KEY (`posto_id`) REFERENCES `tb_posto` (`id`);

--
-- Limitadores para a tabela `tb_reclamacao`
--
ALTER TABLE `tb_reclamacao`
  ADD CONSTRAINT `FKn8te1sn5wc6nqoip9wtcnakrl` FOREIGN KEY (`posto_id`) REFERENCES `tb_posto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
