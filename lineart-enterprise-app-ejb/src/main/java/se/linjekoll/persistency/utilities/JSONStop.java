/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.utilities;

import java.io.Serializable;

/**
 *
 * @author jesper
 */

public class JSONStop implements Serializable{
    private String name;
    private Integer id;
    private Integer time;
    private Integer next_id;
    private Integer previous_id;
    private String sid;
    
}
