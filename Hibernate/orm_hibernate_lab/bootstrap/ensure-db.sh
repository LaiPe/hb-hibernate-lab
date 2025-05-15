#!/bin/bash

# Attendre que MySQL soit prêt
until mysqladmin ping -h"localhost" -u"root" -p"$MYSQL_ROOT_PASSWORD" --silent; do
    echo "En attente du démarrage de MySQL..."
    sleep 2
done

# Créer la base de données si elle n'existe pas
mysql -uroot -p"$MYSQL_ROOT_PASSWORD" -e "CREATE DATABASE IF NOT EXISTS testdb;"

# S'assurer que l'utilisateur a les bons droits
mysql -uroot -p"$MYSQL_ROOT_PASSWORD" -e "GRANT ALL PRIVILEGES ON testdb.* TO '$MYSQL_USER'@'%';"
mysql -uroot -p"$MYSQL_ROOT_PASSWORD" -e "FLUSH PRIVILEGES;"

# Exécuter des scripts d'initialisation supplémentaires si nécessaire
# Par exemple, pour initialiser des tables ou insérer des données

#if [ -f "/path/to/your/init-script.sql" ]; then
#    mysql -uroot -p"$MYSQL_ROOT_PASSWORD" testdb < /path/to/your/init-script.sql
#fi

# Le healthcheck doit retourner 0 pour indiquer que tout va bien
exit 0