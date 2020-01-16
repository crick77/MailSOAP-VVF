# MailSOAP-VVF
SOAP services for mail delivery (simulated for university SOSE project)

This is the support application for mail delivery used by *Bacheca* project.

The application is the result of a university project for SOSE (Service-oriented Software Engineering) course at University of L'Aquila.

The mail delivery is a SOAP service that actually simulate the process by priting something to the console and then waiting a random time ranging from 3 to 13 seconds.
The method will then return the state of the job (as a boolean). The asynchronous nature of the SOAP service will give control back to the caller and then with an AsyncHandler will handle the response.

The project uses Apache CXF as webservice provider.

You will need Tomcat 8.5+ with Java 1.8.

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
