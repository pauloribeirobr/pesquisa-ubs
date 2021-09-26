# Pesquisa-UBS
API que permite pesquisar UBSs (Unidades Básicas de Saúde) próximas.

# Introdução
O Portal Brasileiro de Dados Abertos possui um arquivo CSV com a relação de todas as UBSs ativas no território nacional [https://dados.gov.br/dataset/unidades-basicas-de-saude-ubs](https://dados.gov.br/dataset/unidades-basicas-de-saude-ubs)

O desafio foi desenvolver uma API que permita ordenar por distância as UBSs baseado em um ponto de origem (latitude, longitude).

Foi utlizada a fórmula de Haversine para calcular a distância entre 2 pontos [http://rosettacode.org/wiki/Haversine_formula#Java](http://rosettacode.org/wiki/Haversine_formula#Java)

O arquivo CSV é importado para um Banco em Memória (H2) toda vez que o projeto é iniciado e essa é a lista principal. Como o cálculo é feito em todos os elementos da tabela, cada solicitação cria uma lista própria efetuando o cálculo e posteriormente ordenando da menor distância para a maior. Assim temos um ganho em performance e a segurança que os cálculos não serão compartilhados entre as requisições.

Projeto desenvolvido utilizando o Spring Boot

O projeto foi publicado no Heroku [https://pesquisa-ubs.herokuapp.com/](https://pesquisa-ubs.herokuapp.com/) e possui 3 links:
- Acesso ao Banco de Dados H2: [https://pesquisa-ubs.herokuapp.com/h2-console](https://pesquisa-ubs.herokuapp.com/h2-console)
![Imagem 01](https://raw.githubusercontent.com/pauloribeirobr/informacoesUBSs/master/image-01.png)
- Acesso ao Swagger: [https://pesquisa-ubs.herokuapp.com/swagger-ui.html](https://pesquisa-ubs.herokuapp.com/swagger-ui.html)
![Imagem 02](https://raw.githubusercontent.com/pauloribeirobr/informacoesUBSs/master/image-02.png)
- Teste de Consumo da API utilizando Vanilla Javascript + Google Maps + Google Places: [https://pesquisa-ubs.herokuapp.com/pesquisa-ubs](https://pesquisa-ubs.herokuapp.com/pesquisa-ubs)
![Imagem 03](https://raw.githubusercontent.com/pauloribeirobr/informacoesUBSs/master/image-03.png)
![Imagem 04](https://raw.githubusercontent.com/pauloribeirobr/informacoesUBSs/master/image-04.png)
