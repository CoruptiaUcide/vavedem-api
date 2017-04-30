# vavedem


<h2>Prerechizite</h2>


<ul>
    <li><code><a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">jdk</a></code> incepand cu versiunea 7</li>
    <li><code><a href="https://maven.apache.org/index.html">maven</a></code> - java build tool</li>
    <li><code><a href="https://tomcat.apache.org/download-80.cgi">apache tomcat</a></code> - webserver </li>
    <li><code><a href="https://www.postgresql.org/download/">postgres</a> | sudo pacman -S postgresql pgadmin3 | sudo apt-get install postgresql pgadmin3</code> - baza de date </li>  
    <li><code> sudo pacman -S tzdata </code> *linux only </li> 
</ul>


<h1>Dev</h1>

 <p> Swagger: <code> http://localhost:8080/v2/api-docs </code> </p>

 <p> Pentru a porni aplicatia sunt necesari urmatorii pasi: </p>
 
 
 <p> Setari pentru conexiune la postgres pe localhost: </p>
 <ul>
    <li><code> username=postgres</code></li>
    <li><code> password=postgres</code></li>
    <li><code> host=localhost</code></li>
    <li><code> port=5432</code></li>
    <li><code> database=postgres</code></li>
</ul>


<ul>
    <li><code># cd va-vedem-api </code></li>
    <li><code># mvn clean install </code></li>
    <li><code># cp vavedem-restapi/target/vavedem.war {tomcat_home}/webapps/ </code></li>
</ul>


 




