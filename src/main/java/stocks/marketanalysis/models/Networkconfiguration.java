/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Prakash Tyata
 */
@Entity
@Table(name = "networkconfigdata")
public class NetworkConfiguration implements Serializable {
    
@Id
@GeneratedValue
private int id;
@Column
private double learningrate;
@Column
private double momentum;
@Column
private int layer;
@Column
private String layersize;
@Column
private double threshold;
@Column
private int iteration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLearningrate() {
        return learningrate;
    }

    public void setLearningrate(double learningrate) {
        this.learningrate = learningrate;
    }

    public double getMomentum() {
        return momentum;
    }

    public void setMomentum(double momentum) {
        this.momentum = momentum;
    }

    

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public String getLayersize() {
        return layersize;
    }

    public void setLayersize(String layersize) {
        this.layersize = layersize;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public void setLayersize(int[] layerSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
