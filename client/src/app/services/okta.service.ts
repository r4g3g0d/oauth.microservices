import { Injectable } from '@angular/core';
import * as OktaSignIn from '@okta/okta-signin-widget';

@Injectable()
export class OktaService {
  widget;

  constructor() {
    this.widget = new OktaSignIn({
      baseUrl: 'https://dev-451998.oktapreview.com',
      clientId: '0oaf5i9qj7KcHOHVX0h7',
      authParams: {
        issuer: 'default',
        responseType: ['id_token', 'token'],
        scopes: ['openid', 'email', 'profile']
      }
    });
  }

  getWidget() {
    return this.widget;
  }

  getIdToken() {
    return this.widget.tokenManager.get('idToken');
  }

  getAccessToken() {
    return this.widget.tokenManager.get('accessToken');
  }

}
