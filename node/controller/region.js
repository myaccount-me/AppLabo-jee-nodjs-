const connection = require('./connexionBD');
exports.GetallRegion= (req, res, next) => {
connection.query("select * from region", function (err, result) {
if (!err){
res.send(result);
}
else
console.log(err);
    });
}
