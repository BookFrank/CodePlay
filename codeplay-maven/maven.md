## Maven 打包相关

#### 1. 不使用插件

使用maven创建项目，pom.xml如下，

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>codeplay-maven</artifactId>
    <packaging>jar</packaging>
    <name>codeplay-maven</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.35</version>
        </dependency>
    </dependencies>
</project>
```

直接使用mvn package打包，项目中没有任何依赖和插件，打包完成后出现这两个文件夹和打包成的jar文件，

```shell
|target
    |classes
        -com/tazine/maven/App.class
    |generated-sources
- codeplay-maven.jar    
```

使用 `java -jar Codeplay-maven.jar` 执行，提示错误找不到主清单属性，说明打包后的jar包中的manifest文件中未指定main-class，解压jar包，

```html
Manifest-Version: 1.0
Archiver-Version: Plexus Archiver
Built-By: frank
Created-By: Apache Maven 3.3.9
Build-Jdk: 1.8.0_92


```

发现在MANIFEST.MF中确实没有main-class属性，因此先想办法把main-class加上。

#### 2. maven-jar-plugin

maven-jar-plugin用于生成META-INF/MANIFEST.MF文件的部分内容，<mainClass>com.tazine.XXX</mainClass>用来指定MANIFEST.MF中的Main-Class，<addClasspath>true</addClasspath>会在MANIFEST.MF加上Class-Path项并配置依赖包，<classpathPrefix>lib/</classpathPrefix>指定依赖包所在目录。

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>codeplay-maven</artifactId>
    <packaging>jar</packaging>
    <name>codeplay-maven</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.35</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>lib/</classpathPrefix>
                            <mainClass>com.tazine.maven.App</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

下面是通过maven-jar-plugin生成的MANIFEST.MF的片段，

```html
Class-Path: lib/commons-logging-1.2.jar lib/commons-io-2.4.jar  
Main-Class: com.xxg.Main
```

但是指定了主类以后，再使用 `java -jar Codeplay-maven.jar` ，按理说应该可以执行了，但是还是报错，报错找不到依赖的类库。因为maven-jar-plugin插件虽然指定了主类以及依赖的类库，但是并没有把项目所依赖的外部jar包移动到指定的lib目录中，这时候就要用到另外一个插件。

#### 3. maven-dependency-plugin

maven-dependency-plugin：只生成了MANIFEST.MF文件还不够，需要将依赖包拷贝到<outputDirectory>${project.build.directory}/lib</outputDirectory>指定的位置，即lib目录下。

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>codeplay-maven</artifactId>
    <packaging>jar</packaging>
    <name>codeplay-maven</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.35</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>lib/</classpathPrefix>
                            <mainClass>com.tazine.maven.App</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <executions>
                    <execution>
                        <id>copy-dependencies</id>
                        <phase>package</phase>
                        <goals>
                            <goal>copy-dependencies</goal>
                        </goals>
                        <configuration>
                              <outputDirectory>${project.build.directory}/lib</outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>

```

配置完成后，通过mvn package指令打包，会在target目录下生成jar包，并将依赖包拷贝到target/lib目录下，指定了Main-Class，有了依赖包，那么就可以直接通过java -jar xxx.jar运行jar包。

但是，这样打包也有问题，就是生成的jar包太多难以管理，可不可以把所有的依赖都打到一个jar包里去呢？

#### 4. maven-assembly-plugin

maven-assembly-plugin：打包后会在target目录下生成一个xxx-jar-with-dependencies.jar文件，这个文件不但包含了自己项目中的代码和资源，还包含了所有依赖包的内容。所以可以直接通过java -jar来运行

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>codeplay-maven</artifactId>
    <packaging>jar</packaging>
    <name>codeplay-maven</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.35</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                    <archive>
                        <manifest>
                            <mainClass>com.tazine.maven.App</mainClass>
                        </manifest>
                    </archive>
                </configuration>
                <executions>
                    <execution>
                        <id>make-assembly</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

解压打包完成的jar-with-dependencies.jar包，可以看到，

```shell
|META-INF
    |services
        -java.sql.driver
    -MANIFEST.MF
    -INDEX.LIST  包含每个已索引的 JAR 文件中包含的包或者类的名字
|com
    |mysql
    |tazine
|org
    |gjt
```

