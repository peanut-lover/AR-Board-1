//
//  ARBSignInViewController.swift
//  ARBoard
//
//  Created by 최유태 on 2017. 3. 22..
//  Copyright © 2017년 YutaeChoi. All rights reserved.
//

import UIKit
import FBSDKLoginKit
class ARBSignInViewController: UIViewController {
    let dataManager:ARBDataManager = ARBDataManager.getInstance()
    @IBOutlet weak var facebookLoginButton: FBSDKLoginButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.facebookLoginButton.delegate = self
        self.facebookLoginButton.readPermissions = ["public_profile", "email"]
        
        // Do any additional setup after loading the view.
    }
}

// MARK:- Facebook Login SDK
extension ARBSignInViewController: FBSDKLoginButtonDelegate {
    // 페이스북으로 로그인
    func loginButton(_ loginButton: FBSDKLoginButton!, didCompleteWith result: FBSDKLoginManagerLoginResult!, error: Error!) {
        guard error == nil, let accessToken = FBSDKAccessToken.current(), let accessTokenString = accessToken.tokenString else {
            dump(error)
            return
        }
        dump(accessTokenString)
        dataManager.authRequest(self, domain: OAuthDomain.facebook, token: accessTokenString) { (isSuccess) in
            if isSuccess {
                DispatchQueue.main.async {
                   self.dismiss(animated: true, completion: nil)
                }
            }
        }
    }
    // 로그아웃
    func loginButtonDidLogOut(_ loginButton: FBSDKLoginButton!) {
        dump("facebook LogOut")
        self.dataManager.deleteRequest(RequestType.logout, completion: nil)
    }
}
