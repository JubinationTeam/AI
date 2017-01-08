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
abstract public class Layer {
    
Layer backWardLayer;
Layer forwardLayer;  
int noOfNodes; 
Double weightVal;
int inputSize;
private List<Neuron> neurons=new ArrayList<Neuron>();
private List<Double> weights = new ArrayList<Double>();
private List<List<Double>> delta = new ArrayList<List<Double>>();

    

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public int getNoOfNodes() {
        return noOfNodes;
    }

    public void setNoOfNodes(int noOfNodes) {
        this.noOfNodes = noOfNodes;
    }

    public Double getWeightVal() {
        return weightVal;
    }

    public void setWeightVal(Double weightVal) {
        this.weightVal = weightVal;
    }

    public int getInputSize() {
        return inputSize;
    }

    public void setInputSize(int inputSize) {
        this.inputSize = inputSize;
    }

    public void setNeurons(List<Neuron> neurons) {
        this.neurons = neurons;
    }

    public List<Double> getWeights() {
        return weights;
    }

    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }
     void printHypothesis(){
         for(Neuron n:this.getNeurons()){
             System.out.print("[");
             for(Double val:n.getValue()){
                 System.out.print(val+",");
         
             }
             System.out.println("]");
         }
     }
     void printError(){
         for(Neuron n:this.getNeurons()){
            System.out.println(n.getError());
         }
     }
void printTarget(){
         for(Neuron n:this.getNeurons()){
            System.out.println(n.getTarget());
         }
     }
void printWeights(){
    System.out.println(weights);
}

void printDeltas(){
for(List<Double> list:delta){
    System.out.println(list);
}
}
    public Layer getBackWardLayer() {
        return backWardLayer;
    }

    public void setBackWardLayer(Layer backWardLayer) {
        this.backWardLayer = backWardLayer;
    }

    public Layer getForwardLayer() {
        return forwardLayer;
    }

    public void setForwardLayer(Layer forwardLayer) {
        this.forwardLayer = forwardLayer;
    }

    public List<List<Double>> getDelta() {
        return delta;
    }

    public void setDelta(List<List<Double>> delta) {
        this.delta = delta;
    }

  public Double findCost(){
  return null;
  }
  
 public void backPropagation(){}
 public void adjustDelta(){}
public void attachLayer(Layer... layer){}
public void insertValues(List<List<Double>> peripheralValues){}

abstract public void activateLayer();
 

}
