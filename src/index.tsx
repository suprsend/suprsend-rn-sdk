import { NativeModules } from 'react-native';

const SuprsendRnSdk = NativeModules.SuprsendRnSdk;

const Suprsend = {
  // method to initialize sdk with given key and secret
  initializeSDK: function (
    workspace_key: string,
    workspace_secret: string,
    base_url?: string
  ) {
    SuprsendRnSdk.initializeSDK(workspace_key, workspace_secret, base_url);
  },

  // method to identify the user
  identify: function (unique_id: any) {
    SuprsendRnSdk.identify(unique_id);
  },

  // method to reset user
  reset: function () {
    SuprsendRnSdk.reset();
  },
};

export default Suprsend;
