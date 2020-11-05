package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String n = "Y";
        short s = 2;
        int a = 23;
        boolean m = false;
        char c = 'C';
        double d = 3.14;
        long l = 100500;
        byte b = 1;
        LOG.debug("Variables info String : {},"
              +  " short : {}, int : {}, "
                + " boolean : {}, char : {}, "
                + " double : {}, long : {}, "
                + "byte : {}", n, s, a, m, c, d, l, b);
    }
}
