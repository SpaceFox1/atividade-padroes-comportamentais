package br.edu.ifpb.ads.padroes.atv1.interesse;

import br.edu.ifpb.ads.padroes.atv1.Disco;
import br.edu.ifpb.ads.padroes.atv1.notificacao.ICanalNotificacao;

public class InteressadoArtista implements IInteressado {
    private String artistaInteresse;
    private ICanalNotificacao canal;

    public InteressadoArtista(String artistaInteresse, ICanalNotificacao canal) {
        this.artistaInteresse = artistaInteresse.toLowerCase();
        this.canal = canal;
    }

    @Override
    public void atualizar(Disco disco) {
        if (disco.getArtista().toLowerCase().contains(artistaInteresse)) {
            canal.notificar("Novo disco do artista: " + disco.getArtista() + "! " + disco.getTitulo() + " - " + disco.getGenero() + ", " + disco.getAnoLancamento());
        }
    }
}