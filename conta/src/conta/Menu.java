package conta;

import java.io.IOException;
import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
				
		ContaCorrente c2 = new ContaCorrente(2,123,2,"Maria",2000.0f,1000.0f);
		c2.visualizar();
		
		ContaPoupanca c3 = new ContaPoupanca(3,321,2,"José",1000.f,22);
		c3.visualizar();
		Scanner entrada = new Scanner(System.in);
		
		
		
		int opcao, numero, agencia,tipo,numeroDestino,aniversario;
		float saldo,limite,valor;
		String titular;
		
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
				
				System.out.println("Número da agencia: ");
				agencia = entrada.nextInt();
				
				System.out.println("Nome do titular: ");
				entrada.skip("\\R?");
				titular = entrada.nextLine();
				
				do {
					System.out.println("Tipo da Conta(1-CC / 2-CP)");
					tipo = entrada.nextInt();
				} while(tipo != 1 && tipo != 2);
				
				System.out.println("Saldo da conta: ");
				saldo = entrada.nextInt();
				
				switch(tipo) {
				case 1 ->{
					System.out.println("Limite da Conta Corrente: ");
					limite = entrada.nextFloat();
					ContaCorrente cc = new ContaCorrente(0,agencia,tipo,titular,saldo,limite);
					cc.visualizar();
				}
				case 2 ->{
					System.out.println("Aniversário da Conta Poupança: ");
					aniversario = entrada.nextInt();
					ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
					cp.visualizar();
					}
				}
				
				keyPress();
				break;
				
			case 2:
				System.out.println("Listar todas as contas\n\n");
				keyPress();
				break;
			
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				
				System.out.println("Número da conta: ");
				numero = entrada.nextInt();
				
				keyPress();
				break;
				
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				
				System.out.println("Número da conta: ");
				numero = entrada.nextInt();
				
				System.out.println("Número da agencia: ");
				agencia = entrada.nextInt();
				
				System.out.println("Nome do Titular: ");
				entrada.skip("\\R?");
				titular =  entrada.nextLine();
				
				tipo = 0;
				
				System.out.println("Saldo da conta: ");
				saldo = entrada.nextFloat();
				
				switch(tipo) {
				case 1 ->{
					System.out.println("Limite da Conta Corrente: ");
					limite = entrada.nextFloat();
					ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
					cc.visualizar();
				}
				case 2 ->{
					System.out.println("Aniversário da Conta Poupança: ");
					aniversario = entrada.nextInt();
					ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
					cp.visualizar();
					}
				}
				keyPress();
				break;
			
			case 5:
				System.out.println("Apagar a Conta\n\n");
				
				System.out.println("Número da conta: ");
				numero = entrada.nextInt();
				
				keyPress();
				break;
			
			case 6:
				System.out.println("Saque\n\n");
				
				System.out.println("Número da conta: ");
				numero = entrada.nextInt();
				
				System.out.println("Valor do Saque: ");
				valor = entrada.nextFloat();
				
				keyPress();
				break;
				
			case 7:
				System.out.println("Depósito\n\n");
				
				System.out.println("Número da conta: ");
				numero = entrada.nextInt();
				
				System.out.println("Valor do Depósito: ");
				valor = entrada.nextFloat();
				
				keyPress();
				break;
				
			case 8:
				System.out.println("Transferência entre Contas\n\n");
				
				System.out.println("Número da conta - Origem: ");
				numero = entrada.nextInt();
				
				System.out.println("Número da conta - Destino: ");
				numeroDestino = entrada.nextInt();
				
				System.out.println("Valor do Transferência: ");
				valor = entrada.nextFloat();
				keyPress();
				break;
				
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
				
			}
			
		}
	}
	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}


}

