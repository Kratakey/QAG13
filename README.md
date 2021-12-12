
## :atom: Стек


<p>
<img width="5%" title="IntelliJ IDEA" src="img/Intelij_IDEA.svg">
<img width="5%" title="Java" src="img/Java.svg">
<img width="5%" title="Selenide" src="img/Selenide.svg">
<img width="5%" title="Selenoid" src="img/Selenoid.svg">
<img width="5%" title="Allure Report" src="img/Allure_Report.svg">
<img width="5%" title="Gradle" src="img/Gradle.svg">
<img width="5%" title="JUnit5" src="img/JUnit5.svg">
<img width="5%" title="Github" src="img/Git.svg">
<img width="5%" title="Jenkins" src="img/Jenkins.svg">  
<img width="5%" title="REST-Assured" src="img/Rest-Assured.svg">
<img width="5%" title="Allure TestOps" src="img/Allure_EE.svg">
<img width="5%" title="Jira" src="img/Jira.svg">
<img width="5%" title="Telegram" src="img/Telegram.svg">
</p>

## :desktop_computer: Запуск тестов из командной строки

Запуск тестов с remote.properties:
```bash
gradle clean test
```

Запуск тестов без remote.properties:
```bash
gradle clean test
-Dbrowser={BROWSER}
-DbrowserVersion={BROWSER_VERSION}
-DbrowserSize={BROWSER_SIZE}
-DbrowserMobileView={BROWSER_MOBILE}
-DremoteDriverUrl=https://{login}:{password}@{REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://{REMOTE_DRIVER_URL}/video/
-Dthreads={THREADS}
```

Ключи:
* Dbrowser - браузер, в котором будут выполняться тесты (по-умолчанию chrome)
* DbrowserVersion - версия браузера (по-умолчанию 91.0)
* DbrowserSize - разрешение окна браузера (по-умолчанию 1920x1080)
* DbrowserMobileView - формат устройства, на котором будут проводиться тесты
* DremoteDriverUrl - логин, пароль и адрес удаленного сервера, где будут выполняться тесты (по-умолчанию https://selenoid.autotests.cloud/wd/hub/)
* DvideoStorage - хранилище видео выполненных тестов (по-умолчанию https://selenoid.autotests.cloud/video/)
* Dthreads - количество параллельных потоков выполняющихся тестов (по-умолчанию 5)

Allure отчет:
```bash
allure serve build/allure-results
```