import java.util.Scanner;

public class HotelReservationSystem {

    public enum HotelConstants {
        QUARTOS_DISPONIVEIS(5),
        PRECO_DIARIA(200.0);

        private final double valor;

        HotelConstants(double valor) {
            this.valor = valor;
        }

        public double getValor() {
            return valor;
        }
    }

    private static int quartosOcupados = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuarReservando = true;

        while (continuarReservando) {
            
            if (quartosOcupados >= HotelConstants.QUARTOS_DISPONIVEIS.getValor()) {
                System.out.println("Desculpe, não há mais quartos disponíveis.");
                break; 
            }

            try {
                System.out.print("Informe sua idade: ");
                int idade = scanner.nextInt();

                
                if (idade < 18) {
                    System.out.println("Reserva não permitida. Você deve ter pelo menos 18 anos.");
                    continue; 
                }

                System.out.print("Informe o número de diárias que deseja reservar: ");
                int numeroDiarias = scanner.nextInt();

                
                if (numeroDiarias <= 0) {
                    System.out.println("Número de diárias inválido.");
                    continue; 
                }

                
                double valorTotal = numeroDiarias * HotelConstants.PRECO_DIARIA.getValor();

                System.out.print("Informe seu saldo disponível: ");
                double saldo = scanner.nextDouble();

                
                if (saldo < valorTotal) {
                    System.out.println("Saldo insuficiente para pagar a estadia.");
                    continue;
                }

                
                quartosOcupados += 1; 
                System.out.println("Reserva realizada com sucesso! Total a pagar: R$" + valorTotal);

            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                scanner.next();
            }

            
            System.out.print("Deseja fazer outra reserva? (s/n): ");
            char resposta = scanner.next().charAt(0);
            continuarReservando = (resposta == 's' || resposta == 'S');
        }

        scanner.close(); 
        System.out.println("Obrigado por usar o sistema de reservas!");
    }
}