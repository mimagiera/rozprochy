# Zookeeper client based on 
[ZooKeeper Java Example](https://zookeeper.apache.org/doc/r3.3.5/javaExample.html)

## Features
* when zookeeper node with name specified by argument `zNode` exists,
program specified by argument `program` is executed.
* when node with name specified by argument `zNode` is deleted, program is stopped.
* when new child is added to a node, number of children is shown.
* in file specified by argument `filename` data of `zNode` is stored
* typing anything shows a tree of nodes starting with node specified by argument `zNode`
e.g.: 
```
Tree for node /z: 
   /z
   /z/jarek
   /z/jarek/andrzej
   /z/jarek/andrzej/kazimierz
   /z/angela
   /z/wladyslaw
   /z/wladyslaw/antoni
```

## How to run:
* required Java 14
* run zookeeper server
* run this app with args: `connectionString zNode filename program`,
e.g `127.0.0.1:2181 /z data.txt "./src/hello.sh"`