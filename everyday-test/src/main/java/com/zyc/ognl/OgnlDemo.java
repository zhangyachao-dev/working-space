package com.zyc.ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OgnlDemo {

    private OgnlContext getOgnlContext(){
        OgnlContext ognlContext = (OgnlContext)Ognl.createDefaultContext(this);
        return ognlContext;
    }

    private void testIf() throws OgnlException {
        OgnlContext ognlContext = getOgnlContext();
        //ognlContext.put("foo",3);
        ognlContext.setRoot(OgnlDemo.class.getCanonicalName());
        String exper = "#foo==3";
        Object expression = Ognl.parseExpression(exper);
        Object value = Ognl.getValue(expression, ognlContext, ognlContext.getRoot());
        System.out.println(value);
    }

    public static void main(String[] args) {
        OgnlDemo ognlDemo = new OgnlDemo();
        try {
            ognlDemo.testIf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
