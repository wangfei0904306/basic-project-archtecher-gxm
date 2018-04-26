#!/bin/bash
#
java -jar -Xms2000m -Xmx2000m -Xss256K -XX:MetaspaceSize=250m -XX:MaxMetaspaceSize=250m /accounting/target/attach-assemble-1.0.0.jar
