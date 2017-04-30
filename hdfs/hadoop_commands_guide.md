# fs

## TO see free space 

```sh
 hadoop fs -df (-h for human readable)
```

## TO find a file or relared data

```sh
 hadoop fs -find /test/ keyword
```

## to find extended attribute names

```sh
getfattr

Usage: hadoop fs -getfattr [-R] -n name | -d [-e en] <path>

Displays the extended attribute names and values (if any) for a file or directory.

Options:

-R: Recursively list the attributes for all files and directories.
-n name: Dump the named extended attribute value.
-d: Dump all extended attribute values associated with pathname.
-e encoding: Encode values after retrieving them. Valid encodings are “text”, “hex”, and “base64”. Values encoded as text strings are enclosed in double quotes ("), and values encoded as hexadecimal and base64 are prefixed with 0x and 0s, respectively.
path: The file or directory.
Examples:

hadoop fs -getfattr -d /file
hadoop fs -getfattr -R -n user.myAttr /dir
``` 

## for help

```sh
hadoop fs -help
```

## to remove a directory

```sh 
hadoop fs rmdir /test/ (-skipTrash to skip recyclebin)
```

## To truncate data of matched patterns

```sh
hadoop fs -truncate [-w] <length> <paths>

Truncate all files that match the specified file pattern to the specified length.

hadoop fs -truncate -w 127 hdfs://nn1.example.com/user/hadoop/file1
```

## To check command usage
```sh
hadoop fs -usage command
```

## TO check tail

```sh
hadoop fs -tail [-f] URI

Displays last kilobyte of the file to stdout.

Options:

The -f option will output appended data as the file grows, as in Unix.

```

## To run a jar
```sh
Runs a jar file. Users can bundle their Map Reduce code in a jar file and execute it using this command.

Usage: hadoop jar <jar> [mainClass] args...
```

## to copy files recursively

```sh
 distcp <srcurl> <desturl> 	copy file or directories recursively

```

## TO create a hadoop archive
```sh
 archive -archiveName NAME -p <parent path> <src>* <dest> create a hadoop archive

```


