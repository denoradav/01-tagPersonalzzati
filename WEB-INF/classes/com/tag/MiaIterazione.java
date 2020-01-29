package com.tag;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;

public class MiaIterazione extends BodyTagSupport{
  private Vector vettore;
  private Iterator it;

  public int doStartTag() throws JspException{
    vettore = new Vector();
    vettore.addElement("ciao1");
    vettore.addElement("ciao2");
    vettore.addElement("ciao3");
    vettore.addElement("ciao3");
    return EVAL_BODY_BUFFERED;
  }

  public void doInitBody() throws JspException{
    it = vettore.iterator();
    if (it.hasNext()){
      pageContext.setAttribute("parola",it.next());
    }
  }

  public int doAfterBody() throws JspException{
    if (it.hasNext()){
      pageContext.setAttribute("parola",it.next());
      return EVAL_BODY_AGAIN;
    } else {
      try{
        getBodyContent().writeOut(getPreviousOut());
      } catch (IOException e) {}
      return SKIP_BODY;
    }
  }

}
