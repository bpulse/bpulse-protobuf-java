# bpulse-protobuf-java

bpulse-protobuf-java is the model interface which bpulse relies on in order to send messages with pulses
to the collector, it is a mandatory dependency of bpulse-java-client (link to repo) or bpulse-sdk-java (link to repo)
in order to compile it and send messages to the collector.

# Requirements

# Protocol Buffers
In order to build this project you need to install protoc on your machine, the instructions
for each OS are the following:

# Windows
Download the binary files from here (https://developers.google.com/protocol-buffers/docs/downloads)
the file name is something like protoc-2.x.x-win32.zip.
Unzip it wherever you want.
Edit your environment variables adding one that points to the unzipped folder like PROTOC_HOME
e.g. PROTOC_HOME=C:\software\protoc
Then edit your PATH variable appending the new variable
e.g. PATH=[other_variables];%PROTOC_HOME%

# Linux
The easiest way is to use the package manager to install the most recent version of protoc according
to the current distro repositories so for example:
In Debian like systems:
$ sudo apt-get install libprotoc7
In RedHat like systems:
$ sudo yum install libprotoc7

If that does not work or you need a specific version of protoc installed, you cand build from source
using the instructions of the official repository here (https://github.com/google/protobuf)

# OSX
The easies way is to use homebrew package manager to install the most recent version of protoc
available here, so for example:
$ brew install protobuf

If you need an specific version of protoc you can follow the steps described here (http://stackoverflow.com/questions/21775151/installing-google-protocol-buffers-on-mac)

If that does not work you can follow up the instructions in the official repository here (https://github.com/google/protobuf)

# Verification
You can check if the installation was successfull if when opening a terminal and type
$ protoc --version
Get an output like:
libprotoc 2.x.x

# Apache Maven
# Min JDK version 1.7

# Compilation

Once you checked out the sources, in a terminal go to the repo folder and type
$ mvn clean install

It's done, now you can build the bpulse-java-client or bpulse-sdk-java

# Contact us

You can reach the Developer Platform team at bpulse-devel@bpulse.me

# License

The Bpulse Protobuf Java is licensed under the Apache License 2.0. Details can be found in the LICENSE file.