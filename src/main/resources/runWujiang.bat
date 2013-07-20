@echo off
rem -------------------------------------------------------------------------
rem Batch Data Changing
rem -------------------------------------------------------------------------
set JAVA=%JAVA_HOME%\bin\java
set JAVA_OPTS=%JAVA_OPTS% -server -Xms2048m -Xmx2048m -Xss128k -XX:+UseParallelGC -XX:ParallelGCThreads=8  
set JAVA_OPTS=%JAVA_OPTS% -Dsun.rmi.dgc.client.gcInterval=1800000 -Dsun.rmi.dgc.server.gcInterval=1800000
%JAVA% %JAVA_OPTS% -jar wujiang-1.0-SNAPSHOT.jar