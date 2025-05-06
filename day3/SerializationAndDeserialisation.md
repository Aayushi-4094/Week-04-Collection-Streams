When we create the class and its object , so when the program gets excecuted or stops then-(allowing the program to complete its current tasks, release resources, and perform any necessary cleanup operations before exiting. Methods like Thread.interrupt() or using flags to signal threads to stop are common ways to achieve this.) then its objects also gets deleted by itself, Now when we want to class the class without recreating its objects , then we use serialization.

Note - terminates means - implies an abrupt and immediate halt to the execution. This can be achieved using System.exit(), which forcefully terminates the Java Virtual Machine (JVM) and stops the program without necessarily allowing for cleanup.


SERIALISATION - it is a concept of converting an object into a sequence of bytes which can be persisted to a disk or database or can be sent through streams.
DESERIALISATION - it is process of creating an object from the sequence of bytes.

The class or program should implement the interface called java.io.Serializable or its sub interface called java.io.Externalizable interface
Serialisation is a jvm independent process, meaning the object can be serialised on one platform and deserialised on an entirely different platform.
Classes ObjectInputStream and ObjectOutputStream are high level streams that contaon the methods for serializing and deserializing an object.