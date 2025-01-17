//
//  AppDelegate.swift
//  ARBoard
//
//  Created by 최유태 on 2017. 3. 18..
//  Copyright © 2017년 YutaeChoi. All rights reserved.
//

import UIKit
import FBSDKCoreKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?
    let facebookDelegate:FBSDKApplicationDelegate = FBSDKApplicationDelegate.sharedInstance()

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
        setupColorsUIKitAppearance()
        facebookDelegate.application(application, didFinishLaunchingWithOptions: launchOptions)
        return true
    }
    private func setupColorsUIKitAppearance(){
        let navigationBarAppearance:UINavigationBar = UINavigationBar.appearance()
        navigationBarAppearance.tintColor = UIColor.white
        navigationBarAppearance.barTintColor = UIColor.barTintColor
        
        let navigationBarFont = UIFont.init(name: "GodoB", size: 18.0)
        if let navigationBarFont = navigationBarFont {
            navigationBarAppearance.titleTextAttributes = [
                NSForegroundColorAttributeName : UIColor.white,
                NSFontAttributeName : navigationBarFont]
        }
        let tabBarAppearance:UITabBar = UITabBar.appearance()
        tabBarAppearance.tintColor = UIColor.red
        tabBarAppearance.barTintColor = UIColor.barTintColor
        tabBarAppearance.tintColor = UIColor.redTintColor
        
        let toolBarAppearance:UIToolbar = UIToolbar.appearance()
        toolBarAppearance.barTintColor = UIColor.barTintColor
        toolBarAppearance.tintColor = UIColor.white
        
        let application:UIApplication = UIApplication.shared
        application.statusBarStyle = .lightContent
    }
    func applicationWillResignActive(_ application: UIApplication) {
        // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
        // Use this method to pause ongoing tasks, disable timers, and invalidate graphics rendering callbacks. Games should use this method to pause the game.
    }

    func applicationDidEnterBackground(_ application: UIApplication) {
        // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
        // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
    }

    func applicationWillEnterForeground(_ application: UIApplication) {
        // Called as part of the transition from the background to the active state; here you can undo many of the changes made on entering the background.
    }

    func applicationDidBecomeActive(_ application: UIApplication) {
        FBSDKAppEvents.activateApp()
        // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
    }

    func applicationWillTerminate(_ application: UIApplication) {
        // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
    }
    
    func application(_ application: UIApplication, open url: URL, sourceApplication: String?, annotation: Any) -> Bool {
        return facebookDelegate.application(application, open: url, sourceApplication: sourceApplication, annotation: annotation)
    }

}

