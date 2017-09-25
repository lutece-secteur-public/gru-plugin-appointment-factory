/*
 * Copyright (c) 2002-2016, Mairie de Paris
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
package fr.paris.lutece.plugins.appointmentfactory.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

import fr.paris.lutece.plugins.appointment.service.FormService;
import fr.paris.lutece.plugins.appointment.service.FormTraderService;
import fr.paris.lutece.plugins.appointment.web.rs.Constants;
import fr.paris.lutece.plugins.appointmentfactory.business.AppointmentFactoryDTO;
import fr.paris.lutece.plugins.appointmentfactory.business.InstanceDTO;
import fr.paris.lutece.plugins.appointmentfactory.service.InstanceService;
import fr.paris.lutece.portal.service.admin.AccessDeniedException;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.portal.util.mvc.admin.MVCAdminJspBean;
import fr.paris.lutece.portal.util.mvc.admin.annotations.Controller;
import fr.paris.lutece.portal.util.mvc.commons.annotations.Action;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.portal.util.mvc.utils.MVCUtils;
import fr.paris.lutece.portal.web.util.LocalizedPaginator;
import fr.paris.lutece.util.html.Paginator;
import fr.paris.lutece.util.url.UrlItem;
import net.sf.json.JSONObject;

/**
 * ManageAppointmentfactory JSP Bean abstract class for JSP Bean
 */
@Controller( controllerJsp = "ManageAppointmentfactory.jsp", controllerPath = "jsp/admin/plugins/appointmentfactory/", right = ManageAppointmentfactoryJspBean.RIGHT_MANAGEAPPOINTMENTFACTORY )
public class ManageAppointmentfactoryJspBean extends MVCAdminJspBean
{

    /**
     * UID
     */
    private static final long serialVersionUID = -9044694273971530510L;

    // Rights
    public static final String RIGHT_MANAGEAPPOINTMENTFACTORY = "APPOINTMENTFACTORY_MANAGEMENT";

    // Templates
    private static final String TEMPLATE_MANAGE_APPOINTMENT_FACTORY = "/admin/plugins/appointmentfactory/manage_appointment_factory.html";

    // Actions
    private static final String ACTION_EXPORT_FORM = "exportForm";

    // Session keys
    private static final String SESSION_CURRENT_PAGE_INDEX = "appointmentfactory.session.currentPageIndex";
    private static final String SESSION_ITEMS_PER_PAGE = "appointmentfactory.session.itemsPerPage";
    private static final String SESSION_ATTRIBUTE_APPOINTMENT_FACTORY = "appointmentfactory.session";

    // Properties for page titles
    private static final String PROPERTY_PAGE_TITLE_MANAGE_APPOINTMENT_FACTORY = "appointmentfactory.manage.appointmentfactory.title";

    // Properties
    private static final String PROPERTY_DEFAULT_LIST_SERVERS_PER_PAGE = "appointmentfactory.listServers.itemsPerPage";

    // Views
    private static final String VIEW_MANAGE_APPOINTMENT_FACTORY = "manageAppointmentfactory";

    // Errors
    private static final String ERROR_MESSAGE_NO_INSTANCE_CHECKED = "appointmentfactory.validation.export.noInstanceChecked";

    // Infos
    private static final String INFO_MESSAGE_FORM_EXPORT_OK = "appointmentfactory.message.form.export.ok";

    // Markers
    private static final String MARK_LIST_FORMS = "listForms";
    private static final String MARK_LIST_INSTANCES = "listInstances";
    private static final String MARK_NB_ITEMS_PER_PAGE = "nb_items_per_page";
    private static final String MARK_PAGINATOR = "paginator";
    private static final String MARK_APPOINTMENT_FACTORY = "appointmentfactory";

    // Parameters
    private static final String PARAMETER_ID_INSTANCES = "inst";
    private static final String PARAMETER_ID_FORM = "idForm";
    private static final String PARAMETER_PAGE_INDEX = "page_index";

    // Constants
    private static final String DEFAULT_CURRENT_PAGE = "1";

    // Session variable to store working values
    private int _nDefaultItemsPerPage;

    private static final String JSP_MANAGE_APPOINTMENT_FACTORY = "jsp/admin/plugins/appointmentfactory/ManageAppointmentfactory.jsp";

    /**
     * Default constructor
     */
    public ManageAppointmentfactoryJspBean( )
    {
        _nDefaultItemsPerPage = AppPropertiesService.getPropertyInt( PROPERTY_DEFAULT_LIST_SERVERS_PER_PAGE, 10 );
    }

    /**
     * Get the page to export form to instances
     * 
     * @param request
     *            the request
     * @return The HTML content to display
     */
    @View( value = VIEW_MANAGE_APPOINTMENT_FACTORY, defaultView = true )
    public String getManageAppointmentFactory( HttpServletRequest request )
    {
        String strCurrentPageIndex = Paginator.getPageIndex( request, Paginator.PARAMETER_PAGE_INDEX,
                (String) request.getSession( ).getAttribute( SESSION_CURRENT_PAGE_INDEX ) );
        if ( StringUtils.isEmpty( strCurrentPageIndex ) )
        {
            strCurrentPageIndex = DEFAULT_CURRENT_PAGE;
        }
        AppointmentFactoryDTO appointmentFactoryDTO = (AppointmentFactoryDTO) request.getSession( ).getAttribute( SESSION_ATTRIBUTE_APPOINTMENT_FACTORY );
        if ( appointmentFactoryDTO == null )
        {
            appointmentFactoryDTO = new AppointmentFactoryDTO( );
        }
        request.getSession( ).setAttribute( SESSION_CURRENT_PAGE_INDEX, strCurrentPageIndex );
        int nItemsPerPage = Paginator.getItemsPerPage( request, Paginator.PARAMETER_ITEMS_PER_PAGE,
                getIntSessionAttribute( request.getSession( ), SESSION_ITEMS_PER_PAGE ), _nDefaultItemsPerPage );
        request.getSession( ).setAttribute( SESSION_ITEMS_PER_PAGE, nItemsPerPage );
        UrlItem url = new UrlItem( JSP_MANAGE_APPOINTMENT_FACTORY );
        url.addParameter( MVCUtils.PARAMETER_VIEW, VIEW_MANAGE_APPOINTMENT_FACTORY );
        String strUrl = url.getUrl( );
        HashMap<Integer, InstanceDTO> mapInstances = InstanceService.getInstancesFromProperties( );
        appointmentFactoryDTO.setInstances( mapInstances );
        request.getSession( ).setAttribute( SESSION_ATTRIBUTE_APPOINTMENT_FACTORY, appointmentFactoryDTO );
        LocalizedPaginator<InstanceDTO> paginator = new LocalizedPaginator<InstanceDTO>( new ArrayList<>( mapInstances.values( ) ), nItemsPerPage, strUrl,
                PARAMETER_PAGE_INDEX, strCurrentPageIndex, getLocale( ) );
        Map<String, Object> model = getModel( );
        model.put( MARK_LIST_FORMS, FormService.findAllInReferenceList( ) );
        model.put( MARK_NB_ITEMS_PER_PAGE, Integer.toString( nItemsPerPage ) );
        model.put( MARK_PAGINATOR, paginator );
        model.put( MARK_LIST_INSTANCES, paginator.getPageItems( ) );
        model.put( MARK_APPOINTMENT_FACTORY, appointmentFactoryDTO );
        return getPage( PROPERTY_PAGE_TITLE_MANAGE_APPOINTMENT_FACTORY, TEMPLATE_MANAGE_APPOINTMENT_FACTORY, model );
    }

    /**
     * Export the form selected to the instances selected in json format
     * 
     * @param request
     * @return to the manage page
     * @throws AccessDeniedException
     */
    @Action( ACTION_EXPORT_FORM )
    public String doExportForm( HttpServletRequest request ) throws AccessDeniedException
    {
        AppointmentFactoryDTO appointmentFactoryDTO = (AppointmentFactoryDTO) request.getSession( ).getAttribute( SESSION_ATTRIBUTE_APPOINTMENT_FACTORY );
        if ( appointmentFactoryDTO == null )
        {
            appointmentFactoryDTO = new AppointmentFactoryDTO( );
        }
        String strIdForm = request.getParameter( PARAMETER_ID_FORM );
        if ( StringUtils.isNotEmpty( strIdForm ) )
        {
            appointmentFactoryDTO.setIdForm( Integer.parseInt( strIdForm ) );
        }
        request.getSession( ).setAttribute( SESSION_ATTRIBUTE_APPOINTMENT_FACTORY, appointmentFactoryDTO );
        String [ ] tabIdInstances = request.getParameterValues( PARAMETER_ID_INSTANCES );
        if ( tabIdInstances == null || tabIdInstances.length == 0 )
        {
            addError( ERROR_MESSAGE_NO_INSTANCE_CHECKED, getLocale( ) );
            return redirectView( request, VIEW_MANAGE_APPOINTMENT_FACTORY );
        }
        if ( callRestService( tabIdInstances, appointmentFactoryDTO.getInstances( ), FormTraderService.exportFormToJson( appointmentFactoryDTO.getIdForm( ) ) ) )
        {
            addInfo( INFO_MESSAGE_FORM_EXPORT_OK, getLocale( ) );
        }
        return redirectView( request, VIEW_MANAGE_APPOINTMENT_FACTORY );
    }

    /**
     * Call the rest service that will import the json file to the instances selected
     * 
     * @param tabIdInstances
     *            the instances selected
     * @param mapInstances
     *            all the instances in the properties
     * @param jsonToExport
     *            the json to export
     * @return true if all the calls are ok
     */
    private boolean callRestService( String [ ] tabIdInstances, HashMap<Integer, InstanceDTO> mapInstances, JSONObject jsonToExport )
    {
        boolean bCallOk = Boolean.TRUE;
        WebTarget target;
        int nIdInstance;
        InstanceDTO instanceDTO;
        String url;
        Response res;

        Client client = ClientBuilder.newClient( );
        StringBuilder stbPath = new StringBuilder( ).append( Constants.BASE_REST_PATH ).append( Constants.PLUGIN_PATH ).append( Constants.FORM_PATH )
                .append( Constants.IMPORT_PATH );
        String strPath = stbPath.toString( );
        for ( String strIdInstance : tabIdInstances )
        {
            nIdInstance = Integer.parseInt( strIdInstance );
            if ( mapInstances.containsKey( nIdInstance ) )
            {
                instanceDTO = mapInstances.get( nIdInstance );
                url = instanceDTO.getUrl( );
                target = client.target( url ).path( strPath );
                res = target.request( MediaType.APPLICATION_JSON ).post( Entity.json( jsonToExport ) );
                if ( res.getStatus( ) != Status.OK.getStatusCode( ) )
                {
                    addError( "Error for instance " + instanceDTO.getName( ) + "; Response status = " + res.getStatus( ) );
                    bCallOk = Boolean.FALSE;
                }
            }
        }
        return bCallOk;
    }

    /**
     * Get an integer attribute from the session
     * 
     * @param session
     *            The session
     * @param strSessionKey
     *            The session key of the item
     * @return The value of the attribute, or 0 if the key is not associated with any value
     */
    private int getIntSessionAttribute( HttpSession session, String strSessionKey )
    {
        Integer nAttr = (Integer) session.getAttribute( strSessionKey );
        if ( nAttr != null )
        {
            return nAttr;
        }
        return 0;
    }

}
