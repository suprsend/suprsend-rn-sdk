import { NativeModules } from 'react-native';

const SuprsendRnSdk = NativeModules.SuprsendRnSdk;

const user = {
  set: function (properties: Object) {
    SuprsendRnSdk.set(properties);
  },

  setOnce: function (properties: Object) {
    SuprsendRnSdk.setOnce(properties);
  },

  increment: function (properties: { [key: string]: number }) {
    SuprsendRnSdk.increment(properties);
  },

  append: function (properties: Object) {
    SuprsendRnSdk.append(properties);
  },

  remove: function (properties: Object) {
    SuprsendRnSdk.remove(properties);
  },

  unSet: function (keys: string[]) {
    SuprsendRnSdk.unSet(keys);
  },
  setEmail: function (email: string) {
    SuprsendRnSdk.setEmail(email);
  },

  unSetEmail: function (email: string) {
    SuprsendRnSdk.unSetEmail(email);
  },

  setSms: function (mobile: string) {
    SuprsendRnSdk.setSms(mobile);
  },

  unSetSms: function (mobile: string) {
    SuprsendRnSdk.unSetSms(mobile);
  },

  setWhatsApp: function (mobile: string) {
    SuprsendRnSdk.setWhatsApp(mobile);
  },

  unSetWhatsApp: function (mobile: string) {
    SuprsendRnSdk.unSetWhatsApp(mobile);
  },

  setAndroidFcmPush: function (token: string) {
    SuprsendRnSdk.setAndroidFcmPush(token);
  },

  unSetAndroidFcmPush: function (token: string) {
    SuprsendRnSdk.unSetAndroidFcmPush(token);
  },

  setAndroidXiaomiPush: function (token: string) {
    SuprsendRnSdk.setAndroidXiaomiPush(token);
  },

  unSetAndroidXiaomiPush: function (token: string) {
    SuprsendRnSdk.unSetAndroidXiaomiPush(token);
  },
};

const Suprsend = {
  initializeSDK: function (
    workspace_key: string,
    workspace_secret: string,
    base_url?: string
  ) {
    SuprsendRnSdk.initializeSDK(workspace_key, workspace_secret, base_url);
  },

  identify: function (unique_id: any) {
    SuprsendRnSdk.identify(unique_id);
  },

  user: user,

  track: function (eventName: string, properties?: Object) {
    SuprsendRnSdk.track(eventName, properties);
  },

  setSuperProperties: function (properties: Object) {
    SuprsendRnSdk.setSuperProperties(properties);
  },

  unSetSuperProperty: function (key: string) {
    SuprsendRnSdk.unSetSuperProperty(key);
  },

  flush: function () {
    SuprsendRnSdk.flush();
  },

  reset: function () {
    SuprsendRnSdk.reset();
  },
};

export default Suprsend;
