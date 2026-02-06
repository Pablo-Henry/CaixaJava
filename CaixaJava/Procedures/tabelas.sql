CREATE DATABASE caixa_java;
GO
USE caixa_java;
GO
 
CREATE TABLE tbl_produtos(
id_prod INT IDENTITY PRIMARY KEY,
nome_prod VARCHAR(255),
valor_prod DECIMAL(10,2)
);
GO
 
CREATE TABLE tbl_estoque(
id_estoque INT IDENTITY PRIMARY KEY,
qtd_prod INT,
id_prod_fk INT,
FOREIGN KEY (id_prod_fk) REFERENCES tbl_produtos(id_prod)
);
GO
 
 
CREATE TABLE tbl_vendas (
id INT PRIMARY KEY IDENTITY,
id_venda INT,
qtd_prod_digitado INT,
total DECIMAL(10,2),
id_prod_fk INT
FOREIGN KEY (id_prod_fk) REFERENCES tbl_produtos (id_prod)
);

GO

CREATE TABLE tbl_total (
id_venda INT PRIMARY KEY IDENTITY,
total_venda DECIMAL(10,2),
id_fk INT,
FOREIGN KEY (id_fk) REFERENCES tbl_vendas (id)
);

USE aulamarcos

DROP DATABASE caixa_java;