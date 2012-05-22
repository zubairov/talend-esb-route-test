Unit testing sample for Talend ESB Route
========================

mvn install:install-file -DgroupId=org.talend.camel -DartifactId=FTPTest -Dversion=1.0.0 -Dfile=FTPTest_0.1 -Dpackaging=jar -DgeneratePom=true

mvn install:install-file -DgroupId=org.talend.camel -DartifactId=systemRoutines -Dversion=1.0.0 -Dfile=systemRoutines.jar -Dpackaging=jar -DgeneratePom=true

mvn install:install-file -DgroupId=org.talend.camel -DartifactId=userRoutines -Dversion=1.0.0 -Dfile=userRoutines.jar -Dpackaging=jar -DgeneratePom=true
