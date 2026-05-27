package br.edu.ifpb.ads.padroes.atv1.notificacao.canal;

import br.edu.ifpb.ads.padroes.atv1.notificacao.ICanalNotificacao;

public class EnviarSMS implements ICanalNotificacao {
    @Override
    public void notificar(String txtNotificacao) {
        System.out.println("*Bzzzz* *Bzzzzz* Novo SMS: [SuperDiscoSystem] " + txtNotificacao);
    }
}
