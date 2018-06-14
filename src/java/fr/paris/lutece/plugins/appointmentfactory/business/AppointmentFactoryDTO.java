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
