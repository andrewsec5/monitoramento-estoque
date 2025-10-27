# 📊 Serviço de Monitoramento de Logs

Este microsserviço é responsável por **receber, processar e armazenar logs e eventos** do sistema de **estoque**, garantindo rastreabilidade, auditoria e observabilidade de todas as operações.

Faz parte de um ecossistema baseado em **microsserviços e mensageria**, garantindo alta escalabilidade e isolamento de responsabilidades.

---

## 🚀 Tecnologias Utilizadas

- **Java 21** — linguagem principal  
- **Spring Boot 3** — estrutura de serviço e injeção de dependências  
- **Spring AOP (Aspect Oriented Programming)** — interceptação e padronização de logs  
- **Apache Kafka** — consumo de eventos do serviço de estoque  
- **MongoDB** — persistência dos logs e registros de auditoria   
- **Variáveis de Ambiente (.env)** — configuração de segurança para URIs e credenciais  

---

## 🧩 Arquitetura e Comunicação

O serviço de **monitoramento** consome os eventos enviados pelo serviço de **estoque** via **Kafka**, armazenando logs estruturados no MongoDB para análise e auditoria.

---

📡 **Fluxo de comunicação:**

Estoque --> Kafka --> Monitoramento de Logs

Cada log é enriquecido com metadados (data, operação, serviço de origem e status), permitindo consultas e análises eficientes.

---

## 🔐 Segurança e Boas Práticas

- Configurações sensíveis mantidas via variáveis de ambiente.  
- AOP aplicado para padronizar logs e rastrear exceções.  
- Comunicação assíncrona e desacoplada via Kafka, conforme padrões corporativos.

---

## 📎 Serviço Relacionado

➡️ Este serviço trabalha em conjunto com o microsserviço de **estoque**, responsável por gerar e publicar os eventos:  
👉 [andrewsec5/estoque](https://github.com/andrewsec5/estoque)

---

## 🧠 Autor

Desenvolvido por **Andrew**, aplicando conceitos de **microsserviços, AOP, mensageria e segurança**.  
📬 Feedbacks e sugestões são sempre bem-vindos!
