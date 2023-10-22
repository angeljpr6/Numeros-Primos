import java.util.concurrent.Callable;

public class PrimoCallable implements Callable<String> {

    private int numero;

    public PrimoCallable(int numero) {
        this.numero = numero;
    }

    @Override
    public String call() throws Exception {
        if (esPrimo(numero)) {
            return "El número " + numero + " es primo.";
        } else {
            int mayorDivisor = encontrarMayorDivisor(numero);
            return "El número " + numero + " no es primo. El mayor divisor es " + mayorDivisor;
        }
    }

    private boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int encontrarMayorDivisor(int n) {
        for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1; // Si no se encuentra un divisor, se devuelve -1
    }
}
