package fr.paris.lutece.plugins.appointmentfactory.business;

import java.io.Serializable;
import java.util.HashMap;

/**
 * DTO for the Appointment Factory with the form id to export and the list of the instances to which export the form in json
 * 
 * @author Laurent Payen
 *
 */
public class AppointmentFactoryDTO implements Serializable
{

    /**
     * UID
     */
    private static final long serialVersionUID = 490480757085166770L;

    /**
     * The form id
     */
    private int nIdForm;

    /**
     * The map of the instance (key = id of the instance)
     */
    private HashMap<Integer, InstanceDTO> mapInstances;

    /**
     * Get the form Id
     * 
     * @return the form id
     */
    public int getIdForm( )
    {
        return nIdForm;
    }

    /**
     * Set the form Id
     * 
     * @param nIdForm
     *            the form id to set
     */
    public void setIdForm( int nIdForm )
    {
        this.nIdForm = nIdForm;
    }

    /**
     * Get the map of the instances
     * 
     * @return the map of the instances
     */
    public HashMap<Integer, InstanceDTO> getInstances( )
    {
        return mapInstances;
    }

    /**
     * Set the map of the instances
     * 
     * @param mapInstances
     *            the map to set
     */
    public void setInstances( HashMap<Integer, InstanceDTO> mapInstances )
    {
        this.mapInstances = mapInstances;
    }

}
