/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.Neuralnetwork.neuralnetwork;

/**
 *
 * @author RajaramPakur
 */
public interface NeuralNetwork {
    
   
    public void BackPropagation(double[] input, double[] target);
    
    public void FeedForward(double[] input);
    
    public double MeanSquareError(double[] target);
    
    /**
     *
     * @param i
     * @return
     */
    public double Out(int i);
}
