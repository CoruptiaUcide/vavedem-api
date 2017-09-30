# vavedem


<h2>Required:</h2>


<ul>
    <li><code><a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">jdk</a></code> incepand cu versiunea 7</li>
    <li><code><a href="https://maven.apache.org/index.html">maven</a></code> - java build tool</li>
    <li><code><a href="https://tomcat.apache.org/download-80.cgi">apache tomcat</a></code> - webserver </li>
    <li><code><a href="https://dev.mysql.com/downloads/">postgres</a>MySql</li>
</ul>


<h1>Dev</h1>

 <p> Swagger: <code> http://localhost:8080/v2/api-docs </code> </p>

 <p> To start the application locally, please follow the above steps: </p>
 
 
 <p> Connect to the MySql DB: </p>
 <ul>
    <li><code> username=root</code></li>
    <li><code> password=<somePass></code></li>
    <li><code> host=localhost</code></li>
    <li><code> port=3306</code></li>
    <li><code> database=weesee</code></li>
</ul>

<ul>
    <li><code># cd va-vedem-api </code></li>
    <li><code># mvn clean install </code></li>
    <li><code># cp vavedem-restapi/target/vavedem.war {tomcat_home}/webapps/ </code></li>
</ul>


 




