package com.esami;

public class Esame implements java.io.Serializable{
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