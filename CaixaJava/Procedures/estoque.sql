USE caixa_java;
go
CREATE PROCEDURE P_INSERCAO_ESTOQUE(
	@Qtd_prod INT
)
AS
	BEGIN
		SET NOCOUNT ON
			INSERT INTO tbl_estoque (qtd_prod)
			VALUES (@Qtd_prod)
	END
 
EXEC P_INSERCAO_ESTOQUE 12
 
 TRUNCATE TABLE tbl_estoque

SELECT * FROM tbl_estoque
