package com.tag;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;

public class MiaIterazione2 extends BodyTagSupport {

  private Iterator it;
  private Vector vettore;

  public void setVettore(Vector vettore){
    this.vettore = vettore;
  }

  public int doStartTag() throws JspException{
    if (vettore.size()>0){
      return EVAL_BODY_BUFFERED;
    } else {
      return SKIP_BODY;
    }
  }

  public void doInitBody() throws JspException{
    it = vettore.iterator();
    if(it.hasNext()){
      pageContext.setAttribute("valore",it.next());
    }
  }

  public int doAfterBody() throws JspException{
    if(it.hasNext()){
      pageContext.setAttribute("valore",it.next());
      return EVAL_BODY_AGAIN;
    } else {
      try{getBodyContent().writeOut(getPreviousOut());} catch (IOException e) {}
      return SKIP_BODY;
    }
  }

}
