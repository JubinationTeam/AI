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
public class HiddenLayer extends Layer{
    
   
    
   
    public HiddenLayer(Layer backWardLayer, int noOfNodes, Double weightVal,int inputSize) {
        this.backWardLayer = backWardLayer;
        backWardLayer.setForwardLayer(this);
           this.noOfNodes=noOfNodes;
       this.weightVal=weightVal;
       this.inputSize=inputSize;
       for(int i=0;i<noOfNodes;i++){
           Neuron n=new Neuron();
            for(int j=0;j<inputSize;j++){
                n.getError().add(0.0);
                
                n.getValue().add(0.0);
            }
            this.getNeurons().add(n);
            this.getWeights().add(weightVal);
       }
       
            this.getWeights().add(weightVal);
            for(int i=0;i<=noOfNodes;i++){
           this.getDelta().add(new ArrayList<Double>());
             for(int j=0;j<inputSize;j++){
                 this.getDelta().get(i).add(0.0);
             }
             
        } 
         
    }
    
    
 public HiddenLayer(Layer backWardLayer, Layer forwardLayer, int noOfNodes, Double weightVal,int inputSize) {
        this.backWardLayer = backWardLayer;
        this.forwardLayer = forwardLayer;
           this.noOfNodes=noOfNodes;
       this.weightVal=weightVal;
       this.inputSize=inputSize;
         
       for(int i=0;i<noOfNodes;i++){
           Neuron n=new Neuron();
            for(int j=0;j<inputSize;j++){
                n.getError().add(0.0);
                n.getValue().add(0.0);
            }
            this.getNeurons().add(n);
            this.getWeights().add(weightVal);
       }
           
            this.getWeights().add(weightVal);
        for(int i=0;i<noOfNodes;i++){
           this.getDelta().add(new ArrayList<Double>());
             for(int j=0;j<inputSize;j++){
                 this.getDelta().get(i).add(0.0);
             }
             
        }     
    }

      public void attachLayer(Layer... layer) {
   this.backWardLayer = layer[0];
        this.forwardLayer = layer[1];
    
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
                    //  System.out.print(this+" z"+i+""+k+": "+output);
                         output=1/(1+Math.pow(Math.E, -output));
                      // System.out.println("a"+i+""+k+": "+output);
                        this.getNeurons().get(i).getValue().set(k,output);
                       
                     }
                      
                      
                 }
                 
           
         forwardLayer.activateLayer();      
             
       }

   public void backPropagation(){
       
       for(int i=0;i<this.getNoOfNodes()&&i<forwardLayer.getNoOfNodes();i++){
           Double error=0.0;
             for(int j=0;j<inputSize;j++){
                        
                      error+=forwardLayer.getNeurons().get(i).getError().get(j)*this.getWeights().get(i+1);
                    
                    
               }
            
           
          for(int k=0;k<inputSize;k++){
                this.getNeurons().get(i).getError().set(k,error*this.getNeurons().get(i).getValue().get(k)*(1-this.getNeurons().get(i).getValue().get(k)));
          }
           
       }
          
//         
         backWardLayer.backPropagation();
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
    

   
   
 
    
}
