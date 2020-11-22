# java-single-file

The [JEP 330: Launch Single-File Source-Code Programs](https://openjdk.java.net/jeps/330) was introduced in Java 11 and provides the ability to run a Java single-file source code directly without any compilation.

The files for the examples on this page can be found in the [./src](./src directory).

## Single Class

A Java file can be executed without compiling by calling the `.java` file using just `java`:

```JAVA
java Javafile.java
```

Note that If both .class and .java files exist in the classpath, the launcher enforces usage of the class file. Also note that it's not necessary that the class name in the file matches the file name as there are no `.class` files generated.

Run the example file containing a single Java class:

```JAVA
java SingleClassExample.java argument1
```

Note that the program requires an argument, which is provided the same way as for compiled Java programs.

## Files Without Extension

If the Java file lacks the .java extension, the `--source` option must be used to force source-file mode:

```BASH
java --source 11 NoFileEnding argument1
```

## Multiple Classes

If a Java file contains multiple classes, the `main` method should be defined in the first class in the source file.

A file executed with `java` *can* have multiple public classes. This is opposed to compiled Java, where *at most one* top level class can be public. Other top level classes must be `package private`. Private classes will not work, since `.class` files are generated for each top level class found in a source file.

Run the example with:

```BASH
java MultiClassExample.java
```

## Modules

Using modularized code works as the in-memory compiled code runs as part of an unnamed module with the option `--add-modules=ALL-DEFAULT` which gives access to the full range of modules that ship with the JDK. This enables the code to use different modules without the need to explicitly declare dependency using module-info.java. This allows test new features provided by different modules without having to create a module of your own.

Run the example with:

```BASH
java ModuleExample.java
```

Note that the above code also works when compiled. In Java 9, all code is required to be placed in modules. When you execute code that is not in a module, the code is loaded from the classpath and placed in the `unnamed module`, which can read all named modules.

## Scripting

By allowing running Java files without compiling, Java 11 introduces support for scripting, as in using "shebang" files, which are files that start with "#!". Since `--source` must be provided, the following shebang syntax must be used (Linux):

```BASH
#!/usr/bin/env -S java --source 11
```

Virtual Machine (VM) options are supported, asn should be added after the manadatory `--source` option. The supported VM opations are: `--class-path`, `--module-path`, `--add-exports`, `--add-modules`, `--limit-modules`, `--patch-module`, `--upgrade-module-path` or `--enable-preview`.

Remember to mark the script file as an executable:

```BASH
chmod +x <Filename>.<Extension>
```

Run the example with:

```BASH
$ chmod +x dirlist
$ ./dirlist
```

## Credits

The examples in this project is heavily inspired by [Running Single-file Programs without Compiling in Java 11](https://www.infoq.com/articles/single-file-execution-java11/).
