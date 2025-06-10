name := "playapp1"
version := "1.0"
scalaVersion := "2.13.16"

enablePlugins(PlayJava)

libraryDependencies ++= Seq(
  guice,
  jdbc,
  "org.hibernate.orm" % "hibernate-core" % "6.4.4.Final",
  "jakarta.persistence" % "jakarta.persistence-api" % "3.1.0",
  "mysql" % "mysql-connector-java" % "8.0.33"
)
