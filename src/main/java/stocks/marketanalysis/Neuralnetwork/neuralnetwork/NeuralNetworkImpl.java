/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.Neuralnetwork.neuralnetwork;
import stocks.marketanalysis.Neuralnetwork.Activation.ActivationFunction;
import stocks.marketanalysis.Neuralnetwork.Activation.Sigmoid;

/**
 *
 * @author RajaramPakur
 */
public class NeuralNetworkImpl implements NeuralNetwork {

    double[][] out;
    double[][] delta;
    double[][][] weight;
    double[][][] prevWeight;
    double learingRate;
    double momentum;
    int numLayer;
    int[] layerSize;

    ActivationFunction activationFunction = new Sigmoid();

    public NeuralNetworkImpl() {
    }
    
    

    public NeuralNetworkImpl(int numLayer, int[] layerSize, double learningRate, double momentum) {

        this.learingRate = learningRate;
        this.momentum = momentum;
        this.numLayer = numLayer;
        this.layerSize = new int[numLayer];

//       sets no of layers and their sizes
        for (int i = 0; i < this.numLayer; i++) {
            this.layerSize[i] = layerSize[i];
        }

//       allocate memory for output of each network
        this.out = new double[this.numLayer][];

        for (int i = 0; i < this.numLayer; i++) {
            out[i] = new double[this.layerSize[i]];
        }

//    allocate memory for weights
        this.delta = new double[this.numLayer][];
        this.weight = new double[this.numLayer][][];
        for (int i = 1; i < this.numLayer; i++) {
            this.weight[i] = new double[this.layerSize[i]][];
            this.delta[i] = new double[this.layerSize[i]];
        }

        for (int i = 1; i < this.numLayer; i++) {
            for (int j = 0; j < this.layerSize[i]; j++) {
                this.weight[i][j] = new double[this.layerSize[i - 1] + 1];
            }
        }

//  allocate memory for previouse weights
        this.prevWeight = new double[this.numLayer][][];
        for (int i = 1; i < this.numLayer; i++) {
            this.prevWeight[i] = new double[this.layerSize[i]][];
        }

        for (int i = 1; i < this.numLayer; i++) {
            for (int j = 0; j < this.layerSize[i]; j++) {
                this.prevWeight[i][j] = new double[this.layerSize[i - 1] + 1];
            }
        }

//     seed and assign random weights
        System.out.println("-------------Initial Random weight assigns-----------\n");
        for (int i = 1; i < this.numLayer; i++) {
            for (int j = 0; j < this.layerSize[i]; j++) {
                for (int k = 0; k < this.layerSize[i - 1] + 1; k++) {
                    this.weight[i][j][k] = Math.random(); // assign the random value
                    System.out.println("["+i+"]["+j+"]["+k+"]["+this.weight[i][j][k]+"]");
                }
            }
        }

//    initialize previous weights to 0 for first iteration
        for (int i = 1; i < this.numLayer; i++) {
            for (int j = 0; j < this.layerSize[i]; j++) {
                for (int k = 0; k < this.layerSize[i - 1] + 1; k++) {
                    this.prevWeight[i][j][k] = (double) 0.0; // assign the random value
                }
            }
        }

    }

    //	backpropogate errors from output
//	layer uptill the first hidden layer
    public void BackPropagation(double[] input, double[] target) {

        double sum;
        
        FeedForward(input);
        /*
        find the delta for the output layer
        Dk <--- Ok * (1-Ok)(Tk - Ok)
         */
        for (int i = 0; i < this.layerSize[this.numLayer - 1]; i++) {
//            System.out.println("\nOutput["+(this.numLayer - 1)+"]["+i +"]"+this.out[this.numLayer - 1][i] + "  layerSize of output: "+this.layerSize[this.numLayer - 1] + " target: "+target[i] );
            
            this.delta[this.numLayer - 1][i] = this.out[this.numLayer - 1][i] * (1 - this.out[this.numLayer - 1][i]) * (target[i] - this.out[this.numLayer - 1][i]);
//            System.out.println("output deltavalue "+this.delta[this.numLayer - 1][i]);
        }
        /*
        find the delta for the hidden layer
        Hk <--- Oh * (1-Oh) summation Wkh * Dk       
        */
        
        for(int i=numLayer-2; i>0; i--){
            for(int j=0; j<layerSize[i]; j++){
                sum = 0.0;
                for(int k=0; k<layerSize[i+1]; k++){
                    sum += delta[i+1][k] * weight[i+1][k][j];
                }
                delta[i][j] = out[i][j] * (1 - out[i][j]) * sum;
            }
        }
        
//        apply momentum (does nothing if momentum = 0

        for(int i=1; i<numLayer; i++){
            for(int j=0; j<layerSize[i]; j++){
                for(int k=0; k<layerSize[i-1]; k++){
                    weight[i][j][k] += momentum* prevWeight[i][j][k];
                }
                weight[i][j][layerSize[i-1]] += momentum * prevWeight[i][j][layerSize[i-1]];
            }
        }
        
//        adjust the weights by finding the correction to the weight 
//        
    System.out.println("Updated Weight:");
        for(int i=1; i<numLayer; i++){
            for(int j=0; j<layerSize[i]; j++){
                for(int k=0; k< layerSize[i-1]; k++){
                    prevWeight[i][j][k] = learingRate * delta[i][j] * out[i-1][k];
                    weight[i][j][k] += prevWeight[i][j][k];
                    System.out.println("["+i+"]["+j+"]["+k+"]["+this.weight[i][j][k]+"]");

                }
                prevWeight[i][j][layerSize[i-1]] = learingRate * delta[i][j];
                weight[i][j][layerSize[i-1]] += prevWeight[i][j][layerSize[i-1]];
                
                
            }
        }
        
    }

    // feed forward one set of input
    public void FeedForward(double[] input) {

        double sum;

//        System.out.println("layersize: "+this.layerSize[0]);
        
//assign content to input layer
        for (int i = 0; i < this.layerSize[0]; i++) {
            out[0][i] = input[i];
            
//            System.out.println("Input values[" +i+"]"+ out[0][i]);
        }

        // assign output(activation) value
        // to each neuron usng sigmoid function
        //for each layer
        
        System.out.println("Ouput value of each neuron :");
        for (int i = 1; i < this.numLayer; i++) {
            for (int j = 0; j < this.layerSize[i]; j++) {
                sum = 0.0;
                for (int k = 0; k < layerSize[i - 1]; k++) {
                    //apply weight to inputs and add to sum

                    sum += this.out[i - 1][k] * weight[i][j][k];
                }

                //apply bais 
                sum += weight[i][j][layerSize[i - 1]];

                //apply sigmoid function
                this.out[i][j] = activationFunction.calculateActivation(sum);
                System.out.println("Output["+i+"]["+j +"]"+this.out[i][j]);
            }
        }

    }

    //	mean square error
    public double MeanSquareError(double[] target) {
        
        double mse = 0;
        
        for(int i=0;i<layerSize[numLayer-1];i++){
		mse +=(target[i]-out[numLayer-1][i])*(target[i]-out[numLayer-1][i]);
	}
        
        return mse/2;
    }

    //	returns i'th output of the net
    public double Out(int i) {
        return out[numLayer-1][i];
    }

}
