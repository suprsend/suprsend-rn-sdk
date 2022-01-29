import { AppRegistry } from 'react-native';
import App from './src/App';
import { name as appName } from './app.json';
import Suprsend from '@suprsend/react-native-sdk';
import config from './config';

Suprsend.initializeSDK(
  config.workspace_key,
  config.workspace_secret,
  config.api_url
);

AppRegistry.registerComponent(appName, () => App);
