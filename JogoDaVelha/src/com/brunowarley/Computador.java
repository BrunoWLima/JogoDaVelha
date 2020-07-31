package com.brunowarley;

// Utiliza��o da biblioteca Random para gerar valores aleat�rios.
import java.util.Random;

public class Computador {
	// Declarando as propriedades do Computador.
	private String compA;
	private String compB;
	private String compC;
	private String pc;
	private int gains;
	private String piece;
	private Random gerador = new Random();
	
	// Criando os Getters e Setters das propriedades para definir e obter.
	public String getCompA() {
		return compA = "PC - Easy";
	}
	public void setCompA(String compA) {
		this.compA = compA;
	}

	public String getCompB() {
		return compB = "PC - Normal";
	}
	public void setCompB(String compB) {
		this.compB = compB;
	}

	public String getCompC() {
		return compC = "PC - Hard";
	}
	public void setCompC(String compC) {
		this.compC = compC;
	}

	public String getPc() {
		return pc;
	}
	public void setPc(String pc) {
		this.pc = pc;
	}

	public int getGains() {
		return gains;
	}
	public void setGains(int gains) {
		this.gains = gains;
	}
	
	public String getPiece() {
		return piece;
	}
	public void setPiece(String piece) {
		this.piece = piece;
	}
	
	// M�todo para validar o n�vel do computador e criar jogadas aleat�ria.
	public String jogadasComp(String pc, String board[][]) {
		// Cria��o de vari�veis para uso no c�digo.
		String jogPc = "00";
		int posicao[], range[] = {11, 12, 13, 21, 22, 23, 31, 32, 33};
		
		if (this.compA == pc || this.compB == pc || this.compC == pc)
		{
			// Validando as jogadas do humano e criando uma jogada aleat�ria.
			do {
				posicao = this.selectPosition(range);
				for (int i = 1; i < board.length; i++) { // Rows
					for (int j = 1; j < board.length; j++) { // Cols
						if (board[i][j] == board[posicao[0]][posicao[1]]) {
							if(board[i][j] == "- ") {
								jogPc = "" + range[posicao[2]];
								break;
							}
						}
					}
				}
			}while(jogPc == "00");
		}/*else if (this.compB == pc)
		{
			// Validar jogadas do humano e criar uma jogada estrat�gica e uma jogada aleat�ria.
			
		}else if (this.compC == pc)
		{			
			// Validar jogadas do humano e criar jogadas estrat�gicas.
			
		}*/
		
		// Retorna a jogada do computador.
		return jogPc;
	}
	
	// Criando uma fun��o para uso geral nas jogadas.
	public int[] selectPosition(int range[]) {
		int lin, col, position;
		position = gerador.nextInt(range.length);
		char[] posit = String.valueOf(range[position]).toCharArray();
		lin = Integer.parseInt(String.valueOf(posit[0]));
		col = Integer.parseInt(String.valueOf(posit[1]));
		
		return new int[]{lin, col, position};
	}
}
