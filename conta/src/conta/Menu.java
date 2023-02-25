package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
				
		ContaController contas = new ContaController();
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
			
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		
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
			
			try {
				opcao = entrada.nextInt();
			}  catch(InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				entrada.nextLine();
				opcao=0;
			}
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
					contas.cadastrar(new ContaCorrente(0,agencia,tipo,titular,saldo,limite));
					
				}
				case 2 ->{
					System.out.println("Aniversário da Conta Poupança: ");
					aniversario = entrada.nextInt();
					contas.cadastrar(new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario));
					
					}
				}
				
				keyPress();
				break;
				
			case 2:
				System.out.println("Listar todas as contas\n\n");
				
				contas.listarTodas();
				
				keyPress();
				break;
			
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				
				System.out.println("Número da conta: ");
				numero = entrada.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
				
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				
				System.out.println("Número da conta: ");
				numero = entrada.nextInt();
				
				if(contas.buscarNaCollection(numero) != null) {
				System.out.println("Número da agencia: ");
				agencia = entrada.nextInt();
				
				System.out.println("Nome do Titular: ");
				entrada.skip("\\R?");
				titular =  entrada.nextLine();
				
				tipo = contas.retornaTipo(numero);
				
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
			} else {
				System.out.println("A conta não foi encontrada");
			}
				
				keyPress();
				break;
			
			case 5:
				System.out.println("Apagar a Conta\n\n");
				
				System.out.println("Número da conta: ");
				numero = entrada.nextInt();
				
				contas.deletar(numero);
				
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

