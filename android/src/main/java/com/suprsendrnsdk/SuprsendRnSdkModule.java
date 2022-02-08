package com.suprsendrnsdk;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.module.annotations.ReactModule;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.suprsend.SSApi;
import app.suprsend.base.LogLevel;
import app.suprsend.notification.SSNotificationHelper;


@ReactModule(name = SuprsendRnSdkModule.NAME)
public class SuprsendRnSdkModule extends ReactContextBaseJavaModule {
  public static final String NAME = "SuprsendRnSdk";
  private final ReactApplicationContext context;
  private SSApi suprsendInstance;
  private LogLevel[] LogsList = LogLevel.values();

  public SuprsendRnSdkModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.context = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  private void getInstance() {
    if (suprsendInstance == null) {
      suprsendInstance = SSApi.Companion.getInstance();
    }
  }

  @ReactMethod
  public void setLogLevel(Integer logInteger) {
    getInstance();
    suprsendInstance.setLogLevel(LogsList[logInteger]);
  }

  @ReactMethod
  public void identify(String uniqueId) {
    getInstance();
    suprsendInstance.identify(uniqueId);
  }

  @ReactMethod
  public void set(ReadableMap properties) {
    if (properties == null) {
      return;
    }
    getInstance();
    JSONObject jsonData = convertMapToJson(properties);
    suprsendInstance.getUser().set(jsonData);
  }

  @ReactMethod
  public void setOnce(ReadableMap properties) {
    if (properties == null) {
      return;
    }
    getInstance();
    JSONObject jsonData = convertMapToJson(properties);
    suprsendInstance.getUser().setOnce(jsonData);
  }

  @ReactMethod
  public void increment(ReadableMap properties) {
    if (properties == null) {
      return;
    }
    getInstance();
    Map<String, Number> formattedMap = new HashMap<String, Number>();
    ReadableMapKeySetIterator iterator = properties.keySetIterator();
    while (iterator.hasNextKey()) {
      String key = iterator.nextKey();
      switch (properties.getType(key)) {
        case Number:
          formattedMap.put(key, properties.getDouble(key));
          break;
      }
    }
    suprsendInstance.getUser().increment(formattedMap);
  }

  @ReactMethod
  public void append(ReadableMap properties) {
    if (properties == null) {
      return;
    }
    getInstance();
    JSONObject jsonData = convertMapToJson(properties);
    suprsendInstance.getUser().append(jsonData);
  }

  @ReactMethod
  public void remove(ReadableMap properties) {
    if (properties == null) {
      return;
    }
    getInstance();
    JSONObject jsonData = convertMapToJson(properties);
    suprsendInstance.getUser().remove(jsonData);
  }

  @ReactMethod
  public void unSet(ReadableArray keys) {
    if (keys == null) {
      return;
    }
    getInstance();
    List<String> formattedList = new ArrayList<String>();
    for (int i = 0; i < keys.size(); i++) {
      switch (keys.getType(i)) {
        case String:
          formattedList.add(keys.getString(i));
          break;
      }
    }
    suprsendInstance.getUser().unSet(formattedList);
  }

  @ReactMethod
  public void reset() {
    getInstance();
    suprsendInstance.reset();
  }

  @ReactMethod
  public void setEmail(String email) {
    if (email == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().setEmail(email);
  }

  @ReactMethod
  public void unSetEmail(String email) {
    if (email == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().unSetEmail(email);
  }

  @ReactMethod
  public void setSms(String mobile) {
    if (mobile == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().setSms(mobile);
  }

  @ReactMethod
  public void unSetSms(String mobile) {
    if (mobile == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().unSetEmail(mobile);
  }

  @ReactMethod
  public void setWhatsApp(String mobile) {
    if (mobile == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().setWhatsApp(mobile);
  }

  @ReactMethod
  public void unSetWhatsApp(String mobile) {
    if (mobile == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().unSetWhatsApp(mobile);
  }

  @ReactMethod
  public void setAndroidFcmPush(String token) {
    if (token == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().setAndroidFcmPush(token);
  }

  @ReactMethod
  public void unSetAndroidFcmPush(String token) {
    if (token == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().unSetAndroidFcmPush(token);
  }

  @ReactMethod
  public void setAndroidXiaomiPush(String token) {
    if (token == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().setAndroidXiaomiPush(token);
  }

  @ReactMethod
  public void unSetAndroidXiaomiPush(String token) {
    if (token == null) {
      return;
    }
    getInstance();
    suprsendInstance.getUser().unSetAndroidXiaomiPush(token);
  }

  @ReactMethod
  public void track(String eventName, ReadableMap properties) {
    getInstance();
    JSONObject formattedProperties = convertMapToJson(properties);
    suprsendInstance.track(eventName, formattedProperties);
  }

  @ReactMethod
  public void setSuperProperties(ReadableMap properties) {
    if (properties == null) {
      return;
    }
    getInstance();
    JSONObject jsonData = convertMapToJson(properties);
    suprsendInstance.setSuperProperties(jsonData);
  }

  @ReactMethod
  public void unSetSuperProperty(String key) {
    if (key == null) {
      return;
    }
    getInstance();
    suprsendInstance.unSetSuperProperty(key);
  }

  @ReactMethod
  public void flush() {
    getInstance();
    suprsendInstance.flush();
  }

  @ReactMethod
  public void purchaseMade(ReadableMap properties) {
    if (properties == null) {
      return;
    }
    getInstance();
    JSONObject jsonData = convertMapToJson(properties);
    suprsendInstance.purchaseMade(jsonData);
  }

  @ReactMethod
  public void initXiaomi(String appId, String apiKey) {
    SSApi.Companion.initXiaomi(this.context, appId, apiKey);
  }

  @ReactMethod
  public void showNotification(String notificationJSONPayload) {
    SSNotificationHelper.INSTANCE.showSSNotification(this.context, notificationJSONPayload);
  }

  private static JSONObject convertMapToJson(ReadableMap readableMap) {
    if (readableMap == null) {
      return null;
    }
    JSONObject object = new JSONObject();
    ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
    while (iterator.hasNextKey()) {
      String key = iterator.nextKey();
      try {
        switch (readableMap.getType(key)) {
          case Null:
            object.put(key, JSONObject.NULL);
            break;
          case Boolean:
            object.put(key, readableMap.getBoolean(key));
            break;
          case Number:
            object.put(key, readableMap.getDouble(key));
            break;
          case String:
            object.put(key, readableMap.getString(key));
            break;
          case Map:
            object.put(key, convertMapToJson(readableMap.getMap(key)));
            break;
          case Array:
            object.put(key, convertArrayToJson(readableMap.getArray(key)));
            break;
        }
      } catch (Exception e) {
        Log.d("SS_ERROR", "error is " + e);
      }
    }
    return object;
  }

  private static JSONArray convertArrayToJson(ReadableArray readableArray) {
    if (readableArray == null) {
      return null;
    }
    JSONArray array = new JSONArray();
    for (int i = 0; i < readableArray.size(); i++) {
      try {
        switch (readableArray.getType(i)) {
          case Null:
            break;
          case Boolean:
            array.put(readableArray.getBoolean(i));
            break;
          case Number:
            array.put(readableArray.getDouble(i));
            break;
          case String:
            array.put(readableArray.getString(i));
            break;
          case Map:
            array.put(convertMapToJson(readableArray.getMap(i)));
            break;
          case Array:
            array.put(convertArrayToJson(readableArray.getArray(i)));
            break;
        }
      } catch (Exception e) {
        Log.d("SS_ERROR", "error is " + e);
      }
    }
    return array;
  }
}
