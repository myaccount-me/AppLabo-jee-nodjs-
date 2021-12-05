const connection = require('./connexionBD');
exports.LogLabo= (request, res, next) => {
    let req= request.query;
    let query = "SELECT * FROM labo WHERE login = ? and mdp = ?";
    console.log(req.body);
    let params = [req.login,req.mdp];
    console.log(params);
   
    connection.query(query,params,function (err, result) {
    if (!err)
    res.send(result);
    else
    console.log(err);
        });
    }
// exports.LogAdmin= (request, res, next) => {
//     let req= request.query;
//     let query = "SELECT * FROM admin WHERE login = ? and mdp = ?";
//     let params = [req.login,req.mdp];
//     console.log(params);
//    connection.query(query,params,function (err, result) {
// if (!err)
// res.send(result);
// else
// console.log(err);
//     });
// }
