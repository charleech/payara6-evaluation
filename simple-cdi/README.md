# The Simeple CDI demonstration

## How to build

### Build with weld-se

```bash
mvn clean install -Darq-mode=weld-se -am
```

### Build with payara-managed (default)

```bash
export JAVA_TOOL_OPTIONS="-Djdk.util.zip.disableZip64ExtraFieldValidation=true \
--add-opens=java.base/java.io=ALL-UNNAMED"

mvn clean install -am
```

### Build with payara-micro

```bash
export JAVA_TOOL_OPTIONS="-Djdk.util.zip.disableZip64ExtraFieldValidation=true \
--add-opens=java.base/java.io=ALL-UNNAMED"

mvn clean install -Darq-mode=payara-micro -am
```

### Build with payara-embedded-all

```bash
export JAVA_TOOL_OPTIONS="-Djdk.util.zip.disableZip64ExtraFieldValidation=true \
--add-opens=java.base/java.io=ALL-UNNAMED \
--add-opens=java.base/sun.net.www.protocol.jar=ALL-UNNAMED \
--add-opens=java.base/java.net=ALL-UNNAMED \
--add-opens=java.naming/javax.naming.spi=ALL-UNNAMED"

mvn clean install -Darq-mode=payara-embedded -am
```
