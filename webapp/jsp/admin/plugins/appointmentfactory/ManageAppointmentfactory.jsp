<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="manageappointmentfactory" scope="session" class="fr.paris.lutece.plugins.appointmentfactory.web.ManageAppointmentfactoryJspBean" />
<% String strContent = manageappointmentfactory.processController ( request , response ); %>
<%= strContent %>

<%@ include file="../../AdminFooter.jsp" %>
