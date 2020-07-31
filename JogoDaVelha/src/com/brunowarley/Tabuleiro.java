package com.brunowarley;

public class Tabuleiro {
	// Declarando as propriedades do Tabuleiro.
	private String mat[][] = new String[4][4];
	private int total = 0;
	private int draws = 0;

	// Criando os Getters e Setters das propriedades para definir e obter.
	public String[][] getMat() {
		return mat;
	}
	public void setMat(String[][] mat) {
		this.mat = mat;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int jogadas) {
		this.total = jogadas;
	}
	
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}

	// Passando o placar onde se encontra a situação do jogo.
	public int situation(String playerName, int playerGains, String pc, int compGains) {
		System.out.println("***Placar do jogo***");
		System.out.println("Total de Jogadas: " + this.total);
		System.out.println(playerName + " jogo ganho: " + playerGains);
		System.out.println(pc + " jogo ganho: " + compGains);
		System.out.println("Empates: " + this.draws);
		System.out.println("");
		return 0;
	}
	
	// Criando o tabuleiro.
	protected void createBoard() {
		for (int l = 0; l < mat.length; l++) { // Rows
			for (int c = 0; c < mat.length; c++) { // Cols
				if(mat[l][c] == mat[0][0]) { 
					this.mat[0][0] = "0 ";
			    }else if(mat[l][c] == mat[0][1] || mat[l][c] == mat[1][0]) { 
			    	this.mat[0][1] = "1 ";
			    	this.mat[1][0] = "1 ";
			    }else if(mat[l][c] == mat[0][2] || mat[l][c] == mat[2][0]) { 
			    	this.mat[0][2] = "2 ";
			    	this.mat[2][0] = "2 ";
			    }else if(mat[l][c] == mat[0][3] || mat[l][c] == mat[3][0]) { 
			    	this.mat[0][3] = "3 ";
			    	this.mat[3][0] = "3 ";
			    }else {
			    	this.mat[l][c] = "- ";
				}
			}
		}		
	}
	
	// Fazendo a visualização do tabuleiro.
	public void viewBoard() {
		for (int i = 0; i < mat.length; i++) { // Rows
			for (int j = 0; j < mat.length; j++) { // Cols
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
	
	// Método para inserção das jogadas das peças X ou O.
	public String positionBoard(String position, String piece) {
		String positionResult;
		int lin = 0, col = 0;

		// Convertendo as posições String para um Char array.
		char[] positBoard = String.valueOf(position).toCharArray();
		// Validando se  as jogadas é somento com 2(dois) dígitos e são númericos.
		if (positBoard.length == 2 && Character.isDigit(positBoard[0]) && Character.isDigit(positBoard[1])) {
			// Convertendo as posições de Char para inteiro em variáveis diferente.
			lin = Integer.parseInt(String.valueOf(positBoard[0]));
			col = Integer.parseInt(String.valueOf(positBoard[1]));
		}
		
		// Validando as jogadas.
		if (lin >= 4 && col >= 4 || lin == 0 || col == 0) {
			System.out.println("Jogada inválida!");
			positionResult = "false";
		}else if(mat[lin][col] == piece){
			System.out.println("Jogada inválida!");
			positionResult = "false";
		}else if(mat[lin][col] == "- ") {
			mat[lin][col] = piece;
			positionResult = "true";
		}else {
			System.out.println("Jogada inválida!");
			positionResult = "false";
		}
		
		// retornando uma String se a jogada foi inválida/válida com False/True. 
		return positionResult;
	}
	
	// Método para validar se ouve um ganhador ou empate.
	public int resultGame(String piece) {
		int vencedor = 0;
		// Validação das jogadas possíveis de ganhar ou empatar.
		if (mat[1][1].equalsIgnoreCase(piece) && mat[1][2].equalsIgnoreCase(piece) && mat[1][3].equalsIgnoreCase(piece)) {
			vencedor = 1;
		}else if (mat[2][1].equalsIgnoreCase(piece) && mat[2][2].equalsIgnoreCase(piece) && mat[2][3].equalsIgnoreCase(piece)){
			vencedor = 1;
		}else if (mat[3][1].equalsIgnoreCase(piece) && mat[3][2].equalsIgnoreCase(piece) && mat[3][3].equalsIgnoreCase(piece)){
			vencedor = 1;
		}else if (mat[1][1].equalsIgnoreCase(piece) && mat[2][1].equalsIgnoreCase(piece) && mat[3][1].equalsIgnoreCase(piece)){
			vencedor = 1;
		}else if (mat[1][2].equalsIgnoreCase(piece) && mat[2][2].equalsIgnoreCase(piece) && mat[3][2].equalsIgnoreCase(piece)){
			vencedor = 1;
		}else if (mat[1][3].equalsIgnoreCase(piece) && mat[2][3].equalsIgnoreCase(piece) && mat[3][3].equalsIgnoreCase(piece)){
			vencedor = 1;
		}else if (mat[1][1].equalsIgnoreCase(piece) && mat[2][2].equalsIgnoreCase(piece) && mat[3][3].equalsIgnoreCase(piece)){
			vencedor = 1;
		}else if (mat[1][3].equalsIgnoreCase(piece) && mat[2][2].equalsIgnoreCase(piece) && mat[3][1].equalsIgnoreCase(piece)){
			vencedor = 1;
		}else {
			int cont = 9;
			for (int l = 1; l < mat.length; l++) {
				for (int c = 1; c < mat.length; c++) {
					if (mat[l][c] == "- ") {
						vencedor = 0;
					}else {
						// Usando a operação ternária para validação do empate.
						cont--;
						vencedor = cont == 0 ? 2 : 0;
					}
				}
			}
		}
		
		// retorna 0 para nenhum ganhador, 1 para o ganhador ou 2 para empate.
		return vencedor;
	}
}