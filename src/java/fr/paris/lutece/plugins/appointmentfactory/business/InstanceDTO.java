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

/**
 * DTO for the Instance
 * 
 * @author Laurent Payen
 *
 */
public class InstanceDTO implements Serializable
{

    /**
     * UID
     */
    private static final long serialVersionUID = -4188460866277779459L;

    /**
     * Id of the Instance
     */
    private int _nIdInstance;

    /**
     * Name of the Instance
     */
    private String _strName;

    /**
     * Url of the Instance
     */
    private String _strUrl;

    /**
     * Constructor
     * 
     * @param nIdInstance
     *            the id of the instance
     * @param strName
     *            the name of the instance
     * @param strUrl
     *            the url of the instance
     */
    public InstanceDTO( int nIdInstance, String strName, String strUrl )
    {
        this._nIdInstance = nIdInstance;
        this._strName = strName;
        this._strUrl = strUrl;
    }

    /**
     * Get the id of the instance
     * 
     * @return the id of the instance
     */
    public int getIdInstance( )
    {
        return _nIdInstance;
    }

    /**
     * Set the id of the instace
     * 
     * @param nIdInstance
     *            the id to set
     */
    public void setIdInstance( int nIdInstance )
    {
        this._nIdInstance = nIdInstance;
    }

    /**
     * Get the name of the instance
     * 
     * @return the name of the instance
     */
    public String getName( )
    {
        return _strName;
    }

    /**
     * Set the name of the instance
     * 
     * @param strName
     *            the name to set
     */
    public void setName( String strName )
    {
        this._strName = strName;
    }

    /**
     * Get the url of the instance
     * 
     * @return the url of the instance
     */
    public String getUrl( )
    {
        return _strUrl;
    }

    /**
     * Set the url of the instance
     * 
     * @param strUrl
     *            the url to set
     */
    public void setUrl( String strUrl )
    {
        this._strUrl = strUrl;
    }

}
