name := "Settlers of Catan Leader Board"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  cache,
  filters,
  javaJdbc,
  javaCore,
  ws,
  "com.h2database" % "h2" % "1.4.181",
  "org.springframework" % "spring-context" % "4.1.1.RELEASE",
  "org.springframework" % "spring-orm" % "4.1.1.RELEASE",
  "org.springframework" % "spring-jdbc" % "4.1.1.RELEASE",
  "org.springframework" % "spring-tx" % "4.1.1.RELEASE",
  "org.springframework" % "spring-expression" % "4.1.1.RELEASE",
  "org.springframework" % "spring-aop" % "4.1.1.RELEASE",
  "org.springframework" % "spring-test" % "4.1.1.RELEASE" % "test",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final",
  "com.novocode" % "junit-interface" % "0.8" % "test->default",
  "mysql" % "mysql-connector-java" % "5.1.27",
  "org.webjars" % "bootstrap" % "2.1.1"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)

