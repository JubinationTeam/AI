/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logisticregression;

import logisticregression.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Welcome
 */
public class ListLearningEngine {
    
  private ListLearningObject learnData;
   private Double costError;
    private Double costDifferenceAccept;
    private int sizeData;
    private int sizeInput;
  
    public ListLearningEngine(int sizeInput,int sizeData,Double costError,Double costDifferenceAccept,Double learningRate,Double regularizedValue) {
        this.sizeData=sizeData;
        this.sizeInput=sizeInput;
        learnData=new ListLearningObject();
     learnData.setLearningRate(learningRate);
        this.costDifferenceAccept=costDifferenceAccept;
         this.costError=costError;
         
         learnData.setRegularizingValue(regularizedValue);
         for(int i=0;i<=sizeInput;i++){
         learnData.getTheta().add(0.0);
     }
    }
 public ListLearningEngine(List<Double> theta,int sizeInput,int sizeData,Double costError,Double costDifferenceAccept,Double learningRate,Double regularizedValue) {
       this.sizeData=sizeData;  
        this.sizeInput=sizeInput;
     learnData=new ListLearningObject(theta);
     learnData.setLearningRate(learningRate);
     
         learnData.setRegularizingValue(regularizedValue);
        this.costDifferenceAccept=costDifferenceAccept;
         this.costError=costError;
      
    }
    

 
 public Long learnData(DataObject data){
    Double tempCost=0.0;
     
 
      System.out.println("\nCost before learning "+findCost(data));
       
    Long count=0l;
    do{
        tempCost=findCost(data);
      learnAStep(data);
      learnData.setCost(findCost(data));
      count++;
      
      if(count%100000==0){
        System.out.println("cost= "+tempCost+", "+learnData.getCost());
          System.out.println(learnData.getTheta());
      }
//      if(tempCost<learnData.getCost()){
//          
//          break;
//      }
      
    }while(learnData.getCost()>=costError&&(tempCost-learnData.getCost()!=costDifferenceAccept));
       
     if(tempCost<learnData.getCost()){
            System.err.println("Manipulation might be wrong, please change the learning rate or normalization factor for fine tuning");
    
        }
       System.out.println("Cost after learning "+findCost(data));
        
        
//   System.out.println("theta before normalization : "+learnData.getTheta());
 
     //  norm.denormalizeThetaByDivision(learnData.getTheta());
    System.out.println("theta values : "+learnData.getTheta());
    
    
    return count;
  }
  

  public Double findCost(DataObject data){
     
      
     
     
      learnData.setHypothesis(new ArrayList<Double>());
     learnData.setCost(0.0);
      for(int i=0;i<sizeData;i++){
          
         Double temp=0.0;
          for(int j=0;j<=sizeInput;j++){
                    if(j==0){
                        temp+=learnData.getTheta().get(j);
                  
                    }
                    else{

                        temp+=learnData.getTheta().get(j)*data.getInputs().get(j-1).get(i);
  temp+=learnData.getRegularizingValue()*Math.pow(learnData.getTheta().get(j),2)*0.5;
              

                        }
                    
              
          }
          temp=1/(1+Math.pow(Math.E, -temp));
          learnData.getHypothesis().add(temp);
          learnData.setCost(learnData.getCost()+data.getTarget().get(i)*Math.log(temp)+(1-data.getTarget().get(i))*(Math.log(1-temp)));
          
          
      }
      
      learnData.setCost(-learnData.getCost()/sizeData);
     
      return learnData.getCost();
      
  }

  public void learnAStep(DataObject data){
       
    
         Double temp=0.0;
         Double temp2=0.0;
         
      for(int k=0;k<=sizeInput;k++){

        for(int i=0;i<sizeData;i++){
            for(int j=0;j<=sizeInput;j++){

               if(j==0){
                   
                 temp+=learnData.getTheta().get(j);
                }
                else {
                   
                   temp+=learnData.getTheta().get(j)*data.getInputs().get(j-1).get(i);
                     temp+=learnData.getRegularizingValue()*learnData.getTheta().get(j);
               
                }

              }
            if(k==0){
            temp2=temp2+1/(1+Math.pow(Math.E, -temp))-data.getTarget().get(i);  
            }
            else{
                temp2=temp2+(1/(1+Math.pow(Math.E, -temp))-data.getTarget().get(i))*data.getInputs().get(k-1).get(i);    
            }
        }
       
            learnData.getTheta().set(k,learnData.getTheta().get(k)-learnData.getLearningRate()*temp2);
      
      }
      
//      
//      System.out.println("After learning a step");
//      int count=0;
//     for(Double d:learnData.getTheta()){
//         System.out.println("theta "+(count++)+": "+d+" ");
//     }
//     
//      System.out.println("\n");
//      count=0;
//      for(Double d:learnData.getTheta()){
//         System.out.println("value "+(count++)+": "+Math.round(d)+" ");
//     }
//         System.out.println("\n");
      
      
  }
  

  public Double predict(List<Double> input,Integer sizeInput){
      Double output=0.0;
      for(int i=0;i<=sizeInput;i++){
          if(i==0){
              output+=learnData.getTheta().get(i);
          }
          else{
           output+=learnData.getTheta().get(i)*input.get(i-1);
           
          }
      }
      output=1/(1+Math.pow(Math.E, -output));
      return output;
  }
  
}
