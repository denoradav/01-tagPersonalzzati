package com.esami;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ListaEsami extends TagSupport{
	private Vector vettore;
	private Iterator it;
	private Esame es;
	private JspWriter out;
	
	public void setVettore(Vector vettore){
		this.vettore=vettore;
	}
	
	public int doStarTag() throws JspException {
		out = pageContext.getOut();
			try {out.println("ecchelo");} catch (Exception e){}
		if (vettore.size()>0){
			try {out.println(vettore.size());} catch (Exception e){}
			return SKIP_BODY;
		}
		else
			try {out.println(vettore.size());} catch (Exception e){}
			return EVAL_BODY_INCLUDE;
		
	}
	
	public void doInitBody() throws JspException {
		it = vettore.iterator();
		if (it.hasNext()){
			es=(Esame)it.next();
			
			try{
				out.println (es.getEsame() + " " + es.getVoto());
			} catch (IOException e){}
		}
	}
	
	public int doAfterBody() throws JspException{
		if (it.hasNext()) {
			es=(Esame)it.next();
			
			try{
				out.println (es.getEsame() + " " + es.getVoto());
			}
			catch (IOException e){}
			
			
			return EVAL_BODY_AGAIN;
		} else {
			try{
				out.println("addios");
			} catch (IOException ioe){}	
			return SKIP_BODY;
		}	
	}
}