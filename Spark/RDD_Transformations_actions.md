
```sh
starting spark cli
.....................
>Spark-shell

(any error set javahome ,spark home and their paths of binary in .bashrc)

Transformations
...............


Map
...

Return a new distributed dataset formed by passing each element of the source through a function func.

scala> val x = sc.parallelize(Array("b", "a", "c"))
x: org.apache.spark.rdd.RDD[String] = ParallelCollectionRDD[0] at parallelize at <console>:27

scala> val y = x.map(z => (z,1))
y: org.apache.spark.rdd.RDD[(String, Int)] = MapPartitionsRDD[1] at map at <console>:29

scala> println(x.collect().mkString(", "))
b, a, c                                                                         

scala> println(y.collect().mkString(", "))
(b,1), (a,1), (c,1)


filter
.........	
Return a new dataset formed by selecting those elements of the source on which func returns true.

scala> val l=sc.parallelize(Array(10,20,31))
l: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[4] at parallelize at <console>:27

scala> val m=l.filter(n=>n%10==0)
m: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[5] at filter at <console>:29

scala> m.collect
res7: Array[Int] = Array(10, 20)                                                

scala> val m=l.filter(n=>n%10!=0)
m: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[6] at filter at <console>:29

scala> m.collect
res8: Array[Int] = Array(31)


Flatmap
.........
Similar to map, but each input item can be mapped to 0 or more output items (so func should return a Seq rather than a single item)

scala> val x = sc.parallelize(Array(1,2,3))
x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:27

scala> val y = x.flatMap(n => Array(n, n*100, 42))
y: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[1] at flatMap at <console>:29
                                                                      
scala> println(y.collect().mkString(", "))
1, 100, 42, 2, 200, 42, 3, 300, 42                                              


mapPartitions(func)
..................
Similar to map, but runs separately on each partition (block) of the RDD, so func must be of type Iterator<T> => Iterator<U> when running on an RDD of type T.

scala> val x = sc.parallelize(Array(1,2,3), 2)
x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:27

scala> def f(i:Iterator[Int])={ (i.sum,42).productIterator }
f: (i: Iterator[Int])Iterator[Any]

scala> val y = x.mapPartitions(f)
y: org.apache.spark.rdd.RDD[Any] = MapPartitionsRDD[1] at mapPartitions at <console>:31

scala> y.collect
res0: Array[Any] = Array(1, 42, 5, 42)                                          

scala> y.glom.collect
res1: Array[Array[Any]] = Array(Array(1, 42), Array(5, 42))                     

scala> y.glom.collect
res2: Array[Array[Any]] = Array(Array(1, 42), Array(5, 42))                     

scala> x.collect
res3: Array[Int] = Array(1, 2, 3)                                               

scala> x.glom.collect
res4: Array[Array[Int]] = Array(Array(1), Array(2, 3))     


glom():Return an RDD created by coalescing all elements within each partition into an array

productiterator

scala> List(a).productIterator.foreach(println)
List(1, 2, 3)
List()

scala> List(a, a).productIterator.foreach(println)
List(1, 2, 3)
List(List(1, 2, 3))

scala> List(a, a, a).productIterator.foreach(println)
List(1, 2, 3)
List(List(1, 2, 3), List(1, 2, 3))


MapPartitionswithindex
......................
Similar to mapPartitions, but also provides func with an integer value representing the index of the partition, so func must be of type (Int, Iterator<T>) => Iterator<U> when running on an RDD of type T.

scala> val x = sc.parallelize(Array(1,2,3), 2)
x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:27

scala> def f(partitionIndex:Int, i:Iterator[Int]) = {
     | (partitionIndex, i.sum).productIterator
     | }
f: (partitionIndex: Int, i: Iterator[Int])Iterator[Any]

scala> val y = x.mapPartitionsWithIndex(f)
y: org.apache.spark.rdd.RDD[Any] = MapPartitionsRDD[1] at mapPartitionsWithIndex at <console>:31

scala> x.collect
res0: Array[Int] = Array(1, 2, 3)                                               


scala> y.collect
res2: Array[Any] = Array(0, 1, 1, 5)                                            
                ^

scala> y.glom.collect
res4: Array[Array[Any]] = Array(Array(0, 1), Array(1, 5))   


sample(withReplacement, fraction, seed)	
........................................
Sample a fraction fraction of the data, with or without replacement, using a given random number generator seed.

false
-------

scala> val x = sc.parallelize(Array(1, 2, 3, 4, 5))
x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[2] at parallelize at <console>:27

scala> val y=x.sample(false,0.4)
y: org.apache.spark.rdd.RDD[Int] = PartitionwiseSampledRDD[3] at sample at <console>:29

scala> println(y.collect.mkString(", "))
2, 4                                                                            

scala> println(y.collect.mkString(", "))
2, 4                                                                            

scala> val y=x.sample(false,0.4)
y: org.apache.spark.rdd.RDD[Int] = PartitionwiseSampledRDD[4] at sample at <console>:29

scala> println(y.collect.mkString(", "))
2  

true
--------
val x = sc.parallelize(Array(1, 2, 3, 4, 5))
x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[5] at parallelize at <console>:27

scala> val y=x.sample(true,0.4)
y: org.apache.spark.rdd.RDD[Int] = PartitionwiseSampledRDD[6] at sample at <console>:29

scala> println(y.collect.mkString(", "))
5         

seed
------
scala> val y=x.sample(true,0.4,3)
y: org.apache.spark.rdd.RDD[Int] = PartitionwiseSampledRDD[7] at sample at <console>:29

scala> println(y.collect.mkString(", "))
1, 4, 5                                                                         

scala> val y=x.sample(true,0.4,3)
y: org.apache.spark.rdd.RDD[Int] = PartitionwiseSampledRDD[8] at sample at <console>:29

scala> println(y.collect.mkString(", "))
1, 4, 5                                                                         

scala> val y=x.sample(true,0.5,3)
y: org.apache.spark.rdd.RDD[Int] = PartitionwiseSampledRDD[9] at sample at <console>:29

scala> println(y.collect.mkString(", "))
                                                                                

scala> val y=x.sample(true,0.2,3)
y: org.apache.spark.rdd.RDD[Int] = PartitionwiseSampledRDD[10] at sample at <console>:29

scala> println(y.collect.mkString(", "))
1                                                                                                


union
........	
Return a new dataset that contains the union of the elements in the source dataset and the argument.

scala> val x=sc.parallelize(Array(1,2,3),3)
x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[11] at parallelize at <console>:27

scala> val y=sc.parallelize(Array(1,2))
y: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[12] at parallelize at <console>:27

scala> val z=x.union(y)
z: org.apache.spark.rdd.RDD[Int] = UnionRDD[13] at union at <console>:31

scala> z.glom.collect
res10: Array[Array[Int]] = Array(Array(1), Array(2), Array(3), Array(1), Array(2))


intersection
.............
Return a new RDD that contains the intersection of elements in the source dataset and the argument.

scala> val z=x.intersection(y)
z: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[20] at intersection at <console>:31

scala> z.glom.collect
res11: Array[Array[Int]] = Array(Array(), Array(1), Array(2))  


distinct
.........
Return a new dataset that contains the distinct elements of the source dataset.

scala> val x=sc.parallelize(Array(1,2,3),3)
x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:27

scala> val y=sc.parallelize(Array(2,3,4),3)
y: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[1] at parallelize at <console>:27

scala> val z=x.union(y)
z: org.apache.spark.rdd.RDD[Int] = UnionRDD[2] at union at <console>:31

scala> z.glom.collect
res0: Array[Array[Int]] = Array(Array(1), Array(2), Array(3), Array(2), Array(3), Array(4))

scala> val a=z.distinct()
a: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[6] at distinct at <console>:33

scala> a.glom.collect
res1: Array[Array[Int]] = Array(Array(), Array(1), Array(2), Array(3), Array(4), Array())

```

