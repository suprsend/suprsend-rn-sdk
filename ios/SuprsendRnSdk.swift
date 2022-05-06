import Foundation
import SuprSendSdk;

@objc(SuprsendRnSdk)
class SuprsendRnSdk:NSObject{
    
    @objc
    func identify(_ identity: String) -> Void {
        SuprSend.shared.identify(identity: identity);
    }
    
    @objc
    func reset() -> Void {
        SuprSend.shared.reset();
    }
    
    @objc
    func track(_ eventName:String, properties: [String: Any]? = nil) -> Void {
        SuprSend.shared.track(eventName: eventName, properties: properties!)
    }
    
    @objc
    func setSuperProperties(_ properties:[String: Any]) -> Void {
        SuprSend.shared.setSuperProperties(properties: properties);
    }
    
    @objc
    func unSetSuperProperty(_ key:String) -> Void {
        SuprSend.shared.unSetSuperProperty(key: key);
    }
    
    @objc
    func purchaseMade(_ properties:[String: Any]) -> Void {
        SuprSend.shared.purchaseMade(properties: properties);
    }
    
    @objc
    func flush() -> Void {
        SuprSend.shared.flush();
    }
    
    @objc
    func enableLogging() -> Void {
        SuprSend.shared.enableLogging();
    }
    
//    user methods
    
    @objc
    func set(_ properties:[String: Any]) -> Void {
        SuprSend.shared.set(properties: properties);
    }
    
    @objc
    func setOnce(_ properties:[String: Any]) -> Void {
        SuprSend.shared.setOnce(properties: properties);
    }
    
    @objc
    func append(_ properties:[String: Any]) -> Void {
        for (key, value) in properties{
            SuprSend.shared.append(key: key, value: value);
        }
    }
    
    @objc
    func remove(_ properties:[String: Any]) -> Void {
        for (key, value) in properties{
            SuprSend.shared.remove(key: key, value: value);
        }
    }
    
    @objc
    func unSet(_ properties:[String]) -> Void {
        SuprSend.shared.unSet(keys: properties);
    }
    
//    user channel methods
    
    @objc
    func setEmail(_ emailId:String) -> Void {
        SuprSend.shared.setEmail(emailId: emailId);
    }
    
    @objc
    func unSetEmail(_ emailId:String) -> Void {
        SuprSend.shared.unSetEmail(emailId: emailId);
    }
    
    @objc
    func setSms(_ mobileNumber:String) -> Void {
        SuprSend.shared.setSms(mobileNumber: mobileNumber);
    }
    
    @objc
    func unSetSms(_ mobileNumber:String) -> Void {
        SuprSend.shared.unSetSms(mobileNumber: mobileNumber);
    }
    
    @objc
    func setWhatsApp(_ mobileNumber:String) -> Void {
        SuprSend.shared.setWhatsApp(mobileNumber: mobileNumber);
    }
    
    @objc
    func unSetWhatsApp(_ mobileNumber:String) -> Void {
        SuprSend.shared.unSetWhatsApp(mobileNumber: mobileNumber);
    }
}
