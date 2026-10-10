# Chat com Socket TCP

Chat cliente-servidor em Java com Socket TCP: mensagens públicas, mensagens privadas e lista de usuários online. As mensagens trafegam como JSON (Gson), uma por linha.

| Projeto | Descrição |
|---|---|
| ServidorChatTCP | Servidor na porta 6000; cada cliente é atendido por uma thread do pool (`AtendimentoCliente`) |
| ClienteChatTCP | Cliente Swing; uma thread separada fica escutando as mensagens do servidor |

## Requisitos
- JDK 25 (definido em `maven.compiler.release` no `pom.xml`)
- Maven (NetBeans já inclui)

## Como executar
1. Abra os dois projetos no NetBeans.
2. Execute o **ServidorChatTCP**.
3. Execute uma ou mais instâncias do **ClienteChatTCP**, informe IP (`localhost`), porta (`6000`) e um nickname, e clique em Conectar.
4. Escolha **Todos** para mensagem pública ou um usuário da lista para mensagem privada.

## Protocolo

**Requisicao** (cliente → servidor): `tipo`, `nickname`, `destinatario`, `texto`

| tipo | Ação no servidor |
|---|---|
| `entrar` | registra o nickname (recusa se já estiver em uso) |
| `todos` | repassa a mensagem a todos os conectados |
| `privada` | entrega só ao destinatário e confirma ao remetente |

**Resposta** (servidor → cliente): `tipo`, `hora`, `remetente`, `texto`

| tipo | Significado |
|---|---|
| `OK` | entrada aceita |
| `ERRO` | nickname em uso ou destinatário não encontrado |
| `PUBLICA` | mensagem para todos |
| `PRIVADA` | mensagem privada |
| `SISTEMA` | aviso de entrada/saída de usuário |
| `USUARIOS` | lista de nicknames online, separados por vírgula |

## Conceitos trabalhados
- `ServerSocket`, `accept()` e pool de threads (`ExecutorService`)
- Lista compartilhada de clientes protegida com `synchronized`
- Difusão (*broadcast*) e mensagem direcionada
- Thread de escuta no cliente e atualização da tela com `SwingUtilities.invokeLater`
- Serialização de objetos em JSON com Gson
