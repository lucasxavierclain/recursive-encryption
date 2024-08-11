# Recursive Encryption and Decryption Project
This project demonstrates recursive encryption and decryption of objects using Java 17 and Spring Boot. The core functionality of the project is to apply encryption and decryption recursively to all fields of a given object.

## :hammer:  Tools and Languages Used
`<JDK Java 17 / Spring Boot / IDE (e.g., IntelliJ IDEA, Eclipse) / Maven or Gradle />`

## 🚀 Installing the Project Locally

Open your terminal and clone the repository to your local machine:
```
git clone https://github.com/lucasxavierclain/recursive-encryption.git
```
## 💻 Running the Code in an IDE
* Import the project into your IDE (e.g., IntelliJ IDEA, Eclipse).
* Locate the main class with the @SpringBootApplication annotation.
* Run the application as a Spring Boot application.

## :bulb: Running the Code in an terminal

* Open your terminal.
* Navigate to the project directory.
* Build the project using Maven or Gradle:
* Maven: mvn clean package
* Gradle: ./gradlew build
* Navigate to the target or build/libs directory.
* Execute the following command: ``` java -jar .\encryption-0.0.1.jar ```

## :pencil2: How to Test the Application by Postman
* Use tools like Postman or Insomnia to test the API endpoints.
* The default server URL is http://localhost:8080/api/v1.
* POST /encrypt to encrypt an object.
* POST /decrypt to decrypt an object.

## :pencil2: How to Test the Application by Swagger
* The default server URL is  http://localhost:8080/swagger-ui/index.html#/.
* POST /encrypt to encrypt an object.
* POST /decrypt to decrypt an object.

## Example Requests
* To Encrypt
    ```
    {
        "glossary":{
            "title": "example glossary",
            "GlossDiv": {
                "title": "S",
                "GlossList": {
                    "GlossEntry": {
                        "ID": "SGML",
                        "SortAs": "SGML",
                        "GlossTerm": "Standard Generalized Markup Language",
                        "Acronym": "SGML",
                        "Abbrev": "ISO 8879:1986",
                        "GlossDef": {
                            "para": "A meta-markup language, used to create markup languages such as DocBook.",
                            "GlossSeeAlso": ["GML", "XML"]
                        },
                        "GlossSee": "markup"
                    }
                }
            }
        }
    }


* To Decrypt
    ```
    {
        "glossary": {
            "title": "ZXhhbXBsZSBnbG9zc2FyeQ==",
            "GlossDiv": {
                "GlossList": {
                    "GlossEntry": {
                        "GlossTerm": "U3RhbmRhcmQgR2VuZXJhbGl6ZWQgTWFya3VwIExhbmd1YWdl",
                        "GlossSee": "bWFya3Vw",
                        "SortAs": "U0dNTA==",
                        "GlossDef": {
                            "para": "QSBtZXRhLW1hcmt1cCBsYW5ndWFnZSwgdXNlZCB0byBjcmVhdGUgbWFya3VwIGxhbmd1YWdlcyBzdWNoIGFzIERvY0Jvb2su",
                            "GlossSeeAlso": [
                                "R01M",
                                "WE1M"
                            ]
                        },
                        "ID": "U0dNTA==",
                        "Acronym": "U0dNTA==",
                        "Abbrev": "SVNPIDg4Nzk6MTk4Ng=="
                    }
                },
                "title": "Uw=="
            }
        }
    }

____________________________________________

# Projeto de Criptografia e Descriptografia Recursiva

Este projeto demonstra a criptografia e descriptografia recursiva de objetos usando Java 17 e Spring Boot. A funcionalidade principal do projeto é aplicar criptografia e descriptografia recursivamente a todos os campos de um objeto fornecido.

## :hammer: Ferramentas e Linguagens Utilizadas

`<JDK Java 17 / Spring Boot / IDE (por exemplo, IntelliJ IDEA, Eclipse) / Maven ou Gradle />`

## 🚀 Instalando o Projeto Localmente

Abra seu terminal e clone o repositório para sua máquina local:

```
git clone https://github.com/lucasxavierclain/recursive-encryption.git
```

## 💻 Executando o Código na IDE
* Importe o projeto para sua IDE (por exemplo, IntelliJ IDEA, Eclipse).
* Localize a classe principal com a anotação @SpringBootApplication.
* Execute a aplicação como uma aplicação Spring Boot.

## :bulb: Executando o Código no Terminal
* Abra seu terminal.
* Navegue até o diretório do projeto.
* Compile o projeto usando Maven ou Gradle:
* Maven: mvn clean package
* Gradle: ./gradlew build
* Navegue até o diretório target ou build/libs.
* Execute o seguinte comando: ``` java -jar .\encryption-0.0.1.jar ```

## :pencil2: Como Testar a Aplicação com Postman
* Use ferramentas como Postman ou Insomnia para testar os endpoints da API.
* O URL do servidor padrão é http://localhost:8080/api/v1.
* POST /encrypt para criptografar um objeto.
* POST /decrypt para descriptografar um objeto.


## :pencil2: Como Testar a Aplicação com Swagger
* O URL do servidor padrão é http://localhost:8080/swagger-ui/index.html#/.
* POST /encrypt para criptografar um objeto.
* POST /decrypt para descriptografar um objeto.

## Exemplos de Requisições
* Para Criptografar
    ```
    {
        "glossary":{
            "title": "example glossary",
            "GlossDiv": {
                "title": "S",
                "GlossList": {
                    "GlossEntry": {
                        "ID": "SGML",
                        "SortAs": "SGML",
                        "GlossTerm": "Standard Generalized Markup Language",
                        "Acronym": "SGML",
                        "Abbrev": "ISO 8879:1986",
                        "GlossDef": {
                            "para": "A meta-markup language, used to create markup languages such as DocBook.",
                            "GlossSeeAlso": ["GML", "XML"]
                        },
                        "GlossSee": "markup"
                    }
                }
            }
        }
    }


* Para Descriptografar
    ```
    {
        "glossary": {
            "title": "ZXhhbXBsZSBnbG9zc2FyeQ==",
            "GlossDiv": {
                "GlossList": {
                    "GlossEntry": {
                        "GlossTerm": "U3RhbmRhcmQgR2VuZXJhbGl6ZWQgTWFya3VwIExhbmd1YWdl",
                        "GlossSee": "bWFya3Vw",
                        "SortAs": "U0dNTA==",
                        "GlossDef": {
                            "para": "QSBtZXRhLW1hcmt1cCBsYW5ndWFnZSwgdXNlZCB0byBjcmVhdGUgbWFya3VwIGxhbmd1YWdlcyBzdWNoIGFzIERvY0Jvb2su",
                            "GlossSeeAlso": [
                                "R01M",
                                "WE1M"
                            ]
                        },
                        "ID": "U0dNTA==",
                        "Acronym": "U0dNTA==",
                        "Abbrev": "SVNPIDg4Nzk6MTk4Ng=="
                    }
                },
                "title": "Uw=="
            }
        }
    }
