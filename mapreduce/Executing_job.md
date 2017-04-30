
# Executing a Map reduce Java Program


##create your program in eclipse

```sh
code must contain a mapper code(mapper.java) 
code must contain reducer code(reducer.java)
code must contain driver code(driver.java)
code may contain a combiner code(combiner.java) 
```

##Exporting jar files

```sh
use export option by right clicking on your project folder
select jar option next enter
save it in some location on your workstation
```
##Copying the jar into your node

```sh
In your terminal type scp file name 

scp file.jar root@externalip: ~/(saves it to your nodes's root home)
```
##Executing a mapreduce job
```sh
In your node
 
Set your hadoop home(point it your hadoop jar files in bashrc or bashprofile and source it)
 
hadoop jar Md.jar hadoop.Mdir.driver(hadoop jar jarfile_name packagename.driver_code_classname)
```



