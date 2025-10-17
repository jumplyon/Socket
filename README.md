# Java Socket HTTP Client

Exemplo de cliente HTTP implementado em **Java** utilizando **Sockets**, demonstrando comunicação TCP/IP básica e leitura de respostas HTTP.

---

## Descrição

Este projeto ilustra:

* Conexão TCP com um servidor web (`www.google.com.br`) na porta 80.
* Envio de requisição HTTP do tipo `GET` para a raiz do site.
* Leitura da resposta do servidor linha por linha.
* Impressão do conteúdo recebido no console.

> Observação: Este exemplo utiliza apenas HTTP simples (porta 80). Para HTTPS é necessário `SSLSocket` ou bibliotecas específicas como `HttpClient`.

---

## Código

```java
import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("www.google.com.br", 80);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String linha = "";
            out.println("GET / HTTP/1.0\n");
            while ((linha = in.readLine()) != null) {
                System.out.println("echo: " + linha);
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}
```

---

## Como executar

1. Instale o **Java JDK** (versão 8 ou superior).
2. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```
3. Navegue até a pasta do projeto:

   ```bash
   cd nome-do-repositorio
   ```
4. Compile o programa:

   ```bash
   javac Main.java
   ```
5. Execute o programa:

   ```bash
   java Main
   ```

---

## Saída esperada

O programa exibirá o conteúdo HTML da página inicial do Google, linha por linha, como no exemplo abaixo:

```
HTTP/1.0 200 OK
Date: Wed, 15 Oct 2025 22:00:00 GMT
Content-Type: text/html; charset=ISO-8859-1
...
```

---

## Observações

* Este código é **didático**, adequado para aprendizado de Sockets e comunicação TCP/IP em Java.
* Para acessar servidores HTTPS, é necessário utilizar `SSLSocket` ou bibliotecas específicas.
* Pode ser utilizado como base para o desenvolvimento de clientes HTTP mais complexos ou aplicações de rede em Java.


