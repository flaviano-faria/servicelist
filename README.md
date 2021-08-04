# servicelist

Retorna uma lista de transações, conforme os parâmetros informados no path da requisição

Requisição: [GET] /<id>/transacoes/<ano>/<mes>
  
Resposta: 
  
  Content-type: application/json

[
  {
     "descricao": "string(10, 60)"
     "data": "long(timestamp)"
     "valor": "integer(-9.999.999, 9.999.999)"
  }  
]
