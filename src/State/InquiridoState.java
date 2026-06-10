package State;

import Debate.Microfone;
import Sistema.LogSistem;

/**
 * Padrão State — Interface dos estados do Inquirido.
 *
 * Assim como MarioState define o que o Mario pode fazer,
 * InquiridoState define o que o Inquirido pode fazer
 * dependendo do momento do debate.
 */
public interface InquiridoState {
    InquiridoState responder(int tempo, LogSistem log);
    InquiridoState treplica(int tempo, LogSistem log);
}