package com.odysseyswords.customswordmod.content.entities.base.interfaces;

/**
 * Contrato para toda entidade que funciona como boss no mod.
 * A inicialização da bossbar ocorre no construtor da classe abstrata,
 * portanto aqui ficam apenas os comportamentos de tick e identidade.
 */
public interface IBoss {

    /** Atualiza o progresso da bossbar a cada tick. */
    void tickBossBar();

    /** Chave de tradução do nome do boss (ex: "entity.odysseyswords.tartarus_guardian"). */
    String getBossName();

    /** Total de fases que este boss possui. */
    int getMaxPhases();
}