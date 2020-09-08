# WeatherApp

Objetivo era criar um App de Previsão do Tempo, onde na tela inicial é digitado a cidade e na tela seguinte as informações do da previsão do tempo daquela cidade.

### Para buildar o projeto é necessário:

* Android Studio 4.0(mínimo)
* Java 8 (mínimo)
* Android Sdk 23 (mínimo)
* Gradle 6.1.1 (mínimo)

## Funcionalidades:

* Tela inicial contendo campo para buscar a Cidade.

* Tela de Detalhes da previsão do tempo para a cidade buscada.

## Detalhes

* Apenas busca cidades do Brasil.

## Testes

* Teste de UI:

    Testa o flow da aplicação, i.e, da tela inicial, digita a cidade e confere os campos contêm informações do tempo na tela de Detalhes.
    
* Testes Instrumentados:

    Testa os métodos das classes Presenter e suas interações com dependências e View.
    
* Teste Unitário:

    Testa métodos das classes Model, Getters e Setters não testados.

## Arquitetura utilizada MVP

O padrão de Arquitetura utilizado é o MVP, acrônimo para Movel-View-Presenter, esta arquitetura é uma derivação da MVC(Model-View-Controller). No MVP, o Presenter assume o papel do _intermediário_, é onde ocorre também grande parte da lógica de negócio da aplicação.

* **View**: como no MVC, responde à saída e entrada de dados, porém a saída vem do Presenter, a entrada normalmente vem do usuário.
  
* **Presenter**: camada responsável por responder às invocações da camada de visualização e invocações da camada de modelo, além de também poder invocar ambas as camadas. O Presenter trabalha a formatação dos dados que entram em ambas as camadas paralelas e também pode incluir parte da lógica de negócio que alguns programadores podem pensar que deveria estar somente na camada de modelo.

* **Model**: camada fornecedora de dados além de conter a lógica de negócio do domínio do problema.

[Referência](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter "Referencia Wikipedia sobre MVP")


## API para de Previsão do Tempo: Weatherbit.io

Weatherbit.io é um _webservice_ gratuito e de alto desempenho para consultar Previsão do tempo em todo o mundo.

[Referência](https://www.weatherbit.io/ "Site Oficial do Weatherbit.io")


## HTTP Client utilizado Retrofit

O Retrofit é um type-safe HTPP Client para Android e Java desenvoldido pela [Square](https://square.github.io/)

versão: 2.9.0

[Referência](https://square.github.io/retrofit/ "Documentação Retrofit - square.github.io/")

---
