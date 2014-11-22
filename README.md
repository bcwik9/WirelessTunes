WirelessTunes
=============

Parses email commands sent to a Gmail address to control iTunes via COM interface

Setup: This was designed in Eclipse. Simply click File->Import. Then under 'Java' select 'Import existing project'. Select the root folder which you get here and it should open it up. You also need to download JavaMail, available at http://www.oracle.com/technetwork/java/javamail/index.html and fix the location of the mail.jar file in the project. Once you have it downloaded, right click your project in Eclipse and then click Build Path->Configure Build Path. There should be a mail.jar in there that is missing the path, this is the JavaMail jar. Point it to the mail.jar you just downloaded. You should now be able to run WirelessTunes!
