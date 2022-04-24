import Foundation
import Mixpanel;

@objc(SuprsendRnSdk)
class SuprsendRnSdk:NSObject{
    private var count = 0;
  
    @objc
    func increment(){
      count+=1;
      print(count);
    }
    
//    @objc
//    func identify(_ uniqueId:String) -> Void {
//        SuprSendSdk.SuprSend.shared.identify(identity:uniqueId);
//    }
}
