import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    executarExercicio01();
                    break;
                case 2:
                    executarExercicio02();
                    break;
                case 3:
                    executarExercicio03(scanner);
                    break;
                case 4:
                    executarExercicio04(scanner);
                    break;
                case 5:
                    executarExercicio05(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("=== Exercicios com Fila ===");
        System.out.println("1 - Fila com valores fixos");
        System.out.println("2 - Fila de nomes");
        System.out.println("3 - Remover 10 numeros da fila");
        System.out.println("4 - Fila de atendimento");
        System.out.println("5 - Fila de impressao");
        System.out.println("0 - Sair");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Entrada invalida. Digite um numero inteiro.");
            scanner.nextLine();
        }
    }

    private static void executarExercicio01() {
        Queue<Integer> fila = criarFilaValoresFixos();

        System.out.println("Fila completa: " + fila);
        fila.poll();
        System.out.println("Fila apos remover o primeiro elemento: " + fila);

    }

    private static void executarExercicio02() {
        Queue<String> fila = criarFilaNomes();

        System.out.println("Primeiro elemento: " + fila.peek());
        System.out.println("Quantidade de elementos: " + fila.size());

    }

    private static void executarExercicio03(Scanner scanner) {
        Queue<Integer> fila = new LinkedList<>();

        System.out.println("Digite 10 numeros:");
        for (int i = 1; i <= 10; i++) {
            fila.offer(lerInteiro(scanner, "Numero " + i + ": "));
        }

        List<Integer> removidos = removerTodosElementos(fila);
        System.out.println("Elementos removidos: " + removidos);

    }

    private static void executarExercicio04(Scanner scanner) {
        Queue<String> fila = new LinkedList<>();
        int opcao;

        do {
            System.out.println("\n FILA DE ATENDIMENTO");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Atender cliente");
            System.out.println("3 - Mostrar proximo cliente");
            System.out.println("4 - Exibir fila");
            System.out.println("0 - Sair");
            opcao = lerInteiro(scanner, "Opcao: ");

            switch (opcao) {

                case 1:
                    System.out.print("Nome do cliente: ");
                    fila.offer(scanner.nextLine());
                    break;

                case 2:
                    if (!fila.isEmpty()) {
                        System.out.println("Atendido: " + fila.poll());
                    } else {
                        System.out.println("Fila vazia");
                    }
                    break;

                case 3:
                    if (!fila.isEmpty()) {
                        System.out.println("Proximo: " + fila.peek());
                    } else {
                        System.out.println("Fila vazia");
                    }
                    break;

                case 4:
                    System.out.println("Fila: " + fila);
                    break;

                default:
                    if (opcao != 0) {
                        System.out.println("Opcao invalida!");
                    }
            }

        } while (opcao != 0);


    }

    private static void executarExercicio05(Scanner scanner) {
         Queue<String> fila = new LinkedList<>();
        int opcao;

        do {
            System.out.println("\n FILA DE IMPRESSAO");
            System.out.println("1 - Adicionar documento");
            System.out.println("2 - Imprimir documento");
            System.out.println("3 - Proximo documento");
            System.out.println("4 - Exibir fila");
            System.out.println("0 - Sair");
            opcao = lerInteiro(scanner, "Opcao: ");

            switch (opcao) {
                case 1:
                    System.out.print("Documento: ");
                    adicionarDocumento(fila, scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Impresso: " + imprimirDocumento(fila));
                    break;

                case 3:
                    System.out.println("Proximo: " + proximoDocumento(fila));
                    break;

                case 4:
                    System.out.println("Fila: " + fila);
                    break;

                default:
                    if (opcao != 0) {
                        System.out.println("Opcao invalida!");
                    }
            }

        } while (opcao != 0);

    }

    public static Queue<Integer> criarFilaValoresFixos() {
        Queue<Integer> fila = new LinkedList<>();

        fila.offer(10);
        fila.offer(20);
        fila.offer(30);
        fila.offer(40);
        fila.offer(50);

        return fila;
    }

    public static Queue<String> criarFilaNomes() {
        Queue<String> fila = new LinkedList<>();

        fila.offer("Ana");
        fila.offer("Carlos");
        fila.offer("Pedro");
        fila.offer("Juliana");
        return fila;
    }

    public static List<Integer> removerTodosElementos(Queue<Integer> fila) {
         List<Integer> removidos = new ArrayList<>();

        while (!fila.isEmpty()) {
            removidos.add(fila.poll());
        }
        return removidos;
    }

    public static List<String> atenderClientes(Queue<String> fila) {
        List<String> atendidos = new ArrayList<>();

        while (!fila.isEmpty()) {
            atendidos.add(fila.poll());
        }
        return atendidos;
    }

    public static void adicionarDocumento(Queue<String> fila, String documento) {
        fila.offer(documento);

    }

    public static String imprimirDocumento(Queue<String> fila) {
        return fila.poll();
    }

    public static String proximoDocumento(Queue<String> fila) {
        return fila.peek();
    }
}
