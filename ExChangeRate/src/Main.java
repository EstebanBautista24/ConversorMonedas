import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Moneda>  conversiones= new ArrayList<Moneda>();
        String base = "";
        String conversion = "";
        double valor;

        int opc;
        while (true){
            menu();
            opc = sc.nextInt();
            if (opc == 0) {
                break;
            }
            switch(opc) {
                case 1:
                    base = "USD";
                    conversion = "ARS";
                    break;
                case 2:
                    base = "ARS";
                    conversion = "USD";
                    break;
                case 3:
                    base ="USD";
                    conversion = "BRL";
                    break;
                case 4:
                    base = "BRL";
                    conversion = "USD";
                    break;
                case 5:
                    base = "USD";
                    conversion = "COP";
                    break;
                case 6:
                    base = "COP";
                    conversion = "USD";
                    break;
                case 7:
                    for (int i = 0; i < conversiones.size(); i++) {
                        System.out.println(conversiones.get(i).toString());
                    }
                    continue;
        }
        System.out.println("Ingresa el valor a convertir: ");
        valor = sc.nextDouble();
        Moneda moneda = new Moneda(valor,base,conversion);
        Conversion conversionc = new Conversion(moneda);
        conversiones.add(conversionc.getMoneda());
        System.out.println(conversionc.getMoneda());

        }



    }
    public  static  void menu(){
        System.out.println("****************************************");
        System.out.println("Bienvenido al conversor de monedas:");
        System.out.println("1. Dolar -> Peso Argentino");
        System.out.println("2. Peso Argentino -> Dolar");
        System.out.println("3. Dolar -> Real Brasileño");
        System.out.println("4. Real Brasileño -> Dolar");
        System.out.println("5. Dolar -> Peso Colombiano");
        System.out.println("6. Peso Colombiano -> Dolar");
        System.out.println("7. ver historial de conversion de monedas");
        System.out.println("0. Salir");
        System.out.println("Escoja una opcion: ");
        System.out.println("****************************************");
    }
}