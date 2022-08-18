podman run \
--name zad1 \
--privileged  \
--mount type=bind,source=./../zad1/htdocs,target=/usr/local/apache2/htdocs  \
-p 8081:80 \
-d zad1

podman run \
  --name zad2 \
  --privileged \
  --mount type=bind,source=./../zad2/webapps,target=/usr/local/tomcat/webapps \
  -p 8082:8080 \
  -d tomcat:9.0

podman run \
  --name zad3 \
  --privileged \
  -p 8083:80 \
  -d zad3

