# Sobre o desafio
O desafio foi desenvolvido dentre os dias 05 e 13/11. Desenvolvido em Java na IDE Spring Tools Suite, organizado em camadas, utilizando padrão DTO, web services REST e conexão com o banco de dados de teste H2, atendendo aos testes automatizados em JUnit com Sprint Boot e Mockito. Parte do frontend foi desenvolvido em ReactJS, com integração com o frontend via Axios.
#### Como testar
- A classe TestConfig possui algumas entidades já inicializadas, elas podem ser alteradas/adicionadas para testar com outros valores;
- As requisições podem ser feitas no Postman - a coleção dele para importação pode ser encontrada na pasta raiz do projeto: https://github.com/lucasnakasone/desafioDuxus/blob/main/desafioDuxus.postman_collection.json
- Após clonar e rodar o projeto, o banco de testes pode ser acessado através do link: http://localhost:8080/h2/
- A página pode ser acessada no link a seguir. Para acessá-la, é necessário acessar a pasta do projeto em desafioDuxus\frontend, abrir um Git Bash e rodar o comando yarn start: http://localhost:3000/. Obs.: apenas os endpoints de ApiService respondem no momento.

#### Auto avaliação
Acredito que pude atender às demandas do projeto em sua maioria - até a construção das telas, embora reconheça que ainda possa melhorar na implementação em alguns pontos como por exemplo:
- O processamento de dados como a busca dos integrantes mais usados  na API Service traz a entidade de maior ocorrência dentro do período, porém caso haja outros integrantes ele trará apenas o que atingiu aquela número de ocorrência primeiro, já que o retorno desse método pede um integrante e não uma lista - o mesmo comportamento pode ser visto no método funcaoMaisComum;
- O reuso de código como o resgate de integrantes dos times dentro dos métodos da API Service;
- A implementação de limite quantidade de integrantes por time e a exclusividade do time a apenas uma franquia - ambos no momento do cadastro. 
- A implementação de mais testes;
- A implementação do front de forma geral;

Do mais, estou aberto à críticas disposto a compartilhar ideias!

# Desafio de Desenvolvimento

O objetivo deste desafio é obter uma ideia das habilidades que o candidato possui, da organização de tempo e também do código.

## Considerações Importantes – Por favor, leia com atenção:

- O desafio já tem diversos códigos pré prontos para você completar as funcionalidades. Não é preciso reinventar a roda!

- Use seu tempo de forma inteligente: Uma solução simples primeiro e depois avance.

- Comentários sempre são bem-vindos em métodos ou estruturas mais complexas.

- Parece não intuitivo, mas deixe as telas por último, pense na estrutura dos dados e nos métodos de gravação e exportação primeiro.

- Utilize os testes unitários já existentes e crie novos também, se possível. Não existe necessidade de 100% de cobertura, mas use-os para experimentar e validar sua solução – **é muito importante que os testes já existentes estejam passando após a sua implementação!**

- Faça commits frequentes, assim podemos ver a evolução da sua solução.

- Sobre banco de dados, você pode usar qualquer um que esteja acostumado, inclusive em memória, se preferir. Aqui utilizamos, comumente: PostgreSQL, Microsoft SQL Server, Oracle DB, MySQL e, especialmente para testes, HSQLDB. 

- Não se preocupe caso não consiga finalizar tudo o que é proposto no desafio. Entregue tudo o que conseguir fazer, indiferente de estar completo ou não.

- Durante o período de teste, fique à vontade para enviar dúvidas ao recrutador.

- Ao final, deixamos alguns links que podem ser úteis para consulta, mas você pode consultar qualquer material, à vontade.

- Nos envie, ao final, uma descrição com detalhes de como podemos testar a sua implementação, caso seja necessário alguma ação específica.

## O que você deve implementar:

Imagine que você quer fazer um sistema de escalação de times. Toda semana você vai montar um time vencedor. 

Não importa se é Esporte tradicional ou eSports.

Exemplos de Esporte tradicional : Futebol, Basquete.

Exemplos de eSports : Counter Strike, Valorant, Free Fire, League of Legends, APEX.

Sua tarefa é construir a melhor solução no tempo combinado, considerando os requisitos que estarão descritos abaixo.

Você pode usar a criatividade pois não existe uma solução definitiva para o desafio.

Abaixo, mais detalhes:

## Estrutura dos Dados

### Tabela de "Integrante" :

- Id
- Franquia
- Nome
- Função

### Tabela de Time:

- Id
- Data

### Tabela de ComposicaoTime:

- Id
- Id_Time  (foreign key tabela Time)
- Id_Integrante  (foreign key tabela Integrante)

## Funcionalidades Principais

### 1) Tratamento de dados – PASSO MAIS IMPORTANTE DO DESAFIO, foque nessa etapa primeiro.

Esse passo é o mais importante no teste porque gostaríamos de medir a sua capacidade de lidar com estruturas de dados. 

Já existe um service criado no projeto (ApiService), com métodos para serem implementados. 

**Obs. IMPORTANTE**: Caso decida criar um projeto do zero sem aproveitar o código já fornecido neste repositório, pedimos aqui a restrição de: 

1 - Não utilizar funções de SQL como 'count' para implementar estes métodos, nem procedures ou qualquer outro tratamento dos dados fora da função em **java**, pois queremos justamente entender o seu domínio sobre a linguagem para lidar com o problema a ser resolvido. Você deve usar os selects apenas para trazer todos os dados, mas processe-os na linguagem.

2 – Crie novos ou adapte os testes unitários existentes para validar a sua lógica, isso é muito importante! Caso não seja familiarizado com testes unitários com Junit, dê preferência para o aproveitamento do código existente nesse service, pois os testes unitários propostos já estão preparados para essa estrutura pré pronta.

No quadro, alguns detalhes sobre os métodos:

| Método  | Parâmetros | Descrição |
|--|--|--|
| TimeDaData | Data | Vai retornar uma lista com os nomes dos integrantes do time daquela data |
| IntegranteMaisUsado | Data inicial e Data final (podem ser null) | Vai retornar o integrante que tiver presente na maior quantidade de times dentro do período |
| TimeMaisComum | Data inicial e Data final (podem ser null) | Vai retornar uma lista com os nomes dos integrantes do time mais comum dentro do período |
| FuncaoMaisComum | Data inicial e Data final (podem ser null) | Vai retornar a função mais comum nos times dentro do período |
| FranquiaMaisFamosa | Data inicial e Data final (podem ser null) | Vai retornar o nome da Franquia mais comum nos times dentro do período |
| ContagemPorFranquia | Data inicial e Data final (podem ser null) | Vai retornar o número (quantidade) de Franquias dentro do período |
| ContagemPorFuncao | Data inicial e Data final (podem ser null) | Vai retornar o número (quantidade) de Funções dentro do período |

## Funcionalidades Extras
### 2) API de Cadastro

Lembrando: a prioridade é a funcionalidade correta, não as telas. 

#### Cadastro de Integrantes

Fazer um cadastro de integrantes para os times.

#### Cadastro de Times

Fazer um cadastro de times onde não importa muito a quantidade de integrantes. 

Para cadastrar um time para uma determinada semana basta escolher os personagens/integrantes que farão parte dele.


### 3) API para processamento de Dados

Seu sistema vai processar as informações do banco de dados e vai exportá-las através de endpoints.

Você deve usar os selects para trazer todos os dados, mas processe eles na linguagem, através dos métodos implementados no passo 1.

| Endpoint  | Parâmetros |
|--|--|
| TimeDaData | Data | 
| IntegranteMaisUsado | Data inicial e Data final (podem ser null) |
| TimeMaisComum | Data inicial e Data final (podem ser null) |
| FuncaoMaisComum | Data inicial e Data final (podem ser null) |
| FranquiaMaisFamosa | Data inicial e Data final (podem ser null) |
| ContagemPorFranquia | Data inicial e Data final (podem ser null) |
| ContagemPorFuncao | Data inicial e Data final (podem ser null) |

Exemplos de Resultados esperados:

TimeDaData
``` 
{
  "data": 2021-01-15,
  "integrantes": [ "Bangalore", "BloodHound", "Crypto" ]
}
```

FuncaoMaisComum
``` 
{
  "Função" : "Meia"
}
```

ContagemPorFranquia
``` 
{
  "Apex Legends": 5,
  "Overwatch": 2,
  "FreeFire": 3
}
```


### 4) Telas

Conforme já foi dito as telas de cadastro tem prioridade menor do que o funcionamento da API.

Você pode fazer as telas da maneira mais simples possível e usar qualquer framework que facilite o desenvolvimento.

- Tela de Inserção de Integrantes
    - Um formulário com os campos é suficiente
- Tela de Montagem de Times pode ser feita de diversas maneiras, algumas sugestões:
    - Fazer uma listagem e colocar um checkbox ao lado de cada integrante
    - Fazer um "transfer" usando dois "selects" de html
    - Usar um componente de jquery ( https://www.jqueryscript.net/blog/best-multiple-select.html )

Não se sinta obrigado a utilizar algo dessas sugestões, fique à vontade para utilizar o que tiver mais domínio ou preferência.

O importante é a tela estar funcional e a beleza não será avaliada.

## Alguns links úteis para consulta

- https://www.baeldung.com/java-collections
- https://www.baeldung.com/java-8-streams-introduction
- https://pt.linkedin.com/pulse/tdd-com-java-junit-e-mockito-tiago-perroni
- https://www.devmedia.com.br/rest-tutorial/28912
- https://www.baeldung.com/rest-with-spring-series
- https://www.baeldung.com/jackson-vs-gson
