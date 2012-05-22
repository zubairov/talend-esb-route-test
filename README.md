Unit testing sample for Talend ESB Route
========================

Before you would be able to build this project you would need to deploy the utility JAR files into your local mavne repository.
To do that execute following to deploy system routines:

    mvn install:install-file -DgroupId=org.talend.camel -DartifactId=systemRoutines -Dversion=1.0.0 -Dfile=./src/ext/systemRoutines.jar -Dpackaging=jar -DgeneratePom=true

And this to deploy user routines

    mvn install:install-file -DgroupId=org.talend.camel -DartifactId=userRoutines -Dversion=1.0.0 -Dfile=./src/ext/userRoutines.jar -Dpackaging=jar -DgeneratePom=true

After that you need to import Route from the <strong>src/route</strong>