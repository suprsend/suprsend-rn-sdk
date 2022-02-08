import { NativeModules } from 'react-native';

const SuprsendRnSdk = NativeModules.SuprsendRnSdk;

enum LogLevel {
  VERBOSE,
  DEBUG,
  INFO,
  ERROR,
  OFF,
}

function constructObject(key: String | Object, value: any): Object {
  let response: { [key: string]: any } = {};
  if (typeof key === 'string' && value !== undefined) {
    response[key] = value;
  } else if (typeof key === 'object') {
    response = key;
  }
  return response;
}

function constructArray(key: string[] | string): string[] {
  let response: string[] = [];
  if (typeof key === 'string') {
    response.push(key);
  } else if (Array.isArray(key)) {
    response = key;
  }
  return response;
}

const user = {
  set: function (key: string | Object, value: any) {
    const properties = constructObject(key, value);
    SuprsendRnSdk.set(properties);
  },

  setOnce: function (key: string | Object, value: any) {
    const properties = constructObject(key, value);
    SuprsendRnSdk.setOnce(properties);
  },

  increment: function (key: string | Object, value: number) {
    const properties = constructObject(key, value);
    SuprsendRnSdk.increment(properties);
  },

  append: function (key: string | Object, value: any) {
    const properties = constructObject(key, value);
    SuprsendRnSdk.append(properties);
  },

  remove: function (key: string | Object, value: any) {
    const properties = constructObject(key, value);
    SuprsendRnSdk.remove(properties);
  },

  unSet: function (key: string[] | string) {
    const properties = constructArray(key);
    SuprsendRnSdk.unSet(properties);
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
  initXiaomi: function (appId: string, apiKey: string) {
    SuprsendRnSdk.initXiaomi(appId, apiKey);
  },

  identify: function (unique_id: any) {
    SuprsendRnSdk.identify(unique_id);
  },

  setLogLevel: function (LogType: LogLevel) {
    SuprsendRnSdk.setLogLevel(LogLevel[LogType]);
  },

  user: user,

  track: function (eventName: string, properties?: Object) {
    SuprsendRnSdk.track(eventName, properties);
  },

  setSuperProperties: function (key: string | Object, value: any) {
    const properties = constructObject(key, value);
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

  purchaseMade: function (properties: Object) {
    SuprsendRnSdk.purchaseMade(properties);
  },

  showNotification: function (payload: { data: { supr_send_n_pl: string } }) {
    SuprsendRnSdk.showNotification(payload.data.supr_send_n_pl);
  },
};

export default Suprsend;
