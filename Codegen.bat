@echo off

REM Copyright (c) 2002-2014 TeamDev Ltd. All rights reserved.

set CLASS_PATH=../lib/antlr.jar;../lib/license.jar;../lib/licence.jar;../lib/jniwrap-3.10.jar;../lib/jniwrap-generator-3.10.jar;../lib/winpack-3.10.jar;../WinPack/lib/winpack-3.10.jar;../lib/slf4j-api-1.5.8.jar;../lib/slf4j-simple-1.5.8.jar;
start "" javaw.exe -cp "%CLASS_PATH%" com.jniwrapper.generator.Application
goto end


:end