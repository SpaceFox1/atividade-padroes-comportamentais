package br.edu.ifpb.ads.padroes.atv1;

import br.edu.ifpb.ads.padroes.atv1.interesse.InteressadoArtista;
import br.edu.ifpb.ads.padroes.atv1.interesse.InteressadoGenero;
import br.edu.ifpb.ads.padroes.atv1.interesse.InteressadoTitulo;
import br.edu.ifpb.ads.padroes.atv1.notificacao.canal.EnviarEmail;
import br.edu.ifpb.ads.padroes.atv1.notificacao.canal.EnviarPush;
import br.edu.ifpb.ads.padroes.atv1.notificacao.canal.EnviarSMS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RepositorioDiscos superDiscoSystem = new RepositorioDiscos();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        System.out.println("====== SISTEMA GERENCIADOR DE DISCOS ======");

        while (executando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar Interesse");
            System.out.println("2. Adicionar Novo Disco");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    registrarInteresseMenu(superDiscoSystem, scanner);
                    break;
                case 2:
                    adicionarDiscoMenu(superDiscoSystem, scanner);
                    break;
                case 3:
                    System.out.println("Encerrando o sistema...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void registrarInteresseMenu(RepositorioDiscos repositorio, Scanner scanner) {
        System.out.println("\n--- REGISTRAR INTERESSE ---");
        System.out.println("1. Por Artista");
        System.out.println("2. Por Gênero");
        System.out.println("3. Por Título");
        System.out.print("Escolha o tipo de interesse: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o termo de busca (ex: Iron Maiden, Rock): ");
        String termo = scanner.nextLine();

        System.out.println("Escolha o canal de notificação:");
        System.out.println("1. E-mail");
        System.out.println("2. SMS");
        System.out.println("3. Push Notification");
        System.out.print("Opção de canal: ");
        int canalOpcao = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1:
                if (canalOpcao == 1) {
                    repositorio.registrarInteressado(new InteressadoArtista(termo, new EnviarEmail()));
                } else if (canalOpcao == 2) {
                    repositorio.registrarInteressado(new InteressadoArtista(termo, new EnviarSMS()));
                } else {
                    repositorio.registrarInteressado(new InteressadoArtista(termo, new EnviarPush()));
                }
                System.out.println("Interesse em Artista (" + termo + ") registrado com sucesso!");
                break;

            case 2:
                if (canalOpcao == 1) {
                    repositorio.registrarInteressado(new InteressadoGenero(termo, new EnviarEmail()));
                } else if (canalOpcao == 2) {
                    repositorio.registrarInteressado(new InteressadoGenero(termo, new EnviarSMS()));
                } else {
                    repositorio.registrarInteressado(new InteressadoGenero(termo, new EnviarPush()));
                }
                System.out.println("Interesse em Gênero (" + termo + ") registrado com sucesso!");
                break;

            case 3:
                // Nota: Certifique-se de que a classe InteressadoTitulo exista no seu pacote de interesses
                if (canalOpcao == 1) {
                    repositorio.registrarInteressado(new InteressadoTitulo(termo, new EnviarEmail()));
                } else if (canalOpcao == 2) {
                    repositorio.registrarInteressado(new InteressadoTitulo(termo, new EnviarSMS()));
                } else {
                    repositorio.registrarInteressado(new InteressadoTitulo(termo, new EnviarPush()));
                }
                System.out.println("Interesse em Título (" + termo + ") registrado com sucesso!");
                break;

            default:
                System.out.println("Tipo de interesse inválido.");
        }
    }

    private static void adicionarDiscoMenu(RepositorioDiscos repositorio, Scanner scanner) {
        System.out.println("\n--- ADICIONAR NOVO DISCO ---");
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Ano de Lançamento: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        Disco novoDisco = new Disco(artista, titulo, genero, ano);

        repositorio.addDisco(novoDisco);
        System.out.println("Disco adicionado e observadores notificados!");
    }
}