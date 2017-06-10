## Scala Guide 

```sh
Declaring variables(initialization is mandatory)
...............................................
 
val:immutable (cannot re initialize) 

val i=0

i=1(error)

val i:Int=0 ( with data type)
val a:Float=42.0f
val b:Long=45.0L
val f:Double=a*b*c
val d:Short=42(cannot take decimal)
-------------------------------
var:mutable  (can re initialize)

var i=0

i=1 (no error)




programming Constructs
......................................................
>>:paste to type multiple lines 

>>println("hhhhjj")

>>val d={

val i=1
val b=3

val j=math.pow(2,3)
i-j
}

>>val j=math.random

>>val k=(math.random*100).abs

>>val k=(math.random*100).toInt

>>if(i>j)
println("abbb")
else println
("nnn")

>>i==j ? i=2(if i is not equal to j it return i=2)

>>if(i>j)i else j

>>while(a>=J)
{
println(a)
a-=1
}

>>for (e <- j to i) (from value j to value i)

>>for (e <- 10 to 18 by 2) (takes 2 as increment line 10,8,6,4,..)

>>for (e <- 10 to 1 by -3) (to decrement by 3)
 



Functions
........................................................................

>>def fact(i:int):Int={
val res=1

for(e <- i to 1 by -1)

res=res+e

res
}

//recursive
>>def fact(i:Int):Int = if (i==1) 1 else i * fact(i-1)

//nested function
>>def ncr(n:Int,r:Int)=
{
def fact(i:Int)=
{
  val res=1
for(e<-i to 1 by -1)
res=res*e
res
}
fact(n)/(fact(n-r) * fact(r))
}


//higher order functions

def sum(f:Int=>Int,a:Int,b:Int)=      //to add more aurgments to function
{                                      //sum(f: (Int,Int)=>Int,a:Int,b:Int)
if (a>b) 0 else f(a)+sum(f,a+1,b)
}


def square(i:Int)=a*a

sum(square,1,10)


//Anonymous Function

--(i:int)=>i

--val a=(i:Int)=>i*i
   val(5) gives 25
---sum((i:Int)=>i*i,1,10))(giving function in the method call itself)





Single ton Classes
....................................................................

object combination
{
  def sum(i:Int):Int=
    i+1

  def main(args: Array[String]): Unit ={
    val i=args(0).toInt
    val j=sum(i)
    println(j)
  }
}



class department(dptid:Int,dat:Int)(we caanot acceess data here)

class department(val dptid:Int,val dat:Int)

class department(var dptid:Int,var dat:Int)(getter and setter are created automatically)

val d=new department(1,2)

d.dptid gives 1 as output

override def toString="Department("+dptid+","+dat+")"(in order to not to show byte address)



class Department(
                  departmentId: Int,
                  departmentName: String
                ) {
  override def toString() = "Department(" +
    departmentId +
    "," +
    departmentName +
    ")"
}

class Category(
                categoryId: Int,
                categoryDepartmentId: Int,
                categoryName: String
              ) {
  override def toString() = "Category(" +
    categoryId +
    "," +
    categoryDepartmentId +
    "," +
    categoryName

  ")"
}


class Product(
               productId: Int,
               productCategoryId: Int,
               productName: String,
               productDescription: String,
               productPrice: Float,
               productImage: String
             ) {
  override def toString() = "Product(" +
    productId +
    "," +
    productCategoryId +
    "," +
    productName +
    "," +
    productDescription +
    "," +
    productPrice +
    "," +
    productImage +
    ")"
}

class Customer(
                customerId: Int,
                customerFname: String,
                customerLname: String,
                customerEmail: String,
                customerPassword: String,
                customerStreet: String,
                customerCity: String,
                customerState: String,
                customerZipcode: String
              ) {
  override def toString: String = "Customer(" +
    customerId +
    "," +
    customerFname +
    "," +
    customerLname +
    "," +
    customerEmail +
    "," +
    customerPassword +
    "," +
    customerStreet +
    "," +
    customerCity +
    "," +
    customerState +
    "," +
    customerZipcode +
    ")"
}

class Order(
             orderId: Int,
             orderDate: String,
             orderCustomerId: Int,
             orderStatus: String
           ) {
  override def toString: String = "Order(" +
    orderId +
    "," +
    orderDate +
    "," +
    orderCustomerId +
    "," +
    orderStatus +
    ")"
}




constructor
-------------------------------------------------------------------------
class OrderItem(
                 orderItemId: Int,
                 orderItemOrderId: Int,
                 orderItemProductId: Int,
                 orderItemQuantity: Int,
                 orderItemSubtotal: Float,
                 orderItemProductPrice: Float
               ) {
  require(
    orderItemSubtotal == orderItemQuantity * orderItemProductPrice, "Invalid orderItemSubtotal " + orderItemSubtotal
  )

  //Additional constructor
  def this(
            orderItemId: Int,
            orderItemOrderId: Int,
            orderItemProductId: Int,
            orderItemQuantity: Int,
            orderItemProductPrice: Float
          ) = {
    //Invoking default constructor
    this(orderItemId,
      orderItemOrderId,
      orderItemProductId,
      orderItemQuantity,
      orderItemQuantity * orderItemProductPrice,
      orderItemProductPrice)
  }

  override def toString: String = "OrderItem(" +
    orderItemId +
    "," +
    orderItemOrderId +
    "," +
    orderItemProductId +
    "," +
    orderItemQuantity +
    "," +
    orderItemSubtotal +
    "," +
    orderItemProductPrice +
    ")"
}

object retail {
  def main(args: Array[String]) = {
    val oi = new OrderItem(1, 1, 1, 2, 100, 50)
    println(oi)
    val ordItem = new OrderItem(2, 1, 3, 3, 50)
    println(ordItem)
  }
}





overriding operator's functionalities
-----------------------------------------

class fraction(val n:Int,val d:Int)
{
override def toString=n+"/"+d
def result=n/d.toDouble
//def +(p:fraction)={

//new Fraction((n*p.d+d*p.n),(d*p.d))(redefining the + sign)

//}
}

object Fraction{

def main(args:Array[String])={
val f=new fraction(4,2)
println(f)
println(f.result)
val s=new fraction(3,5)
//val r=f+s  (used redefined + sign)
//println(r)
}
}

 


adding dependencies
-----------------------------
in build.sbt file


LibraryDependencies +="mysql" % "mysql-connector-java"%"5.1.36"




how a scala program look like
-----------------------------------------------
import ....
import ......

case class name(name:String)
{

override toStr....
}

def 





scala collections
..........................................................................

immutable-doesnot contain update
mutable -conatain update

array is not present in collections

scala.collection.mutable/immutable(depends)

array
-----
val a=Array(1,2,3)

val a=Array(2,3.0) gives double-if mixed shows any

list
-----
val b=List(1,2,3)

a.update(index_to_update,value to be updated) or a(2)=15 


a=a:+20 (to add new element at the end)

a=6+:a (to add at the begining)

val m=100 to 200

a=a++m (to combine two lists)


case class Order{

a:Int,
b:Int
}

val os=list(Order(1,1),order(1,2))

os.filter(x=>(x.b==1)) (filters all the data with 1 in second column) 

collection functions
---------------------
l.partition(_%2==0)  (splits the list into odd and even numbers)

val (a,b)=l.partition(f=> f.id=="1" || f.id="2") (divides lists into a,b lists)   

a.foreach(println)
b.foreach(println)

val b=a.par.partition(...) (par increases the speed by parallelizing)
 
l.foreach(println)   (prints a list)

l.foreach(println(x=>x*x))

l.isempty(to check if list is empty)

os.filter(x=>(x.b==1)) (filters data)

os.map(x=>x.a.replace(1,5).toInt) (replace first column value =1 to value=5) 

(1 to 100).filter(_%2==0).reduce((a,b)=>a+b) (takes 1 to 100 even numbers and finds their sum)

l.sorted (sorts data in ascending order)

l.sortBy(k=>-k)  or l.sortBy(-_)   (descending order)

l.sortBy(k=>k(0))  (sorts in ascending order)

l.sortWith((a,b)=>{
if(a.id>b.id)
false
else if(a.id<b.id)
true
else
{
if(a.orderid>b.orderid)
false
else 
true
}).foreach(println)


os.groupBy(k=>k.id) (gives a map as output)


map(f=> (f._1,f._2)) (selects first and second column)(if f._2.size returns size of list)

os.contains(..)  (checks if any element is present)


1->hello (creates a map)

```

