CREATE DATABASE agenda;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `contatos` (
  `id_contato` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `contatos` (`id_contato`, `nome`, `email`, `telefone`) VALUES
(6, 'Hal Jordan', 'hal@jordan.com', '4433-2222'),
(7, 'Joao Santos', 'jsantos@gmail.com', '11-2343-3333'),
(8, 'Antonio Felipe', 'afelipe@yahoo.com', '+23-3333-33333'),
(9, 'Pedro Paulo', 'ppaulo@inbox.com', '234432-3333'),
(10, 'Luiz Daniel', 'ldaniel@icloud.com', '666'),
(11, 'Joao Paulo', 'jp@abc.co.uk', '234- 23423'),
(12, 'Paulo Henrique dos Santos', 'phsantos@ubict.com', '234-234-234'),
(13, 'Bruce Dickson', 'bruce@dickson.com', '234-234-234'),
(14, 'Kurt Cobain', 'kurt@nirvana.com', '234-234234-');

ALTER TABLE `contatos`
  ADD PRIMARY KEY (`id_contato`);

ALTER TABLE `contatos`
  MODIFY `id_contato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

