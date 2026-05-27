package br.edu.ifpb.ads.padroes.atv1.interesse;

import br.edu.ifpb.ads.padroes.atv1.Disco;
import br.edu.ifpb.ads.padroes.atv1.notificacao.ICanalNotificacao;

public class InteressadoTitulo implements IInteressado{
    private String tituloInteresse;
    private ICanalNotificacao canal;

    public InteressadoTitulo(String tituloInteresse, ICanalNotificacao canal) {
        this.tituloInteresse = tituloInteresse.toLowerCase();
        this.canal = canal;
    }

    @Override
    public void atualizar(Disco disco) {
        if (disco.getTitulo().toLowerCase().contains(tituloInteresse)) {
            canal.notificar("Novo disco adicionado: " + disco.getTitulo() + " - " + disco.getArtista() + " [" + disco.getAnoLancamento() + ", " + disco.getGenero() + "]");
        }
    }
}
