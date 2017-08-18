
--
-- Data for table core_admin_right
--
DELETE FROM core_admin_right WHERE id_right = 'APPOINTMENTFACTORY_MANAGEMENT';
INSERT INTO core_admin_right (id_right,name,level_right,admin_url,description,is_updatable,plugin_name,id_feature_group,icon_url,documentation_url, id_order ) VALUES 
('APPOINTMENTFACTORY_MANAGEMENT','appointmentfactory.adminFeature.ManageAppointmentfactory.name',1,'jsp/admin/plugins/appointmentfactory/ManageAppointmentfactory.jsp','appointmentfactory.adminFeature.ManageAppointmentfactory.description',0,'appointment','APPLICATIONS',NULL,NULL,4);


--
-- Data for table core_user_right
--
DELETE FROM core_user_right WHERE id_right = 'APPOINTMENTFACTORY_MANAGEMENT';
INSERT INTO core_user_right (id_right,id_user) VALUES ('APPOINTMENTFACTORY_MANAGEMENT',1);

