package Builder;

import Debate.ColaboradorPolitico;
import Debate.MediarDebate;

/**
 * Padrão Builder — Interface abstrata do construtor.
 *
 * Define os passos que todo builder deve seguir para
 * montar um ColaboradorPolitico (Inquiridor ou Inquirido).
 *
 * O Builder resolve um problema real do seu sistema:
 * ao criar um Inquiridor ou Inquirido, é preciso:
 *   1. Clonar o ColaboradorPolitico original (Prototype)
 *   2. Associar o mediador
 *   3. Marcar o papel (inquiridor = true/false)
 *
 * Em vez de repetir essa lógica em MediarDebate,
 * o Builder centraliza e organiza esses passos.
 */
public abstract class InterfaceConstrutor {

    /** Passo 1: recebe o político base e clona via Prototype */
    public abstract void definirColaborador(ColaboradorPolitico colaborador);

    /** Passo 2: associa o mediador ao colaborador */
    public abstract void definirMediator(MediarDebate mediador);

    /** Passo 3: marca o papel (inquiridor = true ou false) */
    public abstract void definirPapel(boolean ehInquiridor);
}