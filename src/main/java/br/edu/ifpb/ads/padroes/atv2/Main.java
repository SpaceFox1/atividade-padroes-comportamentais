package br.edu.ifpb.ads.padroes.atv2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IItem> packOfItems = new ArrayList<>();
        packOfItems.add(new PhysicalProduct("Espada de Prata", 500.0));
        packOfItems.add(new Service("Treinamento de Caça Noturna", 1200.0));
        packOfItems.add(new PhysicalProduct("Armadura de Couro", 300.0));

        System.out.println("--- Executando o PrintValueVisitor ---");
        PrintValueVisitor printVisitor = new PrintValueVisitor();
        for (IItem item : packOfItems) {
            item.accept(printVisitor);
        }

        System.out.println("\n--- Executando o TaxReportVisitor ---");
        TaxReportVisitor taxVisitor = new TaxReportVisitor();
        for (IItem item : packOfItems) {
            item.accept(taxVisitor);
        }

        System.out.println("\nTotal de Impostos Arrecadados: R$ " + taxVisitor.getTotalTax());
    }
}
