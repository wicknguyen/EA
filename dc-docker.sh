docker pull mysql/mysql-server
docker run --name mysql -v /databases:/var/lib/mysql -p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=root mysql/mysql-server:latest
docker exec -it mysql mysql -uroot -p

