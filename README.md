# suprsend-rn-sdk

Suprsend SDK for React Native Applications

## Installation

### 1. Install Package using npm / yarn

```sh
npm install @suprsend/react-native-sdk
```

### 2. Add mavenCentral dependency in project level build.gradle

Inside allprojects repositories add the below mentioned line as android sdk is available at jitpack repository

```java
allprojects {
        repositories {
            ...
            mavenCentral()
        }
    }
```

### 3. Add Android sdk dependency inside app level build.gradle

Add following line of code inside dependencies in app build.gradle

```java
dependencies {
            ...
            implementation 'com.suprsend:android:0.1Beta10'
    }
```

## Initialisation

Initialise the android sdk in MainApplication.java inside onCreate method and just above super.onCreate() line. You can find workspace_key and workspace_secret in dashboard.

```java
import app.suprsend.SSApi; // import sdk
...
SSApi.Companion.init(this, workspace_key, workspace_secret); // inside onCreate method just above super.onCreate() line
```

NOTE: If you face any issue in installation or integration please refer the [example folder](https://github.com/suprsend/suprsend-rn-sdk/tree/main/example) in respository where you can find the integration of sdk in example application.

## Usage

```js
import Suprsend from '@suprsend/react-native-sdk';

// ...

Suprsend.track('Hello World');
```

## License

MIT
