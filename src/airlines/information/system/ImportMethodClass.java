/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airlines.information.system;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author [Shreesu Thapa, Avigya Aryal, Mubson Karki] - C13
 */


//This is a class created for methods that are used in multiple other classes.
public class ImportMethodClass {
    /**
     * @param args the command line arguments
     */
    
    
    //This is  method that returns a hasmap with login data while logging in as staff.
    public Hashtable<String, String> loginData() {  
    try  
    {
        FileReader fileReader = new FileReader(new File(".\\staffInfo.csv"));
        BufferedReader buffReader = new BufferedReader(fileReader);
        
        StringBuffer sb=new StringBuffer();
        String line; 
        
        Hashtable<String,String> dict = new Hashtable<String,String>();
        
        //while loop for appending data to StringBuffer sb.
        while((line=buffReader.readLine())!=null)  
        {
            sb.append(line);  
            sb.append(",");  
        }  

        fileReader.close();
        
        String output = sb.toString(); 
        //Creating a list to add splitted data from the csv file.
        String[] splitted = output.split(",");

        //for loop to store data from list to the hasmap
        for(int i=0; i<splitted.length; i=i+2)
        {
            String a = splitted[i];
            String b = splitted[i+1];

            dict.put(a,b);
        }
            return dict;

    }  
    catch(IOException e) {  
        e.printStackTrace(); 
        return null;
    }
}

    
    /*
        This is a method that returns a sorted arrayList using selection sort algorithm.
        Here, an unsorted array list with datatype ArrayList<String> is passed as parameter.
    */
    public ArrayList<String> selectionSort(ArrayList<String> priceList) {
        
        //outer for loop for getting values in an arraylist
        for (int i = 0; i < priceList.size(); i++) {
            int minValue = Integer.parseInt(priceList.get(i));
            int minIndex = i;
            
            //inner for loop for iterating over those values.
            for (int j = i; j < priceList.size(); j++) {
                int tempValue = Integer.parseInt(priceList.get(j));
                
                if (tempValue < minValue) {
                    minValue = tempValue;
                    minIndex = j;
                }
            }
            
            if (minValue < Integer.parseInt(priceList.get(i))) {
                String temp = priceList.get(i);
                priceList.set(i, priceList.get(minIndex));
                priceList.set(minIndex, temp);
            }
        }
        return priceList;
    }

    
    /*
        This method searches for the input value in a sorted array list using binary search algorithm.
        Here, a sorted array list (priceList) in ArrayList<String> datatype, its starting index (low) in int datatype, and 
        its final index (high) also in int dataype are passed as parameter.
    */
    public static int binarySearch(ArrayList<String> priceList, int low, int high, String valuePrice) {
        
        //Finding the index of mid value
        if (low <= high) {
            int mid = (low + high) / 2;
            
            //the index of mid value is returned if the data in that index matches the search.
            if (priceList.get(mid).equals(valuePrice)) {
                return mid; 
            } 
            
            //This same method is called again to iterate the left side of the array list from mid index.
            else if (valuePrice.compareTo(priceList.get((mid))) < 0) {
                return binarySearch(priceList, low, mid - 1, valuePrice);
            } 
            
            //This same method is called again to iterate the right side of the array list from mid index.
            else {
                return binarySearch(priceList, mid + 1, high, valuePrice);
            }
        }
        //-1 is returned if the search is not in the sorted array list.
        return -1;
    }
}

  