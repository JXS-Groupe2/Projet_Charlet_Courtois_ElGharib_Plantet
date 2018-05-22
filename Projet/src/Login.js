"use strict";
exports.__esModule = true;
var User = /** @class */ (function () {
    function User(id, password) {
        this.id = id;
        this.password = password;
    }
    User.prototype.checkPasswd = function (pass) {
        return (pass == this.password);
    };
    return User;
}());
exports.User = User;
var Login = /** @class */ (function () {
    function Login() {
    }
    Login.prototype.addUser = function (id, password) {
        this.users.push(new User(id, password));
    };
    Login.prototype.login = function (id, password) {
        var i = 0;
        for (; i < this.users.length;) {
            ++i;
            if (this.users[i].id == id) {
                if (this.users[i].checkPasswd(password)) {
                    console.log("connexion succeeded");
                }
                else {
                    console.log("Connexion error");
                }
            }
        }
    };
    return Login;
}());
exports.Login = Login;
