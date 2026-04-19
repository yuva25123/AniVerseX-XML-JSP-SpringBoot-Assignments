# AniVerseX Assignment-2 Offline Runbook (All 8 Questions)

Use this file when internet is weak.

## 0) One-time setup per new PowerShell window
```powershell
$root   = "C:\Users\Yuva Dharshini . C\OneDrive\Documents\Playground\AniVerseX-XML-JSP-SpringBoot-Assignments\assignment-2"
$jdk    = "C:\Program Files\Microsoft\jdk-17.0.17.10-hotspot"
$mvnd   = "C:\Program Files\maven-mvnd-1.0.5-windows-amd64\bin"
$tomcat = "C:\tomcat-install\apache-tomcat-10.1.30"
$basex  = "C:\Users\Yuva Dharshini . C\BaseX\bin"

$env:JAVA_HOME = $jdk
$env:JRE_HOME = $jdk
$env:CATALINA_HOME = $tomcat
$env:CATALINA_BASE = $tomcat
$env:Path = "$env:JAVA_HOME\bin;$mvnd;$basex;$env:Path"
```

## 1) Q1 Spring Boot CRUD
```powershell
Set-Location "$root\01-springboot-crud"
mvnd --% -Dspring-boot.run.arguments=--server.port=8082 spring-boot:run
```
Open:
- http://localhost:8082/
- http://localhost:8082/anime
- http://localhost:8082/reviews

Stop: `Ctrl + C`

## 2) Q2 XML + DTD
```powershell
$q2 = "$root\02-xml-dtd"
Set-Location $q2
code "$q2\anime-catalog.xml"
code "$q2\anime.dtd"
Start-Process "$q2\xml-viewer.html"
```
Validate:
```powershell
$xmlPath = "$q2\anime-catalog.xml"
$settings = New-Object System.Xml.XmlReaderSettings
$settings.DtdProcessing = [System.Xml.DtdProcessing]::Parse
$settings.ValidationType = [System.Xml.ValidationType]::DTD
$script:hasErrors = $false
$handler = [System.Xml.Schema.ValidationEventHandler]{ param($s,$e) $script:hasErrors=$true; Write-Host "$($e.Severity): Line $($e.Exception.LineNumber), Pos $($e.Exception.LinePosition) - $($e.Message)" -ForegroundColor Red }
$settings.add_ValidationEventHandler($handler)
$reader = [System.Xml.XmlReader]::Create($xmlPath, $settings)
while($reader.Read()){}
$reader.Close()
if(-not $script:hasErrors){ Write-Host "DTD Validation Successful" -ForegroundColor Green }
```

## 3) Q3 XPath
```powershell
$q3 = "$root\03-xpath"
$xml = "$q3\anime.xml"
Set-Location $q3
```
```powershell
"1)"; Select-Xml -Path $xml -XPath '/animeCollection/anime/title' | % { $_.Node.InnerText }
"2)"; Select-Xml -Path $xml -XPath '/animeCollection/anime[number(rating) > 8.5]/title' | % { $_.Node.InnerText }
"3)"; Select-Xml -Path $xml -XPath '/animeCollection/anime[number(episodes) < 100]/title' | % { $_.Node.InnerText }
"4)"; Select-Xml -Path $xml -XPath '/animeCollection/anime[genre="Action"]/title' | % { $_.Node.InnerText }
"5)"; (Select-Xml -Path $xml -XPath '/animeCollection/anime').Count
"6)"; Select-Xml -Path $xml -XPath '/animeCollection/anime/title | /animeCollection/anime/shortReview' | % { $_.Node.InnerText }
"7)"; Select-Xml -Path $xml -XPath '/animeCollection/anime[not(rating < /animeCollection/anime/rating)]/animeId' | % { $_.Node.InnerText }
```

## 4) Q4 XQuery (BaseX)
```powershell
$q4 = "$root\04-xquery"
Set-Location $q4
basex -i anime.xml q1-all-titles.xq
basex -i anime.xml q2-rating-gt-8_5.xq
basex -i anime.xml q3-episodes-lt-100.xq
basex -i anime.xml q4-genre-action.xq
basex -i anime.xml q5-count-anime.xq
basex -i anime.xml q6-title-and-review.xq
basex -i anime.xml q7-highest-rated-animeid.xq
```

Note: if prompt becomes `>`, you are inside BaseX console; type `exit` to return to PowerShell.

## 5) Q5 XML Schema (XSD)
```powershell
$q5 = "$root\05-xml-schema"
$xmlPath = "$q5\anime-data.xml"
$xsdPath = "$q5\anime.xsd"
Set-Location $q5
```
```powershell
$settings = New-Object System.Xml.XmlReaderSettings
$settings.ValidationType = [System.Xml.ValidationType]::Schema
$settings.Schemas.Add($null, $xsdPath) | Out-Null
$script:hasErrors = $false
$handler = [System.Xml.Schema.ValidationEventHandler]{ param($s,$e) $script:hasErrors=$true; Write-Host "$($e.Severity): Line $($e.Exception.LineNumber), Pos $($e.Exception.LinePosition) - $($e.Message)" -ForegroundColor Red }
$settings.add_ValidationEventHandler($handler)
$reader = [System.Xml.XmlReader]::Create($xmlPath, $settings)
while($reader.Read()){}
$reader.Close()
if(-not $script:hasErrors){ Write-Host "XSD Validation Successful" -ForegroundColor Green }
```

## 6) Q6 XML Parser (Java DOM)
```powershell
$q6 = "$root\06-xml-parser"
Set-Location $q6
if (!(Test-Path "$q6\out")) { New-Item -ItemType Directory -Path "$q6\out" | Out-Null }
javac -d out src\AniVerseXmlDomParser.java
java -cp out AniVerseXmlDomParser
```

## 7) Q7 XML + Java + JSP (Tomcat)
```powershell
$q7  = "$root\07-xml-java-jsp"
$app = "aniversex-xml-java-jsp"
Set-Location $q7
New-Item -ItemType Directory -Path "$q7\WEB-INF\classes" -Force | Out-Null
javac -cp "$tomcat\lib\servlet-api.jar" -d "$q7\WEB-INF\classes" "$q7\src\com\aniversex\xmljsp\Anime.java" "$q7\src\com\aniversex\xmljsp\AnimeXmlReaderServlet.java"
$deploy = "$tomcat\webapps\$app"
if (Test-Path $deploy) { Remove-Item $deploy -Recurse -Force }
New-Item -ItemType Directory -Path $deploy | Out-Null
Copy-Item "$q7\*" "$deploy\" -Recurse -Force
& "$tomcat\bin\startup.bat"
```
Open:
- http://localhost:8080/aniversex-xml-java-jsp/
- http://localhost:8080/aniversex-xml-java-jsp/anime-list

Stop Tomcat:
```powershell
& "$tomcat\bin\shutdown.bat"
```

## 8) Q8 JSP + JDBC + Spring Boot
Run on 8081 (to avoid Tomcat conflict on 8080):
```powershell
Set-Location "$root\08-jsp-jdbc-springboot"
mvnd --% -Dspring-boot.run.arguments=--server.port=8081 spring-boot:run
```
Open:
- http://localhost:8081/
- http://localhost:8081/anime

Stop: `Ctrl + C`

## Emergency commands
Check ports:
```powershell
netstat -ano | findstr :8080
netstat -ano | findstr :8081
```
Kill PID:
```powershell
taskkill /PID <PID> /F
```

MySQL FK cleanup (if drop-table error):
```sql
USE aniversex_db;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS anime;
SET FOREIGN_KEY_CHECKS = 1;
```
