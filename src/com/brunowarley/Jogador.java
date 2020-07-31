package com.brunowarley;

public class Jogador {
	// Declarando as propriedades do Jogador.
	private String name;
	private int gains;
	private String piece;
	
	// Criando os Getters e Setters das propriedades para definir e obter.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}