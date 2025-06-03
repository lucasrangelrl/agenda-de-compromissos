
# Gerenciador de Compromissos

**Lucas Rangel**  
Matrícula: 202309581272

---

## 1. Introdução

Este projeto consiste em uma aplicação desktop desenvolvida em Java com interface gráfica JavaFX, destinada ao gerenciamento simples e eficiente de compromissos pessoais. A aplicação permite cadastrar, visualizar e remover compromissos, oferecendo uma solução prática para organização da agenda diária.

O desenvolvimento desse sistema visa facilitar o controle de compromissos, atendendo a necessidade de manter uma agenda organizada e de fácil acesso.

---

## 2. Objetivos da Aplicação

- Cadastrar compromissos com título, descrição, data e hora.
- Listar compromissos cadastrados em uma interface intuitiva.
- Permitir a remoção de compromissos selecionados pelo usuário.
- Garantir persistência dos dados por meio de armazenamento em arquivo.
- Validar as informações inseridas pelo usuário para assegurar a consistência.

---

## 3. Funcionalidades (Requisitos Funcionais)

- **RF1:** Cadastro de compromissos com campos obrigatórios: título, data e hora.
- **RF2:** Visualização da lista de compromissos.
- **RF3:** Remoção de compromissos com confirmação do usuário.
- **RF4:** Salvamento automático dos compromissos em arquivo local.
- **RF5:** Validação de formato para campos de data e hora.

---

## 4. Requisitos Não Funcionais

- **RNF1:** Interface gráfica responsiva e amigável ao usuário.
- **RNF2:** Aplicação desktop com respostas rápidas e sem travamentos.
- **RNF3:** Código estruturado, organizado e fácil de manter.
- **RNF4:** Uso de boas práticas de programação orientada a objetos.

---

## 5. Especificação do Sistema

### Layout da Tela

- Tela principal com ListView exibindo os compromissos.
- Formulário com campos para título, descrição, data e hora.
- Botões para adicionar e remover compromissos.
- Alertas e confirmações para interações importantes.

### Regras de Negócio

- Título, data e hora são campos obrigatórios para adicionar um compromisso.
- O campo hora deve obedecer ao formato `HH:mm`.
- Ao remover, o sistema solicita confirmação ao usuário para evitar exclusão acidental.

### Classes Principais

| Classe        | Responsabilidade                                   |
|---------------|---------------------------------------------------|
| `Compromisso` | Representa um compromisso com seus dados básicos.|
| `AgendaView`  | Gerencia a interface gráfica e as interações.     |
| `ArquivoUtils`| Manipula o salvamento e carregamento de dados.    |

---

## 6. Diagrama de Classes (Resumo)

```
+------------------+            +-----------------+
|   AgendaView     |<>----------|   Compromisso   |
+------------------+            +-----------------+
| - compromissos   |            | - titulo        |
| + criarTela()    |            | - descricao     |
+------------------+            | - data          |
                               | - hora          |
                               +-----------------+
```
# 7. Dicionário de Dados

## Classe `Compromisso`

| Atributo    | Tipo de Dado | Descrição                                 |
|-------------|--------------|-------------------------------------------|
| `titulo`    | `String`     | Título do compromisso.                    |
| `descricao` | `String`     | Descrição detalhada do compromisso.       |
| `data`      | `LocalDate`  | Data do compromisso (formato dd/MM/yyyy). |
| `hora`      | `LocalTime`  | Hora do compromisso (formato HH:mm).      |

---

## Classe `AgendaView`

| Atributo       | Tipo de Dado                     | Descrição                                         |
|----------------|----------------------------------|---------------------------------------------------|
| `compromissos` | `ObservableList<Compromisso>`    | Lista de compromissos exibidos na interface.      |
---

## 8. Informações Adicionais

- Projeto desenvolvido para a disciplina de Programação Orientada a Objetos em Java da Wyden | UniRuy.
- Professor: Heleno Cardoso.
- Projeto individual realizado por Lucas Rangel.

---

## 9. Repositório GitHub

https://github.com/lucasrangelrl/agenda-de-compromissos

---
## 10. Requisitos para Versão Mobile/Web (Considerações)  
Este projeto foi desenvolvido inicialmente como aplicação desktop em JavaFX. Embora o objetivo do trabalho seja entregar uma aplicação web/mobile completa, o foco foi na versão desktop funcional.

Devido ao prazo e nível de conhecimento atual, a versão responsiva para dispositivos móveis não foi implementada, mas está prevista para futuras melhorias.

O projeto atende aos requisitos funcionais e não funcionais básicos, mas para apresentação, é importante explicar essa limitação ao professor, destacando a intenção de evolução do projeto.

## 11. Considerações Finais

Este sistema visa oferecer uma solução prática para o gerenciamento diário de compromissos, com foco em usabilidade e funcionalidade, atendendo às exigências do curso e preparando a base para futuras melhorias e adaptações para plataformas web ou mobile.

---

**Lucas Rangel**  
202309581272
