DROP TABLE IF EXISTS `produtos`;

CREATE TABLE `produtos` (
  `id_produto` bigint NOT NULL AUTO_INCREMENT,
  `categoria_produto` varchar(255) NOT NULL,
  `created_date_produto` datetime(6) DEFAULT NULL,
  `descricao_produto` varchar(255) NOT NULL,
  `marca_produto` varchar(255) NOT NULL,
  `nome_produto` varchar(255) NOT NULL,
  `preco_venda_produto` double NOT NULL,
  `qtde_estoque_produto` int NOT NULL,
  `url_foto_produto` varchar(255) NOT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 ;


INSERT INTO `produtos` VALUES (3,'Celulares','2022-06-27 19:20:31.000000','O processador mais rápido em um Galaxy.','Samsung','Samsung Galaxy S22 Ultra 5G ',9499,100,'../../assets/img/black-13.jpg'),(5,'Celulares','2022-06-27 19:36:52.502000','Grava vídeos em 4K a espantosa resolução de 3840x2160.','Samsung','Galaxy M53 5G',2500,100,'../../assets/img/galaxym53green.jpg'),(6,'Notebook','2022-06-27 20:15:52.047000','O Samsung Book possui uma arquitetura de ultima geração e design elegante para quem busca qualidade, desempenho e proteção do investimento.','Samsung','Notebook Samsung Intel Celeron-6305',2399,100,'../../assets/img/note samsung 6305.jpg'),(7,'Notebook','2022-06-27 20:53:46.679000','Levamos o patamar da performance com processadores de última geração da Intel, que oferecem um alto desempenho para notebooks finos e leves. ','Samsung','Notebook Samsung Core i5-1135G7',3419,100,'../../assets/img/galaxy notebook.jpg'),(8,'Smartwatches','2022-06-27 20:56:49.060000','Condicionamento físico ao alcance do braço.','Samsung','Galaxy Watch4 Classic BT 42mm',1899,100,'../../assets/img/smartwatchblack2.jpg'),(9,'Smartwatches','2022-06-27 21:04:13.918000','O relógio que melhor conhece você. Condicionamento físico ao alcance do braço.','Samsung','Galaxy Watch4 LTE 40mm',1899,100,'../../assets/img/smartwatchprata.jpg'),(10,'Fones de ouvido','2022-06-27 21:08:11.000000','Controle o nível de cancelamento ativo de ruído. Som de estúdio com poderosos alto-falantes duplos.','Samsung','Galaxy Watch4 LTE 40mm',749,100,'../../assets/img/buds prata.jpeg'),(11,'Fones de ouvido','2022-06-27 21:11:05.000000','Design ergonômico, cancelamento ativo de ruído para tipo aberto e som real e intenso','Samsung','Galaxy Buds Live Mystic Black',449,100,'../../assets/img/buds preto.jpg');


DROP TABLE IF EXISTS `tb_usuarios`;

CREATE TABLE `tb_usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(20) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `created_date_user` datetime(6) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `is_admin` bit(1) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `numero` varchar(8) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ;


INSERT INTO `tb_usuarios` VALUES (1,'Vila Olber','11959443772','03379030','são paulo','Ab - 2','23077494809','2022-06-27 20:11:34.800000','rua b','SP',_binary '','renata','400','$2a$10$1WQQjsTz3EdmGc8VjlyTxeqG2be1fNAVa/NfntFMowBOFD5FaDn06','renata@gmail.com');

DROP TABLE IF EXISTS `vendas_item`;

CREATE TABLE `vendas_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date_produto` datetime(6) DEFAULT NULL,
  `desconto_produto` double DEFAULT NULL,
  `forma_pagamento` varchar(255) NOT NULL,
  `id_carrinho` bigint NOT NULL,
  `nome_produto` varchar(255) DEFAULT NULL,
  `nome_usuario` varchar(255) DEFAULT NULL,
  `qtde_produto` int NOT NULL,
  `total` double NOT NULL,
  `valor_unitario_produto` double NOT NULL,
  `id_produto` bigint NOT NULL,
  `id_cliente` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk3wmtcs313i4acsc1l3j5pwy5` (`id_produto`),
  KEY `FKs6naupj1wt31x2k8yu5b0bvw9` (`id_cliente`),
  CONSTRAINT `FKk3wmtcs313i4acsc1l3j5pwy5` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id_produto`),
  CONSTRAINT `FKs6naupj1wt31x2k8yu5b0bvw9` FOREIGN KEY (`id_cliente`) REFERENCES `tb_usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;
