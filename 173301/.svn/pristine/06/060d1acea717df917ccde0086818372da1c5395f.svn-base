Docker instructions:

Run in following order:

buildit.sh (script to build container image)

webstart.sh (script to start container from built image)

the container process will need access to the htdocs folder, so don't put too strict permissions on this folder, otherwise it will not work

*.cgi in the htdocs folder need to have execute permissions in order to be able to run properly


listajcs.exe, Listaj.class and listaj.c.cgi need to be compiled from source so, attach to the running container console and run the following commands

attachconsole.sh (script to attach to running console)

   - cd htdocs
   - mcs listajcs.cs
   - javac Listaj.java
   - gcc -o listaj.c.cgi listaj.c
   - exit

