/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logisticregression.DataObject;
import logisticregression.ListLearningEngine;
import logisticregression.ReadFiles;

/**
 *
 * @author Welcome
 */
public class OperateLogisticRegression implements Runnable{
 private static final Double THETA_LR=0.000001;
    private static final Double COST_ERROR_LR=0.0;
     private static final Double LEARNING_RATE_LR=0.0001;
      private static final Double COST_DIFFERENCE_ACCEPT_LR=0.0;
    
      private static final Double REGULARIZED_VALUE=0.0;
    @Override
    public void run() {
        try{
            
         
      System.out.println("Pattern prediction using logistic regression\n");
          
        DataObject data=new ReadFiles().readTrainingFile();
      
        List<Double> theta = new ArrayList<Double>();
        
        for(int i=0;i<=data.getInputs().size();i++){
            theta.add(THETA_LR);
        }
        
        ListLearningEngine engine =new ListLearningEngine(theta,data.getInputs().size(),data.getInputs().get(0).size(),COST_ERROR_LR,COST_DIFFERENCE_ACCEPT_LR,LEARNING_RATE_LR,REGULARIZED_VALUE);
        
        System.out.println("Inputs");
       
            System.out.println(data.getInputParameters());
        
                for(List<Double> ld:data.getInputs()){
                System.out.println(ld);
                }
        System.out.println("Targets");
            System.out.println(data.getTargetParameter());
                System.out.println(data.getTarget());
        
     
            
                
                
       System.out.println("Learnt after "+engine.learnData(data)+" iterations");

       
       
       
     
        boolean repeatPrediction=true;
        
       while(repeatPrediction){
        List<Double> input = new ArrayList<Double>();   
      for(int j=0;j<data.getInputs().size();j++){
           Scanner sc =new Scanner(System.in);
            System.out.print("\nparameter "+data.getInputParameters().get(j)+": ");
            if(sc.hasNextDouble()){
            input.add(sc.nextDouble());
            }
      }
          
         System.out.print("Predicting values ("+data.getTargetParameter()+"): "+ engine.predict(input, input.size())*100+"% probability");
         if(engine.predict(input, input.size())>=0.50){
             System.out.println("\tTRUE");
         } 
         else{
             System.out.println("\tFALSE");
         }
         System.out.println("Another prediction?(y/n) ");
           String s=new Scanner(System.in).next();
           if(s.equals("y")){
               repeatPrediction=true;
           }
           else{
               repeatPrediction=false;
           }
           
       }
           
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
   
    
}
