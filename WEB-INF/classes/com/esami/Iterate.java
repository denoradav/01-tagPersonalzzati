package com.esami;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.esami.Esame;

public class Iterate extends BodyTagSupport {
  private Collection collection;
  private Iterator it;
  private Esame es;
  private int media = 0;
  private String bla;

  public void setCollection (Collection collection) {
    this.collection=collection;
  }

  public int doStartTag() throws JspException {
    return collection.size() > 0? EVAL_BODY_BUFFERED : SKIP_BODY;
  }

  
  public void doInitBody() throws JspException{
    it = collection.iterator();
    es = (Esame)it.next();
    pageContext.setAttribute("item",es);
    media = es.getVoto();
    
  }

  public int doAfterBody() throws JspException{
    if (it.hasNext()){ 
      es = (Esame)it.next();
      media = media + es.getVoto();
      pageContext.setAttribute("item",es);
   
      return EVAL_BODY_AGAIN;
    } else {
        try {
          media = media /collection.size();
          getBodyContent().writeOut(getPreviousOut());
          getPreviousOut().print("Media=" + media +"<br>");
        } catch (IOException e) {throw new JspException (e.getMessage());}
     }
     return SKIP_BODY;
  }


}
