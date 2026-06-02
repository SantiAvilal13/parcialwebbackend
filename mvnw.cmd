@echo off
setlocal

set "MAVEN_VERSION=3.9.6"
set "MAVEN_HOME=%USERPROFILE%\.m2\wrapper\dists\apache-maven-%MAVEN_VERSION%"
set "MAVEN_ZIP=%USERPROFILE%\.m2\wrapper\dists\apache-maven-%MAVEN_VERSION%-bin.zip"
set "MAVEN_URL=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/%MAVEN_VERSION%/apache-maven-%MAVEN_VERSION%-bin.zip"

if exist "%MAVEN_HOME%\bin\mvn.cmd" goto runMaven

echo Maven not found. Downloading Apache Maven %MAVEN_VERSION%...
if not exist "%USERPROFILE%\.m2\wrapper\dists" mkdir "%USERPROFILE%\.m2\wrapper\dists"

powershell -Command "Invoke-WebRequest -Uri '%MAVEN_URL%' -OutFile '%MAVEN_ZIP%'"
if %ERRORLEVEL% neq 0 (
    echo ERROR: Failed to download Maven.
    exit /B 1
)

echo Extracting Maven...
powershell -Command "Expand-Archive -Path '%MAVEN_ZIP%' -DestinationPath '%USERPROFILE%\.m2\wrapper\dists' -Force"
if %ERRORLEVEL% neq 0 (
    echo ERROR: Failed to extract Maven.
    exit /B 1
)

del "%MAVEN_ZIP%" 2>nul

:runMaven
set "PATH=%MAVEN_HOME%\bin;%PATH%"
mvn.cmd %*

endlocal
