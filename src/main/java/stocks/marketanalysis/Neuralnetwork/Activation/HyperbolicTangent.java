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
public class HyperbolicTangent implements ActivationFunction{

    public double calculateActivation(double input) {
    
        double dividend = Math.exp(input) - Math.exp(-input);
	double divisor = Math.exp(input) + Math.exp(-input);
	return dividend/divisor;
    }

    public double calculateDirivative(double nOutput) {
    
        return 1 - Math.pow(nOutput, 2);
    }
    
}
