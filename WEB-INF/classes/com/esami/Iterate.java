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

  public void setCollection (Collection collection) {
    this.collection=collection;
  }

  public int doStartTag() throws JspException {
    return collection.size() > 0? EVAL_BODY_BUFFERED : SKIP_BODY;
  }

  /*public void doInitBody() throws JspException {
    it=collection.iterator();
    pageContext.setAttribute("item", it.next())
    ;
  }*/

  public void doInitBody() throws JspException{
    it = collection.iterator();
    es = (Esame)it.next();
    pageContext.setAttribute("item",es);
    media = es.getVoto();
    try {
     
      getPreviousOut().print("<br/><font size=\"4\" color=\"red\">Other way: </font>");
    } catch (IOException e) {throw new JspException (e.getMessage());}
  }

  /*public int doAfterBody() throws JspException {
    if (it.hasNext()) {
      pageContext.setAttribute("item", it.next());
      return EVAL_BODY_AGAIN;
    }else {
      try {getBodyContent().writeOut(getPreviousOut());
      }catch (java.io.IOException e) {
        throw new JspException (e.getMessage());
      }
      return SKIP_BODY;
    }
  }

  */


  public int doAfterBody() throws JspException{
    if (it.hasNext()){ 
      es = (Esame)it.next();
      media = es.getVoto();
      pageContext.setAttribute("item",es);
      return EVAL_BODY_AGAIN;
    } else {
        try {
          media = media / collection.size();
          getPreviousOut().print("<br/><font size=\"4\" color=\"red\">Other way: </font>");
        } catch (IOException e) {throw new JspException (e.getMessage());}
        try{
          getBodyContent().writeOut(getPreviousOut());
        } catch (IOException e) {throw new JspException (e.getMessage());}

      return SKIP_BODY;
    }
  }


}
