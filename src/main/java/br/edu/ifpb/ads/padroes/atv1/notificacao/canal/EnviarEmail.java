package br.edu.ifpb.ads.padroes.atv1.notificacao.canal;

import br.edu.ifpb.ads.padroes.atv1.notificacao.ICanalNotificacao;

public class EnviarEmail implements ICanalNotificacao {
    @Override
    public void notificar(String txtNotificacao) {
        System.out.println("Email de: SuperDiscoSystem para: [USERNAME]. Assunto: " + txtNotificacao);
    }
}
