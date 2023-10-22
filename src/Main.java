import java.util.Scanner;
import java.util.concurrent.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        System.out.println("Introduce un numero");
        int numero = sn.nextInt();


        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = new PrimoCallable(numero);

        Future<String> resultado = executor.submit(task);

        try {
            String mensaje = resultado.get();
            System.out.println(mensaje);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }
}