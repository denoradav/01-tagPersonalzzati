package com.esami;

import java.io.*; //serve se dobbiamo lanciare IOException
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class contamelo2 extends BodyTagSupport{
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
  }

  public int doAfterBody(){
    if (count < max){
      count++;
      return EVAL_BODY_AGAIN;
    } else {
      try{
        getBodyContent().writeOut(getPreviousOut());
      } catch (Exception e) {}
      return SKIP_BODY;
    }

  }
}
