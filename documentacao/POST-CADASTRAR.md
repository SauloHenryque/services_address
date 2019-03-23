#**Descrição:** Cadastra address.

**Description (en-US):** Save address.

## **Arquitetura**

**Nome da Tag:** address

**Path:** POST /api/address

**Nome do Resource:** br.com.saulo.address.web.AddressResource

**Nome do Serviço:** br.com.saulo.address.servicos.AddressServico

**Nome do Método:** salvarAddress

## **Requisição**

### **Nome do Request:** br.com.saulo.address.dto.persists.AddressPersist

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| rua | Sim | Nome da rua | Street name | Query | String | "Rua teste" | MAX(250) |
| numero | Não | Numero da residencia | Residence number| Query | String | "68" | MAX(50)|
| cep | Sim | CEP  | CEP| Query | String | "58063450" | MAX(8)|
| cidade | Sim | Cidade | city | Query | String | "João Pessoa" | MAX(255)|
| estado | Sim | Estado | state | Query | String | "PB" | MAX(2)|
| pais | Sim | País | country | Query | String | "Brasil" | MAX(50)|
| id_store | Não | Identificação de uma Store | Store ID | Query | Long | 1 | |
| id_order | Não | Identificação de um Order | Order ID | Query | Long | 1 | |


### **Exemplo Request:**
```
/api/address
```
```json
{
	"rua": "Rua teste",
    "numero": "68",
	"cep": "58063450",
	"cidade": "João Pessoa",
	"estado": "PB",
	"pais": "Brasil",
	"id_store": 0,
	"id_order": 1
}
```

## **Resposta**

### **Nome do Response:** br.com.saulo.address.dto.responses.AddressResponse

|Parâmetro | Descrição | Description (en-US) | Tipo de dados | Exemplo |
|---|---|---|:---:|---|
| id | Código identificador do address | address identifier | Long | 1 | 
| rua | Nome da rua | Street name | String | "Rua teste" | 
| numero | Numero da residencia | Residence number | String | "68" |
| cep | CEP | CEP | String | "58063450" |
| cidade | Cidade | city | String | "João Pessoa" |
| estado | Estado | state | String | "PB" |
| pais | País | country | String | "Brasil" |
| id_store | Identificação de uma Store | Store ID | Long | 1 |
| id_order | Identificação de um Order | Order ID | Long | 1 |
 

**Código status da resposta HTTP: 201 - Created**

### **Exemplo Response:**
```json
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
}
```

## **Documentos e referência**

**Tabelas:** address

## **Detalhes de implementação**

**Fluxo de execução**

1. Converter o objeto de persist na entidade address
2. Salvar entidade
3. Converter a entidade no response
4. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| :---: | --- | :---: | --- |
| Service | Quando cadastra address | 201 | Ok |
| DTO | Quando a quantidade de caracteres do atributo rua for maior que 250 |  400 | Bad Request |
| DTO | Quando a quantidade de caracteres do atributo numero for maior que 50 |  400 | Bad Request |
| DTO | Quando a quantidade de caracteres do atributo cep for maior que 8 |  400 | Bad Request |
| DTO | Quando a quantidade de caracteres do atributo cidade for maior que 255 |  400 | Bad Request |
| DTO | Quando a quantidade de caracteres do atributo estado for maior que 2 |  400 | Bad Request |
| DTO | Quando a quantidade de caracteres do atributo pais for maior que 50 |  400 | Bad Request |
| DTO | Quando o atributo rua não existir | 400 | Bad Request |
| DTO | Quando o atributo cep não existir | 400 | Bad Request |
| DTO | Quando o atributo cidade não existir | 400 | Bad Request |
| DTO | Quando o atributo estado não existir | 400 | Bad Request |
| DTO | Quando o atributo pais não existir | 400 | Bad Request |
