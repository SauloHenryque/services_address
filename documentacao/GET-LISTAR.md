# **Descrição:** Lista os address existentes.

**Description (en-US):** List the existent address.

## **Arquitetura**

**Nome da Tag:** address

**Path:** GET /api/address

**Nome do Resource:** br.com.saulo.address.web.AddressResource

**Nome do Serviço:** br.com.saulo.address.servicos.AddressServico

**Nome do Método:** listarAddress

## **Requisição**

### **Nome do Request:** br.com.saulo.address.dto.request.AddressRequest

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| rua | Não | Nome da rua | Street name | Query | String | "Rua teste" | MAX(250) |
| numero | Não | Numero da residencia | Residence number| Query | String | "68" | MAX(50)|
| cep | Não | CEP  | CEP| Query | String | "58063450" | MAX(8)|
| cidade | Não | Cidade | city | Query | String | "João Pessoa" | MAX(255)|
| estado | Não | Estado | state | Query | String | "PB" | MAX(2)|
| pais | Não | País | country | Query | String | "Brasil" | MAX(50)|
| id_store | Não | Identificação de uma Store | Store ID | Query | Long | 1 | |
| id_order | Não | Identificação de um Order | Order ID | Query | Long | 1 | |



### **Exemplo Request:**
```
/api/address
/api/address?id_store=1
/api/address?cep=58063450
```

## **Resposta**

### **Nome do Response:** br.com.saulo.address.dto.responses.AddressResponse

|Parâmetro | Descrição | Description (en-US) | Tipo de dados | Exemplo | Ordenação |
|---|---|---|:---:|---|:---:|
| id | Código identificador do address | address identifier | Long | 1 | 
| rua | Nome da rua | Street name | String | "Rua teste" | 
| numero | Numero da residencia | Residence number | String | "68" |
| cep | CEP | CEP | String | "58063450" |
| cidade | Cidade | city | String | "João Pessoa" |
| estado | Estado | state | String | "PB" |
| pais | País | country | String | "Brasil" |
| id_store | Identificação de uma Store | Store ID | Long | 1 |
| id_order | Identificação de um Order | Order ID | Long | 1 |


**Código status da resposta HTTP: 200 -  OK**

### **Exemplo Response:**
```json
{
    {
      "id": 1,
      "rua": "Rua teste",
      "numero": "68",
	  "cep": "58063450",
	  "cidade": "João Pessoa",
	  "estado": "PB",
	  "pais": "Brasil",
	  "id_store": 0,
	  "id_order": 1
    },
    {
      "id": 2,
      "rua": "Rua teste",
      "numero": "65",
	  "cep": "58063450",
	  "cidade": "João Pessoa",
	  "estado": "PB",
	  "pais": "Brasil",
	  "id_store": 1,
	  "id_order": 0
    }
}
```

## **Documentos e referência**

**Tabelas:** address

## **Detalhes de implementação**

**Fluxo de execução**

1. Converter o objeto de request na entidade address
2. Realizar a consulta
3. Retorna o List AddressEntidade

## **Casos de teste**
| Onde | Teste | HTTP Status | Resultado |
| :---: | --- | :---: | --- |
| Service | Quando retorna address  | 200 | OK |
| Service | Quando não encontra a address informado no parâmetro | 200 | Ok |