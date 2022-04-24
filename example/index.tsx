import { AppRegistry } from 'react-native';
import App from './src/App';
import { name as appName } from './app.json';
import Suprsend from '@suprsend/react-native-sdk';

// Suprsend.setLogLevel('VERBOSE');

AppRegistry.registerComponent(appName, () => App);
