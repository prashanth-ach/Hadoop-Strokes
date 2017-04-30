#Core Sqoop Commands


##Import commands 
```sh
sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --table test1;(goes to /user/root/test1/ directory)
```
```sh
sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --table test1 -m 1;(to set number of mappers)
```
```sh
sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --table test2 -m 1 --target-dir '/hello/';(to set specified target directory)
```
```
sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --table test2 --fields-terminated-by '|' -m 1 --target-dir '/hello1/';(fields terminated by.....generally fields are terminated by ',')
```
```sh
sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --table test2 --fields-terminated-by '|' --columns 'id' -m 1 --target-dir '/hello2/';(to import only specific columns)
```
```sh
 sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --table test2 --fields-terminated-by '|' --where 'id>2' -m 1 --target-dir '/hello3/';(to import on a condition)
```
```sh
 sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --query "select * from test2 where \$CONDITIONS" --target-dir '/hell' -m 1;(to import with a query )(you can put another where condition using AND)
```
```sh
sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --table test2 --fields-terminated-by '|' --where 'id>2' -m 1 --target-dir '/hello4/' --as-avrodatafile;(to specify a file format)
```

##list-databases commands
```sh
 sqoop list-databases --connect jdbc:mysql://localhost/ --username root --password namenode
```

##list-tables commands
```sh
sqoop list-tables --connect jdbc:mysql://localhost/ --username root --password namenode
```

##import-all tables
```sh
sqoop import-all-tables --connect jdbc:mysql://localhost/test --username root --P -m 1;
```

##eval commands
```sh
sqoop eval --connect jdbc:mysql://localhost/test --username root --password namenode --query "select * from test2 " ;(you can give any sql query)
```
##To create a sqoop job
```sh
sqoop job --create first -- import --connect jdbc:mysql://localhost/test --username root --password namenode --table test1 -m 1 --target-dir /job --incremental append --check-column id ;(can use --last-value 3)
```
##To import into hive tables
```sh 
sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --table test2  -m 1 --hive-import --create-hive-table;
```
##TO export tables
```sh
sqoop export --connect jdbc:mysql://localhost/test --username root --password namenode --table test2 --export-dir '/job/part-m-00000';
```
```sh
sqoop export --connect jdbc:mysql://localhost/test --username root --password namenode --table test2 --export-dir '/job/part-m-00000' --fields-terminated-by '|';(if tables fields are terminated other than ',')
```
##To perform merge
```sh
-->import data to one location1
-->update table using eval(existing rows with some modification)
-->add new data to table
-->import data to location2 with below condition(import data only other than the existing)

sqoop import --connect jdbc:mysql://localhost/test --username root --password namenode --table test2  -m 1 --target-dir=/job2/ --where "id>=2";

-->copy the jar location while running the import (you will see while running the import command)

sqoop merge --merge-key id --new-data /job2/ --onto /job1/ --target-dir /job3/ --class-name test2 --jar-file /tmp/sqoop-root/compile/d6ef0a8b2b06414339ebec43144c4992/test2.jar

```


