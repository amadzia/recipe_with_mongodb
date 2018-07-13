# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql:5 or connect to mysql and run as root user
# docker run -p 3306:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=password -d mysql mysqld --default-authentication-plugin=mysql_native_password  //for mysql 8

#Create database
CREATE DATABASE recipe_dev;
CREATE DATABASE recipe_prod;

#Create database service accounts
CREATE USER 'recipe_dev_user'@'localhost' IDENTIFIED BY 'recipeuser';
CREATE USER 'recipe_prod_user'@'localhost' IDENTIFIED BY 'recipeuser';
#for Docker needs
CREATE USER 'recipe_dev_user'@'%' IDENTIFIED BY 'recipeuser';
CREATE USER 'recipe_prod_user'@'%' IDENTIFIED BY 'recipeuser';

#Database grants
GRANT SELECT ON recipe_dev.* to 'recipe_dev_user'@'localhost';
GRANT INSERT ON recipe_dev.* to 'recipe_dev_user'@'localhost';
GRANT DELETE ON recipe_dev.* to 'recipe_dev_user'@'localhost';
GRANT UPDATE ON recipe_dev.* to 'recipe_dev_user'@'localhost';
GRANT SELECT ON recipe_prod.* to 'recipe_prod_user'@'localhost';
GRANT INSERT ON recipe_prod.* to 'recipe_prod_user'@'localhost';
GRANT DELETE ON recipe_prod.* to 'recipe_prod_user'@'localhost';
GRANT UPDATE ON recipe_prod.* to 'recipe_prod_user'@'localhost';
#for Docker needs
GRANT SELECT ON recipe_dev.* to 'recipe_dev_user'@'%';
GRANT INSERT ON recipe_dev.* to 'recipe_dev_user'@'%';
GRANT DELETE ON recipe_dev.* to 'recipe_dev_user'@'%';
GRANT UPDATE ON recipe_dev.* to 'recipe_dev_user'@'%';
GRANT SELECT ON recipe_prod.* to 'recipe_prod_user'@'%';
GRANT INSERT ON recipe_prod.* to 'recipe_prod_user'@'%';
GRANT DELETE ON recipe_prod.* to 'recipe_prod_user'@'%';
GRANT UPDATE ON recipe_prod.* to 'recipe_prod_user'@'%';
