#!/bin/sh

currentPath=`pwd`
projectPath=`pwd`/../

generatorCore=$currentPath/lib/mybatis-generator-core-1.3.3.jar
mysqlConnector=$currentPath/lib/mysql-connector-java-5.1.38.jar

mkdir $projectPath/target/generated-sources/mybatis

echo ======= mybatis generator start working ... =====
java -DprojectPath=$projectPath -DmysqlClassPath=$mysqlConnector -jar $generatorCore -configfile $currentPath/mybatis-generator-configure.xml -overwrite
echo 生成的文件位于 $projectPathtarget 目录下
echo ======= mybatis generator work done ... ==========