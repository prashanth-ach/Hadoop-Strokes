
# DFS

## To add data to an existing file 

```sh
hdfs dfs -appendToFile appen.txt /test/trial.txt
hdfs dfs -appendToFile - hdfs://nn.example.com/hadoop/hadoopfile Reads the input from stdin.(takes user input)

```

## To view data of created file

```sh
hdfs dfs -cat /test/trial.txt
hdfs dfs -cat hdfs://nn1.example.com/file1 hdfs://nn2.example.com/file2
hdfs dfs -cat file:///file3 /user/hadoop/file4
```

## To change the group of file or folder

```sh
hdfs dfs -chgrp -R supergroup /test/
```

## To create a group and add a user(in linux)

```sh
useradd test(make a group)

usermod -g test temp(add temp user to test group)

```

## To change owner of file

```sh
hdfs dfs -chown -R test /test/

```

## TO change permissions of a file

```sh
 hdfs dfs -chmod -R 777 /test/

```

## TO copy from local to hdfs

```sh
hdfs dfs -copyFromLocal -f trial.txt /test/  (use -f only if the file with same name already exist in node in order to over write)

```

## TO copy from hdfs to local

```sh
hdfs dfs -copyToLocal  /test/sample.txt /var/lib/hadoop-hdfs/

```

## TO count number of files and directories under a directory

```sh
hdfs dfs -count  /test/ (format of -count noofdirectories  nooffiles  bytes)(-q is used to check quota)(you can give any no of paths seperated by space)

```

## To check the size of a file or directory

```sh
hdfs dfs -du /test/ (-s for aggregate summary and -h for human readable format)
```


## To check the summary of size

```sh
hdfs dfs -dus /test/ (replacement for hdfs dfs -du -s /test)
```

## To empty trash 

```sh
 hdfs dfs -expunge(used to empty recycle bin or trash in hadoop fs)
```

## To get a file from hadoop filesystem to local

```sh
 hdfs dfs -get /test/sample.txt /var/lib/hadoop-hdfs/ (source is hdfs , dest is our local file system)
hdfs dfs -get hdfs://nn.example.com/user/hadoop/file localfile(using uri)
```

## To check file owner and group

```sh
hdfs dfs -getfacl -R /test/
```

## To check file and its permissions 

```sh
hdfs dfs -ls /test/ (-lsr for recursive)
``` 

## To copy data from all the files in a hdfs directory to a single file in our local directory

```sh
 hdfs dfs -getmerge /test/ /var/lib/hadoop-hdfs/sample.txt
```

## To create multiple directories

```sh
hdfs dfs -mkdir -p  /dir/ /dir1/ (-p to create parent directory format)
hdfs dfs -mkdir hdfs://nn1.example.com/user/hadoop/dir hdfs://nn2.example.com/user/hadoop/dir(using uri)
```

## To move a file from local to hdfs

```sh
hdfs dfs moveFromLocal sample.txt /test/ (file in local is deleted after move)
```

## To move a file from hdfs to local

```sh
hdfs dfs moveToLocal  /test/sample.txt /var/lib/hadoop-hdfs/(file in the hdfs is deleted)
```

## Moves files from source to destination with in hdfs

```sh
hdfs dfs -mv /user/hadoop/file1 /user/test/(you can provide multiple sources)
hdfs dfs -mv hdfs://nn.example.com/file1 hdfs://nn.example.com/file2 hdfs://nn.example.com/file3 hdfs://nn.example.com/dir1 (using uri)
```


## To move multiple files from local to hdfs

```sh 
hdfs dfs -put /var/lib/hadoop-hdfs/sample.txt /test/(you can put multiple sources here)
```

## To delete a file in hdfs

```sh
hdfs dfs -rm /test/sample.txt (-skipTrash used to directly delete a file not saving in recycle bin)

```

## To delete a files recursively in hdfs

```sh
hdfs dfs -rmr /test/sample.txt (-skipTrash used to directly delete a file not saving in recycle bin)
```

## setfacl
```sh
Usage: hdfs dfs -setfacl [-R] [-b|-k -m|-x <acl_spec> <path>]|[--set <acl_spec> <path>]

Sets Access Control Lists (ACLs) of files and directories.

Options:

-b: Remove all but the base ACL entries. The entries for user, group and others are retained for compatibility with permission bits.
-k: Remove the default ACL.
-R: Apply operations to all files and directories recursively.
-m: Modify ACL. New entries are added to the ACL, and existing entries are retained.
-x: Remove specified ACL entries. Other ACL entries are retained.
--set: Fully replace the ACL, discarding all existing entries. The acl_spec must include entries for user, group, and others for compatibility with permission bits.
acl_spec: Comma separated list of ACL entries.
path: File or directory to modify.
Examples:

hdfs dfs -setfacl -m user:hadoop:rw- /file
hdfs dfs -setfacl -x user:hadoop /file
hdfs dfs -setfacl -b /file
hdfs dfs -setfacl -k /dir
hdfs dfs -setfacl --set user::rw-,user:hadoop:rw-,group::r--,other::r-- /file
hdfs dfs -setfacl -R -m user:hadoop:r-x /dir
hdfs dfs -setfacl -m default:user:hadoop:r-x /dir

```

## To set the replication factor of a file or a directory
```sh
hdfs dfs -setrep -R -w 3 /test/ (-r for recursive and -w is used to wait until the file replication is done ......it may take long time if we use -w)
```

## To check file or folder creation date or time

```sh
hdfs dfs -stat /test/
```

## To check last few lines of data

```sh
hdfs dfs -tail /test/trial.txt(-f appends data as file grows)
```

## To check if a file or directory exists and if it has zero kb 

```sh
hdfs dfs -test /test/ (-e if a file exist or -d check path is directory or -z to see if a file is zero length(no data))
```

## To see data in a text file or see data of text file in a zip

```sh
hdfs dfs -text /text/sample.txt(can even view text data in zip file)
```

## To create a file of zero length

```sh 
hdfs dfs -touchz /test/filename.txt
```
## To create a snap shot to data backup

```sh
hdfs dfs -createSnapshot /test/ chandra
hdfs dfs -ls /foo/.snapshot(list snapshorts)
hdfs dfs -ls /foo/.snapshot/f0(listing files in snap shot)
hdfs dfs -cp -ptopax /foo/.snapshot/s0/bar /tmp( to copy a file from snapshot)
hdfs dfs -deleteSnapshot <path> <snapshotName (to delete a snap shot)

```



# NameNode

```sh
hdfs namenode -format  [-clusterid cid] [-force] [-nonInteractive](Formats the specified NameNode. It starts the NameNode, formats it and then shut it down. -force option formats if the name directory exists. -nonInteractive option aborts if the name directory exists, unless -force option is specified)

hdfs namenode [-backup] |
          [-checkpoint] |
          [-format [-clusterid cid ] [-force] [-nonInteractive] ] |
          [-upgrade [-clusterid cid] [-renameReserved<k-v pairs>] ] |
          [-upgradeOnly [-clusterid cid] [-renameReserved<k-v pairs>] ] |
          [-rollback] |
          [-rollingUpgrade <downgrade |rollback> ] |
          [-finalize] |
          [-importCheckpoint] |
          [-initializeSharedEdits] |
          [-bootstrapStandby] |
          [-recover [-force] ] |
          [-metadataVersion ]

-backup	Start backup node.
-checkpoint	Start checkpoint node.
-format [-clusterid cid] [-force] [-nonInteractive]	Formats the specified NameNode. It starts the NameNode, formats it and then shut it down. -force option formats if the name directory exists. -nonInteractive option aborts if the name directory exists, unless -force option is specified.
-upgrade [-clusterid cid] [-renameReserved <k-v pairs>]	Namenode should be started with upgrade option after the distribution of new Hadoop version.
-upgradeOnly [-clusterid cid] [-renameReserved <k-v pairs>]	Upgrade the specified NameNode and then shutdown it.
-rollback	Rollback the NameNode to the previous version. This should be used after stopping the cluster and distributing the old Hadoop version.
-rollingUpgrade <downgrade|rollback|started>	See Rolling Upgrade document for the detail.
-finalize	Finalize will remove the previous state of the files system. Recent upgrade will become permanent. Rollback option will not be available anymore. After finalization it shuts the NameNode down.
-importCheckpoint	Loads image from a checkpoint directory and save it into the current one. Checkpoint dir is read from property fs.checkpoint.dir
-initializeSharedEdits	Format a new shared edits dir and copy in enough edit log segments so that the standby NameNode can start up.
-bootstrapStandby	Allows the standby NameNode’s storage directories to be bootstrapped by copying the latest namespace snapshot from the active NameNode. This is used when first configuring an HA cluster.
-recover [-force]	Recover lost metadata on a corrupt filesystem. See HDFS User Guide for the detail.
-metadataVersion	Verify that configured directories exist, then print the metadata versions of the software and the image.


```

# Secondarynode

```sh
 hdfs secondarynamenode -checkpoint -force (-format Format the local storage during startup,-geteditsize Prints the number of uncheckpointed transactions on the NameNode,-checkpoint [force] Checkpoints the SecondaryNameNode if EditLog size >= fs.checkpoint.size. If force is used, checkpoint irrespective of EditLog size.)
```

# Journalnode
```sh
Usage: hdfs journalnode

This comamnd starts a journalnode for use with HDFS HA with QJM.

```

# ZKFC

```sh
Usage: hdfs zkfc [-formatZK [-force] [-nonInteractive]]

COMMAND_OPTION	Description
-formatZK	Format the Zookeeper instance
-h	Display help
This comamnd starts a Zookeeper Failover Controller process for use with HDFS HA with QJM.
```

# DataNode

```sh
hdfs datanode [-regular | -rollback | -rollingupgrace rollback]

COMMAND_OPTION	Description
-regular	Normal datanode startup (default).
-rollback	Rollback the datanode to the previous version. This should be used after stopping the datanode and distributing the old hadoop version.
-rollingupgrade rollback	Rollback a rolling upgrade operation.
Runs a HDFS datanode.
```

# dfsadmin

```sh
 hadoop dfsadmin [GENERIC_OPTIONS] [-report] [-safemode enter | leave | get | wait] [-refreshNodes] [-finalizeUpgrade] [-upgradeProgress status | details | force] [-metasave filename] [-setQuota <quota> <dirname>...<dirname>] [-clrQuota <dirname>...<dirname>] [-help [cmd]]

COMMAND_OPTION	Description
-report	Reports basic filesystem information and statistics.
-safemode enter | leave | get | wait	Safe mode maintenance command. Safe mode is a Namenode state in which it 
1. does not accept changes to the name space (read-only) 
2. does not replicate or delete blocks. 
Safe mode is entered automatically at Namenode startup, and leaves safe mode automatically when the configured minimum percentage of blocks satisfies the minimum replication condition. Safe mode can also be entered manually, but then it can only be turned off manually as well.
-refreshNodes	Re-read the hosts and exclude files to update the set of Datanodes that are allowed to connect to the Namenode and those that should be decommissioned or recommissioned.
-finalizeUpgrade	Finalize upgrade of HDFS. Datanodes delete their previous version working directories, followed by Namenode doing the same. This completes the upgrade process.
-upgradeProgress status | details | force	Request current distributed upgrade status, a detailed status or force the upgrade to proceed.
-metasave filename	Save Namenode's primary data structures to <filename> in the directory specified by hadoop.log.dir property. <filename> will contain one line for each of the following 
1. Datanodes heart beating with Namenode
2. Blocks waiting to be replicated
3. Blocks currrently being replicated
4. Blocks waiting to be deleted
-setQuota <quota> <dirname>...<dirname>	Set the quota <quota> for each directory <dirname>. The directory quota is a long integer that puts a hard limit on the number of names in the directory tree.
Best effort for the directory, with faults reported if
1. N is not a positive integer, or
2. user is not an administrator, or
3. the directory does not exist or is a file, or
4. the directory would immediately exceed the new quota.
-clrQuota <dirname>...<dirname>	Clear the quota for each directory <dirname>.
Best effort for the directory. with fault reported if
1. the directory does not exist or is a file, or
2. user is not an administrator.
It does not fault if the directory has no quota.
-help [cmd]	Displays help for the given command or all commands if none is specified.

```


# Diskbalancer

```sh
hdfs diskbalancer -plan node1.mycluster.com

The command accepts Generic Options.

The plan command also has a set of parameters that allows user to control the output and execution of the plan.

COMMAND_OPTION	Description
-out	Allows user to control the output location of the plan file.
-bandwidth	Since datanode is operational and might be running other jobs, diskbalancer limits the amount of data moved per second. This parameter allows user to set the maximum bandwidth to be used. This is not required to be set since diskBalancer will use the default bandwidth if this is not specified.
-thresholdPercentage	Since we operate against a snap-shot of datanode, the move operations have a tolerance percentage to declare success. If user specifies 10% and move operation is say 20GB in size, if we can move 18GB that operation is considered successful. This is to accommodate the changes in datanode in real time. This parameter is not needed and a default is used if not specified.
-maxerror	Max error allows users to specify how many block copy operations must fail before we abort a move step. Once again, this is not a needed parameter and a system-default is used if not specified.
-v	Verbose mode, specifying this parameter forces the plan command to print out a summary of the plan on stdout.
-fs	- Specifies the namenode to use. if not specified default from config is used.
The plan command writes two output files. They are <nodename>.before.json which captures the state of the cluster before the diskbalancer is run, and <nodename>.plan.json.
```

# haadmin

```sh
hdfs haadmin -checkHealth <serviceId>
    hdfs haadmin -failover [--forcefence] [--forceactive] <serviceId> <serviceId>
    hdfs haadmin -getServiceState <serviceId>
    hdfs haadmin -help <command>
    hdfs haadmin -transitionToActive <serviceId> [--forceactive]
    hdfs haadmin -transitionToStandby <serviceId>
COMMAND_OPTION	Description
-checkHealth	check the health of the given NameNode
-failover	initiate a failover between two NameNodes
-getServiceState	determine whether the given NameNode is Active or Standby
-transitionToActive	transition the state of the given NameNode to Active (Warning: No fencing is done)
-transitionToStandby	transition the state of the given NameNode to Standby (Warning: No fencing is done)
```

# fsck

```sh
hadoop fsck [GENERIC_OPTIONS] <path> [-move | -delete | -openforwrite] [-files [-blocks [-locations | -racks]]]

COMMAND_OPTION	Description
<path>	Start checking from this path.
-move	Move corrupted files to /lost+found
-delete	Delete corrupted files.
-openforwrite	Print out files opened for write.
-files	Print out files being checked.
-blocks	Print out block report.
-locations	Print out locations for every block.
-racks	Print out network topology for data-node locations.
```

# version

```sh
hdfs version(to check hdfs version)
```













