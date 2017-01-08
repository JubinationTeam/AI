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
public class InputLayer extends Layer{
    
    

    public InputLayer(int noOfNodes, Double weightVal,int inputSize) {
        this.noOfNodes=noOfNodes;
       this.weightVal=weightVal;
       this.inputSize=inputSize;
       for(int i=0;i<=noOfNodes;i++){
           this.getDelta().add(new ArrayList<Double>());
             for(int j=0;j<inputSize;j++){
                 this.getDelta().get(i).add(0.0);
             }
             
        }
    }

  
   public void attachLayer(Layer... layer) {
          this.setForwardLayer(layer[0]);
    }
    
    
   
 
    public void activateLayer(){
        
         forwardLayer.activateLayer();
       }

    public void insertValues(List<List<Double>> inputs) {
        
        for(int i=0;i<noOfNodes;i++){
                this.getNeurons().add(new Neuron(inputs.get(i)));
       
            this.getWeights().add(weightVal);
       }
           
            this.getWeights().add(weightVal);
    }

  

   

    
    
 
    
}
