"use strict";
exports.__esModule = true;
var Login_1 = require("./Login");
console.log("fichier main");
var main = /** @class */ (function () {
    function main() {
        var _this = this;
        this.log = new Login_1.Login();
        this.btn = document.getElementById("loginButton");
        console.log("constructeur login");
        this.btn.addEventListener("click", function (e) { return _this.login(); });
        this.log.addUser("Jules", "pass123");
        this.log.addUser("Loic", "azerty");
    }
    main.prototype.login = function () {
        console.log("login function");
        var id = document.getElementById("inputEmail").value;
        var pass = document.getElementById("inputPassword").value;
        this.log.login(id, pass);
    };
    return main;
}());
exports.main = main;
new main();
