@echo off
echo deploy to heroku.

set MVN=mvn

call %MVN% clean install
if errorlevel 1 goto error

call %MVN% heroku:deploy
if errorlevel 1 goto error

goto end
:error
echo Error Happen!!
:end
pause
