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
public class Neuron {
    
    List<Double> value;
    List<Double> error;
    List<Double> target;
    Neuron forwardNeuron;
    Neuron backwardNeuron;

    public Neuron() {
        value=new ArrayList<Double>();
        target=new ArrayList<Double>();
        error=new ArrayList<Double>();
    }


   

    public Neuron(List<Double> value) {
        this.value = value;
        target=new ArrayList<Double>();
        error=new ArrayList<Double>();
    }
    public Neuron(List<Double> value,List<Double> target) {
        this.value = value;
        this.target=target;
        error=new ArrayList<Double>();
    }

    public List<Double> getValue() {
        return value;
    }

    public void setValue(List<Double> value) {
        this.value = value;
    }

    public List<Double> getTarget() {
        return target;
    }

    public void setTarget(List<Double> target) {
        this.target = target;
    }

    public List<Double> getError() {
        return error;
    }

    public void setError(List<Double> error) {
        this.error = error;
    }

  

    public Neuron getForwardNeuron() {
        return forwardNeuron;
    }

    public void setForwardNeuron(Neuron forwardNeuron) {
        this.forwardNeuron = forwardNeuron;
    }

    public Neuron getBackwardNeuron() {
        return backwardNeuron;
    }

    public void setBackwardNeuron(Neuron backwardNeuron) {
        this.backwardNeuron = backwardNeuron;
    }

   

   
    
    
    
}
