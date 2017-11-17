#!/bin/sh
retry=0
maxAttempts=3
counter=0
delay=1

JAVA_HOME=/usr/java/jdk1.8.0_71

while [ $retry -eq 0 ]
do
        if [ $counter -eq $maxAttempts ]
        then
                echo "Exiting as attempted $maxAttempts times unsuccessfully"
                retry=1
        else
                counter=$(expr $counter + 1)
                $JAVA_HOME/bin/java -jar /home/btamilma/repos/mis-apps/restart/target/result.jar
                if [ $? -eq 0 ]
                then
                        echo "Result of Java application call $?"
                        echo "The Java program exited normally, will not be attempted again"
                        break;
                else
                        echo "Result of Java application call $?"
                        echo "Java application will be called again after $delay second"
                        sleep $delay
                fi
        fi
        echo "counter:: $counter"
        echo "retry:: $retry"
done
