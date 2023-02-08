#import <Foundation/Foundation.h>
#import "React/RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(SuprsendRnSdk, NSObject);

RCT_EXTERN_METHOD(identify:(NSString *)uniqueId)

RCT_EXTERN_METHOD(reset:(BOOL *)unsubscribeNotification)

RCT_EXTERN_METHOD(track:(NSString *)eventName properties:(NSDictionary *)properties)

RCT_EXTERN_METHOD(setSuperProperties:(NSDictionary *)properties)

RCT_EXTERN_METHOD(unSetSuperProperty:(NSString *)key)

RCT_EXTERN_METHOD(purchaseMade:(NSDictionary *)properties)

RCT_EXTERN_METHOD(flush)

RCT_EXTERN_METHOD(enableLogging)

RCT_EXTERN_METHOD(set:(NSDictionary *)properties)

RCT_EXTERN_METHOD(setOnce:(NSDictionary *)properties)

RCT_EXTERN_METHOD(append:(NSDictionary *)properties)

RCT_EXTERN_METHOD(remove:(NSDictionary *)properties)

RCT_EXTERN_METHOD(unSet:(NSArray *)properties)

RCT_EXTERN_METHOD(setEmail:(NSString *)emailId)

RCT_EXTERN_METHOD(unSetEmail:(NSString *)emailId)

RCT_EXTERN_METHOD(setSms:(NSString *)mobileNumber)

RCT_EXTERN_METHOD(unSetSms:(NSString *)mobileNumber)

RCT_EXTERN_METHOD(setWhatsApp:(NSString *)mobileNumber)

RCT_EXTERN_METHOD(unSetWhatsApp:(NSString *)mobileNumber)

@end
