package br.edu.ifpb.ads.padroes.atv2;

public interface IItem {
    void accept(ITaxVisitor visitor);
    double getValue();
}
