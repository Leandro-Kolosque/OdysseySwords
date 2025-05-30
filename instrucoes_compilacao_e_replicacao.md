# Documentação: Criando um Mod de Espada Customizada (Minecraft Forge 1.19.2)

Olá! Este documento detalha os passos que seguimos para transformar uma espada do seu resource pack "BladesOfMajestica" em um item customizado dentro de um mod para Minecraft Forge 1.19.2. Como a compilação final não pôde ser realizada no meu ambiente por limitações técnicas (ausência do JDK - Java Development Kit), incluí instruções para você compilar e testar o mod localmente.

## 1. Análise e Extração do Resource Pack

- O arquivo `BladesOfMajestica.zip` foi descompactado.
- Identificamos a espada `powerfusesword` como exemplo.
- Extraímos os seguintes arquivos:
    - Textura: `assets/minecraft/textures/item/powerfusesword.png`
    - Modelo: `assets/minecraft/models/item/powerfusesword.json`

## 2. Configuração do Ambiente Forge MDK

- Você forneceu o Forge MDK (Mod Development Kit) para a versão 1.19.2 (`forge-1.19.2-43.5.0-mdk.zip`).
- Criamos um diretório para o mod: `CustomSwordMod`.
- O conteúdo do MDK foi extraído para `/home/ubuntu/CustomSwordMod`.

## 3. Estrutura do Mod e Assets

- Criamos a estrutura de pastas padrão para os assets do mod dentro de `src/main/resources/assets/customswordmod/`:
    - `textures/item/`: Para as texturas dos itens.
    - `models/item/`: Para os modelos JSON dos itens.
    - `lang/`: Para os arquivos de tradução.
- Copiamos a textura e o modelo da espada para as pastas correspondentes, renomeando-os para seguir as convenções do mod:
    - Textura: `/home/ubuntu/CustomSwordMod/src/main/resources/assets/customswordmod/textures/item/powerfuse_sword.png`
    - Modelo: `/home/ubuntu/CustomSwordMod/src/main/resources/assets/customswordmod/models/item/powerfuse_sword.json`
- Ajustamos o arquivo `powerfuse_sword.json` para referenciar a textura corretamente dentro do namespace do mod:
    - Alteramos `"item/powerfusesword"` para `"customswordmod:item/powerfuse_sword"` nas seções `textures` e `particle`.

## 4. Implementação do Código Java

- **Refatoração:**
    - Renomeamos o pacote principal de `com.example.examplemod` para `com.example.customswordmod`.
    - Renomeamos a classe principal de `ExampleMod.java` para `CustomSwordMod.java` e ajustamos seu conteúdo.
    - Atualizamos o `MODID` para `"customswordmod"`.
- **Registro de Itens (`ModItems.java`):**
    - Criamos a classe `src/main/java/com/example/customswordmod/item/ModItems.java`.
    - Usamos `DeferredRegister` para registrar os itens do mod.
    - Registramos a espada `powerfuse_sword` como um `SwordItem`, definindo seu tier (Diamante), dano (3) e velocidade de ataque (-2.4F), e associando-a à aba de combate no modo criativo.
- **Classe Principal (`CustomSwordMod.java`):**
    - Removemos os registros de blocos e itens de exemplo do MDK.
    - Adicionamos a chamada `ModItems.register(modEventBus);` no construtor para registrar nossos itens customizados.

## 5. Arquivos de Configuração e Idioma

- **Idioma (`pt_br.json`):**
    - Criamos o arquivo `src/main/resources/assets/customswordmod/lang/pt_br.json`.
    - Adicionamos a tradução para o nome da espada: `"item.customswordmod.powerfuse_sword": "Espada Powerfuse"`.
- **`mods.toml`:**
    - Atualizamos o arquivo `src/main/resources/META-INF/mods.toml` com as informações do nosso mod:
        - `modId="customswordmod"`
        - `version="1.0.0"`
        - `displayName="Custom Sword Mod"`
        - `authors="Manus & SeuNome"` (Sinta-se à vontade para alterar!)
        - `description=\'\'\'Adiciona espadas customizadas baseadas no resource pack BladesOfMajestica.\'\'\'`

## 6. Compilação e Teste (Instruções para Você)

Como mencionei, a compilação falhou no meu ambiente. Siga estes passos para compilar e testar o mod localmente:

1.  **Instale o JDK 17:** O Minecraft 1.19.2 Forge requer o Java Development Kit (JDK) versão 17. Se você não o tiver, baixe e instale a partir de fontes confiáveis como o site oficial da Oracle (OpenJDK ou Oracle JDK) ou Adoptium (Eclipse Temurin).
2.  **Configure o JAVA_HOME:** Certifique-se de que a variável de ambiente `JAVA_HOME` esteja configurada para apontar para o diretório de instalação do JDK 17.
3.  **Descompacte o Mod:** Extraia o conteúdo do arquivo `CustomSwordMod_Source.zip` que estou enviando para uma pasta no seu computador.
4.  **Abra o Terminal/Prompt de Comando:** Navegue até a pasta onde você extraiu o mod (a pasta que contém o arquivo `gradlew`).
5.  **Execute o Gradle:**
    *   No Windows: Digite `gradlew build` e pressione Enter.
    *   No Linux/macOS: Digite `./gradlew build` e pressione Enter.
    *   Este comando irá baixar as dependências necessárias e compilar o mod. Pode levar algum tempo na primeira vez.
6.  **Localize o Mod Compilado:** Se a compilação for bem-sucedida, você encontrará o arquivo `.jar` do mod dentro da pasta `build/libs/`. O nome do arquivo será algo como `customswordmod-1.0.0.jar`.
7.  **Teste no Minecraft:**
    *   Copie o arquivo `.jar` gerado para a pasta `mods` da sua instalação do Minecraft Forge 1.19.2.
    *   Inicie o Minecraft com o perfil Forge 1.19.2.
    *   Verifique se o mod "Custom Sword Mod" aparece na lista de mods.
    *   Entre em um mundo no modo criativo e procure pela "Espada Powerfuse" na aba de combate.

## 7. Replicando para Outras Espadas

Para adicionar outras espadas do resource pack:

1.  **Copie Assets:** Copie a textura `.png` e o modelo `.json` da nova espada para as pastas `textures/item` e `models/item` do mod, respectivamente (lembre-se de renomear os arquivos de forma única, por exemplo, `excalibur_sword.png`).
2.  **Ajuste o Modelo JSON:** Edite o novo arquivo `.json` e mude as referências de textura para o namespace do seu mod (ex: `"customswordmod:item/excalibur_sword"`).
3.  **Registre o Item:** Abra `ModItems.java` e adicione um novo `RegistryObject` para a nova espada, similar ao `POWERFUSE_SWORD`, ajustando o nome (`EXCALIBUR_SWORD`), o ID de registro (`"excalibur_sword"`), e opcionalmente o tier, dano e velocidade.
4.  **Adicione Tradução:** Abra `pt_br.json` e adicione uma nova linha para o nome da nova espada (ex: `"item.customswordmod.excalibur_sword": "Espada Excalibur"`).
5.  **Compile e Teste:** Recompile o mod (`gradlew build`) e teste no jogo.

Espero que esta documentação ajude! Se tiver qualquer dúvida durante a compilação ou ao adicionar mais itens, pode me perguntar.
