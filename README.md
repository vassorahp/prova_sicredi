# prova_sicredi

## GIT do projeto que criei para a prova: 

	https://github.com/vassorahp/prova_sicredi/
 

## Ambiente em que a prova foi implementada:


- <b>OS</b>: 
	Windows 10 Home 64 bits - versão 1903 (Compilação do Sistema Operacional 18362.356)

- <b>Git</b>: 
	git version 2.23.0.windows.1

- <b>IDE</b>: 
	Eclipse IDE for Enterprise Java Developers.
	Version: 2019-09 R (4.13.0)
	Build id: 20190917-1200

- <b>Java</b>:  
	java version "1.8.0_231"
	Java(TM) SE Runtime Environment (build 1.8.0_231-b11)
	Java HotSpot(TM) 64-Bit Server VM (build 25.231-b11, mixed mode)

- <b>Maven</b>: 
	Apache Maven 3.6.2

- <b>Browser Testado</b>: 
	Google Chrome Versão 77.0.3865.120, (Versão oficial) 64 bits

- <b>Selenium Chrome Driver</b>: 
	ChromeDriver 77.0.3865.40 (https://chromedriver.storage.googleapis.com/index.html?path=77.0.3865.40/)

 

## Passos para executar os testes:


1. Certifique que os seguintes itens estejam na máquina alvo:

	* Google chrome Versão 77

	* Sistema Operacional Windows 10 64 bits

	* Seguintes ferramentas/linguagens: 

		- Maven

		- git

		- Java 1.8

		- Sugestão de IDE: IDE Eclipse (o IDE poderá ser um de preferência do usuário)

	Nota: lembrando que para as ferramentas e linguagem para o build precisam estar com os paths configurados. 
	Maven, java e git devem estar no path do windows para que seja executado.


2. Clone o repositório em um diretório de sua preferência:

	- Abra um prompt do windows

	- Vá até o diretório alvo para clonar o projeto:

		git clone https://github.com/vassorahp/prova_sicredi.git

3. Depois de clonado, vai até o seguinte diretório do projeto:

prova_sicredi\sicredi\

Nota: o projeto já vem com os drivers do google chrome a fim de rodar os testes sem precisar ter que baixar.

4. Execute o seguinte comando para instalar as dependências do projeto:

	mvn install

5. Abra o Eclipse e aponte o workspace para o projeto do git que foi baixado previamente

6. Os desafios 1 e 2 estão no seguinte local:

	sicredi\src\test\java\prova\sicredi\test\testcases

7. Rodar os testes como JUnit (Run as Junit) para os seguintes testes:
	* Desafio1Test.java
	* Desafio2Test.java
	