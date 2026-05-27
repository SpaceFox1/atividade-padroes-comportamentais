package br.edu.ifpb.ads.padroes.atv2;

public class PhysicalProduct implements IItem {
    private String name;
    private double value;

    public PhysicalProduct(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(ITaxVisitor visitor) {
        visitor.visit(this);
    }
}
