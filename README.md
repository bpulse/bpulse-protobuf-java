# bpulse-protobuf-java

bpulse-protobuf-java is the model interface which bpulse relies on in order to send messages with pulses
to the collector, it is a mandatory dependency of [bpulse-sdk-java](https://github.com/bpulse/bpulse-sdk-java)  or bpulse-java-client in order to compile it and send messages to the collector.

# Requirements

* Linux Packages (Linux only):
  * autoconf
  * libtool
* [Apache Maven 3.x.x](https://maven.apache.org/download.cgi)
* [JDK version 1.7+](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)

## Protocol Buffers 2.5.0 

In order to build this project you need to install protoc on your machine, it is very important that you use specifically the *2.5.0* version otherwise the project might not compile. 

The instructions for each OS are the following:

### Windows
Use the provided distribution in this repository under /protobuf/windows/protoc-2.5.0-win32.rar
unpack it wherever you want.
Edit your environment variables adding one that points to the unpackaged folder like **PROTOC_HOME**

e.g. **PROTOC_HOME**=C:\software\protoc

Then edit your **PATH** variable appending the new variable

e.g. **PATH**=\[other_variables];%**PROTOC_HOME**%

You can check if the installation was ok by opening a terminal and executing the following command:

```
protoc --version
```
You should see this output:
```
libprotoc 2.5.0
```

### Linux
Use the provided distribution in this repository under /protobuf/linux/protobuf-2.5.0.tar.gz
unpackit wherever you want.

**Note:** At this point you should have installed the two linux packages mentioned above.

Open a terminal and go to where you unpacked the file, then execute the following commands (one by one):

```
$ ./autogen.sh
$ ./configure
$ ./make
$ ./make install
```

**Note:** The make install commad may require sudo

After that, you can check if everything succeded by executin the command:

```
$ protoc --version
```

If you don't receive a message like:

```
libprotoc 2.5.0
```

Then execute the following:

```
$ sudo ldconfig
```
And check again.

### OSX
The easies way is to use homebrew package manager to install it, please take a look at [this post](http://stackoverflow.com/questions/21775151/installing-google-protocol-buffers-on-mac)


Compilation

Once you checked out the sources, in a terminal go to the repo folder and type

```
$ mvn clean install
```

It's done!, now you can build the bpulse-sdk-java

# Contact us

You can reach the Developer Platform team at jtenganan@innova4j.com

# License

The Bpulse Protobuf Java is licensed under the Apache License 2.0. Details can be found in the LICENSE file.

