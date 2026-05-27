package br.edu.ifpb.ads.padroes.atv2;

public class Service implements IItem {
    private String description;
    private double value;

    public Service(String description, double value) {
        this.description = description;
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void accept(ITaxVisitor visitor) {
        visitor.visit(this);
    }
}
