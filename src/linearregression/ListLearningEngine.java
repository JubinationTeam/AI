/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearregression;

import com.sun.corba.se.impl.orb.NormalParserAction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Welcome
 */
public class ListLearningEngine {
    
  private ListLearningObject learnData;
    private Normalization norm;
    private Double costError;
    private Double costDifferenceAccept;
    private int sizeData;
    private int sizeInput;
  
    public ListLearningEngine(int sizeInput,int sizeData,Double costError,Double costDifferenceAccept,Double learningRate,Double regularizedValue) {
        this.sizeData=sizeData;
        this.sizeInput=sizeInput;
        learnData=new ListLearningObject();
     learnData.setLearningRate(learningRate);
       norm=new Normalization();
         this.costDifferenceAccept=costDifferenceAccept;
         learnData.setRegularizingValue(regularizedValue);
         this.costError=costError;
         for(int i=0;i<=sizeInput;i++){
         learnData.getTheta().add(0.0);
     }
    }
 public ListLearningEngine(List<Double> theta,int sizeInput,int sizeData,Double costError,Double costDifferenceAccept,Double learningRate,Double regularizedValue) {
       this.sizeData=sizeData;  
        this.sizeInput=sizeInput;
     learnData=new ListLearningObject(theta);
     learnData.setLearningRate(learningRate);
        this.costDifferenceAccept=costDifferenceAccept;
         this.costError=costError;
       norm=new Normalization();
       
         learnData.setRegularizingValue(regularizedValue);
       
    }
    

 
 public Long learnData(DataObject data){
    Double tempCost=0.0;
     
  //normalization
  norm.normalizeTargetByDivision(data.getTarget());
  norm.normalizeInputsByDivision(data.getInputs());
  
      System.out.println("\nCost before learning "+findCost(data));
       
    Long count=0l;
    do{
        tempCost=findCost(data);
      learnAStep(data);
      learnData.setCost(findCost(data));
      count++;
      
      if(count%100000==0){
        System.out.println("cost= "+learnData.getCost());
      }
      
    }while(learnData.getCost()>=costError&&(tempCost-learnData.getCost()!=costDifferenceAccept));
        if(tempCost<learnData.getCost()){
            System.err.println("Manipulation might be wrong, please change the learning rate or normalization factor for fine tuning");
    
        }
       System.out.println("Cost after learning "+findCost(data));
        
        
//   System.out.println("theta before normalization : "+learnData.getTheta());
 
       norm.denormalizeThetaByDivision(learnData.getTheta());
    System.out.println("theta values : "+learnData.getTheta());
    
    
    return count;
  }
  

  Double findCost(DataObject data){
     
      
     
     
      learnData.setHypothesis(new ArrayList<Double>());
     
      for(int i=0;i<sizeData;i++){
          
         Double temp=0.0;
          for(int j=0;j<=sizeInput;j++){
                    if(j==0){
                        temp=learnData.getTheta().get(j);
                        
                    }
                    else{

                        temp=temp+learnData.getTheta().get(j)*data.getInputs().get(j-1).get(i);

                              temp+=learnData.getRegularizingValue()*Math.pow(learnData.getTheta().get(j),2);
              
}
                    
              
          }
          learnData.getHypothesis().add(temp);
          learnData.setCost(learnData.getCost()+Math.pow(learnData.getHypothesis().get(i)-data.getTarget().get(i),2));
          
          
      }
      
      learnData.setCost(learnData.getCost()/(2*sizeData));
     
      return learnData.getCost();
      
  }

  void learnAStep(DataObject data){
       
    
         Double temp=0.0;
         Double temp2=0.0;
         
      for(int k=0;k<=sizeInput;k++){

        for(int i=0;i<sizeData;i++){
            for(int j=0;j<=sizeInput;j++){

               if(j==0){
                temp=learnData.getTheta().get(j);
                }
                else {
                    temp=temp+learnData.getTheta().get(j)*data.getInputs().get(j-1).get(i);
                    temp+=learnData.getRegularizingValue()*learnData.getTheta().get(j);
              
                }

              }
            if(k==0){
            temp2=temp2+temp-data.getTarget().get(i);  
            }
            else{
                temp2=temp2+(temp-data.getTarget().get(i))*data.getInputs().get(k-1).get(i);    
            }
        }
       
            learnData.getTheta().set(k,learnData.getTheta().get(k)-learnData.getLearningRate()*temp2/sizeData);
   
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
              output=output+learnData.getTheta().get(i);
          }
          else{
           output=output+learnData.getTheta().get(i)*input.get(i-1);
          }
      }
      return output;
  }
  
}
