/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.Neuralnetwork.Activation;

/**
 *
 * @author RajaramPakur
 */
public class Sigmoid implements ActivationFunction{

    public double calculateActivation(double input) {
    
        double divisor = 1.0 + Math.exp(-input);
	return 1/divisor;   
    }

    public double calculateDirivative(double nOutput) {
    
        return (1-nOutput)*nOutput;
    }
    
}
