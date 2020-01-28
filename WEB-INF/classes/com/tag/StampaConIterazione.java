package com.tag;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class StampaConIterazione extends BodyTagSupport{
    private int max=10,count;

    public void setMax(int max){
        this.max=max;
    }

    public int doStartTag() throws JspException{
        count=0;
        return EVAL_BODY_BUFFERED;
    }

    public void doInitBody() throws JspException{
        if (count<max){
            count++;
            try{getPreviousOut().print(count);} catch (IOException e){}
            pageContext.setAttribute("stringa","("+count+")");
        }
    }

    public int doAfterBody() throws JspException{
        if (count<max){
            count++;
            try{getPreviousOut().print(count);} catch (IOException e){}
            pageContext.setAttribute("stringa","("+count+")");
            return EVAL_BODY_AGAIN;
        } else {
            try{getBodyContent().writeOut(getPreviousOut());} catch (IOException e){}
            return SKIP_BODY;
        }
    }
    
}