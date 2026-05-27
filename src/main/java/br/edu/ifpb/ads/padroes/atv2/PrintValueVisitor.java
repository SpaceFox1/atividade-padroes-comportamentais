package br.edu.ifpb.ads.padroes.atv2;

class PrintValueVisitor implements ITaxVisitor {
    @Override
    public void visit(PhysicalProduct product) {
        System.out.println("Item: Produto Físico [" + product.getName() + "] - Valor Base: R$ " + product.getValue());
    }

    @Override
    public void visit(Service service) {
        System.out.println("Item: Serviço [" + service.getDescription() + "] - Valor Base: R$ " + service.getValue());
    }
}