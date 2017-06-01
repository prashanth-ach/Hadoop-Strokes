
Running Spark Shell
.......................
```sh
spark-shell --packages com.databricks:spark-csv_2.10:1.5.0
```


setting compression in sql Context
.....................................
```sh
avro
.....
sqlContext.setConf("spark.sql.avro.compression.codec","type")

type:

snappy-default
uncompressed
deflate

parquet
.........
sqlContext.setConf("spark.sql.parquet.compression.codec","type")

type:
gzip-default
lzo
uncompressed
snappy
```


importing different file formats
.................................
```sh
avro
.....

val df1=sqlContext.read.format("com.databricks.spark.avro").load("path")

parquet
........

val df1=sqlContext.read.parquet("path")

json
.....
val df1=sqlContext.read.json("path")

csv or any delimited file
..........................
val df1=sqlContext.read.format("com.databricks.spark.csv").option(parameters).load(path)

parameters

"header","true" ---- if file has header else need not to mention

"inferschema","true"---best practise to use since it automatically chose type of data we are importing

"delimter","\t or | or any other"--- need not to mention for csv
```

creating header to a dataframe
..............................
```sh
df2=toDF("h1","h2",....)
```

Registering a Temp Table
........................
```sh
df2.registerTempTable("tablename")
```

Running a sql query
....................
```sh
sqlContext.sql("query")----(to query hive meta store we can directly query here)
```
