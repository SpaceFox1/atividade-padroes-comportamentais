package br.edu.ifpb.ads.padroes.atv2;

public interface ITaxVisitor {
    void visit(PhysicalProduct product);
    void visit(Service service);
}
