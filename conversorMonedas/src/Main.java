import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        double cantidad = 0;
      Service consulta = new Service();
        Moneda moneda;
        String monedaDestino = null;
        String monedaValor= null;
        var opcion =-1;

        while (opcion!=0){
            System.out.println(
                    """
                            ******************************************************************
                            
                            Sea bienvenido/a al conversor de monedas
                            
                            1)Dólar =>>> Peso argentino
                            2)Peso argentino =>>> Dólar
                            3)Dólar =>>> Real brasileño
                            4)Real brasileño =>>> Dólar
                            5)Dólar =>>> Peso colombiano
                            6)Peso colombiano =>>> Dólar
                            7)Peso argentino =>>> Real brasileño
                            8)Real brasileño =>>> Peso argentino
                            
                            9)SALIR
                            
                            Elija una opcion valida:
                            
                            *******************************************************************
                            """);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1:
                    monedaValor="USD";
                    monedaDestino="ARS";
                    break;
                case 2:
                    monedaValor="ARS";
                    monedaDestino ="USD";
                    break;
                case 3:
                    monedaValor="USD";
                    monedaDestino ="BRL";
                    break;
                case 4:
                    monedaValor="BRL";
                    monedaDestino ="USD";
                    break;
                case 5:
                    monedaValor="USD";
                    monedaDestino ="COP";
                    break;
                case 6:
                    monedaValor="COP";
                    monedaDestino ="USD";
                    break;
                case 7:
                    monedaValor="ARS";
                    monedaDestino ="BRL";
                    break;
                case 8:
                    monedaValor="BRL";
                    monedaDestino ="ARS";
                    break;
                case 9:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("La opcion seleccionada no es valida");
            }
            System.out.println("Ingrese el valor que desea convertir");
            cantidad =teclado.nextDouble();
            moneda = consulta.buscaMoneda(monedaValor,monedaDestino,cantidad);
            System.out.println("El valor "+cantidad+ " ["+moneda.base_code()+"] "+"corresponde al valor final de =>> "+ moneda.conversion_result()+ " ["+moneda.target_code()+"]");

        }

    }
}