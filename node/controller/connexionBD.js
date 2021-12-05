const mysql = require('mysql');
//connecion a la base
var connection = mysql.createConnection({ 
    host     : 'localhost',
    user     : 'root', 
    password : 'root',
    database : 'corona'}); 
connection.connect(function(err) {
  if (err) throw err;
  console.log("Connecté à la base de données MySQL!");
  });
  module.exports = connection;