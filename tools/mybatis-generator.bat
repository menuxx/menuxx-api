@echo off

set currentPath=%cd%
set projectPath=%cd%\..\

set generatorCore=%currentPath%\lib\mybatis-generator-core-1.3.2.jar
set mysqlConnector=%currentPath%\lib\mysql-connector-java-5.1.38.jar

echo ======= mybatis generator start workinng ... =====

java -DprojectPath=%projectPath% -DmysqlClassPath=%mysqlConnector% -jar %generatorCore% -configfile %currentPath%\mybatis-generator-configure.xml -overwrite

echo ���ɵ��ļ�λ�� %projectPath%target Ŀ¼��

echo ======= mybatis generator work done ... ==========