package com.brunowarley;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random gerador = new Random();
		Tabuleiro board = new Tabuleiro();
		Jogador player = new Jogador();
		Computador computer = new Computador();
		
		// Usnado o @SuppressWarnings para não ficar mostrando Warnings desnecessários.
		@SuppressWarnings("resource")
		// Usando Scanner para digítos de entrada.
		Scanner ler = new Scanner(System.in);
		String keyBoard;
		
		System.out.println("***Jogo da Velha bruno com***");
		System.out.println("Para iniciar digite: (S)!");
		keyBoard = ler.nextLine();
		do {
			if(!keyBoard.equalsIgnoreCase("S")) {
				System.out.println("***Opção inválida!");
				System.out.println("Para iniciar digite: (S)!");
				keyBoard = ler.nextLine();
			}
		}while(!keyBoard.equalsIgnoreCase("S"));

		// Solicitando o nome do jogador.
		System.out.println("Digite seu primeiro nome: ");
		keyBoard = ler.nextLine();
		player.setName(keyBoard); // Definindo o nome do jogador
		
		// Solicitando para escolher um nível para jogar.
		System.out.println("Escolha o nível de difículdade!");
		System.out.println("Easy (E), Normal (N) ou Hard (H)");
		keyBoard = ler.nextLine();
		do {
			if(!keyBoard.equalsIgnoreCase("E") && !keyBoard.equalsIgnoreCase("N") && !keyBoard.equalsIgnoreCase("H")) {
				System.out.println("***Opção inválida!");
				System.out.println("Escolha o nível de difículdade!");
				System.out.println("Easy (E), Normal (N) ou Hard (H)");
				keyBoard = ler.nextLine();
			}
		}while(!keyBoard.equalsIgnoreCase("E") && !keyBoard.equalsIgnoreCase("N") && !keyBoard.equalsIgnoreCase("H"));
		
		// Definindo o nível do computador.
		if (keyBoard.equalsIgnoreCase("E")) {
			computer.setPc(computer.getCompA());
		}else if (keyBoard.equalsIgnoreCase("N")) {
			computer.setPc(computer.getCompB());
		}else if (keyBoard.equalsIgnoreCase("H")) {
			computer.setPc(computer.getCompC());
		}
		
		// Solicitando a peça de esolha do jogador.
		System.out.println("Escolha sua marcação entre X ou O:");
		keyBoard = ler.nextLine();
		player.setPiece(keyBoard.toUpperCase() + " ");
		if (keyBoard.equalsIgnoreCase("X")) {
			computer.setPiece("O ");
		}else {
			computer.setPiece("X ");
		}

		System.out.println("");
		board.situation(player.getName(), player.getGains(), computer.getPc(), computer.getGains());
		board.createBoard();
		System.out.println("Utilize 2(dois) digíto, primeiro para linha e segundo para coluna.");
		System.out.println("Ex.: 23, linha 2 e coluna 3");
		board.viewBoard();
		
		// Criando variáveis para uso nas jogadas.
		int winnerResult = 0, fimJogo = 0, start = gerador.nextInt(2);
		String result, message = "";
		
		do {
			if(start == 1) {
				// Fazendo todo o procedimento para validar as jogadas e avaliar se o Player ganhou o jogo.
				System.out.println("Escolha sua Jogada:");
				keyBoard = ler.nextLine();
				result = board.positionBoard(keyBoard, player.getPiece());
				start = result == "false" ? 1 : 0;
				winnerResult = board.resultGame(player.getPiece());
				if (winnerResult == 1) { player.setGains(player.getGains() + 1); message = "Você ganhou o jogo!"; }
			}
			else if(start == 0) {
				// Fazendo todo o procedimento para validar as jogadas e avaliar se o Computador ganhou o jogo.
				System.out.println("Jogada Computador:");
				String jogadaPc = computer.jogadasComp(computer.getPc(), board.getMat());
				System.out.println(computer.getPiece() + "- " + jogadaPc);
				result = board.positionBoard(jogadaPc, computer.getPiece());
				start = result == "false" ? 0 : 1;
				winnerResult = board.resultGame(computer.getPiece());
				if (winnerResult == 1) { computer.setGains(computer.getGains() + 1); message = "Computador ganhou o jogo!"; }
			}
			
			System.out.println("");
			board.viewBoard();
			if (winnerResult == 2) { message = "Houve um empate!"; board.setDraws(board.getDraws() + 1); }
			
			// Passando a messagem de quem ganhou o jogo, o placar e resetando o tabuleiro se desejar jogar novamente.
			if (message != "") {
				System.out.println(message);
				System.out.println("");
				board.setTotal(board.getTotal() + 1);
				board.situation(player.getName(), player.getGains(), computer.getPc(), computer.getGains());
				System.out.println("Deseja jogar novamente: (S)?");
				keyBoard = ler.nextLine();
				fimJogo = keyBoard.equalsIgnoreCase("S") ? 0 : 1;
				message = "";
				board.createBoard();
				if(fimJogo == 0) board.viewBoard();
			}
		}while(fimJogo == 0);
	
		System.out.println("Muito obrigado pelo jogo! :)");
	}
}
