/*
    CATATAN PROGRAM
    
    program hanya dapat menerima input statement "SELECT,FROM,JOIN,ON"
        dalam huruf kapital
    selain itu semua statement adalah huruf kecil


        YANG SUDAH DICOBA BENAR
        
        SELECT id_beli, nama FROM pembelian, pembeli;

        
        YANG SUDAH DICOBA SALAH
        SELECT id_beli, nama FROM pembeli JOIN barang;
        SELECT id_beli FROM mahasiswa, pembeli;
        SELECT nim from barang;
        SELECT beli FROM pembelian;
        
*/
package tucil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class TugasKecil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("PROGRAM PARSER SEDERHANA");
        System.out.println("=======================================================================");
        System.out.print("Masukkan SQL Statement : ");
        System.out.println("");
        String something = s.nextLine();
        s.close();
 
        Processes proses = new Processes();
        ArrayList<String[]> arrayDictionary = new ArrayList<String[]>();
        System.out.println("");

        ArrayList<String> defstatements = new ArrayList<String>();
        defstatements.add("SELECT");
        defstatements.add("FROM");
        defstatements.add("JOIN");
        defstatements.add("ON");
        defstatements.add(";");
                
        arrayDictionary = proses.masukDictionary(arrayDictionary);

//        System.out.println("[CEK] Dictionary dalam .txt:");
//        for (int i = 0; i < arrayDictionary.size(); i++) {
//            for (int j = 0; j < arrayDictionary.get(i).length; j++) {
//                System.out.println("dict ke-" + (i+1) +","+j+ ": " + arrayDictionary.get(i)[j]);
//            }
//        }
        
//        System.out.println("");
//        
//        System.out.println("[CEK] Kata dalam array:");
        String[] arrayQuery = proses.arrayOfQuery(something);
//        for (int i = 0; i < arrayQuery.length; i++) {
//            System.out.println("index ke-" + i + ": " + arrayQuery[i]);
//        }
        
//        System.out.println("");
        ArrayList<String> statements = proses.arrayOfStatements(arrayQuery); 
//        System.out.println("[CEK] Statements dalam arraylist:");
//        for (int i = 0; i < statements.size(); i++) {
//            System.out.println("statement ke-" + i + ": " + statements.get(i));
//        }
        
//        System.out.println("");
        ArrayList<String> statementsd = proses.deleteArrayOfStatements2(arrayQuery); 
//        System.out.println("[CEK] Delete statements dalam arraylist:");
//        for (int i = 0; i < statementsd.size(); i++) {
//            System.out.println("statement ke-" + i + ": " + statementsd.get(i));
//        }


//        System.out.println("");
//        System.out.println("[CEK] statement default 1");
        ArrayList<String> def1 = proses.statementsDefault1();
//        for (int i = 0; i < def1.size(); i++) {
//            System.out.println("statement ke- "+i+": "+def1.get(i));
//        }
        
 //       System.out.println("");
//        System.out.println("[CEK] statement default 2");
        ArrayList<String> def2 = proses.statementsDefault2();
//        for (int i = 0; i < def2.size(); i++) {
//            System.out.println("statement ke- "+i+": "+def2.get(i));
//        }
             
        ///     PROSES MENDAPATKAN NAMA KOLOM DALAM QUERY
   //     System.out.println("");
        ArrayList<String> parakolom = new ArrayList<String>();
        int temp = (arrayQuery.length);
        boolean status = true;
        int idxFrom = 500;
            for (int i = 1; i < temp; i++) {
                if (arrayQuery[i].equals(defstatements.get(1))) {
                    idxFrom = i;
                }else if (i < idxFrom ){
                    if (arrayQuery[i].contains(",")) {
                        String neww = arrayQuery[i].replace(",", "");
                        arrayQuery[i] = neww;
                      //  System.out.println(arrayQuery[i]);
                        parakolom.add(arrayQuery[i]);
                    } else {
                        //System.out.println(arrayQuery[i]);
                        parakolom.add(arrayQuery[i]);
                    }
                }
            }
            
        
         
        ///     PROSES MENDAPATKAN NAMA KOLOM DALAM QUERY
       // System.out.println("");
        ArrayList<String> paratabel = new ArrayList<String>();
        int temp2 = (arrayQuery.length);
        int idxTikom     = 500;
            for (int i = 1; i < temp2; i++) {
                if (arrayQuery[i].equals(defstatements.get(4))) {
                    idxTikom = i;
                }else if ((i < idxTikom ) && (i > idxFrom)){
                    if (arrayQuery[i].contains(",")) {
                        String newww = arrayQuery[i].replace(",", "");
                        arrayQuery[i] = newww;
               //         System.out.println(arrayQuery[i]);
                        paratabel.add(arrayQuery[i]);
                    }else if (arrayQuery[i].contains(";")) {
                        String newww = arrayQuery[i].replace(";", "");
                        arrayQuery[i] = newww;
                  //      System.out.println(arrayQuery[i]);
                        paratabel.add(arrayQuery[i]);
                    } else {
                    //    System.out.println(arrayQuery[i]);
                        paratabel.add(arrayQuery[i]);
                    }
                }
            }
            
           

        
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < arrayDictionary.size(); i++) {
            for (int j = 0; j < arrayDictionary.get(i).length; j++) {
                list.add(arrayDictionary.get(i)[j]);
            }
        }
        
  //      System.out.println("");
   //     System.out.println("[CEK] Error kolom dan tabel :");
        boolean er = true;
        for (int i = 0; i < statementsd.size(); i++) {
            if (!list.contains(statementsd.get(i))) {
//                System.out.println("Ga ada, indeks ke-"+i);
//                System.out.println(list.get(i));
//                System.out.println(statementsd.get(i));
                er = false;
            }
            
        }
    //    System.out.println(er);
        System.out.println("-----------------------------------------------------------------------------");    
        System.out.println("OUTPUT PROGRAMNYA");
        boolean error = proses.checkError(def1, def2, statements);
        if ((error == true)&&(er==true)) {
          //  System.out.println(er);
            int w = 1;
            for (int i = 0; i < paratabel.size(); i++) {
                System.out.println("");
                System.out.println("Tabel ("+w+") : "+paratabel.get(i));
                System.out.print("List kolom: ");
                for (int j = 0; j < arrayDictionary.size(); j++) {
                    if ((paratabel.get(i).equalsIgnoreCase(arrayDictionary.get(j)[0]))) {
                        for (int k = 0; k < arrayDictionary.get(j).length; k++) {
                            for (int l = 0; l < parakolom.size(); l++) {
                                if (arrayDictionary.get(j)[k].equalsIgnoreCase(parakolom.get(l))) {
                                    System.out.print(parakolom.get(l)+", ");
                                }
                            }
                        }
                    }
                }
                w++;
            }
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("BUILD SUCCESSFUL ");
            System.out.println("=======================================================================");
        }else {
            System.out.println("error");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("SYNTAX ERROR");
            System.out.println("=======================================================================");       
        }
        

    }
}
    
