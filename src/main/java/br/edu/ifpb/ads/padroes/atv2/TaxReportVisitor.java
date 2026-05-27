package br.edu.ifpb.ads.padroes.atv2;

public class TaxReportVisitor implements ITaxVisitor {
    private double totalTax = 0;

    @Override
    public void visit(PhysicalProduct product) {
        double tax = product.getValue() * 0.10;
        totalTax += tax;
        System.out.println("Imposto sobre Produto Físico '" + product.getName() + "': R$ " + tax);
    }

    @Override
    public void visit(Service service) {
        double tax = service.getValue() * 0.15;
        totalTax += tax;
        System.out.println("Imposto sobre Serviço '" + service.getDescription() + "': R$ " + tax);
    }

    public double getTotalTax() {
        return totalTax;
    }
}
