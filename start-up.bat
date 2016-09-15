@echo off
echo start up.

set MVN=mvn

call %MVN% clean install
if errorlevel 1 goto error

call %MVN% compile exec:java
if errorlevel 1 goto error

goto end
:error
echo Error Happen!!
:end
pause
