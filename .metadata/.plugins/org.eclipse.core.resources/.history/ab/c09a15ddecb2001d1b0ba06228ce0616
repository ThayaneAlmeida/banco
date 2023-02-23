package conta;

import java.util.Scanner;

import conta.model.Conta;

public class Menu {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(1,101,1, "Ana", 1000.0f);
		c1.visualizar();
		c1.sacar(100.0f);
		c1.visualizar();
		c1.depositar(1500.0f);
		c1.visualizar();
		Scanner entrada = new Scanner(System.in);
		
		int opcao;
		
		while(true) {
			
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("Escolha a opção deseja:                              ");
			
			opcao = entrada.nextInt();
			
			if(opcao == 9) {
				System.out.println("Banco do Brazil com Z - O seu futuro começa aqui!");
				entrada.close();
				System.exit(0);
			}
			
			switch(opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");
				break;
				
			case 2:
				System.out.println("Listar todas as contas\n\n");
				break;
			
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				break;
				
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				break;
			
			case 5:
				System.out.println("Apagar a Conta\n\n");
				break;
			
			case 6:
				System.out.println("Saque\n\n");
				break;
				
			case 7:
				System.out.println("Depósito\n\n");
				break;
				
			case 8:
				System.out.println("Transferência entre Contas\n\n");
				break;
				
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
				
			}
			
		}
	}

}

