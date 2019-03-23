# **Descrição:** Atualiza um address a partir do seu código de identificação.

**Description (en-US):** Update an address by the identifier code

## **Arquitetura**

**Nome da Tag:** address

**Path:** PUT /api/address/{id}

**Nome do Resource:** br.com.saulo.address.web.AddressResource

**Nome do Serviço:** br.com.saulo.address.servicos.AddressServico

**Nome do Método:** atualizarAddress

## **Requisição**

### **Nome do Request:** br.com.saulo.address.dto.persists.AddressPersist

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| id | Sim | Código identificador do address | store identifier | Path | Long  | 1 |
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
/api/address/1
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

**Código status da resposta HTTP: 200 - Ok**

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

**Pré-requisitos**
* Existir address para o id informado
* Cumprir as validações de entrada

**Fluxo de execução**

1. Consultar a address pelo id
2. Verificar se a store não é nulo  
2.1. Se for nulo, retornar exceção de registro não encontrado  
3. Converter o objeto persist na entidade address
4. Salvar entidade
5. Converter a entidade no response
6. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| --- | --- | :---: | --- |
| Service | Quando atualiza a address | 200 | Ok |
| Service | Quando a address não existe | 404 | Not Found |
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

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|---|---|---|---|
| 404 | REGISTRO_NAO_ENCONTRADO | Nenhum registro encontrado para essa solicitação | No register found for this request |
