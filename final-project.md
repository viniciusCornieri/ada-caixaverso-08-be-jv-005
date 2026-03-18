# Projeto Final: Analisador de Transações Bancárias e Detecção de Fraude

## 1. Objetivo
Desenvolver uma aplicação Java para processar o histórico de transações bancárias, gerando relatórios estatísticos e identificando transações suspeitas utilizando a API de Streams e Programação Funcional.

## 2. Entrada: Detalhes do Dataset
O programa deve processar o arquivo [bank_transactions_data_2.csv](bank_transactions_data_2.csv). 
- **Fonte dos Dados:** [Kaggle - Bank Transaction Dataset for Fraud Detection](https://www.kaggle.com/datasets/valakhorasani/bank-transaction-dataset-for-fraud-detection)

Os dados devem ser mapeados para um **Record** `Transaction` contendo os seguintes campos extraídos do CSV:
- `transactionId` (String)
- `accountId` (String)
- `amount` (BigDecimal) - Coluna `TransactionAmount`
- `timestamp` (LocalDateTime) - Coluna `TransactionDate`
- `type` (String) - Coluna `TransactionType` (Ex: Debit, Credit)
- `channel` (String) - Coluna `Channel` (Ex: ATM, Online)
- `occupation` (String) - Coluna `CustomerOccupation`
- `loginAttempts` (int) - Coluna `LoginAttempts`
- `balance` (BigDecimal) - Coluna `AccountBalance`

## 3. Regras de Processamento (Requisitos Funcionais)
Toda a lógica de filtragem e agrupamento deve ser implementada via **Streams**.

### A. Análise Estatística (Obrigatório)
1. **Valor Total Movimentado:** Calcular o valor líquido somado de todas as transações (Débitos subtraem, Créditos somam).
2. **Top 10 Maiores Transações:** Listar as 10 transações de maior valor (`amount`).
3. **Saldo Médio por Profissão:** Calcular a média do saldo (`balance`) agrupado por `occupation`.
4. **Volume por Canal:** Contar o total de transações para cada `channel`.

### B. Detecção de Transações Suspeitas (Obrigatório)
Identificar transações que atendam a **pelo menos UM** dos critérios abaixo:
1. **TENTATIVAS_EXCEDIDAS:** Transações com mais de 3 tentativas de login (`loginAttempts > 3`).
2. **HORARIO_SUSPEITO:** Transações realizadas a partir das 18:00:00 (inclusive).

## 4. Saída Esperada

### A. Console (Exemplo de Formatação)

```text
==================================================
   RELATÓRIO DE TRANSAÇÕES BANCÁRIAS - SUMÁRIO
==================================================
Total de transações processadas: 2.513
Valor total movimentado: R$ -1.250.000,00
--------------------------------------------------
TOP 10 MAIORES TRANSAÇÕES:
1. ID: TX000455 | Valor: R$ 1.919,11 | Conta: AC00455 | Data: 27/06/2023
2. ID: TX001234 | Valor: R$ 1.831,02 | Conta: AC00012 | Data: 15/06/2023
...
==================================================
```

### B. Arquivos

1. **`relatorio_estatistico.txt`** (Exemplo de conteúdo):
   ```text
   --- MÉDIA DE SALDO POR PROFISSÃO ---
   Doctor: R$ 12.450,50
   Student: R$ 1.120,30
   
   --- VOLUME POR CANAL ---
   ATM: 1.250 transações
   Online: 1.263 transações
   ```

2. **`transacoes_suspeitas.csv`** (Exemplo de linhas):
   ```csv
   transaction_id,timestamp,loginAttempts,amount
   TX000003,2023-07-10T18:16:08,1,126.29
   TX000088,2023-07-15T17:00:00,5,150.00
   ```

## 5. Desafio Extra (Opcional)
Implemente o processamento de forma **assíncrona** utilizando `CompletableFuture`.

## 6. Restrições Técnicas
- **Paradigma Funcional:** Uso de Streams e Lambdas.
- **Java Time:** Uso obrigatório.
- **Leitura Eficiente:** Utilizar `Files.lines()`.
