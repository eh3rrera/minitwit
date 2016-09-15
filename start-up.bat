@echo off
echo start up.

set MVN=mvn

call %MVN% clean install
if errorlevel 1 goto error

call %MVN% compile exec:java
if errorlevel 1 goto error
echo [INFO] http://localhost:4567/

goto end
:error
echo Error Happen!!
:end
pause
