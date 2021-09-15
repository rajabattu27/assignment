#!groovy

WebTest {
    cron = "20 1 * * *"
    notifyChannel = "automation"
    mvnDebug = false
    executionEnvironment = "develop"
    cloudEnvironment = "develop"
    executeCrossBrowser = true
    buildNodeType = "azul-11-gp-small"
    retries = 3
    logLevel = "info"
    testRequest = '''
{
    "saucePlatform":"Windows 10",
    "sauceBrowser":"chrome",
    "sauceBrowserVersion":"latest",
    "testSuites": [
        "EncoreWebTests.xml"
    ]
}
'''
}