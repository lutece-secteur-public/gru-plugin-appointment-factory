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
