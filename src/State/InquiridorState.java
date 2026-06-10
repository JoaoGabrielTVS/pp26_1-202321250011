package State;

import Debate.Microfone;
import Sistema.LogSistem;

/**
 * Padrão State — Interface dos estados do Inquiridor.
 *
 * Assim como MarioState define o que o Mario pode fazer
 * em cada estado, InquiridorState define o que o Inquiridor
 * pode fazer dependendo do momento do debate.
 *
 * Cada método retorna o PRÓXIMO estado — igual ao Mario.
 */
public interface InquiridorState {
    InquiridorState perguntar(int tempo, LogSistem log);
    InquiridorState replica(int tempo, LogSistem log);
}