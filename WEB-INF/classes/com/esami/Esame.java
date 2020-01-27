package com.esami;

public class Esame{
	private String esame;
	private int voto;
	
	public Esame(){
		
	}
	
	public Esame(String esame,int voto){
		this.esame = esame;
		this.voto = voto;
	}
	
	public int getVoto(){
		return voto;
	}
	
	public String getEsame(){
		return esame;
	}
	
}