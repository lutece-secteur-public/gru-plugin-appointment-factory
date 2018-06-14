/*
 * Copyright (c) 2002-2018, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
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
