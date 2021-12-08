package com.foxminded.task7_sql.db;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ReaderSql {

    public String[] read() {
        String[] inst = null;
        String s = new String();
        StringBuffer sb = new StringBuffer();
        try {
            InputStream in = getClass().getResourceAsStream("/sqlScript.sql");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            while ((s = reader.readLine()) != null) {
                sb.append(s);
            }
            reader.close();
            inst = sb.toString().split(";");

        } catch (Exception ex) {
            System.out.println("*** Error : " + ex.toString());
            System.out.println(ex.getMessage());
        }
        return inst;
    }

}
