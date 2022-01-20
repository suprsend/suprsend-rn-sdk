package com.suprsendrnsdk;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import app.suprsend.SSApi;
import app.suprsend.base.LogLevel;


@ReactModule(name = SuprsendRnSdkModule.NAME)
public class SuprsendRnSdkModule extends ReactContextBaseJavaModule {
    public static final String NAME = "SuprsendRnSdk";
    private final ReactApplicationContext context;
    private SSApi suprsendInstance;
    private String apiKey, apiSecret, apiBaseUrl;

    public SuprsendRnSdkModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    private void getInstance(){
        if(suprsendInstance==null){
          suprsendInstance = SSApi.Companion.getInstance(apiKey, apiSecret, apiBaseUrl);
          suprsendInstance.setLogLevel(LogLevel.VERBOSE);
        }
    }

    @ReactMethod
    public void initializeSDK(String workspaceKey, String workspaceSecret, String apiUrl){
      apiKey = workspaceKey;
      apiSecret = workspaceSecret;
      apiBaseUrl = apiUrl;
    }

    @ReactMethod
    public void identify(String uniqueId) {
        getInstance();
        suprsendInstance.identify(uniqueId);
    }

    @ReactMethod
    public void reset() {
      getInstance();
      suprsendInstance.reset();
    }
}
