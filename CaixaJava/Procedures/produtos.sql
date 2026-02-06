USE caixa_java
go
CREATE PROCEDURE P_INSERCAO_PRODUTOS(
	@Nome_prod VARCHAR(255),
	@Valor_prod DECIMAL(10,2)
)
AS 
	BEGIN 
		SET NOCOUNT ON
 
		INSERT INTO tbl_produtos (nome_prod, valor_prod)
		VALUES (@Nome_prod, @Valor_prod)
	END
 
GO
 
EXEC P_INSERCAO_PRODUTOS 'cArLoS', 2.00;
 
SELECT * FROM tbl_produtos