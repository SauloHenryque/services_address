# **Descrição:** Deleta um address a partir do seu código de identificação.

**Description (en-US):** Delete an address by the identifier code

## **Arquitetura**

**Nome da Tag:** Address

**Path:** DELETE /api/address/{id}

**Nome do Resource:** br.com.saulo.address.web.AddressResource

**Nome do Serviço:** br.com.saulo.address.servicos.AddressServico

**Nome do Método:** deletarAddress

## **Requisição**

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| id | Não | Código identificador do address | address identifier | Path | Long  | 1 |

### **Exemplo Request:**
```
/api/address/1
```
## **Resposta**

**Código status da resposta HTTP: 204 - No Content**

## **Documentos e referência**

**Tabelas:** Address

## **Detalhes de implementação**

**Pré-requisitos**
* Existir address para o id informado

**Fluxo de execução**

1. Consultar a address pelo id
2. Verificar se a address não é nulo  
2.1. Se for nulo, retornar exceção de registro não encontrado  
3. Remover o registro da address
4. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| --- | --- | :---: | --- |
| Service | Quando deleta o address | 204 | Ok |
| Service | Quando a address não existe | 404 | Not Found |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|---|---|---|---|
| 404 | REGISTRO_NAO_ENCONTRADO | Nenhum registro encontrado para essa solicitação | No register found for this request |