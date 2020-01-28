package com.esami;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;



public class ListaEsami extends BodyTagSupport{
	private Vector vettore;
	private Iterator it;
	private Esame es;
	private int media;
	private String esame;
	private String votoStr;

	//private JspWriter out;

	public void setVettore(Vector vettore){
		this.vettore=vettore;
	}

	public void setEsame(String value){
		esame = value;
	}

	public void setVotoStr(String value){
		votoStr = value;
	}

	public int doStartTag() throws JspException {

		vettore = (Vector)pageContext.getAttribute("vettore");
		if (vettore==null) vettore=new Vector();

		//if (esame !=null && votoStr!=null){
			int voto = Integer.parseInt(votoStr);
			es = new Esame("lillo",27);
			vettore.add(es);
			pageContext.setAttribute("esame",es);
			pageContext.setAttribute("vettore",vettore);
		//}

		if (vettore.size()==0){
			return SKIP_BODY;
		} else{
			return EVAL_BODY_BUFFERED;
		}


	}

	public void doInitBody() throws JspException {
		it = vettore.iterator();
		if (it.hasNext())
			es=(Esame)it.next();
			media = es.getVoto();
			pageContext.setAttribute("esame",es);
	}

	public int doAfterBody() throws JspException{
		if (it.hasNext()) {
			es=(Esame)it.next();
			media = media + es.getVoto();
			pageContext.setAttribute("esame",es);
			return EVAL_BODY_AGAIN;
		} else {
			media = media / vettore.size();
			try{
				getPreviousOut().println("Media: "+media+" <br>");
        getBodyContent().writeOut(getPreviousOut());
			} catch (IOException ioe){}
			return SKIP_BODY;
		}
	}
}
