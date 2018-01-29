package fr.paris.lutece.plugins.appointmentfactory.service;

import java.util.HashMap;

import fr.paris.lutece.plugins.appointmentfactory.business.InstanceDTO;
import fr.paris.lutece.portal.service.util.AppPropertiesService;

/**
 * Service for the Instances
 * 
 * @author Laurent Payen
 *
 */
public final class InstanceService
{

    // Properties
    private static final String PROPERTY_NB_INSTANCES = "appointmentfactory.nbInstances";
    private static final String PROPERTY_INSTANCE_NAME = "appointmentfactory.instance.name.";
    private static final String PROPERTY_INSTANCE_URL = "appointmentfactory.instance.url.";

    /**
     * Private constructor - this class does not need to be instantiated
     */
    private InstanceService( )
    {
    }

    /**
     * Read the instances in the properties
     * 
     * @return a map of the instances (key = id of the instance)
     */
    public static HashMap<Integer, InstanceDTO> getInstancesFromProperties( )
    {
        HashMap<Integer, InstanceDTO> mapInstances = new HashMap<>( );
        int nbInstances = AppPropertiesService.getPropertyInt( PROPERTY_NB_INSTANCES, 0 );
        for ( int i = 1; i < nbInstances + 1; i++ )
        {
            mapInstances.put(
                    i,
                    new InstanceDTO( i, AppPropertiesService.getProperty( PROPERTY_INSTANCE_NAME + i ), AppPropertiesService.getProperty( PROPERTY_INSTANCE_URL
                            + i ) ) );
        }
        return mapInstances;
    }

}
