package com.esami;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;



public class ListaEsami extends BodyTagSupport{
//	private Vector vettore;
	//private Iterator it;
	private int max;
	private int count = 0;
	//private Esame es;


	//private JspWriter out;

	public void setMax(int max){
		this.max=max;
	}


	public int doStartTag() throws JspException {
	/*	if (vettore.size()==0){
			return SKIP_BODY;
		} else{
			return EVAL_BODY_BUFFERED;
		}


	}

	public void doInitBody() throws JspException {
		it = vettore.iterator();
		/*it = vettore.iterator();
		if(it.hasNext()){
			es=(Esame)it.next();
			media = es.getVoto();
			pageContext.setAttribute("esame",es);
		}*/
	}

	public int doAfterBody() throws JspException{
		if (count<max)
			return EVAL_BODY_AGAIN;
		else{
			try{
			  getBodyContent().writeOut(getPreviousOut());
			} catch (IOException ioe){}
			return SKIP_BODY;
		}

		/*if (it.hasNext()) {
			es=(Esame)it.next();
			media = media + es.getVoto();
			pageContext.setAttribute("esameX",es);
			return EVAL_BODY_AGAIN;
		} else {
			try{
				getPreviousOut().println("Media: "+media+" <br>");
        getBodyContent().writeOut(getPreviousOut());
			} catch (IOException ioe){}
			return SKIP_BODY;
		}*/

	}
}
