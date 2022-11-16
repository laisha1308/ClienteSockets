import java.io.*;
import java.net.Socket;

public class Cliente {
    public static final int PUERTO = 5000;
    public static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        System.out.println("La address es: " + HOST);
        Socket socket = new Socket(HOST,PUERTO);
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            salida.println("El usuario dice: " + "Hola servidor soy tu cliente");
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            salida.println("FIN");
        } finally {
            System.out.println("Cerrando Cliente");
            socket.close();
        }
    }
}