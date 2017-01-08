/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetworks;

import logisticregression.*;
import linearregression.*;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Welcome
 */
public class ReadFiles {
    BufferedReader br;
    DataObject data;

    public ReadFiles() {
        data=new DataObject();
    }
    
   public  DataObject readTrainingFile() 
    {
        try
        {
          String sCurrentLine,directory,filename;
          Matcher m1,m2;
          boolean readyFile=false;
          do{
            
            System.out.println("\n Enter the diectory path (e.g. E:\\): ");
            directory=new Scanner(System.in).next();
            m1 =  Pattern.compile("([\\w]+:)\\\\((([\\w]+)\\\\)?)").matcher(directory);
            
            System.out.println("\n Enter the file name(e.g. cost.txt): ");
            filename=new Scanner(System.in).next();
            m2 = Pattern.compile("[\\w]+\\.[\\w]+").matcher(filename);
            
            
            
//              System.out.println("\n\n");
//            while(m1.find()){
//                System.out.println(m1.group()+" m1 group");
//                
//            }
//              System.out.println(m1.matches()+" m1");
//            while(m2.find()){
//                System.out.println(m2.group()+" m2 group");
//                
//            }
//              System.out.println(m2.matches()+" m2");
            
              
              
            if(m1.matches()&&m2.matches()){
                
                 try{
                  System.out.println("\nValid Path structure. Trying to fetch file..");
                   br = new BufferedReader(new FileReader(directory+filename));
                   readyFile=true;
                 }
                 catch(FileNotFoundException e){
                        readyFile=false;
                        System.err.println("Could not find path and file name");;
                 }
          }else{
                System.out.println("Invalide File path structure");
            }
            
          }while(!readyFile);
          
          
         
            boolean readFirstLine=false;
            int out=0,in=0;
                     
                        if((sCurrentLine = br.readLine()) != null){
                          
                            
                             if(sCurrentLine!=null&&sCurrentLine!=""){
                                String[] sVal=sCurrentLine.split("\\s+"); 
                                 for(int i=0;i<sVal.length;i++){
                                     if(sVal[i].startsWith("i")){
                                        data.getInputParameters().add(sVal[i]);
                                        in++;
                                     }
                                     else if(sVal[i].startsWith("o")){
                                         data.getTargetParameters().add(sVal[i]);
                                         out++;
                                     }
                                }
                             }
                        }
            
			while ((sCurrentLine = br.readLine()) != null) {
                            if(sCurrentLine!=null&&sCurrentLine!=""){
				
                            String[] sVal=sCurrentLine.split("\\s+");
                                
                                if(!readFirstLine){
                                for(int i=0;i<sVal.length;i++){
                                    sVal[i].replaceAll("\\D", "");
                                     if(i<in){
                                     data.getInputs().add(new ArrayList<Double>());
                                     }
                                     else{
                                         data.getTargets().add(new ArrayList<Double>());
                                     }
                                }
                                readFirstLine=true;
                                }
                                
                                for(int i=0;i<in;i++){
                                    
                                         data.getInputs().get(i).add(Double.parseDouble(sVal[i]));
                                }  
                                 for(int i=in;i<out+in;i++){   
                                        data.getTargets().get(i-in).add(Double.parseDouble(sVal[i]));
                                   
                                    
                                    
                                    }
                                
                            }
			}
                       
                    br.close();
                    if(data.getInputs().size()==0||data.getTargets().size()==0){
                        throw new IndexOutOfBoundsException();
                    }
        return data;
        } 
        catch (IOException|NumberFormatException|IndexOutOfBoundsException e) 
        {
            e.printStackTrace();
            System.err.println("Corrupt file data. Please try again after placing a valid training set");
            System.exit(0);
        return null;
        }
       
     
    }
}

