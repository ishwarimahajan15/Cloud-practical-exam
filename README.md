# Declarative Jenkins Pipeline Practical

This Maven application demonstrates a Jenkins declarative pipeline with:

- Pipeline Jenkinsfile loaded from SCM
- Checkout, Build, Test, Package, and Deploy stages
- JUnit test report publication
- JAR artifact archiving
- `ENVIRONMENT` choice parameter and `DEPLOY` boolean parameter
- Success/failure post actions
- Stage View status reporting

## Local commands

```powershell
.\mvnw.cmd test
.\mvnw.cmd package
java -jar target\declarative-pipeline-demo-1.0.0.jar Student
```

## Jenkins setup

1. Install Jenkins with the JDK 17 and Maven plugins/tools.
2. Configure a JDK 21 tool named `JDK21` and a Maven tool named `Maven` (the Maven installer can download Maven automatically).
3. Create a Pipeline job.
4. Set **Pipeline: Definition** to **Pipeline script from SCM**.
5. Choose Git and enter this repository URL.
6. Set **Script Path** to `Jenkinsfile`.
7. Run `Build with Parameters`.
