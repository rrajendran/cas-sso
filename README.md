cas
===

CAS - Single Sign On Example


Remove exisiting certificates
==============================
keytool -delete -keystore $JAVA_HOME/jre/lib/security/cacerts -alias tomcat

<password>


Create certificate
==============================
keytool -genkey -alias tomcat -keyalg RSA -validity 365

Enter keystore password:changeit
What is your first and last name?
  [Unknown]:  Ramesh Rajendran
What is the name of your organizational unit?
  [Unknown]:  Customers
What is the name of your organization?
  [Unknown]:  Capella Technologies Ltd.,
What is the name of your City or Locality?
  [Unknown]:  Manchester
What is the name of your State or Province?
  [Unknown]:  Lancs
What is the two-letter country code for this unit?
  [Unknown]:  UK
Is CN=Ramesh Rajendran, OU=Customers, O="Capella Technologies Ltd.,", L=Manchester, ST=Lancs, C=UK correct?
  [no]:  yes

Enter key password for <tomcat>
	(RETURN if same as keystore password):changeit
Re-enter new password: changeit


Export Certificate
==================
keytool -export -alias tomcat -file server.crt


Import into keystore
====================
keytool -import -file server.crt -keystore $JAVA_HOME/jre/lib/security/cacerts -alias tomcat


Tomcat Configurations
=====================
1. Go to conf/server.xml 
2. Go to line where it says and uncomment it out

 <Connector 
	SSLCertificateFile="<path_to_certificate>/server.crt" 
	SSLEnabled="true" 
	SSLProtocol="TLSv1" 
	SSLVerifyClient="optional" 
	maxThreads="200" 
	port="8443" 
	protocol="HTTP/1.1" scheme="https" secure="true"/>









