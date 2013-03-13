CAS - Central Authentication Service
====================================

CAS - Single Sign On Example. CAS server is running at [https://localhost:8443/cas/]. The users are authenticated using sha1 password encoder. The project demonstrates application of cas using two website emulating single sign on.


Remove exisiting certificates
==============================
<pre>keytool -delete -keystore $JAVA_HOME/jre/lib/security/cacerts -alias tomcat</pre>

<pre>keytool -delete -alias tomcat</pre>

<password>


Create certificate
==============================
<pre>keytool -genkey -alias tomcat -keyalg RSA -validity 365</pre>
<pre>
Enter keystore password:changeit
What is your first and last name?
  [Unknown]:  localhost
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
</pre>

Export Certificate
==================
<pre>keytool -export -alias tomcat -file server.crt</pre>


Import into keystore
====================
<pre>keytool -import -file server.crt -keystore $JAVA_HOME/jre/lib/security/cacerts -alias tomcat</pre>


Tomcat Configurations
=====================
1. Go to conf/server.xml 
2. Go to line where it says and uncomment it out where it reads [port="8443"]

How to run
==========
1. cd single-sign-on
2. mvn clean install
3. copy cas.war, customer.war and bank.war to tomcat webapps folder
4. Start the tomcat
5. Access customer website : <a href="http://localhost:8080/customer/">Customer</a>
	This should redirect you to CAS login screen. Once your credentials are entered, you will redirect to customer website. To see the list of user look at [single-sign-on/cas/src/main/resources/database/users.sql]
6. Now access the second bank website <a href="http://localhost:8080/bank/">Bank</a> which should be authenticated previously will be redirected to bank website.










