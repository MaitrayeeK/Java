/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function ajaxCall(url, method, data, destination) {
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById(destination).innerHTML = this.responseText;
    }
  xhttp.open(method, url, true);
  xhttp.send(data);
}

function homeLoader() {
    ajaxCall('home.fin?cmdAction=loadHome','GET', '', 'ajax');
}

function home() {
    ajaxCall('home.fin?cmdAction=loadHomePage','GET', '', 'ajax');
}

function NoBrainerLoader() {
    ajaxCall('home.fin?cmdAction=loadNoBrainer','GET', '', 'ajax');
}

function OnlyBrainyLoader() {
    ajaxCall('home.fin?cmdAction=loadOnlyBrainy','GET', '', 'ajax');
}

