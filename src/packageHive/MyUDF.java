/*
 * MyUDF.java VERSION 1.1
 * 
 * Compiled on 08-OCT-2016
 */
//package declaration

package packageHive;

//importing the package to use collections Arraylist

import java.util.ArrayList;

//import the hive package from hive jar to use UDF class

import org.apache.hadoop.hive.ql.exec.UDF;

//class declaration which inherits the HIVE UDF class
/**
 * This class will create a custom HIVE UDF where evaluate method of UDF class is invoked for each record of HIVE UDF.
 * This program accepts two arguments and concatenates the array elements of field value along with separator which is passed as a first argument.
 * 
 * Dated : 08-OCT-2016.
 * 
 * @author chhaya YADAV
 *
 */

public class MyUDF extends UDF {
	
	
//Implementing the evaluate method of parent UDF class in child class
	
 public String evaluate(String sep, ArrayList<String>strarray) {
	 
//Variable declaration	 

        StringBuffer sBuf;
        
 //if field value in HIVE Table is null       

        if (strarray == null) {

        return null;
        }

//StringBuffer variable instantiation and initialization and appending with first array element.
        
       sBuf = new StringBuffer().append(strarray.get(0));
       
//Concatenating array elements with separator passed as first argument.       

       for (int i=1; i < strarray.size(); i++) {

                 sBuf.append(sep);

                 sBuf.append(strarray.get(i));


       }
        return sBuf.toString();
       
     }
}