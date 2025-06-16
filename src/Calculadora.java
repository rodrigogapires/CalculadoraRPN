public class Calculadora {
    private Pilha pilha;

    public Calculadora() {
        this.pilha = new Pilha();
    }

    public enum Operador {
        ADICAO, SUBTRACAO, MULTIPLICACAO, DIVISAO
    }

    public double calcular(Operador operador) {
        if (pilha.empty()) {
            throw new IllegalStateException("Pilha vazia");
        }

        double operando2 = pilha.pop();
        double operando1 = pilha.pop();
        double resultado;

        switch (operador) {
            case ADICAO:
                resultado = operando1 + operando2;
                break;
            case SUBTRACAO:
                resultado = operando1 - operando2;
                break;
            case MULTIPLICACAO:
                resultado = operando1 * operando2;
                break;
            case DIVISAO:
                if (operando2 == 0) {
                    throw new ArithmeticException("Divisao por zero");
                }
                resultado = operando1 / operando2;
                break;
            default:
                throw new IllegalArgumentException("Operador invalido");
        }
        pilha.push(resultado);
        return resultado;
    }

    public double avaliarExpressaoRPN(String[] tokens) {
        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                pilha.push(Double.parseDouble(token));
            } else {
                Operador operador = null;
                switch (token) {
                    case "+": operador = Operador.ADICAO; break;
                    case "-": operador = Operador.SUBTRACAO; break;
                    case "*": operador = Operador.MULTIPLICACAO; break;
                    case "/": operador = Operador.DIVISAO; break;
                    default:
                        throw new IllegalArgumentException("Token invalido: " + token);
                }
                calcular(operador);
            }
        }
        double resultado = pilha.pop();

        if (!pilha.empty()) {
            throw new IllegalStateException("A expressao RPN nao esta completa, ainda ha valores na pilha");
        }
        return resultado;
    }
}
