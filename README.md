# suprsend-rn-sdk

Suprsend SDK for React Native Applications

Refer full documentation [here](https://docs.suprsend.com/docs/react-native)

## Android Setup

### 1. Installation

#### Step 1. Install Package using npm / yarn

```sh
npm install @suprsend/react-native-sdk
```

#### Step 2. Add mavenCentral dependency in project level build.gradle

Inside allprojects repositories add the below mentioned line as android sdk is available at mavenCentral repository

```java
allprojects {
        repositories {
            ...
            mavenCentral()
        }
    }
```

#### Step 3. Add Android sdk dependency inside app level build.gradle

Add following line of code inside dependencies in app build.gradle

```java
dependencies {
            ...
            implementation 'com.suprsend:android:0.1Beta10'
    }
```

 NOTE: If you get any error regarding minSdkVersion please update it to 19 or more

### 2. Initialisation

#### Step 1. Initialise the android sdk in MainApplication.java inside onCreate method and just above super.onCreate() line. You can find workspace_key and workspace_secret in dashboard.

```java
import app.suprsend.SSApi; // import sdk
...
SSApi.Companion.init(this, workspace_key, workspace_secret); // inside onCreate method just above super.onCreate() line
```

#### Step 2. Import SDK in Javascript side like below and call the Suprsend events
```js
import suprsend from "@suprsend/react-native-sdk";
```

NOTE: If you face any issue in installation or integration please refer the [example folder](https://github.com/suprsend/suprsend-rn-sdk/tree/main/example) in respository where you can find the integration of sdk in example application.


## iOS Setup

### 1. Installation

#### Step 1. Install Package using npm / yarn

Please skip this step if you have already installed this package for android setup
```sh
npm install @suprsend/react-native-sdk
```

#### Step 2. Adding swift support and Bridge header
Our iOS SDK is written in swift language so it's necessary to add swift support in React native project as react native uses Objective-C for iOS. This is just a [few steps process](https://docs.suprsend.com/docs/swift-modules-support).

#### Step 3. Changes in PodFile and Run pod Install
SuprSend sdk needs iOS platform version of 13 or above, so check it inside PodFile and change if its less than 13.0 and then run **pod install**  from inside iOS folder.
```ruby
platform :ios, '13.0' // this version has to be 13 or greater
```

### 2. Initialization

#### Step 1. In AppDelegate.m add the below mentioned code inside *didFinishLaunchingWithOptions* method,  just before returning YES like in code below. 
```objective-c
#import <UserNotifications/UserNotifications.h> //add this, needed as sdk internally depends on this package
#import <SuprSendSdk/SuprSendSdk-Swift.h> //add this

...

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
  ...
  SuprSendSDKConfiguration* configuration = [[SuprSendSDKConfiguration alloc] initWithKey:@workspace_key secret:@workspace_secret]; // add this line
  [SuprSend.shared configureWithConfiguration:configuration launchOptions:launchOptions]; // add this line
  return YES;
```
Replace workspace_key and workspace_secret with your values. You will get  workspace_key and workspace_secret from [client dashboard](https://app.suprsend.com/).

NOTE: If you face any issue in installation or integration please refer the [example folder](https://github.com/suprsend/suprsend-rn-sdk/tree/main/example) in respository where you can find the integration of sdk in example application.

## License

MIT
