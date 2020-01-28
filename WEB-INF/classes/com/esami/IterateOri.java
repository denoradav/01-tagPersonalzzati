package com.esami;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class Iterate extends BodyTagSupport {
  private Collection collection;
  private Iterator it;

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
    pageContext.setAttribute("item",it.next());
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
      pageContext.setAttribute("item",it.next());
      return EVAL_BODY_AGAIN;
    } else {
      try{
        getBodyContent().writeOut(getPreviousOut());
      } catch (IOException e) {}

      return SKIP_BODY;
    }
  }


}
