/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetworks;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Welcome
 */
public class OutputLayer extends Layer{
     Layer backWardLayer;

    public OutputLayer(int noOfNodes, Double weightVal,int inputSize) {
        this.noOfNodes=noOfNodes;
       this.weightVal=weightVal;
       this.inputSize=inputSize;
        
    }

    public OutputLayer(Layer backWardLayer, int noOfNodes, Double weightVal,int inputSize) {
        this.backWardLayer = backWardLayer;
        backWardLayer.setForwardLayer(this);
         this.noOfNodes=noOfNodes;
       this.weightVal=weightVal;
       this.inputSize=inputSize;
        
    }

    
    
    
     
     
     
   
     public void activateLayer(){
       
             for(int i=0;i<noOfNodes;i++){
               
                 
                 for(int j=0;j<backWardLayer.getNoOfNodes();j++){
                      //linking of neurons
                     
                      this.getNeurons().get(i).setBackwardNeuron(backWardLayer.getNeurons().get(j));
                      backWardLayer.getNeurons().get(j).setForwardNeuron(this.getNeurons().get(i));
                      
                 }
                 
                 
                for(int k=0;k<inputSize;k++){  
                      Double output=0.0;
                      for(int j=0;j<backWardLayer.getNoOfNodes()+1;j++){
                            if(j==0){
                                output+=backWardLayer.getWeights().get(j);
                            }
                            else{
                             output+=backWardLayer.getWeights().get(j)*backWardLayer.getNeurons().get(j-1).getValue().get(k);
                             
                               
                            }
                        }
                         // System.out.print(this+" z"+i+""+k+": "+output);
                         output=1/(1+Math.pow(Math.E, -output));
                       //System.out.println("a"+i+""+k+": "+output);
                        this.getNeurons().get(i).getValue().set(k,output);
                       
                     }
                      
                      
                 }
                 
                 this.backPropagation();
             
       }

     public void backPropagation(){
         
         for(int i=0;i<noOfNodes;i++){
             for(int j=0;j<inputSize;j++){
                 Double error=this.getNeurons().get(i).getTarget().get(j)-this.getNeurons().get(i).getValue().get(j);
                 this.getNeurons().get(i).getError().set(j,error);
             }
         }
         
         backWardLayer.backPropagation();
     }
     
    
     public void insertValues(List<List<Double>> targets){
         
           for(int i=0;i<noOfNodes;i++){
            Neuron n=new Neuron(new ArrayList<Double>(),targets.get(i));
            for(int j=0;j<inputSize;j++){
                n.getError().add(0.0);
                
                n.getValue().add(0.0);
            }
                this.getNeurons().add(n);
        
       }
           
           
               
             
    }

     
    public void adjustDelta() {
          for(int i=0;i<=backWardLayer.getNoOfNodes();i++){
           this.getDelta().add(new ArrayList<Double>());
             for(int j=0;j<inputSize;j++){
                 backWardLayer.getDelta().get(i).set(j,0.0);
             }
             
        } 
        
     for(int i=0;i<backWardLayer.getNoOfNodes()+1;i++){
        
         for(int j=0;j<this.getNoOfNodes();j++){
                if(i==0){
                           for(int k=0;k<inputSize;k++){
                                backWardLayer.getDelta().get(i).set(k, this.getNeurons().get(j).getError().get(k)/inputSize);
                           } 
                }
                else{
                           for(int k=0;k<inputSize;k++){
                                backWardLayer.getDelta().get(i).set(k, this.getNeurons().get(j).getError().get(k)*backWardLayer.getNeurons().get(i-1).getValue().get(k)/inputSize);
                           } 
                    
                }
         }
         
     } 
     
      for(int i=0;i<backWardLayer.getNoOfNodes()+1;i++){
          for(int k=0;k<inputSize;k++){
              
            backWardLayer.getWeights().set(i, backWardLayer.getWeights().get(i)-backWardLayer.getDelta().get(i).get(k));
          }
      }
     
     
     
     backWardLayer.adjustDelta();
    
    }

   
      public Double findCost(){
     
      
     
     
      
   Double temp=0.0;
      for(int i=0;i<getNoOfNodes();i++){
          
          
          for(int j=0;j<inputSize;j++){
                   
           temp+=this.getNeurons().get(i).getTarget().get(j)*Math.log(this.getNeurons().get(i).getValue().get(j))
                      +(1-this.getNeurons().get(i).getTarget().get(j))*Math.log(1-this.getNeurons().get(i).getValue().get(j));
              
          }
        
          
      }
      temp=temp/2;
      
      
      return temp;
      
  }

     
     
     
     
}
