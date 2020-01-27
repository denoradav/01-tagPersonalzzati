package com.esami;

import java.io.*; //serve se dobbiamo lanciare IOException
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class contamelo extends BodyTagSupport{
  private int count,max;

  public void setMax(int value){
    max = value;
  }

  public int doStartTag() throws JspException{
    max = 10;
    count = 0;
    return  EVAL_BODY_BUFFERED;
  }

  public void doInitBody() throws JspException{
    count ++;
    try {getPreviousOut().println("INIZIO<br>");} catch (Exception e) {}
    pageContext.setAttribute("count",Integer.toString(count)+" init");
  }

  public int doAfterBody(){
    if (count < max){
      count++;
      pageContext.setAttribute("count",Integer.toString(count) + "after");
      return EVAL_BODY_AGAIN;
    } else {
      try{
        getPreviousOut().println("FINE<br>");
        getBodyContent().writeOut(getPreviousOut());
      } catch (Exception e) {}
      return SKIP_BODY;
    }

  }
}
