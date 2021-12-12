
## :atom: Стек

<p  align="center"

<code><img width="5%" title="IntelliJ IDEA" src="https://upload.wikimedia.org/wikipedia/commons/9/9c/IntelliJ_IDEA_Icon.svg"></code>
<code><img width="5%" title="Java" src="https://upload.wikimedia.org/wikipedia/ru/3/39/Java_logo.svg"></code>
<code><img width="5%" title="Selenide" src="images/daramirra_selenide-logo.svg"></code>
<code><img width="5%" title="REST-Assured" src="images/daramirra_rest-assured-logo.svg"></code>
<code><img width="5%" title="Selenoid" src="images/daramirra_selenoid-logo.svg"></code>
<code><img width="5%" title="Gradle" src="images/daramirra_gradle-logo.svg "></code>
<code><img width="5%" title="JUnit5" src="images/daramirra_junit5-logo.svg"></code>
<code><img width="5%" title="Allure Report" src="images/daramirra_allure-Report-logo.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/daramirra_allure-ee-logo.svg"></code>
<code><img width="5%" title="Github" src="images/daramirra_git-logo.svg"></code>
<code><img width="5%" title="Jenkins" src="images/daramirra_jenkins-logo.svg"></code>
<code><img width="5%" title="Jira" src="images/daramirra_jira-logo.svg"></code>
<code><img width="5%" title="Telegram" src="images/daramirra_Telegram.svg"></code>
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