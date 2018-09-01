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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Prakash Tyata
 */
@Entity
@Table(name = "traineddata")
public class TrainedDataset implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private int layer;
    @Column
    private int layernode;
    @Column
    private int inputnode;
    @Column
    private int weight;
    @Column
    private double outputvalue;
    @Column
    private int iteration;
    
    @ManyToOne
    @JoinColumn(name="config_id")
    private NetworkConfiguration objconfig;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getLayernode() {
        return layernode;
    }

    public void setLayernode(int layernode) {
        this.layernode = layernode;
    }

    public int getInputnode() {
        return inputnode;
    }

    public void setInputnode(int inputnode) {
        this.inputnode = inputnode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getOutputvalue() {
        return outputvalue;
    }

    public void setOutputvalue(double outputvalue) {
        this.outputvalue = outputvalue;
    }


    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public NetworkConfiguration getObjconfig() {
        return objconfig;
    }

    public void setObjconfig(NetworkConfiguration objconfig) {
        this.objconfig = objconfig;
    }
    
    
    
    
}
