# servicelist

Retorna uma lista de transações, conforme os parâmetros informados:

Requisição [GET] <id>/transacoes/<ano>/<mes>
  
Resposta:
  
Content-type: application/json

[
  {
  
      "descricao": "string(10, 60)"
     "data": "long(timestamp)"
     "valor": "integer(-9.999.999, 9.999.999)"
     
  }
]

  Para fazer o build da aplicação:
  
  1) Entrar no diretório do projeto
  2) Na linha de comando: Executar o "gradle build".
  
  Deploy da aplicação:
  1) Enviar o pacote .war gerado anteriormente para a pasta webappps (tomcat).
  2) Executar o catalina.sh
