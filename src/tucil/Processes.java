/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tucil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */



// COBA GIT BISA HUAHAHAHAHHAAHAHAHA
public class Processes {
    
    boolean checkValidity(String q, String[] aq){
        boolean status = true;
        int jumchar = q.length()-1;
        if (!(q.charAt(jumchar) == ';')) {
            status = false;
        }
        if (checkTypoMain(q,aq) == false) {
            status = false;
        }
        return status;
    }
    
    int cobaCoba(int no){
        return no;
    }


    ArrayList<String[]> masukDictionary(ArrayList<String[]> arrayDictionary){
        BufferedReader ins;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read;
        try{
           ins = new BufferedReader(new FileReader("DataDictionary.txt"));
           while((read = ins.readLine()) != null){
             arrayDictionary.add(read.split(";"));
             read+=read+"\n";
           }
           ins.close();
         }catch(IOException e){
           System.out.println("There was a problem found: " + e);
         }
        return arrayDictionary;
    }
    
    boolean checkTypoMain(String q, String[] aq){
        boolean status = true;
        if (aq[1] != ("SELECT") && !(q.contains("FROM"))) {
            status = false;
        }
        return status;
    }
    
    String[] arrayOfQuery(String q){
        return q.split(" ");
    }
    
    ArrayList<String> arrayOfStatements(String[] aq){
        ArrayList<String> statements = new ArrayList<String>();
        statements.add(aq[0]);
            for (int i = 1; i <= aq.length-1; i++) {
                    if ("FROM".equals(aq[i])) {
                        statements.add(aq[i]);
                    }else if ("JOIN".equals(aq[i])) {
                        statements.add(aq[i]);
                    }else if ("ON".equals(aq[i])) {
                        statements.add(aq[i]);
                    }else if (';' == aq[i].charAt(aq[i].length()-1)){
                        statements.add(Character.toString(aq[i].charAt(aq[i].length()-1)));
                    }
            }
        return statements;
    }
    
        ArrayList<String> deleteArrayOfStatements(String[] aq){
            String[] arrayFrom = {"FROM"};
        ArrayList<String> statements = new ArrayList<String>();
        
            for (int i = 1; i <= aq.length-1; i++) {
                    if ((!"JOIN".equals(aq[i])) || (!"ON".equals(aq[i])) || (!(arrayFrom[0].equals(aq[i])))) {
                        statements.add(aq[i]);
                        System.out.println(aq[i]);
                    }else if (';' != aq[i].charAt(aq[i].length()-1)){
                        statements.add(Character.toString(aq[i].charAt(aq[i].length()-1)));
                    }
            }
        return statements;
        }
        
        
        
        
        ///
        ArrayList<String> deleteArrayOfStatements2(String[] aq){
        ArrayList<String> statements = new ArrayList<String>();
        ArrayList<String> nonstatements = new ArrayList<String>();
        
            for (int i = 1; i <= aq.length-1; i++) {
                    if ("FROM".equals(aq[i])) {
                        statements.add(aq[i]);
                    }else if ("JOIN".equals(aq[i])) {
                        statements.add(aq[i]);
                    }else if ("ON".equals(aq[i])) {
                        statements.add(aq[i]);
                    }else if (';' == aq[i].charAt(aq[i].length()-1)){
                        statements.add(Character.toString(aq[i].charAt(aq[i].length()-1)));
                    } else{
                        if (aq[i].contains(",")) {
                            String temp = aq[i].replace(",", "");
                            aq[i] = temp;
                            nonstatements.add(aq[i]);
                        } else {
                            nonstatements.add(aq[i]);
                        }
                        
                    }
            }
        return nonstatements;
    }
        ///
        
    
    ArrayList<String> arrayOfTable(String[] t){
        ArrayList<String> statements = new ArrayList<String>();
            for (int i = 0; i <= t.length-1; i++) {
                    if (("pembeli".equals(t[i]))||("pembeli,".equals(t[i]))) {
                        statements.add("pembeli");
                    }else if ("barang".equals(t[i])) {
                        statements.add(t[i]);
                    }else if ("pembelian".equals(t[i])) {
                        statements.add(t[i]);
                    }
            }
        return statements;
    }
    
    ArrayList<String> statementsDefault1(){
        ArrayList<String> def1 = new ArrayList<String>();
        def1.add("SELECT");
        def1.add("FROM");
        def1.add("JOIN");
        def1.add("ON");
        def1.add(";");
        return def1;
    }
    
    ArrayList<String> statementsDefault2(){
        ArrayList<String> def2 = new ArrayList<String>();
        def2.add("SELECT");
        def2.add("FROM");
        def2.add(";");
        return def2;
    }
    
    
    boolean checkError(ArrayList<String> def1, ArrayList<String> def2, ArrayList<String> statements){
        boolean ermessage = false;
        boolean bener1 = def1.equals(statements);
        boolean bener2 = def2.equals(statements);
        //System.out.println("Cek 1: "+bener1);
        //System.out.println("Cek 2: "+bener2);
        if ((bener1 == true)||(bener2 == true)){
            ermessage =true;
        }else{
            ermessage =false;
        }
        return ermessage;
    }
    
    
}
