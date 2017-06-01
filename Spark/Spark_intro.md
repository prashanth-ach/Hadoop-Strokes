
RDD
....
```sh
RDD is big collection of data

Resilient-fault tolerant

Distributed-can run on multiple machines

Data set-collection of data
```


properties
..........
```sh
immutable:once created never changes(Helps in parallelize and caching)

lazy evaluated:do not compute transformations till u need it or until an action is made until then loaded RDD are empty in memory
example :
val c1=collection.map(value=>value+1)
val c2=c1.map(value=>value+2)
print c2(now transform)(val c2=collection.map(value=>{var result=value+1 result=result+2}}

cachable(immutable data can be cached)


type inference(no type casting of data is required)(data type is not required)

```
sequence of steps performed on RDD
..................................
```sh
Transformations(map or join) 

actions(print)
```
Dependencies of RDD
.....................
```sh
Narrow(each partition of the parent RDD is used by at most one partition of the child RDD)

Wide(multiple child RDD partitions may depend on a single parent RDD partition)


```
Introduction about spark
........................
```sh
spark is built on scala about 1500 lines of code 

which is faster in execution

we can use intermediate results

we do in memory computation
```
spark modes of execution
......................
```sh
local mode(lacks proper troubleshooting)
yarn (for production)
mesos(for production)
standlone(development and troubleshoot in cluster mode)

```
spark modules
.................
core spark(transformations:map,join and actions:reduce,count,collect)

Dataframes,datasets and sql(integration of rdd with sql by ceating structure at run time)

Spark streaming(for analytics for batch data from  sources such as web sources using flu and kafka) 

Mlib(to apply machine learning algorithms)

Graphx(for graph pocessing )

Bagel(for implemeting graph processing algorithms)

R(for working with R like spark with scala)


Engine
........
Spark Core

storage
.........
local 
hdfs
rdbms
nosql

supported programming interfaces
.................................
scala
python
r
java
tools



Spark job anatomy
....................

Driver program(in master machine)
workernode(data node)
executors(code is sitting....space in ram where block is loaded where you can cache to persist data)



