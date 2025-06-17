public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        System.out.print("Digite a expressão RPN: ");
        String linha = scanner.nextLine();
        String[] tokens = linha.trim().split(" ");

        try {
            double resultado = calculadora.avaliarExpressaoRPN(tokens);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        scanner.close();
    }
}
