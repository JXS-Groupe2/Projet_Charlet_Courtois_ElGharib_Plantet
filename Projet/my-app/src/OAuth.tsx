
/*
export class OAuth{
    'use strict';

    const express = require('express');
    const simpleOauthModule = require('./../');

    const app = this.express();
    const oauth2 = this.simpleOauthModule.create({
    client: {
        id: '<CLIENT_ID>',
        secret: '<CLIENT_SECRET>',
    },
    auth: {
        tokenHost: 'https://github.com',
        tokenPath: '/login/oauth/access_token',
        authorizePath: '/login/oauth/authorize',
    },
    });

    // Authorization uri definition
    const authorizationUri = this.oauth2.authorizationCode.authorizeURL({
    redirect_uri: 'http://localhost:3000/callback',
    scope: 'notifications',
    state: '3(#0/!~',
    });

    // Initial page redirecting to Github
    app.get('/auth', (req, res) => {
    console.log(this.authorizationUri);
    res.redirect(this.authorizationUri);
    });

    // Callback service parsing the authorization token and asking for the access token
    app.get('/callback', async (req, res) => {
    const code = req.query.code;
    const options = {
        code,
    };

    try {
        const result = await this.oauth2.authorizationCode.getToken(options);

        console.log('The resulting token: ', result);

        const token = this.oauth2.accessToken.create(result);

        return res.status(200).json(token)
    } catch(error) {
        console.error('Access Token Error', error.message);
        return res.status(500).json('Authentication failed');
    }
    });

    app.get('/success', (req, res) => {
    res.send('');
    });

    app.get('/', (req, res) => {
    res.send('Hello<br><a href="/auth">Log in with Github</a>');
    });

    app.listen(3000, () => {
    console.log('Express server started on port 3000');
    });


}*/