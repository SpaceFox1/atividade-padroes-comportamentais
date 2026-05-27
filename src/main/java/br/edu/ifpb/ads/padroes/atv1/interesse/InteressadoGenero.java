package br.edu.ifpb.ads.padroes.atv1.interesse;

import br.edu.ifpb.ads.padroes.atv1.Disco;
import br.edu.ifpb.ads.padroes.atv1.notificacao.ICanalNotificacao;

public class InteressadoGenero implements IInteressado {
    private String generoInteresse;
    private ICanalNotificacao canal;

    public InteressadoGenero(String generoInteresse, ICanalNotificacao canal) {
        this.generoInteresse = generoInteresse.toLowerCase();
        this.canal = canal;
    }

    @Override
    public void atualizar(Disco disco) {
        if (disco.getGenero().toLowerCase().contains(generoInteresse)) {
            canal.notificar("Novo disco do gênero: " + disco.getGenero() + "! " + disco.getTitulo() + " - " + disco.getArtista());
        }
    }
}