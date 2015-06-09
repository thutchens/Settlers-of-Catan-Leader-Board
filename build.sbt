name := "play-java-spring"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  cache,
  filters,
  javaJdbc,
  javaCore,
  javaWs % "test",
  "com.h2database" % "h2" % "1.4.181",
  "org.springframework" % "spring-context" % "4.1.1.RELEASE",
  "org.springframework" % "spring-orm" % "4.1.1.RELEASE",
  "org.springframework" % "spring-jdbc" % "4.1.1.RELEASE",
  "org.springframework" % "spring-tx" % "4.1.1.RELEASE",
  "org.springframework" % "spring-expression" % "4.1.1.RELEASE",
  "org.springframework" % "spring-aop" % "4.1.1.RELEASE",
  "org.springframework" % "spring-test" % "4.1.1.RELEASE" % "test",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final",
  "ch.qos.logback.contrib" % "logback-json-core"    % "0.1.2" % "runtime",
  "ch.qos.logback.contrib" % "logback-json-classic" % "0.1.2" % "runtime",
  "ch.qos.logback.contrib" % "logback-jackson"      % "0.1.2" % "runtime"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.27"

libraryDependencies += "org.webjars" % "bootstrap" % "2.1.1"
