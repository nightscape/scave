resolvers += Resolver.url(
  "bintray-sbt-plugin-releases",
    url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(
      Resolver.ivyStylePatterns)

addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.2.7")
