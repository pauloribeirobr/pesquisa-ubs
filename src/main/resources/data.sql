DROP TABLE IF EXISTS ubs_base;

CREATE TABLE ubs_base (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  latitude DOUBLE NOT NULL,
  longitude DOUBLE NOT NULL,
  codigo_municipio VARCHAR(7) NOT NULL,
  codigo_cnes VARCHAR(250) DEFAULT NULL,
  nome VARCHAR(250) DEFAULT NULL,
  endereco VARCHAR(250) DEFAULT NULL,
  bairro VARCHAR(250) DEFAULT NULL,
  cidade VARCHAR(250) DEFAULT NULL,
  telefone VARCHAR(250) DEFAULT NULL,
  situacao_estrutura VARCHAR(250) DEFAULT NULL,
  situacao_adaptacoes VARCHAR(250) DEFAULT NULL,
  situacao_equipamentos VARCHAR(250) DEFAULT NULL,
  situacao_medicamento VARCHAR(250) DEFAULT NULL
);
