# API - Registro de Atividades

## Sobre o Projeto
REST API para a realização do CRUD para o registro de atividades realizadas em atendimentos ou internamente no setor TIC. Os dados necessários para o cadastro de uma atividade são a descrição, motivo, data e a que categoria está associada.  Para a categoria registra-se apenas o nome. 

## Tecnologias: 
- [x] Java<br> 
- [x] Spring boot <br> 
- [x] Spring Security< br> 

<h2> Capturas de telas do CRUD da aplicação </h2>

<h3> POST de Atividade  </h3>

Body: 
 ```
  {
    "descricao" : "Troca de cabo USB da Impressora na Secretaria ",
    "motivo" : "impressora nao funcionando",
    "data" : "2021-01-01",
    "categoriaAtividadeId" : 4
}
```
<h1 align="center">
    <img src="https://github.com/deoliveiralima/registro-atividades-api/blob/master/screenshots/postman_post_atividade.png" />
</h1>

<h3> GET de Atividade  </h3>

URI: http://localhost:8080/atividade/5 

<h1 align="center">
    <img src="https://github.com/deoliveiralima/registro-atividades-api/blob/master/screenshots/postman_get_atividade.png" />
</h1>

<h3> PUT de Atividade  </h3>
URI: http://localhost:8080/atividade/5 
Body: 
 ```
 {
    "descricao" : "Troca de cabo USB da Impressora na Secretaria ",
    "motivo" : "impressora nao funcionando",
    "data" : "2022-05-06",
    "categoriaAtividadeId" : 4
}
```



