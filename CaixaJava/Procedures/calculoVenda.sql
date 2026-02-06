USE caixa_java;
GO
CREATE PROCEDURE P_CALCULO_VENDA (
	@Id_venda INT, 
	@Id_produto_fk INT,
	@Qtd_prod_digitado INT
)
AS
	BEGIN
		SET NOCOUNT ON
		IF NOT EXISTS (
			SELECT 1
			FROM tbl_produtos
			WHERE id_prod = @Id_produto_fk
		)
		BEGIN
			PRINT 'PRODUTO NÃO CADASTRADO!'
		END
 
		ELSE
			BEGIN
			DECLARE @Nome VARCHAR(255);
			DECLARE @Total DECIMAL(10,2);

			SET @Nome = (SELECT nome_prod FROM tbl_produtos WHERE id_prod = @Id_produto_fk)
			SET @Total = (SELECT valor_prod * @Qtd_prod_digitado FROM tbl_produtos WHERE id_prod = @Id_produto_fk)
			
			
			INSERT INTO tbl_vendas(id_venda, qtd_prod_digitado, total, id_prod_fk)
			VALUES (@Id_venda, @Qtd_prod_digitado, @Total, @Id_produto_fk)
			
			PRINT 'VENDA CADASTRADA COM SUCESSO!'
			PRINT 'PRODUTO ' + @Nome
			PRINT 'TOTAL: ' + @Total
 
			END
	END
 
 
EXEC P_CALCULO_VENDA 1, 1, 12;
 
 
select * from tbl_vendas;
select * from tbl_produtos;
