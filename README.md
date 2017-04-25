# vavedem


<h2>Prerechizite</h2>


<ul>
    <li><code><a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">jdk</a></code> incepand cu versiunea 7</li>
    <li><code><a href="https://maven.apache.org/index.html">maven</a></code> - java build tool</li>
    <li><code><a href="https://tomcat.apache.org/download-80.cgi">apache tomcat</a></code> - webserver </li>  
    
</ul>


<h2>Dev</h2>


 <p> Pentru a porni aplicatia sunt necesari urmatorii pasi: </p>
 

<ul>
    <li><code># cd va-vedem-api </code></li>
    <li><code># mvn clean install </code></li>
    <li><code># cp vavedem-restapi/target/vavedem.war {tomcat_home}/webapps/ </code></li>
</ul>


 <p> Exemplu acces enpoint: <code> http://localhost:8080/vavedem/primarii </code> </p>




