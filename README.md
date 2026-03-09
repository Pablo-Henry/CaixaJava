# CaixaJava
# 🛒 CaixaJava - Sistema de PDV com Stored Procedures

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![SQL Server](https://img.shields.io/badge/Microsoft%20SQL%20Server-CC2927?style=for-the-badge&logo=microsoft-sql-server&logoColor=white)

Este projeto é um sistema de frente de caixa (PDV) desktop desenvolvido para praticar a integração robusta entre uma aplicação Java e um banco de dados relacional. O diferencial técnico deste projeto é a delegação da lógica de manipulação de dados para o banco de dados através do uso de **Stored Procedures**.

## 🎯 Objetivo do Projeto
O foco principal foi o desenvolvimento de uma camada de persistência eficiente, utilizando o driver JDBC para executar procedimentos armazenados no **SQL Server**, garantindo maior segurança e performance nas operações de inserção e consulta de produtos.

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java (JDK 17+)
- **Interface Gráfica:** Java Swing
- **Banco de Dados:** Microsoft SQL Server
- **Persistência:** JDBC (Java Database Connectivity)
- **IDE:** Apache NetBeans / IntelliJ IDEA

## 🚀 Funcionalidades Principais
- **Cadastro de Produtos:** Interface para inserção de itens no estoque via Stored Procedures.
- **Sistema de Vendas:** Cálculo de itens e totalização de valores.
- **Integração de Dados:** Consulta em tempo real ao banco de dados para validação de produtos.
- **Tratamento de Exceções:** Implementação de logs e mensagens de erro para falhas de conexão SQL.

## 🏗️ Estrutura Técnica (Destaques)
- **Camada de Conexão:** Centralizada na classe `ConexaoSql`, utilizando URLs de conexão seguras e parâmetros de criptografia.
- **Stored Procedures:** O sistema utiliza `CallableStatement` para invocar procedimentos como `P_INSERCAO_PRODUTOS`, permitindo que o SQL Server gerencie a lógica de inserção e integridade.
